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
			<h1>Create Book</h1>
			<form action="books/add" method="post" onSubmit="return checkAllValues()">
				<div class="mwb-form-group">
					<input type="text"  class="mwb-form-control" placeholder="Enter Book Name*" value="" name="name" id="name">
				
					<div class="mwb-form-error" id="name-error">This Field Required*</div>
				</div>
				<div class="mwb-form-group">
					<input type="text"  class="mwb-form-control" placeholder="Enter Author*" name="author" id="author">
					
					<div class="mwb-form-error" id="author-error">This Field Required*</div>
				</div>
				<div class="mwb-form-group">
					<input type="text" class="mwb-form-control" placeholder="Enter The Price*" name="price" id="price">
					<div class="mwb-form-error" id="price-error">This Field Required*</div>
				</div>
				
				<div class="mwb-form-group flex">
					<a href="/bookstore" style="width: 100%;"> <button type="button" class="mwb-form-submit-btn submit-back-btn" >Back</button></a>
					<button type="submit"  class="mwb-form-submit-btn" >Submit</button>
				</div>
			</form>
		</div>
	</div>
<script src="<c:url value='/js/create.js' />"></script>
</body>
</html>