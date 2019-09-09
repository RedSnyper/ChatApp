
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;


public class ServerConnect extends Thread implements Serializable {

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
    public ServerConnect(String loginType,String loginEmailAddress) // for getting username and messages(for main chatframe)
    {
        this.loginType = loginType;
        this.loginEmailAddress = loginEmailAddress;
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

    public void run()
    {
        ObjectOutputStream objectOutputStream = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        try{
            socket = new Socket("localhost",5000);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);
            if(getLoginType().equals("register")) // this is from the register panel. if the server sends register(after the suceess of storing the data that is, the register is done here)
            {
                objectOutputStream.writeObject(new ServerConnect(loginType, userName, regEmailAddress, gender, password));
                String message = reader.readLine();
                if(message.equals("registered"))
                {
                    this.isRegistered = true;
                }else
                {
                    this.sameEmail = true;
                }
            }else if(getLoginType().equals("login")){ // this is for the login panel
                isConnected = true;
                objectOutputStream.writeObject(new ServerConnect(loginType,loginEmailAddress,loginPassword));
                String message = reader.readLine();
                if(message.equals("found"))
                {
                    this.canLogin = true;

                }
            }else if(getLoginType().equals("userName"))
            {
                objectOutputStream.writeObject(new ServerConnect(loginType,loginEmailAddress));
                System.out.println(loginEmailAddress);

            }
        }catch(ConnectException e)
        {

            isRegistered = false;
            canLogin = false;
        }catch(IOException e)
        {
            isConnected =false;
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
