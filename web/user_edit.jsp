<%-- 
    Document   : user_edit
    Created on : 10-ago-2019, 10:39:49
    Author     : dany
--%>

<%@page import="bean.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Usuarios!</h1>

        <h2>Editar Usuario</h2>
        <%
            String status = (String) request.getAttribute("status");
            if (status != null) {
                %>
                    <h3><%=status%></h3>
                <%
            }
      
            UserDTO user = (UserDTO)request.getAttribute("user");
            if (null != user) {
                %>
                <form action="user_edit" method="post">
                    <p>
                        <input type="hidden" name="action" value="edit">
                        <input type="hidden" name="id" value="${requestScope.user.id}">
                        <input type="text" name="name" placeholder="Nombre" value="${requestScope.user.name}">
                        <input type="text" name="email" placeholder="Email" value="${requestScope.user.email}">
                        <input type="password" name="password" placeholder="Password" value="${requestScope.user.password}">
                        <input type="submit" value="Editar">
                    </p>
                </form>
                <%
            }
            
        %>
        <hr>
        <%
            if (null != user) {
                %>
                <form action="user_edit" method="post" onsubmit="return confirm('Esta seguro?');">
                    <p>
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${requestScope.user.id}">
                        <input type="submit" value="Eliminar">
                    </p>
                </form>
                <%
            }
        %>
        <p>
            <a href="users_controller">Volver</a>
        </p>
    </body>
</html>
