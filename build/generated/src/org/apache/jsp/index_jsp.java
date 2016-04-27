package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.pitt.is1017.spaceinvaders.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Alien Invasion - Login</title>\n");
      out.write("    </head>\n");
      out.write("<!--    Java code below -->\n");
      out.write("    ");

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
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <form id=\"frmLogin\" action=\"index.jsp\" method=\"post\"> \n");
      out.write("            <label for=\"txtUserName\">User name: </label>&nbsp;<input type=\"text\" id=\"txtUserName\" name=\"txtUserName\" value=\"\">\n");
      out.write("            <br/>\n");
      out.write("            <label for=\"txtPassword\">Password: </label>&nbsp;<input type=\"password\" id=\"txtPassword\" name=\"txtPassword\" value=\"\">\n");
      out.write("            <br/>\n");
      out.write("            <input type=\"submit\" id=\"btnSubmit\" name=\"btnSubmit\" value=\"Login\">\n");
      out.write("        </form>\n");
      out.write("        <br/>\n");
      out.write("        <form id=\"registerBtn\" action=\"register.jsp\" method=\"post\">\n");
      out.write("            <input type=\"submit\" id=\"btnReg\" name=\"btnReg\" value=\"Register\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
