import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class MyModel  {

Connectionn connect;

String username;
String password;
String strQuery;
String day,month,year;

boolean flag;
int pkey=1,last,check,mValidate,sCheck,nCheck,iflag,manuId=0,prodId=0,tempQuantity,quantity,boxQuantity;
float productPrice,boxPrice,vat;

 
public MyModel(){
connect=new Connectionn();
connect.startConnection();
}

//-------------------------------chkInstance-----------------------------------
void chkInstance(){
iflag=1;
try{


strQuery="select * from instance";
connect.executeQuery("query",strQuery);

while(connect.rs.next())
{
iflag=(connect.rs.getInt(1));
}

if(iflag==0)
{

strQuery="Delete from instance";
connect.executeQuery("update",strQuery);
strQuery="insert into instance values('1')";
connect.executeQuery("update",strQuery);

}
else {
//System.out.print("Already running");
JOptionPane.showMessageDialog(null,"The program is already running, \nOnly one instance can run at a time ! " ,"Error",JOptionPane.ERROR_MESSAGE);

System.exit(0);
}
}

catch(Exception e){
System.out.print(e);
}

}
//-----------------------------exit--------------------------------------------------

void exit(){
try{


strQuery="Delete from instance";
connect.executeQuery("update",strQuery);
strQuery="insert into instance values('0')";
connect.executeQuery("update",strQuery);
strQuery="delete from modifyf";
connect.executeQuery("update",strQuery);
strQuery="insert into modifyf values(0,0,0,0)";

connect.executeQuery("update",strQuery);
iflag=0;
strQuery="select * from instance";
connect.executeQuery("query",strQuery);
while(connect.rs.next())
{
iflag=(connect.rs.getInt(1));
System.out.println(iflag);
}

}

catch(Exception e1){
System.out.print(e1);
}
System.exit(0);
}
//---------------------------------------------login-----------------------------------

public boolean login(JTextField jtf,JPasswordField jpf){
try{


username=jtf.getText();
char[] p=jpf.getPassword();
password=new String(p);

strQuery="Select * from login where username='"+username+"'and password='"+password+"'";

connect.executeQuery("query",strQuery);
flag=false;

while(connect.rs.next())
{
System.out.println(connect.rs.getString(1));
flag=true;
}

}
catch(Exception e){
System.out.print(e);
}
if(flag) return(flag);
else if(jtf.getText().equals(""))
{JOptionPane.showMessageDialog(null,
        "Warning: Username Cannot be Blank !!!"
        ,
        "Warning",
        JOptionPane.WARNING_MESSAGE);
}
else if(password.equals(""))
{JOptionPane.showMessageDialog(null,
        "Warning: Password Cannot be Blank!!!"
        ,
        "Warning",
        JOptionPane.WARNING_MESSAGE);
}
else {//System.out.print("no match");
JOptionPane.showMessageDialog(null,
        "Warning: Wrong Username or Password !!!"
        ,
        "Warning",
        JOptionPane.WARNING_MESSAGE);
}

return(flag);
}

//------------------------------------numberCheck-------------------------------------
public boolean numberCheck(String x)
        {
            String strInput = x;
            
                try
                {
                        Long Input = Long.parseLong(strInput);
                }
                catch(Exception e)
                {
                    return(true);
                }
            return(false);
        }
//-----------------------------------charCheck----------------------------------------

        public boolean charCheck(String target)
        {
            
            String strInput = target;
			
            String substringInput = "null"; //substringInput;
            for(int i=0;i<strInput.length();i++)
            {  
                substringInput = strInput.substring(i,i+1);
                try
                {
                Integer.parseInt(substringInput);
          
			   return(true);
                }
               catch(Exception e)
                {}
            }        
            return(false);
            }
			
//-----------------------------------priceCheck----------------------------------------

      public boolean priceCheck(String x)
        {
            String strInput = x;
            
                try
                {
                        Float Input = Float.parseFloat(strInput);
                }
                catch(Exception e)
                {
                    return(true);
                }
            return(false);
        }
//------------------------------Prompt Type--------------------------------------
public void message(String target,String type){

if(type.equals("empty"))
JOptionPane.showMessageDialog(null,target+" Empty!!!" ,"Error",JOptionPane.ERROR_MESSAGE);
if(type.equals("number") || type.equals("char"))
JOptionPane.showMessageDialog(null,"Invalid "+target ,"Error",JOptionPane.ERROR_MESSAGE);
if(type.equals("length"))
JOptionPane.showMessageDialog(null,"Invalid "+target+" Length" ,"Error",JOptionPane.ERROR_MESSAGE);
}
//---------------------------------updateStock--------------------------------------------------
public void updateStock(String s,JTextField add,JTextField remove){
if(s.equals("")) JOptionPane.showMessageDialog(null,"Select a row to enter data ! " ,"Error",JOptionPane.ERROR_MESSAGE);
else if(add.getText().equals("") && remove.getText().equals(""))
{JOptionPane.showMessageDialog(null,"Enter Data to Add or Remove Stock ! " ,"Error",JOptionPane.ERROR_MESSAGE);}
else if(!add.getText().equals("") && !remove.getText().equals(""))
{JOptionPane.showMessageDialog(null,"You can Either Add or Remove Stock at a time ! ! " ,"Error",JOptionPane.ERROR_MESSAGE);}
else if(!add.getText().equals("")){if(numberCheck(add.getText())) message("Add","number");
else {
try{
strQuery="select * from Stock where Stock_Id="+s+" ";
connect.executeQuery("query",strQuery);
connect.rs.next();
quantity=connect.rs.getInt(3);
tempQuantity=Integer.parseInt(add.getText().trim());
quantity+=tempQuantity;
System.out.println(quantity);
strQuery="update Stock set Stock_Quantity="+quantity+" where Stock_Id="+s+" ";
connect.executeQuery("update",strQuery);

add.setText("");

}
catch(Exception e){System.out.println(e);}
}
}

else if(!remove.getText().equals("")){if(numberCheck(remove.getText())) message("Remove","number");
else {
try{
strQuery="select * from Stock where Stock_Id="+s+" ";
connect.executeQuery("query",strQuery);
connect.rs.next();
quantity=connect.rs.getInt(3);
 tempQuantity=Integer.parseInt(remove.getText().trim());
quantity-=tempQuantity;
if(quantity<0) quantity=0;
System.out.println(quantity);
strQuery="update Stock set Stock_Quantity="+quantity+" where Stock_Id="+s+" ";
connect.executeQuery("update",strQuery);

remove.setText("");

}
catch(Exception e){System.out.println(e);}
}
}
}
//---------------------------------searchSale--------------------------------------------------
public Object[][] searchSale(JComboBox jcb,JTextField jtf){
int i=0,j=0,k=0,m=0,size=0;
String[] obj=new String[100];
String search=jtf.getText().toUpperCase().trim();
//System.out.println(jcb.getSelectedItem());
Object[][] obj2=new Object[100][100];

try{
strQuery="select * from manufacturer where Manu_Name='"+jcb.getSelectedItem()+"'";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
manuId=connect.rs.getInt(1);
}

//strQuery="select p.product_Name,p.product_Mrp,p.box_price,s.stock_quantity,s.stock_ordered,s.stock_remaining from product p,stock s,manufacturer m where m.manu_id=p.manu_id and p.product_id=s.product_id and m.manu_id="+manuId+" ";
strQuery="select p.product_Name,p.product_Mrp,p.box_price,s.stock_quantity from product p,stock s,manufacturer m where m.manu_id=p.manu_id and p.product_id=s.product_id and m.manu_id="+manuId+" ";
connect.executeQuery("query",strQuery);

int length=search.length();

while(connect.rs.next()){
String txt=connect.rs.getString(1).toUpperCase();
if(txt.length()<search.length()) break;
if(search.equals("")) break;
if(search.equals(txt.substring(0,length))){
obj[k]=connect.rs.getString(1);
k++;
obj[k]=connect.rs.getString(2);
k++;
obj[k]=connect.rs.getString(3);
k++;
obj[k]=connect.rs.getString(4);
k++;

j=0;
obj2[i][j]=obj[m];
j++;m++;
obj2[i][j]=obj[m]; 
j++;m++;
obj2[i][j]=obj[m]; 
j++;m++;
obj2[i][j]=obj[m]; 
j++;m++;

i++;size++;
}

}
}catch(Exception e){}


Object[][] obj3=new Object[size][4];
for(int p=0;p<size;p++){
for(int q=0;q<4;q++){
obj3[p][q]=obj2[p][q];
}
}
return (obj3);
}
//---------------------------------saveCustomer--------------------------------------------------
public void saveCustomer(JTextField firstName,JTextField lastName,JComboBox state,JTextField area,JTextArea address,JTextField phone,JTextField email,JTextField company,JTextField pin){

if(firstName.getText().equals("")) message("First Name","empty");
else if(charCheck(firstName.getText())) message("First Name","char");

else if(lastName.getText().equals("")) message("Last Name","empty");
else if(charCheck(lastName.getText())) message("Last Name","char");

else if(area.getText().equals("")) message("Area ","empty");
else if(charCheck(area.getText())) message("Area","char");

else if(address.getText().equals("")) message("Address","empty");
//else if(charCheck(address.getText())) message("Address","char");

else if(phone.getText().equals("")) message("Phone","empty");
else if(numberCheck(phone.getText())) message("Phone","number");

//else if(email.getText().equals("")) message("Email","empty");
else if(charCheck(email.getText())) message("Email","char");

else if(company.getText().equals("")) message("Company","empty");
else if(charCheck(company.getText())) message("Company","char");

else if(pin.getText().equals("")) message("Pincode","empty");
else if(numberCheck(pin.getText())) message("Pincode","number");

else{
JOptionPane.showMessageDialog(null,"Data Inserted" ,"Information",JOptionPane.INFORMATION_MESSAGE);


try{
strQuery="select * from customer order by Cust_Id";

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

strQuery="insert into Customer values(	"+pkey+",'"+ firstName.getText() +"','"+ lastName.getText()+ "','"+ state.getSelectedItem()+"','"+ area.getText() +"','"+ address.getText() +"',"+phone.getText()+",'"+ email.getText() +"','"+ company.getText() +"',"+pin.getText()+")";

connect.executeQuery("update",strQuery);


firstName.setText("");
lastName.setText("");
area.setText("");	
address.setText("");
phone.setText("");
email.setText("");
company.setText("");
pin.setText("");
}
catch(Exception e){System.out.println(e);
}
}

}

