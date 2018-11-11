<%@ page import = "java.util.*,java.io.*,com.proj1.login.User" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<style>
#main {
	padding: 20px;
    align: center;
    border: 1px solid black; 
    
}
#first {
	padding: 5px;
    border: 1px solid black; 
    width: 500px;
    height: 500px;
}
</style>
<script type="text/javascript">
function showUsers(){
	//alert('sasa');
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("demo").innerHTML = this.responseText;
	    }
	  };
	xhttp.open("GET","http://localhost:8080/Proj1/LoginServlet",true);
	xhttp.send();
}
function editUser(name,email){
	document.getElementById("name").value = name;
	document.getElementById("email").value = email;
// 	var xhttp = new XMLHttpRequest();
// 	xhttp.onreadystatechange=function() {
// 	    if (this.readyState == 4 && this.status == 200) {
// 	      document.getElementById("demo").innerHTML = this.responseText;
// 	    }
// 	  };
// 	xhttp.open("GET","http://localhost:8080/Proj1/LoginServlet",true);
// 	xhttp.send();
}
function onLoad(){
	alert('onload');
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("demo").innerHTML = this.responseText;
	    }
	  };
	xhttp.open("GET","http://localhost:8080/Proj1/LoginServlet",true);
	xhttp.send();
}
onLoad();
</script>
<body>
<div>
<form action="LoginServlet" method="post">
	<div id="main" >
		<div><span>User Name: </span><input id="name" type="text" name="name"/></div></br>
		<div><span>Email:</span><input id="email" type="email" name="email" /></div></br>
		
		<div><input type="submit" title="Submit"/></div>
	</div>
</form>
</div>
</br></br>

<div><button name="Show" title="Show" style="align:right;" onclick="showUsers()">Show</button></div>

<table id="first">
	<thead><tr><td>Name</td><td>Email</td></tr></thead>
	<tbody>
	<% 
		List<User> usrList = (List<User>) request.getSession().getAttribute("usrList");
		if(usrList != null){
		for(User usr : usrList){
			out.print("<tr><td>" + usr.getName() + "</td><td>" + usr.getEmail() + "</td><td><button onclick=\"editUser('"+usr.getName()+"','"+usr.getEmail()+"')\">Edit</button></td></tr>");
		}
		}
	%>
	</tbody>
</table>
<div id="demo"></div>

</body>
</html>