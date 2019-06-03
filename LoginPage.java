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
    }

    public JPanel setLoginPanel()
    {
        this.namePanel.setLayout(new FlowLayout());
        this.nameField.setPreferredSize(new Dimension(30,25));
        this.nameField.setActionCommand("name");
        this.nameField.addActionListener(new DataBaseConnect());
        this.namePanel.add(this.nameLabel);
        this.namePanel.add(this.nameField);

        this.passwordPanel.setLayout(new FlowLayout());
        this.passwordLabel.setText("Password:");
        this.passwordField.setActionCommand("password");
        this.passwordField.addActionListener(new DataBaseConnect());
        this.passwordPanel.add(this.passwordLabel);
        this.passwordPanel.add(this.passwordField);


        this.submitButton.setActionCommand("submit");
        this.submitButton.addActionListener(new ServerConnect());
        this.submitPanel.add(this.submitButton);

        this.errorPanel.add(this.errorMessage); // just to show error message


        this.loginPanel.setLayout(new BoxLayout(this.loginPanel,BoxLayout.Y_AXIS));
        this.loginPanel.add(Box.createVerticalStrut(20));
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



    public JPanel setRegisterPanel()
    {
        JSeparator separator = new JSeparator();

        this.registerLabelPanel.setLayout(new FlowLayout());

        this.registerLabelPanel.add(Box.createVerticalStrut(40));
        this.registerPanel.add(separator);
        String message = "New Member? Register";
        Font font = new Font("Times New Roman",Font.PLAIN,20);

        this.registerLabel.setFont(font);
        this.registerLabel.setText(message);
        this.registerButtonPanel.setLayout(new FlowLayout());
        this.registerButton.setActionCommand("register");
        this.registerButton.addActionListener(new Frame());

        this.registerPanel.setLayout(new BoxLayout(this.registerPanel,BoxLayout.Y_AXIS));
        registerPanel.add(Box.createVerticalStrut(30));
        this.registerPanel.add(this.registerLabel);
        this.registerPanel.add(Box.createVerticalStrut(30));
        this.registerPanel.add(this.registerButton);

return this.registerPanel;
    }


    public JPanel setMainPanel()
    {



        this.mainPanel.add(setLoginPanel(),BorderLayout.NORTH);
       // loginPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        this.mainPanel.add(setRegisterPanel(),BorderLayout.SOUTH);

        return this.mainPanel;
    }

    public JPasswordField getPasswordField() {
        return this.passwordField;
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

