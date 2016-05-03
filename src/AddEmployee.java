import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.Dimension;


import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class AddEmployee extends JPanel
{
JTabbedPane jtpEmployee;
JLabel lblFirstName;
JLabel lblMiddleName;
JLabel lblLastName;
JLabel lblSex;
JLabel lblDateOfBirth;
JLabel lblQualification;
JLabel lblRAddress;
JLabel lblRArea;
JLabel lblRState;
JLabel lblRPin;
JLabel lblRPhone;
JLabel lblEmail;
JLabel lblNAddress;
JLabel lblNArea;
JLabel lblNState;
JLabel lblNPin;
JLabel lblNPhone;
JLabel lblBranch;
JLabel lblDepartment;
JLabel lblDesignation;
JLabel lblDateOfJoining;
JLabel lblPayOfDay;
JLabel lblOverTimePay;

JTextField   txtFirstName;
JTextField txtMiddleName;
JTextField txtLastName;
JRadioButton jrbMale,jrbFemale;
JComboBox jcbDateOfBirthDay;
JComboBox jcbDateOfBirthMonth;
JComboBox jcbDateOfBirthYear;
JComboBox jcbQualification;
JTextField txtRAddress;
JComboBox jcbRState;
JTextField txtRArea;
JTextField txtRPin;
JTextField txtRPhone;
JTextField txtEmail;
JTextField txtNAddress;
JComboBox jcbNState;
JTextField txtNArea;
JTextField txtNPin;
JTextField txtNPhone;

JComboBox jcbBranch;
JComboBox jcbDepartment;
JTextField txtDesignation;
JComboBox jcbDateOfJoiningDay;
JComboBox jcbDateOfJoiningMonth;
JComboBox jcbDateOfJoiningYear;
JTextField txtPayOfDay;
JTextField txtOverTimePay;
JButton btnSave,btnCancel;

ButtonGroup group; 
String temp =null;
JPanel panel0;
JPanel panel1;

JPanel panel1_1;

JPanel panel1_2;
JPanel panel2;
JPanel panel2_1;
JPanel panel2_2;
JPanel panel2_3;
JPanel panel3;
JPanel panel4;
JPanel panel4_1;
JPanel panel4_2;
JPanel panel4_3;

JPanel panel5;
JPanel panel5_1;
JPanel panel5_2;
JPanel panel5_3;
JPanel panel6;
JPanel panel7;
JPanel panel8;
JPanel panel8_1;
JPanel panel8_2;
JPanel panel9;
JPanel panel10;
JPanel panel9_1;
JPanel panel11;
JPanel panel12;
AddEmployee()
{
jtpEmployee=new JTabbedPane();


//----------------------first tab pane contents--------------------------
lblFirstName =new JLabel("First Name  ",JLabel.LEFT);
lblMiddleName =new JLabel("Middle Name  ",JLabel.LEFT);
lblLastName =new JLabel("Last Name  ",JLabel.LEFT);
txtFirstName =new JTextField("",15);
txtMiddleName =new JTextField("",15);
txtLastName =new JTextField(" ",15);
lblSex=new JLabel("      Sex                       ",JLabel.LEFT);
jrbMale=new JRadioButton("Male ");
jrbFemale=new JRadioButton("Female ");
group=new ButtonGroup();
group.add(jrbMale);
group.add(jrbFemale);
lblDateOfBirth=new JLabel("     Date Of Birth       ");
jcbDateOfBirthDay=new JComboBox();
for(Integer i=1;i<32;i++)
{
temp=Integer.toString(i);
jcbDateOfBirthDay.addItem(temp);
}
jcbDateOfBirthMonth=new JComboBox();
jcbDateOfBirthMonth.addItem("Jan");
                jcbDateOfBirthMonth.addItem("Feb");
                jcbDateOfBirthMonth.addItem("Mar");
                jcbDateOfBirthMonth.addItem("Apr");
                jcbDateOfBirthMonth.addItem("May");
                jcbDateOfBirthMonth.addItem("Jun");
                jcbDateOfBirthMonth.addItem("Jul");
                jcbDateOfBirthMonth.addItem("Aug");
                jcbDateOfBirthMonth.addItem("Sep");
                jcbDateOfBirthMonth.addItem("Oct");
                jcbDateOfBirthMonth.addItem("Nov");
                jcbDateOfBirthMonth.addItem("Dec");
jcbDateOfBirthYear=new JComboBox();
for(Integer j=1991;j<2100;j++)
{
temp =Integer.toString(j);
jcbDateOfBirthYear.addItem(temp);
temp=null;
}
lblQualification=new JLabel("     Qualification        ",JLabel.LEFT);
jcbQualification=new JComboBox();
jcbQualification.addItem("S.S.C");
jcbQualification.addItem("H.S.C");
jcbQualification.addItem("Graduation");
jcbQualification.addItem("NA");
JLabel lblBlank=new JLabel("               ");
    // Main panel Employee
    panel0=new JPanel();
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	panel0.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Employee"));
   // panel0.setBackground(Color.lightGray);
				 
     //panel Name
	 panel1=new JPanel();
       panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
	  panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Name"));
	
	panel1_1 =new JPanel();
	panel1_1.setLayout(new FlowLayout(0));
	panel1_1.add(lblFirstName);
	panel1_1.add(txtFirstName);
	panel1_1.add(lblMiddleName);
	panel1_1.add(txtMiddleName);
	
	panel1_2 =new JPanel();
        panel1_2.setLayout(new FlowLayout(FlowLayout.LEFT));
	panel1_2.add(lblLastName);
	panel1_2.add(txtLastName);
	
	panel1.add(panel1_1);
	panel1.add(panel1_2);
	
    
	// panel  General Information
	panel2=new JPanel();
    panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
	panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"General Info"));

	panel2_1=new JPanel();
        panel2_1.setLayout(new FlowLayout(FlowLayout.LEFT));
	panel2_1.add(lblSex);
	panel2_1.add(jrbMale);
	panel2_1.add(jrbFemale);
	
    panel2_2=new JPanel();
