package connections;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static DBConnection dbConnection;
    private static Connection connection;
    private DBConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost/thogakade","root","1234");
    }

    public static DBConnection getInstance()  throws Exception{
        return dbConnection!=null? dbConnection:(dbConnection=new DBConnection());
    }
    public static Connection getConnection(){
        return connection;
    }

}
