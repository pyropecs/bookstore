<%@ page import="java.util.List,java.util.Set,com.library.models.Book,com.library.models.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <title>View Books</title>
<link rel="stylesheet" href="<c:url value='/styles/style.css' />" />
</head>

<body>
        
     <div class="wrap"  style="background-color:white; align-items: center;">
<table>
      <tr>
        
        <th>Book Name</th>
        <th>Users</th>
        
      </tr>
      <% List<Book> books = (List<Book>) request.getAttribute("books");
        for(Book book:books){
        %>
    <tr>  
  <td><%=book.getName()%></td>
     <td>
        <% Set<User> users = book.getUsers();
                
                for(User user:users){ %>
        <%=user.getUsername() %>,
        <% } %>
</td>
  </tr>
    <% } %>
    </table>
     </div>   

</body>
</html>
