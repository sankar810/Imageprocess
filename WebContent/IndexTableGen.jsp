<!DOCTYPE html>
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
   <title>Index Table Generation</title>
    <!--GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <!--BOOTSTRAP MAIN STYLES -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!--FONTAWESOME MAIN STYLE -->
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
    
    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
    
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
                    <li><a href="InboxEncrypt.jsp">INBOX</a></li>
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
                    <h1>INDEX TABLE GENERATION </h1>
                    <h4>
                      
                    </h4>
                </div>
            </div>
            <!-- ./ Main Heading-->
             <div class="row main-low-margin  text-center">
                
             
                <div class="col-md-12 col-sm-12 text-justify" >
                    <h3> TABLE DESIGN</h3>
                   
                        
                         <div  class="form">
    		<form id="contactform" action="IndexTableGen" method="post"> 
    		
    		    <p class="contact"><label for="username">Enter Your Number of Rows</label></p> 
    			<input id="username" name="row" placeholder="No Of Rows" required="" tabindex="3" type="text"> 
                
    			<p class="contact"><label for="password">Enter Your Number of Colomns</label></p> 
    			<input type="text" name="colomn" placeholder="No Of Colomns" required="" tabindex="1" type="text"> 
    			 
    		    <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit !" type="submit"> 	 
     
            
   </form> 
</div>      
                   
                      
              
              <!-- ./ Row Content-->
            
        </div>
    </div>
    <!-- END ABOUT SECTION -->
   
   
 
    <!--FOOTER SECTION -->
    <!-- <div id="footer">
        <div class="container">
            <div class="row ">
                &copy; 2014 www.yourdomain.com | All Right Reserved 				
		
            </div>
            
        </div>
       
    </div>   -->
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
