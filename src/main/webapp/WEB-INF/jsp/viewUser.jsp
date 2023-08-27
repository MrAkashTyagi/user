  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="3">
<tr><th>Id</th><th>Name</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>
   <c:forEach var="user" items="${list}">
   <tr>
   <td>${user.id}</td>
   <td>${user.name}</td>
   <td>${user.mobile}</td>
      <td><a href="edituser/${user.id}">Edit</a></td>
      <td><a href="deleteuser/${user.id}">Delete</a></td>
   </tr>
   </c:forEach>
   </table>
   <br/>
   <a href="userForm">Add New User</a>