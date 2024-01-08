
package toll_controller_demo_database;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.awt.event.*;

public class DeveloperInformation extends JFrame implements ActionListener {
    

    public DeveloperInformation() {
        
  
       
   
        
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
        //jlabel
        JLabel userLabel = new JLabel("Any Suggestion or Feedback: ");
        userLabel.setBounds(20, 485, 260, 50);
        userLabel.setFont(new Font("serif", Font.BOLD, 20));
        userLabel.setForeground(Color.WHITE); // Set font color to white
        frame2.add(userLabel);
 
         // Load the background image
        //background image add
        ImageIcon backgroundImage = new ImageIcon("IMAGES/devoback.png"); 
        JLabel background = new JLabel(backgroundImage);
        frame2.add(background);
        background.setBounds(0, 0, 1000, 600);

        /*
        l1: Developed by,
        l2: Md. Sahid
        l3: ID: 221902057
        l4: Department: Computer Science and Engineering
        l5: Green University of Bangladesh
        l6: Email: msahid.cse@gmail.com  ||  Phone: 01407531529
         */

        //developer label
        JLabel l1 = new JLabel("Developed By, ");
        frame2.add(l1);
        l1.setBounds(50, 55, 200, 25);
        l1.setFont(new Font("serif", Font.BOLD, 25));
        l1.setForeground(Color.BLACK);
        //label
        JLabel l2 = new JLabel("Md. Sahid");
        frame2.add(l2);
        l2.setBounds(50, 90, 200, 15);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        l2.setForeground(Color.BLACK);
        //label
        JLabel l3 = new JLabel("ID: 221902057 ");
        frame2.add(l1);
        l3.setBounds(50, 90, 500, 20);
        l3.setFont(new Font("serif", Font.BOLD, 15));
        l3.setForeground(Color.BLACK);
        //label
        JLabel l4 = new JLabel("Department: Computer Science and Engineering");
        frame2.add(l4);
        l4.setBounds(50, 110, 500, 20);
        l4.setFont(new Font("serif", Font.BOLD, 15));
        l4.setForeground(Color.BLACK);
        //label
        JLabel l5 = new JLabel("Green University of Bangladesh ");
        frame2.add(l5);
        l5.setBounds(50, 130, 500, 20);
        l5.setFont(new Font("serif", Font.BOLD, 15));
        l5.setForeground(Color.BLACK);
        //label
        JLabel l6 = new JLabel("Email: msahid.cse@gmail.com  ||  Phone: 01407531529");
        frame2.add(l6);
        l6.setBounds(50, 150, 500, 20);
        l6.setFont(new Font("serif", Font.BOLD, 15));
        l6.setForeground(Color.BLACK);

        /*
        l7: Instructed by,
        l8: Sharifur Rahman
        l9: Lecturer, Department of CSE
        l10: Green University of Bangladesh
        */
        //Instructor label
        JLabel l7 = new JLabel("Instructed by, ");
        frame2.add(l7);
        l7.setBounds(50, 200, 200, 25);
        l7.setFont(new Font("serif", Font.BOLD, 25));
        l7.setForeground(Color.BLACK);
        //label
        JLabel l8 = new JLabel("Sharifur Rahman");
        frame2.add(l8);
        l8.setBounds(50, 235, 200, 20);
        l8.setFont(new Font("serif", Font.BOLD, 20));
        l8.setForeground(Color.BLACK);
        //label
        JLabel l9 = new JLabel("Lecturer, Department of CSE");
        frame2.add(l9);
        l9.setBounds(50, 260, 500, 20);
        l9.setFont(new Font("serif", Font.BOLD, 15));
        l9.setForeground(Color.BLACK);
        //label
        JLabel l10 = new JLabel("Green University of Bangladesh");
        frame2.add(l10);
        l10.setBounds(50, 280, 500, 20);
        l10.setFont(new Font("serif", Font.BOLD, 15));
        l10.setForeground(Color.BLACK);



        //add back button
        ImageIcon b_backgroundImage = new ImageIcon("IMAGES/Back.png");
        JButton Back = new JButton("< Back",b_backgroundImage);
        Back.setFont(new Font("Arial", Font.BOLD, 20));
        Back.setBounds(0, 0, 85, 25);
        Back.setBackground(new Color(1, 55, 125));
        Back.setForeground(Color.white);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Welcome();
                frame2.setVisible(false);

            }
        });
        frame2.add(Back);


        //color button background
       ImageIcon color_background = new ImageIcon("IMAGES/color.png");
        //color button
        JButton c = new JButton("<BG color>",color_background);
        c.setBounds(900, 0, 100, 25);
        c.setBackground(new Color(1, 55, 125));
        c.setForeground(Color.white);
        c.setFont(new Font("Arial", Font.BOLD, 12));

        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color cc = JColorChooser.showDialog(null, "choose a color", Color.green);
                frame2.getContentPane().setBackground(cc);


            }
        });
        frame2.add(c);

        ////
        // ... (previous code)



// ... (rest of your code)


        //USERNAME TEXT FIELD
        JTextField tf=new JTextField();
        tf.setBounds(280,500,480,30);
        tf.setFont(new Font("serif", Font.BOLD, 20));
        frame2.add(tf);
      //  String comment= tf.getText();
        //System.out.println(comment);

        //LOGIN BUTTON
       JButton sendButton= new JButton("Send");
        sendButton.setBounds(870,500,90,30);
        sendButton.setForeground(Color.white);
        sendButton.setBackground(new Color(1, 55, 125));
        sendButton.setFont(new Font("serif", Font.BOLD, 20));
        frame2.add(sendButton);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String comment=tf.getText().toString();
                
                
                try{
                        Conn conn=new Conn();
                        String query="insert into feedback_suggestion values('"+comment+"')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"your Suggestion/Feedback send Successful");
                        tf.setText(" ");
                    }
                    catch (Exception ee){
                        ee.printStackTrace();
                    }
            }
        });

        
        //CLEAR BUTTON
       JButton clearButton= new JButton("Clear");
        clearButton.setBounds(770,500,90,30);
        clearButton.setFont(new Font("serif", Font.BOLD, 20));
        clearButton.setBackground(new Color(1, 55, 125));
        clearButton.setForeground(Color.white);
        frame2.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText(" ");
            }
        });

    }

    public static void main(String[] args) {
        new DeveloperInformation();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
