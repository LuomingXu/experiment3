import javax.swing.*;
import java.awt.*;

public class Message
{
    public static Object showMessageDialog(Object message,int optionType){


        JOptionPane pane = new JOptionPane(new JLabel("<html><font size=14>" +
                ""+message+"</font></html>"), optionType);
        //JOptionPane pane= new JOptionPane(message,optionType);
        //Font font=new Font("黑体",Font.PLAIN,100);
        //pane.setWantsInput(true);

        JDialog dialog = pane.createDialog("信息");

        dialog.setSize(350, 350);
        //dialog.setFont(font);
        dialog.show();

        dialog.dispose();

        Object value = pane.getInputValue();

        if(value == JOptionPane.UNINITIALIZED_VALUE)return null;

        return value;

    }
    public static JLabel transformat(String str)
    {
        return new JLabel("<html><font size=14>" +
                ""+str+"</font></html>");
    }
}
