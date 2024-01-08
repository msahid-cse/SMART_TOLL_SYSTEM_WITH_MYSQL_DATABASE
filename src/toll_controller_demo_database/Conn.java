
package toll_controller_demo_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try {
           // Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost:3307/toll_controller_database","root","123456789");
            s=c.createStatement();
        }
        catch(Exception ex){
           // JOptionPane.showMessageDialog(this, ex);
        }
    }
}

