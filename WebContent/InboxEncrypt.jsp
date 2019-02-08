<!DOCTYPE html>

<%@ page import="com.Dbcon.*" %>
<%@ page import="java.sql.*" %>

<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<!-- HEAD SECTION -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
   <title>Inbox Encrypt Page</title>
    <!--GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <!--BOOTSTRAP MAIN STYLES -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!--FONTAWESOME MAIN STYLE -->
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
    <!--CUSTOM STYLE -->
    <link href="assets/css/style.css" rel="stylesheet" />
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
    <!--END HEAD SECTION -->
    
    <SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<body onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">
<body>
<body>   
       <!-- NAV SECTION -->
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <%String Username =(String)session.getAttribute("Uname");
                  System.out.println("Username is "+Username);
                  
                %>
                <a class="navbar-brand" href="#">Welcome <%=Username %></a>
            </div>
           <div class="navbar-collapse collapse" >
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="HomePage.jsp" span="color:red">HOME</a></li>
                     <li><a href="IndexTableGen.jsp">TABLE GENERATION</a></li>
                     <li><a href="ImageGen.jsp">IMAGE GENERATION</a></li>
                       <li><a href="Logout.jsp">LOG-OUT</a></li>
                </ul>
            </div>
           
        </div>
    </div>
     <!--END NAV SECTION -->
     
     
     
     
     
     
     
     
    <!--ABOUT SECTION -->
    <div id="found-section" >
        <div class="container" >
            <div class="row main-top-margin text-center">
                <div class="col-md-8 col-md-offset-2 " >
               <center> <table>
                   <tr><td><img alt="" src="gif image/inboxiconanimation_30.gif" width="75" height="75">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                   <td>  <h1>Inbox </h1></td>
                   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <img alt="" src="gif image/inboxiconanimation_30.gif" width="75" height="75"></td>
                   </tr>
                   
                 </table>  </center>
                   
                   
                    <h4>
                      
                    </h4>
                </div>
            </div>
            <!-- ./ Main Heading-->
            </div>
            </div>
          <br>
          <br>
          <br>
          
        
          
          <%  String path=request.getParameter("path"); 
              System.out.println("path ="+path);
          %>
          
          <% Connection con=Dbcon.dbcon(); 
     
     PreparedStatement ps = con.prepareStatement("SELECT * FROM imageprocess.secretmessage where receiver='"+Username+"'");
     
     ResultSet rs =ps.executeQuery();
     
     while(rs.next())
     
     {   String sender =rs.getString(1);
         String Filefullpath=rs.getString(2);
         String Secret_Key1 =rs.getString(9);
         String Secret_Key2 =rs.getString(10);
         String Secret_Key3 =rs.getString(11);
    	 String mergeimagepath =rs.getString(7);
    	
    	 System.out.println("sender ="+sender);
    	 System.out.println("Filefullpath ="+Filefullpath);
    	 System.out.println("Secret_Key1 ="+Secret_Key1);
    	 System.out.println("Secret_Key2 ="+Secret_Key2);
    	 System.out.println("Secret_Key3 ="+Secret_Key3);
    	 System.out.println("mergeimagepath ="+mergeimagepath);
     %>
     
           
     
     
      <center><table>
      
      
      
      <th>To:&nbsp;<%=sender %></th>
            <th>SecretKey1</th>
            <th>SecretKey2</th>
            <th>SecretKey3</th>
      
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
            
        <tr>   <td width="300"><img width="200" height="200" alt="" src="<%=mergeimagepath%>"></td>
          <td width="150"><%=Secret_Key1 %>&nbsp;&nbsp;&nbsp;&nbsp;</td>
          <td width="150"><%=Secret_Key2 %>&nbsp;&nbsp;&nbsp;&nbsp;</td>
          <td width="150"><%=Secret_Key3 %>&nbsp;&nbsp;&nbsp;&nbsp;</td>
             <td width="100"><h3><button><a href="DecryptPage.jsp">Decrypt</a></button></h3></td></tr>
          
          
          <br>
          
      <% } %>     
      </table>
          
      
      </center>
      
      
</body>
</html>
          
  
