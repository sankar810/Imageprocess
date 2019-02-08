<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spliting Table</title>
</head>
<body>
<!-- //<img src="Images1\hd_nature.jpg"></img> -->
<%-- <h1><center><table >
<tr>

<% 
for(int i=0;i<4;i++)
{ %>
<td><a href="HidemsginImage?image=ImageSplit\\ns<%=i%>.jpg"><img src="ImageSplit\\ns<%=i%>.jpg"></a></td>

<%}%>
</tr>
<tr>
<% 
for(int i=4;i<8;i++)
{ %>
<td><a href="HidemsginImage?image=ImageSplit\\ns<%=i%>.jpg"><img src="ImageSplit\\ns<%=i%>.jpg"></a></td>
<%}%>
</tr>
<tr>
<% 
for(int i=8;i<12;i++)
{ %>
<td><a href="HidemsginImage?image=ImageSplit\\ns<%=i%>.jpg"><img src="ImageSplit\\ns<%=i%>.jpg"></a></td>
<%}%>
</tr>
<tr>
<% 
for(int i=12;i<16;i++)
{ %>
<td><a href="HidemsginImage?image=ImageSplit\\ns<%=i%>.jpg"><img src="ImageSplit\\ns<%=i%>.jpg"></a></td>
<%}%>
</tr>
</table>
</center></h1>

 --%>         <div id="pricing-section" >
        <div class="container" >
            <div class="row main-top-margin text-center">
                <div class="col-md-8 col-md-offset-2 " >
                    <h1>Receiver Spliting Process Done </h1>
                    <h4>
                       
                    </h4>
                </div>
            </div>
            

                    <% 
                        
                        String r1 =request.getParameter("rrow");
                       int r2 =Integer.parseInt(r1);
                       int r7 =Integer.parseInt(r1);
                       System.out.println("r1 ="+r1);
                       
                        String c1 =request.getParameter("rcol");
                       int c2 =Integer.parseInt(c1);
                       int c7 =Integer.parseInt(c1);
                       System.out.println("c1 ="+c1);
                       
                       String imageno =request.getParameter("imageno");
                       
                       System.out.println("imageno ="+imageno);
                       
                       String Filefullpath =request.getParameter("Filefullpath");
                       
                       System.out.println("Filefullpath ="+Filefullpath);
                       
                       
                      
                       %>   
                 <%! 
                 int j;
                 %>   
              
               <center> <table border="1" >
               <%
               int v=0;
              for(int i=0; i<r2 ; i++) 
              { 
            	  System.out.println("i ="+i);
            	  System.out.println("v ="+v);
              %>
              <tr>
              <%
              for( j=v; j<c2; j++ )  
              {
            	  System.out.println("j ="+j);
              %>
              <td><a href="Receivergettingsecretmsg?image=receiver_ImageSplit\\ns<%=j%>.jpg&&imageno=<%=imageno%>&&Filefullpath=<%=Filefullpath%>"><img width="90" height="90" src="receiver_ImageSplit\\ns<%=j%>.jpg"></a></td>
               
               <% 
                 } 
                  %>
               </tr>
               <%
                 v=j;
                 int v1=r7*c7;
                 if(j<=v1)
                 {
                	 c2=c2+c7;
                	 System.out.println("c2 value ="+c2);
                 }
                 } 
               
               %>

            </table>    </center>


</body>
</html>