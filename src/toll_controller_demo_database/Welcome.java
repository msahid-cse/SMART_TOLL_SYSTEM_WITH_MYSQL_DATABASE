package toll_controller_demo_database;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Welcome extends JFrame implements ActionListener{

    Welcome(){
        

        //creat frame
        JFrame f=new JFrame("Smart Toll System");
        f.setLayout(null);
        f.getContentPane().setBackground(new Color(136, 196, 245));
       // f.getContentPane().setBackground(Color.white);
        f.setSize(1000, 600);
        f.setLocation(200, 60);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ImageIcon icon = new ImageIcon("IMAGES/icon2.png"); 
        // Set the icon image for the JFrame
        f.setIconImage(icon.getImage());
        
        

        //heading 01
        JLabel heading = new JLabel("Smart Toll System");
        f.add(heading);
        heading.setBounds(400, 170, 1200, 80);
        heading.setFont(new Font("serif", Font.BOLD, 70));
       // heading.setForeground(new Color( 244	, 236	, 189));
        heading.setForeground(new Color(0, 0, 230));

        // heading 02
        JLabel welcome = new JLabel("Welcome");
        f.add(welcome);
        welcome.setBounds(540, 250, 1200, 80);
        welcome.setFont(new Font("serif", Font.BOLD, 60));
        welcome.setForeground(new Color(77, 121, 255));
      // welcome.setForeground(new Color( 244	, 236	, 189));


      ImageIcon backgroundImage = new ImageIcon("IMAGES/welcome_page_background.png"); // Replace this with your image path
        JLabel background = new JLabel(backgroundImage);
        //background.setLayout(new BorderLayout());
        f.add(background);

        // Set the size of the JLabel to match the JFrame
        background.setBounds(0, 0, 1000, 600);

        //b background image
        
        ImageIcon b_backgroundImage = new ImageIcon("IMAGES/click_here_to_login.png");
       // JLabel b_background = new JLabel(b_backgroundImage);
        

        //click here to login button
        JButton b=new JButton("Click here to Login");
        b.setFont(new Font("Arial", Font.BOLD, 18));
        b.setBounds(570, 350, 200, 40);
        b.setBackground(new Color(1, 55, 125));
        b.setForeground(Color.white);
       // b.setForeground(new Color(255,255,255));
       // b.setLayout(null);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new SelectionPage();
                f.setVisible(false);
            }
        });
        f.add(b);
       // b.add(b_background);

       //color button background
       ImageIcon color_background = new ImageIcon("IMAGES/color.png");
        //bgColor button
        JButton c=new JButton("<color>",color_background);
        c.setBounds(0, 0, 100, 25);
        c.setBackground(new Color(1, 55, 125));
        c.setForeground(Color.white);
        c.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Color cc= JColorChooser.showDialog(null,"choose a color",Color.green);
                f.getContentPane().setBackground(cc);
            }
        });
        f.add(c);

        //developer info button
        JButton developerInfo=new JButton("Developer Info");
        developerInfo.setBounds(880, 0, 120, 25);
        developerInfo.setBackground(new Color(1, 55, 125));
        developerInfo.setForeground(Color.white);
        developerInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new DeveloperInformation();
                f.setVisible(false);


            }
        });
        f.add(developerInfo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new Welcome();
    }
}