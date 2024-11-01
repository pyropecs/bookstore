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
			<h1>Contact Us</h1>
			<form action="users/add" method="post" onSubmit="return checkAllValues()">
				<div class="mwb-form-group">
					<input type="text" onChange="" class="mwb-form-control" placeholder="Enter your username*" value="" name="username" id="name">
				
					<div class="mwb-form-error" id="name-error">This Field Required*</div>
				</div>
				<div class="mwb-form-group">
					<input type="text" class="mwb-form-control" placeholder="Enter your Department*" name="department" id="department">
					
					<div class="mwb-form-error" id="department-error">This Field Required*</div>
				</div>
				<div class="mwb-form-group">
					<input type="text" class="mwb-form-control" placeholder="Enter your designation*" name="designation" id="designation">
					<div class="mwb-form-error" id="designation-error">This Field Required*</div>
				</div>
				
				<div class="mwb-form-group">
					<button type="submit" class="mwb-form-submit-btn" >Submit</button>
				</div>
			</form>
		</div>
	</div>
<script src="<c:url value='/js/createUser.js' />"></script>
</body>
</html>