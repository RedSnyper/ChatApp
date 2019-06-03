import javax.swing.*;
import java.awt.*;

public class Frame {
    private static final int width = 400;
    private static final int breadth = 600;
    private  boolean resizable = false;
    private JFrame frame;
    private MainLoginPanel mainLoginPanel;
   // private RegisterPage registerPage;
   //private LoginPage loginPage;
    private CardLayout cardLayout;
    public Frame()
    {
        this.frame = new JFrame("Login");
        this.mainLoginPanel = new MainLoginPanel();
        //this.loginPage = new LoginPage();
       // this.registerPage = new RegisterPage();
        this.cardLayout = new CardLayout();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void start()
    {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e)
        {
            e.getCause();
        }

        frame.setSize(this.width,this.breadth);
        //loginPage.setMainPanel();
        frame.setLocationRelativeTo(null);
        frame.setResizable(resizable);
        //frame.add(loginPage.getMainPanel());
        mainLoginPanel.getMainPanel().setLayout(cardLayout);
        mainLoginPanel.addAllInOne();
        frame.add(mainLoginPanel.getMainPanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.start();
    }



}
