<%-- 
    Document   : register
    Created on : Mar 24, 2016, 8:40:00 PM
    Author     : Asha Wilson
--%>

<%@page import="edu.pitt.is1017.spaceinvaders.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alien Invasion - Register</title>
    </head>
    <%
        String fName = "";
        String lName = "";
        String email = "";
        String pwrd = "";
        User user;
        
        if(request.getParameter("btnSubmit") != null){
            if(request.getParameter("txtFName")!= null){
                if(request.getParameter("txtFName") != ""){
                    fName = request.getParameter("txtFName");
                    //out.println(userName);
                }
            }
            if(request.getParameter("txtLName")!= null){
                if(request.getParameter("txtLName") != ""){
                    lName = request.getParameter("txtLName");
                }
            }
            if(request.getParameter("txtEmail")!= null){
                if(request.getParameter("txtEmail") != ""){
                    email = request.getParameter("txtEmail");
                }
            }
            if(request.getParameter("txtPword")!= null){
                if(request.getParameter("txtPword") != ""){
                     if(request.getParameter("txtConfirmPW")!= null){
                        if(request.getParameter("txtConfirmPW") != ""){
                            pwrd = request.getParameter("txtConfirmPW");
                        }
                    }
                }
            }
            if(!fName.equals("") && !lName.equals("") && !pwrd.equals("") && !email.equals("")){
                user = new User(lName, fName, email, pwrd);

                out.println("<script>alert('You have registered a new account!');</script>");
                
                response.sendRedirect("index.jsp");
            }
            else{
                out.println("<script>alert('You must answer all criteria!');</script>");
            }
        }
    %>
    <body>
        <form id="frmReg" action="register.jsp" method=post"> 
            <label for="txtFName">First Name: </label>&nbsp;<input type="text" id="txtFName" name="txtFName" value="">
            <br/>
            <label for="txtLName">Last Name: </label>&nbsp;<input type="text" id="txtLName" name="txtLName" value="">
            <br/>
            <label for="txtEmail">E-mail: </label>&nbsp;<input type="text" id="txtEmail" name="txtEmail" value="">
            <br/>
            <label for="txtPword">Password: </label>&nbsp;<input type="password" id="txtPword" name="txtPword" value="">
            <br/>
            <label for="txtConfirmPW">Confirm Password: </label>&nbsp;<input type="password" id="txtConfirmPW" name="txtConfirmPW" value="">
            <br/>
            <input type="submit" id="btnSubmit" name="btnSubmit" value="Register">
        </form>        
    </body>
</html>
