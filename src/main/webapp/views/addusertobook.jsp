<%@ page import="com.library.models.Book,java.util.List" %>
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
			<h1>Add Users To Book</h1>
			<form action="books/add" method="post" onSubmit="return checkAllValues()">
				<div class="mwb-form-group">
					<select name="" id="">
                                                <%
                                                List<Book> books = (List<Book>) request.getAttribute("books");
                                                        for(Book book:books){

                                                %>
                                                <option value="<%=book.getId()%>"">
                                                        <%=book.getAuthor() %>
                                                </option>
                                                <% } %>
                                                <option value="book1">
                                                        book1
                                                </option>
                                        </select>
				
					<div class="mwb-form-error" id="name-error">This Field Required*</div>
				</div>
                                
				<div class="mwb-form-group">
                                        <div class="checkbox-container">
                                                <input type="checkbox" name="" id="" >
                                        user 1
                                        </input>
                                        </div>
					
                                        <div class="checkbox-container">
                                                <input type="checkbox" name="" id="" />
                                        </div>
                                        <div class="checkbox-container">
                                                <input type="checkbox" name="" id="" />
                                        </div>
				</div>
			
				<div class="mwb-form-group">
					<button type="submit"  class="mwb-form-submit-btn" >Submit</button>
				</div>
			</form>
		</div>
	</div>
<script src="<c:url value='/js/create.js' />"></script>
</body>
</html>