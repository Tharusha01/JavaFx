package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionClass {
    private static Connection connection;
    public static Connection getConnection() {
        String dbName="jeff's_shop";
        String userName="root";
        String password="";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }

}

