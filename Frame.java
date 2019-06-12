//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Frame extends Thread implements ActionListener {
//    private static final int width = 400;
//    private static final int height = 600;
//    private  boolean resizable = true;
//    private JFrame frame;
//    private JPanel mainPanel; // to add both the loginPage and registerPage ko panels in one main panel
//    private RegisterPage registerPage;
//    private LoginPage loginPage;
//    private CardLayout cardLayout;
//    public Frame()
//    {
//        this.frame = new JFrame("Login");
//        this.mainPanel = new JPanel();
//        this.loginPage = new LoginPage();
//        this.registerPage = new RegisterPage();
//        this.cardLayout = new CardLayout();
//    }
//
//    public JFrame getFrame() {
//        return frame;
//    }
//
//    public void run()
//    {
//        try{
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        }catch (Exception e)
//        {
//            e.getCause();
//        }
//
//        frame.setSize(this.width,this.height);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(!resizable);
//        mainPanel.setLayout(cardLayout); // making the main panel a cardlayout
//        mainPanel.add("a",loginPage.setMainPanel()); // adding the LoginPage ko panel and registerPage ko panel here.
//        mainPanel.add("b",registerPage.addAllPanels());
//        frame.add(mainPanel);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//    @Override
//    public void actionPerformed(ActionEvent e)
//    {
//        if(e.getActionCommand().equals("register"))
//        {
//
//        }
//    }
//
//    public static void main(String[] args) {
//        Frame frame = new Frame();
//        frame.start();
//    }
//
//
//
//}
