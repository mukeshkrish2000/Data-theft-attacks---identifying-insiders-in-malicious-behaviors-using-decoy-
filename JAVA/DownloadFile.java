/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import de.flexiprovider.core.FlexiCoreProvider;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Random;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;


public class DownloadFile extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     String host = "smtp.gmail.com";
                String from="securecomputing10@gmail.com";
                String subject = "Key Generation";
        
     private String algo="DES/ECB/PKCS5Padding";
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       // PrintWriter out = response.getWriter();
        try {
            String filSelect = request.getParameter("filSelect");
            String seckey = request.getParameter("seckey");
             String username2 = request.getParameter("username2");
            String originalName = filSelect;
            String primary = null;
            //String seckey="";
            RequestDispatcher rd;
            //int count = 0;
            Object obj;
            int i=0;
            byte[] block = new byte[8];
            String email2="";
            
            HttpSession sn = request.getSession(true);
   //  sn.setAttribute("username",username);
      System.out.println(""+username2+","+filSelect+","+seckey);
      
      String ipaddr="";
  try {
            InetAddress ipAddr = InetAddress.getLocalHost();
            System.out.println(ipAddr.getHostAddress());
            ipaddr = ipAddr.getHostAddress();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
      
      
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/filesecuritydecoy","root","1234");
           
           Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery("select * from userdetails where username='"+username2+"'");
            
            if(rs2.next())
                
            {
                email2=rs2.getString(6);
            }
           
                String query = "select * from uploadlist where filename='" + filSelect +"' && key1='" +seckey+"'"; 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                 System.out.println(originalName);
                File f = new File ("D:\\DupFiles\\"+originalName+"");
                String my=f.getPath();
                System.out.println(my);
                String filename=f.getName();
                System.out.println(filename);
                String type=getMimeType("file:"+my);
                System.out.println("pass 1");

    response.setContentType (type);
    System.out.println("pass 2");
    response.setHeader ("Content-Disposition", "attachment;     filename=\""+filename+"\"");
    System.out.println("pass 3");
    String name = f.getName().substring(f.getName().lastIndexOf("/") + 1,f.getName().length());
    System.out.println("pass 4");
    InputStream in = new FileInputStream(f);
    System.out.println("pass 5");
    ServletOutputStream outs = response.getOutputStream();
    System.out.println("pass 6");
    
  
//SecretKey secKey = (SecretKey) obj;
 //cipher.init(Cipher.DECRYPT_MODE, secKey);

 FileInputStream fis = new FileInputStream(f);
 
 File file=new File("D:\\Downloads\\"+originalName+"");
 
   
         FileOutputStream fos =new FileOutputStream(file);               
         //generating same key
         byte k[] = seckey.getBytes();   
         SecretKeySpec key = new SecretKeySpec(k,algo.split("/")[0]);  
         //creating and initialising cipher and cipher streams
         Cipher decrypt =  Cipher.getInstance(algo);  
         decrypt.init(Cipher.DECRYPT_MODE, key);  
         CipherInputStream cin=new CipherInputStream(fis, decrypt);
         

 
   byte[] buf = new byte[1024];
         int read=0;
         while((read=cin.read(buf))!=-1)  //reading encrypted data
              fos.write(buf,0,read);  //writing decrypted data
         //closing streams
         cin.close();
         fos.flush();
         fos.close();
 

            }
            else
            {
                
                Statement st1 = con.createStatement();
        
                Random generator = new Random();
                int r = generator.nextInt(9999);
            String s12 = "9a3"+r+"d8k";
            sn.setAttribute("secretkey", s12);
            System.out.println(s12);
           // int add=st.executeUpdate("insert into userlogin values('"+secretkey+"')");
                System.out.println("Pass 4");
             // department=rs.getString(3);
                st1=con.createStatement();
                System.out.println("Pass 5");
                int val=st1.executeUpdate("update userdetails set password='"+s12+"' where username='"+username2+"'"); 
                sn.setAttribute("email2",email2);
		String message = "The new password is : "+s12 + "  The ip is : "+ipaddr;
                
                boolean sessionDebug = true;
// Create some properties and get the default Session.
//System.setProperty("smtp.protocols", "SSLv3");
Properties props = System.getProperties();

props.put("mail.smtp.starttls.enable","true");
props.setProperty("mail.transport.protocol","smtp");
props.setProperty("mail.host",host);
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.port", "587");    //port is 587 for TLS  if you use SSL then port is 465
props.put("mail.debug", "true");
props.put("mail.smtp.socketFactory.port", "465");
props.put("mail.smtp.socketFactory.fallback", "false");
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

Session mailSession = Session.getInstance(props, new javax.mail.Authenticator()
{
protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication("UserName", "Password");
}
});
 
// Set debug on the Session
// Passing false will not echo debug info, and passing True will.
 
mailSession.setDebug(sessionDebug);
 
// Instantiate a new MimeMessage and fill it with the
// required information.
 
Message msg = new MimeMessage(mailSession);
msg.setFrom(new InternetAddress(from));
InternetAddress[] address = {new InternetAddress(email2)};
msg.setRecipients(Message.RecipientType.TO, address);
msg.setSubject(subject);
//msg.setSentDate(new Date());
msg.setText(message);


 
// Hand the message to the default transport service
// for delivery.
 
Transport transport = mailSession.getTransport("smtp");
//transport.connect(host, "testmailselva", "sqmaizyufkvsxxoi");
transport.connect(host, "mukeshkanna1414", "nweluqntvxnadwjg");
transport.sendMessage(msg, msg.getAllRecipients());
                
	/*			
		 String username3 = "selvaprop";

// Replace with your API KEY (We have sent API KEY on activation email, also available on panel)
String apikey = "0JbzRz17y79RI7SIc8Bi";

// Replace with the destination mobile Number to which you want to send sms
String mobile = email2;

// Replace if you have your own Sender ID, else donot change
String senderid = "MYTEXT";

// Replace with your Message content
String message = "The new password is : "+s12 + "  The ip is : "+ipaddr;;

// For Plain Text, use "txt" ; for Unicode symbols or regional Languages like hindi/tamil/kannada use "uni"
String type="txt";

//Prepare Url
URLConnection myURLConnection=null;
URL myURL=null;
BufferedReader reader=null;

//encoding message 
String encoded_message=URLEncoder.encode(message);

//Send SMS API
String mainUrl="http://smshorizon.co.in/api/sendsms.php?";

//Prepare parameter string 
StringBuilder sbPostData= new StringBuilder(mainUrl);
sbPostData.append("user="+username3); 
sbPostData.append("&apikey="+apikey);
sbPostData.append("&message="+encoded_message);
sbPostData.append("&mobile="+mobile);
sbPostData.append("&senderid="+senderid);
sbPostData.append("&type="+type);

//final string
mainUrl = sbPostData.toString();
try
{
    //prepare connection
    myURL = new URL(mainUrl);
    myURLConnection = myURL.openConnection();
    myURLConnection.connect();
    reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
    //reading response 
    String response1;
    while ((response1 = reader.readLine()) != null) 
    //print response 
    System.out.println(response1);
    
    //finally close connection
    reader.close();
} 
catch (IOException e) 
{ 
	e.printStackTrace();
} 		
	*/			
				
                 rd = request.getRequestDispatcher("mail2.jsp");
                rd.forward(request, response);
               
                //count = Integer.parseInt(rs.getString(5));
                //String oriName[] = originalName.split("____");
                // oriName[1].split("\\.");
               // String original = oriName[0] + "." + oriName[1].split("\\.")[1];
               
 

    /*    int bit = 256;
        int i = 0;
            try {
                    while ((bit) >= 0) {
                        bit = in.read();
                        outs.write(bit);
                    }
                        } catch (IOException ioe) {
                        ioe.printStackTrace(System.out);
                    }
                        outs.flush();
                    outs.close();
                    in.close(); */
            }
           

        }  
        catch (Exception ex) {
            System.out.print(ex);
        }
        finally {
           // out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public static String getMimeType(String fileUrl)throws java.io.IOException, MalformedURLException 
  {
    String type = null;
    URL u = new URL(fileUrl);
    URLConnection uc = null;
    uc = u.openConnection();
    type = uc.getContentType();
    return type;
  }
}
