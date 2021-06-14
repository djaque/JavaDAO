<%-- 
    Document   : users
    Created on : 06-ago-2019, 23:41:07
    Author     : dany
--%>

<%@page import="java.util.List"%>
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
        
        <h2>Crear Usuario</h2>
        <form action="users_controller" method="post">
            <p>
                <input type="text" name="name" placeholder="Nombre">
                <input type="text" name="email" placeholder="Email">
                <input type="password" name="password" placeholder="Password">
                <input type="submit" value="Crear">
            </p>
        </form>
        <hr>
        <h2>Lista de usuarios</h2>
        <ul>
            <% 
                List<UserDTO> lu = (List<UserDTO>)request.getAttribute("users");
                
                if (null == lu) {
                    out.println("<li>SIN USUARIOS</li>");
                } else {
                    for(UserDTO u : lu) {
                        out.println("<li>"+u.getName()+" ("+u.getEmail()+") <a href=\"user_edit?id="+u.getId()+"\">Editar</a></li>");
                    }
                }
            %>
        </ul>
    </body>
</html>