//---------------------------------------editCustomer-----------------------------------
public void editCustomer(String s){


strQuery="delete from customer where cust_id="+s+"";

connect.executeQuery("update",strQuery);

}

//----------------------------------------searchCustomer-----------------------------------
public Object[][] searchCustomer(JTextField jtf,JComboBox jcb){
int i=0,j=0,k=0,m=0,size=0;
String[] obj=new String[100];
String search=jtf.getText().toUpperCase().trim();
System.out.println(jcb.getSelectedItem());
Object[][] obj2=new Object[10][4];

strQuery="select * from customer";
connect.executeQuery("query",strQuery);

int length=search.length();
try{
if(jcb.getSelectedItem().equals("Company"))
{
while(connect.rs.next()){
String txt=connect.rs.getString(9).toUpperCase();
if(txt.length()<search.length()) break;
if(search.equals("")) break;
if(search.equals(txt.substring(0,length))){
obj[k]=connect.rs.getString(1);
k++;
obj[k]=connect.rs.getString(2);
k++;
obj[k]=connect.rs.getString(3);
k++;
obj[k]=connect.rs.getString(9);
k++;
j=0;
obj2[i][j]=obj[m];
j++;m++;
obj2[i][j]=obj[m]; 
j++;m++;
obj2[i][j]=obj[m];
j++;m++;
obj2[i][j]=obj[m];
i++;m++;size++;
}

}

}

else 
{
while(connect.rs.next()){
String txt=connect.rs.getString(2).toUpperCase();
if(txt.length()<search.length()) break;
if(search.equals("")) break;
if(search.equals(txt.substring(0,length))){
obj[k]=connect.rs.getString(1);
k++;
obj[k]=connect.rs.getString(2);
k++;
obj[k]=connect.rs.getString(3);
k++;
obj[k]=connect.rs.getString(9);
k++;
j=0;
obj2[i][j]=obj[m];
j++;m++;
obj2[i][j]=obj[m]; 
j++;m++;
obj2[i][j]=obj[m];
j++;m++;
obj2[i][j]=obj[m];
i++;m++;size++;
}

}

}
}catch(Exception e){}


Object[][] obj3=new Object[size][4];
for(int p=0;p<size;p++){
for(int q=0;q<4;q++){
obj3[p][q]=obj2[p][q];
}
}
return (obj3);
}
//----------------------------------------modifyCustomer--------------------------
public void modifyCustomer(String s,JTextField firstName,JTextField lastName,JComboBox state,JTextField area,JTextArea address,JTextField phone,JTextField email,JTextField company,JTextField pin){
try{

strQuery="select * from customer where cust_id="+s+"";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
firstName.setText(connect.rs.getString(2));
lastName.setText(connect.rs.getString(3));
state.setSelectedItem(connect.rs.getString(4));
area.setText(connect.rs.getString(5));
address.setText(connect.rs.getString(6));
phone.setText(connect.rs.getString(7));
email.setText(connect.rs.getString(8));
company.setText(connect.rs.getString(9));
pin.setText(connect.rs.getString(10));

}



}
catch(Exception e){}
}
//--------------------------------------saveModifiedCustomer------------------------------------------
public void saveModifiedCustomer(JFrame modifyCust,String s,JTextField firstName,JTextField lastName,JComboBox state,JTextField area,JTextArea address,JTextField phone,JTextField email,JTextField company,JTextField pin){

if(firstName.getText().equals("")) message("First Name","empty");
else if(charCheck(firstName.getText())) message("First Name","char");

else if(lastName.getText().equals("")) message("Last Name","empty");
else if(charCheck(lastName.getText())) message("Last Name","char");

else if(area.getText().equals("")) message("Area ","empty");
else if(charCheck(area.getText())) message("Area","char");

else if(address.getText().equals("")) message("Address","empty");
//else if(charCheck(address.getText())) message("Address","char");

else if(phone.getText().equals("")) message("Phone","empty");
else if(numberCheck(phone.getText())) message("Phone","number");

//else if(email.getText().equals("")) message("Email","empty");
else if(charCheck(email.getText())) message("Email","char");

else if(company.getText().equals("")) message("Company","empty");
else if(charCheck(company.getText())) message("Company","char");

else if(pin.getText().equals("")) message("Pincode","empty");
else if(numberCheck(pin.getText())) message("Pincode","number");


else{

try{
strQuery="update customer set Cust_First_name='"+ firstName.getText() +"',Cust_Last_Name='"+ lastName.getText()+ "',Cust_State='"+ state.getSelectedItem()+"',Cust_Area='"+ area.getText() +"',Cust_Address='"+ address.getText() +"',Cust_Phone="+phone.getText()+",Cust_Email='"+ email.getText() +"',Cust_Company='"+ company.getText() +"',Cust_Pin="+pin.getText()+" where cust_Id="+s+"";

connect.executeQuery("update",strQuery);


firstName.setText("");
lastName.setText("");
area.setText("");	
address.setText("");
phone.setText("");
email.setText("");
company.setText("");
pin.setText("");

JOptionPane.showMessageDialog(null,"Data Saved" ,"Information",JOptionPane.INFORMATION_MESSAGE);
modifyCust.dispose();
}
catch(Exception e){System.out.println(e);
}
}

}
//---------------------------------------clearCustomer--------------------------------------------
public void clearCustomer(JTextField firstName,JTextField lastName,JComboBox state,JTextField area,JTextArea address,JTextField phone,JTextField email,JTextField company,JTextField pin){

firstName.setText("");
lastName.setText("");
area.setText("");	
address.setText("");
phone.setText("");
email.setText("");
company.setText("");
pin.setText("");

}
//---------------------------------------saveManufacturer-----------------------
public void saveManufacturer(JTextField Name,JComboBox state,JTextField area,JTextArea address,JTextField phone,JTextField email,JTextField pin,JTextField vat){

if(Name.getText().equals("")) message("Name","empty");
else if(charCheck(Name.getText())) message("Name","char");

else if(vat.getText().equals("")) message("Vat","empty");
else if(priceCheck(vat.getText())) message("Vat","number");

else if(area.getText().equals("")) message("Area ","empty");
else if(charCheck(area.getText())) message("Area","char");

else if(address.getText().equals("")) message("Address","empty");
//else if(charCheck(address.getText())) message("Address","char");

else if(phone.getText().equals("")) message("Phone","empty");
else if(numberCheck(phone.getText())) message("Phone","number");
else if((phone.getText().length()>10) || (phone.getText().length()<8)) message("Phone Number","length");

else if(email.getText().equals("")) message("Email","empty");
else if(charCheck(email.getText())) message("Email","char");

else if(pin.getText().equals("")) message("Pincode","empty");
else if(numberCheck(pin.getText())) message("Pincode","number");


else{

try{
strQuery="select * from manufacturer order by Manu_Id";

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

strQuery="insert into manufacturer values("+pkey+",'"+ Name.getText() +"','"+ state.getSelectedItem()+"','"+ area.getText() +"','"+ address.getText() +"',"+phone.getText()+",'"+ email.getText() +"',"+pin.getText()+","+vat.getText()+")";

connect.executeQuery("update",strQuery);


Name.setText("");
//lastName.setText("");
area.setText("");	
address.setText("");
phone.setText("");
email.setText("");
//company.setText("");
pin.setText("");
vat.setText("");


JOptionPane.showMessageDialog(null,"Data Inserted" ,"Information",JOptionPane.INFORMATION_MESSAGE);
}
catch(Exception e){System.out.println(e);
}
}

}

