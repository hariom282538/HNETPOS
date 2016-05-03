//import java.awt.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.Desktop;
import javax.swing.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.UIManager.*;
import javax.swing.table.DefaultTableModel.*;
import javax.swing.table.*;
import java.util.*;
import javax.swing.border.*;
import java.io.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
public class MyController extends JWindow implements KeyListener,ActionListener,ItemListener,MouseListener{

//SplashScreen splash;
Connectionn connect,connect2,connect3;
MyLogin login;
MyModel model;
MyMenu menu;
Customer cust;
Manufacturer manu;
Employee emp;
Sale sale;
Product prod;
Order order;
View view;
Payment pay;
Complaint comp;
Report report1;
About about1;
ChangePassword changePass;
ManageUsers manageUsers;
Bill bill;
ReorderLevel reorder;

ModifyEmployee modifyEmp;
ModifyCustomer modifyCust;
ModifyManufacturer modifyManu;
ModifyProduct modifyProd;

Calendar cal;
Border border; 

//BasicWindowMonitor basicW;
BasicWindowMonitor2  basicW2;

int m,size=0,rows=0,custModify=0;
int validate;
int row,pkey=1,pkeyo=1;
boolean bflag;
int i1=0,i2=0,i3=0,i4=0,i5=0,i6=0;

Object source;
Object[][] dc1;
Object[][] dc2;

String[][] sc2;
String userName="";
String modEmp1="",modEmp2="",modEmp3="",modEmp4="",modEmp5="",modEmp6="",modEmp7="",modEmp8="" ,modEmp9="", modEmp10="",modEmp11="",modEmp12="",modEmp13="",modEmp14="",modEmp15="";
String s="",s1="",s2="",s3="",s4="",s5="",s6="",s7="",s8="",s9="",s10="",s11="",s12="",s13="",s14="",s15="",s16="",s17="",s18="",s19="",s20="",s21="",s22="";
String calendar;
String strQuery,modCust1="",modCust2="",modCust3="",modCust4="",modCust5="",modCust6="",modCust7="",modCust8="";
String modManu1="",modManu2="",modManu3="",modManu4="",modManu5="",modManu6="",modManu7="",modManu8="",modManu9="";
String modProd1="",modProd2="",modProd3="",modProd4="",modProd5="",modProd6="",modProd7="",modProd8="";

private JProgressBar progressBar;

//---------------------------CONSTRUCTOR-------------------------------
public MyController(){
//---------------------------Look & Feel-------------------------------
try {
for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
if ("Nimbus".equals(info.getName())) {
    UIManager.setLookAndFeel(info.getClassName());
	break; }
	}
} catch (Exception e) {System.out.println("Error:1"+e);}

model=new MyModel();
model.chkInstance();
initialize();
//pack();
//---------------------------Timer-----------------------------------------
javax.swing.Timer t = new javax.swing.Timer(1000, new ClockListener());
        t.start();
		
		//basicW2=new BasicWindowMonitor2();
}

//------------------------------INITIALIZE----------------------------------
public void initialize(){
//--------------------------------SplashScreen------------------------------------------
  JPanel content = (JPanel)getContentPane();
       content.setBackground(Color.white);

	    progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
		progressBar.setBorderPainted(true);
		progressBar.setStringPainted(true);
	
		// Set the window's bounds, centering the window
       int width = 710;
       int height =450;
       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       int x = (screen.width-width)/2;
       int y = (screen.height-height)/2;
       setBounds(x,y,width,height);

       // Build the splash screen
       JLabel label = new JLabel(new ImageIcon(getClass().getResource("i/splash.jpg")));
       JLabel copyrt = new JLabel("HNET POS, Copyright 2015", JLabel.CENTER);
       copyrt.setFont(new java.awt.Font("Sans-Serif", Font.BOLD, 15));
       content.add(label, BorderLayout.CENTER);
       content.add(copyrt, BorderLayout.NORTH);
	   content.add(progressBar,BorderLayout.SOUTH);
       Color oraRed = new Color(156, 20, 20,  255);
       content.setBorder(BorderFactory.createLineBorder(Color.darkGray, 10));

       // Display it
       setVisible(true);

         try
        {
		for(int i=0;i<51;i++){
       Thread.sleep(10);
	   	progressBar.setString("Loading  "+i+"%");
	   progressBar.setValue(i);
}
        } catch (Exception e) {System.out.println("Error:2"+e);}



//---------------------------------work2do-------------------------------------
//basicW=new BasicWindowMonitor();
connect =new Connectionn();
connect.startConnection();
connect2 =new Connectionn();
connect2.startConnection();
connect3 =new Connectionn();
connect3.startConnection();
//splash=new SplashScreen();

login=new MyLogin();
login.btnExit.addActionListener(this);
login.btnLogin.addActionListener(this);
//login.addWindowListener(basicW);

cust=new Customer();
cust.addMouseListener(this);
cust.addMouseMotionListener(new MouseAdapter()
       {
          public void mouseClicked(MouseEvent me)
         {
        menu.getLayeredPane().setPosition(cust,0);
        System.out.println("me");
         
	}  public void mousePressed(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(cust,0);
        System.out.println("me");
         
	}  public void mouseDragged(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(cust,0);
        System.out.println("me");
         
	}public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(cust,0);
        System.out.println("me");
         
	}
          });
cust.editCust.txtSearch.addKeyListener(this);
cust.editCust.btnDelete.addActionListener(this);
cust.editCust.btnDelete.setActionCommand("cust.editCust.btnDelete");
cust.editCust.btnModify.addActionListener(this);
cust.editCust.btnModify.setActionCommand("cust.editCust.btnModify");
cust.editCust.btnCancel.addActionListener(this);
cust.editCust.btnCancel.setActionCommand("cust.editCust.btnCancel");
cust.addCust.btnCancel.addActionListener(this);
cust.addCust.btnCancel.setActionCommand("cust.addCust.btnCancel");

cust.addCust.btnClear.addActionListener(this);
cust.addCust.btnClear.setActionCommand("cust.addCust.btnClear");
cust.editCust.jcbSearch.addItemListener(this);

cust.addCust.btnSave.addActionListener(this);
cust.addCust.btnSave.setActionCommand("addCust.btnSave");

cust.editCust.jtCustomer.addMouseListener(new MouseAdapter()
       {
          public void mouseClicked(MouseEvent me)
         {
        int column = cust.editCust.jtCustomer.getSelectedColumn();
       row = cust.editCust.jtCustomer.getSelectedRow();
	   System.out.println(row);
        s1=(String)cust.editCust.jtCustomer.getModel().getValueAt(row, 0);
        System.out.println(s1);
         
	}
          });
		  
manu=new Manufacturer();
manu.addMouseListener(this);
manu.addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(manu,0);
        
         
	}
          });
manu.editManu.btnDelete.addActionListener(this);
manu.editManu.btnDelete.setActionCommand("manu.editManu.btnDelete");
manu.editManu.btnModify.addActionListener(this);
manu.editManu.btnModify.setActionCommand("manu.editManu.btnModify");
manu.editManu.txtSearch.addKeyListener(this);
manu.addManu.btnCancel.addActionListener(this);
manu.addManu.btnCancel.setActionCommand("manu.addManu.btnCancel");
manu.editManu.btnCancel.addActionListener(this);
manu.editManu.btnCancel.setActionCommand("manu.editManu.btnCancel");
manu.addManu.btnClear.addActionListener(this);
manu.addManu.btnClear.setActionCommand("manu.addManu.btnClear");


manu.addManu.btnSave.addActionListener(this);
manu.addManu.btnSave.setActionCommand("addManu.btnSave");
		  
		  manu.editManu.jtManufacturer.addMouseListener(new MouseAdapter()
       {
          public void mouseClicked(MouseEvent me)
         {
        int column = manu.editManu.jtManufacturer.getSelectedColumn();
       row = manu.editManu.jtManufacturer.getSelectedRow();
	   System.out.println(row);
        s2=(String)manu.editManu.jtManufacturer.getModel().getValueAt(row, 0);
        System.out.println(s2);
         
	}
          });
		  


emp=new Employee();
emp.addMouseListener(this);
emp.addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(emp,0);
        
         
	}
          });
emp.editEmployee.txtSearch.addKeyListener(this);
emp.addEmployee.btnSave.addActionListener(this);
emp.addEmployee.btnSave.setActionCommand("emp.addEmployee.btnSave");
emp.addEmployee.btnCancel.addActionListener(this);
emp.addEmployee.btnCancel.setActionCommand("emp.addEmployee.btnCancel");
emp.editEmployee.btnCancel.addActionListener(this);
emp.editEmployee.btnCancel.setActionCommand("emp.editEmployee.btnCancel");
emp.editEmployee.btnModify.addActionListener(this);
emp.editEmployee.btnModify.setActionCommand("emp.editEmployee.btnModify");
emp.editEmployee.btnDelete.addActionListener(this);
emp.editEmployee.btnDelete.setActionCommand("emp.editEmployee.btnDelete");

emp.editEmployee.jtEmployee.addMouseListener(new MouseAdapter()
       {
          public void mouseClicked(MouseEvent me)
         {
        int column = emp.editEmployee.jtEmployee.getSelectedColumn();
       row = emp.editEmployee.jtEmployee.getSelectedRow();
	   System.out.println(row);
        s3=(String)emp.editEmployee.jtEmployee.getModel().getValueAt(row, 0);
        System.out.println(s);
         
	}
          });

sale=new Sale();
sale.addMouseListener(this);
sale.addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(sale,0);
        
         
	}
          });
		  	  sale.viewSale.jtViewSale.addMouseListener(new MouseAdapter(){
public void mouseClicked(MouseEvent me)
         {
        int column = sale.viewSale.jtViewSale.getSelectedColumn();
       row = sale.viewSale.jtViewSale.getSelectedRow();
	   System.out.println(row);
       i2=(Integer)sale.viewSale.jtViewSale.getModel().getValueAt(row, 0);
		s19=(String)sale.viewSale.jtViewSale.getModel().getValueAt(row, 8);
		i5=(Integer)sale.viewSale.jtViewSale.getModel().getValueAt(row, 3);
		i6=(Integer)sale.viewSale.jtViewSale.getModel().getValueAt(row, 4);
        System.out.println(s19);
       
	}
          });

Object[][] dc3=new Object[0][0];
final Object[] header={"Product Name","Price","Quantity","Amount"};
DefaultTableModel jtModel=new DefaultTableModel(dc3,header);
sale.addSale.jtAddProduct.setModel(jtModel);

cal=new GregorianCalendar();
int day=cal.get(Calendar.DAY_OF_MONTH);
int month=cal.get(Calendar.MONTH);
int year=cal.get(Calendar.YEAR);
month=month+1;
String strMonth="";
if(month==1) strMonth="Jan";
if(month==2) strMonth="Feb";
if(month==3) strMonth="Mar";
if(month==4) strMonth="Apr";
if(month==5) strMonth="May";
if(month==6) strMonth="Jun";
if(month==7) strMonth="Jul";
if(month==8) strMonth="Aug";
if(month==9) strMonth="Sep";
if(month==10) strMonth="Oct";
if(month==11) strMonth="Nov";
if(month==12) strMonth="Dec";
calendar=Integer.toString(day)+"-"+strMonth+"-"+Integer.toString(year);
sale.addSale.lblSaleDate2.setText(calendar);
//sale.addSale.lblSaleDate2.setBsale(bsale);
//sale.addSale.txtsaleDate.setEnabled(false);
//System.out.println(calendar);

try{
strQuery="delete from sale2 ";
connect.executeQuery("update",strQuery);
}catch(Exception e){System.out.println("Error:3"+e);}

sale.setVisible(false);
sale.addSale.txtSearch.setText("");


sale.viewSale.btnComplete.addActionListener(this);
sale.viewSale.btnComplete.setActionCommand("sale.viewSale.btnComplete");
sale.viewSale.btnDelete.addActionListener(this);
sale.viewSale.btnDelete.setActionCommand("sale.viewSale.btnDelete");
sale.viewSale.btnCancel.addActionListener(this);
sale.viewSale.btnCancel.setActionCommand("sale.viewSale.btnCancel");

sale.addSale.jcbCompany.addItemListener(this);
sale.updateSale.jcbCompany.addItemListener(this);
sale.addSale.jcbFirstName.addItemListener(this);
sale.updateSale.jcbFirstName.addItemListener(this);
sale.addSale.jcbLastName.addItemListener(this);
sale.updateSale.jcbLastName.addItemListener(this);

sale.addSale.txtSearch.addKeyListener(this);
sale.addSale.jcbManufacturer.addItemListener(this);
sale.addSale.btnAdd.addActionListener(this);
sale.addSale.btnAdd.setActionCommand("addSale.btnAdd");
sale.addSale.btnRemove.addActionListener(this);
sale.addSale.btnRemove.setActionCommand("addSale.btnRemove");
sale.addSale.btnSave.addActionListener(this);
sale.addSale.btnSave.setActionCommand("addSale.btnSave");
sale.addSale.btnCancel.addActionListener(this);
sale.addSale.btnCancel.setActionCommand("addSale.btnCancel");

sale.updateSale.btnDelete.addActionListener(this);
sale.updateSale.btnDelete.setActionCommand("updateSale.btnDelete");
sale.updateSale.btnCancel.addActionListener(this);
sale.updateSale.btnCancel.setActionCommand("updateSale.btnCancel");
sale.updateSale.btnSearch.addActionListener(this);
sale.updateSale.btnSearch.setActionCommand("updateSale.btnSearch");
sale.updateSale.btnComplete.addActionListener(this);
sale.updateSale.btnComplete.setActionCommand("updateSale.btnComplete");
sale.addSale.jtProductList.addMouseListener(new MouseAdapter()
       {
          public void mouseClicked(MouseEvent me)
         {
        int column = sale.addSale.jtProductList.getSelectedColumn();
       row = sale.addSale.jtProductList.getSelectedRow();
	   System.out.println(row);
        s5=(String)sale.addSale.jtProductList.getModel().getValueAt(row, 0);
		s6=(String)sale.addSale.jtProductList.getModel().getValueAt(row, 2);
        System.out.println(s5);
         System.out.println(s6);
	}
          });
		  sale.addSale.jtAddProduct.addMouseListener(new MouseAdapter(){
public void mouseClicked(MouseEvent me)
         {
        int column = sale.addSale.jtAddProduct.getSelectedColumn();
       row = sale.addSale.jtAddProduct.getSelectedRow();
	   System.out.println(row);
        s7=(String)sale.addSale.jtAddProduct.getModel().getValueAt(row, 0);
		s8=(String)sale.addSale.jtAddProduct.getModel().getValueAt(row, 1);
		s9=(String)sale.addSale.jtAddProduct.getModel().getValueAt(row, 2);
        System.out.println(s7);
         System.out.println(s8);
		  System.out.println(s9);
	}
          });
		  

prod=new Product();
prod.addMouseListener(this);
prod.addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(prod,0);
        
         
	}
          });
order=new Order();
order.addMouseListener(this);
order.addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(order,0);
        
         
	}
          });
order.adOrder.jcbManufacturer.addItemListener(this);
order.adOrder.btnAdd.addActionListener(this);
order.adOrder.btnAdd.setActionCommand("adOrder.btnAdd");
order.adOrder.btnDelete.addActionListener(this);
order.adOrder.btnDelete.setActionCommand("adOrder.btnDelete");
order.adOrder.btnSave.addActionListener(this);
order.adOrder.btnSave.setActionCommand("adOrder.btnSave");
order.adOrder.btnCancel.addActionListener(this);
order.adOrder.btnCancel.setActionCommand("adOrder.btnCancel");



    order.upOrder.txtSearch.addKeyListener(this);
    order.upOrder.btnUpdate.addActionListener(this);
	order.upOrder.btnUpdate.setActionCommand("upOrder.btnUpdate");
	order.upOrder.btnDelete.addActionListener(this);
	order.upOrder.btnDelete.setActionCommand("upOrder.btnDelete");
	order.upOrder.btnCancel.addActionListener(this);
	order.upOrder.btnCancel.setActionCommand("upOrder.btnCancel");
	order.upOrder.jcbManufacturer.addItemListener(this);
	
	order.upOrder.jtOrder.addMouseListener(new MouseAdapter()
       {
          public void mouseClicked(MouseEvent me)
         {
        int column = order.upOrder.jtOrder.getSelectedColumn();
       row = order.upOrder.jtOrder.getSelectedRow();
	   System.out.println(row);
	   int in=(Integer)order.upOrder.jtOrder.getModel().getValueAt(row, 0);
	   int in2=(Integer)order.upOrder.jtOrder.getModel().getValueAt(row, 2);
	    i1=(Integer)order.upOrder.jtOrder.getModel().getValueAt(row, 3);
        s4=Integer.toString(in);
        System.out.println(s4);
		s17=Integer.toString(in2);
	s18=(String)order.upOrder.jtOrder.getModel().getValueAt(row, 7);
         
	}
          });
		  
		  order.adOrder.jtOrder.addMouseListener(new MouseAdapter()
       {
          public void mouseClicked(MouseEvent me)
         {
        int column = order.adOrder.jtOrder.getSelectedColumn();
       row = order.adOrder.jtOrder.getSelectedRow();
	   System.out.println(row);
        s14=(String)order.adOrder.jtOrder.getModel().getValueAt(row, 0);
		s15=(String)order.adOrder.jtOrder.getModel().getValueAt(row, 1);
        System.out.println(s14);
         
	}
          });
view=new View();
view.addMouseListener(this);
view.addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(view,0);
        
         
	}
          });
view.viewProd.txtProductName.addKeyListener(this);
prod.editProduct.jtProduct.addMouseListener(new MouseAdapter()
       {
          public void mouseClicked(MouseEvent me)
         {
        int column = prod.editProduct.jtProduct.getSelectedColumn();
       row = prod.editProduct.jtProduct.getSelectedRow();
	   System.out.println(row);
        s3=(String)prod.editProduct.jtProduct.getModel().getValueAt(row, 0);
        System.out.println(s3);
         
	}
          });
prod.editProduct.txtSearch.addKeyListener(this);
prod.addProduct.btnSave.addActionListener(this);
prod.addProduct.btnSave.setActionCommand("prod.addProduct.btnSave");
prod.addProduct.btnCancel.addActionListener(this);
prod.addProduct.btnCancel.setActionCommand("prod.addProduct.btnCancel");
prod.editProduct.btnCancel.addActionListener(this);
prod.editProduct.btnCancel.setActionCommand("prod.editProduct.btnCancel");
prod.editProduct.btnModify.addActionListener(this);
prod.editProduct.btnModify.setActionCommand("prod.editProduct.btnModify");
prod.editProduct.btnDelete.addActionListener(this);
prod.editProduct.btnDelete.setActionCommand("prod.editProduct.btnDelete");
prod.editProduct.jcbManufacturer.addItemListener(this);


pay=new Payment();
pay.addMouseListener(this);
pay.addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(pay,0);
        
         
	}
          });
		  
pay.btnUpdate.addActionListener(this);
pay.btnUpdate.setActionCommand("pay.btnUpdate");

pay.btnCancel.addActionListener(this);
pay.btnCancel.setActionCommand("pay.btnCancel");


pay.jtViewPayment.addMouseListener(new MouseAdapter(){
public void mouseClicked(MouseEvent me)
         {
        int column = pay.jtViewPayment.getSelectedColumn();
       row = pay.jtViewPayment.getSelectedRow();
	   System.out.println(row);
	  i4=(Integer)pay.jtViewPayment.getModel().getValueAt(row, 0);
     
		
        System.out.println(i4);
        
	}
          });

comp=new Complaint();
comp.addMouseListener(this);
comp.addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(comp,0);
        
         
	}
          });
		  
		  

