function validateform()
{  
	
 var name=document.myform.username.value;  
 var password=document.myform.passwd.value;  
 var confirm=document.myform.confirm.value;  
 var x=document.myform.emailid.value;  
 var atposition=x.indexOf("@");  
 var dotposition=x.lastIndexOf("."); 
 var dob=document.myform.dob.value;
 var phoneno=document.myform.phoneno.value;
  
   if (name==null || name=="")
   {  
   alert("Name can't be blank");  
   return false;  
   }

   if(password.length<6)
   {  
   alert("Password must be at least 6 characters ");  
   return false;  
   }  
  
   if(password!=confirm)
     {  
	   alert("Password Must Be Same!");  
	   return false;  
     }  
     
    if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length)
     {  
       alert("Please Enter a Valid E-mail Address ");  
       return false;  
      
     }  

    if (dob==null || dob=="")
    {  
    alert("Date of Birth can't be blank");  
    return false;  
    }
     
    if (phoneno==null || phoneno=="")
    {  
    alert("Phone No can't be blank");  
    return false;  
    }
     
     
     
     }  



