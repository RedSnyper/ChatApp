//This class needs layout management. NamePanel is to be removed and added with gender check box.

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
    public JPanel setNamePanel() // set the namepanel and returns it, this is later added to the main registerPanel(in allInOne())
    {
        this.namePanel.setLayout(new FlowLayout());
        this.namePanel.add(Box.createVerticalStrut(100));
        this.namePanel.add(this.nameLabel);
        this.nameField.setPreferredSize(new Dimension(300,20));
        this.nameField.setActionCommand("name");
        this.nameField.addActionListener(this);
        this.namePanel.add(this.nameField);
        return this.namePanel;
    }
    public JPanel setMailPanel()// set the email and returns it, this is later added to the main registerPanel(in allInOne())
    {
        this.mailPanel.setLayout(new FlowLayout());
        this.mailPanel.add(emailLabel);
        this.emailField.setPreferredSize(new Dimension(308,20));
        this.emailField.setActionCommand("email");
        this.emailField.addActionListener(this);
        this.mailPanel.add(emailField);
        return this.mailPanel;
    }
    public JPanel setUsernamePanel()// set the userName and returns it, this is later added to the main registerPanel(in allInOne())
    {
        this.usernamePanel.setLayout(new FlowLayout());
        this.usernamePanel.add(userNameLabel);
        this.usernameTextfield.setPreferredSize(new Dimension(300,20));
        this.usernameTextfield.setActionCommand("username");
        this.usernameTextfield.addActionListener(this);
        this.usernamePanel.add(usernameTextfield);
        return this.usernamePanel;
    }
    public JPanel setPasswordPanel()// set the password and returns it, this is later added to the main registerPanel(in allInOne())
    {
        this.passwordPanel.setLayout(new FlowLayout());
        passwordField.setPreferredSize(new Dimension(400,20));
        this.passwordPanel.add(this.passwordLabel);
        this.passwordPanel.add(this.passwordField);
        this.passwordField.setActionCommand("password");
        this.passwordField.addActionListener(this);
        return this.passwordPanel;
    }
    public JPanel setVerifyPasswordPanel()// set the verifyPassword panel and returns it, this is later added to the main registerPanel(in allInOne())
    {
        this.verifyPasswordPanel.setLayout(new FlowLayout());
        verifyPassWordField.setPreferredSize(new Dimension(260,20));
        this.verifyPasswordPanel.add(this.verifyPassworldLabel);
        this.verifyPasswordPanel.add(this.verifyPassWordField);
        return this.verifyPasswordPanel;
    }
    public JPanel setPasswordVerifyErrorPanel(String message) // if password does not match this panel should show the message

    {
        this.passwordVerifyErrorPanel.setLayout(new FlowLayout());
        this.passwordErrorLabel.setText(message);
        this.passwordVerifyErrorPanel.add(this.passwordErrorLabel);
        //This shows the error message hola idk
        return this.passwordVerifyErrorPanel;
    }

    public JPanel setButtonPanel()// set the Submitbutton panel and returns it, this is later added to the main registerPanel(in allInOne())
    {
        this.buttonPanel.setLayout(new FlowLayout());
        this.buttonPanel.add(this.submitButton);
        return this.buttonPanel;
    }
    public JPanel addAllPanels() // add every panel above into a mainPanel, this function returns the mainPanel which is later used in Frame.java class
    {
        this.mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        this.mainPanel.add(setNamePanel());
        this.mainPanel.add(setMailPanel());
        this.mainPanel.add(setUsernamePanel());
        this.mainPanel.add(setPasswordPanel());
        this.mainPanel.add(setVerifyPasswordPanel());
        this.mainPanel.add(setPasswordVerifyErrorPanel(""));
        //this.verifyPasswordPanel.setVisible(false);
        //this.mainPanel.add(this.verifyPasswordPanel);
        this.mainPanel.add(setButtonPanel());
        return this.mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("password"))
        {
            setPasswordVerifyErrorPanel("Password Correct");
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
