import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataBaseConnect implements ActionListener {

    private LoginPage loginPage;

    public DataBaseConnect()
    {
        loginPage = new LoginPage();
        //data base features
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("name")) {
            //Add this name to the database also check if the name exists or not.
        }
        if (e.getActionCommand().equals("password")) {
            char[] pwd = loginPage.getPasswordField().getPassword();
            String password = pwd.toString();

            // ADD DATABASE FUNCTIONALITIES HERE (CHECK FOR HASH AND PASSWORD SECURE FEATURES WHILE AT IT)

        }
    }


}
