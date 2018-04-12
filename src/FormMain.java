import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMain
{
    private  JTextField txtNo;
    private  JTextField txtName;
    private  JTextField txtBirth;
    private  JTextField txtGender;
    private  JTextField txtSchool;
    private  JTextField txtMajor;
    private  JTextField txtClass;
    private  JTextField txtAddress;
    private  JTextField txtPhone;
    private  JTextField txtCellPhone;
    private  JPanel mainPanel;
    private JButton btnUpdate;
    private JButton btnInsert;
    private JButton btnDelete;

    //private String UserName;
    private JFrame frame = new JFrame("FormMain");

    FormMain ()
    {
        Listener();

    }

    FormMain (String UserNo)
    {
        Listener();
        this.txtNo.setText(UserNo);
        SetInfo();
    }

    public void main(String UserNo)
    {
        frame.setContentPane(new FormMain(UserNo).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1600, 1400));
        frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 600, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 200);
        frame.pack();
        frame.setVisible(true);
    }

    private void Listener()
    {
        btnInsert.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int choice = JOptionPane.showConfirmDialog(null, "确定添加此学生的信息吗?",
                        "确认",JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION)
                {
                    User.SetUserInfo(GetInfo());
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int choice = JOptionPane.showConfirmDialog(null, "确定更新\""+txtNo.getText()+"\"的信息吗?",
                        "确认",JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION)
                {
                    User.UpdateUserInfo(GetInfo());
                }
            }
        });

    }

    private void SetInfo()
    {
        User userInfo=User.GetUserInfo(txtNo.getText());
        txtName.setText(userInfo.StuName);
        txtBirth.setText(userInfo.Birthday);
        txtGender.setText(userInfo.Gender);
        txtSchool.setText(userInfo.School);
        txtMajor.setText(userInfo.Major);
        txtClass.setText(userInfo.Class);
        txtAddress.setText(userInfo.Address);
        txtPhone.setText(userInfo.HomePhone);
        txtCellPhone.setText(userInfo.CellPhone);
    }

    private User GetInfo()
    {
        User user=new User();
        user.StuNo=txtNo.getText();
        user.StuName=txtName.getText();user.Birthday=txtBirth.getText();
        user.Gender=txtGender.getText();user.School=txtSchool.getText();
        user.Major=txtMajor.getText();user.Class=txtClass.getText();
        user.Address=txtAddress.getText();user.HomePhone=txtPhone.getText();
        user.CellPhone=txtCellPhone.getText();

        return user;
    }
}
