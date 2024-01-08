
package toll_controller_demo_database;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class UpdateUserInformation extends JFrame implements ActionListener {

    UserConnection conn=new UserConnection();
    JTextField  textFieldAccount_Pin, textFieldAccount_Number, textFieldTollFee,textFieldConfirmPasswor, textFieldLicenseNumber,textFieldUser, textFieldPassword;
    JComboBox textFieldVehicleName,Payment_Gateway_List;
    JButton SaveButton,BackButton;
    String vLicenseNumber, vPassword;



    UpdateUserInformation(String LicenseNumber, String Password1){
        this.vLicenseNumber=LicenseNumber;
        this.vPassword=Password1;
        getContentPane().setBackground(new Color(136, 196, 245));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Smart Toll System");
        ImageIcon icon = new ImageIcon("IMAGES/icon2.png"); 
        // Set the icon image for the JFrame
        setIconImage(icon.getImage());

        //background image
        ImageIcon backgroundImage = new ImageIcon("IMAGES/login_frame_background.png"); 
        JLabel background = new JLabel(backgroundImage);
        this.add(background);
        background.setBounds(0, 0, 1000, 600);

        //heading
        JLabel heading = new JLabel("Update User Information");
        add(heading);
        heading.setBounds(330, 20, 900, 60);
        heading.setFont(new Font("serif", Font.BOLD, 40));
        heading.setForeground(Color.BLACK);

        //Password
        JLabel Password = new JLabel("New Password:");
        Password.setBounds(30, 190, 200, 20 );
        add(Password);
        Password.setFont(new Font("serif", Font.BOLD, 20));

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(237, 193, 250,20);
        add(textFieldPassword);

        JLabel Payment_Gateway = new JLabel("New Payment Gateway:");
        Payment_Gateway.setBounds(30, 220, 230, 20 );
        add(Payment_Gateway);
        Payment_Gateway.setFont(new Font("serif", Font.BOLD, 20));

        String gateway_name[] = {"BKash", "Nogod","Rocket","MCash","SureCash","Upay","Trust Axiata Pay (Tap)"};
        Payment_Gateway_List = new JComboBox(gateway_name);
        Payment_Gateway_List.setBounds(237, 223, 250,20);
        add(Payment_Gateway_List);

        //UserName
        JLabel Account_Number = new JLabel("New Account Number:");
        Account_Number.setBounds(30, 250, 200, 20 );
        add(Account_Number);
        Account_Number.setFont(new Font("serif", Font.BOLD, 20));

        textFieldAccount_Number = new JTextField();
        textFieldAccount_Number.setBounds(237, 253, 250,20);
        add(textFieldAccount_Number);

        //pin
        JLabel Account_Pin = new JLabel("Account PIN:");
        Account_Pin.setBounds(30, 280, 200, 20 );
        add(Account_Pin);
        Account_Pin.setFont(new Font("serif", Font.BOLD, 20));

        textFieldAccount_Pin = new JTextField();
        textFieldAccount_Pin.setBounds(237, 283, 250,20);
        add(textFieldAccount_Pin);


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
        SaveButton = new JButton(" SAVE ");
        SaveButton.setBounds(350, 350, 150, 30);
        add(SaveButton);
        SaveButton.setFont(new Font("serif", Font.BOLD, 20));
        SaveButton.setBackground(new Color(1, 55, 125));
        SaveButton.setForeground(Color.WHITE);
        SaveButton.addActionListener(this);                  // action


        //Back Button
        BackButton = new JButton(" BACK ");
        BackButton.setBounds(180, 350, 150, 30);
        add(BackButton);
        BackButton.setFont(new Font("serif", Font.BOLD, 20));
        BackButton.setBackground(new Color(1, 55, 125));
        BackButton.setForeground(Color.WHITE);
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserSelectionPage();
                setVisible(false);
            }
        });                // action


        //fream
        setSize(1000, 600);
        setLocation(200, 60);
        setVisible(true);

    }


    @Override
    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == SaveButton){
           // String vName = textFieldVehicleName.getText();
           // String Name = (String)textFieldVehicleName.getSelectedItem();
         //   String vLicenseNumber = /*Integer.parseInt*/(String)textFieldLicenseNumber.getText();
          //  int vTollFee = Integer.parseInt(textFieldTollFee.getText());
            String NewAccountNumber = textFieldAccount_Number.getText();
            String vNewPassword = textFieldPassword.getText() ;
            String Newpayment_gateway = (String)Payment_Gateway_List.getSelectedItem();
            int pin= Integer.parseInt(textFieldAccount_Pin.getText());


            try {
                Conn conn=new Conn();              
                String updateQuery = "UPDATE online_user_registration_record SET Password = '"+vNewPassword+"', Payment_Gateway = '"+Newpayment_gateway+"', Account_Number = '"+NewAccountNumber+"', Pin = '"+pin+"' WHERE Vehicle_License_Number = '"+vLicenseNumber+"'";
                conn.s.executeUpdate(updateQuery);
                JOptionPane.showMessageDialog(null,"Upate successfully");
                setVisible(false);
               // new Welcome();
               new UserLogin();
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            //   new AdminPanel();
        }
    }


    public static void main(String args[]) {
        String a=null,b=null;
        new UpdateUserInformation(a,b);

    }

}


