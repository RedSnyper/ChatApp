import javax.swing.*;

/*


program execution starts


*/
public class Main extends Thread{
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); //for changing UI to look better
        }catch (Exception e)
        {
            e.getCause();
        }
        LoginPage loginPage = new LoginPage();
        loginPage.run(); // basically  a function to show the login page. Also the program execution runs to loginPage class run() function.
    }
}