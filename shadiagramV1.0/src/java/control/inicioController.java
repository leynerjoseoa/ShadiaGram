package control;

import dao.FotoDAO;
import dao.AmistadDAO;
import dao.UsuarioDAO;
import entity.AmistadDTO;
import entity.FotoDTO;
import entity.UsuarioDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "inicioController", urlPatterns = {"/inicio"})
public class inicioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        int id;
        String usuario = null;
        int publicaciones, siguiendo, seguidores;

        UsuarioDAO dao = new UsuarioDAO();
        UsuarioDTO dto = new UsuarioDTO();
        FotoDAO daoF = new FotoDAO();
        FotoDTO dtoF = new FotoDTO();
        AmistadDAO daoA = new AmistadDAO();
        AmistadDTO dtoA = new AmistadDTO();

        HttpSession inicio = request.getSession(true);

        switch (accion) {
            case "inicio":
                id = Integer.parseInt(request.getParameter("id"));
                List<FotoDTO> fotos = daoF.publicacionesAmigos(id);

                RequestDispatcher rdd = request.getRequestDispatcher("inicio.jsp");
                inicio.setAttribute("publicacionesA", fotos);
                rdd.forward(request, response);
                break;
            case "perfil":

                id = Integer.parseInt(request.getParameter("id"));
                usuario = request.getParameter("user");

                publicaciones = daoF.publicacioneID(id);
                siguiendo = daoA.siguiendoID(id);
                seguidores = daoA.seguidoresID(id);

                List<FotoDTO> list = daoF.Listar_FotoID(id);

                dto = dao.conocerUsuario(usuario);

                RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
                inicio.setAttribute("fotosS", list);
                inicio.setAttribute("user", dto);
                inicio.setAttribute("publicaciones", publicaciones);
                inicio.setAttribute("siguiendo", siguiendo);
                inicio.setAttribute("seguidores", seguidores);
                rd.forward(request, response);
                break;
            case "perfilA":
                id = Integer.parseInt(request.getParameter("id"));
                int idU= Integer.parseInt(request.getParameter("idU"));
                usuario = request.getParameter("user");
                
                int valor=daoA.sigoUsuario(id, idU);
                
                publicaciones = daoF.publicacioneID(idU);
                siguiendo = daoA.siguiendoID(idU);
                seguidores = daoA.seguidoresID(idU);

                List<FotoDTO> lists = daoF.Listar_FotoID(idU);

                dto = dao.conocerUsuario(usuario);

                RequestDispatcher rs = request.getRequestDispatcher("perfil.jsp");
                inicio.setAttribute("fotosS", lists);
                inicio.setAttribute("user", dto);
                inicio.setAttribute("publicaciones", publicaciones);
                inicio.setAttribute("siguiendo", siguiendo);
                inicio.setAttribute("seguidores", seguidores);
                inicio.setAttribute("seguir", valor);
              
                rs.forward(request, response);
                break;
            case "configuracion":
                UsuarioDAO daoU = new UsuarioDAO();
                UsuarioDTO dtoU = daoU.conocerUsuario(request.getParameter("usuario"));

                RequestDispatcher rds = request.getRequestDispatcher("configuracion.jsp");
                inicio.setAttribute("user", dtoU);
                inicio.removeAttribute("mensaje");
                rds.forward(request, response);
                break;
            case "cerrar":
                RequestDispatcher salir = request.getRequestDispatcher("login.jsp");
                inicio.removeAttribute("usuario");
                inicio.removeAttribute("id");
                inicio.removeAttribute("user");
                inicio.removeAttribute("fotosS");
                inicio.removeAttribute("publicaciones");
                inicio.removeAttribute("publicacionesA");
                inicio.removeAttribute("siguiendo");
                inicio.removeAttribute("seguidores");
                inicio.removeAttribute("infoF");
                inicio.removeAttribute("likes");
                inicio.removeAttribute("like");
                inicio.removeAttribute("comentarios");
                salir.forward(request, response);
                break;
            case "error":
                String error = "Debes Iniciar Sesion";
                inicio.setAttribute("mensaje", error);
                RequestDispatcher e = request.getRequestDispatcher("login.jsp");
                e.forward(request, response);
                break;
            default:
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
