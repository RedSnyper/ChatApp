
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class ServerConnect implements Serializable {

    private String loginType; //either register or login
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
   // private MultithreadServer multithreadServer;
    private final int socketPort=6000;
    private HashMap<Integer,String> readHashMap;


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


    public HashMap<Integer, String> getReadHashMap() {
        return readHashMap;
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
    }

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

    public void run()
    {

        try {
            socket = new Socket("localhost", socketPort);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
          //  inputStream = socket.getInputStream();

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"US-ASCII"));
            writer = new PrintWriter(socket.getOutputStream(), true);

                if (getLoginType().equals("register")) // this is from the register panel. if the server sends register(after the suceess of storing the data that is, the register is done here)
                {
                    objectOutputStream.writeObject(new ServerConnect(loginType, userName, regEmailAddress, gender, password));
                    System.out.println("yo first");

                    String message = reader.readLine();

                    if (message.charAt(4) =='r') {
                            this.isRegistered = true;
                        } else {
                            this.sameEmail = true;

                    }

                } else if (getLoginType().equals("login")) { // this is for the login panel
                    isConnected = true;
                    objectOutputStream.writeObject(new ServerConnect(loginType, loginEmailAddress, loginPassword));
                    String message = reader.readLine();
                    System.out.println(message);

                        if (message.charAt(4)=='f') {
                            this.canLogin = true;

                        }else
                        {
                            this.canLogin=false;
                        }

                } else if (getLoginType().equals("online")) {
                    System.out.println("yo third");

                    objectOutputStream.writeObject(new ServerConnect(loginType, loginEmailAddress, onlineStatus));

                    System.out.println(loginEmailAddress);
                    if (socket == null) {
                        onlineStatus = 0;
                        System.out.println("Server null ? ");
                        objectOutputStream.writeObject(new ServerConnect("offline", loginEmailAddress, onlineStatus));
                    }
                    try {

                        objectInputStream = new ObjectInputStream((socket.getInputStream()));
                        readHashMap = (HashMap) objectInputStream.readObject();
                        ChatFrame chatFrame = new ChatFrame();
                        System.out.println(Arrays.asList(readHashMap));
                        chatFrame.setOnlineUserHashMap(readHashMap);
                        objectOutputStream.flush();
//                    } catch (ClassNotFoundException e) {
//                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }catch(ConnectException e)
            {

                isRegistered = false;
                canLogin = false;
            }catch(IOException e)
            {
                isConnected = false;
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

    }
}
