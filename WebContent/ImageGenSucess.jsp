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
   <title>IMAGE PROCESSING</title>
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
     
    <!--ABOUT SECTION -->
    <div id="found-section" >
        <div class="container" >
            <div class="row main-top-margin text-center">
                <div class="col-md-8 col-md-offset-2 " >
                    <h1>COMPOSITE IMAGE  GENERATION </h1>
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
          
          <%String path=request.getParameter("path"); 
            System.out.println("path ="+path);
          %>
          
          
          <h1><center> Image Generation Sucessfully</center></h1>
          <h2><center><a href="Imagesplit?path=<%=path%>">split</a></center></h2>
          
          
</body>
</html>
          
  
</body>
</html>
