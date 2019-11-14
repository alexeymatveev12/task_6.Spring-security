
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Update User Page</title>
    <link href="/res/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div align="center">
    <form method="POST" action="/update">
    <table bordercolor="red" border="1" cellpadding="4" cellspacing="0">
        <caption>
           <h2>Update page</h2>
        </caption>

        <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>

        <br/><br/>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Username</th>
            <th>Password</th>
            <th>Role</th>
            <th>Confirmation - Update the record</th>
        </tr>

        <jsp:useBean id="user" scope="request" type="task5.spring.model.User"/>


        <tr>
            <td align="center" size="20"><p>Текущее значение:</p><h5><c:out value="${user.id}"/></h5>
                <p>Данные менять не разрешается!</p>
            </td>
            <td align="center" size="30"><p>Текущее значение:</p><h5><c:out value="${user.name}"/></h5>
                <p>Новое значение</p>
                <input type="text" name="name" required="required"
                       value="<c:out value='${user.name}'/>"/></td>
            <td align="center" size="30"><p>Текущее значение:</p><h5><c:out value="${user.username}"/></h5>
                <p>Новое значение</p>
                <input type="text" name="username" required="required"
                       value="<c:out value='${user.username}'/>"/></td>
            <td align="center" size="30"><p>Текущее значение:</p><h5><c:out value="${user.password}"/></h5>
                <p>Новое значение</p>
                <input type="text" name="password" required="required"
                       value="<c:out value='${user.password}'/>"/></td>
            <td align="center" size="30"><p>Текущее значение:</p><h5><c:out value="${user.role}"/></h5>
                <p>Новое значение</p>
                <input type="text" name="role" required="required"
                       value="<c:out value='${user.role}'/>"/></td>
            <td>
                <input type="submit" value="Update this User"/>
            </td>

        </tr>


    </table>
    </form>
    <hr>

    <br/><br/>
    <hr>






    <form action="/create">
        <input type="submit" value="Create the New User" />
    </form>

    <form action="/read">
        <input type="submit" value="Read User's List" />
    </form>


</div>



<%--<td align="center" size="30"><p>Текущее значение:</p><h5><c:out value="${user.role}"/></h5>
    <p>Новое значение</p>

    input type="text" name="role" required="required"
    value="<c:out value='${user.role}'/>"/>
</td>--%>



<%--                <select name="role" id="role">User rights (user or admin)>--%>
<%--                    <option value="user" selected>User credentials</option>--%>
<%--                    <option value="admin">Admin credentials--%>
<%--                    <value="<c:out value='${user.role}'/>"</option>--%>
<%--                </select>--%>


<%--               <input type="text" name="role" required="required"--%>
<%--                       value="<c:out value='${user.role}'/>"/>--%>
<%--   <form:form>
       Role:  User: <form:radiobutton path="role" value="user"/>
       Admin: <form:radiobutton path="role" value="admin"/>
   </form:form>--%>

<%--            </td>--%>

</body>
</html>
