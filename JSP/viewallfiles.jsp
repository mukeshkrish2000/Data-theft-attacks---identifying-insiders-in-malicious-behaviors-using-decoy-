<%@page import="java.io.*, java.sql.*"%>
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
.style6 {color: #006600}
-->
</style>
</head>
<body>
<header>
  <div class="wrap"> <a id="logo" href="#"><span>FileSecurity</span>Decoy</a>
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
    <h1>Hacking is not Random</h1>
    <p>securing the data using  decoy (duplicate) information technology, that we have come to call fog  computing. Decoy Algorithm is used to  add duplicates for every file uploads of user, and gives secure to the file. We use this technology to  launch disinformation attacks against malicious insiders, preventing them from  distinguishing the real sensitive customer data from fake worthless data.</p>
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
      <form name="form1" method="post" action="Login">
        <div align="right" class="style1">
          <table>
            <tr>
                <td width="1090"></th>
        
                            </td>
            </tr>
            <tr>
              <td align="left" valign="top"><span class="style6">File Name </span></td>
            </tr>
			 <%
				  String uuname =session.getAttribute("username").toString();
				  String path1 = "D:/DupFiles/";
File f = new File(path1);
        File[] files = f.listFiles();
        for(int i=0;i<files.length;i++){
            String name=files[i].getName();
            String path=files[i].getPath();
%>     
            <tr>
              <td align="left" valign="top"><p><%=name%>
                <label></label>
              </p></td>
            </tr>
            <%
        }
%>
          </table>
        <a href="index.jsp">Logout</a></div>
      </form>
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
