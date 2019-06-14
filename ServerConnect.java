
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerConnect extends Thread implements ActionListener {

    private String loginType; //either register or login
    private String userName;
    private String regEmailAddress;
    private String gender;
    private char[] password;
    private String loginEmailAddress;
    private char[] loginPassword;
    private Socket socket;


        //program to send the database to server
    public ServerConnect(String loginType,String userName, String email, String gender, char[] password)
    {
        this.loginType = loginType;
        this.userName = userName;
        this.regEmailAddress = email;
        this.gender = gender;
        this.password = password;
    }
    public ServerConnect(String loginType,String loginEmailAddress,char[] loginPassword)
    {
        this.loginType = loginType;
        this.loginEmailAddress = loginEmailAddress;
        this.loginPassword = loginPassword;
    }
    public void run()
    {
        System.out.println(userName);
        System.out.println(regEmailAddress);
        System.out.println(gender);
        ObjectOutputStream objectOutputStream = null;
        try{
            socket = new Socket("locahost",5000);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            if(loginType.equals("register")) {
                objectOutputStream.writeObject(new ServerConnect(loginType, userName, regEmailAddress, gender, password));
            }else{
                objectOutputStream.writeObject(new ServerConnect(loginType,loginEmailAddress,loginPassword));
            }
        }catch(IOException e)
        {
            System.out.println();
        }


    }

    @Override
    public void actionPerformed (ActionEvent e){


        }


}
