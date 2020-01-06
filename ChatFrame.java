import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

public class ChatFrame implements WindowListener,ActionListener {


    private JFrame frame;
    private JLabel userNameLabel;
    private JSeparator userNameSeparator;
    private JLabel statusLabel;
    private JPanel onlinePanel;
    private ServerConnect serverConnect;
    private LoginPage loginPage;
    private String userEmail;
    private String userID;
    private ArrayList<JButton> onlineUserButton;
    private ArrayList onlineUser;
    private HashMap<String, String> onlineUserHashMap;
    private Scanner scanner;
    private HashMap<String,String> sendMessageFromTo;



    public ChatFrame()
    {
        this.frame = new JFrame(loginPage.getEmail());
        this.userNameLabel = new JLabel();
        this.userNameSeparator = new JSeparator();
        this.statusLabel = new JLabel();
        this.onlinePanel = new JPanel();
        this.onlineUserButton = new ArrayList<>();
        this.onlineUser = new ArrayList();
        this.loginPage = new LoginPage();
        this.scanner = new Scanner(System.in);
        sendMessageFromTo = new HashMap<>();
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

    }

    public void windowClosing(WindowEvent arg0) {      // This window listener is what sets the current user offline once the window is closed ( aka program termination)
        System.out.println("Closing" + loginPage.getEmail());
        ServerConnect serverConnect = new ServerConnect("online",loginPage.getEmail(),0); //offline status = 0 as third paramenter
        serverConnect.run(); // runs the serverconnect run() function which here is used to just sent that user offline in database.
        System.out.println("closing");
        frame.dispose();
        System.exit(0);
    }
    public void windowDeactivated(WindowEvent arg0) {

    }
    public void windowDeiconified(WindowEvent arg0) {

    }
    public void windowIconified(WindowEvent arg0) {

    }
    public void windowOpened(WindowEvent arg0) {

    }


    public void setUserName(String email)
    {
        userEmail = email;
    }

    public void setOnlineUserHashMap(HashMap<String, String> onlineUserHashMap) /* called in ServerConnect class which sets all the online users at that moment
                                                                                 this hashmap value is later added to JButton arraylist to show who are online at that moment
                                                                                 ----------------------------- SUBJECT TO CHANGE ------------------------------------------------
                                                                                 How to make it update in real time basis ?
                                                                                                                                    */
    {
        this.onlineUserHashMap = onlineUserHashMap;
    }

    public void run()
    {

        addInFrame(); //adds every component in frame

        serverConnect = new ServerConnect("online",loginPage.getEmail(),1); //this sets the current user
                                                                                // (obtained from loginpage.getEmail()(is a static variable)) to online status
        serverConnect.run(); //called to set user online
        onlineUserHashMap = serverConnect.getReadHashMap(); // get all online user at that moment.
                                                            //--------------------------- NOTE TO SELF:----------------------------------
                                                            // why did I write the same thing
                                                            // twice? Here and setOnlineUserHashMap does the same thing. Optimize it later on
        this.onlinePanel.setLayout(new BoxLayout(this.onlinePanel,BoxLayout.Y_AXIS));
        this.userID = onlineUserHashMap.get(loginPage.getEmail());

        //this.serverConnect = new ServerConnect("online",loginPage.getNameField(),1);
        //onlineUserHashMap.remove(loginPage.getEmail()); //removes the data once finding out who the user is ??

        for (String key : onlineUserHashMap.keySet()) {
           // System.out.println("Key = " + key);
        }

        //Iterating over values only
        for (String value : onlineUserHashMap.values()) {
           // System.out.println(loginPage.getEmail());
           // System.out.println("Value = " + value);
            if (value.equals(loginPage.getEmail()))             // dont add the current user as online to his/her own chatframe
            {
             //   System.out.println("self user");
            }else
            {
              //  System.out.println("okay");
                onlineUserButton.add(new JButton(value));       //add every other online people to JButton as currently online ones

            }
        }

        for(int i =0; i<onlineUserButton.size();i++)                //loop to add action listener to every online user button ( for sending messages on clicking them )
        {
            onlineUserButton.get(i).addActionListener(this); //adds action listener on button press
            onlineUserButton.get(i).setActionCommand(onlineUserButton.get(i).getName());    // the setAction command is set on the basis of the clicked username
            onlinePanel.add(onlineUserButton.get(i)); // adds all the online user button to panel.
        }
        frame.add(onlinePanel);
        addInFrame();
    }

    public void getUserName()
    {


    }
    public void showDialogueBox(String Sender, String receiver, String message)
    {
        JOptionPane.showMessageDialog(frame,message,"Message from"+Sender+"to"+receiver,JOptionPane.WARNING_MESSAGE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String sendMessageTo = e.getActionCommand(); // the getActionCommand is different as the setActionCommand is set by to whom it is clicked.
                                                    // Makes it easier to know to whom the message is to be sent
        sendMessageFromTo.put(loginPage.getEmail(),sendMessageTo); // initalizes the hashmap which is to be send to server by calling the serverconnect object and then the run() func

        System.out.println("Write message to" + sendMessageTo);
        String message = scanner.nextLine();                        // -----------------------SUBJECT TO CHANGE-------------------------
                                                                    //                    Add UI later on and not CLI
        // String message=JOptionPane.showInputDialog(this.frame,"Write message to "+sendMessageTo);
        //JOptionPane.showMessageDialog(this.frame,"Message Sent","Success",JOptionPane.WARNING_MESSAGE);

        serverConnect = new ServerConnect("message",sendMessageFromTo,message); //calling the serverconnect function for sending messages along with who sent to whom (by hashmap)
        serverConnect.run();

        // sendMessageFromTo.remove(loginPage.getEmail()); // why this ? limiting the size of hashmap hola ??? What am i doing here ?? ask for help!!
        //System.out.println("Comes till here? ");
        //serverConnect = (ServerConnect)

    }
}