comp.viewComplaint.jtViewComplaint.addMouseListener(new MouseAdapter(){
public void mouseClicked(MouseEvent me)
         {
        int column = comp.viewComplaint.jtViewComplaint.getSelectedColumn();
       row = comp.viewComplaint.jtViewComplaint.getSelectedRow();
	   System.out.println(row);
	   int in=(Integer)comp.viewComplaint.jtViewComplaint.getModel().getValueAt(row, 0);
        s16=Integer.toString(in);
		
        System.out.println(s16);
        
	}
          });
		  
comp.addComplaint.jcbCompany.addItemListener(this);
comp.addComplaint.jcbFirstName.addItemListener(this);
comp.addComplaint.jcbLastName.addItemListener(this);
comp.addComplaint.jcbSaleId.addItemListener(this);

comp.addComplaint.jrbSale.addActionListener(this);
comp.addComplaint.jrbSale.setActionCommand("comp.addComplaint.jrbSale");
comp.addComplaint.jrbProduct.addActionListener(this);
comp.addComplaint.jrbProduct.setActionCommand("comp.addComplaint.jrbProduct");
comp.addComplaint.btnSave.addActionListener(this);
comp.addComplaint.btnSave.setActionCommand("comp.addComplaint.btnSave");
comp.addComplaint.btnCancel.addActionListener(this);
comp.addComplaint.btnCancel.setActionCommand("comp.addComplaint.btnCancel");

comp.viewComplaint.btnDelete.addActionListener(this);
comp.viewComplaint.btnDelete.setActionCommand("comp.viewComplaint.btnDelete");
comp.viewComplaint.btnClear.addActionListener(this);
comp.viewComplaint.btnClear.setActionCommand("comp.viewComplaint.btnClear");
comp.viewComplaint.btnCancel.addActionListener(this);
comp.viewComplaint.btnCancel.setActionCommand("comp.viewComplaint.btnCancel");

comp.addComplaint.lblCurrentDate.setText(calendar);


report1=new Report();
report1.salReport.jcbManufacturer.addItemListener(this);
report1.addMouseListener(this);
report1.addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(report1,0);
        
         
	}
          });
		  
		  
report1.salReport.btnCancel.addActionListener(this);
report1.salReport.btnCancel.setActionCommand("report1.salReport.btnCancel");
report1.salReport.btnReport.addActionListener(this);
report1.salReport.btnReport.setActionCommand("report1.salReport.btnReport");

report1.salReport.jrbSaleDate.addActionListener(this);
report1.salReport.jrbSaleDate.setActionCommand("report1.salReport.jrbSaleDate");
report1.salReport.jrbProductType.addActionListener(this);
report1.salReport.jrbProductType.setActionCommand("report1.salReport.jrbProductType");


report1.purReport.btnCancel.addActionListener(this);
report1.purReport.btnCancel.setActionCommand("report1.purReport.btnCancel");
report1.purReport.btnReport.addActionListener(this);
report1.purReport.btnReport.setActionCommand("report1.purReport.btnReport");

report1.purReport.jrbPurchaseDate.addActionListener(this);
report1.purReport.jrbPurchaseDate.setActionCommand("report1.purReport.jrbPurchaseDate");
report1.purReport.jrbProductType.addActionListener(this);
report1.purReport.jrbProductType.setActionCommand("report1.purReport.jrbProductType");

report1.comReport.btnCancel.addActionListener(this);
report1.comReport.btnCancel.setActionCommand("report1.comReport.btnCancel");
report1.comReport.btnReport.addActionListener(this);
report1.comReport.btnReport.setActionCommand("report1.comReport.btnReport");

report1.comReport.jrbComplaintDate.addActionListener(this);
report1.comReport.jrbComplaintDate.setActionCommand("report1.comReport.jrbComplaintDate");
report1.comReport.jrbCustomer.addActionListener(this);
report1.comReport.jrbCustomer.setActionCommand("report1.comReport.jrbCustomer");



about1=new About();
about1.cmdOk.addActionListener(this);
about1.cmdOk.setActionCommand("about1.cmdOk");

about1.addMouseListener(this);
about1.addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(about1,0);
        
         
	}
          });

changePass=new ChangePassword();
changePass.setVisible(false);
changePass.btnCancel.addActionListener(this);
changePass.btnCancel.setActionCommand("changePass.btnCancel");
changePass.btnChange.addActionListener(this);
changePass.btnChange.setActionCommand("changePass.btnChange");


manageUsers=new ManageUsers();
manageUsers.setVisible(false);
manageUsers.addUser.btnAdd.addActionListener(this);
manageUsers.addUser.btnAdd.setActionCommand("manageUsers.addUser.btnAdd");
manageUsers.addUser.btnClose.addActionListener(this);
manageUsers.addUser.btnClose.setActionCommand("manageUsers.addUser.btnClose");

manageUsers.deleteUser.btnDelete.addActionListener(this);
manageUsers.deleteUser.btnDelete.setActionCommand("manageUsers.deleteUser.btnDelete");
manageUsers.deleteUser.btnClose.addActionListener(this);
manageUsers.deleteUser.btnClose.setActionCommand("manageUsers.deleteUser.btnClose");


bill=new Bill();
bill.setVisible(false);
bill.btnGenerate.addActionListener(this);
bill.btnGenerate.setActionCommand("bill.btnGenerate");
bill.btnCancel.addActionListener(this);
bill.btnCancel.setActionCommand("bill.btnCancel");

bill.jcbCompany.addItemListener(this);
bill.jcbFirstName.addItemListener(this);
bill.jcbLastName.addItemListener(this);
bill.jcbSaleId.addItemListener(this);

bill.addMouseListener(this);
bill.addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(bill,0);
        
         
	}
          });
reorder=new ReorderLevel();
reorder.setVisible(false);
reorder.btnSet.addActionListener(this);
reorder.btnSet.setActionCommand("reorder.btnSet");
reorder.btnClose.addActionListener(this);
reorder.btnClose.setActionCommand("reorder.btnClose");
reorder.jcbManufacturer.addItemListener(this);


reorder.addMouseListener(this);
reorder.addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent me)
         {
         menu.getLayeredPane().setPosition(reorder,0);
        
         
	}
          });
		  
		  

menu=new MyMenu();

menu.getLayeredPane().add(cust);
menu.getLayeredPane().add(manu);
menu.getLayeredPane().add(emp);
menu.getLayeredPane().add(sale);
menu.getLayeredPane().add(prod);
menu.getLayeredPane().add(about1);
menu.getLayeredPane().add(order);
menu.getLayeredPane().add(view);
menu.getLayeredPane().add(pay);
menu.getLayeredPane().add(comp);
menu.getLayeredPane().add(report1);
menu.getLayeredPane().add(changePass);
menu.getLayeredPane().add(manageUsers);
menu.getLayeredPane().add(bill);
menu.getLayeredPane().add(reorder);
/*

menu.bg.panelBgImg.add(manu);
menu.bg.panelBgImg.add(emp);
menu.bg.panelBgImg.add(sale);
menu.bg.panelBgImg.add(prod);
menu.bg.panelBgImg.add(about1);
menu.bg.panelBgImg.add(order);
menu.bg.panelBgImg.add(view);
menu.bg.panelBgImg.add(pay);
menu.bg.panelBgImg.add(comp);
menu.bg.panelBgImg.add(report1);
*/


menu.btnCustomer.addActionListener(this);
menu.btnCustomer.setActionCommand("btnCustomer");
menu.btnManufacturer.addActionListener(this);
menu.btnManufacturer.setActionCommand("btnManufacturer");
menu.btnEmployee.addActionListener(this);
menu.btnEmployee.setActionCommand("btnEmployee");
menu.btnSale.addActionListener(this);
menu.btnSale.setActionCommand("btnSale");
menu.btnProduct.addActionListener(this);
menu.btnProduct.setActionCommand("btnProduct");
menu.btnOrder.addActionListener(this);
menu.btnOrder.setActionCommand("btnOrder");
menu.btnOrder.addActionListener(this);
menu.btnOrder.setActionCommand("btnOrder");
menu.btnView.addActionListener(this);
menu.btnView.setActionCommand("btnView");
menu.btnPayment.addActionListener(this);
menu.btnPayment.setActionCommand("btnPay");
menu.btnComplaint.addActionListener(this);
menu.btnComplaint.setActionCommand("btnComp");
menu.btnReport.addActionListener(this);
menu.btnReport.setActionCommand("btnReport");

menu.itemExit.setActionCommand("itemExit");
menu.itemExit.addActionListener(this);
menu.itemAbout.setActionCommand("itemabout1");
menu.itemAbout.addActionListener(this);
menu.itemMetal.addActionListener(this);
menu.itemMetal.setActionCommand("itemMetal");
menu.itemMotif.addActionListener(this);
menu.itemMotif.setActionCommand("itemMotif");
menu.itemWindows.addActionListener(this);
menu.itemWindows.setActionCommand("itemWindows");
menu.itemNimbus.addActionListener(this);
menu.itemNimbus.setActionCommand("itemNimbus");
menu.itemLiquid.addActionListener(this);
menu.itemLiquid.setActionCommand("itemLiquid");
menu.itemSystem.addActionListener(this);
menu.itemSystem.setActionCommand("itemSystem");


menu.itemChangePassword.addActionListener(this);
menu.itemChangePassword.setActionCommand("itemChangePassword");
menu.itemManageUsers.addActionListener(this);
menu.itemManageUsers.setActionCommand("itemManageUsers");
menu.itemBill.addActionListener(this);
menu.itemBill.setActionCommand("itemBill");
menu.itemReorder.addActionListener(this);
menu.itemReorder.setActionCommand("itemReorder");

menu.itemLogout.addActionListener(this);
menu.itemLogout.setActionCommand("itemLogout");

menu.itemChangePassword2.addActionListener(this);
menu.itemChangePassword2.setActionCommand("itemChangePassword2");
menu.itemLogout2.addActionListener(this);
menu.itemLogout2.setActionCommand("itemLogout2");

menu.setVisible(false);
cust.setVisible(false);
manu.setVisible(false);
emp.setVisible(false);
sale.setVisible(false);
prod.setVisible(false);
about1.setVisible(false);
order.setVisible(false);
view.setVisible(false);
pay.setVisible(false);
comp.setVisible(false);

border= LineBorder.createGrayLineBorder();
//splash.showSplashAndExit(); 
 // Wait a little while, maybe while loading resources
       try
        {
		for(int i=50;i<100;i++){
       Thread.sleep(5);
	   	progressBar.setString("Loading  "+i+"%");
	   progressBar.setValue(i);
}
        } catch (Exception e) {System.out.println("Error:5"+e);}
		
	setVisible(false);
	login.setVisible(true);
}
//-----------------------------------------------------------------------
//-----------------------------ACTION EVENT---------------------------------------------
//public void removeRow(){cust.editCust.jtModel.removeRow(row);}
public void actionPerformed(ActionEvent ae){

source=ae.getSource();

//-----------------------------MyLogin------------------------------------

if(source.equals(login.btnExit))
{
model.exit();
}

if(source.equals(login.btnLogin)){
//bflag=model.login(login.txtUsername,login.txtPassword);
bflag=true;
if(bflag) {
//login.dispose();
login.setVisible(false);
userName=login.txtUsername.getText();

menu.lblUserName.setFont(new java.awt.Font("Sans-Serif", Font.BOLD, 20));
menu.lblUser.setFont(new java.awt.Font("Sans-Serif", Font.BOLD, 20));
menu.lblUserName.setText(userName);

if(userName.toLowerCase().equals("admin")) {menu.mnuUser.setEnabled(false);menu.mnuAdmin.setEnabled(true);
manu.editManu.btnDelete.setEnabled(true);
prod.editProduct.btnDelete.setEnabled(true);
cust.editCust.btnDelete.setEnabled(true);
emp.editEmployee.btnDelete.setEnabled(true);
order.upOrder.btnDelete.setEnabled(true);
sale.viewSale.btnDelete.setEnabled(true);
comp.viewComplaint.btnDelete.setEnabled(true);
}
else {menu.mnuAdmin.setEnabled(false);
menu.mnuUser.setEnabled(true);
manu.editManu.btnDelete.setEnabled(false);
prod.editProduct.btnDelete.setEnabled(false);
cust.editCust.btnDelete.setEnabled(false);
emp.editEmployee.btnDelete.setEnabled(false);
order.upOrder.btnDelete.setEnabled(false);
sale.viewSale.btnDelete.setEnabled(false);
comp.viewComplaint.btnDelete.setEnabled(false);

}
login.txtUsername.setText("");
login.txtPassword.setText("");
menu.setVisible(true);
 Calendar now = Calendar.getInstance();
            int h = now.get(Calendar.HOUR_OF_DAY);
            int m = now.get(Calendar.MINUTE);
            int s = now.get(Calendar.SECOND);
			menu.lblLoginTime.setText("" + h + ":" + m + ":" + s);
}


}

//-----------------------------MyMenu------------------------------------

if(ae.getActionCommand().equals("itemMetal")){
try {
UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
SwingUtilities.updateComponentTreeUI(menu);
} 
catch (Exception e) {System.out.println("Error:6"+e);}
}

if(ae.getActionCommand().equals("itemMotif")){
try {
UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
SwingUtilities.updateComponentTreeUI(menu);
} 
catch (Exception e) {System.out.println("Error:7"+e);}

}
if(ae.getActionCommand().equals("itemWindows")){
	try {
   
           
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(menu);
		      } catch (Exception e) {System.out.println("Error:8"+e);}

}
if(ae.getActionCommand().equals("itemLiquid")){
	try {
   
           
			 UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			SwingUtilities.updateComponentTreeUI(menu);
		      
    
 
} catch (Exception e) {System.out.println("Error:9"+e);}

}
if(ae.getActionCommand().equals("itemNimbus")){
	try {
   
           
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(menu);
		      
    
 
} catch (Exception e) {System.out.println("Error:10"+e);}

}
if(ae.getActionCommand().equals("itemSystem")){
	try {
   
           
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(menu);
		      
    
 
} catch (Exception e) {System.out.println("Error:11"+e);}

}

if(ae.getActionCommand().equals("itemManageUsers")){

manageUsers.setVisible(true);
try{
strQuery="select username from login";
connect.executeQuery("query",strQuery);
manageUsers.deleteUser.jcbUser.removeAllItems();
manageUsers.deleteUser.jcbUser.addItem("Select");
while(connect.rs.next()){

manageUsers.deleteUser.jcbUser.addItem(connect.rs.getString(1));

}
}
catch(Exception e){System.out.println("Error:42"+e);}
manageUsers.deleteUser.jcbUser.setSelectedItem("Select");

}
if(ae.getActionCommand().equals("manageUsers.addUser.btnAdd")){
int user=0;
String p1=new String(manageUsers.addUser.txtNewPassword1.getPassword());
String p2=new String(manageUsers.addUser.txtNewPassword2.getPassword());
try{
strQuery="select * from login where username='"+manageUsers.addUser.txtUser.getText()+"'";
connect.executeQuery("query",strQuery);

while(connect.rs.next()){user=1;}




if(manageUsers.addUser.txtUser.getText().equals(""))
JOptionPane.showMessageDialog(null,"Username cannot be Empty" ,"Error",JOptionPane.ERROR_MESSAGE);

else if(user==1){
JOptionPane.showMessageDialog(null,"Username already exists, choose another name" ,"Error",JOptionPane.ERROR_MESSAGE);
}


else if(p1.equals("")){

JOptionPane.showMessageDialog(null,"Password cannot be Empty" ,"Error",JOptionPane.ERROR_MESSAGE);
}
else if(p2.equals(""))
JOptionPane.showMessageDialog(null,"Confirm Password cannot be Empty" ,"Error",JOptionPane.ERROR_MESSAGE);
else if(!p1.equals(p2)){
JOptionPane.showMessageDialog(null,"Passwords do not match!" ,"Error",JOptionPane.ERROR_MESSAGE);
manageUsers.addUser.txtNewPassword1.setText("");
manageUsers.addUser.txtNewPassword2.setText("");
}
else{
strQuery="insert into login values('"+manageUsers.addUser.txtUser.getText()+"','"+p1+"')";
connect.executeQuery("query",strQuery);

manageUsers.deleteUser.jcbUser.addItem(manageUsers.addUser.txtUser.getText());

JOptionPane.showMessageDialog(null,"User successfully Added!" ,"Information",JOptionPane.INFORMATION_MESSAGE);

manageUsers.addUser.txtUser.setText("");
manageUsers.addUser.txtNewPassword1.setText("");
manageUsers.addUser.txtNewPassword2.setText("");
}
}
catch(Exception e){System.out.println("Error:44"+e);}
}
if(ae.getActionCommand().equals("manageUsers.addUser.btnClose")){

manageUsers.setVisible(false);

}
if(ae.getActionCommand().equals("manageUsers.deleteUser.btnDelete")){

if(manageUsers.deleteUser.jcbUser.getSelectedItem().equals("Select")){
JOptionPane.showMessageDialog(null,"Select Username to delete" ,"Error",JOptionPane.ERROR_MESSAGE);
}
else{
try{
Object[] options = {"Yes", "No"};
                    int n = JOptionPane.showOptionDialog(null,
                                    "Are you sure you want to delete user "+manageUsers.deleteUser.jcbUser.getSelectedItem()+" ?",
                                    "Question",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                    if (n == JOptionPane.YES_OPTION) {

strQuery="delete from login where username='"+manageUsers.deleteUser.jcbUser.getSelectedItem()+"'";
connect.executeQuery("query",strQuery);

manageUsers.deleteUser.jcbUser.removeItem(manageUsers.deleteUser.jcbUser.getSelectedItem());

JOptionPane.showMessageDialog(null,"User successfully deleted" ,"Information",JOptionPane.INFORMATION_MESSAGE);
}
}
catch(Exception e){System.out.println("Error:43"+e);}
}



//manageUsers.setVisible(false);

}
if(ae.getActionCommand().equals("manageUsers.deleteUser.btnClose")){

manageUsers.setVisible(false);

}

if(ae.getActionCommand().equals("itemChangePassword")){
changePass.setVisible(true);
changePass.jcbUser.setEnabled(true);
try{
strQuery="select username from login";
connect.executeQuery("query",strQuery);
changePass.jcbUser.removeAllItems();
while(connect.rs.next()){

changePass.jcbUser.addItem(connect.rs.getString(1));

}
}catch(Exception e){System.out.println("Error:42"+e);}
changePass.jcbUser.setSelectedItem(userName);
}
if(ae.getActionCommand().equals("itemChangePassword2")){
changePass.setVisible(true);
changePass.jcbUser.setEnabled(false);
try{
strQuery="select username from login";
connect.executeQuery("query",strQuery);
changePass.jcbUser.removeAllItems();
while(connect.rs.next()){

changePass.jcbUser.addItem(connect.rs.getString(1));

}
}catch(Exception e){System.out.println("Error:42"+e);}
changePass.jcbUser.setSelectedItem(userName);
}
if(ae.getActionCommand().equals("itemLogout")){
menu.dispose();
login.txtUsername.setText("");
login.txtPassword.setText("");
//menu=new MyMenu();

JOptionPane.showMessageDialog(null,"You have successfully logged out" ,"Information",JOptionPane.INFORMATION_MESSAGE);
//login =new MyLogin();
login.setVisible(true);
login.txtUsername.requestFocus();
}

if(ae.getActionCommand().equals("itemLogout2")){
menu.dispose();
login.txtUsername.setText("");
login.txtPassword.setText("");
JOptionPane.showMessageDialog(null,"You have successfully logged out" ,"Information",JOptionPane.INFORMATION_MESSAGE);
//login =new MyLogin();
login.setVisible(true);
login.txtUsername.requestFocus();
}

if(ae.getActionCommand().equals("itemBill")){
bill.setVisible(true);

try{
bill.jcbCompany.removeAllItems();


bill.jcbCompany.addItem("Select");

strQuery="select cust_company from customer order by cust_company";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
bill.jcbCompany.addItem(connect.rs.getString(1));

}

}
catch(Exception e){System.out.println("Error:4"+e);}
}


if(ae.getActionCommand().equals("bill.btnCancel")){
bill.setVisible(false);

}


if(ae.getActionCommand().equals("bill.btnGenerate")){
if(bill.jcbSaleId.getSelectedItem().equals("Select")){JOptionPane.showMessageDialog(null,"Select sale Id to generate Bill" ,"Error",JOptionPane.ERROR_MESSAGE);}
else{

try {


            OutputStream file = new FileOutputStream(new File("C:\\Bill.pdf"));
 
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            document.add(new Paragraph("HNET POS"));
			document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
			document.add(new Paragraph(""));
            document.add(new Paragraph(new Date().toString()));
			 Paragraph p1=new Paragraph("Bill");
  document.add(p1);
 document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------"));
 CMYKColor color = new CMYKColor( 0, 1, (float)0.2, (float)0.667 );
String text = "kievan wrote more: different color and font type.";
Font o = FontFactory.getFont( FontFactory.TIMES_BOLD, 14, Font.BOLD, color );
document.add(new Paragraph("sale Id : "+bill.jcbSaleId.getSelectedItem()+"      "+"Customer Details :"+bill.jcbFirstName.getSelectedItem()+" "+bill.jcbLastName.getSelectedItem(),o));

document.add(new Paragraph(""));
document.add(new Paragraph(""));
 document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------"));
 PdfPTable table1=new PdfPTable(5);
 table1.addCell("Manufacturer");
 table1.addCell("Product");

 table1.addCell("Quantity");

 table1.addCell("Amount");

 table1.addCell("Sale_Date");
 document.add(table1);
  //Paragraph p2=new Paragraph("Manufacturer|Product |Quantity | Amount |Purchase_Date ",o);
  //document.add(p2);
String mname="";
String pname="";
  int total=0;

strQuery="select * from sale1 where sale_id1="+bill.jcbSaleId.getSelectedItem()+"";
 connect.executeQuery("query",strQuery);
 while(connect.rs.next()){
 strQuery="select product_name from product where product_id="+connect.rs.getString(4)+"";
 connect2.executeQuery("query",strQuery);
 while(connect2.rs.next()){
  pname=connect2.rs.getString(1);
 }
 
 strQuery="select manu_name from manufacturer where manu_id=(select manu_id from product where product_id="+connect.rs.getString(4)+")";
 connect3.executeQuery("query",strQuery);
 while(connect3.rs.next()){
  mname=connect3.rs.getString(1);
 }
 PdfPTable table=new PdfPTable(5);
       table.addCell(mname);
       table.addCell(pname);
       table.addCell(connect.rs.getString(5));
       table.addCell(connect.rs.getString(6));
	   table.addCell(connect.rs.getString(7));
       document.add(table);
 //Paragraph p=new Paragraph(mname+"            "+pname+""+connect.rs.getString(5)+"    "+connect.rs.getString(6)+"    "+connect.rs.getString(7));
  //document.add(p);
  total+=connect.rs.getInt(6);
 }
 
 document.add(new Paragraph(""));
   document.add(new Paragraph("Total Amount : "+total,o));
 document.addAuthor("DrAGoN");
document.addCreationDate();
document.addCreator("iText library");
document.addTitle("My First PDF");
 
            document.close();
            file.close();
 
    if(Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
			Desktop.getDesktop().open(new File("C:\\Bill.pdf"));}
        } catch (Exception e) {
 System.out.println("Error:33"+e);
            e.printStackTrace();
        }



}


}

if(ae.getActionCommand().equals("itemReorder")){
reorder.setVisible(true);

}



if(ae.getActionCommand().equals("btnCustomer")){
/*
manu.setVisible(false);
emp.setVisible(false);
sale.setVisible(false);
prod.setVisible(false);
about1.setVisible(false);
order.setVisible(false);
view.setVisible(false);
pay.setVisible(false);
comp.setVisible(false);
report1.setVisible(false);
*/
menu.getLayeredPane().setPosition(cust,0);
cust.setVisible(true);

cust.addCust.txtFirstName.requestFocus();
}

if(ae.getActionCommand().equals("btnManufacturer")){
/*
cust.setVisible(false);
emp.setVisible(false);
sale.setVisible(false);
prod.setVisible(false);
about1.setVisible(false);
order.setVisible(false);
view.setVisible(false);
pay.setVisible(false);
comp.setVisible(false);
report1.setVisible(false);
*/
menu.getLayeredPane().setPosition(manu,0);
manu.setVisible(true);
/*
try {
if(Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
			Desktop.getDesktop().open(new File("C:\\Test.pdf"));}

            OutputStream file = new FileOutputStream(new File("C:\\Manufacturer Report.pdf"));
 
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            document.add(new Paragraph("JEHOVAH"));
            document.add(new Paragraph(new Date().toString()));
			 Paragraph p1=new Paragraph("MANUFACTURER REPORT");
  document.add(p1);
 document.add(new Paragraph("---------------------------------------------------------------------------------"));
 CMYKColor color = new CMYKColor( 0, 1, (float)0.2, (float)0.667 );
String text = "kievan wrote more: different color and font type.";
Font o = FontFactory.getFont( FontFactory.TIMES_BOLD, 14, Font.BOLD, color );
  Paragraph p2=new Paragraph("Manu_Id     Manu_Name",o);
  document.add(p2);
 
 strQuery="select * from manufacturer";
 connect.executeQuery("query",strQuery);
 while(connect.rs.next()){
 Paragraph p=new Paragraph(connect.rs.getString(1)+"                       "+connect.rs.getString(2));
  document.add(p);
 }
 document.addAuthor("DrAGoN");
document.addCreationDate();
document.addCreator("iText library");
document.addTitle("My First PDF");
 
            document.close();
            file.close();
 
        } catch (Exception e) {
 System.out.println("Error:33"+e);
            e.printStackTrace();
        }
   
		*/
manu.addManu.txtName.requestFocus();
}

if(ae.getActionCommand().equals("btnEmployee")){
/*
cust.setVisible(false);
manu.setVisible(false);
sale.setVisible(false);
prod.setVisible(false);
about1.setVisible(false);
order.setVisible(false);
view.setVisible(false);
pay.setVisible(false);
comp.setVisible(false);
report1.setVisible(false);
*/
//cust.setOpaque(true);
//manu.setOpaque(false);
menu.getLayeredPane().setPosition(emp,0);
emp.setVisible(true);
}
if(ae.getActionCommand().equals("btnSale")){
/*
cust.setVisible(false);
manu.setVisible(false);
emp.setVisible(false);
prod.setVisible(false);
about1.setVisible(false);
order.setVisible(false);
pay.setVisible(false);
comp.setVisible(false);
view.setVisible(false);
report1.setVisible(false);
*/
menu.getLayeredPane().setPosition(sale,0);
sale.addSale.txtSearch.setText("");

//dc1=new Object[10][10];
//m=0;
Object[][] dc3=new Object[0][0];
final Object[] header={"Product Name","Price","Quantity","Amount"};

//-------------------------------------------view sale------------------------------------
/*
Object[][] vo = model.overAllView("sale1","sale_Date",9);
 final Object[] headersale={"sale Id1","sale Id2","Customer Id","Product Id","Quantity","Amount","O_date","S_date","Status"};
 DefaultTableModel jtModelsale=new DefaultTableModel(vo,headersale);
sale.viewSale.jtViewSale.setModel(jtModelsale);
*/
try{
int j=0;
strQuery="select * from sale1";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){j++;}
strQuery="select * from sale1";
connect.executeQuery("query",strQuery);
Object[][] obj=new Object[j][9];
int i=0;
while(connect.rs.next()){
obj[i][0]=connect.rs.getInt(1);
obj[i][1]=connect.rs.getInt(2);;
obj[i][2]=connect.rs.getInt(3);;
obj[i][3]=connect.rs.getInt(4);;
obj[i][4]=connect.rs.getInt(5);;
obj[i][5]=connect.rs.getInt(6);;
obj[i][6]=connect.rs.getString(7);;
obj[i][7]=connect.rs.getString(8);;
obj[i][8]=connect.rs.getString(9);;
i++;
}
final Object[] headersale={"sale Id1","sale Id2","Customer Id","Product Id","Quantity","Amount","O_date","S_date","Status"};
 DefaultTableModel jtModelsale=new DefaultTableModel(obj,headersale);
sale.viewSale.jtViewSale.setModel(jtModelsale);
}
catch(Exception e){System.out.println("Error:41"+e);}


DefaultTableModel jtModel=new DefaultTableModel(dc3,header);
sale.addSale.jtAddProduct.setModel(jtModel);
rows=0;
try{
strQuery="delete from sale2 ";
connect.executeQuery("update",strQuery);
}catch(Exception e){System.out.println("Error:12"+e);}


try{
sale.addSale.jcbManufacturer.removeAllItems();


strQuery="select * from manufacturer order by manu_name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
sale.addSale.jcbManufacturer.addItem(connect.rs.getString(2));

}

}
catch(Exception e){System.out.println("Error:13"+e);}
try{
sale.addSale.jcbCompany.removeAllItems();
sale.updateSale.jcbCompany.removeAllItems();

sale.addSale.jcbCompany.addItem("Select");
sale.updateSale.jcbCompany.addItem("Select");
strQuery="select cust_company from customer order by cust_company";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
sale.addSale.jcbCompany.addItem(connect.rs.getString(1));
sale.updateSale.jcbCompany.addItem(connect.rs.getString(1));
}

}
catch(Exception e){System.out.println("Error:14"+e);}

