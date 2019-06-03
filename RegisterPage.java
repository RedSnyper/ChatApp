import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage implements ActionListener {
    private JPanel namePanel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JPanel mailPanel;
    private JLabel emailLabel;
    private JTextField emailField;
    private JPanel usernamePanel;
    private JLabel userNameLabel;
    private JTextField usernameTextfield;
    private JPanel passwordPanel;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JPanel verifyPasswordPanel;
    private JLabel verifyPassworldLabel;
    private JPasswordField verifyPassWordField;
    private JPanel passwordVerifyErrorPanel;
    private JLabel passwordErrorLabel;
    private JPanel buttonPanel;
    private JButton submitButton;
    private JPanel mainPanel;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public RegisterPage()
    {
        this.namePanel = new JPanel();
        this.nameLabel = new JLabel("Name:");
        this.nameField = new JTextField();
        this.mailPanel = new JPanel();
        this.emailLabel = new JLabel("E-mail:");
        this.emailField = new JTextField();
        this.usernamePanel = new JPanel();
        this.userNameLabel = new JLabel("Username:");
        this.usernameTextfield = new JTextField();
        this.passwordPanel = new JPanel();
        this.passwordLabel = new JLabel("Password:");
        this.passwordField = new JPasswordField(20);
        this.verifyPasswordPanel = new JPanel();
        this.verifyPassworldLabel = new JLabel("Verify-Password");
        this.verifyPassWordField = new JPasswordField();
        this.passwordVerifyErrorPanel = new JPanel();
        this.passwordErrorLabel = new JLabel();
        this.buttonPanel = new JPanel();
        this.submitButton = new JButton("Submit");
        this.mainPanel = new JPanel();
    }
    public void setNamePanel()
    {
        namePanel.add(Box.createVerticalStrut(20));
        namePanel.setLayout(new FlowLayout());
        namePanel.add(nameLabel);
        nameField.setPreferredSize(new Dimension(30,20));
        nameField.setActionCommand("name");
        nameField.addActionListener(this);
        namePanel.add(nameField);

    }
    public void setMailPanel()
    {
        mailPanel.setLayout(new FlowLayout());
        mailPanel.add(emailLabel);
        emailField.setPreferredSize(new Dimension(30,20));
        emailField.setActionCommand("email");
        emailField.addActionListener(this);
        mailPanel.add(emailField);
    }
    public void setUsernamePanel()
    {
        usernamePanel.setLayout(new FlowLayout());
        usernamePanel.add(userNameLabel);
        usernameTextfield.setPreferredSize(new Dimension(30,20));
        usernameTextfield.setActionCommand("username");
        usernameTextfield.addActionListener(this);
        usernamePanel.add(usernameTextfield);
    }
    public void setPasswordPanel()
    {
        passwordPanel.setLayout(new FlowLayout());
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        passwordField.setActionCommand("password");
        passwordField.addActionListener(this);
    }
    public void setPasswordVerifyErrorPanel()
    {
        passwordVerifyErrorPanel.setLayout(new FlowLayout());
        //This shows the error message hola idk
    }
    public void setVerifyPasswordPanel()
    {
        verifyPasswordPanel.setLayout(new FlowLayout());
        verifyPasswordPanel.add(verifyPassWordField);
        verifyPasswordPanel.add(verifyPassWordField);
    }
    public void setButtonPanel()
    {
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(submitButton);
    }
    public void addAllPanels()
    {
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.add(namePanel);
        mainPanel.add(mailPanel);
        mainPanel.add(usernamePanel);
        mainPanel.add(passwordPanel);
        mainPanel.add(verifyPasswordPanel);
        verifyPasswordPanel.setVisible(false);
        mainPanel.add(verifyPasswordPanel);
        mainPanel.add(buttonPanel);
        setNamePanel();
        setMailPanel();
        setUsernamePanel();
        setPasswordPanel();
        setVerifyPasswordPanel();
        setButtonPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("password"))
        {
            setPasswordVerifyErrorPanel();
            if(passwordField.equals(verifyPassWordField))
            {
                verifyPasswordPanel.setVisible(true);
                passwordErrorLabel.setText("Password is correct");
                if(e.getActionCommand().equals("name"))
                {


                }
                if(e.getActionCommand().equals("email"))
                {

                }
                if(e.getActionCommand().equals("username"))
                {


                }
            }
            else
            {
                verifyPasswordPanel.setVisible(true);
                passwordErrorLabel.setText("Password does not match");
            }
        }




    }
}
