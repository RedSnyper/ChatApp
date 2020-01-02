import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChatFrame implements WindowListener {


    private JFrame frame;
    private JLabel userNameLabel;
    private JSeparator userNameSeparator;
    private JLabel statusLabel;
    private JPanel userNamePanel;
    private ServerConnect serverConnect;
    private LoginPage loginPage;
    private String userEmail;
    private int userID;
    private ArrayList<JButton> onlineUserButton;
    private ArrayList onlineUser;
    private HashMap<Integer, String> onlineUserHashMap;



public ChatFrame()
{
    this.frame = new JFrame("ChatApp");
    this.userNameLabel = new JLabel();
    this.userNameSeparator = new JSeparator();
    this.statusLabel = new JLabel();
    this.userNamePanel = new JPanel();
    this.onlineUserButton = new ArrayList<>();
    this.onlineUser = new ArrayList();
    this.loginPage = new LoginPage();
}

public void addInFrame()
{
    frame.setSize(1000,900);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.addWindowListener(this);
   // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

        @Override
        public void windowClosed(WindowEvent e) {

        }
    public void windowActivated(WindowEvent arg0) {
        System.out.println("activated");
    }

    public void windowClosing(WindowEvent arg0) {// this is the place where you need to close the application hai!!!
        System.out.println("Closgin" + loginPage.getEmail());
        ServerConnect serverConnect = new ServerConnect("online",loginPage.getEmail(),0);
        serverConnect.run();
        System.out.println("closing");
        frame.dispose();
        System.exit(0);
    }
    public void windowDeactivated(WindowEvent arg0) {
        System.out.println("deactivated");
    }
    public void windowDeiconified(WindowEvent arg0) {
        System.out.println("deiconified");
    }
    public void windowIconified(WindowEvent arg0) {
        System.out.println("iconified");
    }
    public void windowOpened(WindowEvent arg0) {
        System.out.println("opened");
    }


    public void setUserName(String email)
{
    userEmail = email;
}

    public void setOnlineUserHashMap(HashMap<Integer, String> onlineUserHashMap) {
        this.onlineUserHashMap = onlineUserHashMap;
    }

    public void run()
{

    addInFrame();
    System.out.println("Run wwale" + loginPage.getEmail());
    serverConnect = new ServerConnect("online",loginPage.getEmail(),1);
    System.out.println("Hi");
    serverConnect.run();
    onlineUserHashMap = serverConnect.getReadHashMap();

    //this.serverConnect = new ServerConnect("online",loginPage.getNameField(),1);

    System.out.println("asdsadeafe" + Arrays.asList(onlineUserHashMap));
    for (Integer key : onlineUserHashMap.keySet()) {
        System.out.println("Key = " + key);
    }

// Iterating over values only
    for (String value : onlineUserHashMap.values()) {
        System.out.println("Value = " + value);
    }







}

public void getUserName()
{


}


}