panel2_2.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel2_2.add(lblDateOfBirth);
	panel2_2.add(jcbDateOfBirthDay);
	panel2_2.add(jcbDateOfBirthMonth);
	panel2_2.add(jcbDateOfBirthYear);
	
	panel2_3=new JPanel();
	panel2_3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel2_3.add(lblQualification);
	panel2_3.add(jcbQualification);
	 panel2_3.add(lblBlank);
	panel2.add(panel2_1);
	panel2.add(panel2_2);
	panel2.add(panel2_3);
		
		panel0.add(panel1);	
        panel0.add(panel1);
        panel0.add(panel2);
  //-------------------------end of 1 tab pane contents------------------------------

  //------------------------- Second tan pane content-------------------------------

Object[] objState= {"Andaman Nicobar","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chattisgarh","Dadar And Nagar Haveli","Daman & Diu","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu And Kashmir","Jharkhand","Karnataka","Kerala","Lakshwdeep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","New Delhi","Orissa","Pondicherry","Punjab","Rajasthan","Sikkim","Tamil Nadu","Tripura","Uttar Pradesh","Uttaranchal","West Bengal"};


	 lblRAddress = new JLabel(" Address    ",JLabel.LEFT);
         txtRAddress = new JTextField(32);
         lblRState = new JLabel("                State  ",JLabel.LEFT);
	 jcbRState =new JComboBox(objState);
         lblRArea  =new JLabel("Area            ",JLabel.LEFT);
         txtRArea =new JTextField(15);
         lblRPin=new JLabel("   Pin Code",JLabel.LEFT);
         txtRPin=new JTextField("",10);
         lblRPhone=new JLabel("Contact No",JLabel.LEFT);
         txtRPhone=new JTextField(15);

         lblNAddress = new JLabel("Address     ",JLabel.LEFT);
         txtNAddress = new JTextField(32);
         lblNState = new JLabel("                State  ",JLabel.LEFT);
	 jcbNState =new JComboBox(objState);
         lblNArea  =new JLabel("Area            ",JLabel.LEFT);
         txtNArea =new JTextField(15);
         lblNPin=new JLabel("   Pin Code",JLabel.LEFT);
         txtNPin=new JTextField("",10);
         lblNPhone=new JLabel("Contact No",JLabel.LEFT);
         txtNPhone=new JTextField(15);

          lblEmail=new JLabel("Email-Id      ",JLabel.LEFT);
         txtEmail=new JTextField(20);
         panel3=new JPanel();
	panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
	panel3.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Contact Information"));
    //panel3.setBackground(Color.lightGray);

       panel4=new JPanel();
       panel4.setLayout(new BoxLayout(panel4,BoxLayout.Y_AXIS));
       panel4.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Residential"));

        panel4_1=new JPanel();
        panel4_1.setLayout(new FlowLayout(FlowLayout.LEFT));
	panel4_1.add(lblRAddress);
	panel4_1.add(txtRAddress);

        panel4_2=new JPanel();
	
	
	panel4_2.add(lblRArea);
	panel4_2.add(txtRArea);
        panel4_2.add(lblRPin);
	panel4_2.add(txtRPin);
panel4_2.add(lblRState);
panel4_2.add(jcbRState);


	panel4_3=new JPanel();
	panel4_3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel4_3.add(lblRPhone);
	panel4_3.add(txtRPhone);
	 panel4_3.add(lblBlank);
	panel4.add(panel4_1);
	panel4.add(panel4_2);
	panel4.add(panel4_3);


       panel5=new JPanel();
       panel5.setLayout(new BoxLayout(panel5,BoxLayout.Y_AXIS));
       panel5.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Native"));

        panel5_1=new JPanel();
		panel5_1.setLayout(new FlowLayout(FlowLayout.LEFT));
	panel5_1.add(lblNAddress);
	panel5_1.add(txtNAddress);

        panel5_2=new JPanel();
	
	panel5_2.add(lblNArea);
	panel5_2.add(txtNArea);
        panel5_2.add(lblNPin);
	panel5_2.add(txtNPin);
