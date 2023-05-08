/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import de.flexiprovider.core.FlexiCoreProvider;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.DateFormat;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class Fileupload extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "web\\Files";
    private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    SecretKey secKey;
    private String algo="DES/ECB/PKCS5Padding";
    String kvalue="";
  String email="";
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        RequestDispatcher rd;
        PreparedStatement ps;
        String fileName = null;
        String a=null,b=null;
        String a1,b1;
        int nonce2=0;
        String s1="";
        String dbFile1="";
    String dbFile2="";
    String dbFile3="";
    String dbFile4="";
    String dbFile5="";
    
     String host = "smtp.gmail.com";
                String from="securecomputing10@gmail.com";
                String subject = "Key Generation";
        
        HashMap hm = new HashMap(); 
        
       

        // configures some settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(REQUEST_SIZE);
        HttpSession session = request.getSession(true);
        String userName = (String) session.getAttribute("username");
        email = (String) session.getAttribute("email");
        String filepath1 = getServletContext().getRealPath("fu"); 
        System.out.println("The real path is:"+filepath1);
        System.out.println("The name is:"+userName);

       File file2 = new File("D:\\UploadedFiles\\");
       File file3 = new File("D:\\UploadedFiles\\");
       File file4 = new File("D:\\UploadedFiles\\");
       File file5 = new File("D:\\UploadedFiles\\");
       File file6 = new File("D:\\UploadedFiles\\");

        // constructs the directory path to store upload file
        // String uploadPath = getServletContext().getRealPath("web\\Files");
        // creates the directory if it does not exist
       
        File uploadDir = new File("D:\\temp\\");
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            try {

                List formItems = upload.parseRequest(request);
                Iterator iter = formItems.iterator();


                // iterates over form's fields
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        fileName = new File(item.getName()).getName();
                        String filePath = uploadDir + File.separator + fileName;
                        String[] arr = filePath.split("\\.");
                        long sysTime = System.currentTimeMillis();
                        
                        filePath = arr[0] +"."+arr[1];
                        String time=String.valueOf(sysTime);
                        kvalue=time.substring(0, 8);
                        System.out.println("The file path is:"+filePath+" "+kvalue);
                     String s2 =  fileName + userName + sysTime +"."+arr[1];
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                         Random generator1 = new Random();
           nonce2 = generator1.nextInt(1000000);
                        Security.addProvider(new FlexiCoreProvider());

	Cipher cipher = Cipher.getInstance("AES128_CBC", "FlexiCore");
	KeyGenerator keyGen = KeyGenerator.getInstance("AES", "FlexiCore");
	secKey = keyGen.generateKey();
        System.out.println("secret key is"+secKey);
        //String secKey1 = secKey;

        
         // saves the file on disk
                        
                        String dbFileName[] = fileName.split("\\.");
                        String dbFile = dbFileName[0]+"."+arr[1];
                        
                        dbFile1 = dbFileName[0] +"s" +"."+arr[1];
                        dbFile2 = dbFileName[0]  +"b" +"."+arr[1];
                        dbFile3 = dbFileName[0] +"11" +"."+arr[1];
                        dbFile4 = dbFileName[0] +"a" +"."+arr[1];
                        dbFile5 = dbFileName[0] +"1" +"."+arr[1];

                        hm.put("filename",dbFile); 

                      
                     //  cipher.init(Cipher.ENCRYPT_MODE, secKey);

	
        File file=new File("D:\\DupFiles\\"+dbFile);
        file2 = new File("D:\\DupFiles\\"+dbFile1);
        file3 = new File("D:\\DupFiles\\"+dbFile2);
        file4 = new File("D:\\DupFiles\\"+dbFile3);
        file5 = new File("D:\\DupFiles\\"+dbFile4);
        file6 = new File("D:\\DupFiles\\"+dbFile5);
        
	FileInputStream fis = new FileInputStream(storeFile);
	// file=new File(file.getAbsolutePath()+".enc");
         FileOutputStream fos =new FileOutputStream(file);
         //generating key
         byte k[] = kvalue.getBytes();   
         SecretKeySpec key = new SecretKeySpec(k,algo.split("/")[0]);  
          System.out.println("secret key is"+key);
           
         //creating and initialising cipher and cipher streams
         Cipher encrypt =  Cipher.getInstance(algo);  
         encrypt.init(Cipher.ENCRYPT_MODE, key);  
         CipherOutputStream cos=new CipherOutputStream(fos, encrypt);

	byte[] block = new byte[8];
	int i;
	while ((i = fis.read(block)) != -1) {
	    cos.write(block, 0, i);
	}
	cos.close();

                        
                       
                        
                    } else {
                         a = item.getFieldName();
                         //a1.item.getFieldName();
                         b = item.getString();
                        System.out.println(a + " - " + b);
                        
                         //hm.put("ownername", b);
                         if(a != null && a.equalsIgnoreCase("on2")){
                            hm.put("groupname", b); 
                        }
                         else if(a != null && a.equalsIgnoreCase("on")){
                            hm.put("ownername", b); 
                        }else if(a != null && a.equalsIgnoreCase("fname")){
                            hm.put("foldername", b); 
                        }
                         else if(a != null && a.equalsIgnoreCase("fu")){
                            hm.put("asdf", b); 
                        }
                         
                    }
                }
                String sm =""+hm.get("foldername");
                byte k1[] = sm.getBytes();   
         SecretKeySpec key1 = new SecretKeySpec(k1,algo.split("/")[0]);
          String test = "ABCD";
     for ( int i = 0; i < sm.length(); ++i ) {
       char c = sm.charAt( i );
       int j = (int) c;
       s1 = s1 + j;
       }
     
     try {
 
	      
 
	      if (file2.createNewFile()){
	        System.out.println("File is created!");
	      }else{
	        System.out.println("File already exists.");
	      }
              if (file3.createNewFile()){
	        System.out.println("File is created!");
	      }else{
	        System.out.println("File already exists.");
	      }
              if (file4.createNewFile()){
	        System.out.println("File is created!");
	      }else{
	        System.out.println("File already exists.");
	      }
              if (file5.createNewFile()){
	        System.out.println("File is created!");
	      }else{
	        System.out.println("File already exists.");
	      }
              if (file6.createNewFile()){
	        System.out.println("File is created!");
	      }else{
	        System.out.println("File already exists.");
	      }
    	} catch (IOException e) {
	      e.printStackTrace();
	}

                    try {
                        
                        Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/filesecuritydecoy","root","1234");
             ResultSet rs =null; 
             
             Statement st = con.createStatement();
            System.out.println("Mail id : "+email);
             String messageText = "The Key for file "+hm.get("filename")+ "  is :" + kvalue;
             
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
InternetAddress[] address = {new InternetAddress(email)};
msg.setRecipients(Message.RecipientType.TO, address);
msg.setSubject(subject);
//msg.setSentDate(new Date());
msg.setText(messageText);


 
// Hand the message to the default transport service
// for delivery.
 
Transport transport = mailSession.getTransport("smtp");
//transport.connect(host, "testmailselva", "sqmaizyufkvsxxoi");
transport.connect(host, "mukeshkanna1414", "nweluqntvxnadwjg");

transport.sendMessage(msg, msg.getAllRecipients());


            st = con.createStatement();
            int add=st.executeUpdate("insert into storage values('" + dbFile1 + "','"+userName+"')");
              
             st = con.createStatement();
            int add5=st.executeUpdate("insert into storage values('" + hm.get("filename") + "','"+userName+"')");
            
            
                    st = con.createStatement();
            int add1=st.executeUpdate("insert into storage values('" + dbFile2 + "','"+userName+"')");
              st = con.createStatement();
            int add2=st.executeUpdate("insert into storage values('" + dbFile3 + "','"+userName+"')");
              st = con.createStatement();
            int add3=st.executeUpdate("insert into storage values('" + dbFile4 + "','"+userName+"')");
              st = con.createStatement();
            int add4=st.executeUpdate("insert into storage values('" + dbFile5 + "','"+userName+"')");
           
            
            
            String sql = "insert into uploadlist(ownername,filename,key1) values('" + userName + "','" + hm.get("filename") + "','" + kvalue + "')";
                        ps = con.prepareStatement(sql);
                        int noOfRows = ps.executeUpdate();

                        } catch (Exception ex) {
                            System.out.println(ex);
                        } finally {
                            //out.close();
                        }
             
                System.out.println(fileName);
                request.setAttribute("message", "Upload has been done successfully!");
rd = request.getRequestDispatcher("uploadsuccess.jsp");
                            rd.forward(request, response);


            } catch (Exception ex) {
                System.out.println(ex);
            } finally {
                out.close();
            }

        } catch (Exception ex) {
            request.setAttribute("message", "There was an error: " + ex.getMessage());
        }
        //getServletContext().getRequestDispatcher("/uploadsuccess.jsp").forward(request, response);
        /* finally {            
        out.close();
        } */
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
}
