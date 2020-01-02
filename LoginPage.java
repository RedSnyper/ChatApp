import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {
    private static final int width = 400;
    private static final int height = 600;
    private  boolean resizable = true;

    public static String getEmail() {
        return email;
    }

    private static  String email;
    private String userEmail;
    private JLabel loginMessageLabel;
    private JPanel loginDisplayPanel;
    private JPanel loginPanel;
    private JPanel namePanel;
    private JPanel passwordPanel;
    private JPanel submitPanel;
    private JButton submitButton;
    private JPanel errorPanel;
    private JLabel errorLabel;
    private JPanel registerPanel;
    private JLabel registerLabel;
    private JPanel registerLabelPanel;
    private JPanel registerButtonPanel;
    private JButton registerButton;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JPanel mainPanel;
    private JFrame frame;

    public LoginPage()
    {
        this.loginMessageLabel = new JLabel();
        this.loginDisplayPanel= new JPanel();
        this.loginPanel = new JPanel();
        this.namePanel = new JPanel();
        this.passwordPanel = new JPanel();
        this.submitPanel = new JPanel();
        this.submitButton = new JButton("Submit");
        this.errorLabel = new JLabel();
        this.errorPanel = new JPanel();
        this.registerPanel = new JPanel();
        this.registerLabel = new JLabel();
        this.registerLabelPanel = new JPanel();
        this.registerButtonPanel = new JPanel();
        this.registerButton = new JButton("Register");
        this.nameLabel = new JLabel("E-mail:");
        this.passwordLabel = new JLabel();
        this.nameField = new JTextField(20);
        this.passwordField  = new JPasswordField(13);
        this.mainPanel = new JPanel();
        this.frame = new JFrame("Login");
    }

    public JPanel setLoginPanel() //add name, password, submit and error message to a panel called loginpanel and returns this panel
    {
        this.namePanel.setLayout(new FlowLayout());
        this.nameField.setPreferredSize(new Dimension(30,28));
        this.nameField.setActionCommand("name");
        this.nameField.addActionListener(this);
        this.namePanel.add(this.nameLabel);
        this.namePanel.add(this.nameField);

        this.passwordPanel.setLayout(new FlowLayout());
        this.passwordLabel.setText("Password:");
        this.passwordField.setActionCommand("loginPassword");
        this.passwordField.addActionListener(this);
        this.passwordPanel.add(this.passwordLabel);
        this.passwordPanel.add(this.passwordField);

        this.submitButton.setActionCommand("submit");
        this.submitButton.addActionListener(this);
        this.submitPanel.add(this.submitButton);

        this.errorPanel.add(this.errorLabel); // just to show error message

        this.loginPanel.setLayout(new BoxLayout(this.loginPanel,BoxLayout.Y_AXIS));
        this.loginPanel.add(Box.createVerticalStrut(70));
        this.loginMessageLabel.setFont(new Font("", Font.BOLD,30));
        this.loginMessageLabel.setText("LOGIN");
        this.loginDisplayPanel.add(this.loginMessageLabel);
        this.loginPanel.add(loginDisplayPanel);
        this.loginPanel.add(this.namePanel);
        this.loginPanel.add(Box.createVerticalStrut(20));
        this.loginPanel.add(this.passwordPanel);
        this.loginPanel.add(Box.createVerticalStrut(20));
        this.loginPanel.add(this.submitPanel);
        this.loginPanel.add(Box.createVerticalStrut(20));
        this.loginPanel.add(this.errorPanel);
        this.errorPanel.setVisible(false);
        return this.loginPanel;
    }



    public JPanel setRegisterPanel() // add reigster label and the register button to new panel called registerpanel and returns this
    {
        JSeparator separator = new JSeparator();
        this.registerLabelPanel.setLayout(new FlowLayout());
        this.registerPanel.add(Box.createVerticalStrut(60));
        this.registerPanel.add(separator);
        String message = "New Member? Register";
        Font font = new Font("Times New Roman",Font.PLAIN,20);
        this.registerLabel.setFont(font);
        this.registerLabel.setText(message);
        this.registerButtonPanel.setLayout(new FlowLayout());
        this.registerButton.setActionCommand("register");
        this.registerButton.addActionListener(this); // passing the event, the register button click wale to the frame class.
        this.registerPanel.setLayout(new BoxLayout(this.registerPanel,BoxLayout.Y_AXIS));
        registerPanel.add(Box.createVerticalStrut(30));
        this.registerPanel.add(this.registerLabel);
        this.registerPanel.add(Box.createVerticalStrut(30));
        this.registerPanel.add(this.registerButton);
        return this.registerPanel;
    }


    public JPanel setMainPanel() /* this makes a mainPanel, adds the mathi ko two panels
                                   MainPanel = loginPanel + RegisterPanel and returns this panel. This panel is
                                    later used in Frame.java */
    {
        this.mainPanel.add(setLoginPanel(),BorderLayout.NORTH);
        this.mainPanel.add(setRegisterPanel(),BorderLayout.SOUTH);
        return this.mainPanel;
    }

    public void run()
    {
        frame.setSize(this.width,this.height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(!resizable);
        frame.add(setMainPanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getNameField() {
        return this.userEmail;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("register"))
        {
            frame.dispose();
            RegisterPage registerPage = new RegisterPage();
            registerPage.start();

        }
        if (e.getActionCommand().equals("submit")) {
            try {
                this.email = nameField.getText();
                ServerConnect serverConnect = new ServerConnect("login",nameField.getText(),passwordField.getPassword());
                serverConnect.run();
                if(serverConnect.isConnected()){
                    if(serverConnect.isCanLogin())
                    {
                        JOptionPane.showMessageDialog(frame,"Login Successful","Success", JOptionPane.INFORMATION_MESSAGE);

                    /*
                    ----------------------------------------------------------------------------------
                        Kill the current thread and now make a new ChatApp frame and start its thread
                    ----------------------------------------------------------------------------------
                    */
                        frame.dispose();

                        System.out.println(this.userEmail);
                        ChatFrame chatFrame = new ChatFrame();
                        chatFrame.run();


                    }else {
                        Font font = new Font("", Font.PLAIN, 10);
                        errorLabel.setForeground(Color.RED);
                        errorLabel.setFont(font);
                        errorLabel.setText("*Email or password does not match");
                        errorPanel.add(errorLabel);
                        errorPanel.setVisible(true);
                    }
                } else{
                    JOptionPane.showMessageDialog(frame,"Server Offline", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception exc){
                exc.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Cannot connect to server", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
