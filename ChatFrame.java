import javax.swing.*;
import java.util.ArrayList;

public class ChatFrame {

    private JFrame frame;
    private JLabel userNameLabel;
    private JSeparator userNameSeparator;
    private JLabel statusLabel;
    private JPanel userNamePanel;
    private ServerConnect serverConnect;
    private LoginPage loginPage;
    private String userEmail;
    private ArrayList<JButton> onlineUserButton;
    private ArrayList onlineUser;


public ChatFrame()
{
    this.frame = new JFrame("ChatApp");
    this.userNameLabel = new JLabel();
    this.userNameSeparator = new JSeparator();
    this.statusLabel = new JLabel();
    this.userNamePanel = new JPanel();
    this.loginPage = new LoginPage();
    this.serverConnect = new ServerConnect("online",loginPage.getNameField(),1);
    this.onlineUserButton = new ArrayList<>();
    this.onlineUser = new ArrayList();
}

public void addInFrame()
{
    frame.setSize(1000,900);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);
}
//public void

public void setUserName(String email)
{
    userEmail = email;
}

public void run()
{
    addInFrame();
    serverConnect.run();




}

public void getUserName()
{


}


}


