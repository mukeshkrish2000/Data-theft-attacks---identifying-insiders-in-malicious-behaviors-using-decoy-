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
.style1 {
	font-size: large;
	color: #FF0000;
}
.style3 {font-size: x-large}
.style4 {
	color: #FF0000;
	font-size: x-large;
}
-->
</style>
</head>
<body>
 <%@ page import="java.util.*" %>
  <%@ page import="javax.mail.*" %>
  <%@ page import="javax.mail.internet.*" %>
  <%@ page import="javax.activation.*" %>
  <%@ page import="javax.net.ssl.*" %>
  <%@ page import="java.net.InetAddress" %>
  <%@ page import="java.net.UnknownHostException" %>

  
  <%
  String ipaddr="";
  try {
            InetAddress ipAddr = InetAddress.getLocalHost();
            System.out.println(ipAddr.getHostAddress());
            ipaddr = ipAddr.getHostAddress();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
String host = "smtp.gmail.com";
String to = session.getAttribute("email2").toString();
String from="securecomputing10@gmail.com";  // write your email address means from email address.
//String from="YourEmailAddress";
String subject = "Secret Key from Admin";
//username=sn.getAttribute("eid").toString();
String messageText = "The new password is : "+session.getAttribute("secretkey").toString() + "  The ip is : "+ipaddr;
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

Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication("UserName", "Password");
}
});
 
// Set debug on the Session
// Passing false will not echo debug info, and passing True will.
 
mailSession.setDebug(sessionDebug);
 
// Instantiate a new MimeMessage and fill it with the
// required information.
 
Message msg = new MimeMessage(mailSession);
msg.setFrom(new InternetAddress(from));
InternetAddress[] address = {new InternetAddress(to)};
msg.setRecipients(Message.RecipientType.TO, address);
msg.setSubject(subject);
msg.setSentDate(new Date());
msg.setText(messageText);
 
// Hand the message to the default transport service
// for delivery.
 
 Transport transport = mailSession.getTransport("smtp");
transport.connect(host, "testmailselva", "5#SelvaJava");
transport.sendMessage(msg, msg.getAllRecipients());
//transport.send(msg);
//out.println("Mail was sent to "+to);
//out.println(" from "+from);
//out.println(" using host "+host+".");  -->



%>

<header>
  <div class="wrap"> <a id="logo" href="#"><span>FileSecurity</span>Decoy</a>
    <hr>
    <nav>
      <ul>
        <li class="active"> <a href="index.jsp">Home</a> </li>
        <li> <a href="userregister.jsp">Registration</a> </li>
        <li> <a href="userlogin.jsp">Login</a> </li>
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
        <p class="style4">&nbsp;</p>
        <p class="style4"><a href ="index.jsp" class="style1">Downloading Process Failed... Please Try Again </a></p>
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
