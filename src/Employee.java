import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;

public class Employee extends JInternalFrame {

JTabbedPane jtbEmployee;


AddEmployee addEmployee;
EditEmployee editEmployee;


public Employee(){
super("Employee",false,true,false,false);

addEmployee=new AddEmployee();
editEmployee=new EditEmployee();

setLayout(new BorderLayout());

jtbEmployee=new JTabbedPane(JTabbedPane.TOP);

jtbEmployee.addTab("Edit Employee",editEmployee);
jtbEmployee.addTab("Add Employee",addEmployee);


add(jtbEmployee,BorderLayout.CENTER);
pack();

setVisible(true);
setLocation(250,30);

}


}