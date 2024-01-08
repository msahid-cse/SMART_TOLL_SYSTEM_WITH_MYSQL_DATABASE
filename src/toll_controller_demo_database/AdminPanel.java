
package toll_controller_demo_database;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AdminPanel extends JFrame implements ActionListener{
    AdminPanel(){

        //create new frame
        JFrame frame3=new JFrame("Smart Toll System");
        frame3.setLayout(null);
        frame3.getContentPane().setBackground(new Color(136, 196, 245));
        frame3.setSize(1000, 600);
        frame3.setLocation(200, 60);
        frame3.setVisible(true);
        frame3.setResizable(false);
        frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("IMAGES/icon2.png"); 
        // Set the icon image for the JFrame
        frame3.setIconImage(icon.getImage());
        
        //background image
        ImageIcon backgroundImage = new ImageIcon("IMAGES/admin_panel_background.png"); 
        JLabel background = new JLabel(backgroundImage);
        frame3.add(background);
        background.setBounds(0, 0, 1000, 600);

        //color button background
       ImageIcon color_background = new ImageIcon("IMAGES/color.png");
        //add color button
        JButton c=new JButton("<BG color>",color_background);
        c.setBounds(900, 0, 100, 20);
        c.setFont(new Font("Arial", Font.BOLD, 12));
        c.setBackground(new Color(1, 55, 125));
        c.setForeground(Color.white);
        c.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Color cc= JColorChooser.showDialog(null,"choose a color",Color.green);
                frame3.getContentPane().setBackground(cc);
            }
        });
        frame3.add(c);

        //add back button
        ImageIcon b_backgroundImage = new ImageIcon("IMAGES/Back.png");
        JButton Back = new JButton("< Back",b_backgroundImage);
        Back.setFont(new Font("Arial", Font.BOLD, 20));
        Back.setBounds(0, 0, 85, 25);
        Back.setBackground(new Color(1, 55, 125));
        Back.setForeground(Color.white);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectionPage();
                frame3.setVisible(false);

            }
        });
        frame3.add(Back);

        //heading 01
        JLabel heading = new JLabel("----->Admin Panel<-----");
        frame3.add(heading);
        heading.setBounds(150, 100, 400, 60);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(Color.black);

        //collect toll button
        JButton payment=new JButton("Collect Toll");
        payment.setFont(new Font("serif", Font.BOLD, 20));
        payment.setBounds(200, 170, 230, 50);
        payment.setBackground(new Color(1, 55, 125));
        payment.setForeground(Color.white);
        payment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //   new OfflinePayment();
                new CashPayment();
                //new WelcomePage();
                frame3.setVisible(false);

            }
        });
        frame3.add(payment);

        //More button

        JButton more=new JButton("More...");
        more.setFont(new Font("serif", Font.BOLD, 20));
        more.setBounds(200, 230, 230, 50);
        more.setBackground(new Color(1, 55, 125));
        more.setForeground(Color.white);
        more.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new MoreOption();
//                new WelcomePage();
                frame3.setVisible(false);

            }
        });
        frame3.add(more);





    }

    public static void main(String args[]){
        AdminPanel frame= new AdminPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
