
package toll_controller_demo_database;
import com.sun.jdi.PathSearchingVirtualMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LoginFrame extends JFrame {

    private JLabel userLabel,passLabel,adminLogin;
    private JTextField tf;
    private JPasswordField pf;
    private JButton loningButton, clearButton, backButton, bgColor;

    private Container c;
    private Font f;

    LoginFrame(){
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200,60,1000,600);
        this.setTitle("Smart TOll System");

        ImageIcon icon = new ImageIcon("IMAGES/icon2.png"); 
        // Set the icon image for the JFrame
        this.setIconImage(icon.getImage());
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(136, 196, 245));

        f= new Font("Arial",Font.BOLD,20);
        
        //background image
        ImageIcon backgroundImage = new ImageIcon("IMAGES/login_frame_background1.png"); 
        JLabel background = new JLabel(backgroundImage);
        this.add(background);
        background.setBounds(0, 0, 1000, 600);

        //ADMIN LOGIN LABEL
        adminLogin =new JLabel("ADMIN LOGIN");
        adminLogin.setBounds(200, 120, 400, 60);
        adminLogin.setFont(new Font("Arial",Font.BOLD,30));
        c.add(adminLogin);

        //USERNAME LABEL
        userLabel =new JLabel("User Name:");
        userLabel.setBounds(87,190,150,50);
        userLabel.setFont(f);
        c.add(userLabel);

        //USERNAME TEXT FIELD
        tf=new JTextField();
        tf.setBounds(200,200,240,30);
        tf.setFont(f);
        c.add(tf);

        //PASSWORD LABEL
        passLabel =new JLabel("Password:");
        passLabel.setBounds(96,240,150,50);
        passLabel.setFont(f);
        c.add(passLabel);

        //PASSWORD TEXT FIELD
        pf=new JPasswordField();
        pf.setBounds(200,250,240,30);
        pf.setFont(f);
        pf.setEchoChar('1');
        c.add(pf);

        //LOGIN BUTTON
        loningButton= new JButton("Login");
        loningButton.setBounds(200,300,90,50);
        loningButton.setForeground(Color.white);
        loningButton.setBackground(new Color(1, 55, 125));
        loningButton.setFont(f);
        c.add(loningButton);

        //CLEAR BUTTON
        clearButton= new JButton("Clear");
        clearButton.setBounds(350,300,90,50);
        clearButton.setFont(f);
        clearButton.setBackground(new Color(1, 55, 125));
        clearButton.setForeground(Color.white);
        c.add(clearButton);

        //add back button
        ImageIcon b_backgroundImage = new ImageIcon("IMAGES/Back.png");
        //add back button
        backButton= new JButton("< Back",b_backgroundImage);
        backButton.setBounds(0,0,85,25);
        backButton.setFont(new Font("Arial",Font.BOLD,15));
        backButton.setBackground(new Color(1, 55, 125));
        backButton.setForeground(Color.white);
        c.add(backButton);

        //add back button action
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // SelectionPage selectionPage=
                new SelectionPage();
               // selectionPage.setVisible(true);
                setVisible(false);
            }
        });

        //color button background
       ImageIcon color_background = new ImageIcon("IMAGES/color.png");
        //add bgColor button
        bgColor =new JButton("<BG color>",color_background);
        bgColor.setBounds(900,0,100,25);
        bgColor.setFont(new Font("Arial",Font.BOLD,12));
        bgColor.setBackground(new Color(1, 55, 125));
        bgColor.setForeground(Color.white);
        c.add(bgColor);

        //add bgColor action
        bgColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color cc= JColorChooser.showDialog(null,"choose a color",Color.green);
                c.setBackground(cc);
            }
        });

        //add clear action
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("");
                pf.setText("");
            }
        });


        //add login action
        loningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username= tf.getText();
                    String password = pf.getText();
                    Conn c=new Conn();
                    String query="select * from Admin_Login where User_Name = '"+username+"' and Password = '"+password+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    if(rs.next()){
                    new AdminPanel();
                    setVisible(false);
                    }
                    else {
                    JOptionPane.showMessageDialog(null,"invalid username & password");
                    }
                }
                catch (Exception ee){
                }
            }
        });
    }
    public static void main(String args[]){
        LoginFrame Frame6 = new LoginFrame();


    }
}
