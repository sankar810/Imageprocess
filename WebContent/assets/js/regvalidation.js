
function validateform() {
	var name=document.myform.name.value;	
	var email=document.myform.email.value;
	var atposition=email.indexOf("@");
	var dotposition=email.lastIndexOf(".");
	var usrnam=document.myform.username.value;
	var password=document.myform.password.value;
	var repassword=document.myform.repassword.value;
	var phone=document.myform.phone.value;   
	var address=document.myform.address.value;
	if(name==null || name==""){
		alert("Name Can't be Blank");
		return false;
	}
	
	else if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length){  
		  alert("Please enter a valid e-mail address");  
		  return false;  
		  }  	
	else if(usrnam==null || usrnam==""){
		alert("Username Can't be blank");
		return false;
	}
	
	else if(password==null || password==""){
		alert("Password can't be blank");
		return false;
	}
	else if (password.length<6) {
		alert("Password must be at least 6 characters long");  
		return false;
	}
	else if(repassword==null || repassword==""){
		alert("Confirm password can't be blank");
		return false;
	}
	else if(phone==null || phone==""){
		 alert("Mobile number can't be blank");
		 return false;
	 }
	
	else if(phone.length<10 ){
		 alert("Mobile number not less than 10 digits");
		 return false;
	 }

	else if(phone.length>10){
		 alert("Mobile number not greater than 10 digits");
		 return false;
	 }
	else if(address==null || address==""){
		 alert("Address can't be blank");
		 return false;
	 }
	
	
} 
