<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <h1>Edit Employee</h1>
        <c:forEach var="user" items="${list}">
         </c:forEach>

       <form:form method="POST" action="/user/editsave">
        <table >

        <tr>
        <td></td>
         <td><form:hidden  path="id" /></td>
         </tr>
         <tr>
          <td>Name : </td>
          <td><form:input path="name"  /></td>
          <td>${user.name}</td>
         </tr>
                  <tr>
                   <td>Mobile : </td>
                   <td><form:input path="mobile"  /></td>
                  </tr>
         <tr>
          <td> </td>
          <td><input type="submit" value="Edit Save" /></td>
         </tr>
        </table>
       </form:form>