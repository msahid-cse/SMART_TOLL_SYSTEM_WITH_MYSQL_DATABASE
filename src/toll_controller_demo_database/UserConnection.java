
package toll_controller_demo_database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;


public class UserConnection  {

 Connection c;
    Statement s;
    ResultSet rs;
    public void UserConnection(){
        try{
            c= DriverManager.getConnection("jdbc:mysql://localhost:3307/login","root","123456789");
            s=c.createStatement();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}