import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends Thread implements ActionListener {
    private static final int width = 400;
    private static final int height = 600;
    private  boolean resizable = true;
    private JLabel loginMessageLabel;
    private JPanel loginPanel;
    private JPanel namePanel;
    private JPanel passwordPanel;
    private JPanel submitPanel;
    private JButton submitButton;
    private JPanel errorPanel;
    private JLabel errorMessage;
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
    //private JFrame jFrame;

    public LoginPage(/*JFrame frame*/)
    {
        this.loginMessageLabel = new JLabel();
        this.loginPanel = new JPanel();
        this.namePanel = new JPanel();
        this.passwordPanel = new JPanel();
        this.submitPanel = new JPanel();
        this.submitButton = new JButton("Submit");
        this.errorMessage = new JLabel();
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
    //   this.frame = new JFrame();
        this.frame = new JFrame();
    }

    public JPanel setLoginPanel() //add name, password, submit and error message to a panel called loginpanel and returns this panel
    {
        this.namePanel.setLayout(new FlowLayout());
        this.nameField.setPreferredSize(new Dimension(30,28));
        this.nameField.setActionCommand("name");
        this.nameField.addActionListener(new DataBaseConnect());
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

        this.errorPanel.add(this.errorMessage); // just to show error message


        this.loginPanel.setLayout(new BoxLayout(this.loginPanel,BoxLayout.Y_AXIS));
        this.loginPanel.add(Box.createVerticalStrut(70));
        this.loginMessageLabel.setFont(new Font("", Font.BOLD,30));
        this.loginMessageLabel.setText("LOGIN");
        this.loginPanel.add(this.loginMessageLabel);
        this.loginPanel.add(this.namePanel);
        this.loginPanel.add(Box.createVerticalStrut(20));
        this.loginPanel.add(this.passwordPanel);
        this.loginPanel.add(Box.createVerticalStrut(20));
        this.loginPanel.add(this.submitPanel);
        this.loginPanel.add(Box.createVerticalStrut(20));
        this.loginPanel.add(this.errorPanel);
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
//        try{
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        }catch (Exception e)
//        {
//            e.getCause();
//        }

        frame.setSize(this.width,this.height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(!resizable);
       // mainPanel.setLayout(cardLayout); // making the main panel a cardlayout
       // mainPanel.add("a",loginPage.setMainPanel()); // adding the LoginPage ko panel and registerPage ko panel here.
       // mainPanel.add("b",registerPage.addAllPanels());
        frame.add(setMainPanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JPasswordField getPasswordField() {
        return this.passwordField;
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
                // Check the login details to data stored in database if not exist show / throw error in catch panel
            } catch(Exception exc){
                // show the error in error panel.
            }
        }
    }
}

