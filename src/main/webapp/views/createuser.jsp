<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create user</title>
        <link rel="stylesheet" href="<c:url value='/styles/style.css' />" />

</head>
<body>
    
<div class="mwb-form-main-wrapper">
	<div class="mwb-form-main-container">
			<h1>Create User</h1>
			<form action="users/add" method="post" onSubmit="return checkAllValues()">
			<%
				String message = (String) request.getParameter("message");
				String messageClass = "";
				
				if (message != null && message.equals("User Created Successfully")) {
					messageClass = "success";
				} else if (message != null && message.equals("Internal Server Error")) {
					messageClass = "error";
				} else {
					messageClass = "success hide";
					message = ""; 
				}
			%>
			<p class="<%= messageClass %> text-center" id="message"><%= message %></p>
			<div class="mwb-form-group">
					<input type="text" class="mwb-form-control" placeholder="Enter your username*" value="" name="username" id="name">
				
					<div class="mwb-form-error" id="name-error"></div>
				</div>
				<div class="mwb-form-group">
					<input type="text" class="mwb-form-control" placeholder="Enter your Department*" name="department" id="department">
					
					<div class="mwb-form-error" id="department-error"></div>
				</div>
				<div class="mwb-form-group">
					<input type="text" class="mwb-form-control" placeholder="Enter your designation*" name="designation" id="designation">
					<div class="mwb-form-error" id="designation-error"></div>
				</div>
				
				<div class="mwb-form-group flex">
				<a href="/bookstore" style="width: 100%;"> <button type="button" class="mwb-form-submit-btn submit-back-btn" >Back</button></a>	
					<button type="submit"  class="mwb-form-submit-btn" >Submit</button>
				</div>
			</form>
		</div>
	</div>
<script src="<c:url value='/js/index.js' />"></script>
</body>
</html>