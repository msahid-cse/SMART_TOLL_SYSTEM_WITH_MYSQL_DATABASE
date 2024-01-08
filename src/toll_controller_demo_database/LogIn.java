
package toll_controller_demo_database;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LogIn extends JFrame {
   /* Connection conn;
    Statement stm;
    ResultSet rs;
    public void Connect(){
        try{
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3307/login","root","123456789");
            stm=conn.createStatement();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }*/

    private JLabel userLabel,passLabel,adminLogin;
    private JTextField tf;
    private JPasswordField pf;
    private JButton loningButton, clearButton, backButton, bgColor;

    private Container c;
    private Font f;

    LogIn(){

      //  Connect();
      UserConnection conn2 = new UserConnection();
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200,60,1000,600);
        this.setTitle("Smart Toll System");

        ImageIcon icon = new ImageIcon("IMAGES/icon2.png"); 
        // Set the icon image for the JFrame
        this.setIconImage(icon.getImage());
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(208, 189, 244));

        f= new Font("Arial",Font.BOLD,15);

        //ADMIN LOGIN LABEL
        adminLogin =new JLabel("----->User Login<-----");
        adminLogin.setBounds(350, 50, 400, 60);
        adminLogin.setFont(new Font("Arial",Font.BOLD,30));
        c.add(adminLogin);

        //USERNAME LABEL
        userLabel =new JLabel("License Number: ");
        userLabel.setBounds(270,140,150,50);
        userLabel.setFont(f);
        c.add(userLabel);

        //USERNAME TEXT FIELD
        tf=new JTextField();
        tf.setBounds(400,150,240,30);
        tf.setFont(f);
        c.add(tf);

        //PASSWORD LABEL
        passLabel =new JLabel("Password:");
        passLabel.setBounds(270,190,150,50);
        passLabel.setFont(f);
        c.add(passLabel);

        //PASSWORD TEXT FIELD
        pf=new JPasswordField();
        pf.setBounds(400,200,240,30);
        pf.setFont(f);
        pf.setEchoChar('1');
        c.add(pf);

        //LOGIN BUTTON
        loningButton= new JButton("Login");
        loningButton.setBounds(400,250,90,50);
        loningButton.setForeground(Color.white);
        loningButton.setBackground(new Color(159,126	,219));
        loningButton.setFont(f);
        c.add(loningButton);

        //CLEAR BUTTON
        clearButton= new JButton("Clear");
        clearButton.setBounds(550,250,90,50);
        clearButton.setFont(f);
        clearButton.setBackground(new Color(159,126	,219));
        clearButton.setForeground(Color.white);
        c.add(clearButton);

        //add back button
        backButton= new JButton("< Back");
        backButton.setBounds(0,0,100,25);
        backButton.setFont(new Font("Arial",Font.BOLD,15));
        backButton.setBackground(new Color(159,126	,219));
        backButton.setForeground(Color.white);
        c.add(backButton);

        //add back button action
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  dispose();
                //   UserSelectionPage userselectionPage=
                // new UserSelectionPage();
                // userselectionPage.setVisible(true);
                setVisible(false);
            }
        });

        //add bgColor button
        bgColor =new JButton("<BG color>");
        bgColor.setBounds(900,0,100,25);
        bgColor.setFont(new Font("Arial",Font.BOLD,12));
        bgColor.setBackground(new Color(159,126	,219));
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
                String username= tf.getText().toString();
                String password = pf.getText().toString();
                try{
                    Conn conn2 = new Conn();
                    String sql="select * from student where username='"+username+"' and password='"+password+"'";
                   // rs=stm.executeQuery(sql);
                    ResultSet rs=conn2.s.executeQuery(sql);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null,"right username & password");
                      

                    }
                    else {
                        JOptionPane.showMessageDialog(null,"invalid username & password");
                    }
                    
                    
                    
                   /* int i=0;
                    while(rs.next()){
                        i++;
                    }
                    if(i==1) {
                       JOptionPane.showMessageDialog(null, "No");
                     //  System.out.println("Yes");
                    } else{
                        JOptionPane.showMessageDialog(null, "Yes");
                        //System.out.println("N0");
                    }*/
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                   //System.out.println(ex);
                }
            }
        });
    }
    public static void main(String args[]){
        new LogIn();
    }
}