//---------------------------------------searchManufacturer-----------------------
public Object[][] searchManufacturer(JTextField jtf){
int i=0,j=0,k=0,m=0,size=0;
String[] obj=new String[100];
String search=jtf.getText().toUpperCase().trim();
//System.out.println(jcb.getSelectedItem());
Object[][] obj2=new Object[10][2];

strQuery="select * from manufacturer";
connect.executeQuery("query",strQuery);

int length=search.length();
try{
while(connect.rs.next()){
String txt=connect.rs.getString(2).toUpperCase();
if(txt.length()<search.length()) break;
if(search.equals("")) break;
if(search.equals(txt.substring(0,length))){
obj[k]=connect.rs.getString(1);
k++;
obj[k]=connect.rs.getString(2);
k++;

j=0;
obj2[i][j]=obj[m];
j++;m++;
obj2[i][j]=obj[m]; 
j++;m++;i++;
size++;
}

}
}catch(Exception e){}


Object[][] obj3=new Object[size][4];
for(int p=0;p<size;p++){
for(int q=0;q<2;q++){
obj3[p][q]=obj2[p][q];
}
}
return (obj3);
}
//---------------------------------------editManufacturer--------------------------------------------------
public void editManufacturer(String s){

try{
strQuery="delete from Manufacturer where manu_id="+s+"";

connect.executeQuery("update",strQuery);
}
catch(Exception e){JOptionPane.showMessageDialog(null,"There are products associated with this manufacturer" ,"Delete Failed",JOptionPane.ERROR_MESSAGE);}

}
//----------------------------------------modifyManufacturer--------------------------
public void modifyManufacturer(String s,JTextField Name,JComboBox state,JTextField area,JTextArea address,JTextField phone,JTextField email,JTextField pin,JTextField vat){
try{

strQuery="select * from Manufacturer where manu_id="+s+"";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
Name.setText(connect.rs.getString(2));
state.setSelectedItem(connect.rs.getString(3));
area.setText(connect.rs.getString(4));
address.setText(connect.rs.getString(5));
phone.setText(connect.rs.getString(6));
email.setText(connect.rs.getString(7));
pin.setText(connect.rs.getString(8));
vat.setText(connect.rs.getString(9));


}


}
catch(Exception e){}

}

