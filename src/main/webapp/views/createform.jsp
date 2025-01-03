<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

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
		<%String path =  (String) request.getAttribute("path"); %>
			<h1>Create <%=path.substring(0, 1).toUpperCase() + path.substring(1,path.length() - 1)%></h1>
		
			<form action="<%=path%>/add" method="post" onSubmit="return checkAllValues()">
			<%
				String[] fields = path.equals("books") 
                   ? new String[]{"name", "author", "price"} 
                   : new String[]{"name", "department", "designation"};

				String message = (String) request.getAttribute("message");
				
				String messageClass = "";
				
				if (message != null && (message.equals("User Created Successfully") || message.equals("Book Created Successfully"))) {
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
					<input type="text" class="mwb-form-control" placeholder="Enter your <%=fields[0]%>*" value="" name="<%=fields[0]%>" id="<%=fields[0]%>">
				
					<div class="mwb-form-error" id="<%=fields[0]%>-error"></div>
				</div>
				<div class="mwb-form-group">
					<input type="text" class="mwb-form-control" placeholder="Enter your <%=fields[1]%>*" name="<%=fields[1]%>" id="<%=fields[1]%>">
					
					<div class="mwb-form-error" id="<%=fields[1]%>-error"></div>
				</div>
				<div class="mwb-form-group">
					<input type="text" class="mwb-form-control" placeholder="Enter your <%=fields[2]%>*" name="<%=fields[2]%>" id="<%=fields[2]%>">
					<div class="mwb-form-error" id="<%=fields[2]%>-error"></div>
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