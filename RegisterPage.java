//This class needs layout management. NamePanel is to be removed and added with gender check box.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Arrays;

public class RegisterPage extends Thread implements ActionListener {
    private static final int width = 400;
    private static final int height = 600;

    private String regEmail;
    private String regUsername;
    private char[] password;
    private String regGender;

    private JLabel registerLabel;
    private JPanel registerPanel;

    private JPanel namePanel;
    private JLabel nameLabel;
    private JTextField nameField;

    private JPanel mailPanel;
    private JLabel emailLabel;
    private JTextField emailField;

    private JPanel mailCheckPanel;
    private JLabel mailCheckLabel;

    private JPanel genderPanel;
    private JLabel genderLabel;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JRadioButton otherButton;
    private ButtonGroup buttonGroup;

    private JTextField usernameTextfield;
    private JPanel passwordPanel;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JPanel verifyPasswordPanel;
    private JLabel verifyPasswordLabel;
    private JPasswordField verifyPassWordField;
    private JPanel passwordVerifyErrorPanel;
    private JLabel passwordErrorLabel;
    private JPanel buttonPanel;
    private JButton submitButton;
    private JPanel mainPanel;
    private JFrame frame;


    public RegisterPage() {
        this.registerLabel = new JLabel();
        this.registerPanel = new JPanel();
        this.namePanel = new JPanel();
        this.nameLabel = new JLabel("Username:");
        this.nameField = new JTextField();

        this.mailPanel = new JPanel();
        this.emailLabel = new JLabel("E-mail:      ");
        this.emailField = new JTextField();

        this.mailCheckPanel = new JPanel();
        this.mailCheckLabel = new JLabel();

        this.genderPanel = new JPanel();
        this.genderLabel = new JLabel("Gender:");
        this.maleButton = new JRadioButton("Male");
        this.femaleButton = new JRadioButton("Female");
        this.otherButton = new JRadioButton("Other");
        this.buttonGroup = new ButtonGroup();

        this.usernameTextfield = new JTextField();
        this.passwordPanel = new JPanel();
        this.passwordLabel = new JLabel("Password: ");
        this.passwordField = new JPasswordField();
        this.verifyPasswordPanel = new JPanel();
        this.verifyPasswordLabel = new JLabel("Verify-Password:");
        this.verifyPassWordField = new JPasswordField();
        this.passwordVerifyErrorPanel = new JPanel();
        this.passwordErrorLabel = new JLabel();
        this.buttonPanel = new JPanel();
        this.submitButton = new JButton("Submit");
        this.mainPanel = new JPanel();
        this.frame = new JFrame("Register");
    }