panel5_2.add(lblNState);
	panel5_2.add(jcbNState);

	panel5_3=new JPanel();
        panel5_3.setLayout(new FlowLayout(FlowLayout.LEFT));
	panel5_3.add(lblNPhone);
	panel5_3.add(txtNPhone);
	 panel5_3.add(lblBlank);
	panel5.add(panel5_1);
	panel5.add(panel5_2);
	panel5.add(panel5_3);

        panel6=new JPanel();
        panel6.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel6.add(lblEmail);
        panel6.add(txtEmail);
        panel3.add(panel4);
        panel3.add(panel5);
        panel3.add(panel6);

//-------------------------------Third tab pane content---------------------------

 //lblBranch=new JLabel(" Branch",JLabel.LEFT);
 lblDepartment=new JLabel("Departmet",JLabel.LEFT);
 lblDesignation=new JLabel("                  Designation",JLabel.LEFT);
 lblDateOfJoining=new JLabel("        Date Of Joining  ",JLabel.LEFT);
 lblPayOfDay=new JLabel("Pay Of Day",JLabel.LEFT);
 lblOverTimePay=new JLabel("          Over Time Pay(hr)",JLabel.LEFT);

 //jcbBranch=new JComboBox();
 jcbDepartment=new JComboBox();
  jcbDepartment.addItem("Accounts");
 jcbDepartment.addItem("Finance");
  jcbDepartment.addItem("Delivery");
 txtDesignation=new JTextField(10);
 jcbDateOfJoiningDay=new JComboBox();
 
  for(Integer i=1;i<32;i++)
{
temp=Integer.toString(i);
jcbDateOfJoiningDay.addItem(temp);
}
 jcbDateOfJoiningMonth=new JComboBox();
  jcbDateOfJoiningMonth.addItem("Jan");
                jcbDateOfJoiningMonth.addItem("Feb");
                jcbDateOfJoiningMonth.addItem("Mar");
                jcbDateOfJoiningMonth.addItem("Apr");
                jcbDateOfJoiningMonth.addItem("May");
                jcbDateOfJoiningMonth.addItem("Jun");
                jcbDateOfJoiningMonth.addItem("Jul");
                jcbDateOfJoiningMonth.addItem("Aug");
                jcbDateOfJoiningMonth.addItem("Sep");
                jcbDateOfJoiningMonth.addItem("Oct");
                jcbDateOfJoiningMonth.addItem("Nov");
                jcbDateOfJoiningMonth.addItem("Dec");
 
 jcbDateOfJoiningYear=new JComboBox();
 for(Integer j=1991;j<2100;j++)
{
temp =Integer.toString(j);
jcbDateOfJoiningYear.addItem(temp);
temp=null;
}
 
 txtPayOfDay=new JTextField(6);
 txtOverTimePay=new JTextField(6);
 btnSave=new JButton("Save");
 btnCancel=new JButton("Cancel");

panel7=new JPanel();
       panel7.setLayout(new BoxLayout(panel7,BoxLayout.Y_AXIS));
       panel7.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Company Related Information"));

 panel8=new JPanel();
       panel8.setLayout(new BoxLayout(panel8,BoxLayout.Y_AXIS));
       panel8.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Designation-Joining"));

       panel8_1=new JPanel();
      // panel8_1.add(lblBranch);
     //  panel8_1.add(jcbBranch);
       panel8_1.add(lblDateOfJoining);
       panel8_1.add(jcbDateOfJoiningDay);
       panel8_1.add(jcbDateOfJoiningMonth);
       panel8_1.add(jcbDateOfJoiningYear);


       panel8_2=new JPanel();
       panel8_2.add(lblDepartment);
       panel8_2.add(jcbDepartment);
       panel8_2.add(lblDesignation);
       panel8_2.add(txtDesignation);


       panel8.add(panel8_1);
       panel8.add(panel8_2);

       panel9=new JPanel();
       panel9.setLayout(new BoxLayout(panel9,BoxLayout.Y_AXIS));
       panel9.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Salary"));

       panel9_1=new JPanel();
       panel9_1.add(lblPayOfDay);
       panel9_1.add(txtPayOfDay);
        panel9_1.add(lblOverTimePay);
         panel9_1.add(txtOverTimePay);

         panel9.add(panel9_1);
       panel10=new JPanel();
       panel10.setLayout(new FlowLayout(FlowLayout.RIGHT));
       panel10.add(btnSave);
       panel10.add(btnCancel);

       panel7.add(panel8);
       panel7.add(panel9);
       panel7.add(panel10);

       jtpEmployee.add("Employee",panel0);
        jtpEmployee.add("Contact Info",panel3);
	jtpEmployee.add("Company Related Info",panel7);
        //Container c=getContentPane();
     add(jtpEmployee);
	 setSize(500,400);
	 setVisible(true);
        // pack();
}
public static void main(String a[])
{
    try {

UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}
catch(Exception e)
{
}  
AddEmployee ae=new AddEmployee();

}
}