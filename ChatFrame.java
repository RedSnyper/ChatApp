import javax.swing.*;

public class ChatFrame extends Thread {

    private JFrame frame;
    private JLabel userNameLabel;
    private JSeparator userNameSeparator;
    private JLabel statusLabel;
    private JPanel userNamePanel;
    private ServerConnect serverConnect;
    private LoginPage loginPage;
    private String userEmail;

public ChatFrame()
{
    this.frame = new JFrame("ChatApp");
    this.userNameLabel = new JLabel();
    this.userNameSeparator = new JSeparator();
    this.statusLabel = new JLabel();
    this.userNamePanel = new JPanel();
    this.loginPage = new LoginPage();
    this.serverConnect = new ServerConnect("userName",loginPage.getNameField());

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
    System.out.println("Run");
    System.out.println(userEmail);
    serverConnect.setLoginEmail(userEmail);
    serverConnect.start();




}

public void getUserName()
{


}


}