sale.setVisible(true);

}
if(ae.getActionCommand().equals("btnProduct")){
/*
cust.setVisible(false);
manu.setVisible(false);
emp.setVisible(false);
sale.setVisible(false);
order.setVisible(false);
about1.setVisible(false);
pay.setVisible(false);
comp.setVisible(false);
view.setVisible(false);
report1.setVisible(false);
*/
menu.getLayeredPane().setPosition(prod,0);
try{
prod.addProduct.jcbManufacturer.removeAllItems();
prod.editProduct.jcbManufacturer.removeAllItems();

strQuery="select * from manufacturer order by manu_name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
prod.addProduct.jcbManufacturer.addItem(connect.rs.getString(2));
prod.editProduct.jcbManufacturer.addItem(connect.rs.getString(2));
}

}
catch(Exception e){System.out.println("Error:15"+e);}

prod.setVisible(true);
}

if(ae.getActionCommand().equals("btnOrder")){
/*
cust.setVisible(false);
manu.setVisible(false);
emp.setVisible(false);
prod.setVisible(false);
about1.setVisible(false);
sale.setVisible(false);
pay.setVisible(false);
comp.setVisible(false);
view.setVisible(false);
report1.setVisible(false);
*/
menu.getLayeredPane().setPosition(order,0);
/*try{
order.upOrder.jcbManufacturer.removeAllItems();
order.upOrder.jcbManufacturer.addItem("Select");
strQuery="select * from manufacturer order by manu_name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
order.upOrder.jcbManufacturer.addItem(connect.rs.getString(2));

}}catch(Exception e){System.out.println("Error:16"+e);}*/
try{
order.adOrder.jcbManufacturer.removeAllItems();
order.adOrder.jcbManufacturer.addItem("Select");
strQuery="select * from manufacturer order by manu_name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
order.adOrder.jcbManufacturer.addItem(connect.rs.getString(2));

}
}
catch(Exception e){System.out.println("Error:16"+e);}
try{
int j=0;
strQuery="select * from purchase_order";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){j++;}
Object[][] objs=new Object[j][8];
strQuery="select * from purchase_order";
connect.executeQuery("query",strQuery);
int i=0;
while(connect.rs.next()){
 objs[i][0]=connect.rs.getInt(1);
 objs[i][1]=connect.rs.getInt(2);
 objs[i][2]=connect.rs.getInt(3);
 objs[i][3]=connect.rs.getInt(4);
objs[i][4]=connect.rs.getFloat(5);
objs[i][5]=connect.rs.getString(6);
objs[i][6]=connect.rs.getString(7);
objs[i][7]=connect.rs.getString(8);
 i++;
 }
 final Object[] header={"Purchase Id","Manufacturer Id","Product Id","Quantity","Amount","Order Date","Received Date","Status"};

 DefaultTableModel jtModel=new DefaultTableModel(objs,header);
 order.upOrder.jtOrder.setModel(jtModel);
 }
catch(Exception e){System.out.println("Error:37"+e);}

order.setVisible(true);
}
if(ae.getActionCommand().equals("btnView")){
/*
cust.setVisible(false);
manu.setVisible(false);
emp.setVisible(false);
prod.setVisible(false);
about1.setVisible(false);
sale.setVisible(false);
pay.setVisible(false);
comp.setVisible(false);
order.setVisible(false);
report1.setVisible(false);
*/
menu.getLayeredPane().setPosition(view,0);

view.viewCust.txtCustomerName.addKeyListener(this);	
view.viewManu.txtManufacturerName.addKeyListener(this);	
//---------------------------------------view customer---------------------------------
Object[][] vc = model.overAllView("Customer","Cust_id",10);
 final Object[] headerCust={"id","First Name","Last Name","State","Area","Address","Contactno.","Email","Company","Pincode"};
 DefaultTableModel jtModelCust=new DefaultTableModel(vc,headerCust);
view.viewCust.jtViewCustomer.setModel(jtModelCust);
//----------------------------------------view Manufacturer-----------------------------
Object[][] vm = model.overAllView("Manufacturer","Manu_id",9);
 final Object[] headerManu={"id","Manufacturer","State","Area","Address","Contactno.","Email","Pincode","Vat"};
 DefaultTableModel jtModelManu=new DefaultTableModel(vm,headerManu);
view.viewManu.jtViewManufacturer.setModel(jtModelManu);
//-----------------------------------------view Product----------------------------------
Object[][] vp = model.overAllView("Product","Product_id",8);

 final Object[] headerProduct={"product id","Manufacturer id","Product Name","MRP","Customer Price","Unit_Quantity","Unit_Purchase_Price","Unit_Selling_Price"};
 DefaultTableModel jtModelProduct=new DefaultTableModel(vp,headerProduct);
view.viewProd.jtViewProduct.setModel(jtModelProduct);
//-------------------------------------------view Stock------------------------------------
Object[][] vs = model.overAllView("stock","stock_id",3);
 final Object[] headerorder={"Stock Id","Product Id","Quantity"};
 DefaultTableModel jtModelorder=new DefaultTableModel(vs,headerorder);
view.viewStock.jtViewStock.setModel(jtModelorder);



view.setVisible(true);


}
if(ae.getActionCommand().equals("btnPay")){
/*
cust.setVisible(false);
manu.setVisible(false);
emp.setVisible(false);
sale.setVisible(false);
prod.setVisible(false);
order.setVisible(false);
view.setVisible(false);
about1.setVisible(false);
comp.setVisible(false);
report1.setVisible(false);
*/
try{
int j=0;
strQuery="select * from payment";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){j++;}
Object[][] obj=new Object[j][4];
int i=0;
strQuery="select * from payment";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
obj[i][0]=connect.rs.getInt(2);
obj[i][1]=connect.rs.getFloat(3);
obj[i][2]=connect.rs.getString(4);
obj[i][3]=connect.rs.getString(5);
//obj[i][4]=connect.rs.getString(5);
i++;
}
 final Object[] header={"sale Id","Amount","Date","Status"};

 DefaultTableModel jtModel=new DefaultTableModel(obj,header);
 pay.jtViewPayment.setAutoResizeMode(3);
pay.jtViewPayment.setModel(jtModel);
}
catch(Exception e){System.out.println("Error:43"+e);}
menu.getLayeredPane().setPosition(pay,0);
pay.setVisible(true);



}
if(ae.getActionCommand().equals("btnComp")){
/*
cust.setVisible(false);
manu.setVisible(false);
emp.setVisible(false);
sale.setVisible(false);
prod.setVisible(false);
order.setVisible(false);
view.setVisible(false);
about1.setVisible(false);
pay.setVisible(false);
report1.setVisible(false);
*/

try{
int j=0;
strQuery="select * from complaint";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){j++;}
Object[][] objs=new Object[j][8];
strQuery="select * from complaint";
connect.executeQuery("query",strQuery);
int i=0;
while(connect.rs.next()){
 objs[i][0]=connect.rs.getInt(1);
 objs[i][1]=connect.rs.getInt(2);
 objs[i][2]=connect.rs.getInt(3);
 objs[i][3]=connect.rs.getInt(4);
objs[i][4]=connect.rs.getInt(5);
objs[i][5]=connect.rs.getString(6);
objs[i][6]=connect.rs.getString(7);
objs[i][7]=connect.rs.getString(8);
 i++;
 }
 final Object[] header={"Complaint Id","sale Id1","sale Id2","Product Id","Customer_Id","Description","Date","Status"};

 DefaultTableModel jtModel=new DefaultTableModel(objs,header);
comp.viewComplaint.jtViewComplaint.setModel(jtModel);
 }
catch(Exception e){System.out.println("Error:37"+e);}

try{
comp.addComplaint.jcbCompany.removeAllItems();


comp.addComplaint.jcbCompany.addItem("Select");

strQuery="select cust_company from customer order by cust_company";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
comp.addComplaint.jcbCompany.addItem(connect.rs.getString(1));

}

}
catch(Exception e){System.out.println("Error:4"+e);}

menu.getLayeredPane().setPosition(comp,0);
comp.setVisible(true);
}

if(ae.getActionCommand().equals("btnReport")){
/*
cust.setVisible(false);
manu.setVisible(false);
emp.setVisible(false);
sale.setVisible(false);
prod.setVisible(false);
order.setVisible(false);
view.setVisible(false);
about1.setVisible(false);
pay.setVisible(false);
comp.setVisible(false);
report1.setVisible(false);
*/

try{
report1.salReport.jcbManufacturer.removeAllItems();
report1.salReport.jcbManufacturer.addItem("Select");
strQuery="select * from manufacturer order by manu_name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
report1.salReport.jcbManufacturer.addItem(connect.rs.getString(2));

}
}
catch(Exception e){System.out.println("Error:16"+e);}

report1.setVisible(true);
menu.getLayeredPane().setPosition(report1,0);
}

if(ae.getActionCommand().equals("itemabout1")){
/*
cust.setVisible(false);
manu.setVisible(false);
emp.setVisible(false);
sale.setVisible(false);
prod.setVisible(false);
order.setVisible(false);
view.setVisible(false);
pay.setVisible(false);
comp.setVisible(false);
report1.setVisible(false);
*/
menu.getLayeredPane().setPosition(about1,0);
about1.setVisible(true);
about1.requestFocus();
}
if(ae.getActionCommand().equals("itemExit")){
model.exit();
}//---------------------------------------CHANGE PASSWORD-------------------------------------------
if(ae.getActionCommand().equals("changePass.btnCancel")){
changePass.setVisible(false);
}

if(ae.getActionCommand().equals("changePass.btnChange")){

String p1=new String(changePass.txtOldPassword.getPassword());
String p2=new String(changePass.txtNewPassword1.getPassword());
String p3=new String(changePass.txtNewPassword2.getPassword());
try{ 
if(p1.equals("")){JOptionPane.showMessageDialog(null,"Enter Existing Password" ,"Error",JOptionPane.ERROR_MESSAGE);}
else if(p2.equals("")){JOptionPane.showMessageDialog(null,"Enter New Password" ,"Error",JOptionPane.ERROR_MESSAGE);}
else if(p3.equals("")){JOptionPane.showMessageDialog(null,"Re-Enter New Password" ,"Error",JOptionPane.ERROR_MESSAGE);}

else if(p2.equals(p3)){
strQuery="select password from login where 	username='"+changePass.jcbUser.getSelectedItem()+"'";
connect.executeQuery("query",strQuery);
int p=0;
while(connect.rs.next()){
if(p1.equals(connect.rs.getString(1))){p=1;
strQuery="update login set password='"+p2+"' where username='"+changePass.jcbUser.getSelectedItem()+"'";
connect2.executeQuery("update",strQuery);
JOptionPane.showMessageDialog(null,"Old Password Changed" ,"Information",JOptionPane.INFORMATION_MESSAGE);
changePass.txtOldPassword.setText("");
changePass.txtNewPassword1.setText("");
changePass.txtNewPassword2.setText("");
}

}
if(p==0){JOptionPane.showMessageDialog(null,"Old Password Does not match" ,"Error",JOptionPane.ERROR_MESSAGE);}
}
else{JOptionPane.showMessageDialog(null,"Passwords do not match" ,"Error",JOptionPane.ERROR_MESSAGE);}
}
catch(Exception e){System.out.println("Error:42"+e);}
}
//---------------------------------------ABOUT-------------------------------------------
if(ae.getActionCommand().equals("about1.cmdOk")){
about1.setVisible(false);

}//---------------------------------------PAYMENT-------------------------------------------
if(ae.getActionCommand().equals("pay.btnCancel")){
pay.setVisible(false);
}


