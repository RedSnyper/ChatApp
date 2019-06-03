//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MainLoginPanel implements ActionListener {
//    private Frame frame;
//    private JPanel mainPanel;
//    private LoginPage loginPage;
//    private RegisterPage registerPage;
//    CardLayout cardLayout;
//    //Frame frame;
//
//    public  MainLoginPanel()
//    {
//        mainPanel = new JPanel();
//        loginPage = new LoginPage();
//        registerPage = new RegisterPage();
//        cardLayout = new CardLayout();
//     //   Frame frame = new Frame();
//    }
//
//    public void addAllInOne()
//    {
//        //mainPanel.setLayout(cardLayout);
//        loginPage.setLoginPanel();
//        loginPage.setMainPanel();
//
//        mainPanel.add("a",loginPage.getMainPanel());
//     //   loginPage.setRegisterPanel();
//        //registerPage.addAllPanels();
//        //mainPanel.add("b",registerPage.getMainPanel());
//
//
//
//    }
//
//    public JPanel getMainPanel() {
//        return mainPanel;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getActionCommand().equals("register"))
//        {
//            frame = new Frame();
//            frame.getFrame().add(mainPanel);
//            registerPage.addAllPanels();
//            mainPanel.add(registerPage.getMainPanel());
//
//            System.out.println("okay");
//
//        }
//    }
//}
