package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class aliens_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Alien Board</title>\n");
      out.write("        <style>\n");
      out.write("            #tblAliens{\n");
      out.write("                position: absolute;\n");
      out.write("                top: 10px;\n");
      out.write("                left: 10px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            #tblAliens tr td{\n");
      out.write("                padding: 5px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"assets/js/jquery-2.2.3.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("            var alienList = [];\n");
      out.write("            $tblAliens = null;\n");
      out.write("            var docWidth;\n");
      out.write("            var docHeight;\n");
      out.write("            var intervalAllAliens = null;\n");
      out.write("            var goRight = true;\n");
      out.write("            \n");
      out.write("            $(document).ready(function(){\n");
      out.write("                docWidth = $(document).width();\n");
      out.write("                docHeight = $(document).height();\n");
      out.write("                \n");
      out.write("                $tblAliens = $('#tblAliens');\n");
      out.write("                drawAllAliens();\n");
      out.write("                \n");
      out.write("                intervallAllAliens = setInterval(moveAllAliens, 100);\n");
      out.write("                \n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            function drawAllAliens(){\n");
      out.write("                for(var i = 0; i < 3; i++){\n");
      out.write("                    $tr = $('<tr></tr>');\n");
      out.write("                    for(var j = 0; j < 10; j++){\n");
      out.write("                        $td = $('<td></td>');\n");
      out.write("                        $alien = $('<img>');\n");
      out.write("                        $alien.attr('src', 'assets/Images/alien.gif');\n");
      out.write("                        alienList.push($alien);\n");
      out.write("                        // everytime fire, bullet and see if curr pos of bullet intersects with alien\n");
      out.write("                        $td.append($alien);\n");
      out.write("                        $tr.append($td);\n");
      out.write("                    }\n");
      out.write("                    $tblAliens.append($tr);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function moveAllAliens(){\n");
      out.write("//                var pos = $tblAliens.position();\n");
      out.write("//                //once reach certain side, need to reverse\n");
      out.write("//                $tblAliens.css(\"left\", (pos.left+10) + \"px\");\n");
      out.write("                \n");
      out.write("                var pos = $tblAliens.position();\n");
      out.write("                //once reach certain side, need to reverse\n");
      out.write("                if(pos.left < (docWidth - ($tblAliens.width()+ 5)) && goRight == true){\n");
      out.write("                    $tblAliens.css(\"left\", (pos.left+10) + \"px\");\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                    goRight = false;\n");
      out.write("                \n");
      out.write("                if(pos.left > 0 && goRight == false){\n");
      out.write("                    $tblAliens.css(\"left\", (pos.left-10) + \"px\");\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    goRight = true;\n");
      out.write("                    moveDown();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table id=\"tblAliens\">\n");
      out.write("            \n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        \n");
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
