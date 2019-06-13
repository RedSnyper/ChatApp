//This class needs layout management. NamePanel is to be removed and added with gender check box.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage extends Thread implements ActionListener {
    private static final int width = 400;
    private static final int height = 600;
    private JLabel registerLabel;
    private JPanel registerPanel;

    private JPanel namePanel;
    private JLabel nameLabel;
    private JTextField nameField;

    private JPanel mailPanel;
    private JLabel emailLabel;
    private JTextField emailField;

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


    public RegisterPage()
    {
        this.registerLabel = new JLabel();
        this.registerPanel = new JPanel();
        this.namePanel = new JPanel();
        this.nameLabel = new JLabel("Username:");
        this.nameField = new JTextField();
        this.mailPanel = new JPanel();
        this.emailLabel = new JLabel("E-mail:      ");
        this.emailField = new JTextField();

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

    public JPanel registerFrame(){
        this.registerPanel.setLayout(new BoxLayout(this.registerPanel,BoxLayout.Y_AXIS));
        this.registerPanel.add(Box.createHorizontalStrut(40));
        this.registerPanel.add(Box.createVerticalStrut(-10));
        this.registerLabel.setFont(new Font("",Font.BOLD,30));
        this.registerLabel.setText("Register");
        this.registerPanel.add(registerLabel);


        this.namePanel.setLayout(new FlowLayout());
        //this.namePanel.add(Box.createVerticalStrut(100));
        //this.namePanel.add(Box.createHorizontalStrut(-20));
        this.nameField.setPreferredSize(new Dimension(300,28));
        this.nameField.setActionCommand("username");
        this.nameField.addActionListener(this);
        this.namePanel.add(this.nameLabel);
        this.namePanel.add(this.nameField);


        this.mailPanel.setLayout(new FlowLayout());
        this.emailField.setPreferredSize(new Dimension(300,28));
        this.emailField.setActionCommand("email");
        this.emailField.addActionListener(this);
        this.mailPanel.add(emailLabel);
        this.mailPanel.add(emailField);

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
       // this.genderPanel.add(Box.createHorizontalStrut(40));



        this.passwordPanel.setLayout(new FlowLayout());
        passwordField.setPreferredSize(new Dimension(300,28));
        this.passwordPanel.add(this.passwordLabel);
        this.passwordPanel.add(this.passwordField);
        this.passwordField.setActionCommand("password");
        this.passwordField.addActionListener(this);


        this.verifyPasswordPanel.setLayout(new FlowLayout());
        verifyPassWordField.setPreferredSize(new Dimension(268,28));
        this.verifyPasswordPanel.add(this.verifyPasswordLabel);
        this.verifyPasswordPanel.add(this.verifyPassWordField);

        this.passwordVerifyErrorPanel.setLayout(new FlowLayout());
        this.passwordErrorLabel.setText("");
        this.passwordVerifyErrorPanel.add(this.passwordErrorLabel);
        //This shows the error message hola idk

        this.buttonPanel.setLayout(new FlowLayout());
        this.buttonPanel.add(this.submitButton);



        this.mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        this.mainPanel.add(registerPanel);
        this.mainPanel.add(Box.createVerticalStrut(40));
        this.mainPanel.add(namePanel);
        this.mainPanel.add(mailPanel);
        this.mainPanel.add(genderPanel);
        this.mainPanel.add(passwordPanel);
        this.mainPanel.add(verifyPasswordPanel);
        this.mainPanel.add(buttonPanel);

     //   this.mainPanel.add(setPasswordVerifyErrorPanel(""));
        //this.verifyPasswordPanel.setVisible(false);
        //this.mainPanel.add(this.verifyPasswordPanel);
       // this.mainPanel.add(setButtonPanel());
        return mainPanel;
    }
    @Override
    public void run() {


        registerPageFrame();
    }

        public void registerPageFrame()
        {

            frame.setResizable(false);
            frame.setSize(width, height);
            frame.add(registerFrame());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("password"))
        {
            //setPasswordVerifyErrorPanel("Password Correct");
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
