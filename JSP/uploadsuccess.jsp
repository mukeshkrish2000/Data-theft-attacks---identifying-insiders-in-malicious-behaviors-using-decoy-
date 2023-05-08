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
.style6 {
	color: #006600;
	font-size: large;
}
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
       <form id="form2" name="form2" method="post" enctype="multipart/form-data" action="Fileupload">
        <table width="384" height="256" border="0">
          <tbody>
            <tr>
              <td height="52" colspan="2" bgcolor="#666666"><div align="center"><span class="style5">Upload the data </span></div></td>
            </tr>
            
            <tr>
              <td height="70"><h3 class="style4">User Name</h3></td>
              <td><label>
                <input type="text" name="on" value="<%=session.getAttribute("username")%>" size="20"/>
              </label></td>
            </tr>
            <tr>
              <td height="70"><h3 class="style4">File Upload</h3></td>
              <td><label>
                <input name="fu" type="file" value="" size="30" width="30" />
                </label>              </td>
            </tr>
            <tr>
              <td colspan="2"><div align="center">
                  <label>
                  <input type="submit" name="Submit" value="Upload data" />
                  </label>
              </div></td>
            </tr>
          </tbody>
        </table>
        <p class="style6">File uploaded successfully.... </p>
        <div align="right" class="style1">
          <p><a href="userpage.jsp">Back</a></p>
          <p><a href="index.jsp">Logout</a></p>
        </div>
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
