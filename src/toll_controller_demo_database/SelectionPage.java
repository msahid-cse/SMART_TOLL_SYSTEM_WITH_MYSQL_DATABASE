
package toll_controller_demo_database;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectionPage extends JFrame implements ActionListener {

    public SelectionPage() {
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
        //background image add
        ImageIcon backgroundImage = new ImageIcon("IMAGES/selection_page_background.png"); 
        JLabel background = new JLabel(backgroundImage);
        frame2.add(background);
        background.setBounds(0, 0, 1000, 600);

        //heading
        JLabel heading = new JLabel("Login");
        frame2.add(heading);
        heading.setBounds(350, 70, 1200, 150);
        heading.setFont(new Font("Arial", Font.BOLD, 100));
        heading.setForeground(new Color(65,105,225));


        //add back button
        ImageIcon b_backgroundImage = new ImageIcon("IMAGES/Back.png");
        //add back button
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

        //selection Button
        // for admin
        JButton adminLogin = new JButton("As Admin");
        adminLogin.setBounds(400, 250, 200, 50);
        frame2.add(adminLogin);
        adminLogin.setFont(new Font("serif", Font.BOLD, 20));
       // adminLogin.setBackground(new Color(0,128,128));
        adminLogin.setBackground(new Color(1, 55, 125));

        adminLogin.setForeground(Color.white);
        adminLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LoginFrame loginFrame =
                 new LoginFrame();
               // loginFrame.setVisible(true);
                frame2.setVisible(false);

            }
        });

        //for User Login
        JButton UserLogin = new JButton("As Normal User");
        UserLogin.setBounds(400, 310, 200, 50);
        frame2.add(UserLogin);
        UserLogin.setFont(new Font("serif", Font.BOLD, 20));
      //  UserLogin.setBackground(new Color(0,139,139));
        UserLogin.setBackground(new Color(1, 55, 125));
        UserLogin.setForeground(Color.white);
        UserLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // UserSelectionPage userSelectionPage=
                new UserSelectionPage();
                //userSelectionPage.setVisible(true);
                frame2.setVisible(false);
            }
        });

        //color button background
       ImageIcon color_background = new ImageIcon("IMAGES/color.png");
        //color button
        JButton c = new JButton("<BG color>",color_background);
        c.setBounds(900, 0, 100, 25);
        //new Color(0,139,139)
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
    }

    public static void main(String[] args) {
        new SelectionPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
