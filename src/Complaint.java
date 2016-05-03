import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;

public class Complaint extends JInternalFrame {

JTabbedPane jtbComplaint;


AddComplaint addComplaint;
ViewComplaint viewComplaint;

public Complaint(){
super("Complaint",false,true,false,false);

addComplaint=new AddComplaint();
viewComplaint=new ViewComplaint();

setLayout(new BorderLayout());

jtbComplaint=new JTabbedPane(JTabbedPane.TOP);


jtbComplaint.addTab("Add Complaint",addComplaint);
jtbComplaint.addTab("View Complaint",viewComplaint);

add(jtbComplaint,BorderLayout.CENTER);
pack();

setVisible(true);
	 getRootPane().setDefaultButton(addComplaint.btnCancel);
setLocation(350,30);
setSize(500,500);

}


}