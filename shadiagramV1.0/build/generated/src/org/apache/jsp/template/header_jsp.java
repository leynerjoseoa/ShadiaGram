package org.apache.jsp.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/template.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.1/css/all.css\" integrity=\"sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"menu_bar\">\n");
      out.write("                <a href=\"#\" class=\"bt-menu\"><i class=\"fas fa-bars\"></i>Menu</a>\n");
      out.write("            </div>\n");
      out.write("            <nav>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"inicio?accion=inicio&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"logoE\">\n");
      out.write("                            <img src=\"../img/portada.png\" id=\"logo\">\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"mover\"><a href=\"inicio?accion=perfil&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&user=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                            <img src=\"img/iconos/usuario.png\">\n");
      out.write("                            <i> Perfil ( @");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" )</i>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"mover\">\n");
      out.write("                        <a href=\"#\" target=\"_blank\" data-toggle=\"modal\"  \n");
      out.write("                           data-target=\"#exampleModalScrollable2\" \n");
      out.write("                           data-dismiss=\"modal\">\n");
      out.write("                            <img src=\"img/iconos/buscar.png\">\n");
      out.write("                            <i> Buscar</i>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"mover\">\n");
      out.write("                        <a href=\"inicio?accion=configuracion&usuario=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                            <img src=\"img/iconos/configuracion.png\">\n");
      out.write("                            <i> Configuración</i>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"mover\"> \n");
      out.write("                        <a href=\"inicio?accion=cerrar\">\n");
      out.write("                            <img src=\"img/iconos/salir.png\">\n");
      out.write("                            <i> Cerrar Sesion</i>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"modal fade\" id=\"exampleModalScrollable2\" tabindex=\"-2\" role=\"dialog\" \n");
      out.write("             aria-labelledby=\"exampleModalScro\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog modal-dialog-scrollable\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\"  class=\"text-center\" style=\"background: #1ab188; text-align: center\">\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <div class=\"d-flex justify-content-center\">\n");
      out.write("                                <div class=\"searchbar\">\n");
      out.write("                                    <input id=\"searchTerm\" class=\"search_input\" type=\"text\" name=\"\"onkeyup=\"doSearch()\" placeholder=\"Buscar...\">\n");
      out.write("                                    <a href=\"#\" class=\"search_icon\"><i class=\"fas fa-search\"></i></a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <table id=\"datos\">\n");
      out.write("                            <thead>\n");
      out.write("                            <th></th>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");
      dao.AmistadDAO ono = null;
      synchronized (_jspx_page_context) {
        ono = (dao.AmistadDAO) _jspx_page_context.getAttribute("ono", PageContext.PAGE_SCOPE);
        if (ono == null){
          ono = new dao.AmistadDAO();
          _jspx_page_context.setAttribute("ono", ono, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("                            <c:set var=\"idd\" scope=\"session\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                            <c:set var = \"lista\" scope = \"session\" value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ono.listarUsuarios()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>  \n");
      out.write("                            <c:forEach var=\"m\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lista}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td> \n");
      out.write("                                        <h1 style=\"display:none\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${m.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${m.getApellido()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </h1>\n");
      out.write("                                        <div class=\"imagen\">\n");
      out.write("                                            <a><img src=\"fotos?accion=fotoPerfil&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${m.getID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></a>\n");
      out.write("                                        </div>\n");
      out.write("                                        <h2 style=\"display:none\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${m.getUsuario()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td> <h2 >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${m.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2></td>\n");
      out.write("                                </tr>\n");
      out.write("                            </c:forEach>        \n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                                \n");
      out.write("<footer class=\"footer py-2 text-center\">\n");
      out.write("    <div class=\"container\"> <p>Sergio Buitrago - Leyner - V1.0</p> </div>\n");
      out.write("</footer>\n");
      out.write("<script src=\"js/BuscadorTabla.js\" type=\"text/javascript\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("                                       $(document).ready(main);\n");
      out.write("                                       var contador = 1;\n");
      out.write("                                       function main() {\n");
      out.write("                                           $('.menu_bar').click(function () {\n");
      out.write("                                               $('nav').toggle();\n");
      out.write("\n");
      out.write("                                               /*if (contador === 1) {\n");
      out.write("                                                $('nav').animate({\n");
      out.write("                                                left: '0'\n");
      out.write("                                                });\n");
      out.write("                                                contador = 0;\n");
      out.write("                                                } else {\n");
      out.write("                                                contador = 1;\n");
      out.write("                                                $('nav').animate({\n");
      out.write("                                                left: '-100%'\n");
      out.write("                                                });\n");
      out.write("                                                }*/\n");
      out.write("                                           });\n");
      out.write("                                       }\n");
      out.write("                                       ;\n");
      out.write("</script>\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("</body>\n");
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