//--------------------------------------saveModifiedManufacturer------------------------------------------
public void saveModifiedManufacturer(JFrame modifymanu,String s,JTextField name,JComboBox state,JTextField area,JTextArea address,JTextField phone,JTextField email,JTextField pin,JTextField vat){

if(name.getText().equals("")) message("First Name","empty");
else if(charCheck(name.getText())) message("First Name","char");

else if(vat.getText().equals("")) message("Vat","empty");
else if(priceCheck(vat.getText())) message("Vat","number");

else if(area.getText().equals("")) message("Area ","empty");
else if(charCheck(area.getText())) message("Area","char");

else if(address.getText().equals("")) message("Address","empty");
//else if(charCheck(address.getText())) message("Address","char");

else if(phone.getText().equals("")) message("Phone","empty");
else if(numberCheck(phone.getText())) message("Phone","number");

else if(email.getText().equals("")) message("Email","empty");
else if(charCheck(email.getText())) message("Email","char");

else if(pin.getText().equals("")) message("Pincode","empty");
else if(numberCheck(pin.getText())) message("Pincode","number");


else{

try{
strQuery="update Manufacturer set manu_name='"+ name.getText() +"',manu_State='"+ state.getSelectedItem()+"',manu_Area='"+ area.getText() +"',manu_Address='"+ address.getText() +"',manu_Phone="+phone.getText()+",manu_Email='"+ email.getText() +"',manu_Pin="+pin.getText()+",manu_vat="+vat.getText()+" where manu_Id="+s+"";

connect.executeQuery("update",strQuery);


name.setText("");
area.setText("");	
address.setText("");
phone.setText("");
email.setText("");
pin.setText("");
vat.setText("");


JOptionPane.showMessageDialog(null,"Data Saved" ,"Information",JOptionPane.INFORMATION_MESSAGE);
modifymanu.dispose();
}
catch(Exception e){System.out.println(e);
}
}

}

//---------------------------------------clearManufacturer--------------------------------------------
public void clearManufacturer(JTextField Name,JComboBox state,JTextField area,JTextArea address,JTextField phone,JTextField email,JTextField pin,JTextField vat){

Name.setText("");
area.setText("");	
address.setText("");
phone.setText("");
email.setText("");
pin.setText("");
vat.setText("");


}
//---------------------------------------PRODUCT----------------------------------------------

//---------------------------------saveProduct--------------------------------------------------
public void saveProduct(JComboBox jcbManufacturer,JTextField txtProductName,JTextField txtPrice,JTextField txtCustomerPrice,JTextField txtBoxQuantity,JTextField txtBoxMrp){

if(txtProductName.getText().equals("")) message("Product Name","empty");
else if(charCheck(txtProductName.getText())) message("Product Name","char");

else if(txtPrice.getText().equals("")) message("Product Mrp","empty");
else if(priceCheck(txtPrice.getText())) message("Product Mrp","number");

else if(txtCustomerPrice.getText().equals("")) message("Customer Price","empty");
else if(priceCheck(txtCustomerPrice.getText())) message("Customer Price","number");

else if(txtBoxQuantity.getText().equals("")) message("Box Quantity","empty");
else if(priceCheck(txtBoxQuantity.getText())) message("Box Quantity","number");

else if(txtBoxMrp.getText().equals("")) message("Box Price","empty");
else if(priceCheck(txtBoxMrp.getText())) message("Box Price","number");

else{

try{
strQuery="select * from product order by Product_Id";
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

strQuery="select * from manufacturer where Manu_Name='"+jcbManufacturer.getSelectedItem()+"'";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
manuId=connect.rs.getInt(1);
}
vat=0;
strQuery="select manu_vat from manufacturer where manu_id="+manuId+"";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
vat=connect.rs.getFloat(1);
}

boxPrice=0;
boxQuantity=Integer.parseInt(txtBoxQuantity.getText().trim());
productPrice=Float.parseFloat(txtCustomerPrice.getText().trim());
System.out.println(productPrice+"PP");

boxPrice=productPrice * boxQuantity;
boxPrice+=((vat/100)* boxPrice);
System.out.println(boxPrice+"PP");

strQuery="insert into product values("+pkey+","+manuId+",'"+ txtProductName.getText() +"',"+ txtPrice.getText() +","+ txtCustomerPrice.getText() +","+txtBoxQuantity.getText()+","+ txtBoxMrp.getText() +","+boxPrice+")";

connect.executeQuery("update",strQuery);

strQuery="insert into stock values("+pkey+","+pkey+",0,0,0)";
connect.executeQuery("update",strQuery);



txtProductName.setText("");
txtPrice.setText("");	
txtCustomerPrice.setText("");
txtBoxQuantity.setText("");
txtBoxMrp.setText("");

JOptionPane.showMessageDialog(null,"Data Inserted" ,"Information",JOptionPane.INFORMATION_MESSAGE);
}
catch(Exception e){System.out.println(e);
}
}

}
//---------------------------------------searchProduct-----------------------
public Object[][] searchProduct(JComboBox jcb,JTextField jtf){
int i=0,j=0,k=0,m=0,size=0;
String[] obj=new String[100];
String search=jtf.getText().toUpperCase().trim();
//System.out.println(jcb.getSelectedItem());
Object[][] obj2=new Object[10][3];

try{
strQuery="select * from manufacturer where Manu_Name='"+jcb.getSelectedItem()+"'";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
manuId=connect.rs.getInt(1);
}

strQuery="select * from product where Manu_Id="+manuId+"";
connect.executeQuery("query",strQuery);

int length=search.length();

while(connect.rs.next()){
String txt=connect.rs.getString(3).toUpperCase();
if(txt.length()<search.length()) break;
if(search.equals("")) break;
if(search.equals(txt.substring(0,length))){
obj[k]=connect.rs.getString(1);
k++;
obj[k]=connect.rs.getString(3);
k++;

j=0;
obj2[i][j]=obj[m];
j++;m++;
obj2[i][j]=obj[m]; 
j++;m++;
i++;size++;
}

}
}catch(Exception e){}


