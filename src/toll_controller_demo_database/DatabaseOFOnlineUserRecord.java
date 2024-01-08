package toll_controller_demo_database;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class DatabaseOFOnlineUserRecord extends JFrame implements ActionListener {

    JScrollPane ScrollPanel;
    Choice License;
    JButton SearchButton, TablePrintButton, UpdateButton, backButton;
    JTable DataTable; //table


    public DatabaseOFOnlineUserRecord() {
        getContentPane().setBackground(new Color(136, 196, 245));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("IMAGES/icon2.png"); 
        // Set the icon image for the JFrame
        this.setIconImage(icon.getImage());

        //heading
        JLabel heading = new JLabel("ONLINE USER RECORD DATABASE");
        add(heading);
        heading.setBounds(450, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);


        DataTable = new JTable();
        try {
            Conn ccc = new Conn();
            ResultSet AllData = ccc.s.executeQuery("select * from online_user_registration_record");
            DataTable.setModel(DbUtils.resultSetToTableModel(AllData));
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Search
        JLabel DateTimeSearch = new JLabel("Search by License Number:");
        DateTimeSearch.setBounds(50, 75, 250, 35);
        DateTimeSearch.setFont(new Font("serif", Font.BOLD, 20));
        add(DateTimeSearch);


        
        License = new Choice();
        License.setBounds(300, 83, 250, 60);
        add(License);

        try {
            Conn ccc = new Conn();
            ResultSet AllData = ccc.s.executeQuery("select * from online_user_registration_record");
            while(AllData.next()){
                License.add(AllData.getString("Vehicle_License_Number")); //find by
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
        SearchButton.setBounds(550, 80, 150, 25);
        add(SearchButton);
        SearchButton.setFont(new Font("serif", Font.BOLD, 15));
        SearchButton.setBackground(Color.BLACK);
        SearchButton.setForeground(Color.WHITE);
        SearchButton.addActionListener(this);                  // action


        //Print
        TablePrintButton = new JButton(" Print ");
        TablePrintButton.setBounds(750, 80, 150, 25);
        add(TablePrintButton);
        TablePrintButton.setFont(new Font("serif", Font.BOLD, 15));
        TablePrintButton.setBackground(Color.BLACK);
        TablePrintButton.setForeground(Color.WHITE);
        TablePrintButton.addActionListener(this);                  // action



        //Back
        backButton = new JButton(" Back ");
        backButton.setBounds(900, 80, 150, 25);
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
            String SearchQuary = " select * from online_user_registration_record where Vehicle_License_Number = '"+ License.getSelectedItem()+"'";

            try {
                Conn ccc = new Conn();
                ResultSet Data = ccc.s.executeQuery(SearchQuary);
                DataTable.setModel(DbUtils.resultSetToTableModel(Data));


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
            new MoreOption();
            //  moreOption.setVisible(true);
        }
    }


    public static void main(String[] args){
        new DatabaseOFOnlineUserRecord();
    }
}