if(ae.getActionCommand().equals("pay.btnUpdate")){

if(i4==0){JOptionPane.showMessageDialog(null,"Select a row to update" ,"Error",JOptionPane.ERROR_MESSAGE);}
else{
Object[] options = {"Yes", "No"};
                    int n = JOptionPane.showOptionDialog(null,
                                    "Are you sure you want to update payment",
                                    "Question",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                    if (n == JOptionPane.YES_OPTION) {
strQuery="update payment set payment_status='Complete' where payment_id="+i4+"";
connect.executeQuery("update",strQuery);
i4=0;
}
}
menu.btnPayment.doClick();

}




//---------------------------------------order-------------------------------------------
/*if(ae.getActionCommand().equals("upOrder.btnUpdate")){
model.updateorder(s4,order.upOrder.txtAddorder,order.upOrder.txtDamage);
Object[][] dc=model.searchOrder(order.upOrder.jcbManufacturer,order.upOrder.txtSearch);
s4="";
 final Object[] header={"order Id","Product Name","order"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
order.upOrder.jtOrder.setModel(jtModel);
}*/
if(ae.getActionCommand().equals("upOrder.btnCancel")){
order.setVisible(false);

}


if(ae.getActionCommand().equals("upOrder.btnUpdate")){
if(s4.equals("")) {JOptionPane.showMessageDialog(null,"Select Row to Update" ,"Error",JOptionPane.ERROR_MESSAGE);}
else if(s18.equals("Complete")){JOptionPane.showMessageDialog(null,"This Delivery is Already Complete, select another row" ,"Error",JOptionPane.ERROR_MESSAGE);}
else{
Object[] options = {"Yes", "No"};
                    int n = JOptionPane.showOptionDialog(null,
                                    "Are you sure you want to update data",
                                    "Question",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                    if (n == JOptionPane.YES_OPTION) {
strQuery="update purchase_order set purchase_status='Complete',purchase_received_date='"+order.upOrder.lblCurrentDate.getText()+"' where purchase_id="+s4+" and product_id="+s17+"";
connect.executeQuery("update",strQuery);
//s4="";


try{

strQuery="select product_id,purchase_quantity from purchase_order where purchase_id="+s4+"and product_id="+s17+"";
connect2.executeQuery("query",strQuery);

while(connect2.rs.next()){
int quantity=0;
strQuery="select stock_quantity from stock where product_id="+connect2.rs.getString(1)+" ";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){quantity=connect.rs.getInt(1);}
quantity+=connect2.rs.getInt(2);
i1=0;
strQuery="update stock set stock_quantity="+quantity+" where product_id="+connect2.rs.getString(1)+"";
connect.executeQuery("update",strQuery);

s17="";
}

}
catch(Exception e){System.out.println("Error:39"+e);}
//s4="";
try{
int j=0;
strQuery="select * from purchase_order";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){j++;}
Object[][] objs=new Object[j][8];
strQuery="select * from purchase_order";
connect.executeQuery("query",strQuery);
int i=0;
while(connect.rs.next()){
 objs[i][0]=connect.rs.getInt(1);
 objs[i][1]=connect.rs.getInt(2);
 objs[i][2]=connect.rs.getInt(3);
 objs[i][3]=connect.rs.getInt(4);
objs[i][4]=connect.rs.getFloat(5);
objs[i][5]=connect.rs.getString(6);
objs[i][6]=connect.rs.getString(7);
objs[i][7]=connect.rs.getString(8);
 i++;
 }
 final Object[] header={"Purchase Id","Manufacturer Id","Product Id","Quantity","Amount","Order Date","Received Date","Status"};

 DefaultTableModel jtModel=new DefaultTableModel(objs,header);
 order.upOrder.jtOrder.setModel(jtModel);
 }
catch(Exception e){System.out.println("Error:38"+e);}
}
}
/*
try {


            OutputStream file = new FileOutputStream(new File("C:\\PurchaseReport.pdf"));
 
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            document.add(new Paragraph("SEERAN'S SUPPLIERS"));
			document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
			document.add(new Paragraph(""));
            document.add(new Paragraph(new Date().toString()));
			 Paragraph p1=new Paragraph("PURCHASE REPORT");
  document.add(p1);
 document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------"));
 CMYKColor color = new CMYKColor( 0, 1, (float)0.2, (float)0.667 );
String text = "kievan wrote more: different color and font type.";
Font o = FontFactory.getFont( FontFactory.TIMES_BOLD, 14, Font.BOLD, color );
document.add(new Paragraph("Purchase_Id : "+s4,o));
  Paragraph p2=new Paragraph("Manu_Id | Product_Id | Quantity | Amount |Purchase_Date ",o);
  document.add(p2);

  int total=0;
  
strQuery="select * from purchase_order where purchase_id="+s4+"";
 connect.executeQuery("query",strQuery);
 while(connect.rs.next()){
 Paragraph p=new Paragraph(connect.rs.getString(2)+"                    "+connect.rs.getString(3)+"                  "+connect.rs.getString(4)+"               "+connect.rs.getString(5)+"       "+connect.rs.getString(6));
  document.add(p);
  total+=connect.rs.getInt(5);
 }
 document.add(new Paragraph(""));
   document.add(new Paragraph("							Total Amount : "+total,o));
 document.addAuthor("DrAGoN");
document.addCreationDate();
document.addCreator("iText library");
document.addTitle("My First PDF");
 
            document.close();
            file.close();
 
    if(Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
			Desktop.getDesktop().open(new File("C:\\PurchaseReport.pdf"));}
        } catch (Exception e) {
 System.out.println("Error:33"+e);
            e.printStackTrace();
        }
*/
s4="";

}


if(ae.getActionCommand().equals("upOrder.btnDelete")){
if(s4.equals("")) {JOptionPane.showMessageDialog(null,"Select Row to Delete" ,"Error",JOptionPane.ERROR_MESSAGE);}
else{
Object[] options = {"Yes", "No"};
                    int n = JOptionPane.showOptionDialog(null,
                                    "Are you sure you want to delete data",
                                    "Question",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                    if (n == JOptionPane.YES_OPTION) {
strQuery="delete from purchase_order where purchase_id="+s4+"";
connect.executeQuery("update",strQuery);
s4="";
try{
int j=0;
strQuery="select * from purchase_order";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){j++;}
Object[][] objs=new Object[j][8];
strQuery="select * from purchase_order";
connect.executeQuery("query",strQuery);
int i=0;
while(connect.rs.next()){
 objs[i][0]=connect.rs.getInt(1);
 objs[i][1]=connect.rs.getInt(2);
 objs[i][2]=connect.rs.getInt(3);
 objs[i][3]=connect.rs.getInt(4);
objs[i][4]=connect.rs.getFloat(5);
objs[i][5]=connect.rs.getString(6);
objs[i][6]=connect.rs.getString(7);
objs[i][7]=connect.rs.getString(8);
 i++;
 }
 final Object[] header={"Purchase Id","Manufacturer Id","Product Id","Quantity","Amount","Order Date","Received Date","Status"};

 DefaultTableModel jtModel=new DefaultTableModel(objs,header);
 order.upOrder.jtOrder.setModel(jtModel);
 }
catch(Exception e){System.out.println("Error:38"+e);}
}
}
}


if(ae.getActionCommand().equals("adOrder.btnCancel")){
order.setVisible(false);
order.adOrder.jcbManufacturer.setEnabled(true);
}
if(ae.getActionCommand().equals("adOrder.btnAdd")){

if(order.adOrder.jcbManufacturer.getSelectedItem().equals("Select")) {
JOptionPane.showMessageDialog(null,"Select Manufacturer" ,"Error",JOptionPane.ERROR_MESSAGE);}
else if(order.adOrder.jcbProduct.getSelectedItem().equals("Select")) {
JOptionPane.showMessageDialog(null,"Select Product" ,"Error",JOptionPane.ERROR_MESSAGE);}

else{
order.adOrder.jcbManufacturer.setEnabled(false);
try{

float amount=0;
strQuery="select box_price from product where product_name='"+order.adOrder.jcbProduct.getSelectedItem()+"'";
connect.executeQuery("query",strQuery);
connect.rs.next();
int obj=(Integer)order.adOrder.jsQuantity.getValue();
amount =obj * connect.rs.getFloat(1);
int quantity=(Integer)order.adOrder.jsQuantity.getValue();
System.out.println(amount);
int match=0;
strQuery="select * from tmp_purchase_order where manu_name='"+order.adOrder.jcbManufacturer.getSelectedItem()+"' and product_name='"+order.adOrder.jcbProduct.getSelectedItem()+"'";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){match=1;

quantity+=connect.rs.getInt(3);
amount+=connect.rs.getFloat(4);
System.out.println(match);
}

if(match==1){
strQuery="update tmp_purchase_order set purchase_quantity="+quantity+",purchase_amount="+amount+" where manu_name='"+order.adOrder.jcbManufacturer.getSelectedItem()+"' and product_name='"+order.adOrder.jcbProduct.getSelectedItem()+"'";
connect.executeQuery("update",strQuery);
}
else{
strQuery="insert into tmp_purchase_order values('"+order.adOrder.jcbManufacturer.getSelectedItem()+"','"+order.adOrder.jcbProduct.getSelectedItem()+"',"+quantity+","+amount+",'"+order.upOrder.lblCurrentDate.getText()+"') ";
connect.executeQuery("update",strQuery);
}
int j=0;
strQuery="select * from tmp_purchase_order";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){j++;}
Object[][] objs=new Object[j][5];
strQuery="select * from tmp_purchase_order";
connect.executeQuery("query",strQuery);
int i=0;
while(connect.rs.next()){
 objs[i][0]=connect.rs.getString(1);
 objs[i][1]=connect.rs.getString(2);
 objs[i][2]=connect.rs.getInt(3);
 objs[i][3]=connect.rs.getFloat(4);
  objs[i][4]=connect.rs.getString(5);
 i++;
 }
 final Object[] header={"Manufacturer","Product","Quantity","Amount","Date"};

 DefaultTableModel jtModel=new DefaultTableModel(objs,header);
 order.adOrder.jtOrder.setModel(jtModel);
}catch(Exception e){System.out.println("Error:35"+e);}
}
}


if(ae.getActionCommand().equals("adOrder.btnSave")){
try{

int save2=0;
strQuery="select * from tmp_purchase_order";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
save2=1;
}
if(save2==0){JOptionPane.showMessageDialog(null,"Add to Save" ,"Error",JOptionPane.ERROR_MESSAGE);}
else{
Object[] options = {"Yes", "No"};
                    int n = JOptionPane.showOptionDialog(null,
                                    "Are you sure you want to save data",
                                    "Question",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                    if (n == JOptionPane.YES_OPTION) {



strQuery="select * from purchase_order order by purchase_Id";

connect2.executeQuery("query",strQuery);

if(connect2.rs.next()) {connect2.rs.beforeFirst();
int i=1,j=0;
while(connect2.rs.next()){

}
connect2.rs.last();
if(j==0) pkey=connect2.rs.getInt(1)+1;
}
else{
pkey=1;
}
System.out.println("pkey P"+pkey);


strQuery="select * from tmp_purchase_order";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){



int manu_id=0,product_id=0;
strQuery="select manu_id from manufacturer where manu_name='"+connect.rs.getString(1)+"'";
connect2.executeQuery("query",strQuery);
while(connect2.rs.next()){
manu_id=connect2.rs.getInt(1);}

strQuery="select product_id from product where product_name='"+connect.rs.getString(2)+"'";
connect2.executeQuery("query",strQuery);
while(connect2.rs.next()){
product_id=connect2.rs.getInt(1);}

strQuery="insert into purchase_order(purchase_id,manu_id,product_id,purchase_quantity,purchase_amount,purchase_order_date,purchase_status) values("+pkey+","+manu_id+","+product_id+","+connect.rs.getInt(3)+","+connect.rs.getFloat(4)+",'"+order.upOrder.lblCurrentDate.getText()+"','pending')";
connect2.executeQuery("update",strQuery);
//pkey++;
}

strQuery="delete from tmp_purchase_order";
connect.executeQuery("update",strQuery);
//if(save==1)
JOptionPane.showMessageDialog(null,"Save Successful" ,"Information",JOptionPane.INFORMATION_MESSAGE);
order.adOrder.jcbManufacturer.setEnabled(true);
Object obj=order.adOrder.jcbManufacturer.getSelectedItem();
menu.btnOrder.doClick();
order.adOrder.jcbManufacturer.removeItem(obj);
//order.adOrder.jcbManufacturer.removeItemAt(order.adOrder.jcbManufacturer.getSelectedIndex());
}
}
//else JOptionPane.showMessageDialog(null,"Add to Save" ,"Error",JOptionPane.ERROR_MESSAGE);
}
catch(Exception e){System.out.println("Error:36"+e);}
Object[][] objs=new Object[0][0];

 final Object[] header={"Manufacturer","Product","Quantity","Amount","Date"};

 //DefaultTableModel jtModel=new DefaultTableModel(objs,header);
 TableModel jtModel = new DefaultTableModel(objs,header) {
    public boolean isCellEditable(int rowIndex, int mColIndex) {
        return false;
    }
};
 
 order.adOrder.jtOrder.setModel(jtModel);

}


if(ae.getActionCommand().equals("adOrder.btnDelete")){
if(s14.equals("")) {JOptionPane.showMessageDialog(null,"Select Row to Delete" ,"Error",JOptionPane.ERROR_MESSAGE);}
else{
strQuery="delete from tmp_purchase_order where manu_name='"+s14+"' and product_name='"+s15+"'";
connect.executeQuery("update",strQuery);
s14="";s15="";

try{
int j=0;
strQuery="select * from tmp_purchase_order";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){j++;}
Object[][] objs=new Object[j][5];
strQuery="select * from tmp_purchase_order";
connect.executeQuery("query",strQuery);
int i=0;
while(connect.rs.next()){
 objs[i][0]=connect.rs.getString(1);
 objs[i][1]=connect.rs.getString(2);
 objs[i][2]=connect.rs.getInt(3);
 objs[i][3]=connect.rs.getFloat(4);
  objs[i][4]=connect.rs.getString(5);
 i++;
 }
 if(j==0) order.adOrder.jcbManufacturer.setEnabled(true);
 final Object[] header={"Manufacturer","Product","Quantity","Amount","Date"};

 DefaultTableModel jtModel=new DefaultTableModel(objs,header);
 order.adOrder.jtOrder.setModel(jtModel);
 }
catch(Exception e){System.out.println("Error:37"+e);}

}
}
//---------------------------------------CUSTOMER-------------------------------------------

//--------------------------------------Save Customer----------------------------------------
if(ae.getActionCommand().equals("addCust.btnSave")){
model.saveCustomer(cust.addCust.txtFirstName,cust.addCust.txtLastName,cust.addCust.jcbState,cust.addCust.txtArea,cust.addCust.txtaAddress,cust.addCust.txtPhone,cust.addCust.txtEmail,cust.addCust.txtCompany,cust.addCust.txtPin);
}