Object[][] obj3=new Object[size][3];
for(int p=0;p<size;p++){
for(int q=0;q<2;q++){
obj3[p][q]=obj2[p][q];
}
}
return (obj3);
}

//---------------------------------------editProduct--------------------------------------------------
public void editProduct(String s){


strQuery="delete from Product where Product_id="+s+"";

connect.executeQuery("update",strQuery);


}
//------------------------------------clearProduct----------------------------------------
public void clearProduct(JTextField txtProductName,JTextField txtPrice,JTextField txtCustomerPrice,JTextField txtBoxQuantity,JTextField txtBoxMrp){

txtProductName.setText("");	
txtPrice.setText("");	
txtCustomerPrice.setText("");	
txtBoxQuantity.setText("");	
txtBoxMrp.setText("");	
}
//----------------------------------------modifyProduct--------------------------
public void modifyProduct(String s,JComboBox jcbManufacturer,JTextField txtProductName,JTextField txtPrice,JTextField txtCustomerPrice,JTextField txtBoxQuantity,JTextField txtBoxMrp){
try{


jcbManufacturer.removeAllItems();

strQuery="select * from manufacturer order by manu_name";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
jcbManufacturer.addItem(connect.rs.getString(2));

}

String strManu="";int manu=0;
strQuery="select manu_id from product where product_id="+s+"";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
manu=connect.rs.getInt(1);
}

strQuery="select * from manufacturer where manu_id="+manu+"";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
strManu=connect.rs.getString(2);
}

