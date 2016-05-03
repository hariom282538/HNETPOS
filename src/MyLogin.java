import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;
import javax.swing.border.*;
public class MyLogin extends JFrame {

GetImage getI;


public static JPanel panel0;
public static JPanel panel1;
public static JPanel panel2;
public static JPanel panel3;
public static JPanel panel4;
public static JPanel panel5;

public JButton btnLogin;
public JButton btnExit;

public JLabel lblName;
//public JLabel lblTrain;
public JLabel lblUser;
public JLabel lblPass;

public static JTextField txtUsername;
public static JPasswordField txtPassword;

int dialogtype =JOptionPane.PLAIN_MESSAGE;
String dialogmessage;
String dialogs;
	
Cursor cursor;
	
Connection con;
Statement stmt;
ResultSet rs;
	
Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

public MyLogin(){
super("HNET POS USER LOGIN");

getI=new GetImage();
panel0=new JPanel();
panel0.setLayout(new FlowLayout());
lblName=new JLabel("WELCOME AT HNET POS");
//lblTrain=new JLabel("",new ImageIcon(getI.getImage("i/t.jpg")),0);

panel1 =new JPanel();
panel1.setLayout(new FlowLayout(0));


lblUser=new JLabel("Username :");
lblPass=new JLabel("Password : ");
txtUsername=new JTextField(15);
txtPassword=new JPasswordField(15);

panel2=new JPanel();
panel2.setLayout(new FlowLayout(0));

panel3 =new JPanel();
panel3.setLayout(new FlowLayout(0));

panel4=new JPanel();
panel4.setLayout(new BoxLayout(panel4,BoxLayout.Y_AXIS));


panel5=new JPanel();
panel5.setLayout(new FlowLayout(0));

ImageIcon ilogin=new ImageIcon(getI.getImage("i/seeranlogin.jpg"));

cursor=new Cursor(12);
btnLogin=new JButton("Login",new ImageIcon(getI.getImage("i/key.jpg")));
btnLogin.setCursor(cursor);
btnLogin.setPreferredSize(new Dimension(120,50));
btnLogin.setRolloverSelectedIcon(new ImageIcon(getI.getImage("i/o.jpg")));
btnExit=new JButton("Exit",new ImageIcon(getI.getImage("i/lock.jpg")));
btnExit.setCursor(cursor);
btnExit.setPreferredSize(new Dimension(120,50));
//btnLogin.addActionListener(this);
//btnExit.addActionListener(this);

//panel0.add(lblTrain);
panel0.add(lblName);
panel0.setBackground(new Color(0,153,204));
panel0.setOpaque(true);

panel1.add(lblUser);
panel1.add(txtUsername);
panel1.setBackground(new Color(0,153,204));
panel1.setOpaque(true);
//panel1.setBorder(new LineBorder(Color.BLACK));

panel2.add(lblPass);
panel2.add(txtPassword);
panel2.setBackground(new Color(0,153,204));
panel2.setOpaque(true);
//panel2.setBorder(new LineBorder(Color.BLACK));

panel3.add(btnLogin);
panel3.add(btnExit);
panel3.setBackground(new Color(0,153,204));
panel3.setOpaque(true);

panel4.add(panel0);
panel4.add(panel1);
panel4.add(panel2);
panel4.add(panel3);
//panel4.setBackground(Color.BLACK);
panel4.setOpaque(true);
panel4.setBackground(Color.GREEN);
//panel4.setPreferredSize(new Dimension(300,300));
JButton jblogin=new JButton("",ilogin);
//jblogin.setEnabled(false);
//panel5.add(jblogin);
panel5.setBackground(Color.WHITE);
//panel5.setOpaque(true);
ImageIcon imh = new ImageIcon(getI.getImage("i/seeranlogin.jpg"));
  JPanel panel6 = new JPanel()
        {
            public void paintComponent(Graphics g) 
            {
                Image img = new ImageIcon(getI.getImage("i/seeranlogin.jpg")).getImage();
               		   //Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
			   Dimension size = new Dimension(250,250);
                setPreferredSize(size);
                setMinimumSize(size);
                setMaximumSize(size);
               // setSize(size);
                setLayout(new GridLayout(1,1));
               g.drawImage(img, 0, 0,250,250,null);
            } 
        };
		
		JLabel image= new JLabel(imh);
		//panel6.setSize(250,250);
		panel6.setBorder(new EtchedBorder());
		panel5.setBorder(new EtchedBorder());
//setSize(270,205);
//setMaximumSize(new Dimension(500,500));
Container pane=getContentPane();
//panel5.setBackground(new Color(0,153,204));
panel5.setLayout(new FlowLayout(0));
//pane.setLayout(new BoxLayout(pane,BoxLayout.X_AXIS));
//pane.setLayout(new GridLayout(1,2));
pane.setLayout(new FlowLayout(0));
//pane.setBackground(Color.GREEN);
pane.setBackground(new Color(0,153,204));
//pane.add(panel6);
//panel5.add(panel6);
JPanel panel7 =new JPanel();
//panel5.add(panel4);
panel5.add(panel4);
panel7.add(image);
pane.add(panel7);
pane.add(panel5);
setLocation((screen.width-500)/2,((screen.height-350)/2));
//setVisible(true);
//setResizable(false);

getRootPane().setDefaultButton(btnLogin);
//setIconImage(new ImageIcon(getI.getImage("i/k.jpg")).getImage());
setIconImage(new ImageIcon(getI.getImage("i/icone.jpg")).getImage());
pack();
//setSize(500,300);

txtUsername.setText("admin");
txtPassword.setText("admin");

addWindowListener(new BasicWindowMonitor());

}

 
 

}