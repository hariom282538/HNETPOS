
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Mail{
public void postMail( String recipients[], String subject, String message , String from) throws MessagingException, AddressException
{
    boolean debug = false;

     //Set the host smtp address
     Properties props = new Properties();
     props.put("mail.smtp.host", "chrd.in2cable.net");

    // create some properties and get the default Session
    Session session = Session.getDefaultInstance(props, null);
    session.setDebug(debug);

    // create a message
    Message msg = new MimeMessage(session);
try
{
    // set the from and to address
    InternetAddress addressFrom = new InternetAddress(from);
    msg.setFrom(addressFrom);

    InternetAddress[] addressTo = new InternetAddress[recipients.length]; 
    for (int i = 0; i < recipients.length; i++)
    {
        addressTo[i] = new InternetAddress(recipients[i]);
    }
    msg.setRecipients(Message.RecipientType.TO, addressTo);
   

    // Optional : You can also set your custom headers in the Email if you Want
    msg.addHeader("MyHeaderName", "myHeaderValue");

    // Setting the Subject and Content Type
    msg.setSubject(subject);
    msg.setContent(message, "text/plain");
    Transport.send(msg);
}
catch(Exception e)
{
    System.out.println("Exception occured");
}
}


public static void main(String[] args){
Mail m=new Mail();
String[] s=new String[1];
s[0]="nigelcog@gmail.com";
try{
m.postMail(s,"Hello", "null" , "nigelcog@yahoo.com");
}
catch (Exception e){System.out.print("error");}
}

}