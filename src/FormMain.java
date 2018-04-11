import javax.swing.*;
import java.awt.*;

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

    private String UserName;

    FormMain ()
    {

    }
    FormMain (String UserName)
    {
        this.UserName=UserName;
    }

    public void main()
    {
        JFrame frame = new JFrame("FormMain");

        frame.setContentPane(new FormMain("dskfjdskl").mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1600, 1400));
        frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 600, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 500);
        frame.pack();
        frame.setVisible(true);

        txtName.setText(UserName);
    }

    private void SetInfo()
    {
        User user=User.GetUserInfo(UserName);
    }
}
