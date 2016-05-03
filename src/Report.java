import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class Report extends JInternalFrame {

JTabbedPane jtbReport;


SalesReport salReport;
PurchaseReport purReport;
ComplaintReport comReport;


public Report(){
super("Report",false,true,false,false);

salReport=new SalesReport();
purReport=new PurchaseReport();
comReport=new ComplaintReport();


setLayout(new BorderLayout());

jtbReport=new JTabbedPane(JTabbedPane.TOP);


jtbReport.addTab("Sales Report",salReport);
jtbReport.addTab("Purchase Report",purReport);
jtbReport.addTab("Complaint Report",comReport);

add(jtbReport,BorderLayout.CENTER);
pack();

//setVisible(true);
setLocation(350,30);


}


}