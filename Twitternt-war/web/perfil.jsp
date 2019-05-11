<%-- 
    Document   : perfil
    Created on : 10-may-2019, 20:00:11
    Author     : Jesús Muley
--%>

<%@page import="twitternt.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario u = (Usuario)request.getAttribute("usuario");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil de usuario</title>
    </head>
    <body>
        <h1>Datos del perfil</h1>
        Nombre de usuario <br/> <input name="usuario" value="<%= u.getNombreUsuario() %>" maxsize="30" maxlength="30" readonly/> <br/> <br/>
        Contraseña <br/> <input type="password" name="password" value="<%= u.getPassword() %>" maxsize="30" maxlength="30"/> <br/> <br/>
        Nombre <br/> <input name="nombre" value="<%= u.getNombre() %>" maxsize="45" maxlength="45"/> <br/> <br/>
        Apellidos <br/> <input name="apellidos" value="<%= u.getApellidos() %>" maxsize="60" maxlength="60"/> <br/> <br/>
        Correo electr&oacute;nico <br/> <input name="correo" value="<%= u.getEmail() %>" maxsize="60" maxlength="60"/> <br/> <br/>
        
        
    </body>
</html>