
package toll_controller_demo_database;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.util.Date;
import java.sql.*;


public class OnlinePayment extends JFrame implements ActionListener {
    JPasswordField passwordField;
    JButton OkButton, ConfirmButton,exit,DeleteButton,UpdateInformation,Profile, PaymentHistory;
    JTextArea BalanceArea;
  //  String LicenseNumber;
    JLabel confirmlabel, pinlabel,success;
    Date date = new Date();
    int Balance;
    int fee;
    String VehicleName, LicenseNumber,TollFee, Password,Pin,Number;
    String vPaymentGateway;


    
  
    public OnlinePayment(String a,String b) {
      //  String UserName=a;
      this.LicenseNumber=a;
      this.Password=b;
    

        
    
   
       // String Password=b;
        //creat new frame
        JFrame frame2 = new JFrame("Smart Toll System");
        frame2.setLayout(null);
        frame2.getContentPane().setBackground(new Color(136, 196, 245));
        frame2.setSize(1000, 600);
        frame2.setLocation(200, 60);
        frame2.setVisible(true);
        frame2.setResizable(false);
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("IMAGES/icon2.png"); 
        // Set the icon image for the JFrame
        frame2.setIconImage(icon.getImage());
        
        //background image
        ImageIcon backgroundImage = new ImageIcon("IMAGES/online_payment_background.png"); 
        JLabel background = new JLabel(backgroundImage);
        frame2.add(background);
        background.setBounds(0, 0, 1000, 600);
        
        //heading
        confirmlabel = new JLabel("Confirm Your Payment ");
        frame2.add(confirmlabel);
        confirmlabel.setBounds(200, 150, 500, 30);
        confirmlabel.setFont(new Font("Arial", Font.BOLD, 30));
        confirmlabel.setForeground(Color.BLACK);
        // ok button
        OkButton = new JButton("OK");
        OkButton.setBounds(530, 153, 100, 30);
        frame2.add(OkButton);
        OkButton.setFont(new Font("serif", Font.BOLD, 25));
        OkButton.setBackground(new Color(1, 55, 125));
        OkButton.setForeground(Color.white);
        OkButton.addActionListener(this);
        //
        
        //Profile
        Profile = new JButton("Profile");
        Profile.setBounds(750, 165, 200, 30);
        frame2.add(Profile);
        Profile.setFont(new Font("serif", Font.BOLD, 20));
        Profile.setBackground(new Color(1, 55, 125));
        Profile.setForeground(Color.white);
        Profile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new Profile(VehicleName, LicenseNumber,TollFee, Password,Pin,Number,vPaymentGateway);
           frame2.setVisible(false);
            }
        });
        //
        //UpdateInformation
        UpdateInformation = new JButton("Update Information");
        UpdateInformation.setBounds(750, 197, 200, 30);
        frame2.add(UpdateInformation);
        UpdateInformation.setFont(new Font("serif", Font.BOLD, 20));
        UpdateInformation.setBackground(new Color(1, 55, 125));
        UpdateInformation.setForeground(Color.white);
        UpdateInformation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UpdateUserInformation(LicenseNumber,Password);
                //new WelcomePage();
                frame2.setVisible(false);
            }
        });
        //

        //Payment History
        PaymentHistory = new JButton("Payment History");
        PaymentHistory.setBounds(750, 229, 200, 30);
        frame2.add(PaymentHistory);
        PaymentHistory.setFont(new Font("serif", Font.BOLD, 20));
        PaymentHistory.setBackground(new Color(1, 55, 125));
        PaymentHistory.setForeground(Color.white);
        PaymentHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // new UpdateUserInformation(LicenseNumber,Password);
               new OnlineUserPaymentHistory(LicenseNumber, Password);
                //new WelcomePage();
                frame2.setVisible(false);
            }
        });
        //
        //DeleteButton
        DeleteButton = new JButton("Delete Account");
        DeleteButton.setBounds(750, 261, 200, 30);
        frame2.add(DeleteButton);
        DeleteButton.setFont(new Font("serif", Font.BOLD, 20));
        DeleteButton.setBackground(new Color(255,36,0));
        DeleteButton.setForeground(Color.white);
        DeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn ccc = new Conn();
                    String deleteQuery = "DELETE FROM online_user_registration_record WHERE Vehicle_License_Number = '" + LicenseNumber + "' AND Password = '" + Password + "'";
                    int rowsAffected = ccc.s.executeUpdate(deleteQuery);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Account Delete Successful");
                        new Welcome();
                //new WelcomePage();
                frame2.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Account not found or deletion failed");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        
        //
        success = new JLabel("Your payment successful.");
        frame2.add(success);
        success.setBounds(350, 200, 500, 30);
        success.setFont(new Font("Arial", Font.BOLD, 30));
        success.setForeground(new Color(34,139,34));
        success.setVisible(false);
        // ok button
        exit = new JButton("Exit");
        exit.setBounds(350, 250, 100, 30);
        frame2.add(exit);
        exit.setFont(new Font("serif", Font.BOLD, 25));
        exit.setBackground(new Color(1, 55, 125));
        exit.setForeground(Color.white);
        exit.setVisible(false);
       exit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });
        //
        //
        pinlabel = new JLabel("Enter your Account PIN: ");
        frame2.add(pinlabel);
        pinlabel.setBounds(190,200,240,30);
        pinlabel.setFont(new Font("serif", Font.BOLD, 20));
        pinlabel.setForeground(Color.BLACK);
        pinlabel.setVisible(false);
        //
        passwordField= new JPasswordField();
        frame2.add(passwordField);
        passwordField.setBounds(415,200,240,30);
        passwordField.setFont(new Font("serif", Font.BOLD, 20));
        passwordField.setEchoChar('1');
       // passwordField.setVisible(true);
        passwordField.setVisible(false);
        //  ConfirmButton
        ConfirmButton = new JButton("Confirm");
        ConfirmButton.setBounds(350, 250, 150, 50);
        frame2.add(ConfirmButton);
        ConfirmButton.setFont(new Font("serif", Font.BOLD, 25));
        ConfirmButton.setBackground(new Color(1, 55, 125));
        ConfirmButton.setForeground(Color.white);
        ConfirmButton.addActionListener(this);
        ConfirmButton.setVisible(false);
        ImageIcon b_backgroundImage = new ImageIcon("IMAGES/Back.png");
        //add back button
        JButton Back = new JButton("< Back",b_backgroundImage);
        Back.setFont(new Font("Arial", Font.BOLD, 20));
        Back.setBounds(0, 0, 85, 25);
        Back.setBackground(new Color(159,126	,219));
        Back.setForeground(Color.white);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               //  new Welcome();
                //new WelcomePage();
                frame2.setVisible(false);

            }
        });
        frame2.add(Back);
        //color button background
       ImageIcon color_background = new ImageIcon("IMAGES/color.png");
        //color button
        JButton c = new JButton("<BG color>",color_background);
        c.setBounds(900, 0, 100, 25);
        c.setBackground(new Color(159,126	,219));
        c.setForeground(Color.white);
        c.setFont(new Font("Arial", Font.BOLD, 12));
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color cc = JColorChooser.showDialog(null, "choose a color", Color.green);
                frame2.getContentPane().setBackground(cc);


            }
        });
        frame2.add(c);


        //
        JLabel userInfo =new JLabel("User Info");
        frame2.add(userInfo);
        userInfo.setBounds(820,45,100,10);
        userInfo.setVisible(true);
        //
        BalanceArea= new JTextArea();
        frame2.add(BalanceArea);
        BalanceArea.setBounds(750,60,200,100);
        BalanceArea.setBackground(new Color(224,255,255));
        BalanceArea.setForeground(Color.black);
        BalanceArea.setVisible(true);
        //
        
        
        try {
            //
            Conn ccc=new Conn();
           // Retrieving data from userregistration where password is 'password'
            String selectQuery = "SELECT * FROM online_user_registration_record WHERE Vehicle_License_Number = '"+LicenseNumber+"' and Password='"+Password+"'";
            ResultSet rs = ccc.s.executeQuery(selectQuery);
            // Inserting retrieved data into the info table in the destination database
            while (rs.next()) {
                // Assuming columns are named similarly in both tables
                //String LicenseNumber = rs.getString("vLicenseNumber");
                this.VehicleName = rs.getString("Vehicle_Name");
                this.TollFee = rs.getString("Toll_Fee");
                fee = Integer.parseInt(TollFee);
                this.vPaymentGateway=rs.getString("payment_Gateway");
                this.Pin=rs.getString("pin");
                this.Number=rs.getString("Account_Number");
                Balance=18000;
                BalanceArea.setText("   License Number: " + LicenseNumber +"\n" +"   Balance:" + Balance + "\n" + "    Account Name: "+vPaymentGateway +"\n"+"    Vehicle Name: "+VehicleName+""+"\n"+"   Payment Status: Processing....");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Balance>=100) {
            if (e.getSource() == OkButton) {
                pinlabel.setVisible(true);
                passwordField.setVisible(true);
                ConfirmButton.setVisible(true);
            } else if (e.getSource() == ConfirmButton) {
                try {
                    

                    int pin = Integer.parseInt(passwordField.getText());
                    //UserConnection c = new UserConnection();
                    Conn c= new Conn();
                    String query = "select * from online_user_registration_record where Pin = '" + pin + "' and Password='"+Password+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        Balance = Balance - fee;
                        BalanceArea.setText("   License Number: " + LicenseNumber+"\n" +"   Balance:" + Balance + "\n" + "    Account Name: "+ vPaymentGateway +" \n"+"    Vehicle Name: "+VehicleName+"\n"+"   Payment Status: Paid");
                        System.out.println();
                        JOptionPane.showMessageDialog(null, "Payment successfully");
                        pinlabel.setVisible(false);
                        passwordField.setVisible(false);
                        ConfirmButton.setVisible(false);
                        OkButton.setVisible(false);
                        confirmlabel.setVisible(false);
                        exit.setVisible(true);
                        success.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid PIN");
                    }
                } catch (Exception ee) {

                }
                try {
                    
                   /* Conn conn = new Conn();
                    String query = "insert into info2 values( 'MotorCycle', 'Gh-123', ' " + date + " ', ' Online ', '100')";
                    conn.s.executeUpdate(query);*/
                    Conn conn=new Conn();
                        String query="insert into collected_toll_record values('"+VehicleName+" ', ' "+ LicenseNumber +" ', ' Online ', '"+TollFee+"','"+date+"')";
                        conn.s.executeUpdate(query);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }

            }
        }
        else{
            JOptionPane.showMessageDialog(null,"You have not sufficient balance","Warning",JOptionPane.ERROR_MESSAGE);
        }

    }
    public static void main(String[] args) {

        String n=null,m=null;
        new OnlinePayment(n,m);
    }


}