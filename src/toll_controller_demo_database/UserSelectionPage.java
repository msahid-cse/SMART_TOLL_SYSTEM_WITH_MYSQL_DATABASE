package toll_controller_demo_database;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserSelectionPage extends JFrame implements ActionListener {

    public UserSelectionPage() {
        
        
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
        ImageIcon backgroundImage = new ImageIcon("IMAGES/admin_panel_background.png"); 
        JLabel background = new JLabel(backgroundImage);
        frame2.add(background);
        background.setBounds(0, 0, 1000, 600);
        
        //heading
        JLabel heading = new JLabel("User Panel");
        frame2.add(heading);
        heading.setBounds(100, 50, 1200, 150);
        heading.setFont(new Font("Arial", Font.BOLD, 60));
        heading.setForeground(Color.BLACK);

       // Load the background image
ImageIcon b_backgroundImage = new ImageIcon("IMAGES/Back.png");

// Create the button and set the background image as its icon
JButton Back = new JButton("< Back", b_backgroundImage);
Back.setFont(new Font("Arial", Font.BOLD, 20));
Back.setBounds(0, 0, 85, 25);
Back.setBackground(new Color(159, 126, 219));
Back.setForeground(Color.white);
Back.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Perform action on button click
        // new WelcomePage();
        // new WelcomePage();
        new SelectionPage();
        frame2.setVisible(false);
    }
});
frame2.add(Back);


        //selection Button
        // UserLogin
        JButton UserLogin = new JButton("LOGIN");
        UserLogin.setBounds(150, 180, 200, 50);
        frame2.add(UserLogin);
        UserLogin.setFont(new Font("serif", Font.BOLD, 20));
        UserLogin.setBackground(new Color(1, 55, 125));
        UserLogin.setForeground(Color.white);
        UserLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // UserLogin userLogin =
                        new UserLogin();
                //userLogin.setVisible(true);
                frame2.setVisible(false);

            }
        });

        //User Registration
        JButton UserRegistration = new JButton("REGISTRATION");
        UserRegistration.setBounds(150, 240, 200, 50);
        frame2.add(UserRegistration);
        UserRegistration.setFont(new Font("serif", Font.BOLD, 20));
        UserRegistration.setBackground(new Color(1, 55, 125));
        UserRegistration.setForeground(Color.white);
        UserRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // UserRegistration userRegistration=
                 new UserRegistration();
              //  userRegistration.setVisible(true);
                frame2.setVisible(false);
            }
        });

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
    }

    public static void main(String[] args) {
        new UserSelectionPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
