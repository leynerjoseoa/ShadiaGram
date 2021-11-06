package control;

import Task.email.email;
import dao.FotoDAO;
import dao.UsuarioDAO;
import entity.FotoDTO;
import entity.UsuarioDTO;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginController", urlPatterns = {"/login"})
public class loginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        String nombre, apellido, usuario, email, password, fechaN, mensaje, mensaje2;

        UsuarioDTO dto = new UsuarioDTO();
        UsuarioDAO dao = new UsuarioDAO();

        HttpSession inicio = request.getSession(true);

        switch (accion) {
            case "login":
                usuario = request.getParameter("usuarioU");
                password = request.getParameter("passwordU");

                if (dao.concidePassword(usuario, password)) {
                    dto.setUsuario(usuario);
                    dto.setPassword(password);

                    dto = dao.conocerUsuario(usuario);
                    
                    FotoDAO publicaciones= new FotoDAO();
                    List<FotoDTO> publicacionesAmigos= publicaciones.publicacionesAmigos(dto.getID());
                    
                    RequestDispatcher rd = request.getRequestDispatcher("inicio.jsp");
                    inicio.setAttribute("usuario", usuario);
                    inicio.setAttribute("id", dto.getID());
                    inicio.setAttribute("publicacionesA", publicacionesAmigos);
                    inicio.setAttribute("user", dto);

                    rd.forward(request, response);
                    
                } else if (!dao.existeUsuario(usuario)) {
                    request.setAttribute("mensaje", ":( Error de acceso, verifique el usuario NO EXISTE");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensaje", ":( Error de acceso, verifique la contraseña INCORRECTA");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                break;

            case "registro":
                nombre = request.getParameter("nombreU");
                apellido = request.getParameter("apellidoU");
                usuario = request.getParameter("usuarioU");
                email = request.getParameter("emailU");
                password = request.getParameter("passwordU");
                fechaN = request.getParameter("fecha_NacimientoU");

                dto.setUsuario(usuario);
                dto.setEmail(email);

                if (dao.existeUsuario(dto.getUsuario())) {
                    request.setAttribute("mensaje2", "Error, Usuario ya REGISTRADO");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else if (dao.existeEmail(dto.getEmail())) {
                    request.setAttribute("mensaje2", "Error, Email ya esta siendo utilizado");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    dto.setNombre(nombre);
                    dto.setApellido(apellido);
                    dto.setPassword(password);
                    dto.setFecha_Nacimiento(fechaN);

                    mensaje = "<h1>BIENVENIDO (a) " + nombre + " " + apellido + ", A SHADIAGRAM </h1>"
                            + "</br></br><p style='font-size: 25px'>Estamos felices de que te hallas registrado en nuestra red social<br/>"
                            + "Esperamos que la pases super bien no olvides en recomendarnos con tus amigos."
                            + "<br/><br/><br/> Cualquier fallo de AngieGram no olvides en comunicarnos en nuestra cuentas oficiales.</p>"
                            + "<br/><br/><br/><p style='font-size: 22px; text-align: center'>Con gusto el Equipo de ShadiaGram.</p>";

                    mensaje2 = "<h1>Datos del Usuario Registrado</h1><p style='font-size: 25px'>"
                            + "<br/><strong>Nombre: </strong>" + dto.getNombre() + "<br/><strong>Apellido: </strong>"
                            + dto.getApellido() + "<br/><strong>Email: </strong>" + dto.getEmail() + "</p>";

                    email mailEnvio = new email();
                    if (mailEnvio.send("angiegram2019@gmail.com", "Angie2019Gram", dto.getEmail(), mensaje, "Contacto de Sergio Buitrago- Leyner")
                            && mailEnvio.send("angiegram2019@gmail.com", "Angie2019Gram", "sergiobuitrago54@gmail.com", mensaje2, "Se ha Registrado Un Usuario AngieGram")) {

                        Calendar c = Calendar.getInstance();
                        String dia = Integer.toString(c.get(Calendar.DATE));
                        String mes = Integer.toString(c.get(Calendar.MONTH) + 1);
                        String annio = Integer.toString(c.get(Calendar.YEAR));
                        int tmp = Integer.parseInt(mes);
                        mes = (tmp < 10) ? "0" + tmp : "" + tmp;
                        String fecha = annio + "-" + mes + "-" + dia;

                        dto.setFecha_Creacion(fecha);

                        dao.SaveUsuario(dto);
                        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                        inicio.setAttribute("usuario", usuario);
                        inicio.setAttribute("id", dto.getID());
                        inicio.setAttribute("user", dto);
                        String registro="Te has registrado correctamente, ahora inicia sesion :)";
                        inicio.setAttribute("mensaje", registro);
                        rd.forward(request, response);

                    } else {
                        request.setAttribute("mensaje2", "Error al verificar datos");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                }
                break;
            case "olvidoU":
                email = request.getParameter("emailU");
                password = request.getParameter("passwordU");

                usuario = dao.existeUserEmail(email, password);
                if (usuario != null) {
                    email mailEnvio = new email();
                    mensaje = "<h1>El Equipo de SHADIAGRAM, te recordamos que</h1>"
                            + "</br></br><p style='font-size: 25px'>Tu Usuario es:  " + usuario + " </p>";
                    if (mailEnvio.send("angiegram2019@gmail.com", "Angie2019Gram", email, mensaje, "Contacto de Sergio Buitrago- Leyner")) {
                        request.setAttribute("mensaje", "Te hemos enviado el usuario al correo electronico :), REVISELO");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensaje", ":( Error al mandar el correo electronico intenta de nuevo :)");
                        request.getRequestDispatcher("olvidoUsuario.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensaje", ":( Error de acceso, Email o Password incorrecto");
                    request.getRequestDispatcher("olvidoUsuario.jsp").forward(request, response);
                }
                break;
            case "olvidoP":
                usuario = request.getParameter("usuarioU");
                email = request.getParameter("emailU");
                password = request.getParameter("passwordU");

                if (dao.existeUsuario(usuario)) {
                    if (dao.concideEmailUsuario(usuario, email)) {
                        int id = dao.conocerID(usuario);
                        if (dao.cambiarPasswordID(id, password)) {

                            email mailEnvio = new email();
                            mensaje = "<h1>El Equipo de  SHADIAGRAM </h1>"
                                    + "</br></br><p style='font-size: 25px'>Te informa que has cambiar corectamente la contraseña :)</p>";

                            if (mailEnvio.send("angiegram2019@gmail.com", "Angie2019Gram", email, mensaje, "Contacto de Sergio Buitrago- Leyner")) {
                                request.setAttribute("mensaje", "Has moficiaco correctamente la contraseña ");
                                request.getRequestDispatcher("login.jsp").forward(request, response);
                            } else {
                                request.setAttribute("mensaje", ":( Error al mandar el correo electronico intenta de nuevo :)");
                                request.getRequestDispatcher("olvidoPassword.jsp").forward(request, response);
                            }
                        } else {
                            request.setAttribute("mensaje", ":( Error de acceso, Al cambiar la password intenta de nuevo");
                            request.getRequestDispatcher("olvidoPassword.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("mensaje", ":( Error de acceso, Email incorrecto");
                        request.getRequestDispatcher("olvidoPassword.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensaje", ":( Error de acceso, Usuario No Existe");
                    request.getRequestDispatcher("recuperar_password.jsp").forward(request, response);
                }
                break;
            default:
                break;
        }
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
