package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">  \n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Raleway|Ubuntu\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/login.css\">\n");
      out.write("        <title>ShadiaGram |LOGIN</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"contenedor-formularios\">\n");
      out.write("            <div class=\"contenedor-logo text-center\"><img src=\"img/logo.png\"></div>\n");
      out.write("            <ul class=\"contenedor-tabs\">\n");
      out.write("                <li class=\"tab tab-segunda active\"><a href=\"#iniciar-sesion\">Iniciar Sesión</a></li>\n");
      out.write("                <li class=\"tab tab-primera\"><a href=\"#registrarse\">Registrarse</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"contenido-tab\" name=\"div\">\n");
      out.write("                <div id=\"alerta2\" name=\"alerta2\"></div>\n");
      out.write("                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                <div id=\"iniciar-sesion\">\n");
      out.write("                    <h1>Iniciar Sesión</h1>\n");
      out.write("                    <form name=\"addForm2\" action=\"login?accion=login\" method=\"post\" >\n");
      out.write("                        <div class=\"contenedor-input\">\n");
      out.write("                            <label>  &#128247 | Usuario <span class=\"req\">*</span>  </label>\n");
      out.write("                            <input type=\"text\" id=\"usuarioU\" nombre=\"usuarioU\" name=\"usuarioU\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"contenedor-input\">\n");
      out.write("                            <label>  &#128272 | Contraseña <span class=\"req\">*</span> </label>\n");
      out.write("                            <input type=\"password\" id=\"passwordU\" password=\"passwordU\" name=\"passwordU\">\n");
      out.write("                        </div>\n");
      out.write("                        <p class=\"forgot\"><a href=\"olvidoPassword.jsp\" >Se te olvidó la contraseña?</a>\n");
      out.write("                        </p>\n");
      out.write("                        <p class=\"forgot\"><a href=\"olvidoUsuario.jsp\">Se te olvidó el usuario?</a></p>\n");
      out.write("                        <input type=\"submit\" onclick=\"return validarForm2();\" class=\"button button-block\" value=\"Iniciar Sesión\">                                              \n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"registrarse\">\n");
      out.write("                    <div id=\"alerta\" name=\"alerta\"></div>\n");
      out.write("                    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    <h1>Registrarse</h1>\n");
      out.write("                    <form name=\"addForm\" action=\"login?accion=registro\" method=\"post\" >\n");
      out.write("                        <div class=\"fila-arriba\">\n");
      out.write("                            <div class=\"contenedor-input\">\n");
      out.write("                                <label>Nombre<span class=\"req\">*</span></label>\n");
      out.write("                                <input type=\"text\" id=\"nombreU\" name=\"nombreU\" >\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"contenedor-input\">\n");
      out.write("                                <label>Apellido </label>\n");
      out.write("                                <input type=\"text\" id=\"apellidoU\" name=\"apellidoU\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"contenedor-input\">\n");
      out.write("                            <label>Usuario <span class=\"req\">*</span> </label>\n");
      out.write("                            <input type=\"text\" id=\"usuarioU\" name=\"usuarioU\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"contenedor-input\">\n");
      out.write("                            <label> Email <span class=\"req\">*</span>  </label>\n");
      out.write("                            <input type=\"text\" id=\"emailU\" name=\"emailU\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"contenedor-input\">\n");
      out.write("                            <label>Contraseña <span class=\"req\">*</span>  </label>\n");
      out.write("                            <input type=\"password\" id=\"passwordU\" name=\"passwordU\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"contenedor-input\">\n");
      out.write("                            <label>Repetir Contraseña <span class=\"req\">*</span> </label>\n");
      out.write("                            <input type=\"password\" id=\"repetir\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"contenedor-input\">\n");
      out.write("                            <p id=\"fechaS\">Fecha Nacimiento <span class=\"req\">*</span></p>\n");
      out.write("                            <input id=\"date\" type=\"date\" id=\"fecha_NacimientoU\" name=\"fecha_NacimientoU\">\n");
      out.write("                        </div>                        \n");
      out.write("                        <div class=\"contenedor-input res\">\n");
      out.write("                            <p id=\"terminos\"> Haciendo click en <em>Registrase</em> Acepta los \n");
      out.write("                                <a href=\"\" target=\"_blank\" data-toggle=\"modal\"  data-target=\"#exampleModalScrollable\">\n");
      out.write("                                    Terminos y Condiciones del servicio</a>\n");
      out.write("                            </p>                                                                      \n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"submit\" onclick=\"return validarForm();\" class=\"button button-block\" value=\"Registrarse\">\n");
      out.write("\n");
      out.write("                        <div class=\"modal fade\" id=\"exampleModalScrollable\" tabindex=\"-1\" role=\"dialog\" \n");
      out.write("                             aria-labelledby=\"exampleModalScrollableTitle\" aria-hidden=\"true\">\n");
      out.write("                            <div class=\"modal-dialog modal-dialog-scrollable\" role=\"document\">\n");
      out.write("                                <div class=\"modal-content\">\n");
      out.write("                                    <div class=\"modal-header text-center\" style=\"background: #1ab188; text-align: center\">\n");
      out.write("                                        <h5 class=\"modal-title\" id=\"exampleModalScrollableTitle\" style=\"color: white\" >Terminos\n");
      out.write("                                            y condiciones</h5>\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                            <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                        </button>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-body\">\n");
      out.write("                                        Aceptamos proporcionarte el Servicio de AngieGram, que incluye\n");
      out.write("                                        todos los productos, las funciones, las aplicaciones, los\n");
      out.write("                                        servicios, las tecnologías y el software que ofrecemos para cumplir\n");
      out.write("                                        la misión de AngieGram: acercarte a las personas y cosas que te\n");
      out.write("                                        encantan. El Servicio se compone de los siguientes aspectos (el\n");
      out.write("                                        \"Servicio\"):\n");
      out.write("                                        <ul style=\"list-style: none; padding-top: 15px\">\n");
      out.write("                                            <li><span class=\"font-weight-bolder text-center\">Ofrecer\n");
      out.write("                                                    oportunidades personalizadas para crear, conectar, comunicar,\n");
      out.write("                                                    descubrir y compartir.</span></br></br> Cada persona es distinta. Queremos\n");
      out.write("                                                fortalecer las relaciones por medio de experiencias compartidas\n");
      out.write("                                                que realmente te interesen. Por lo tanto, creamos sistemas que\n");
      out.write("                                                intentan entender quiénes o qué cosas te interesan y les\n");
      out.write("                                                interesan a los demás, y usamos esa información para ayudarte a\n");
      out.write("                                                crear, encontrar, unir y compartir experiencias que te resulten\n");
      out.write("                                                relevantes. Parte de esto consiste en destacar el contenido, las\n");
      out.write("                                                funciones, las ofertas y las cuentas que te pueden interesar, y\n");
      out.write("                                                ofrecerte formas de experimentar Instagram en función de lo que\n");
      out.write("                                                tú y otras personas hacen tanto dentro como fuera de Instagram.</li>\n");
      out.write("                                            <li style=\"padding-top: 15px\"><span class=\"font-weight-bolder text-center\">Fomentar un\n");
      out.write("                                                    ambiente positivo, inclusivo y seguro.</span></br></br> Desarrollamos y usamos\n");
      out.write("                                                herramientas, y ofrecemos recursos a los miembros de nuestra\n");
      out.write("                                                comunidad que contribuyen a que estos vivan experiencias\n");
      out.write("                                                positivas e inclusivas, incluso cuando creemos que pueden\n");
      out.write("                                                necesitar ayuda. También contamos con equipos y sistemas cuyo\n");
      out.write("                                                trabajo es combatir el abuso y las violaciones de nuestras\n");
      out.write("                                                Condiciones y políticas, así como combatir comportamientos\n");
      out.write("                                                perjudiciales y engañosos. Usamos toda la información que\n");
      out.write("                                                tenemos, incluida la tuya, para proteger nuestra plataforma.\n");
      out.write("                                                Asimismo, es posible que compartamos información sobre usos\n");
      out.write("                                                indebidos o contenido perjudicial con otras empresas de Facebook\n");
      out.write("                                                o con las fuerzas del orden. Obtén más información en la Política\n");
      out.write("                                                de datos.</li>\n");
      out.write("                                            <li style=\"padding-top: 15px\"><span class=\"font-weight-bolder text-center\">Desarrollar y\n");
      out.write("                                                    usar tecnologías que nos ayuden a respaldar continuamente a\n");
      out.write("                                                    nuestra comunidad en constante crecimiento.</span> </br></br>Organizar y analizar\n");
      out.write("                                                información de nuestra creciente comunidad es central para\n");
      out.write("                                                nuestro Servicio. Gran parte de nuestro Servicio consiste en\n");
      out.write("                                                crear y usar tecnologías de vanguardia que nos ayuden a\n");
      out.write("                                                personalizar, proteger y mejorar nuestro Servicio a gran escala\n");
      out.write("                                                para una amplia comunidad internacional. Tecnologías como la\n");
      out.write("                                                inteligencia artificial y el aprendizaje automático nos dan el\n");
      out.write("                                                poder de aplicar procesos complejos en todo nuestro Servicio. Las\n");
      out.write("                                                tecnologías automatizadas también nos permiten garantizar la\n");
      out.write("                                                funcionalidad y la integridad de nuestro Servicio.</li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-footer\">\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-secondary\" \n");
      out.write("                                                data-dismiss=\"modal\" style=\"background: #1ab188\">Cerrar\n");
      out.write("                                        </button>\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-primary\" name=\"aceptoTerminos\" \n");
      out.write("                                                data-dismiss=\"modal\" style=\"background: #1ab188\"> Aceptar\n");
      out.write("                                        </button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>        \n");
      out.write("        </div>\n");
      out.write("        <footer class=\"rounded-top text-center\">\n");
      out.write("            <div class=\"container py-2\"> \n");
      out.write("                <p class=\"text-white my-2\">Sergio Buitrago - Leinner - V1.0</p> \n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/validarForm.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/main-login.js\"></script>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <div  class=\"alert alert-danger\"><a  id=\"alerta3\" href=\"\" class=\"close\" data-dismiss=\"alert\">&times;</a>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</div>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje2!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        <div  class=\"alert alert-danger\">  <a href=\"\" class=\"close\" data-dismiss=\"alert\">&times;</a>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje2}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(" </div> \n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