strQuery="select * from Product where Product_id="+s+"";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
jcbManufacturer.setSelectedItem(strManu);
txtProductName.setText(connect.rs.getString(3));
txtPrice.setText(connect.rs.getString(4));
txtCustomerPrice.setText(connect.rs.getString(5));
txtBoxQuantity.setText(connect.rs.getString(6));
txtBoxMrp.setText(connect.rs.getString(7));

}


}
catch(Exception e){}

}
//---------------------------------saveModifiedProduct--------------------------------------------------
public void saveModifiedProduct(JFrame modifyProd,String s,JComboBox jcbManufacturer,JTextField txtProductName,JTextField txtPrice,JTextField txtCustomerPrice,JTextField txtBoxQuantity,JTextField txtBoxMrp){

if(txtProductName.getText().equals("")) message("Product Name","empty");
else if(charCheck(txtProductName.getText())) message("Product Name","char");

else if(txtPrice.getText().equals("")) message("Product Mrp","empty");
else if(priceCheck(txtPrice.getText())) message("Product Mrp","number");

else if(txtCustomerPrice.getText().equals("")) message("Customer Price","empty");
else if(priceCheck(txtCustomerPrice.getText())) message("Customer Price","number");

else if(txtBoxQuantity.getText().equals("")) message("Box Quantity","empty");
else if(priceCheck(txtBoxQuantity.getText())) message("Box Quantity","number");

else if(txtBoxMrp.getText().equals("")) message("Box Price","empty");
else if(priceCheck(txtBoxMrp.getText())) message("Box Price","number");

else{

try{


strQuery="select * from manufacturer where Manu_Name='"+jcbManufacturer.getSelectedItem()+"'";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
manuId=connect.rs.getInt(1);
}
vat=0;
strQuery="select manu_vat from manufacturer where manu_id="+manuId+"";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
vat=connect.rs.getFloat(1);
}

boxPrice=0;
boxQuantity=Integer.parseInt(txtBoxQuantity.getText().trim());
productPrice=Float.parseFloat(txtCustomerPrice.getText().trim());
boxPrice=productPrice * boxQuantity;
boxPrice+=vat*boxPrice;

strQuery="update product set manu_id="+manuId+",product_name='"+ txtProductName.getText() +"',product_mrp="+ txtPrice.getText() +",product_price="+ txtCustomerPrice.getText() +",box_Quantity="+txtBoxQuantity.getText()+",Box_mrp="+ txtBoxMrp.getText() +",Box_Price="+boxPrice+" where product_id="+s+"";

connect.executeQuery("update",strQuery);


txtProductName.setText("");
txtPrice.setText("");	
txtCustomerPrice.setText("");
txtBoxQuantity.setText("");
txtBoxMrp.setText("");

JOptionPane.showMessageDialog(null,"Data Inserted" ,"Information",JOptionPane.INFORMATION_MESSAGE);
modifyProd.dispose();
}
catch(Exception e){System.out.println(e);
}
}

}
//--------------------------------------------searchOrder---------------------------------
public Object[][] searchOrder(JComboBox jcb,JTextField jtf){
int i=0,j=0,k=0,m=0,size=0;
String[] obj=new String[100];
String search=jtf.getText().toUpperCase().trim();
//System.out.println(jcb.getSelectedItem());
Object[][] obj2=new Object[10][3];

try{
strQuery="select * from manufacturer where Manu_Name='"+jcb.getSelectedItem()+"'";
connect.executeQuery("query",strQuery);
while(connect.rs.next()){
manuId=connect.rs.getInt(1);
}



strQuery="select s.stock_id,p.product_name,s.stock_quantity from stock s,product p,manufacturer m where m.manu_id="+manuId+" and p.manu_Id=m.manu_Id and s.product_id=p.product_id";
connect.executeQuery("query",strQuery);

int length=search.length();

while(connect.rs.next()){
String txt=connect.rs.getString(2).toUpperCase();
if(txt.length()<search.length()) break;
if(search.equals("")) break;
if(search.equals(txt.substring(0,length))){
obj[k]=connect.rs.getString(1);
k++;
obj[k]=connect.rs.getString(2);
k++;
obj[k]=connect.rs.getString(3);
k++;
j=0;
obj2[i][j]=obj[m];
j++;m++;
obj2[i][j]=obj[m]; 
j++;m++;
obj2[i][j]=obj[m]; 
j++;m++;
i++;size++;
}
}

}catch(Exception e){}


Object[][] obj3=new Object[size][3];
for(int p=0;p<size;p++){
for(int q=0;q<3;q++){
obj3[p][q]=obj2[p][q];
}
}
return (obj3);
}
//----------------------------------------------Over all view-------------------------------
public Object[][] overAllView(String entity,String search,int index)
{
int i=0,j=0,k=0,m=0,size=0;

String[] obj=new String[1000];
//System.out.println(jcb.getSelectedItem());
Object[][] obj2=new Object[100][30];

strQuery="select * from "+entity+" order by "+search+"";
connect.executeQuery("query",strQuery);
try{
while(connect.rs.next()){
j=0;
for(int x=1;x<=index;x++)
{

obj[k]=connect.rs.getString(x);
obj2[i][j]=obj[k];

k++;j++;

}
i++;size++;
}
}catch(Exception e){System.out.println("O:"+e);}


Object[][] obj3=new Object[size][10];
for(int p=0;p<size;p++){
for(int q=0;q<index;q++){
obj3[p][q]=obj2[p][q];
}
}
return (obj3);


}
//---------------------------------------------Search View-----------------------------------
public Object[][] searchView(JTextField jtf,String entity,String search,int index)
{int i=0,j=0,k=0,m=0,size=0;

String[] obj=new String[100];
String searchAll=jtf.getText().toUpperCase().trim();
//System.out.println(jcb.getSelectedItem());
Object[][] obj2=new Object[100][30];


strQuery="select * from "+entity+" order by "+search+"";
connect.executeQuery("query",strQuery);
int length=searchAll.length();
try{
while(connect.rs.next()){
String txt;
if(entity=="Product")
{
 txt=connect.rs.getString(3).toUpperCase();
}
else
{
 txt=connect.rs.getString(2).toUpperCase();
}
if(txt.length()<searchAll.length()) break;
//if(search.equals("")) break;
if(searchAll.equals(txt.substring(0,length))){
j=0;
for(int x=1;x<=index;x++)
{

obj[k]=connect.rs.getString(x);
obj2[i][j]=obj[k];

k++;j++;

}
i++;size++;
}

}}catch(Exception e){}


Object[][] obj3=new Object[size][100];
for(int p=0;p<size;p++){
for(int q=0;q<index;q++){
obj3[p][q]=obj2[p][q];
}
}
return (obj3);

}


//--------------------------------------------Date calculation------------------------------

public  Object[] show(String x)
{
Object[] date=new Object[3];
int i=x.length();
String save=x;
System.out.println(i);
if(save.length()==10)
{
day=save.substring(0,1);
month=save.substring(2,5);
year=save.substring(6,10);
date[0]=day;
date[1]=month;
date[2]=year;
}
else if(save.length()==11)
{
day=save.substring(0,2);
month=save.substring(3,6);
year=save.substring(7,11);
date[0]=day;
date[1]=month;
date[2]=year;
}
return(date);
}


