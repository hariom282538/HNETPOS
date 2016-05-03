import java.awt.event.*;
import java.awt.Window;


public class BasicWindowMonitor2 extends WindowAdapter {
String s1;
Connectionn connect;
String strQuery;
public BasicWindowMonitor2(String s){
s1=s;
}
public void windowClosing(WindowEvent e) {
Window w = e.getWindow();
System.out.println(w);
//if(s1.equals("modifyCust")){System.out.println("Customer");
strQuery="update modifyf set "+s1+"=0 where "+s1+"=1";

w.setVisible(false);
connect=new Connectionn();

try{
connect.startConnection();

connect.executeQuery("update",strQuery);

connect.closeConnection();
}

catch(Exception e1){
System.out.print(e1);
}
w.dispose();
System.out.println("let d hackin begin");

}
}