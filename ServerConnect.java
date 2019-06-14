import javax.crypto.interfaces.PBEKey;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnect extends Thread implements ActionListener {


    private String userName;
    private String regEmailAddress;
    private String gender;
    private char[] password;
    private String loginEmailAddress;
    private String loginPassword;
    private ServerSocket serverSocket;
    private Socket socket;


        //program to send the database to server
    public ServerConnect(String userName, String email, String gender, char[] password)
    {
        this.userName = userName;
        this.regEmailAddress = email;
        this.gender = gender;
        this.password = password;
    }

    public void run()
    {
        System.out.println(userName);
        System.out.println(regEmailAddress);
        System.out.println(gender);

        try{
            socket = new Socket("locahost",5000);




        }catch(IOException e)
        {
            System.out.println();
        }


    }




    @Override
    public void actionPerformed (ActionEvent e){


        }


}
