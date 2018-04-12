import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB
{
    private static String username="sa";
    private static String userpwd="123456";//暂且用这个sbPwd

    private static Connection ConnDB()
    {
        String drivename="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dburl="jdbc:sqlserver://徐络溟SURFACEPR\\SQLEXPRESS:2537;DatabaseName=JavaTest";
        try
        {
            Class.forName(drivename);
//            System.out.println("load jdbcdrive successful");
//            System.out.println("conn start");
            Connection conn=DriverManager.getConnection(dburl, username, userpwd);

            return conn;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet ReadDB(String SQL)
    {
        try
        {
            Connection conn=ConnDB();
            if (conn != null)
                System.out.println("connection successful");
            else
                System.out.println("connection fail");

            Statement stat=conn.createStatement();
            ResultSet rs=stat.executeQuery(SQL);

            return rs;
        }
        catch(Exception e)
        {
//            System.out.println("DB.ReadDB-error");
//            e.printStackTrace();
        }
        return null;
    }

    public static int ReturnRows(String SQL)
    {
        try
        {
            Connection conn=ConnDB();
            if (conn != null)
                System.out.println("connection successful");
            else
                System.out.println("connection fail");

            Statement stat=conn.createStatement();
            stat.executeQuery(SQL);

            return stat.getUpdateCount();
        }
        catch(Exception e)
        {
//            System.out.println("DB.ReadDB-error");
//            e.printStackTrace();
        }

        return 0;
    }
}
