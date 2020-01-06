//This class needs layout management. NamePanel is to be removed and added with gender check box.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class RegisterPage implements ActionListener {
    /*
        variables declaration section
                                        */
    private static final int width = 400;
    private static final int height = 600;

    private String regEmail;
    private String regUsername;
    private char[] password;
    private String regGender;
    private boolean emailSame;

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


    public RegisterPage() // constructor initializing all components.
     {
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
        this.mainPanel = new JPanel();                  /* Main Panel = registerPanel + name panel + mailCheckPanel + genderpanel
                                                                        + passwordPanel + passwordVerificationPanel + buttonPanel
                                                                                                */

        this.frame = new JFrame("Register");
    }

    public JPanel registerFrame() //adds everything to the register frame with layouts included here.
     {
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

    public boolean isValid(String email) //email checking if email pattern is entered correctly or not.
    {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public void start() {
        registerPageFrame();
    } // calls the function which adds all components into one.

    public void registerPageFrame() //this adds all the components into frame. Buttons have actionListener.
     {
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.add(registerFrame()); // this registerFrame() functions contains all swing components(above LOCs) which are added to frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean success =false; //setting up flag. If true, initiate process of sending data to server.
        if (e.getActionCommand().equals("regSubmit")) // this runs if the register button is pressed.
        {
            this.regEmail = emailField.getText(); // what email address written is stored in regEmail var.

            if ((Arrays.equals(passwordField.getPassword(), verifyPassWordField.getPassword())) && isValid(regEmail)) /*checks if password entered in two fields are same or not
                                                                                                                        and also if email is valid or not. If password and email both
                                                                                                                        are valid then this statement runs */
            {
                passwordVerifyErrorPanel.setVisible(false); // if password match, dont show password mismatch feature. As password verification is done above, this is always set to false(hide it)
                mailCheckPanel.setVisible(false); // if email match, dont show email invalid. As email verification is done above, this is always hidden
                try {
                    regUsername = nameField.getText(); //store username
                    regGender = buttonGroup.getSelection().getActionCommand(); //store gender
                    password = passwordField.getPassword(); //store password
                    if (regUsername.equals("") || regEmail.equals("") || password.length == 0) // if anything is empty show a dialogue box saying to fill all fields
                    {
                        throw new Exception(); // throw an exception ( which basically says to fill all fields)
                    } else {
                        success = true;     // if everything is filled then set success as true ( this means its ready to send data to server, success variable acts as a flag. )
                    }
                } catch (Exception err)
                {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE); //pops up an error dialogue box if any field is empty
                }
                if (success) /*

                 the main part where data is sent to server after email, password, username is filled correctly

                                                                                            */
                {

                    ServerConnect serverConnect = new ServerConnect("register", regUsername, regEmail, regGender, password); /*ServerConnect class is equivalent to binding all data
                                                                                                                                        into one object and passing that object to server
                                                                                                                                        (Uses object serialization)
                                                                                                                                        */
                    try {

                            serverConnect.run(); // program execution goes to serverConnect run() function
                            if (serverConnect.isRegistered() && !serverConnect.isSameEmail()) // the isRegistered and isSameEmail flag is set up by the serverconnect object
                                                                                                // this checks if the user is registered successfully or if the email clash
                            {

                            emailSame = false;
                            JOptionPane.showMessageDialog(frame, "Register Successful");
                            frame.dispose();
                            LoginPage loginPage = new LoginPage();
                            loginPage.run();

                        } else {
                            if(serverConnect.isSameEmail()) // case for same email.
                            {
                                JOptionPane.showMessageDialog(frame,"Email Already Taken", "Error",JOptionPane.ERROR_MESSAGE);
                            }
                            else if(!serverConnect.isRegistered()) //case for register unsuccessful
                            {
                                JOptionPane.showMessageDialog(frame, "Cannot Register. Server Is Offline", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (Exception err) {
                        System.out.println(err.getMessage());
                    } // end of if (success)
                }
                /*
                end of  if ((Arrays.equals(passwordField.getPassword(), verifyPassWordField.getPassword())) && isValid(regEmail))
                 */
            }
            else // says what to do if password or email does not match.
                {
                Font font = new Font("", Font.PLAIN, 10);
                if (!isValid(regEmail)) //case for email pattern mismatch
                {
                    mailCheckLabel.setForeground(Color.RED);
                    mailCheckLabel.setFont(font);
                    mailCheckLabel.setText("*ENTER A VALID EMAIL ADDRESS");
                    mailCheckPanel.add(mailCheckLabel);
                    mailCheckPanel.setVisible(true);// sets the error panel and is shown
                } else {
                    /* This else here works as
                        1) In first try if email is wrong, the above if statement gets executed. The above statement displays email mismatch message
                        2) Now if you correct it, the email mismatch error is still displayed even though corrected email is entered
                        3) This else statement is added here to not show the mismatch error if email is corrected. It hides the error panel
                        */
                    mailCheckPanel.setVisible(false);
                }
                if ((Arrays.equals(passwordField.getPassword(), verifyPassWordField.getPassword()))) // case for password mismatch
                {
                    passwordVerifyErrorPanel.setVisible(false);
                } else
                    /* else is written for the same reasons as for email's above */
                    {
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