    public JPanel registerFrame() {
        this.registerPanel.setLayout(new BoxLayout(this.registerPanel, BoxLayout.Y_AXIS));
        this.registerPanel.add(Box.createHorizontalStrut(40));
        this.registerPanel.add(Box.createVerticalStrut(-10));
        this.registerLabel.setFont(new Font("", Font.BOLD, 30));
        this.registerLabel.setText("Register");
        this.registerPanel.add(registerLabel);

        this.namePanel.setLayout(new FlowLayout());
        this.nameField.setPreferredSize(new Dimension(300, 28));
        this.nameField.addActionListener(this);
        this.nameField.setActionCommand("regUsername");
        this.namePanel.add(this.nameLabel);
        this.namePanel.add(this.nameField);

        this.mailPanel.setLayout(new FlowLayout());
        this.emailField.setPreferredSize(new Dimension(300, 28));
        this.emailField.setActionCommand("regEmail");
        this.emailField.addActionListener(this);
        this.mailPanel.add(emailLabel);
        this.mailPanel.add(emailField);

        this.mailCheckPanel.setLayout(new FlowLayout());
        this.mailCheckPanel.add(mailCheckLabel);
        this.mailCheckPanel.setVisible(false);

        this.genderPanel.setLayout(new FlowLayout());
        this.buttonGroup.add(maleButton);
        this.buttonGroup.add(femaleButton);
        this.buttonGroup.add(otherButton);
        this.maleButton.addActionListener(this);
        this.maleButton.setActionCommand(maleButton.getText());
        this.femaleButton.addActionListener(this);
        this.femaleButton.setActionCommand(femaleButton.getText());
        this.otherButton.addActionListener(this);
        this.otherButton.setActionCommand(otherButton.getText());
        this.genderPanel.add(genderLabel);
        this.genderPanel.add(Box.createHorizontalStrut(50));
        this.genderPanel.add(maleButton);
        this.genderPanel.add(Box.createHorizontalStrut(38));
        this.genderPanel.add(femaleButton);
        this.genderPanel.add(Box.createHorizontalStrut(38));
        this.genderPanel.add(otherButton);

        this.passwordPanel.setLayout(new FlowLayout());
        passwordField.setPreferredSize(new Dimension(300, 28));
        this.passwordPanel.add(this.passwordLabel);
        this.passwordPanel.add(this.passwordField);
        this.passwordField.setActionCommand("regPassword");

        this.verifyPasswordPanel.setLayout(new FlowLayout());
        verifyPassWordField.setPreferredSize(new Dimension(268, 28));
        this.verifyPasswordPanel.add(this.verifyPasswordLabel);
        this.verifyPasswordPanel.add(this.verifyPassWordField);
        this.verifyPassWordField.setActionCommand("verifyPassword");
        verifyPassWordField.addActionListener(this);
        this.passwordVerifyErrorPanel.setLayout(new FlowLayout());
        passwordVerifyErrorPanel.setVisible(false);
        this.buttonPanel.setLayout(new FlowLayout());
        this.buttonPanel.add(this.submitButton);
        submitButton.addActionListener(this);
        submitButton.setActionCommand("regSubmit");

        this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.mainPanel.add(registerPanel);
        this.mainPanel.add(Box.createVerticalStrut(40));
        this.mainPanel.add(namePanel);
        this.mainPanel.add(mailPanel);
        this.mainPanel.add(mailCheckPanel);
        this.mainPanel.add(genderPanel);
        this.mainPanel.add(passwordPanel);
        this.mainPanel.add(verifyPasswordPanel);
        this.mainPanel.add(passwordVerifyErrorPanel);
        this.mainPanel.add(buttonPanel);

        return mainPanel;
    }

    public boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    @Override
    public void run() {
        registerPageFrame();
    }

    public void registerPageFrame() {
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.add(registerFrame());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("regSubmit")) {
            this.regEmail = emailField.getText();
            boolean success = false;
            if ((Arrays.equals(passwordField.getPassword(), verifyPassWordField.getPassword())) && isValid(regEmail)) {
                passwordVerifyErrorPanel.setVisible(false);
                mailCheckPanel.setVisible(false);
                try {
                    regUsername = nameField.getText();
                    regGender = buttonGroup.getSelection().getActionCommand();
                    password = passwordField.getPassword();
                    if (regUsername.equals("") || regEmail.equals("") || password.length == 0) {
                        throw new Exception();
                    } else {
                        success = true;
                    }
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (success) {
                    ServerConnect serverConnect = new ServerConnect("register", regUsername, regEmail, regGender, password);
                    System.out.println(serverConnect.getLoginType());
                    System.out.println("here");
                     try {
                         {
                             serverConnect.start();
                         }
                         Thread.sleep(1000); // to delay the main thread to get the isRegistered result

                        if (serverConnect.isRegistered()) {
                            JOptionPane.showMessageDialog(frame, "Register Successful");
                            frame.dispose();
                            LoginPage loginPage = new LoginPage();
                            loginPage.start();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Cannot Register. Server Is Offline", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception err) {
                        System.out.println(err.getMessage());
                    }
                }
            } else{
                Font font = new Font("quicksand", Font.PLAIN, 10);
                if (!isValid(regEmail)) {
                    mailCheckLabel.setForeground(Color.RED);
                    mailCheckLabel.setFont(font);
                    mailCheckLabel.setText("*ENTER A VALID EMAIL ADDRESS");
                    mailCheckPanel.add(mailCheckLabel);
                    mailCheckPanel.setVisible(true);
                } else {
                    mailCheckPanel.setVisible(false);
                }
                if ((Arrays.equals(passwordField.getPassword(), verifyPassWordField.getPassword()))) {
                    passwordVerifyErrorPanel.setVisible(false);
                } else {
                    passwordErrorLabel.setForeground(Color.RED);
                    passwordErrorLabel.setFont(font);
                    this.passwordErrorLabel.setText("*PASSWORD DOES NOT MATCH");
                    this.passwordVerifyErrorPanel.add(this.passwordErrorLabel);
                    passwordVerifyErrorPanel.setVisible(true);
                }
            }
        }
    }
}





