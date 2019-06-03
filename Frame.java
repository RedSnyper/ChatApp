import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame implements ActionListener {
    private static final int width = 400;
    private static final int breadth = 600;
    private  boolean resizable = false;
    private JFrame frame;
    private JPanel mainPanel;
    private RegisterPage registerPage;
   private LoginPage loginPage;
    private CardLayout cardLayout;
    public Frame()
    {
        this.frame = new JFrame("Login");
        this.mainPanel = new JPanel();
        this.loginPage = new LoginPage();
        this.registerPage = new RegisterPage();
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
        frame.setLocationRelativeTo(null);
        frame.setResizable(resizable);
        mainPanel.setLayout(cardLayout);
        mainPanel.add("a",loginPage.setMainPanel());
        mainPanel.add("b",registerPage.addAllPanels());
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("register"))
        {
            cardLayout.next(mainPanel);
        }
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.start();
    }



}
