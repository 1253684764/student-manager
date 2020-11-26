package frame;

import entity.AdminName;
import factory.ServiceFactory;
import utils.ResultEntity;
import frame.mainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName NEW
 * @Description TODO
 * @Author UnKnW
 * @Date 2020/11/16 21:23
 **/
public class AdminLoginFrame extends JFrame{
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JTextField accountField;
    private JPasswordField passField;
    private JButton loginButton;
    private JButton resetButton;
    private JLabel loginField;
    private JLabel welField;
    private JLabel accountLabel;
    private JLabel passLabel;
    private JPanel loginPanel;
    private JPanel passPanel;
    private JLabel logoField;

    public AdminLoginFrame(){
        this.setTitle("AdminLoginFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        //frame.pack();
        this.setVisible(true);
        loginButton.addActionListener(e -> {
            String account = accountField.getText().trim();
            String password = new String(passField.getPassword()).trim();
            ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account,password);
            JOptionPane.showMessageDialog(mainPanel,resultEntity.getMessage());
            if (resultEntity.getCode() ==0){
                this.dispose();
                new mainFrame();
            }else{
                accountField.setText("");
                passField.setText("");
            }
        });
        resetButton.addActionListener(e -> {
            accountField.setText("");
            passField.setText("");
        });
    }
    public static void main(String[] args) {
        new AdminLoginFrame();
    }
}
