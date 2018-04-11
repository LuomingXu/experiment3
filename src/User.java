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

    public static boolean UserConfirm(String UserName, String Pwd)
    {
        String SQL="select count(*) as hang from JavaTest.dbo.StudentTable " +
                "where UserName='"+UserName+"' and Pwd='"+Pwd+"'";

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
                "where UserName='"+UserName+"'";
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
            }

            return user;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}