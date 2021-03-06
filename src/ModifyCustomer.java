import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;
import javax.swing.JComboBox.*;

public class ModifyCustomer extends JFrame {

JPanel panel0;
JPanel panel1;
JPanel panel2;
JPanel panel3;
JPanel panel4;
JPanel panel5;
JPanel panel6;
JPanel panel7;
JPanel panel8;


JLabel lblFirstName;
JLabel lblLastName;
JLabel lblAddress;
JLabel lblArea;
JLabel lblState;
JLabel lblPin;
JLabel lblPhone;
JLabel lblEmail;
JLabel lblCompany;


JTextField txtFirstName;
JTextField txtLastName;
JTextField txtArea;
JTextField txtPin;
JTextField txtPhone;
JTextField txtEmail;
JTextField txtCompany;


JComboBox jcbState;


JButton btnSave;
JButton btnClear;
JButton btnCancel;
JTextArea txtaAddress;

JCheckBox jchFirstName;
JCheckBox jchLastName;
JCheckBox jchArea;
JCheckBox jchAddress;
JCheckBox jchPhone;
JCheckBox jchEmail;
JCheckBox jchCompany;
JCheckBox jchPin;


GetImage getI;


JScrollPane jspAddress;
Object[] objState;



public ModifyCustomer(){

super("Modify Customer");
getI=new GetImage();
panel0=new JPanel();
panel1=new JPanel();
panel2=new JPanel();
panel3=new JPanel();
panel4=new JPanel();
panel5=new JPanel();
panel6=new JPanel();
panel7=new JPanel();
panel8=new JPanel();

btnSave=new JButton("Save");

btnCancel=new JButton("Cancel");


panel0.setLayout(new BoxLayout(panel0,BoxLayout.Y_AXIS));
panel1.setLayout(new FlowLayout(0));
panel2.setLayout(new GridLayout(2,1));
panel3.setLayout(new FlowLayout(0));
panel4.setLayout(new FlowLayout(0));
panel5.setLayout(new GridLayout(2,1));
panel6.setLayout(new FlowLayout(0));
panel7.setLayout(new FlowLayout(0));
panel8.setLayout(new FlowLayout(4));

lblFirstName=new JLabel("First Name :");
lblLastName=new JLabel("   Last Name :");
lblState=new JLabel("State :");
lblAddress=new JLabel("Address :");
lblArea=new JLabel("Area :");
lblPin=new JLabel("Pincode :");
lblEmail=new JLabel("   Email : ");
lblPhone=new JLabel("Phone : ");
lblCompany=new JLabel("   Company :");


txtFirstName=new JTextField(10);
txtLastName=new JTextField(10);
txtArea=new JTextField(10);
txtPin=new JTextField(10);
txtEmail=new JTextField(10);
txtPhone=new JTextField(10);
txtCompany=new JTextField(10);

txtFirstName.setEnabled(false);
txtLastName.setEnabled(false);
txtArea.setEnabled(false);
txtPin.setEnabled(false);
txtEmail.setEnabled(false);
txtPhone.setEnabled(false);
txtCompany.setEnabled(false);


objState=new Object[] {"Andaman Nicobar","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chattisgarh","Dadar And Nagar Haveli","Daman & Diu","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu And Kashmir","Jharkhand","Karnataka","Kerala","Lakshwdeep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","New Delhi","Orissa","Pondicherry","Punjab","Rajasthan","Sikkim","Tamil Nadu","Tripura","Uttar Pradesh","Uttaranchal","West Bengal"};





jcbState=new JComboBox(objState);


txtaAddress=new JTextArea(2,20);
txtaAddress.setEnabled(false);
 jchFirstName =new JCheckBox();
 jchLastName =new JCheckBox();
 jchArea =new JCheckBox();
 jchAddress =new JCheckBox();
 jchPhone =new JCheckBox();
 jchEmail =new JCheckBox();
 jchCompany =new JCheckBox();
 jchPin =new JCheckBox();



panel1.add(lblFirstName);
panel1.add(txtFirstName);
panel1.add(jchFirstName);
panel1.add(lblLastName);
panel1.add(txtLastName);
panel1.add(jchLastName);


panel3.add(lblState);
panel3.add(jcbState);
panel3.add(lblArea);
panel3.add(txtArea);
panel3.add(jchArea);

jspAddress=new JScrollPane(txtaAddress,22,30);


panel4.add(lblAddress);
panel4.add(jspAddress);
panel4.add(jchAddress);


panel6.add(lblPhone);
panel6.add(txtPhone);
panel6.add(jchPhone);
panel6.add(lblEmail);
panel6.add(txtEmail);
panel6.add(jchEmail);

panel7.add(lblCompany);
panel7.add(txtCompany);
panel7.add(jchCompany);
panel7.add(lblPin);
panel7.add(txtPin);
panel7.add(jchPin);

panel8.add(btnSave);

panel8.add(btnCancel);


panel0.setBorder(new TitledBorder(new LineBorder(Color.blue,2),"Modify Customer ",0,1,new Font("Serif", Font.BOLD,15)));
panel1.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Name ",0,1,new Font("Serif", Font.BOLD,15)));
panel2.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Location ",0,1,new Font("Serif", Font.BOLD,15)));
panel5.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Contact ",0,1,new Font("Serif", Font.BOLD,15)));


panel2.add(panel3);
panel2.add(panel4);


panel5.add(panel6);
panel5.add(panel7);


panel0.add(panel1);
panel0.add(panel2);
panel0.add(panel5);
panel0.add(panel8);




Container c=getContentPane();
c.add(panel0);

//addWindowListener(new BasicWindowMonitor2());
setIconImage(new ImageIcon(getI.getImage("i/k.jpg")).getImage());
setVisible(true);
setLocation(300,100);
pack();
}

public static void main(String a[])
{
try {

UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}
catch(Exception e)
{

}  
ModifyCustomer mc=new ModifyCustomer();
}


}