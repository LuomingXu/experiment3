import javax.swing.*;
import java.awt.*;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
//        Scanner cin=new Scanner(System.in);
//        while (true)
//        {
//            System.out.println("waiting for input...");
//            try
//            {
//                if (cin.nextInt() > 18)
//                    throw new UserException("out range");
//            }
//            catch(Exception e)
//            {
//                e.printStackTrace();
//            }
//        }
        //System.out.println("\033[31mRed Underline Text\033[m");

        FormLogin Login = new FormLogin();
        Login.main();

        //Message.showMessageDialog("test",JOptionPane.YES_NO_OPTION);


//        FormMain formMain=new FormMain();
//        formMain.main();
    }
}
