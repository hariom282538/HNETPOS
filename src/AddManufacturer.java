import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;
import javax.swing.JComboBox.*;

public class AddManufacturer extends JPanel{

JPanel panel0;
JPanel panel1;
JPanel panel2;
JPanel panel3;
JPanel panel4;
JPanel panel5;
JPanel panel6;
JPanel panel7;
JPanel panel8;


JLabel lblManufacturerName;
JLabel lblAddress;
JLabel lblArea;
JLabel lblState;
JLabel lblPin;
JLabel lblPhone;
JLabel lblEmail;
JLabel lblVat;



JTextField txtName;
JTextField txtVat;
JTextField txtArea;
JTextField txtPin;
JTextField txtPhone;
JTextField txtEmail;



JComboBox jcbState;


JButton btnSave;
JButton btnClear;
JButton btnCancel;


JTextArea txtaAddress;

JScrollPane jspAddress;

Object[] objState;

public AddManufacturer(){

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
btnClear=new JButton("Clear");
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

lblManufacturerName=new JLabel("Manufacturer Name :");
lblVat=new JLabel("Vat% :");
lblState=new JLabel("State :");
lblAddress=new JLabel("Address :");
lblArea=new JLabel("Area :");
lblPin=new JLabel("Pincode :");
lblEmail=new JLabel("Email :  ");
lblPhone=new JLabel("Phone :   ");



txtName=new JTextField(10);
txtVat=new JTextField(10);
txtArea=new JTextField(10);
txtPin=new JTextField(10);
txtEmail=new JTextField(10);
txtPhone=new JTextField(10);

objState=new Object[] {"Andaman Nicobar","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chattisgarh","Dadar And Nagar Haveli","Daman & Diu","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu And Kashmir","Jharkhand","Karnataka","Kerala","Lakshwdeep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","New Delhi","Orissa","Pondicherry","Punjab","Rajasthan","Sikkim","Tamil Nadu","Tripura","Uttar Pradesh","Uttaranchal","West Bengal"};



jcbState=new JComboBox(objState);


txtaAddress=new JTextArea(2,20);


panel1.add(lblManufacturerName);
panel1.add(txtName);

panel1.add(lblVat);
panel1.add(txtVat);
//panel1.setPreferredSize(new Dimension(100,100));


panel3.add(lblState);
panel3.add(jcbState);
panel3.add(lblArea);
panel3.add(txtArea);

jspAddress=new JScrollPane(txtaAddress,22,30);


panel4.add(lblAddress);
panel4.add(jspAddress);


panel6.add(lblPhone);
panel6.add(txtPhone);
panel6.add(lblEmail);
panel6.add(txtEmail);


panel7.add(lblPin);
panel7.add(txtPin);

panel8.add(btnSave);
panel8.add(btnClear);
panel8.add(btnCancel);


panel0.setBorder(new TitledBorder(new LineBorder(Color.blue,2),"Add Manufacturer ",0,1,new Font("Serif", Font.BOLD,15)));
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


add(panel0);

setVisible(true);

}


}