/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author java.2
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

Connection con=null;
    Statement st=null,st1=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
 
            
            HttpSession sn = req.getSession(true);
     
	   String fullname= req.getParameter("name");
            String username= req.getParameter("username");
          String password= req.getParameter("password");
        	String prof= req.getParameter("prof");
		String mobile= req.getParameter("mobile");
		String emailid= req.getParameter("email");
              
        	RequestDispatcher rd;
         Random generator1 = new Random();
            int seckey = generator1.nextInt(1000000);
            
	try {
		
		
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/filesecuritydecoy","root","1234");
           
            st1 = con.createStatement();
          int add=st1.executeUpdate("insert into userdetails values('"+fullname+"','"+username+"','"+password+"','"+prof+"','"+mobile+"','"+emailid+"')");
        rd=req.getRequestDispatcher("regsuccess.jsp");
            rd.forward(req,res);
           
        } catch(Exception e2)
         {
            System.out.println("Exception : "+e2.toString());
        }
    }
}