//--------------------------------------Delete Customer----------------------------
if(ae.getActionCommand().equals("cust.editCust.btnDelete")){
if(s1.equals("")) JOptionPane.showMessageDialog(null,"Select a row to Delete" ,"Error",JOptionPane.ERROR_MESSAGE);
else{
model.editCustomer(s1); 
s1="";
Object[][] dc=model.searchCustomer(cust.editCust.txtSearch,cust.editCust.jcbSearch);
 final Object[] header={"Customer Id","Name","Last Name","Company"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
cust.editCust.jtCustomer.setModel(jtModel);
}
}

//------------------------------------Clear Customer---------------------------
if(ae.getActionCommand().equals("cust.addCust.btnClear")){
model.clearCustomer(cust.addCust.txtFirstName,cust.addCust.txtLastName,cust.addCust.jcbState,cust.addCust.txtArea,cust.addCust.txtaAddress,cust.addCust.txtPhone,cust.addCust.txtEmail,cust.addCust.txtCompany,cust.addCust.txtPin);
}

//------------------------------------Cancel Customer---------------------------
if(ae.getActionCommand().equals("cust.editCust.btnCancel")){
cust.setVisible(false);
}
if(ae.getActionCommand().equals("cust.addCust.btnCancel")){
cust.setVisible(false);
}

//---------------------------------------Modify Customer--------------------------

if(ae.getActionCommand().equals("cust.editCust.btnModify")){
int cm=0;
try{

strQuery="select *	 from modifyf where customer=1";
//String strQuery="Delete from modifyf";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){cm=1;}
}

catch(Exception e1){
System.out.print(e1);
}
if(cm==0){
if(s1.equals("Type")) JOptionPane.showMessageDialog(null,"Type to Search.. Dude !" ,"Error",JOptionPane.ERROR_MESSAGE);
else if(s1.equals("")) JOptionPane.showMessageDialog(null,"Select a row to Modify" ,"Error",JOptionPane.ERROR_MESSAGE);


else { modifyCust=new ModifyCustomer();

try{

strQuery="update modifyf set customer=1 where customer=0";

connect.executeQuery("update",strQuery);

}

catch(Exception e1){
System.out.print(e1);
}

modifyCust.setVisible(true);
modifyCust.addWindowListener(new BasicWindowMonitor2("customer"));
model.modifyCustomer(s1,modifyCust.txtFirstName,modifyCust.txtLastName,modifyCust.jcbState,modifyCust.txtArea,modifyCust.txtaAddress,modifyCust.txtPhone,modifyCust.txtEmail,modifyCust.txtCompany,modifyCust.txtPin);


modifyCust.jchFirstName.addActionListener(this);
modifyCust.jchFirstName.setActionCommand("modifyCust.jchFirstName");
modifyCust.jchLastName.addActionListener(this);
modifyCust.jchLastName.setActionCommand("modifyCust.jchLastName");
modifyCust.jchArea.addActionListener(this);
modifyCust.jchArea.setActionCommand("modifyCust.jchArea");
modifyCust.jchAddress.addActionListener(this);
modifyCust.jchAddress.setActionCommand("modifyCust.jchAddress");
modifyCust.jchPhone.addActionListener(this);
modifyCust.jchPhone.setActionCommand("modifyCust.jchPhone");
modifyCust.jchEmail.addActionListener(this);
modifyCust.jchEmail.setActionCommand("modifyCust.jchEmail");
modifyCust.jchCompany.addActionListener(this);
modifyCust.jchCompany.setActionCommand("modifyCust.jchCompany");
modifyCust.jchPin.addActionListener(this);
modifyCust.jchPin.setActionCommand("modifyCust.jchPin");

modifyCust.btnSave.addActionListener(this);
modifyCust.btnSave.setActionCommand("modifyCust.btnSave");
modifyCust.btnCancel.addActionListener(this);
modifyCust.btnCancel.setActionCommand("modifyCust.btnCancel");
}
}
else{modifyCust.requestFocus();}
}


if(ae.getActionCommand().equals("modifyCust.btnSave")){

model.saveModifiedCustomer(modifyCust,s1,modifyCust.txtFirstName,modifyCust.txtLastName,modifyCust.jcbState,modifyCust.txtArea,modifyCust.txtaAddress,modifyCust.txtPhone,modifyCust.txtEmail,modifyCust.txtCompany,modifyCust.txtPin);
	//modifyCust.dispose();
	Object[][] dc=model.searchCustomer(cust.editCust.txtSearch,cust.editCust.jcbSearch);
s1="";
 final Object[] header={"Customer Id","Name","Last Name","Company"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
cust.editCust.jtCustomer.setModel(jtModel);
}

if(ae.getActionCommand().equals("modifyCust.btnCancel")){
custModify=0;
try{

strQuery="update modifyf set customer=0 where customer=1";

connect.executeQuery("update",strQuery);


}

catch(Exception e1){
System.out.print(e1);
}
model.clearCustomer(modifyCust.txtFirstName,modifyCust.txtLastName,modifyCust.jcbState,modifyCust.txtArea,modifyCust.txtaAddress,modifyCust.txtPhone,modifyCust.txtEmail,modifyCust.txtCompany,modifyCust.txtPin);
	modifyCust.dispose();
}

//--------------------------------------------------------------chkboxes--------------------------
if(ae.getActionCommand().equals("modifyCust.jchFirstName")){
if(modifyCust.jchFirstName.isSelected()) {
modCust1=modifyCust.txtFirstName.getText();
modifyCust.txtFirstName.setText("");
modifyCust.txtFirstName.setEnabled(true);
}
else if(modifyCust.txtFirstName.getText().equals("")) {
modifyCust.txtFirstName.setText(modCust1);
modifyCust.txtFirstName.setEnabled(false);
}
else modifyCust.txtFirstName.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyCust.jchLastName")){
if(modifyCust.jchLastName.isSelected()) {
modCust2=modifyCust.txtLastName.getText();
modifyCust.txtLastName.setText("");
modifyCust.txtLastName.setEnabled(true);
}
else if(modifyCust.txtLastName.getText().equals("")) {
modifyCust.txtLastName.setText(modCust2);
modifyCust.txtLastName.setEnabled(false);
}
else modifyCust.txtLastName.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyCust.jchArea")){
if(modifyCust.jchArea.isSelected()) {
modCust3=modifyCust.txtArea.getText();
modifyCust.txtArea.setText("");
modifyCust.txtArea.setEnabled(true);
}
else if(modifyCust.txtArea.getText().equals("")) {
modifyCust.txtArea.setText(modCust3);
modifyCust.txtArea.setEnabled(false);
}
else modifyCust.txtArea.setEnabled(false);

}
if(ae.getActionCommand().equals("modifyCust.jchAddress")){
if(modifyCust.jchAddress.isSelected()) {
modCust4=modifyCust.txtaAddress.getText();
modifyCust.txtaAddress.setText("");
modifyCust.txtaAddress.setEnabled(true);
}
else if(modifyCust.txtaAddress.getText().equals("")) {
modifyCust.txtaAddress.setText(modCust4);
modifyCust.txtaAddress.setEnabled(false);
}
else modifyCust.txtaAddress.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyCust.jchPhone")){
if(modifyCust.jchPhone.isSelected()) {
modCust5=modifyCust.txtPhone.getText();
modifyCust.txtPhone.setText("");
modifyCust.txtPhone.setEnabled(true);
}
else if(modifyCust.txtPhone.getText().equals("")) {
modifyCust.txtPhone.setText(modCust5);
modifyCust.txtPhone.setEnabled(false);
}
else modifyCust.txtPhone.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyCust.jchEmail")){
if(modifyCust.jchEmail.isSelected()) {
modCust6=modifyCust.txtEmail.getText();
modifyCust.txtEmail.setText("");
modifyCust.txtEmail.setEnabled(true);
}
else if(modifyCust.txtEmail.getText().equals("")) {
modifyCust.txtEmail.setText(modCust6);
modifyCust.txtEmail.setEnabled(false);
}
else modifyCust.txtEmail.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyCust.jchCompany")){
if(modifyCust.jchCompany.isSelected()) {
modCust7=modifyCust.txtCompany.getText();
modifyCust.txtCompany.setText("");
modifyCust.txtCompany.setEnabled(true);
}
else if(modifyCust.txtCompany.getText().equals("")) {
modifyCust.txtCompany.setText(modCust7);
modifyCust.txtCompany.setEnabled(false);
}
else modifyCust.txtCompany.setEnabled(false);
}

if(ae.getActionCommand().equals("modifyCust.jchPin")){
if(modifyCust.jchPin.isSelected()) {
modCust8=modifyCust.txtPin.getText();
modifyCust.txtPin.setText("");
modifyCust.txtPin.setEnabled(true);
}
else if(modifyCust.txtPin.getText().equals("")) {
modifyCust.txtPin.setText(modCust8);
modifyCust.txtPin.setEnabled(false);
}
else modifyCust.txtPin.setEnabled(false);


}
//---------------------------------------MANUFACTURER-------------------------------------------

//--------------------------------------Save Manufacturer----------------------------------------

if(ae.getActionCommand().equals("addManu.btnSave")){
model.saveManufacturer(manu.addManu.txtName,manu.addManu.jcbState,manu.addManu.txtArea,manu.addManu.txtaAddress,manu.addManu.txtPhone,manu.addManu.txtEmail,manu.addManu.txtPin,manu.addManu.txtVat);
	}

//--------------------------------------Delete Manufacturer----------------------------
if(ae.getActionCommand().equals("manu.editManu.btnDelete")){
if(s2.equals("")) JOptionPane.showMessageDialog(null,"Select a row to Delete","Error",JOptionPane.ERROR_MESSAGE);
else{
model.editManufacturer(s2); 
s2="";
Object[][] dc=model.searchManufacturer(manu.editManu.txtSearch);
 final Object[] header={"Manufacturer Id","Name"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
manu.editManu.jtManufacturer.setModel(jtModel);
}
}
//------------------------------------Clear Manufacturer---------------------------
if(ae.getActionCommand().equals("manu.addManu.btnClear")){
model.clearManufacturer(manu.addManu.txtName,manu.addManu.jcbState,manu.addManu.txtArea,manu.addManu.txtaAddress,manu.addManu.txtPhone,manu.addManu.txtEmail,manu.addManu.txtPin,manu.addManu.txtVat);
}
//------------------------------------Cancel Manufacturer---------------------------
if(ae.getActionCommand().equals("manu.editManu.btnCancel")){

manu.setVisible(false);
}
if(ae.getActionCommand().equals("manu.addManu.btnCancel")){
manu.setVisible(false);
}
//---------------------------------------Modify Manufacturer--------------------------
if(ae.getActionCommand().equals("manu.editManu.btnModify")){


int cm=0;
try{

strQuery="select *	 from modifyf where manufacturer=1";
//String strQuery="Delete from modifyf";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){cm=1;}
}

catch(Exception e1){
System.out.print(e1);
}
if(cm==0){
if(s2.equals("Type")) JOptionPane.showMessageDialog(null,"Type to Search.. Dude !" ,"Error",JOptionPane.ERROR_MESSAGE);
else if(s2.equals("")) JOptionPane.showMessageDialog(null,"Select a row to Modify" ,"Error",JOptionPane.ERROR_MESSAGE);

else { modifyManu=new ModifyManufacturer();

try{

strQuery="update modifyf set manufacturer=1 where manufacturer=0";

connect.executeQuery("update",strQuery);

}

catch(Exception e1){
System.out.print(e1);
}

modifyManu.addWindowListener(new BasicWindowMonitor2("manufacturer"));



model.modifyManufacturer(s2,modifyManu.txtName,modifyManu.jcbState,modifyManu.txtArea,modifyManu.txtaAddress,modifyManu.txtPhone,modifyManu.txtEmail,modifyManu.txtPin,modifyManu.txtVat);


modifyManu.jchName.addActionListener(this);
modifyManu.jchName.setActionCommand("modifyManu.jchName");
modifyManu.jchArea.addActionListener(this);
modifyManu.jchArea.setActionCommand("modifyManu.jchArea");
modifyManu.jchAddress.addActionListener(this);
modifyManu.jchAddress.setActionCommand("modifyManu.jchAddress");
modifyManu.jchPhone.addActionListener(this);
modifyManu.jchPhone.setActionCommand("modifyManu.jchPhone");
modifyManu.jchEmail.addActionListener(this);
modifyManu.jchEmail.setActionCommand("modifyManu.jchEmail");
modifyManu.jchPin.addActionListener(this);
modifyManu.jchPin.setActionCommand("modifyManu.jchPin");
modifyManu.jchVat.addActionListener(this);
modifyManu.jchVat.setActionCommand("modifyManu.jchVat");


modifyManu.btnSave.addActionListener(this);
modifyManu.btnSave.setActionCommand("modifyManu.btnSave");
modifyManu.btnCancel.addActionListener(this);
modifyManu.btnCancel.setActionCommand("modifyManu.btnCancel");
}
}
else{modifyManu.requestFocus();}
}

if(ae.getActionCommand().equals("modifyManu.btnSave")){
model.saveModifiedManufacturer(modifyManu,s2,modifyManu.txtName,modifyManu.jcbState,modifyManu.txtArea,modifyManu.txtaAddress,modifyManu.txtPhone,modifyManu.txtEmail,modifyManu.txtPin,modifyManu.txtVat);
	//modifyManu.dispose();
	Object[][] dc=model.searchManufacturer(manu.editManu.txtSearch);
s2="";
final Object[] header={"Manufacturer Id","Name"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
manu.editManu.jtManufacturer.setModel(jtModel);
}

if(ae.getActionCommand().equals("modifyManu.btnCancel")){
model.clearManufacturer(modifyManu.txtName,modifyManu.jcbState,modifyManu.txtArea,modifyManu.txtaAddress,modifyManu.txtPhone,modifyManu.txtEmail,modifyManu.txtPin,modifyManu.txtVat);
	modifyManu.dispose();
	try{

strQuery="update modifyf set manufacturer=0 where manufacturer=1";
connect.executeQuery("update",strQuery);
}
catch(Exception e1){
System.out.print(e1);
}
}
//--------------------------------------------------------------chkboxes--------------------------

if(ae.getActionCommand().equals("modifyManu.jchName")){
if(modifyManu.jchName.isSelected()) {
modManu1=modifyManu.txtName.getText();
modifyManu.txtName.setText("");
modifyManu.txtName.setEnabled(true);
}
else if(modifyManu.txtName.getText().equals("")) {
modifyManu.txtName.setText(modManu1);
modifyManu.txtName.setEnabled(false);
}
else modifyManu.txtName.setEnabled(false);
}

if(ae.getActionCommand().equals("modifyManu.jchArea")){
if(modifyManu.jchArea.isSelected()) {
modManu3=modifyManu.txtArea.getText();
modifyManu.txtArea.setText("");
modifyManu.txtArea.setEnabled(true);
}
else if(modifyManu.txtArea.getText().equals("")) {
modifyManu.txtArea.setText(modManu3);
modifyManu.txtArea.setEnabled(false);
}
else modifyManu.txtArea.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyManu.jchAddress")){
if(modifyManu.jchAddress.isSelected()) {
modManu4=modifyManu.txtaAddress.getText();
modifyManu.txtaAddress.setText("");
modifyManu.txtaAddress.setEnabled(true);
}
else if(modifyManu.txtaAddress.getText().equals("")) {
modifyManu.txtaAddress.setText(modManu4);
modifyManu.txtaAddress.setEnabled(false);
}
else modifyManu.txtaAddress.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyManu.jchPhone")){
if(modifyManu.jchPhone.isSelected()) {
modManu5=modifyManu.txtPhone.getText();
modifyManu.txtPhone.setText("");
modifyManu.txtPhone.setEnabled(true);
}
else if(modifyManu.txtPhone.getText().equals("")) {
modifyManu.txtPhone.setText(modManu5);
modifyManu.txtPhone.setEnabled(false);
}
else modifyManu.txtPhone.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyManu.jchEmail")){
if(modifyManu.jchEmail.isSelected()) {
modManu6=modifyManu.txtEmail.getText();
modifyManu.txtEmail.setText("");
modifyManu.txtEmail.setEnabled(true);
}
else if(modifyManu.txtEmail.getText().equals("")) {
modifyManu.txtEmail.setText(modManu6);
modifyManu.txtEmail.setEnabled(false);
}
else modifyManu.txtEmail.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyManu.jchPin")){
if(modifyManu.jchPin.isSelected()) {
modManu8=modifyManu.txtPin.getText();
modifyManu.txtPin.setText("");
modifyManu.txtPin.setEnabled(true);
}
else if(modifyManu.txtPin.getText().equals("")) {
modifyManu.txtPin.setText(modManu8);
modifyManu.txtPin.setEnabled(false);
}
else modifyManu.txtPin.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyManu.jchVat")){
if(modifyManu.jchVat.isSelected()) {
modManu9=modifyManu.txtVat.getText();
modifyManu.txtVat.setText("");
modifyManu.txtVat.setEnabled(true);
}
else if(modifyManu.txtVat.getText().equals("")) {
modifyManu.txtVat.setText(modManu9);
modifyManu.txtVat.setEnabled(false);
}
else modifyManu.txtVat.setEnabled(false);
}


//---------------------------------------PRODUCT----------------------------------------------

//---------------------------------------Save Product---------------------------------------------
if(ae.getActionCommand().equals("prod.addProduct.btnSave")){
model.saveProduct(prod.addProduct.jcbManufacturer,prod.addProduct.txtProductName,prod.addProduct.txtPrice,prod.addProduct.txtCustomerPrice,prod.addProduct.txtBoxQuantity,prod.addProduct.txtBoxMrp);
}//------------------------------------Clear Product---------------------------
if(ae.getActionCommand().equals("prod.addProduct.btnClear")){
model.clearProduct(prod.addProduct.txtProductName,prod.addProduct.txtPrice,prod.addProduct.txtCustomerPrice,prod.addProduct.txtBoxQuantity,prod.addProduct.txtBoxMrp);
}
//------------------------------------Cancel Product---------------------------
if(ae.getActionCommand().equals("prod.addProduct.btnCancel")){
prod.setVisible(false);
}
if(ae.getActionCommand().equals("prod.editProduct.btnCancel")){
prod.setVisible(false);
}
//--------------------------------------Delete Product----------------------------
if(ae.getActionCommand().equals("prod.editProduct.btnDelete")){
if(s3.equals("")) JOptionPane.showMessageDialog(null,"Select a row to Delete","Error",JOptionPane.ERROR_MESSAGE);
else{
model.editProduct(s3); 
s3="";
Object[][] dc=model.searchProduct(prod.editProduct.jcbManufacturer,prod.editProduct.txtSearch);
 final Object[] header={"Product Id","Product Name","Manufacturer Name"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
prod.editProduct.jtProduct.setModel(jtModel);
}
}
//---------------------------------------Modify Product--------------------------
if(ae.getActionCommand().equals("prod.editProduct.btnModify")){

int cm=0;
try{

strQuery="select * from modifyf where product=1";
//String strQuery="Delete from modifyf";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){cm=1;}
}

catch(Exception e1){
System.out.print(e1);
}
if(cm==0){
if(s3.equals("Type")) JOptionPane.showMessageDialog(null,"Type to Search.. Dude !" ,"Error",JOptionPane.ERROR_MESSAGE);
else if(s3.equals("")) JOptionPane.showMessageDialog(null,"Select a row to Modify" ,"Error",JOptionPane.ERROR_MESSAGE);

else { modifyProd=new ModifyProduct();

try{

strQuery="update modifyf set product=1 where product=0";

connect.executeQuery("update",strQuery);

}

catch(Exception e1){
System.out.print(e1);
}


modifyProd.addWindowListener(new BasicWindowMonitor2("product"));
model.modifyProduct(s3,modifyProd.jcbManufacturer,modifyProd.txtProductName,modifyProd.txtPrice,modifyProd.txtCustomerPrice,modifyProd.txtBoxQuantity,modifyProd.txtBoxMrp);


modifyProd.jchProductName.addActionListener(this);
modifyProd.jchProductName.setActionCommand("modifyProd.jchProductName");
modifyProd.jchPrice.addActionListener(this);
modifyProd.jchPrice.setActionCommand("modifyProd.jchPrice");
modifyProd.jchCustomerPrice.addActionListener(this);
modifyProd.jchCustomerPrice.setActionCommand("modifyProd.jchCustomerPrice");
modifyProd.jchBoxMrp.addActionListener(this);
modifyProd.jchBoxMrp.setActionCommand("modifyProd.jchBoxMrp");
modifyProd.jchBoxQuantity.addActionListener(this);
modifyProd.jchBoxQuantity.setActionCommand("modifyProd.jchBoxQuantity");

modifyProd.btnSave.addActionListener(this);
modifyProd.btnSave.setActionCommand("modifyProd.btnSave");
modifyProd.btnCancel.addActionListener(this);
modifyProd.btnCancel.setActionCommand("modifyProd.btnCancel");
}
}
else{modifyCust.requestFocus();}
}

if(ae.getActionCommand().equals("modifyProd.btnSave")){
model.saveModifiedProduct(modifyProd,s3,modifyProd.jcbManufacturer,modifyProd.txtProductName,modifyProd.txtPrice,modifyProd.txtCustomerPrice,modifyProd.txtBoxQuantity,modifyProd.txtBoxMrp);
	//modifyProd.dispose();
	Object[][] dc=model.searchProduct(prod.editProduct.jcbManufacturer,prod.editProduct.txtSearch);
s3="";
 final Object[] header={"Product Id","Product Name","Manufacturer Name"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
prod.editProduct.jtProduct.setModel(jtModel);
}

if(ae.getActionCommand().equals("modifyProd.btnCancel")){
model.clearProduct(modifyProd.txtProductName,modifyProd.txtPrice,modifyProd.txtCustomerPrice,modifyProd.txtBoxQuantity,modifyProd.txtBoxMrp);
	modifyProd.dispose();
	try{
	
	strQuery="update modifyf set product=0 where product=1";
connect.executeQuery("update",strQuery);

}

catch(Exception e1){
System.out.print(e1);
}
}


//--------------------------------------------------------------chkboxes--------------------------

if(ae.getActionCommand().equals("modifyProd.jchProductName")){
if(modifyProd.jchProductName.isSelected()) {
modProd1=modifyProd.txtProductName.getText();
modifyProd.txtProductName.setText("");
modifyProd.txtProductName.setEnabled(true);
}
else if(modifyProd.txtProductName.getText().equals("")) {
modifyProd.txtProductName.setText(modProd1);
modifyProd.txtProductName.setEnabled(false);
}
else modifyProd.txtProductName.setEnabled(false);
}

if(ae.getActionCommand().equals("modifyProd.jchPrice")){
if(modifyProd.jchPrice.isSelected()) {
modProd3=modifyProd.txtPrice.getText();
modifyProd.txtPrice.setText("");
modifyProd.txtPrice.setEnabled(true);
}
else if(modifyProd.txtPrice.getText().equals("")) {
modifyProd.txtPrice.setText(modProd3);
modifyProd.txtPrice.setEnabled(false);
}
else modifyProd.txtPrice.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyProd.jchCustomerPrice")){
if(modifyProd.jchCustomerPrice.isSelected()) {
modProd4=modifyProd.txtCustomerPrice.getText();
modifyProd.txtCustomerPrice.setText("");
modifyProd.txtCustomerPrice.setEnabled(true);
}
else if(modifyProd.txtCustomerPrice.getText().equals("")) {
modifyProd.txtCustomerPrice.setText(modProd4);
modifyProd.txtCustomerPrice.setEnabled(false);
}
else modifyProd.txtCustomerPrice.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyProd.jchBoxMrp")){
if(modifyProd.jchBoxMrp.isSelected()) {
modProd5=modifyProd.txtBoxMrp.getText();
modifyProd.txtBoxMrp.setText("");
modifyProd.txtBoxMrp.setEnabled(true);
}
else if(modifyProd.txtBoxMrp.getText().equals("")) {
modifyProd.txtBoxMrp.setText(modProd5);
modifyProd.txtBoxMrp.setEnabled(false);
}
else modifyProd.txtBoxMrp.setEnabled(false);
}
if(ae.getActionCommand().equals("modifyProd.jchBoxQuantity")){
if(modifyProd.jchBoxQuantity.isSelected()) {
modProd6=modifyProd.txtBoxQuantity.getText();
modifyProd.txtBoxQuantity.setText("");
modifyProd.txtBoxQuantity.setEnabled(true);
}
else if(modifyProd.txtBoxQuantity.getText().equals("")) {
modifyProd.txtBoxQuantity.setText(modProd6);
modifyProd.txtBoxQuantity.setEnabled(false);
}
else modifyProd.txtBoxQuantity.setEnabled(false);
}
//---------------------------------------sale----------------------------------------------
//---------------------------------------Update sale-----------------------------------
if(ae.getActionCommand().equals("sale.viewSale.btnCancel")){
sale.setVisible(false);
}


if(ae.getActionCommand().equals("sale.viewSale.btnComplete")){
int q1=0;int q2=0;
if(i2==0) {JOptionPane.showMessageDialog(null,"Select a row to Complete sale !" ,"Error",JOptionPane.ERROR_MESSAGE);}
else if(s19.equals("Complete")){JOptionPane.showMessageDialog(null,"sale Already Completed !" ,"Error",JOptionPane.ERROR_MESSAGE);}
else {

try{
strQuery="select quantity from sale1 where product_id="+i5+"";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
q1=connect.rs.getInt(1);
}
 q2=i6;
if(q1<q2){JOptionPane.showMessageDialog(null,"Stock not available" ,"Error",JOptionPane.ERROR_MESSAGE);}

else{
int q3=q1-q2;
strQuery="update sale1 set Quantity="+q3+" where product_id="+i5+"";
connect.executeQuery("update",strQuery);

i5=0;
i6=0;
s19="";
try{
strQuery="select * from payment order by payment_Id";

connect.executeQuery("query",strQuery);

if(connect.rs.next()) {connect.rs.beforeFirst();
int i=1,j=0;
while(connect.rs.next()){
if(i!=connect.rs.getInt(1)) {pkey=i; j=1; break; }
i++;
}
connect.rs.last();
if(j==0) pkey=connect.rs.getInt(1)+1;
}
else{
pkey=1;
}
System.out.println("pkey "+pkey);
int amount=0;
strQuery="select AMOUNT from sale1 where sale_id1="+i2+"";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
amount+=connect.rs.getInt(1);
}

strQuery="insert into payment values("+pkey+","+i2+","+amount+",'"+comp.addComplaint.lblCurrentDate.getText()+"','pending')";
connect.executeQuery("update",strQuery);

strQuery="update sale1 set sale_status='Complete' where sale_id1="+i2+"";
connect.executeQuery("update",strQuery);
i2=0;
}
catch(Exception e){System.out.println("Error:40"+e);}
}
menu.btnSale.doClick();
}catch(Exception e){System.out.println("Error:40"+e);}
}
}
//---------------------------------------Cancel sale-----------------------------------
if(ae.getActionCommand().equals("addSale.btnCancel")){

Object[][] dc3=new Object[0][0];
final Object[] header={"Product Name","Price","Quantity","Amount"};
DefaultTableModel jtModel=new DefaultTableModel(dc3,header);
sale.addSale.jtAddProduct.setModel(jtModel);
rows=0;
try{
strQuery="delete from sale2 ";
connect.executeQuery("update",strQuery);
}catch(Exception e){System.out.println("Error:17"+e);}

sale.setVisible(false);
sale.addSale.txtSearch.setText("");

}

//---------------------------------------Add sale-----------------------------------
if(ae.getActionCommand().equals("addSale.btnAdd")){
int quantity=0,i,j,k,p,order=0,saleed=0,remaining=0;float amount=0,total=0;boolean count=false;

if(s5.equals("")){JOptionPane.showMessageDialog(null,"Select a row to add sale !" ,"Error",JOptionPane.ERROR_MESSAGE);}
else if(sale.addSale.txtQuantity.getText().equals("")) JOptionPane.showMessageDialog(null,"Enter Quantity for product !" ,"Error",JOptionPane.ERROR_MESSAGE);
else {
try{

strQuery="select * from sale2 where name='"+s5+"' and price="+s6+"";
connect.executeQuery("query",strQuery);
if(connect.rs.next()) count=true;
if(count) {
//connect.rs.next();
quantity=connect.rs.getInt(3);
quantity+=Integer.parseInt(sale.addSale.txtQuantity.getText());
amount=quantity*connect.rs.getFloat(2);
strQuery="update sale2 set quantity="+quantity+",amount="+amount+" where name='"+s5+"' and price="+s6+"";
connect.executeQuery("update",strQuery);
}
else{


rows++;

quantity=Integer.parseInt(sale.addSale.txtQuantity.getText());
amount=quantity*Float.parseFloat(s6);

strQuery="insert into sale2 values('"+s5+"',"+s6+","+quantity+","+amount+")";	
connect.executeQuery("update",strQuery);
/*
strQuery="select s.order_quantity,s.order_saleed from order s where s.product_id=(select product_id from product where product_name='"+s5+"' and box_price="+s6+")";
connect.executeQuery("query",strQuery);
connect.rs.next();
order=connect.rs.getInt(1);
saleed=connect.rs.getInt(2);
saleed+=quantity;
remaining=order-saleed;
if(remaining<0) remaining=0;
strQuery="update order set order_saleed="+saleed+",order_remaining="+remaining+" where product_id=(select product_id from product where product_name='"+s5+"' and box_price="+s6+")";	
connect.executeQuery("update",strQuery);
*/
Object[][] dc=model.searchSale(sale.addSale.jcbManufacturer,sale.addSale.txtSearch);
s5="";
 //final Object[] header={"Product Name","Box_Price","order","saleed","Remaining"};
 final Object[] header={"Product Name","MRP","Box_Price","Stock"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
sale.addSale.jtProductList.setModel(jtModel);
sale.addSale.jtProductList.setAutoResizeMode(3);
}
}
catch(Exception e){System.out.println("Error:18"+e);}
try{
 dc2=new Object[rows][4];sc2=new String[rows][4];
strQuery="select * from sale2 order by name";
connect.executeQuery("query",strQuery);
connect.rs.next();
for(i=0;i<rows;i++,connect.rs.next()){
for(j=0,k=1;j<4;j++,k++){
dc2[i][j]=connect.rs.getString(k);
sc2[i][j]=connect.rs.getString(k);
}
total+=(connect.rs.getFloat(4));
}
final Object[] header={"Product Name","Price","Quantity","Amount"};
DefaultTableModel jtModel=new DefaultTableModel(dc2,header);
sale.addSale.jtAddProduct.setModel(jtModel);



}catch(Exception e){System.out.println("Error:19"+e);}
String strTotal=Float.toString(total);
sale.addSale.lblTotal2.setText(strTotal);
sale.addSale.txtQuantity.setText("");
s5="";
s6="";
}
}

//---------------------------------------Remove sale-----------------------------------
if(ae.getActionCommand().equals("addSale.btnRemove")){
rows--;if(rows<0) rows=0;
int quantity=0,i,j,k,p,order=0,saleed=0,remaining=0;float amount=0,total=0;boolean count=false;
int r2=0;
// quantity=Integer.parseInt(sale.addSale.txtQuantity.getText());
if(s7.equals("")) {JOptionPane.showMessageDialog(null,"Select a row to remove !" ,"Error",JOptionPane.ERROR_MESSAGE);}
else{
strQuery="delete from sale2 where name='"+s7+"' and price="+s8+" ";
connect.executeQuery("update",strQuery);
try{
quantity=Integer.parseInt(s9);
strQuery="select s.order_quantity,s.order_saleed from order s where s.product_id=(select product_id from product where product_name='"+s7+"' and box_price="+s8+")";
connect.executeQuery("query",strQuery);
connect.rs.next();System.out.println(s9);
order=connect.rs.getInt(1);
saleed=connect.rs.getInt(2);
saleed-=quantity;
remaining=order-saleed;
if(remaining<0) remaining=0;
strQuery="update order set order_saleed="+saleed+",order_remaining="+remaining+" where product_id=(select product_id from product where product_name='"+s7+"' and box_price="+s8+")";	
connect.executeQuery("update",strQuery);

Object[][] dc=model.searchSale(sale.addSale.jcbManufacturer,sale.addSale.txtSearch);
s5="";System.out.println(s9);
 final Object[] header2={"Product Name","Box_Price","order","saleed","Remaining"};
 DefaultTableModel jtModel2=new DefaultTableModel(dc,header2);
sale.addSale.jtProductList.setModel(jtModel2);
sale.addSale.jtProductList.setAutoResizeMode(0);



Object[][] dc4=new Object[100][100];
strQuery="select * from sale2 order by name";
connect.executeQuery("query",strQuery);
k=0;i=0;j=0;
while(connect.rs.next()){
r2++;
dc4[i][0]=connect.rs.getString(1);
dc4[i][1]=connect.rs.getString(2);
dc4[i][2]=connect.rs.getString(3);
dc4[i][3]=connect.rs.getString(4);
total+=connect.rs.getFloat(4);
i++;
}
dc2=new Object[r2][4];
for(i=0;i<r2;i++){
for(j=0;j<4;j++){
dc2[i][j]=dc4[i][j];
}

}
final Object[] header={"Product Name","Price","Quantity","Amount"};
DefaultTableModel jtModel=new DefaultTableModel(dc2,header);
sale.addSale.jtAddProduct.setModel(jtModel);
}catch(Exception e){System.out.println("Error:20"+e);}
String strTotal=Float.toString(total);
sale.addSale.lblTotal2.setText(strTotal);
sale.addSale.txtQuantity.setText("");
s10=s7;
s11=s8;
s7="";
s8="";
}

}

//---------------------------------------Save sale-----------------------------------
if(ae.getActionCommand().equals("addSale.btnSave")){
boolean oflag=true;
try{
strQuery="select * from sale2";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
oflag=false;
}
}
catch(Exception e){System.out.println("Error:21"+e);}

if(sale.addSale.jcbCompany.getSelectedItem().equals("Select") || sale.addSale.jcbFirstName.getSelectedItem().equals("Select") || sale.addSale.jcbLastName.getSelectedItem().equals("Select")){JOptionPane.showMessageDialog(null,"Select Customer Name ! " ,"Error",JOptionPane.ERROR_MESSAGE);}
//else if(sale.addSale.jcbShipmentDateDay.getSelectedItem().equals("Select") || sale.addSale.jcbShipmentDateMonth.getSelectedItem().equals("Select") || sale.addSale.jcbShipmentDateYear.getSelectedItem().equals("Select")){JOptionPane.showMessageDialog(null,"Select Date ! " ,"Error",JOptionPane.ERROR_MESSAGE);}
else if(oflag){JOptionPane.showMessageDialog(null,"Select Product ! " ,"Error",JOptionPane.ERROR_MESSAGE);}
else{
Object[] options = {"Yes", "No"};
                    int n = JOptionPane.showOptionDialog(null,
                                    "Are you sure you want to save data",
                                    "Question",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                    if (n == JOptionPane.YES_OPTION) {


int customerId=0,productId=0,r2=0,quantity=0;
float amount,price=0;
String oDate="",sDate="",oStatus="",name="";
try{
strQuery="select cust_id from customer where cust_company='"+sale.addSale.jcbCompany.getSelectedItem()+"' and cust_first_name='"+sale.addSale.jcbFirstName.getSelectedItem()+"' and cust_last_name='"+sale.addSale.jcbLastName.getSelectedItem()+"'";
connect.executeQuery("query",strQuery);
connect.rs.next();

customerId=connect.rs.getInt(1);
System.out.println(customerId);


//sDate=sale.addSale.jcbShipmentDateDay.getSelectedItem()+"-"+sale.addSale.jcbShipmentDateMonth.getSelectedItem()+"-"+sale.addSale.jcbShipmentDateYear.getSelectedItem();
sDate=calendar;
System.out.println(sDate);
oDate=calendar;
System.out.println(oDate);

strQuery="select distinct(sale_id1) from sale1 order by sale_Id1";

connect.executeQuery("query",strQuery);

if(connect.rs.next()) {connect.rs.beforeFirst();
int i=1,j=0;
while(connect.rs.next()){
if(i!=connect.rs.getInt(1)) {pkeyo=i; j=1; break; }
i++;
}
connect.rs.last();
if(j==0) pkeyo=connect.rs.getInt(1)+1;
}
else{
pkeyo=1;
}
System.out.println("pkeyo "+pkeyo);


strQuery="select * from sale2 order by name";
connect2.executeQuery("query",strQuery);
pkey=0;
while(connect2.rs.next()){

pkey++;

/*strQuery="select * from sale1 order by sale_Id2";

connect.executeQuery("query",strQuery);

if(connect.rs.next()) {connect.rs.beforeFirst();
int i=1,j=0;
while(connect.rs.next()){
if(i!=connect.rs.getInt(2)) {pkey=i; j=1; break; }
i++;
}
connect.rs.last();
if(j==0) pkey=connect.rs.getInt(1)+1;
}
else{
pkey=1;
}
System.out.println("pkey "+pkey);*/

name=connect2.rs.getString(1);
System.out.println(name);
price=connect2.rs.getFloat(2);
System.out.println(price);
strQuery="select product_id from product where product_name='"+name+"' and box_price="+price+"";
connect.executeQuery("query",strQuery);
connect.rs.next();
productId=connect.rs.getInt(1);
System.out.println("p "+productId);
quantity=connect2.rs.getInt(3);
amount=connect2.rs.getFloat(4);
    System.out.println("sDate"+sDate);
strQuery="insert into sale1 values("+pkeyo+","+pkey+","+customerId+","+productId+","+quantity+","+amount+",'"+oDate+"','"+sDate+"','Pending')";
connect.executeQuery("update",strQuery);
}
}
catch(Exception e){System.out.println("Error:22"+e);}
Object[][] dc3=new Object[0][0];
final Object[] header={"Product Name","Price","Quantity","Amount"};
DefaultTableModel jtModel=new DefaultTableModel(dc3,header);
sale.addSale.jtAddProduct.setModel(jtModel);
rows=0;
try{
strQuery="delete from sale2 ";
connect.executeQuery("update",strQuery);
}catch(Exception e){System.out.println("Error:23"+e);}

r2=0;
Object[][] dc4=new Object[100][100];
strQuery="select * from sale1 where Customer_Id="+customerId+" order by sale_id1";
connect.executeQuery("query",strQuery);
int i=0,j;
try{
while(connect.rs.next()){
r2++;
for(j=0;j<8;j++){
if(j!=2)
dc4[i][j]=connect.rs.getString(j+1);
}

i++;
}
Object[][] dc5=new Object[r2][8];
for(i=0;i<r2;i++){
for(j=0;j<8;j++){
dc5[i][j]=dc4[i][j];
}
}

final Object[] header4={"sale Id1","Customer Id","Product Id","Quantity"};
DefaultTableModel jtModel2=new DefaultTableModel(dc5,header4);
sale.updateSale.jtUpdateSale.setModel(jtModel2);
}catch(Exception e){System.out.println("Error:24"+e);}

JOptionPane.showMessageDialog(null,"Data saved","Information",JOptionPane.INFORMATION_MESSAGE);
menu.btnSale.doClick();
}
}
}


//--------------------------------------EMPLOYEE--------------------------------------------------------
//------------------------------------------ADD Employee--------------------------------------
if(ae.getActionCommand().equals("emp.addEmployee.btnSave"))
{

model.saveEmployee(emp.addEmployee.txtFirstName,emp.addEmployee.txtMiddleName,emp.addEmployee.txtLastName,emp.addEmployee.jrbMale,emp.addEmployee.jrbFemale,emp.addEmployee.jcbDateOfBirthDay,emp.addEmployee.jcbDateOfBirthMonth,emp.addEmployee.jcbDateOfBirthYear,emp.addEmployee.jcbQualification,emp.addEmployee.txtRAddress,emp.addEmployee.jcbRState,emp.addEmployee.txtRArea,emp.addEmployee.txtRPin,emp.addEmployee.txtRPhone,emp.addEmployee.txtEmail,emp.addEmployee.txtNAddress,emp.addEmployee.jcbNState,emp.addEmployee.txtNArea,emp.addEmployee.txtNPin,emp.addEmployee.txtNPhone,emp.addEmployee.jcbDateOfJoiningDay,emp.addEmployee.jcbDateOfJoiningMonth,emp.addEmployee.jcbDateOfJoiningYear,emp.addEmployee.jcbDepartment,emp.addEmployee.txtDesignation,emp.addEmployee.txtPayOfDay,emp.addEmployee.txtOverTimePay);

}
if(ae.getActionCommand().equals("emp.addEmployee.btnCancel")){
emp.setVisible(false);

}
//---------------------------------------Delete Employee--------------------------------------
if(ae.getActionCommand().equals("emp.editEmployee.btnDelete")){
if(s3.equals("")) JOptionPane.showMessageDialog(null,"Select a row to Delete" ,"Error",JOptionPane.ERROR_MESSAGE);
else{
model.editEmployee(s3); 
s3="";
Object[][] dc=model.searchEmployee(emp.editEmployee.txtSearch);
 final Object[] header={"Id","First Name","Middle Name","Last Name"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
emp.editEmployee.jtEmployee.setModel(jtModel);
}
}
//----------------------------------------Modify Employee------------------------------------------
if(ae.getActionCommand().equals("emp.editEmployee.btnModify"))
{

int cm=0;
try{

strQuery="select *	 from modifyf where employee=1";
//String strQuery="Delete from modifyf";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){cm=1;}
}

catch(Exception e1){
System.out.print(e1);
}
if(cm==0){
if(s3.equals("")) JOptionPane.showMessageDialog(null,"Select a row to Delete" ,"Error",JOptionPane.ERROR_MESSAGE);
else
{
modifyEmp=new ModifyEmployee();


try{

strQuery="update modifyf set employee=1 where employee=0";

connect.executeQuery("update",strQuery);

}

catch(Exception e1){
System.out.print(e1);
}
modifyEmp.addWindowListener(new BasicWindowMonitor2("employee"));


model.modifyEmployee(s3,modifyEmp.txtFirstName,modifyEmp.txtMiddleName,modifyEmp.txtLastName,modifyEmp.jrbMale,modifyEmp.jrbFemale,modifyEmp.jcbDateOfBirthDay,modifyEmp.jcbDateOfBirthMonth,modifyEmp.jcbDateOfBirthYear,modifyEmp.jcbQualification,modifyEmp.txtRAddress,modifyEmp.jcbRState,modifyEmp.txtRArea,modifyEmp.txtRPin,modifyEmp.txtRPhone,modifyEmp.txtEmail,modifyEmp.txtNAddress,modifyEmp.jcbNState,modifyEmp.txtNArea,modifyEmp.txtNPin,modifyEmp.txtNPhone,modifyEmp.jcbDateOfJoiningDay,modifyEmp.jcbDateOfJoiningMonth,modifyEmp.jcbDateOfJoiningYear,modifyEmp.jcbDepartment,modifyEmp.txtDesignation,modifyEmp.txtPayOfDay,modifyEmp.txtOverTimePay);

modifyEmp.btnSave.addActionListener(this);
modifyEmp.btnSave.setActionCommand("modifyEmp.btnSave");
modifyEmp.btnCancel.addActionListener(this);
modifyEmp.btnCancel.setActionCommand("modifyEmp.btnCancel");

modifyEmp.jchFirstName.addActionListener(this);
modifyEmp.jchFirstName.setActionCommand("modifyEmp.jchFirstName");
modifyEmp.jchMiddleName.addActionListener(this);
modifyEmp.jchMiddleName.setActionCommand("modifyEmp.jchMiddleName");
modifyEmp.jchLastName.addActionListener(this);
modifyEmp.jchLastName.setActionCommand("modifyEmp.jchLastName");
modifyEmp.jchRArea.addActionListener(this);
modifyEmp.jchRArea.setActionCommand("modifyEmp.jchRArea");
modifyEmp.jchRAddress.addActionListener(this);
modifyEmp.jchRAddress.setActionCommand("modifyEmp.jchRAddress");
modifyEmp.jchRPhone.addActionListener(this);
modifyEmp.jchRPhone.setActionCommand("modifyEmp.jchRPhone");
modifyEmp.jchEmail.addActionListener(this);
modifyEmp.jchEmail.setActionCommand("modifyEmp.jchEmail");
modifyEmp.jchRPin.addActionListener(this);
modifyEmp.jchRPin.setActionCommand("modifyEmp.jchRPin");
modifyEmp.jchNArea.addActionListener(this);
modifyEmp.jchNArea.setActionCommand("modifyEmp.jchNArea");
modifyEmp.jchNAddress.addActionListener(this);
modifyEmp.jchNAddress.setActionCommand("modifyEmp.jchNAddress");
modifyEmp.jchNPhone.addActionListener(this);
modifyEmp.jchNPhone.setActionCommand("modifyEmp.jchNPhone");
modifyEmp.jchNPin.addActionListener(this);
modifyEmp.jchNPin.setActionCommand("modifyEmp.jchNPin");
modifyEmp.jchDesignation.addActionListener(this);
modifyEmp.jchDesignation.setActionCommand("modifyEmp.jchDesignation");
modifyEmp.jchPayOfDay.addActionListener(this);
modifyEmp.jchPayOfDay.setActionCommand("modifyEmp.jchPayOfDay");
modifyEmp.jchOverTimePay.addActionListener(this);
modifyEmp.jchOverTimePay.setActionCommand("modifyEmp.jchOverTimePay");
}
}
else{modifyEmp.requestFocus();}
}

if(ae.getActionCommand().equals("modifyEmp.btnSave"))
{
model.saveModifiedEmployee(modifyEmp,s3,modifyEmp.txtFirstName,modifyEmp.txtMiddleName,modifyEmp.txtLastName,modifyEmp.jrbMale,modifyEmp.jrbFemale,modifyEmp.jcbDateOfBirthDay,modifyEmp.jcbDateOfBirthMonth,modifyEmp.jcbDateOfBirthYear,modifyEmp.jcbQualification,modifyEmp.txtRAddress,modifyEmp.jcbRState,modifyEmp.txtRArea,modifyEmp.txtRPin,modifyEmp.txtRPhone,modifyEmp.txtEmail,modifyEmp.txtNAddress,modifyEmp.jcbNState,modifyEmp.txtNArea,modifyEmp.txtNPin,modifyEmp.txtNPhone,modifyEmp.jcbDateOfJoiningDay,modifyEmp.jcbDateOfJoiningMonth,modifyEmp.jcbDateOfJoiningYear,modifyEmp.jcbDepartment,modifyEmp.txtDesignation,modifyEmp.txtPayOfDay,modifyEmp.txtOverTimePay);
s3="";
Object[][] dc=model.searchEmployee(emp.editEmployee.txtSearch);
 final Object[] header={"Id","First Name","Middle Name","Last Name"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
emp.editEmployee.jtEmployee.setModel(jtModel);

}
if(ae.getActionCommand().equals("modifyEmp.btnCancel"))
{

try{

strQuery="update modifyf set employee=0 where employee=1";
connect.executeQuery("update",strQuery);
}
catch(Exception e1){
System.out.print(e1);
}
modifyEmp.dispose();
}
//---------------------------------------------Checkbox employee---------------------------------
if(ae.getActionCommand().equals("modifyEmp.jchFirstName")){
if(modifyEmp.jchFirstName.isSelected()) {
modEmp1=modifyEmp.txtFirstName.getText();
modifyEmp.txtFirstName.setText("");
modifyEmp.txtFirstName.setEnabled(true);
}
else if(modifyEmp.txtFirstName.getText().equals("")) {
modifyEmp.txtFirstName.setText(modEmp1);
modifyEmp.txtFirstName.setEnabled(false);
}
else modifyEmp.txtFirstName.setEnabled(false);
}

if(ae.getActionCommand().equals("modifyEmp.jchMiddleName")){
if(modifyEmp.jchMiddleName.isSelected()) {
modEmp2=modifyEmp.txtMiddleName.getText();
modifyEmp.txtMiddleName.setText("");
modifyEmp.txtMiddleName.setEnabled(true);
}
else if(modifyEmp.txtMiddleName.getText().equals("")) {
modifyEmp.txtMiddleName.setText(modEmp2);
modifyEmp.txtMiddleName.setEnabled(false);
}
else modifyEmp.txtMiddleName.setEnabled(false);
}

if(ae.getActionCommand().equals("modifyEmp.jchLastName")){
if(modifyEmp.jchLastName.isSelected()) {
modEmp3=modifyEmp.txtLastName.getText();
modifyEmp.txtLastName.setText("");
modifyEmp.txtLastName.setEnabled(true);
}
else if(modifyEmp.txtLastName.getText().equals("")) {
modifyEmp.txtLastName.setText(modEmp3);
modifyEmp.txtLastName.setEnabled(false);
}
else modifyEmp.txtLastName.setEnabled(false);
}

if(ae.getActionCommand().equals("modifyEmp.jchRArea")){
if(modifyEmp.jchRArea.isSelected()) {
modEmp4=modifyEmp.txtRArea.getText();
modifyEmp.txtRArea.setText("");
modifyEmp.txtRArea.setEnabled(true);
}
else if(modifyEmp.txtRArea.getText().equals("")) {
modifyEmp.txtRArea.setText(modEmp4);
modifyEmp.txtRArea.setEnabled(false);
}
else modifyEmp.txtRArea.setEnabled(false);

}

if(ae.getActionCommand().equals("modifyEmp.jchRAddress")){
if(modifyEmp.jchRAddress.isSelected()) {
modEmp5=modifyEmp.txtRAddress.getText();
modifyEmp.txtRAddress.setText("");
modifyEmp.txtRAddress.setEnabled(true);
}
else if(modifyEmp.txtRAddress.getText().equals("")) {
modifyEmp.txtRAddress.setText(modEmp5);
modifyEmp.txtRAddress.setEnabled(false);
}
else modifyEmp.txtRAddress.setEnabled(false);
}

if(ae.getActionCommand().equals("modifyEmp.jchRPhone")){
if(modifyEmp.jchRPhone.isSelected()) {
modEmp6=modifyEmp.txtRPhone.getText();
modifyEmp.txtRPhone.setText("");
modifyEmp.txtRPhone.setEnabled(true);
}
else if(modifyEmp.txtRPhone.getText().equals("")) {
modifyEmp.txtRPhone.setText(modEmp6);
modifyEmp.txtRPhone.setEnabled(false);
}
else modifyEmp.txtRPhone.setEnabled(false);
}

if(ae.getActionCommand().equals("modifyEmp.jchEmail")){
if(modifyEmp.jchEmail.isSelected()) {
modEmp7=modifyEmp.txtEmail.getText();
modifyEmp.txtEmail.setText("");
modifyEmp.txtEmail.setEnabled(true);
}
else if(modifyEmp.txtEmail.getText().equals("")) {
modifyEmp.txtEmail.setText(modEmp7);
modifyEmp.txtEmail.setEnabled(false);
}
else modifyEmp.txtEmail.setEnabled(false);
}



if(ae.getActionCommand().equals("modifyEmp.jchRPin")){
if(modifyEmp.jchRPin.isSelected()) {
modEmp8=modifyEmp.txtRPin.getText();
modifyEmp.txtRPin.setText("");
modifyEmp.txtRPin.setEnabled(true);
}
else if(modifyEmp.txtRPin.getText().equals("")) {
modifyEmp.txtRPin.setText(modEmp8);
modifyEmp.txtRPin.setEnabled(false);
}
else modifyEmp.txtRPin.setEnabled(false);
}



if(ae.getActionCommand().equals("modifyEmp.jchNArea")){
if(modifyEmp.jchNArea.isSelected()) {
modEmp9=modifyEmp.txtNArea.getText();
modifyEmp.txtNArea.setText("");
modifyEmp.txtNArea.setEnabled(true);
}
else if(modifyEmp.txtNArea.getText().equals("")) {
modifyEmp.txtNArea.setText(modEmp9);
modifyEmp.txtNArea.setEnabled(false);
}
else modifyEmp.txtNArea.setEnabled(false);

}

if(ae.getActionCommand().equals("modifyEmp.jchNAddress")){
if(modifyEmp.jchNAddress.isSelected()) {
modEmp10=modifyEmp.txtNAddress.getText();
modifyEmp.txtNAddress.setText("");
modifyEmp.txtNAddress.setEnabled(true);
}
else if(modifyEmp.txtNAddress.getText().equals("")) {
modifyEmp.txtNAddress.setText(modEmp10);
modifyEmp.txtNAddress.setEnabled(false);
}
else modifyEmp.txtNAddress.setEnabled(false);
}

if(ae.getActionCommand().equals("modifyEmp.jchNPhone")){
if(modifyEmp.jchNPhone.isSelected()) {
modEmp11=modifyEmp.txtRPhone.getText();
modifyEmp.txtNPhone.setText("");
modifyEmp.txtNPhone.setEnabled(true);
}
else if(modifyEmp.txtNPhone.getText().equals("")) {
modifyEmp.txtNPhone.setText(modEmp11);
modifyEmp.txtNPhone.setEnabled(false);
}
else modifyEmp.txtNPhone.setEnabled(false);
}



if(ae.getActionCommand().equals("modifyEmp.jchNPin")){
if(modifyEmp.jchNPin.isSelected()) {
modEmp12=modifyEmp.txtNPin.getText();
modifyEmp.txtNPin.setText("");
modifyEmp.txtNPin.setEnabled(true);
}
else if(modifyEmp.txtNPin.getText().equals("")) {
modifyEmp.txtNPin.setText(modEmp12);
modifyEmp.txtNPin.setEnabled(false);
}
else modifyEmp.txtNPin.setEnabled(false);
}

if(ae.getActionCommand().equals("modifyEmp.jchDesignation")){
if(modifyEmp.jchDesignation.isSelected()) {
modEmp13=modifyEmp.txtDesignation.getText();
modifyEmp.txtDesignation.setText("");
modifyEmp.txtDesignation.setEnabled(true);
}
else if(modifyEmp.txtDesignation.getText().equals("")) {
modifyEmp.txtDesignation.setText(modEmp13);
modifyEmp.txtDesignation.setEnabled(false);
}
else modifyEmp.txtDesignation.setEnabled(false);
}


if(ae.getActionCommand().equals("modifyEmp.jchPayOfDay")){
if(modifyEmp.jchPayOfDay.isSelected()) {
modEmp14=modifyEmp.txtPayOfDay.getText();
modifyEmp.txtPayOfDay.setText("");
modifyEmp.txtPayOfDay.setEnabled(true);
}
else if(modifyEmp.txtPayOfDay.getText().equals("")) {
modifyEmp.txtPayOfDay.setText(modEmp14);
modifyEmp.txtPayOfDay.setEnabled(false);
}
else modifyEmp.txtPayOfDay.setEnabled(false);
}


if(ae.getActionCommand().equals("modifyEmp.jchOverTimePay")){
if(modifyEmp.jchOverTimePay.isSelected()) {
modEmp15=modifyEmp.txtOverTimePay.getText();
modifyEmp.txtOverTimePay.setText("");
modifyEmp.txtOverTimePay.setEnabled(true);
}
else if(modifyEmp.txtOverTimePay.getText().equals("")) {
modifyEmp.txtOverTimePay.setText(modEmp15);
modifyEmp.txtOverTimePay.setEnabled(false);
}
else modifyEmp.txtOverTimePay.setEnabled(false);
}
//----------------------------------COMPLAINT---------------------------------------------------
if(ae.getActionCommand().equals("comp.viewComplaint.btnCancel")){
comp.setVisible(false);
}
if(ae.getActionCommand().equals("comp.viewComplaint.btnDelete")){
if(s16.equals("")) {JOptionPane.showMessageDialog(null,"Select Row to Delete" ,"Error",JOptionPane.ERROR_MESSAGE);}
else{
strQuery="delete from complaint where complaint_id="+s16+"";
connect.executeQuery("update",strQuery);
s16="";
try{
int j=0;
strQuery="select * from complaint";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){j++;}
Object[][] objs=new Object[j][8];
strQuery="select * from complaint";
connect.executeQuery("query",strQuery);
int i=0;
while(connect.rs.next()){
 objs[i][0]=connect.rs.getInt(1);
 objs[i][1]=connect.rs.getInt(2);
 objs[i][2]=connect.rs.getInt(3);
 objs[i][3]=connect.rs.getInt(4);
objs[i][4]=connect.rs.getInt(5);
objs[i][5]=connect.rs.getString(6);
objs[i][6]=connect.rs.getString(7);
objs[i][7]=connect.rs.getString(8);
 i++;
 }
 final Object[] header={"Complaint Id","sale Id1","sale Id2","Product Id","Customer_Id","Description","Date","Status"};

 DefaultTableModel jtModel=new DefaultTableModel(objs,header);
comp.viewComplaint.jtViewComplaint.setModel(jtModel);
 }
catch(Exception e){System.out.println("Error:37"+e);}
}
}
if(ae.getActionCommand().equals("comp.viewComplaint.btnClear")){
if(s16.equals("")) {JOptionPane.showMessageDialog(null,"Select Row to Clear" ,"Error",JOptionPane.ERROR_MESSAGE);}
else{
strQuery="update complaint set Complaint_status='Cleared' where complaint_id="+s16+"";
connect.executeQuery("update",strQuery);
s16="";
try{
int j=0;
strQuery="select * from complaint";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){j++;}
Object[][] objs=new Object[j][8];
strQuery="select * from complaint";
connect.executeQuery("query",strQuery);
int i=0;
while(connect.rs.next()){
 objs[i][0]=connect.rs.getInt(1);
 objs[i][1]=connect.rs.getInt(2);
 objs[i][2]=connect.rs.getInt(3);
 objs[i][3]=connect.rs.getInt(4);
objs[i][4]=connect.rs.getInt(5);
objs[i][5]=connect.rs.getString(6);
objs[i][6]=connect.rs.getString(7);
objs[i][7]=connect.rs.getString(8);
 i++;
 }
 final Object[] header={"Complaint Id","sale Id1","sale Id2","Product Id","Customer_Id","Description","Date","Status"};

 DefaultTableModel jtModel=new DefaultTableModel(objs,header);
comp.viewComplaint.jtViewComplaint.setModel(jtModel);
 }
catch(Exception e){System.out.println("Error:37"+e);}
}
}

if(ae.getActionCommand().equals("comp.addComplaint.jrbSale")){
comp.addComplaint.jcbSaleId.setEnabled(true);
comp.addComplaint.jcbProductName.setEnabled(false);
}
if(ae.getActionCommand().equals("comp.addComplaint.jrbProduct")){
comp.addComplaint.jcbProductName.setEnabled(true);
}
if(ae.getActionCommand().equals("comp.addComplaint.btnCancel")){
comp.setVisible(false);
}
if(ae.getActionCommand().equals("comp.addComplaint.btnSave")){

if(comp.addComplaint.jcbLastName.getSelectedItem().equals("Select")){
JOptionPane.showMessageDialog(null,"Select Name" ,"Error",JOptionPane.ERROR_MESSAGE);
}
else if(comp.addComplaint.jcbSaleId.getSelectedItem().equals("Select")){
JOptionPane.showMessageDialog(null,"Select sale_ID" ,"Error",JOptionPane.ERROR_MESSAGE);}
else if(comp.addComplaint.jcbProductName.isEnabled() && comp.addComplaint.jcbProductName.getSelectedItem().equals("Select")){
JOptionPane.showMessageDialog(null,"Select Product Name" ,"Error",JOptionPane.ERROR_MESSAGE);}
else if(comp.addComplaint.txtaDescription.equals("")){
JOptionPane.showMessageDialog(null,"Enter Description" ,"Error",JOptionPane.ERROR_MESSAGE);
}
else{
Object[] options = {"Yes", "No"};
                    int n = JOptionPane.showOptionDialog(null,
                                    "Are you sure you want to save data",
                                    "Question",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                    if (n == JOptionPane.YES_OPTION) {
int cust_id=0,sale_id2=0,prod_id=0;
String des=comp.addComplaint.txtaDescription.getText();
try{
strQuery="select cust_id from customer where cust_company='"+comp.addComplaint.jcbCompany.getSelectedItem()+"' and cust_first_name='"+comp.addComplaint.jcbFirstName.getSelectedItem()+"' and cust_last_name='"+comp.addComplaint.jcbLastName.getSelectedItem()+"' ";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
cust_id=connect.rs.getInt(1);

}
strQuery="select sale_id2 from sale1 where sale_id1="+comp.addComplaint.jcbSaleId.getSelectedItem()+" and product_id=(select product_id from product where product_name='"+comp.addComplaint.jcbProductName.getSelectedItem()+"') ";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
sale_id2=connect.rs.getInt(1);

}
strQuery="select product_id from product where product_name='"+comp.addComplaint.jcbProductName.getSelectedItem()+"'";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
prod_id=connect.rs.getInt(1);

}

strQuery="select * from complaint order by complaint_Id";

connect.executeQuery("query",strQuery);

if(connect.rs.next()) {connect.rs.beforeFirst();
int i=1,j=0;
while(connect.rs.next()){
if(i!=connect.rs.getInt(1)) {pkey=i; j=1; break; }
i++;
}
connect.rs.last();
if(j==0) pkey=connect.rs.getInt(1)+1;
}
else{
pkey=1;
}
System.out.println("pkey "+pkey);


strQuery="insert into complaint values("+pkey+","+comp.addComplaint.jcbSaleId.getSelectedItem()+","+sale_id2+","+prod_id+","+cust_id+",'"+des+"','"+comp.addComplaint.lblCurrentDate.getText()+"','pending')";
connect.executeQuery("update",strQuery);
}
catch(Exception e){System.out.println("Error:34"+e);}
JOptionPane.showMessageDialog(null,"Data Inserted" ,"Information",JOptionPane.INFORMATION_MESSAGE);
comp.addComplaint.txtaDescription.setText("");
}
}
}
//----------------------------------REPORT---------------------------------------------------
//----------------------------------sale Report---------------------------------------------------
if(ae.getActionCommand().equals("report1.salReport.jrbSaleDate")){
report1.salReport.panel3.remove(report1.salReport.panel5);
report1.salReport.panel3.add(report1.salReport.panel4);
report1.salReport.panel4.setVisible(true);
report1.salReport.panel5.setVisible(false);
}

if(ae.getActionCommand().equals("report1.salReport.btnReport")){
//if(jrbSaleDate.isSelected()){
int total=0;
String date1=report1.salReport.jcbStartDate.getSelectedItem()+"-"+report1.salReport.jcbStartMonth.getSelectedItem()+"-"+report1.salReport.jcbStartYear.getSelectedItem();
System.out.println(date1);
String date2=report1.salReport.jcbEndDate.getSelectedItem()+"-"+report1.salReport.jcbEndMonth.getSelectedItem()+"-"+report1.salReport.jcbEndYear.getSelectedItem();
try {


          OutputStream file = new FileOutputStream(new File("C:\\Bill.pdf"));
 
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            document.add(new Paragraph("HNET POS"));
			document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------"));
			document.add(new Paragraph(""));
            document.add(new Paragraph(new Date().toString()));
			 Paragraph p1=new Paragraph("Sales REPORT");
  document.add(p1);
 document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------"));
 CMYKColor color = new CMYKColor( 0, 1, (float)0.2, (float)0.667 );
String text = "kievan wrote more: different color and font type.";
Font o = FontFactory.getFont( FontFactory.TIMES_BOLD, 14, Font.BOLD, color );
//document.add(new Paragraph("sale Id : "+bill.jcbSaleId.getSelectedItem()+"      "+"Customer Details :"+bill.jcbFirstName.getSelectedItem()+" "+bill.jcbLastName.getSelectedItem(),o));

document.add(new Paragraph(""));
document.add(new Paragraph(""));
 document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------"));
 //Paragraph p2=new Paragraph("sale_Id | Product_Id | Quantity | sale_Date | Shipment_Date | sale_Status",o);
 PdfPTable table1=new PdfPTable(6);
 table1.addCell("sale Id");
 table1.addCell("Product Id");

 table1.addCell("Quantity");
  table1.addCell("Amount");
 table1.addCell("sale_Date");

 table1.addCell("Shipment_Date");

 document.add(table1);
  //Paragraph p2=new Paragraph("Manufacturer|Product |Quantity | Amount |Purchase_Date ",o);
  //document.add(p2);
  int i=0;
if(report1.salReport.jrbSaleDate.isSelected()){
    System.out.println("date1"+date1);
    System.out.println("date2"+date2);
    
 strQuery="select * from sale1 where sale_date between '"+date1+"' and '"+date2+"'";i=1;}
 else if(report1.salReport.jrbSaleDate.isSelected()){ strQuery="select * from sale1 where product_id=(select product_id from product where product_name='"+report1.salReport.jcbProduct.getSelectedItem()+"')";i=1;}
 else{JOptionPane.showMessageDialog(null,"Select an option" ,"Error",JOptionPane.ERROR_MESSAGE);}
 if(i==1){
 connect.executeQuery("query",strQuery);
 while(connect.rs.next()){
 PdfPTable table=new PdfPTable(6);
       table.addCell(connect.rs.getString(2));
       table.addCell(connect.rs.getString(4));
       table.addCell(connect.rs.getString(5));
       table.addCell(connect.rs.getString(6));
	   table.addCell(connect.rs.getString(7));
	   table.addCell(connect.rs.getString(8));
       document.add(table);
 //Paragraph p=new Paragraph(connect.rs.getString(2)+"                    "+connect.rs.getString(4)+"                  "+connect.rs.getString(5)+"               "+connect.rs.getString(7)+"       "+connect.rs.getString(8)+"       "+connect.rs.getString(9));
  //document.add(p);
    total+=connect.rs.getInt(6);
 }

 
 //Paragraph p=new Paragraph(mname+"            "+pname+""+connect.rs.getString(5)+"    "+connect.rs.getString(6)+"    "+connect.rs.getString(7));
  //document.add(p);

 
 
 document.add(new Paragraph(""));
   document.add(new Paragraph("Total Amount : "+total,o));
 document.addAuthor("DrAGoN");
document.addCreationDate();
document.addCreator("iText library");
document.addTitle("My First PDF");
 
            document.close();
            file.close();
 
    if(Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
			Desktop.getDesktop().open(new File("C:\\Bill.pdf"));}
        } 
		}
		catch (Exception e) {
 System.out.println("Error:33"+e);
            e.printStackTrace();
        


}
}
if(ae.getActionCommand().equals("report1.salReport.jrbProductType")){
report1.salReport.panel3.remove(report1.salReport.panel4);
report1.salReport.panel3.add(report1.salReport.panel5);
report1.salReport.panel4.setVisible(false);
report1.salReport.panel5.setVisible(true);
}
//----------------------------------Purchase Report---------------------------------------------------
if(ae.getActionCommand().equals("report1.purReport.jrbPurchaseDate")){
report1.purReport.panel3.remove(report1.purReport.panel5);
report1.purReport.panel3.add(report1.purReport.panel4);
report1.purReport.panel4.setVisible(true);
report1.purReport.panel5.setVisible(false);
}

if(ae.getActionCommand().equals("report1.purReport.jrbProductType")){
report1.purReport.panel3.remove(report1.purReport.panel4);
report1.purReport.panel3.add(report1.purReport.panel5);
report1.purReport.panel4.setVisible(false);
report1.purReport.panel5.setVisible(true);
}
//----------------------------------Complaint Report---------------------------------------------------
if(ae.getActionCommand().equals("report1.comReport.jrbComplaintDate")){
report1.comReport.panel3.remove(report1.comReport.panel5);
report1.comReport.panel3.add(report1.comReport.panel4);
report1.comReport.panel4.setVisible(true);
report1.comReport.panel5.setVisible(false);
}

if(ae.getActionCommand().equals("report1.comReport.jrbCustomer")){
report1.comReport.panel3.remove(report1.comReport.panel4);
report1.comReport.panel3.add(report1.comReport.panel5);
report1.comReport.panel4.setVisible(false);
report1.comReport.panel5.setVisible(true);
}
//-------------------------------------------------------------------------------------
}
//--------------------------------------MOUSE LISTENER------------------------------------
   public void mousePressed(MouseEvent e){//if(cust.isSelected()) System.out.println("Error:25"+e);
 // menu.getLayeredPane().setPosition(cust,0);
 } 
   // dont use these so leave them empty 
   public void mouseClicked(MouseEvent e){//if(e.getSource().equals(cust)){ System.out.println("Error:25"+e);menu.getLayeredPane().setPosition(cust,0);}
   } 
   public void mouseEntered(MouseEvent e){} 
   public void mouseExited(MouseEvent e){} 
   public void mouseReleased(MouseEvent e){} 
//--------------------------------------KEY LISTENER------------------------------------
public void  keyPressed(KeyEvent ke){}
public void  keyTyped(KeyEvent ke){}
public void  keyReleased(KeyEvent ke){

//-------------------------------------------Customer-------------------------------------
if(ke.getSource().equals(cust.editCust.txtSearch)) 
{
Object[][] dc=model.searchCustomer(cust.editCust.txtSearch,cust.editCust.jcbSearch);
s1="";
 final Object[] header={"Customer Id","Name","Last Name","Company"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
cust.editCust.jtCustomer.setModel(jtModel);
}
//-------------------------------------------Manufacturer-------------------------------------
if(ke.getSource().equals(manu.editManu.txtSearch)) 
{
Object[][] dc=model.searchManufacturer(manu.editManu.txtSearch);
s2="";
 final Object[] header={"Manufacturer Id","Name"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
manu.editManu.jtManufacturer.setModel(jtModel);
}
//-------------------------------------------Product-------------------------------------
if(ke.getSource().equals(prod.editProduct.txtSearch)) 
{
Object[][] dc=model.searchProduct(prod.editProduct.jcbManufacturer,prod.editProduct.txtSearch);
s3="";
 final Object[] header={"Product Id","Product Name","Manufacturer Name"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
prod.editProduct.jtProduct.setModel(jtModel);
}
//-------------------------------------------order--------------------------------------
if(ke.getSource().equals(order.upOrder.txtSearch)) 
{
Object[][] dc=model.searchOrder(order.upOrder.jcbManufacturer,order.upOrder.txtSearch);
s4="";
 final Object[] header={"order Id","Product Name","order"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
order.upOrder.jtOrder.setModel(jtModel);
}
//-------------------------------------------sale--------------------------------------
if(ke.getSource().equals(sale.addSale.txtSearch)) 
{
Object[][] dc=model.searchSale(sale.addSale.jcbManufacturer,sale.addSale.txtSearch);
s5="";
 final Object[] header={"Product Name","MRP","Box_Price","Stock"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
sale.addSale.jtProductList.setModel(jtModel);
sale.addSale.jtProductList.setAutoResizeMode(0);

}
//-------------------------------------------customer view search--------------------------
if(ke.getSource().equals(view.viewCust.txtCustomerName))
{
if(view.viewCust.txtCustomerName.getText().equals(""))
{
Object[][] vc = model.overAllView("Customer","Cust_id",10);
 final Object[] headerCust={"id","First Name","Last Name","State","Area","Address","Contactno.","Email","Company","Pincode"};
 DefaultTableModel jtModelCust=new DefaultTableModel(vc,headerCust);
view.viewCust.jtViewCustomer.setModel(jtModelCust);
}
else{
Object[][] vc = model.searchView(view.viewCust.txtCustomerName,"Customer","Cust_id",10);
 final Object[] headerCust={"id","First Name","Last Name","State","Area","Address","Contactno.","Email","Company","Pincode"};
 DefaultTableModel jtModelCust=new DefaultTableModel(vc,headerCust);
view.viewCust.jtViewCustomer.setModel(jtModelCust);
}
}


if(ke.getSource().equals(emp.editEmployee.txtSearch)) 
{

Object[][] dc=model.searchEmployee(emp.editEmployee.txtSearch);
s="";
 final Object[] header={"Id","First Name","Middle Name","Last Name"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
emp.editEmployee.jtEmployee.setModel(jtModel);
}
//------------------------------------------Manufacturer view search---------------------------
if(ke.getSource().equals(view.viewManu.txtManufacturerName))
{
if(view.viewManu.txtManufacturerName.getText().equals(""))
{
Object[][] vm = model.overAllView("Manufacturer","Manu_id",9);
 final Object[] headerManu={"id","Manufacturer","State","Area","Address","Contactno.","Email","Pincode","Vat"};
 DefaultTableModel jtModelManu=new DefaultTableModel(vm,headerManu);
view.viewManu.jtViewManufacturer.setModel(jtModelManu);


}
else{

Object[][] vm = model.searchView(view.viewManu.txtManufacturerName,"Manufacturer","Manu_id",9);
 final Object[] headerManu={"id","Manufacturer","State","Area","Address","Contactno.","Email","Pincode","Vat"};
 DefaultTableModel jtModelManu=new DefaultTableModel(vm,headerManu);
view.viewManu.jtViewManufacturer.setModel(jtModelManu);
}
}


if(ke.getSource().equals(view.viewProd.txtProductName))
{
if(view.viewProd.txtProductName.getText().equals(""))
{
Object[][] vp = model.overAllView("Product","Product_id",8);

 final Object[] headerProduct={"product id","Manufacturer id","Product Name","MRP","Customer Price","Unit_Quantity","Unit_Purchase_Price","Unit_Selling_Price"};
 DefaultTableModel jtModelProduct=new DefaultTableModel(vp,headerProduct);
view.viewProd.jtViewProduct.setModel(jtModelProduct);
}
else{
Object[][] vp = model.searchView(view.viewProd.txtProductName,"Product","Product_id",8);
 final Object[] headerProd={"id","Manufacturer","State","Area","Address","Contactno.","Email","Pincode"};
 DefaultTableModel jtModelProd=new DefaultTableModel(vp,headerProd);
view.viewProd.jtViewProduct.setModel(jtModelProd);
}
}

//-------------------------------------------------------------------------------
}
//--------------------------------------CHANGE LISTENER------------------------------------------------

public void itemStateChanged(ItemEvent ie){

if(ie.getSource().equals(cust.editCust.jcbSearch)){
Object[][] dc=model.searchCustomer(cust.editCust.txtSearch,cust.editCust.jcbSearch);

 final Object[] header={"Customer Id","Name","Last Name","Company"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
cust.editCust.jtCustomer.setModel(jtModel);
}

if(ie.getSource().equals(prod.editProduct.jcbManufacturer)){
Object[][] dc=model.searchProduct(prod.editProduct.jcbManufacturer,prod.editProduct.txtSearch);
s3="";
 final Object[] header={"Product Id","Product Name","Manufacturer Name"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
prod.editProduct.jtProduct.setModel(jtModel);

}
if(ie.getSource().equals(order.upOrder.jcbManufacturer)){
Object[][] dc=model.searchOrder(order.upOrder.jcbManufacturer,order.upOrder.txtSearch);

 final Object[] header={"order Id","Product Name","order"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
order.upOrder.jtOrder.setModel(jtModel);
}
if(ie.getSource().equals(order.adOrder.jcbManufacturer)){
try{
order.adOrder.jcbProduct.removeAllItems();
order.adOrder.jcbProduct.addItem("Select");

strQuery="select Product_name from product where manu_id=(select manu_id from manufacturer where manu_name='"+order.adOrder.jcbManufacturer.getSelectedItem()+"')";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
order.adOrder.jcbProduct.addItem(connect.rs.getString(1));

}

}
catch(Exception e){System.out.println("Error:25"+e);}

}
if(ie.getSource().equals(sale.addSale.jcbCompany)){

try{
sale.addSale.jcbFirstName.removeAllItems();
sale.addSale.jcbFirstName.addItem("Select");

strQuery="select * from customer  where cust_company='"+sale.addSale.jcbCompany.getSelectedItem()+"' order by Cust_First_Name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
sale.addSale.jcbFirstName.addItem(connect.rs.getString(2));

}
sale.updateSale.jcbCompany.setSelectedItem(sale.addSale.jcbCompany.getSelectedItem());
}
catch(Exception e){System.out.println("Error:25"+e);}
}

if(ie.getSource().equals(sale.updateSale.jcbCompany)){

try{
sale.updateSale.jcbFirstName.removeAllItems();
sale.updateSale.jcbFirstName.addItem("Select");

strQuery="select * from customer  where cust_company='"+sale.updateSale.jcbCompany.getSelectedItem()+"' order by Cust_First_Name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
sale.updateSale.jcbFirstName.addItem(connect.rs.getString(2));

}

}
catch(Exception e){System.out.println("Error:26"+e);}
}

if(ie.getSource().equals(sale.addSale.jcbFirstName)){

try{
sale.addSale.jcbLastName.removeAllItems();
sale.addSale.jcbLastName.addItem("Select");

strQuery="select * from customer  where cust_first_name='"+sale.addSale.jcbFirstName.getSelectedItem()+"' order by Cust_Last_Name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
sale.addSale.jcbLastName.addItem(connect.rs.getString(3));

}
sale.updateSale.jcbFirstName.setSelectedItem(sale.addSale.jcbFirstName.getSelectedItem());
}
catch(Exception e){System.out.println("Error:27"+e);}
}
if(ie.getSource().equals(sale.updateSale.jcbFirstName)){

try{
sale.updateSale.jcbLastName.removeAllItems();
sale.updateSale.jcbLastName.addItem("Select");

strQuery="select * from customer  where cust_first_name='"+sale.updateSale.jcbFirstName.getSelectedItem()+"' order by Cust_Last_Name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
sale.updateSale.jcbLastName.addItem(connect.rs.getString(3));

}

}
catch(Exception e){System.out.println("Error:28"+e);}
}
if(ie.getSource().equals(sale.addSale.jcbLastName)){
sale.updateSale.jcbLastName.setSelectedItem(sale.addSale.jcbLastName.getSelectedItem());
}


if(ie.getSource().equals(sale.addSale.jcbManufacturer)){
Object[][] dc=model.searchSale(sale.addSale.jcbManufacturer,sale.addSale.txtSearch);
s5="";
 final Object[] header={"Product Name","MRP","Box_Price","Stock"};
 DefaultTableModel jtModel=new DefaultTableModel(dc,header);
sale.addSale.jtProductList.setModel(jtModel);
sale.addSale.jtProductList.setAutoResizeMode(3);
}
if(ie.getSource().equals(comp.addComplaint.jcbCompany)){

try{
comp.addComplaint.jcbFirstName.removeAllItems();
comp.addComplaint.jcbFirstName.addItem("Select");

strQuery="select * from customer  where cust_company='"+comp.addComplaint.jcbCompany.getSelectedItem()+"' order by Cust_First_Name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
comp.addComplaint.jcbFirstName.addItem(connect.rs.getString(2));

}

}
catch(Exception e){System.out.println("Error:29"+e);}
}

if(ie.getSource().equals(comp.addComplaint.jcbFirstName)){

try{
comp.addComplaint.jcbLastName.removeAllItems();
comp.addComplaint.jcbLastName.addItem("Select");

strQuery="select * from customer  where cust_first_name='"+comp.addComplaint.jcbFirstName.getSelectedItem()+"' order by Cust_Last_Name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
comp.addComplaint.jcbLastName.addItem(connect.rs.getString(3));

}

}
catch(Exception e){System.out.println("Error:30"+e);}
}

if(ie.getSource().equals(comp.addComplaint.jcbLastName)){

try{
comp.addComplaint.jcbSaleId.removeAllItems();
comp.addComplaint.jcbSaleId.addItem("Select");

strQuery="select distinct(sale_id1) from sale1  where customer_id=(select cust_id from customer where cust_company='"+comp.addComplaint.jcbCompany.getSelectedItem()+"' and cust_First_Name='"+comp.addComplaint.jcbFirstName.getSelectedItem()+"' and cust_Last_name='"+comp.addComplaint.jcbLastName.getSelectedItem()+"' )";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
comp.addComplaint.jcbSaleId.addItem(connect.rs.getString(1));

}

}
catch(Exception e){System.out.println("Error:31"+e);}
}

if(ie.getSource().equals(comp.addComplaint.jcbSaleId)){

try{

comp.addComplaint.jcbProductName.removeAllItems();
comp.addComplaint.jcbProductName.addItem("Select");

strQuery="select product_id from sale1 where sale_id1="+comp.addComplaint.jcbSaleId.getSelectedItem()+"";
connect2.executeQuery("query",strQuery);
while(connect2.rs.next()){
System.out.println(connect2.rs.getInt(1));
strQuery="select product_name from product where product_id="+connect2.rs.getString(1)+"";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
comp.addComplaint.jcbProductName.addItem(connect.rs.getString(1));
}
}

}

catch(Exception e){System.out.println("Error:32"+e);}
}


if(ie.getSource().equals(report1.salReport.jcbManufacturer)){
try{
report1.salReport.jcbProduct.removeAllItems();
report1.salReport.jcbProduct.addItem("Select");

strQuery="select Product_name from product where manu_id=(select manu_id from manufacturer where manu_name='"+report1.salReport.jcbManufacturer.getSelectedItem()+"')";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
report1.salReport.jcbProduct.addItem(connect.rs.getString(1));

}

}
catch(Exception e){System.out.println("Error:25"+e);}

}


if(ie.getSource().equals(bill.jcbCompany)){

try{
bill.jcbFirstName.removeAllItems();
bill.jcbFirstName.addItem("Select");

strQuery="select * from customer  where cust_company='"+bill.jcbCompany.getSelectedItem()+"' order by Cust_First_Name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
bill.jcbFirstName.addItem(connect.rs.getString(2));

}

}
catch(Exception e){System.out.println("Error:29"+e);}
}

if(ie.getSource().equals(bill.jcbFirstName)){

try{
bill.jcbLastName.removeAllItems();
bill.jcbLastName.addItem("Select");

strQuery="select * from customer  where cust_first_name='"+bill.jcbFirstName.getSelectedItem()+"' order by Cust_Last_Name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
bill.jcbLastName.addItem(connect.rs.getString(3));

}

}
catch(Exception e){System.out.println("Error:30"+e);}
}

