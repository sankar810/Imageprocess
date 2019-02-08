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
   <title>Free Template- Bootstrap Multi Pager by Binary Theme</title>
    <!--GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <!--BOOTSTRAP MAIN STYLES -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!--FONTAWESOME MAIN STYLE -->
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
    <!--CUSTOM STYLE -->
    <link href="assets/css/style.css" rel="stylesheet" />
    
     <link rel="stylesheet" type="text/css" href="style.css" media="all" />
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
    <!--END HEAD SECTION -->
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
                    <li><a href="Inbox.jsp">INBOX</a></li>
                    <li><a href="IndexTableGen.jsp">TABLE GENERATION</a></li>
                     <li><a href="ImageGen.jsp">IMAGE GENERATION</a></li>
                       <li><a href="Logout.jsp">LOG-OUT</a></li>
                </ul>
            </div>
           
        </div>
    </div>
     <!--END NAV SECTION -->
     
    <!--PRICING SECTION -->
    <div id="pricing-section" >
        <div class="container" >
            <div class="row main-top-margin text-center">
                <div class="col-md-8 col-md-offset-2 " >
                    <h1> IMAGE MERGING SUCESS </h1>
                    <h4>
                       
                    </h4>
                </div>
            </div>
            <!-- ./ Main Heading-->
             
             <br><br>
           
             <% String mergeimagepath= request.getParameter("mergeimagepath");
                
                String sender= request.getParameter("sender");
                
                String secret_key1= request.getParameter("secret_key1");
                
                String secret_key2= request.getParameter("secret_key2");
                
                String secret_key3= request.getParameter("secret_key3");
                
                String Imagepath= request.getParameter("Imagepath");
                
                String FileFullpath= request.getParameter("FileFullpath");
                
                
                
                System.out.println("ImageMergesucess.jsp");
                
                System.out.println("  mergeimagepath ="+mergeimagepath);
               
                System.out.println(" sender="+sender);
                
                System.out.println("secret_key1 ="+secret_key1);
        		
                System.out.println("secret_key2 ="+secret_key2);
        		
                System.out.println("secret_key3 ="+secret_key3);
                
                System.out.println(" Imagepath="+Imagepath);
                
                System.out.println(" FileFullpath ="+FileFullpath);
                
              
                
                
               
             %>
            
             <h1>Your Spliting Image is Sucessfully Merged </h1>
             <br>
             <br>
             
             
            <% Connection con =Dbcon.dbcon(); 
             
             PreparedStatement ps =con.prepareStatement("SELECT * FROM imageprocess.senderregister where Name!='"+sender+"'");
             
             ResultSet rs= ps.executeQuery();
             
           
            
            %>
            
            <form action="Sendingsecretimage?mergeimagepath=<%=mergeimagepath %>&&secret_key1=<%=secret_key1%>&&secret_key2=<%=secret_key2%>&&secret_key3=<%=secret_key3%>&&Imagepath=<%=Imagepath %>&&FileFullpath=<%=FileFullpath %>&&sender=<%=sender %>" method="post">
             
            <table>
            
         <tr> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              
              <img width="250" height="250" src="<%=mergeimagepath%>"></td>
              
              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
              
              <select name="receiver">
              
              <option value="Available Users">Available Users</option>
          
              <%while(rs.next()){ %>
          
              <option value="<%=rs.getString(3)%>"><%=rs.getString(3)%></option>
             
              <% } %>
             </select></td>
           
          <td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input style="border:4px solid blue;" type="submit" value="Send"></td> </tr>
          </form>
            
            </table>
             
    <!--FOOTER SECTION -->
    
    <!--END FOOTER SECTION --> 
    <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY LIBRARY -->
    <script src="assets/js/jquery.js"></script>
    <!-- CORE BOOTSTRAP LIBRARY -->
    <script src="assets/js/bootstrap.min.js"></script>
       <!-- CUSTOM SCRIPT-->
    <script src="assets/js/custom.js"></script>
</body>
</html>