//-------------------------------------------Add Employee------------------------------
public void saveEmployee(JTextField FirstName,JTextField MiddleName,JTextField LastName,JRadioButton Male,JRadioButton Female,JComboBox BirthDay,JComboBox BirthMonth,JComboBox BirthYear,JComboBox Qualification,JTextField RAddress,JComboBox RState,JTextField RArea,JTextField RPin,JTextField RPhone,JTextField Email,JTextField NAddress,JComboBox NState,JTextField NArea,JTextField NPin,JTextField NPhone,JComboBox JoiningDay,JComboBox JoiningMonth,JComboBox JoiningYear,JComboBox Department,JTextField Designation,JTextField PayOfDay,JTextField OverTimePay)
{
  String Sex="Male";

  String DOB =(String)BirthDay.getSelectedItem() + "-" + (String)BirthMonth.getSelectedItem() + "-" + (String)BirthYear.getSelectedItem();
 String DOJ =(String)JoiningDay.getSelectedItem() + "-" + (String)JoiningMonth.getSelectedItem() + "-" + (String)JoiningYear.getSelectedItem();
  
System.out.println(DOB+ "  "+DOJ);
if(Female.isSelected())	
     	 Sex="Female";
	 
 if(FirstName.getText().equals("")) message("First Name","empty");
else if(charCheck(FirstName.getText())) message("First Name","char");

else if(MiddleName.getText().equals("")) message("Middle Name","empty");
else if(charCheck(MiddleName.getText())) message("Middle Name","char");

else if(LastName.getText().equals("")) message("Last Name","empty");
else if(charCheck(LastName.getText())) message("Last Name","char");

 
     
	 
	 else if(RArea.getText().equals("")) message("Residential Area ","empty");
else if(charCheck(RArea.getText())) message("Residential Area","char");

else if(RAddress.getText().equals("")) message("Residential Address","empty");
//else if(charCheck(address.getText())) message("Address","char");

else if(RPhone.getText().equals("")) message("Residential Phone","empty");
else if(numberCheck(RPhone.getText())) message("Residential Phone","number");

else if(Email.getText().equals("")) message("Email","empty");
else if(charCheck(Email.getText())) message("Email","char");

else if(RPin.getText().equals("")) message("Residential Pincode","empty");
else if(numberCheck(RPin.getText())) message("Residential Pincode","number");

else if(NArea.getText().equals("")) message("Residential Area ","empty");
else if(charCheck(NArea.getText())) message("Residential Area","char");

else if(NAddress.getText().equals("")) message("Residential Address","empty");
//else if(charCheck(address.getText())) message("Address","char");

else if(NPhone.getText().equals("")) message("Residential Phone","empty");
else if(numberCheck(NPhone.getText())) message("Residential Phone","number");

else if(NPin.getText().equals("")) message("Residential Pincode","empty");
else if(numberCheck(RPin.getText())) message("Residential Pincode","number");

else if(Designation.getText().equals("")) message("Designation","empty");
else if(charCheck(Designation.getText())) message("Designation","char");

else if(PayOfDay.getText().equals("")) message("PayOfDay","empty");
else if(numberCheck(PayOfDay.getText())) message("PayOfDay","number");

else if(OverTimePay.getText().equals("")) message("OverTimePay","empty");
else if(numberCheck(OverTimePay.getText())) message("OverTimePay","number");







else{
JOptionPane.showMessageDialog(null,"Data Inserted" ,"Information",JOptionPane.INFORMATION_MESSAGE);

  

try{
strQuery="select * from employee order by emp_id";

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


strQuery="insert into employee values("+pkey+",'"+FirstName.getText()+"','"+MiddleName.getText()+ "','"+LastName.getText()+"','"+Sex+"','"+DOB+"','"+Qualification.getSelectedItem()+"','"+RAddress.getText()+"','"+RState.getSelectedItem()+"','"+RArea.getText()+"','"+RPin.getText()+"','"+RPhone.getText()+"','"+NAddress.getText()+"','"+NState.getSelectedItem()+"','"+NArea.getText()+"','"+NPin.getText()+"','"+NPhone.getText()+"','"+DOJ+"','"+Department.getSelectedItem()+"','"+Designation.getText()+"','"+PayOfDay.getText()+"','"+OverTimePay.getText()+"','"+Email.getText()+"')";

connect.executeQuery("update",strQuery);


FirstName.setText("");
MiddleName.setText("");
LastName.setText("");
RArea.setText("");	
RAddress.setText("");
RPhone.setText("");
Email.setText("");
RPin.setText("");
NArea.setText("");	
NAddress.setText("");
NPhone.setText("");
NPin.setText("");
Designation.setText("");
PayOfDay.setText("");
OverTimePay.setText(""); 



}
catch(Exception e){System.out.println(e);
}
}
}
//---------------------------------------delete Employee----------------------------------
public void editEmployee(String s){


strQuery="delete from employee where emp_id="+s+"";

connect.executeQuery("update",strQuery);


}
//---------------------------------------Search Employee------------------------------------
public Object[][] searchEmployee(JTextField jtf){
int i=0,j=0,k=0,m=0,size=0;
String[] obj=new String[100];
String search=jtf.getText().toUpperCase().trim();
System.out.println(search);
Object[][] obj2=new Object[10][10];

strQuery="select * from employee";
connect.executeQuery("query",strQuery);

int length=search.length();
try{



while(connect.rs.next()){

String txt=connect.rs.getString(2).toUpperCase();
if(txt.length()<search.length()) break;
if(search.equals("")) break;
if(search.equals(txt.substring(0,length))){
obj[k]=connect.rs.getString(1);

k++;
obj[k]=connect.rs.getString(2);

k++;
obj[k]=connect.rs.getString(3);

k++;
obj[k]=connect.rs.getString(4);

k++;
j=0;
obj2[i][j]=obj[m];
System.out.println(obj[m]+"");
j++;m++;
obj2[i][j]=obj[m]; 
System.out.println(obj[m]+"");
j++;m++;
obj2[i][j]=obj[m]; 
System.out.println(obj[m]+"");
j++;m++;

obj2[i][j]=obj[m]; 
System.out.println(obj[m]+"");
m++;

i++;size++;
}

}
}catch(Exception e){}


Object[][] obj3=new Object[size][4];
for(int p=0;p<size;p++){
for(int q=0;q<4;q++){
obj3[p][q]=obj2[p][q];

}
}
return (obj3);
}
//-------------------------------------------Modify Employee---------------------------------
public void modifyEmployee(String s,JTextField FirstName,JTextField MiddleName,JTextField LastName,JRadioButton Male,JRadioButton Female,JComboBox BirthDay,JComboBox BirthMonth,JComboBox BirthYear,JComboBox Qualification,JTextField RAddress,JComboBox RState,JTextField RArea,JTextField RPin,JTextField RPhone,JTextField Email,JTextField NAddress,JComboBox NState,JTextField NArea,JTextField NPin,JTextField NPhone,JComboBox JoiningDay,JComboBox JoiningMonth,JComboBox JoiningYear,JComboBox Department,JTextField Designation,JTextField PayOfDay,JTextField OverTimePay)
{

try
{

strQuery="select * from employee where emp_id="+s+"";
connect.executeQuery("query",strQuery);
while(connect.rs.next())
{
FirstName.setText(connect.rs.getString(2));
MiddleName.setText(connect.rs.getString(3));
LastName.setText(connect.rs.getString(4));
Qualification.setSelectedItem(connect.rs.getString(7));
RState.setSelectedItem(connect.rs.getString(9));
RArea.setText(connect.rs.getString(10));
RAddress.setText(connect.rs.getString(8));
RPhone.setText(connect.rs.getString(12));
Email.setText(connect.rs.getString(23));
RPin.setText(connect.rs.getString(11));
NState.setSelectedItem(connect.rs.getString(14));
NArea.setText(connect.rs.getString(15));
NAddress.setText(connect.rs.getString(13));
NPhone.setText(connect.rs.getString(17));
NPin.setText(connect.rs.getString(16));
Department.setSelectedItem(connect.rs.getString(18));
Designation.setText(connect.rs.getString(19));
PayOfDay.setText(connect.rs.getString(21));
OverTimePay.setText(connect.rs.getString(22));

Object[] Date_Of_Birth=  show(connect.rs.getString(6));
BirthDay.setSelectedItem(Date_Of_Birth[0]);
BirthMonth.setSelectedItem(Date_Of_Birth[1]);
BirthYear.setSelectedItem(Date_Of_Birth[2]);

Object[] Date_Of_Joining=  show(connect.rs.getString(18));
JoiningDay.setSelectedItem(Date_Of_Birth[0]);
JoiningMonth.setSelectedItem(Date_Of_Birth[1]);
JoiningYear.setSelectedItem(Date_Of_Birth[2]);

String Sex=connect.rs.getString(4);

if(Sex=="Male")
{
Male.setSelected(true);
}
else
{
Female.setSelected(true);
}

}



}
catch(Exception e){}
}
//------------------------------------------Save Modified Employee------------------------
public void saveModifiedEmployee(JFrame modifyEm,String s, JTextField FirstName,JTextField MiddleName,JTextField LastName,JRadioButton Male,JRadioButton Female,JComboBox BirthDay,JComboBox BirthMonth,JComboBox BirthYear,JComboBox Qualification,JTextField RAddress,JComboBox RState,JTextField RArea,JTextField RPin,JTextField RPhone,JTextField Email,JTextField NAddress,JComboBox NState,JTextField NArea,JTextField NPin,JTextField NPhone,JComboBox JoiningDay,JComboBox JoiningMonth,JComboBox JoiningYear,JComboBox Department,JTextField Designation,JTextField PayOfDay,JTextField OverTimePay)
{
  String Sex="Male";
   String pk=s;
  String DOB =(String)BirthDay.getSelectedItem() + "-" + (String)BirthMonth.getSelectedItem() + "-" + (String)BirthYear.getSelectedItem();
 String DOJ =(String)JoiningDay.getSelectedItem() + "-" + (String)JoiningMonth.getSelectedItem() + "-" + (String)JoiningMonth.getSelectedItem();
  
System.out.println(DOB+ "  "+DOJ);
boolean neal= Female.isSelected();
System.out.println(neal);

 if(Female.isSelected())	
     Sex="Female";	 
	 
 if(FirstName.getText().equals("")) message("First Name","empty");
else if(charCheck(FirstName.getText())) message("First Name","char");

else if(MiddleName.getText().equals("")) message("Middle Name","empty");
else if(charCheck(MiddleName.getText())) message("Middle Name","char");

else if(LastName.getText().equals("")) message("Last Name","empty");
else if(charCheck(LastName.getText())) message("Last Name","char");


     
	 
	 else if(RArea.getText().equals("")) message("Residential Area ","empty");
else if(charCheck(RArea.getText())) message("Residential Area","char");

else if(RAddress.getText().equals("")) message("Residential Address","empty");
//else if(charCheck(address.getText())) message("Address","char");

else if(RPhone.getText().equals("")) message("Residential Phone","empty");
else if(numberCheck(RPhone.getText())) message("Residential Phone","number");

else if(Email.getText().equals("")) message("Email","empty");
else if(charCheck(Email.getText())) message("Email","char");

else if(RPin.getText().equals("")) message("Residential Pincode","empty");
else if(numberCheck(RPin.getText())) message("Residential Pincode","number");

else if(NArea.getText().equals("")) message("Residential Area ","empty");
else if(charCheck(NArea.getText())) message("Residential Area","char");

else if(NAddress.getText().equals("")) message("Residential Address","empty");
//else if(charCheck(address.getText())) message("Address","char");

else if(NPhone.getText().equals("")) message("Residential Phone","empty");
else if(numberCheck(NPhone.getText())) message("Residential Phone","number");

else if(NPin.getText().equals("")) message("Residential Pincode","empty");
else if(numberCheck(RPin.getText())) message("Residential Pincode","number");

else if(Designation.getText().equals("")) message("Designation","empty");
else if(charCheck(Designation.getText())) message("Designation","char");

else if(PayOfDay.getText().equals("")) message("PayOfDay","empty");
else if(numberCheck(PayOfDay.getText())) message("PayOfDay","number");

else if(OverTimePay.getText().equals("")) message("OverTimePay","empty");
else if(numberCheck(OverTimePay.getText())) message("OverTimePay","number");







else{


  

try{








strQuery="update Employee set Emp_First_Name='"+FirstName.getText()+"',Emp_Middle_Name='"+MiddleName.getText()+ "',Emp_Last_Name='"+LastName.getText()+"',Emp_Sex='"+Sex+"',Emp_DateOfBirth='"+DOB+"',Emp_Qualification='"+Qualification.getSelectedItem()+"',Emp_RAddress='"+RAddress.getText()+"',Emp_RState='"+RState.getSelectedItem()+"',Emp_RArea='"+RArea.getText()+"',Emp_RPinCode='"+RPin.getText()+"',Emp_RContactNo='"+RPhone.getText()+"',Emp_NAddress='"+NAddress.getText()+"',Emp_NState='"+NState.getSelectedItem()+"',Emp_NArea='"+NArea.getText()+"',Emp_NPinCode="+NPin.getText()+",Emp_NContactNo='"+NPhone.getText()+"',Emp_DateOfJoining='"+DOJ+"',Emp_Department='"+Department.getSelectedItem()+"',Emp_Designation='"+Designation.getText()+"',Emp_PayOfDay="+PayOfDay.getText()+",Emp_OverTimePay="+OverTimePay.getText()+",Emp_Email='"+Email.getText()+"' where emp_id="+s+"";

connect.executeQuery("update",strQuery);


FirstName.setText("");
MiddleName.setText("");
LastName.setText("");
RArea.setText("");	
RAddress.setText("");
RPhone.setText("");
Email.setText("");
RPin.setText("");
NArea.setText("");	
NAddress.setText("");
NPhone.setText("");
NPin.setText("");
Designation.setText("");
PayOfDay.setText("");
OverTimePay.setText(""); 

JOptionPane.showMessageDialog(null,"Data Inserted" ,"Information",JOptionPane.INFORMATION_MESSAGE);
modifyEm.dispose();


}
catch(Exception e){System.out.println(e);}
}
}





//----------------------------------------------------------------------------------------
}