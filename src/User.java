import javax.annotation.processing.RoundEnvironment;
import java.sql.ResultSet;

public class User
{
    public String StuName=null;
    public String StuNo=null;
    public String Birthday=null;
    public String Gender=null;
    public String School=null;
    public String Major=null;
    public String Class=null;
    public String Address=null;
    public String HomePhone=null;
    public String CellPhone=null;
    public String Age=null;

    public static boolean UserConfirm(String UserName, String Pwd)
    {
        String SQL="select count(*) as hang from JavaTest.dbo.StudentTable " +
                "where StuNo='"+UserName+"' and Pwd='"+Pwd+"'";

        try
        {
            ResultSet rs=DB.ReadDB(SQL);
            rs.next();//必须得用这个next, 很烦...
            String temp=rs.getString(1);
            if ( temp.equals("1"))
                return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public static User GetUserInfo(String UserName)
    {
        String SQL="select * from JavaTest.dbo.StudentTable " +
                "where StuNo='"+UserName+"'";
        User user=new User();
        try
        {
            ResultSet rs=DB.ReadDB(SQL);
            if (rs.next())
            {
                user.StuName=rs.getString("StuName");
                user.StuNo=rs.getString("StuNo");
                user.Birthday=rs.getString("Birthday");
                user.Gender=rs.getString("Gender");
                user.School=rs.getString("School");
                user.Major=rs.getString("Major");
                user.Class=rs.getString("Class");
                user.Address=rs.getString("Address");
                user.HomePhone=rs.getString("HomePhone");
                user.CellPhone=rs.getString("CellPhone");
                user.Age=rs.getString("Age");
            }

            return user;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean SetUserInfo(User user)
    {
        String SQL ="insert into StudentTable(StuNo,StuName,Birthday,Gender,School," +
                "Major,Class,Address,HomePhone,CellPhone,Age) " +
                "values('"+user.StuNo+"','"+user.StuName+"','"+user.Birthday+"','"+user.Gender+"'," +
                "'"+user.School+"','"+user.Major+"'," +
            "'"+user.Class+"','"+user.Address+"','"+user.HomePhone+"','"+user.CellPhone+"'," +
                "'"+user.Age+"')";

        try
        {
            int rows=DB.ReturnRows(SQL);
            if (rows == 1)
                return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean UpdateUserInfo(User user)
    {
        String SQL ="update StudentTable set StuName='"+user.StuName+"'," +
                "Birthday='"+user.Birthday+"',Gender='"+user.Gender+"'," +
                "School='"+user.School+"',Major='"+user.Major+"',Class='"+user.Class+"'," +
                "Address='"+user.Address+"',HomePhone='"+user.HomePhone+"'," +
                "CellPhone='"+user.CellPhone+"',Age='"+user.Age+"' " +
                "where StuNo='"+user.StuNo+"'" ;
        //System.out.println(SQL);
        try
        {
            int rows=DB.ReturnRows(SQL);
            if (rows == 1)
                return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean DeleteUser(String StuNo)
    {
        String SQL ="delete from StudentTable where StuNo='"+StuNo+"'";

        try
        {
            int rows= DB.ReturnRows(SQL);
            if (rows == 1)
                return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
