import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Ref;
import java.text.Normalizer;

public class FormLogin
{
    public boolean isDisposed=false;
    private JFrame frameLogin = new JFrame("FormLogin");

    FormLogin()
    {
        Listener();
    }


    public void main()
    {
        frameLogin.setContentPane(new FormLogin().mainPanel);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frameLogin.setSize(800, 600);用这个没卵用
        frameLogin.setPreferredSize(new Dimension(800, 600));
        frameLogin.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 800, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 600);
        frameLogin.pack();
        frameLogin.setVisible(true);
    }

    private void Listener()
    {
        btnLogin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //User user=new User();//必须new出来, 不然会有一个什么Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException错误...
                boolean bool = User.UserConfirm(txtUser.getText(), txtPwd.getText());
                if (bool)
                {
                    JOptionPane.showMessageDialog(mainPanel,"登录成功");
                    //isDisposed=true;
                    //frameLogin.dispose();
                    FormMain formMain=new FormMain();
                    formMain.main(txtUser.getText());
                }
                else
                    JOptionPane.showMessageDialog(mainPanel,"登录失败");

            }
        });
        btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                txtUser.setText("");
                txtPwd.setText("");
            }
        });
        txtPwd.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    btnLogin.doClick();
            }
        });
    }

//    private static JFrame frameMain=new JFrame("FormMain")
//    {
//        @Override
//        public void setContentPane(Container contentPane)
//        {
//            super.setContentPane(contentPane);
//        }
//    };
    private JPanel mainPanel;
    private JLabel label1;
    private JButton btnLogin;
    private JButton btnCancel;
    private JTextField txtUser;
    private JTextField txtPwd;
}
