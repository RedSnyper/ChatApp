import javax.swing.*;

public class Main extends Thread{
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch (Exception e)
        {
            e.getCause();
        }
        LoginPage loginPage = new LoginPage();
        Thread loginThread = new Thread(loginPage);
        loginThread.start();
    }
}