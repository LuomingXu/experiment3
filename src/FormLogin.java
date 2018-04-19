import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormLogin extends JFrame
{
    public boolean isDisposed=false;
    //private JFrame frameLogin = new JFrame("FormLogin");

    FormLogin()
    {
        InitializeComponent();
        Listener();
    }


//    public void main()
//    {
//        frameLogin.setContentPane(new FormLogin().mainPanel);
//        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frameLogin.setSize(800, 600);用这个没卵用
//        frameLogin.setPreferredSize(new Dimension(800, 600));
//        //frameLogin.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 800, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 600);
//        frameLogin.setLocationRelativeTo(null);
//        frameLogin.pack();
//        frameLogin.setVisible(true);
//    }

    private void InitializeComponent()
    {
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(800, 600);用这个没卵用
        this.setPreferredSize(new Dimension(800, 600));
        this.setLocation(200,200);
        //this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        txtPwd.setEchoChar('*');
    }

    private void Listener()
    {
        btnLogin.addActionListener(e ->
        {
                //User user=new User();//必须new出来, 不然会有一个什么Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException错误...
                boolean bool = User.UserConfirm(txtUser.getText(), String.valueOf(txtPwd.getPassword()));
                if (bool)
                {
                    Message.showMessageDialog("登录成功",JOptionPane.OK_OPTION);
                    this.setVisible(false);
                    FormChoice choice=new FormChoice(txtUser.getText());
                }
                else
                    Message.showMessageDialog("登录失败",JOptionPane.OK_OPTION);
        });
        btnCancel.addActionListener(e ->
        {
                txtUser.setText("");
                txtPwd.setText("");
        });
        txtPwd.addKeyListener(new KeyAdapter()
        {//press enter login
            @Override
            public void keyPressed(KeyEvent e)
            {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    btnLogin.doClick();
            }
        });
        txtUser.addKeyListener(new KeyAdapter()
        {//press enter login
            @Override
            public void keyPressed(KeyEvent e)
            {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    btnLogin.doClick();
            }
        });
    }

    private JPanel mainPanel;
    private JLabel label1;
    private JButton btnLogin;
    private JButton btnCancel;
    private JTextField txtUser;
    private JPasswordField txtPwd;
}
