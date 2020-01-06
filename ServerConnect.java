
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class ServerConnect implements Serializable {

    private String loginType; //either register, login, online, message ( more detailed later down in comments )
    private String userName;
    private String regEmailAddress;
    private String gender;
    private char[] password;
    private String loginEmailAddress;
    private char[] loginPassword;
    private Socket socket;
    private boolean isRegistered;
    private boolean canLogin;
    private boolean isConnected;
    private boolean sameEmail;
    private int onlineStatus;
    private String message;
    private String msg;
    private String receiver;
    private String sender;
    private LoginPage loginPage;
    private final int socketPort=6000;
    private HashMap<String,String> readHashMap;                   // ----------------SUBJECT TO CHANGE----------------------
    private HashMap<String,String> sendMessagesHashMap;           //  used alot of data structure to do the same thing
    private HashMap<String,String> readReceivedMessage;           //NOTE TO SELF: Learn and think of ways to optimize this
    private HashMap<String,String> sendReceiver;

    private ObjectOutputStream objectOutputStream = null;
    private ObjectInputStream objectInputStream = null;
    private BufferedReader reader = null;
    private PrintWriter writer = null;
    public boolean isSameEmail() {
        return sameEmail;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public boolean isCanLogin() {
        return canLogin;
    }

    public boolean isRegistered() {
        return isRegistered;
    }


    public HashMap<String, String> getReadHashMap() {
        return readHashMap;
    }

    public String getMessage() {
        return message;
    }

    public HashMap<String, String> getSendMessagesHashMap() {
        return sendMessagesHashMap;
    }

    public ServerConnect(String loginType, HashMap sendMessagesHashMap, String messages)
    {
        this.loginType = loginType;
        this.sendMessagesHashMap = sendMessagesHashMap;
        this.message = messages;
    }

    public ServerConnect(String loginType,String userName, String email, String gender, char[] password) // for register purpose
    {
        this.loginType = loginType;
        this.userName = userName;
        this.regEmailAddress = email;
        this.gender = gender;
        this.password = password;
    }
    public ServerConnect(String loginType,String loginEmailAddress,char[] loginPassword) // for login purpose
    {
        this.loginType = loginType;
        this.loginEmailAddress = loginEmailAddress;
        this.loginPassword = loginPassword;
    }
    public ServerConnect(String loginType,String loginEmailAddress,int onlineStatus) // for getting username and messages(for main chatframe)
    {
        this.loginType = loginType;
        this.loginEmailAddress = loginEmailAddress;
        this.onlineStatus = onlineStatus;
    }

    public String getLoginType() {
        return loginType;
    } /*
                                                            This is like a message sent to server saying what to do. If loginType equals
                                                            1) login - execute login verification part
                                                            2) register - execute registering part
                                                            3) online - once logged in, receive online users info and send and receive message
                                                                -------------------SUBJECT TO CHANGE----------------------
                                                                    */

    public String getUserName() {
        return userName;
    }

    public String getRegEmailAddress() {
        return regEmailAddress;
    }

    public String getGender() {
        return gender;
    }

    public char[] getPassword() {
        return password;
    }

    public String getLoginEmailAddress() {
        return loginEmailAddress;
    }

    public char[] getLoginPassword() {
        return loginPassword;
    }

    public void setLoginEmail(String email)
    {
        this.loginEmailAddress = email;
    }

    public int getOnlineStatus() {
        return onlineStatus;
    }

    public String getMsg() {
        return msg;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }

    public void run()
                        /* This function is called multiple times by
                            RegisterPage - to send register data to server.
                            LoginPage - to send login data to server.
                            Chatframe - to send and receive messages and send data to set that user online in database.
                                        Also works to set the current user offline once the application is closed.
                         */
    {

        try {
            socket = new Socket("localhost", socketPort); /*

            creating a communication mechanism to connect to server. NOTE TO SELF: Maybe this entire try block can be written in constructor ?
            ---------------------------(SUBJECT TO CHANGE)-------------------------------

            --------------------------NOTE TO SELF-------------------------------
            ASK FOR ADVICE ON HOW TO SEND DATA OVER A NETWORK VIA ROUTER.
            ASK IF INET ADDRESS IS NEEDED. ALSO ASK HOW TO UPDATE CHATFRAME IN REAL TIME
            ONCE MESSAGES ARE RECEIVED
                                                                        */
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream()); //send objects to where the sockets is linked at ( here localhost. TO SELF: CHANGE IF INETADDRESS IS USED )
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"US-ASCII")); //reads messages received from server
            writer = new PrintWriter(socket.getOutputStream(), true); //writes messages to server


            /*

            Below written getLoginType acts like a message to do certain tasks.
            This getLoginType is set in ChatFrame, RegisterPage,LoginPage by creating serverConnect object there respectively.
            The objects created there calls the run function and hence which object is to do what is known.
             */


            if (getLoginType().equals("register")) /* This is from the register panel. The getLoginType is initialized in RegisterPage class under if success
                                                    ServerConnect serverConnect = new ServerConnect("register", regUsername, regEmail, regGender, password);
                                                                                                                                                */
{
                objectOutputStream.writeObject(new ServerConnect(loginType, userName, regEmailAddress, gender, password)); /*  sends data to server uses serialization interface provided java.
                                                                                                                                Refer to CHATAPPSERVER Project to continue to understand program
                                                                                                                                flow.
                                                                                                                                            */
                    /* once data to be registered is sent to server, the server registers in database.
                       If the registration was success. A message "registered" is sent from client to server.  I
                                                                                */

                String message = reader.readLine();  //this reads the message sent

                if (message.charAt(4) =='r')    // if the message is "registered" set the flag isRegistered true. The flag isRegistered is whether to run LoginPage again or not

                    /* ----------------------------------------NOTE TO SELF----------------------------------------------------
                    Ask why the message reads '??registered' and not just 'registered' , what is with the  '??l_l' encoded letters attached to the message. Takes up 4 characters
                                                                                                                    */
                {

                    this.isRegistered = true;
                } else {
                    this.sameEmail = true; /* if user is not registered, its only due to email clash as every other field verification is done on RegisterPage already.
                                             So this flag sets up same email tab which is later looked by object of RegisterPage class on whether to throw same-email error
                                             dialogue box or not */
                }

            } else if (getLoginType().equals("login")) { // this is for the login panel
                isConnected = true;                      // flag to see if the client is connected to server or not. This is done true and exception were to be thrown above if not connected.
                objectOutputStream.writeObject(new ServerConnect(loginType, loginEmailAddress, loginPassword)); // sends login details to server using object serialization.
                //A message 'found' is to be expected if the server finds the login record
                String message = reader.readLine(); // reads what message is sent by the server

                if (message.charAt(4)=='f') // checking if message was found or not. Again character comparision cause of weird encoded 4 characters attached along with 'found' message
                {
                    this.canLogin = true; //later used in LoginPage to say login successful and then forward to ChatFrame frame.
                }else
                {
                    this.canLogin=false; // later used in LoginPage to throw 'Email or password does not match' error message.
                }

            } else if (getLoginType().equals("online")) /*This is set by ChatFrame. Works to
                                                        1. Pass flag(1) to server to make the user online in database
                                                        2. Read all the online users at the moment sent by server
                                                     --------------------------------------NOTE TO SELF--------------------------------------------
                                                        Ask how to make the online user known in real time basis
                                                        3. Also to make user offline if the users closes the window(pass 0). A window listener is added in ChatFrame which calls
                                                        this run function with online status as 0.
                                                       */
            {

                objectOutputStream.writeObject(new ServerConnect(loginType, loginEmailAddress, onlineStatus)); //making the particular user online

                System.out.println(loginEmailAddress);


                if (socket == null) {
                    /* ----------------SUBJECT TO CHANGE-------------------------
                        Wanted to make the user offline if ChatFrame connection to server is broken. Ask if this is the correct approach or not.
                     */
                    onlineStatus = 0;
                    System.out.println("Server null ? ");
                    objectOutputStream.writeObject(new ServerConnect("offline", loginEmailAddress, onlineStatus));
                }
                try {

                    objectInputStream = new ObjectInputStream((socket.getInputStream()));
                    readHashMap = (HashMap) objectInputStream.readObject(); /*
                                                                               get all online user record at the moment
                                                                               recordHasMap contains
                                                                               key = who the online uses are (in terms of unique email address)
                                                                               value = name of users

                                                                                */
                    ChatFrame chatFrame = new ChatFrame();
                    System.out.println("Reading all online users (sent from server)\n");
                    System.out.println(Arrays.asList(readHashMap)); //displaying all online users.
                    System.out.println("\n");
                    chatFrame.setOnlineUserHashMap(readHashMap); //passes the online user data to chatFrame. This function is used to set online users as JButtons in chatFrame.
                    objectOutputStream.flush();
                    objectInputStream.close();
//                    } catch (ClassNotFoundException e) {
//                        System.out.println(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(getLoginType().equals("message")) //works to send and receive message

                /*-----------------------------------------------------------------------
                ------------------------ SUBJECT TO HEAVY CHANGE------------------------
                -------------------------------------------------------------------------
                1) How to forward messages sent to only that particular user?
                2) How to update messages in real time?
                3) Note to self: Used alot of hashmap as data structure for mostly one time use. Optimize it later on.
                ------------------------------------------------------------------------
                 ---------------------------------------------------------------------
                 --------------------------------------------------------------------------*/
            {
                loginPage = new LoginPage();
                objectOutputStream.writeObject(new ServerConnect(loginType, sendMessagesHashMap, message)); /*send message
                                                                                                             sendMessagesHashMap contains
                                                                                                             key = current user email id
                                                                                                             value = email address of whom the current user is sending message to
                                                                                                            */
                System.out.println("Message sent!! ");
                objectInputStream = new ObjectInputStream((socket.getInputStream()));
                sendReceiver = (HashMap) objectInputStream.readObject(); // receives message from sever in a hashmap data structure.

                System.out.println(Arrays.asList(sendReceiver));
                for(String values:sendReceiver.values()) // analysing the sendReceiver data structure to see who sent to whom .
                {
                    receiver = values; // sets  to whom the message was sent to
                }
                for(String values:sendReceiver.keySet())
                {
                    sender = values; // sets who sent the message to receiver
                }
                msg = reader.readLine(); //reads the message from server. Note to self : if many user send the message how to direct what message was sent to whom. Figure it out.
                if(msg!=null){
                   // if(loginPage.getEmail().equals(sender))               //for dialogue box thing. Later use this to update message in chatframe maybe{
                        // ChatFrame chatFrame = new ChatFrame();
                        //chatFrame.showDialogueBox(sender,receiver,message);
                        System.out.println("MESSAGE INFO:\n\tSent From =" + sender + "\n\tSent To =" + receiver + "\n\tmessage ="+message);
                        System.out.println("Received from server");
                  //  }
                }
            }
        }catch(ConnectException e)
        {
            isRegistered = false; // if connection error set isRegistered to false essentially throwing cant connect to server message
            canLogin = false;   // if connection error set canLogin to false essentially throwing server offline message
        }catch(IOException e)
        {
            isConnected = false;
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
