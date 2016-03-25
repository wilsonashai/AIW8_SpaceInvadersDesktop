<%-- 
    Document   : index
    Created on : Mar 20, 2016, 4:05:46 PM
    Author     : Asha Wilson
--%>

<%@page import="edu.pitt.is1017.spaceinvaders.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alien Invasion - Login</title>
    </head>
<!--    Java code below -->
    <%
        String userName ="";
        String password = "";
        User user;
        
        if(request.getParameter("btnSubmit") != null){
            if(request.getParameter("txtUserName")!= null){
                if(request.getParameter("txtUserName") != ""){
                    userName = request.getParameter("txtUserName");
                    //out.println(userName);
                }
            }
            if(request.getParameter("txtPassword")!= null){
                if(request.getParameter("txtPassword") != ""){
                    password = request.getParameter("txtPassword");
                    //out.println(userName + " " + password);
                }
            }
            if(!userName.equals("") && !password.equals("")){
                user = new User(userName, password);

                if(user.isLoggedIn() == true)
                {
                    response.sendRedirect("game.jsp");
                }
                else 
                {
                    out.println("<script>alert('Invalid login credentials!');</script>");
                }
            }
            else{
                out.println("<script>alert('You must enter both user name & password!');</script>");
            }
       }
    %>
    <body>
        <form id="frmLogin" action="index.jsp" method="post"> 
            <label for="txtUserName">User name: </label>&nbsp;<input type="text" id="txtUserName" name="txtUserName" value="">
            <br/>
            <label for="txtPassword">Password: </label>&nbsp;<input type="password" id="txtPassword" name="txtPassword" value="">
            <br/>
            <input type="submit" id="btnSubmit" name="btnSubmit" value="Login">
        </form>
        <br/>
        <form id="registerBtn" action="register.jsp" method="post">
            <input type="submit" id="btnReg" name="btnReg" value="Register">
        </form>
    </body>
</html>
