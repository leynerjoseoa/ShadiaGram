package control;

import Task.email.email;
import dao.AmistadDAO;
import dao.ComentarioDAO;
import dao.FotoDAO;
import dao.LikeDAO;
import dao.UsuarioDAO;
import entity.ComentarioDTO;
import entity.FotoDTO;
import entity.LikeDTO;
import entity.UsuarioDTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "operacionesController", urlPatterns = {"/operaciones"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class operacionesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        String nombre, apellido, descripcion, telefono, direccion, email, sexo, fechaNacimiento;

        FotoDAO dao = new FotoDAO();
        FotoDTO dto = new FotoDTO();
        UsuarioDAO daoU = new UsuarioDAO();
        AmistadDAO daoA = new AmistadDAO();
        ComentarioDAO daoC = new ComentarioDAO();
        ComentarioDTO dtoC = new ComentarioDTO();
        InputStream inputStream = null;

        Calendar c = Calendar.getInstance();
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH) + 1);
        String annio = Integer.toString(c.get(Calendar.YEAR));
        int tmp = Integer.parseInt(mes);
        mes = (tmp < 10) ? "0" + tmp : "" + tmp;
        String fecha = annio + "-" + mes + "-" + dia;

        HttpSession inicio = request.getSession(true);

        switch (accion) {
            case "subirFoto":
                int idU = Integer.parseInt(request.getParameter("id"));
                descripcion = request.getParameter("descripcionU");
                int publicaciones = dao.publicacioneID(idU);

                dto.setIdUser(idU);
                dto.setFecha(fecha);
                dto.setDescripcion(descripcion);

                try {
                    Part filePart = request.getPart("fotoU");
                    System.out.println("" + filePart);
                    if (filePart.getSize() > 0) {
                        System.out.println(filePart.getName());
                        System.out.println(filePart.getSize());
                        System.out.println(filePart.getContentType());
                        inputStream = filePart.getInputStream();
                    }
                } catch (Exception ex) {
                    System.out.println("fichero: " + ex.getMessage());
                    request.setAttribute("mensaje2", "Error al procesar la imagen");
                    request.getRequestDispatcher("perfil.jsp").forward(request, response);
                }

                try {
                    if (inputStream != null) {
                        dao.savePhoto(dto, inputStream);
                        List<FotoDTO> lista = dao.Listar_FotoID(idU);

                        RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
                        inicio.setAttribute("fotosS", lista);
                        inicio.setAttribute("publicaciones", publicaciones);
                        rd.forward(request, response);
                    }
                } catch (Exception ex) {
                    System.out.println("textos: " + ex.getMessage());
                    request.setAttribute("mensaje2", "Imagen muy grande intenta con otra");
                    request.getRequestDispatcher("perfil.jsp").forward(request, response);
                }
                break;
            case "actualizarInfo":
                String user = request.getParameter("u");

                nombre = request.getParameter("nombreU");
                apellido = request.getParameter("apellidoU");
                descripcion = request.getParameter("descripcionU");
                telefono = request.getParameter("telefonoU");
                direccion = request.getParameter("dirreccionU");
                String usuario = request.getParameter("usuarioU");
                email = request.getParameter("emailU");
                fechaNacimiento = request.getParameter("fecha_NacimientoU");
                sexo = request.getParameter("sexoU");

                UsuarioDTO u = new UsuarioDTO();
                u.setNombre(nombre);
                u.setApellido(apellido);
                u.setDescripcion(descripcion);
                u.setTelefono(telefono);
                u.setDireccion(direccion);
                u.setUsuario(usuario);
                u.setEmail(email);
                u.setFecha_Nacimiento(fechaNacimiento);
                u.setSexo(sexo);

                UsuarioDTO comparar = daoU.conocerUsuario(user);

                boolean entrar = false;
                if (!comparar.getUsuario().equalsIgnoreCase(usuario)) {
                    if (daoU.existeUser(usuario)) {
                        entrar = false;
                        request.setAttribute("mensaje", "Error, Usuario ya REGISTRADO");
                        request.getRequestDispatcher("configuracion.jsp").forward(request, response);
                    } else {
                        entrar = true;
                    }
                } else if (!comparar.getEmail().equalsIgnoreCase(email)) {
                    if (daoU.existeEmail(email)) {
                        entrar = false;
                        request.setAttribute("mensaje", "Error, Email ya REGISTRADO");
                        request.getRequestDispatcher("configuracion.jsp").forward(request, response);
                    } else {
                        entrar = true;
                    }
                } else {
                    entrar = true;
                }

                if (entrar) {

                    if (daoU.ModificarUsuario(user, u)) {

                        String m1 = "<h1>Hola (a) " + u.getNombre() + " " + u.getApellido() + ",  El equipo de ANGIEGRAM </h1>"
                                + "</br></br><p style='font-size: 25px'>te informa que has modificado tus datos personales correctamente<br/>";
                        email mailEnvio = new email();
                        u = daoU.conocerUsuario(usuario);

                        if (mailEnvio.send("angiegram2019@gmail.com", "Angie2019Gram", u.getEmail(), m1, "Contacto de Sergio Buitrago- Leinner")) {
                            RequestDispatcher rd = request.getRequestDispatcher("configuracion.jsp");
                            inicio.setAttribute("usuario", u.getUsuario());
                            inicio.setAttribute("id", u.getID());
                            inicio.setAttribute("user", u);
                            rd.forward(request, response);
                        } else {
                            request.setAttribute("mensaje", "Error, Interno verifica el correo electronico que sea gmail");
                            request.getRequestDispatcher("configuracion.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("mensaje", "Error, Interno vuelva a intentar");
                        request.getRequestDispatcher("configuracion.jsp").forward(request, response);
                    }
                }
                break;
            case "cambiarFoto":
                usuario = request.getParameter("u");
                try {
                    Part filePart = request.getPart("fotoU");
                    System.out.println("" + filePart);
                    if (filePart.getSize() > 0) {
                        System.out.println(filePart.getName());
                        System.out.println(filePart.getSize());
                        System.out.println(filePart.getContentType());
                        inputStream = filePart.getInputStream();
                    }
                } catch (Exception ex) {
                    System.out.println("fichero: " + ex.getMessage());
                    request.setAttribute("mensaje2", "Imagen muy grande intenta con otra");
                    request.getRequestDispatcher("configuracion.jsp").forward(request, response);
                }

                try {
                    if (inputStream != null) {
                        daoU.savePhoto(inputStream, usuario);
                        RequestDispatcher rd = request.getRequestDispatcher("configuracion.jsp");
                        rd.forward(request, response);
                    }
                } catch (Exception ex) {
                    System.out.println("textos: " + ex.getMessage());
                    request.setAttribute("mensaje2", "Imagen muy grande intenta con otra");
                    request.getRequestDispatcher("configuracion.jsp").forward(request, response);
                }
                break;
            case "cambiarPassword":
                usuario = request.getParameter("u");
                String anterior = request.getParameter("passwordA");
                String nueva = request.getParameter("passwordN");

                u = daoU.conocerUsuario(usuario);
                if (u.getPassword().equals(anterior)) {
                    if (!u.getPassword().equals(nueva)) {
                        if (daoU.cambiarPassword(usuario, anterior, nueva)) {

                            u = daoU.conocerUsuario(usuario);
                            email mailEnvio = new email();

                            String m1 = "<h1>Hola (a) " + u.getNombre() + " " + u.getApellido() + ",  El equipo de ANGIEGRAM </h1>"
                                    + "</br></br><p style='font-size: 25px'>te informa que has modificado tu contrasela correctamente<br/>";

                            if (mailEnvio.send("angiegram2019@gmail.com", "Angie2019Gram", u.getEmail(), m1, "Contacto de Sergio Buitrago- Leinner")) {
                                RequestDispatcher rd = request.getRequestDispatcher("configuracion.jsp");
                                inicio.setAttribute("usuario", u.getUsuario());
                                inicio.setAttribute("id", u.getID());
                                inicio.setAttribute("user", u);
                                rd.forward(request, response);
                            } else {
                                request.setAttribute("mensaje3", "Error al cambiar contraseña");
                                request.getRequestDispatcher("configuracion.jsp").forward(request, response);
                            }
                        } else {
                            request.setAttribute("mensaje3", "Error al cambiar contraseña, verifica correo electronico sea gmail");
                            request.getRequestDispatcher("configuracion.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("mensaje3", "La contraseña no deben ser iguales cambiela :)");
                        request.getRequestDispatcher("configuracion.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensaje3", "La contraseña anterior incorrecta");
                    request.getRequestDispatcher("configuracion.jsp").forward(request, response);
                }
                break;
            case "comentar":
                int idUU = Integer.parseInt(request.getParameter("id"));
                int idFF = Integer.parseInt(request.getParameter("idF"));
                String comentario = request.getParameter("descripcionU");
                

                int comentarios=daoC.cantidadComentarios(idFF); 
                
                dtoC = new ComentarioDTO();
                dtoC.setIdUser(idUU);
                dtoC.setIdFoto(idFF);
                dtoC.setDescripcion(comentario);

                daoC.saveComentario(dtoC);

                dto = dao.informacionFoto(idFF);
                String usuarios = daoA.usuarioID(dto.getIdUser());
                UsuarioDTO dtoU = daoU.conocerUsuario(usuarios);

                RequestDispatcher rd = request.getRequestDispatcher("foto.jsp");
                inicio.setAttribute("infoF", dto);
                inicio.setAttribute("user", dtoU);
                inicio.setAttribute("comentarios", comentarios);
                rd.forward(request, response);
                break;        
            default:
                break;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
