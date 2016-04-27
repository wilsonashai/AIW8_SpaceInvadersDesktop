package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tutorial_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Tutorial Game</title>\n");
      out.write("        <script src=\"assets/js/jquery-2.2.3.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("            //will need array of bullets\n");
      out.write("            $bullet = null;\n");
      out.write("            $alien = null;\n");
      out.write("            var bulletInterval = null;\n");
      out.write("            \n");
      out.write("                       \n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $bullet = $(\"#bullet1\");\n");
      out.write("                $alien = $(\"#alien\");\n");
      out.write("                //clearInterval(bulletInterval);\n");
      out.write("                $(document).keydown(function(e){\n");
      out.write("                    //key code for space key is 32\n");
      out.write("                    if(e.keyCode == 32){\n");
      out.write("                        bulletInterval = setInterval(moveBullet, 500);\n");
      out.write("                    }\n");
      out.write("                })\n");
      out.write("                \n");
      out.write("                letsSee();\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            function letsSee(){\n");
      out.write("                var i = 1;\n");
      out.write("                $(\"#bullet\" + i ).hide();\n");
      out.write("                console.log(\"#bullet\" + i + \" removed\");\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function moveAlien(){\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function moveBullet(){\n");
      out.write("                var pos = $bullet.position();\n");
      out.write("                //build logic to stop interval: figure out colision \n");
      out.write("                //if(pos.top < ... clearInterval(bulletInterval)\n");
      out.write("                $bullet.css(\"top\", (pos.top - 10) + \"px\");\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function intersectRect(r1, r2) {\n");
      out.write("                return !(r2.left > r1.right || \n");
      out.write("                         r2.right < r1.left || \n");
      out.write("                         r2.top > r1.bottom ||\n");
      out.write("                         r2.bottom < r1.top);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("            #alien{\n");
      out.write("                border: 1px solid #000;\n");
      out.write("                width: 75px;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 10px;\n");
      out.write("                left: 10px;\n");
      out.write("                padding: 20px;\n");
      out.write("                border-radius: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            #bullet1{\n");
      out.write("                border: 1px solid #000;\n");
      out.write("                width: 5px;\n");
      out.write("                height: 15px;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 300px;\n");
      out.write("                left: 100px;\n");
      out.write("                padding: 5px;\n");
      out.write("                border-radius: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            #bullet2{\n");
      out.write("                border: 1px solid #000;\n");
      out.write("                width: 5px;\n");
      out.write("                height: 15px;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 200px;\n");
      out.write("                left: 50px;\n");
      out.write("                padding: 5px;\n");
      out.write("                border-radius: 20px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"alien\">Alien</div>\n");
      out.write("        <div id=\"bullet1\"></div>\n");
      out.write("        <div id=\"bullet2\"></div>\n");
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
