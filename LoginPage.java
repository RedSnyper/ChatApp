import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {
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
    //private JFrame frame;

    public LoginPage(/*JFrame frame*/)
    {
        loginMessageLabel = new JLabel();
        loginPanel = new JPanel();
        namePanel = new JPanel();
        passwordPanel = new JPanel();
        submitPanel = new JPanel();
        submitButton = new JButton("Submit");
        errorMessage = new JLabel();
        errorPanel = new JPanel();
        registerPanel = new JPanel();
        registerLabel = new JLabel();
        registerLabelPanel = new JPanel();
        registerButtonPanel = new JPanel();
        registerButton = new JButton("Register");
        nameLabel = new JLabel("E-mail:");
        passwordLabel = new JLabel();
        nameField = new JTextField(20);
        passwordField  = new JPasswordField(13);
        mainPanel = new JPanel();
    //   this.frame = new JFrame();
    }

    public JPanel setLoginPanel()
    {
        namePanel.setLayout(new FlowLayout());
        nameField.setPreferredSize(new Dimension(30,25));
        nameField.setActionCommand("name");
        nameField.addActionListener(new DataBaseConnect());
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        passwordPanel.setLayout(new FlowLayout());
        passwordLabel.setText("Password:");
        passwordField.setActionCommand("password");
        passwordField.addActionListener(new DataBaseConnect());
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);


        submitButton.setActionCommand("submit");
        submitButton.addActionListener(new ServerConnect());
        submitPanel.add(submitButton);

        errorPanel.add(errorMessage); // just to show error message


        loginPanel.setLayout(new BoxLayout(loginPanel,BoxLayout.Y_AXIS));
        loginPanel.add(Box.createVerticalStrut(20));
        loginMessageLabel.setFont(new Font("", Font.BOLD,30));
        loginMessageLabel.setText("LOGIN");
        loginPanel.add(loginMessageLabel);
        loginPanel.add(namePanel);
        loginPanel.add(Box.createVerticalStrut(20));
        loginPanel.add(passwordPanel);
        loginPanel.add(Box.createVerticalStrut(20));
        loginPanel.add(submitPanel);
        loginPanel.add(Box.createVerticalStrut(20));
        loginPanel.add(errorPanel);
        return loginPanel;
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public JPanel getRegisterPanel() {
        return registerPanel;
    }

    public void setRegisterPanel()
    {
        JSeparator separator = new JSeparator();

        registerLabelPanel.setLayout(new FlowLayout());

        registerLabelPanel.add(Box.createVerticalStrut(40));
        registerPanel.add(separator);
        String message = "New Member? Register";
        Font font = new Font("Times New Roman",Font.PLAIN,20);

        registerLabel.setFont(font);
        registerLabel.setText(message);
        registerButtonPanel.setLayout(new FlowLayout());
        registerButton.setActionCommand("register");
        registerButton.addActionListener(new MainLoginPanel());

        registerPanel.setLayout(new BoxLayout(registerPanel,BoxLayout.Y_AXIS));
        registerPanel.add(Box.createVerticalStrut(30));
        registerPanel.add(registerLabel);
        registerPanel.add(Box.createVerticalStrut(30));
        registerPanel.add(registerButton);


    }

    public JPanel getMainPanel()
    {
        return mainPanel;
    }

    public void setMainPanel()
    {

       setLoginPanel();
       setRegisterPanel();

        mainPanel.add(getLoginPanel(),BorderLayout.NORTH);
       // loginPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        mainPanel.add(getRegisterPanel() ,BorderLayout.SOUTH);

    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("submit")) {
            try {
                // Check the login details to data stored in database if not exist show error in catch panel
            } catch(Exception exc){
                // show the error in error panel.
            }
        }
        if(e.getActionCommand().equals("register"))
        {

            //MainLoginPanel mainLoginPanel = new MainLoginPanel();
            //mainLoginPanel.addAllInOne();
            //CardLayout cardLayout = (CardLayout) mainLoginPanel.getMainPanel().getLayout();
            //cardLayout.next(mainLoginPanel.getMainPanel());
        }
    }
}

