
package toll_controller_demo_database;


import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import net.proteanit.sql.DbUtils;


public class OnlineUserPaymentHistory extends JFrame implements ActionListener {

    JScrollPane ScrollPanel;
    Choice LicenseNumber;
    JButton SearchButton, TablePrintButton, UpdateButton, backButton;
    JTable DataTable; //table
    String LicenseNumber1;
    String Password1;


    public OnlineUserPaymentHistory(String LicenseNumber2, String Password) {
     this.Password1=Password;
        this.LicenseNumber1=LicenseNumber2;
        getContentPane().setBackground(new Color(136, 196, 245));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("IMAGES/icon2.png"); 
        // Set the icon image for the JFrame
        setIconImage(icon.getImage());
        //heading
        JLabel heading = new JLabel("Payment History");
        add(heading);
        heading.setBounds(450, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);

        DataTable = new JTable();
        try {
            Conn ccc = new Conn();
            ResultSet AllData = ccc.s.executeQuery("select * from collected_toll_record");
            DataTable.setModel(DbUtils.resultSetToTableModel(AllData));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
     

        //Search
        JLabel Search = new JLabel("Your License Number:");
        Search.setBounds(20, 75, 250, 35);
        Search.setFont(new Font("serif", Font.BOLD, 20));
        add(Search);


        LicenseNumber = new Choice();
        LicenseNumber.setBounds(300, 83, 150, 60);
        add(LicenseNumber);

        try {
            Conn ccc = new Conn();
            ResultSet AllData = ccc.s.executeQuery("select * from collected_toll_record");
            while(AllData.next()){
                LicenseNumber.add(AllData.getString("License_Number")); //find by
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        //ScrollPanel
        ScrollPanel = new JScrollPane(DataTable);
        ScrollPanel.setBounds(10, 125, 1370, 600);
        add(ScrollPanel);


        //search
        SearchButton = new JButton(" Search ");
        SearchButton.setBounds(460, 80, 150, 25);
        add(SearchButton);
        SearchButton.setFont(new Font("serif", Font.BOLD, 15));
        SearchButton.setBackground(Color.BLACK);
        SearchButton.setForeground(Color.WHITE);
        SearchButton.addActionListener(this);                  // action


        //Print
        TablePrintButton = new JButton(" Print ");
        TablePrintButton.setBounds(570, 80, 150, 25);
        add(TablePrintButton);
        TablePrintButton.setFont(new Font("serif", Font.BOLD, 15));
        TablePrintButton.setBackground(Color.BLACK);
        TablePrintButton.setForeground(Color.WHITE);
        TablePrintButton.addActionListener(this);                  // action



        //Back
        backButton = new JButton(" Back ");
        backButton.setBounds(750, 80, 150, 25);
        add(backButton);
        backButton.setFont(new Font("serif", Font.BOLD, 15));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);                  // action


        //fream
        setSize(1350, 600);
        setLocation(0, 60);
        setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent ae) {

        if(ae.getSource() == SearchButton){
            //setVisible(false);
            String SearchQuary = " select * from collected_toll_record where License_Number = '"+ LicenseNumber.getSelectedItem()+"'";

            try {
                Conn ccc = new Conn();
                ResultSet EmployeeData = ccc.s.executeQuery(SearchQuary);
                DataTable.setModel(DbUtils.resultSetToTableModel(EmployeeData));


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if (ae.getSource() == TablePrintButton) {

            try {
                DataTable.print();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if (ae.getSource() == backButton) {
            setVisible(false);
            new OnlinePayment(LicenseNumber1, Password1);
            //  moreOption.setVisible(true);
        }
    }


    public static void main(String[] args){
        String a = null, b=null;
        new OnlineUserPaymentHistory(a,b);
    }
}





/*package toll_controller_demo_database;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import net.proteanit.sql.DbUtils;
import toll_controller_demo_database.Conn;
import toll_controller_demo_database.MoreOption;

public class OnlineUserPaymentHistory extends JFrame {

    JScrollPane ScrollPanel;
    JTable DataTable; //table
    String licenseNumber = "abc"; // Change this to your desired license number

    public OnlineUserPaymentHistory() {

        getContentPane().setBackground(new Color(136, 196, 245));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("IMAGES/icon2.png");
        setIconImage(icon.getImage());

        JLabel heading = new JLabel("COLLECTED TOLL RECORD DATABASE");
        add(heading);
        heading.setBounds(450, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);

        DataTable = new JTable();
        try {
            Conn ccc = new Conn();
            
            String query = "SELECT * FROM collected_toll_record WHERE License_Number = '" + licenseNumber + "'";
            ResultSet data = ccc.s.executeQuery(query);
            
            if (!data.next()) {
                // If no rows are found, display a message
                JLabel noDataLabel = new JLabel("No data found for license number: " + licenseNumber);
                add(noDataLabel);
                noDataLabel.setBounds(500, 150, 400, 30);
                noDataLabel.setFont(new Font("serif", Font.BOLD, 16));
                noDataLabel.setForeground(Color.RED);
            } else {
                // Move the cursor back to the beginning to include data in the table
                data.beforeFirst();
                DataTable.setModel(DbUtils.resultSetToTableModel(data));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ScrollPanel = new JScrollPane(DataTable);
        ScrollPanel.setBounds(10, 200, 1370, 500);
        add(ScrollPanel);

        setSize(1350, 600);
        setLocation(0, 60);
        setVisible(true);
    }

    public static void main(String[] args){
        new OnlineUserPaymentHistory();
    }
}
*/