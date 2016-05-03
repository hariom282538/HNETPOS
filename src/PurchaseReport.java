import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;
import javax.swing.JComboBox.*;
import javax.swing.table.*;

public class PurchaseReport extends JPanel {

JPanel panel0;
JPanel panel1;
JPanel panel2;
JPanel panel2_1;
JPanel panel2_2;
JPanel panel3;
JPanel panel4;
//JPanel panel5;
JPanel panel5;
JPanel panel6;
JPanel panel7;
JPanel panel8;
ButtonGroup bgroup;
Border border;
JLabel lblFirstName;
JLabel lblLastName;
JLabel lblCompany;

JComboBox jcbFirstName;
JComboBox jcbLastName;
JComboBox jcbCompany;
JComboBox jcbManufacturer;
JComboBox jcbProduct;

JLabel lblStatus;


JLabel lblPending; 
JLabel lblDate;
JLabel lblCurrentDate;
JLabel lblManufacturer;
JLabel lblProduct;


JButton btnSave;
JButton btnReport;


JButton btnCancel;

JLabel lblComplaint;
JTextArea txtaDescription;
JScrollPane jspDescription;


JRadioButton jrbPurchaseDate;
JRadioButton jrbProductType;

JComboBox jcbStartDate;
JComboBox jcbStartMonth;
JComboBox jcbStartYear;

JLabel lblTo;

JComboBox jcbEndDate;
JComboBox jcbEndMonth;
JComboBox jcbEndYear;

JTable jtPurchase;
JScrollPane jspPurchase;
DefaultTableModel model;


public PurchaseReport(){



panel0=new JPanel();
panel1=new JPanel();
panel2=new JPanel();
panel2_1=new JPanel();
panel2_2=new JPanel();
panel3=new JPanel();
panel4=new JPanel();
panel5=new JPanel();
//panel5=new JPanel();
panel6=new JPanel();
panel7=new JPanel();
panel8=new JPanel();

btnSave=new JButton("Save");
btnReport=new JButton("Report");
btnCancel=new JButton("Cancel");

    
	jrbPurchaseDate=new JRadioButton("Purchase Date");
	jrbProductType=new JRadioButton("Product Type");
	bgroup=new ButtonGroup();
	bgroup.add(jrbPurchaseDate);
	bgroup.add(jrbProductType);
	//jrbPurchaseDate.setSelected(true);
	
	jcbManufacturer=new JComboBox();
	jcbProduct=new JComboBox();
	jcbManufacturer.addItem("Select");
	jcbProduct.addItem("Select Manufacturer First");
	//jcbManufacturer.setEnabled(false);
	//jcbProduct.setEnabled(false);
	
jcbStartDate = new JComboBox();
jcbStartMonth = new JComboBox();
jcbStartYear = new JComboBox();
	
lblTo = new JLabel("     To     ",JLabel.LEFT);
	
jcbEndDate = new JComboBox();
jcbEndMonth = new JComboBox();
jcbEndYear = new JComboBox();

  for(int i = 1;i<32;i++){jcbStartDate.addItem(i);}
                for(int i =1995;i<2100;i++){jcbStartYear.addItem(i);}
                jcbStartMonth.addItem("Jan");
                jcbStartMonth.addItem("Feb");
                jcbStartMonth.addItem("Mar");
                jcbStartMonth.addItem("Apr");
                jcbStartMonth.addItem("May");
                jcbStartMonth.addItem("Jun");
                jcbStartMonth.addItem("Jul");
                jcbStartMonth.addItem("Aug");
                jcbStartMonth.addItem("Sep");
                jcbStartMonth.addItem("Oct");
                jcbStartMonth.addItem("Nov");
                jcbStartMonth.addItem("Dec");

                for(int i = 1;i<32;i++){jcbEndDate.addItem(i);}
                for(int i =1995;i<2100;i++){jcbEndYear.addItem(i);}
                jcbEndMonth.addItem("Jan");
                jcbEndMonth.addItem("Feb");
                jcbEndMonth.addItem("Mar");
                jcbEndMonth.addItem("Apr");
                jcbEndMonth.addItem("May");
                jcbEndMonth.addItem("Jun");
                jcbEndMonth.addItem("Jul");
                jcbEndMonth.addItem("Aug");
                jcbEndMonth.addItem("Sep");
                jcbEndMonth.addItem("Oct");
                jcbEndMonth.addItem("Nov");
                jcbEndMonth.addItem("Dec");
                
	
	panel2_1.add(jrbPurchaseDate);
	panel2_1.add(jrbProductType);
	
	jcbFirstName=new JComboBox();
    jcbLastName=new JComboBox();
    jcbCompany=new JComboBox();
	
	jcbFirstName.addItem("Select");
		jcbLastName.addItem("Select");
			jcbCompany.addItem("Select");
	lblPending =new JLabel("Pending");
	border= LineBorder.createGrayLineBorder();
	lblPending.setBorder(border);

	final String[] header={"Purchase Id","Manu Id","Product Id","Quantity","Amount","Order Date","Received Date","Status"};
      Object[][] data=new Object[0][8];
	  model = new DefaultTableModel(data,header);
	
	jtPurchase=new JTable(model);
jtPurchase.setAutoResizeMode(0);
	jtPurchase.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtPurchase.setColumnSelectionAllowed(false);
	jtPurchase.setShowVerticalLines(false);
	jtPurchase.setShowGrid(false);
	//jtPurchase.setBackground(Color.white);
	jtPurchase.setOpaque(false);
	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jspPurchase=new JScrollPane(jtPurchase,vertical,height);
	jspPurchase.setPreferredSize(new Dimension(400, 200));
	
lblManufacturer =new JLabel("Manufacturer");
lblProduct =new JLabel("        Product");
//panel2_2.add(lblManufacturer);
//panel2_2.add(jcbManufacturer);
//panel2_2.add(lblProduct);
//panel2_2.add(jcbProduct);

panel2.add(panel2_1);
panel2.add(panel2_2);


	txtaDescription=new JTextArea(3,20);
		jspDescription=new JScrollPane(txtaDescription,22,30);
	lblCurrentDate=new JLabel("D");
lblCurrentDate.setBorder(border);

panel0.setLayout(new BoxLayout(panel0,BoxLayout.Y_AXIS));
panel1.setLayout(new FlowLayout(0));
panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
panel2_1.setLayout(new FlowLayout(0));
panel2_2.setLayout(new FlowLayout(0));
panel3.setLayout(new GridLayout(2,1));
panel4.setLayout(new FlowLayout(0));
panel5.setLayout(new FlowLayout(0));
//panel5.setLayout(new GridLayout(2,1));
panel6.setLayout(new FlowLayout(0));
panel7.setLayout(new FlowLayout(0));
panel8.setLayout(new FlowLayout(4));

lblFirstName=new JLabel("First Name :");
lblLastName=new JLabel("Last Name :");

lblCompany=new JLabel("Company :");
lblComplaint=new JLabel("Complaint");
lblStatus=new JLabel("Status:");
lblDate=new JLabel("                   Date:");


panel1.add(lblCompany);
panel1.add(jcbCompany);

panel1.add(lblFirstName);
panel1.add(jcbFirstName);

panel1.add(lblLastName);
panel1.add(jcbLastName);


panel4.add(jcbStartDate);
panel4.add(jcbStartMonth);
panel4.add(jcbStartYear);
panel4.add(lblTo);
panel4.add(jcbEndDate);
panel4.add(jcbEndMonth);
panel4.add(jcbEndYear);


panel5.add(lblManufacturer);
panel5.add(jcbManufacturer);
panel5.add(lblProduct);
panel5.add(jcbProduct);

panel4.setVisible(false);
panel5.setVisible(false);

//panel6.add(jspPurchase);

//panel5.add(lblStatus);
//panel5.add(lblPending);
//panel5.add(lblDate);
//panel5.add(lblCurrentDate);
//panel5.setSize(100,100);
//panel8.add(btnSave);
panel8.add(btnReport);
panel8.add(btnCancel);


panel0.setBorder(new TitledBorder(new LineBorder(Color.blue,2),"Purchase Report",0,1,new Font("Serif", Font.BOLD,15)));
panel1.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Name ",0,1,new Font("Serif", Font.BOLD,15)));
panel3.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Details ",0,1,new Font("Serif", Font.BOLD,15)));
panel2.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Category",0,1,new Font("Serif", Font.BOLD,15)));

//panel0.add(panel1);
panel0.add(panel2);

panel3.add(panel4);
panel3.add(panel5);
panel0.add(panel3);
panel0.add(panel6);
panel0.add(panel8);


//Container c=getContentPane();
add(panel0);

setVisible(true);
setSize(400,500);
//pack();
}

public static void main(String a[])
{
PurchaseReport acp=new PurchaseReport();
}
}