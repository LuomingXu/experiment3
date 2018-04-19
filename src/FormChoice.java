import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FormChoice extends JFrame
{
    private JPanel mainPanel;
    private JButton btnUpdate;
    private JButton btnInsert;
    private JButton btnDelete;
    private String UserName;
    private enumChoice option= enumChoice.none;

    private FormMain formMain=null;

    public FormChoice()
    {
        InitializeComponent();
        Listener();
    }
    public FormChoice(String UserName)
    {
        InitializeComponent();
        Listener();
        this.UserName=UserName;
    }

    private void InitializeComponent()
    {
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 400));
        //this.setLocationRelativeTo(null);
        this.setLocation(200,200);
        this.pack();
        this.setVisible(true);
        addWindowListener(new WindowAdapter() {//exit all
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    private void Listener()
    {
        btnUpdate.addActionListener(e ->
        {
            option=enumChoice.update;
            if (formMain != null)
                formMain.dispose();
            formMain=new FormMain(UserName,option);
        });
        btnDelete.addActionListener(e ->
        {
            option=enumChoice.delete;
            if (formMain != null)
                formMain.dispose();
            formMain=new FormMain(UserName,option);
        });
        btnInsert.addActionListener(e ->
        {
            option=enumChoice.insert;
            if (formMain != null)
                formMain.dispose();
            formMain=new FormMain(UserName,option);
        });
    }

}