if(ie.getSource().equals(bill.jcbLastName)){

try{
bill.jcbSaleId.removeAllItems();
bill.jcbSaleId.addItem("Select");

strQuery="select distinct(sale_id1) from sale1  where customer_id=(select cust_id from customer where cust_company='"+bill.jcbCompany.getSelectedItem()+"' and cust_First_Name='"+bill.jcbFirstName.getSelectedItem()+"' and cust_Last_name='"+bill.jcbLastName.getSelectedItem()+"' )";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
bill.jcbSaleId.addItem(connect.rs.getString(1));

}

}
catch(Exception e){System.out.println("Error:31"+e);}
}
//------------------------------------------------------------------------------------------------------
}
class ClockListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		//... Whenever this is called, get the current time and
    		//    display it in the textfield.
            Calendar now = Calendar.getInstance();
            int h = now.get(Calendar.HOUR_OF_DAY);
            int m = now.get(Calendar.MINUTE);
            int s = now.get(Calendar.SECOND);
			//menu.lblLoginTime.setText("" + h + ":" + m + ":" + s);
            menu._timeField.setText("" + h + ":" + m + ":" + s);
            //... The following is an easier way to format the time,
            //    but requires knowing how to use the format method.
            //_timeField.setText(String.format("%1$tH:%1$tM:%1$tS", now));
    	}
    }

//-------------------------------------------DON CLASS--------------------------------------------------
public static void main(String[] args){
MyController Controller=new MyController();

}

//---------------------------------------THE END--------------------------------------------------------
}