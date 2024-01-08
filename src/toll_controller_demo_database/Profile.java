package toll_controller_demo_database;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import net.proteanit.sql.DbUtils;


public class Profile extends JFrame implements ActionListener {


    JTextField textFieldVehicleName, textFieldPaymentGatway, textFieldAccount_Pin;
    JTextField textFieldAccount_Number, textFieldTollFee, textFieldLicenseNumber,textFieldPassword;

    JButton PrintButton,BackButton;
    String VehicleName, LicenseNumber,TollFee, Password,Pin,Number,vPaymentGateway;
    JTable DataTable;
    JScrollPane ScrollPanel;


   

    public Profile(String a,String b, String cip, String d,String eip,String f,String g){
        this.VehicleName=a;
        this.LicenseNumber=b;
        this.TollFee=cip;
        this.Password=d;
        this.Pin=eip;
        this.Number=f;
        this.vPaymentGateway=g;
        
        getContentPane().setBackground(new Color(136, 196, 245));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Smart TOll System");
        
        ImageIcon icon = new ImageIcon("IMAGES/icon2.png"); 
        // Set the icon image for the JFrame
        setIconImage(icon.getImage());
        //background image
        ImageIcon backgroundImage = new ImageIcon("IMAGES/devoback.png"); 
        JLabel background = new JLabel(backgroundImage);
        this.add(background);
        background.setBounds(0, 0, 1000, 600);


        //heading
        JLabel heading = new JLabel("Your Full Information");
        add(heading);
        heading.setBounds(40, 20, 900, 60);
        heading.setFont(new Font("serif", Font.BOLD, 40));
        heading.setForeground(Color.BLACK);


        //VahicleName
        JLabel VahicleName = new JLabel("Vehicle Name:");
        VahicleName.setBounds(30, 100, 200, 20 );
        add(VahicleName);
        VahicleName.setFont(new Font("serif", Font.BOLD, 20));

        textFieldVehicleName = new JTextField();
        textFieldVehicleName.setBounds(200, 103, 250,20);
        add(textFieldVehicleName);
        textFieldVehicleName.setText(a);
        

        DataTable = new JTable();
        try {
            Conn ccc = new Conn();
            ResultSet AllData = ccc.s.executeQuery("select * from online_user_registration_record");
            DataTable.setModel(DbUtils.resultSetToTableModel(AllData));
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        
    

        //LicenseNumber
        JLabel LicenseNumber = new JLabel("License Number:");
        LicenseNumber.setBounds(30, 130, 200, 20 );
        add(LicenseNumber);
        LicenseNumber.setFont(new Font("serif", Font.BOLD, 20));

        textFieldLicenseNumber = new JTextField();
        textFieldLicenseNumber.setBounds(200, 133, 250,20);
        add(textFieldLicenseNumber);
        textFieldLicenseNumber.setText(b);
        

        //TollFee
        JLabel TollFee = new JLabel("Toll Fee:");
        TollFee.setBounds(30, 160, 200, 20 );
        add(TollFee);
        TollFee.setFont(new Font("serif", Font.BOLD, 20));

        textFieldTollFee = new JTextField();
        textFieldTollFee.setBounds(200, 163, 250,20);
        add(textFieldTollFee);
        textFieldTollFee.setText(cip);
        

        //

        //Password
        JLabel Password = new JLabel("Password:");
        Password.setBounds(30, 190, 200, 20 );
        add(Password);
        Password.setFont(new Font("serif", Font.BOLD, 20));

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(200, 193, 250,20);
        add(textFieldPassword);
        textFieldPassword.setText(d);
        

        JLabel Payment_Gateway = new JLabel("Payment Gateway:");
        Payment_Gateway.setBounds(30, 220, 200, 20 );
        add(Payment_Gateway);
        Payment_Gateway.setFont(new Font("serif", Font.BOLD, 20));

        textFieldPaymentGatway = new JTextField();
        textFieldPaymentGatway.setBounds(200, 223, 250,20);
        add(textFieldPaymentGatway);
        textFieldPaymentGatway.setText(g);
        


        //UserName
        JLabel Account_Number = new JLabel("Account Number:");
        Account_Number.setBounds(30, 250, 200, 20 );
        add(Account_Number);
        Account_Number.setFont(new Font("serif", Font.BOLD, 20));

        textFieldAccount_Number = new JTextField();
        textFieldAccount_Number.setBounds(200, 253, 250,20);
        add(textFieldAccount_Number);
        textFieldAccount_Number.setText(f);
        

        //pin
        JLabel Account_Pin = new JLabel("Account PIN:");
        Account_Pin.setBounds(30, 280, 200, 20 );
        add(Account_Pin);
        Account_Pin.setFont(new Font("serif", Font.BOLD, 20));

        textFieldAccount_Pin = new JTextField();
        textFieldAccount_Pin.setBounds(200, 283, 250,20);
        add(textFieldAccount_Pin);
        textFieldAccount_Pin.setText(eip);


        //color button background
       ImageIcon color_background = new ImageIcon("IMAGES/color.png");
        JButton c = new JButton("<BG color>",color_background);
        c.setBounds(900, 0, 100, 25);
        c.setFont(new Font("Arial", Font.BOLD, 12));
        c.setBackground(new Color(159,126	,219));
        c.setForeground(Color.white);
        c.addActionListener(e -> {
            Color cc = JColorChooser.showDialog(null, "choose a color", Color.green);
            getContentPane().setBackground(cc);
        });
        add(c);


        

        //Save Button
        PrintButton = new JButton(" PRINT ");
        PrintButton.setBounds(320, 350, 150, 30);
        add(PrintButton);
        PrintButton.setFont(new Font("serif", Font.BOLD, 20));
        PrintButton.setBackground(new Color(1, 55, 125));
        PrintButton.setForeground(Color.WHITE);
        PrintButton.addActionListener(this);                  // action


        //Back Button
        BackButton = new JButton(" BACK ");
        BackButton.setBounds(150, 350, 150, 30);
        add(BackButton);
        BackButton.setFont(new Font("serif", Font.BOLD, 20));
        BackButton.setBackground(new Color(1, 55, 125));
        BackButton.setForeground(Color.WHITE);
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   new UserSelectionPage();
             new OnlinePayment(b,d);
                setVisible(false);
            }
        });                // action


        //fream
        setSize(1000, 600);
        setLocation(200, 60);
        setVisible(true);

    }
    @Override
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == PrintButton) {
        // Code to print the full information
        StringBuilder fullInfo = new StringBuilder();
        fullInfo.append("Vehicle Name: ").append(textFieldVehicleName.getText()).append("\n");
        fullInfo.append("License Number: ").append(textFieldLicenseNumber.getText()).append("\n");
        fullInfo.append("Toll Fee: ").append(textFieldTollFee.getText()).append("\n");
        fullInfo.append("Password: ").append(textFieldPassword.getText()).append("\n");
        fullInfo.append("Payment Gateway: ").append(textFieldPaymentGatway.getText()).append("\n");
        fullInfo.append("Number: ").append(textFieldAccount_Number.getText()).append("\n");
        fullInfo.append("Pin: ").append(textFieldAccount_Pin.getText()).append("\n");
        JOptionPane.showMessageDialog(this, fullInfo.toString(), "Full Information", JOptionPane.INFORMATION_MESSAGE);

        // Retrieve data from the database and set it in the table
        try {
            Conn cccc = new Conn();
            String searchQuery = "select * from online_user_registration_record where Vehicle_License_Number = '" + LicenseNumber + "'";
            ResultSet newData = cccc.s.executeQuery(searchQuery);
            DataTable.setModel(DbUtils.resultSetToTableModel(newData));

            //ScrollPanel
        ScrollPanel = new JScrollPane(DataTable);
        ScrollPanel.setBounds(15, 95, 530, 600);
        
        
        add(ScrollPanel);
        
        
            DataTable.print(); // Print the JTable
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




    public static void main(String[] args) {
        String a=null, b=null,c=null, d=null, e=null, f=null,g=null;
        new Profile(a, b,c, d, e, f,g);
    }

}


