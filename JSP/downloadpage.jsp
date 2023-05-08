<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<title>File Security Decoy</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/main.css" media="all">
<script src="js/jquery-1.6.4.min.js"></script>
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<script src="js/IE9.js"></script>
<![endif]-->
<style type="text/css">
<!--
.style1 {font-size: large}
.style3 {font-size: x-large}
.style4 {font-size: 18px}
.style5 {color: #E1EAF1;
	font-size: 24px;
}
-->
</style>
</head>
<body>
<header>
  <div class="wrap"> <a id="logo" href="#"><span>FileSecurity</span>DECOY</a>
    <hr>
    <nav>
      <ul>
        <li class="active"> <a href="index.jsp">Home</a> </li>
       
        <li> <a href="userlogin.jsp">Logout</a> </li>
        
      </ul>
    </nav>
  </div>
</header>
<hr>
<div id="intro">
  <div class="wrap clearFix">
    <h1>Your Files Are SAFE-HERE</h1>
    <p>securing Files using a technique known as Fog Computing.In addition to Fog Computing,it  involves implementing a Decoy Algorithm This algorithm adds duplicate files for every file uploaded by a user. These duplicate files are essentially decoys that are used to mislead potential attackers who may be trying to access sensitive customer data.By launching disinformation attacks against malicious insiders, it aims to prevent them from distinguishing the real sensitive customer data from fake worthless data..</p>
  </div>
</div>
<!-- / #intro -->
<hr>
<div id="subIntro"></div>
<hr>
<div id="content" class="wrap">
  <div class="box clearFix">
    <p align="center" class="col2-3 style3">User Page </p>
    <div align="center">
        
                     <table width="614" height="250" border="0" >
									 
                            <tr>
                              <td height="67" colspan="6" bgcolor="#666666"><div align="center"><span class="style5">Download the data</span></div></td>
                            </tr>
                            <tr>
                              <td width="84"><div align="center" class="style14"><span class="style1">Choose Option </span></div></td>
                              <td width="60"><div align="center" class="style14"><span class="style1">File id</span></div></td>
                              <td width="183"><div align="center" class="style14"><span class="style1">File Name</span></div></td>
							  
							  <td width="154"><div align="center" class="style14"><span class="style1">Security key</span></div></td>
                              <td width="111">&nbsp;</td>
                            </tr>
                                    <%
                                        try {
                                            //String username = "username";
											String uname1=session.getAttribute("username").toString();
							String username, user;
        PreparedStatement ps;
        ResultSet rs;
		//Connection con = null;
		Statement st,st1,st2,st3,st4;
                                            
                                            Class.forName("com.mysql.jdbc.Driver");
                                      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/filesecuritydecoy","root","1234");
                                            String query = "select * from storage where username='"+uname1+"'"; 
                                            st = con.createStatement();
                                            rs = st.executeQuery(query);

                                            while (rs.next()) {
                                                String id = rs.getString(1);
                                                //String ownerName = rs.getString(2);
                                                String fileName = rs.getString(2);
											//	 String skey = rs.getString(4);
												 
                                           
                                    %>


                                  
                            <tr>
		    <form id="form1" name="form1" action="DownloadFile">
                                <td> <div align="center"><input type="radio" name="filSelect" value="<%=id%>" /> </div></td>
                                <td> <div align="center"><%=id%></div></td>
                                <td> <div align="center"><%=fileName%></div></td>
								
								<td> <div align="center">
								  <input name="seckey" type="text" id="seckey" value="" size="12" />
								</div></td>
              <td><input type="submit" name="Submit" value="Download" />
                                <input name="username2" type="text" id="username2"  style="visibility:hidden" value="<%=session.getAttribute("username")%>" size="2"/></td>
			</form>
           </tr>
                            <tr>
                              <td colspan="3"><div align="center"></div></td>
                            </tr>
                           
                       
                                    <p>
                                      <%

                                            }
                                            con.close();
                                        } catch (Exception e) {
                                            out.println(e);
                                        }

                                    %>
                                        </table>
         <div align="right" class="style1">
          <p><a href="userpage.jsp">Back</a></p>
          <p><a href="index.jsp">Logout</a></p>
        </div>
      
    </div>
  </div>
  <hr>
  <div class="clearFix"></div>
</div>
<!-- / #content -->
<hr>
<footer>
  <div align="center">All rights reserved - File Security </div>
</footer>
<div align=center></div>
</body>
</html>
