package control;

import dao.FotoDAO;
import dao.AmistadDAO;
import dao.ComentarioDAO;
import dao.LikeDAO;
import dao.UsuarioDAO;
import entity.AmistadDTO;
import entity.FotoDTO;
import entity.LikeDTO;
import entity.UsuarioDTO;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "fotosController", urlPatterns = {"/fotos"})
public class fotosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/png");

        String accion = request.getParameter("accion");
        int idU, idF;
        FotoDAO dao = new FotoDAO();
        FotoDTO dto = new FotoDTO();
        UsuarioDAO daoU = new UsuarioDAO();
        ComentarioDAO daoC= new ComentarioDAO();

        HttpSession inicio = request.getSession(true);

        switch (accion) {
            case "fotoPerfil":
                idF = Integer.parseInt(request.getParameter("id"));
                response.getOutputStream().write(dao.mostrarFoto(idF));
                break;
            case "fotoAmigos":
                idF = Integer.parseInt(request.getParameter("id"));
                response.getOutputStream().write(dao.mostrarFotoAmigos(idF));
                break;
            case "abrirFoto":
                idF = Integer.parseInt(request.getParameter("idF"));
                idU = Integer.parseInt(request.getParameter("idU"));
                String accion2 = request.getParameter("accion2");
                
                LikeDTO like = new LikeDTO();
                LikeDAO daoL = new LikeDAO();
                
                dto = dao.informacionFoto(idF);
                int comentario=daoC.cantidadComentarios(idF);
                int likesF=daoL.cantidadLikes(idF);

                

                Calendar c = Calendar.getInstance();
                String dia = Integer.toString(c.get(Calendar.DATE));
                String mes = Integer.toString(c.get(Calendar.MONTH) + 1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                int tmp = Integer.parseInt(mes);
                mes = (tmp < 10) ? "0" + tmp : "" + tmp;
                String fecha = annio + "-" + mes + "-" + dia;

                AmistadDAO sdao = new AmistadDAO();
                String usuario = sdao.usuarioID(dto.getIdUser());
                UsuarioDTO dtoU = daoU.conocerUsuario(usuario);

                RequestDispatcher rd = request.getRequestDispatcher("foto.jsp");
                inicio.setAttribute("infoF", dto);
                inicio.setAttribute("user", dtoU);
                inicio.setAttribute("likes", likesF);
                inicio.setAttribute("comentarios", comentario);

                int valor = 0;
                int respuest=daoL.existeLike(idF, idU);
                inicio.setAttribute("like",respuest);
                if ( respuest== 0) {
                    like.setFecha(fecha);
                    like.setIdFoto(idF);
                    like.setIdUsuario(idU);
                    if (accion2.equalsIgnoreCase("like")) {
                        daoL.saveLike(like);
                        valor = 1;
                        inicio.setAttribute("like", valor);
                    }
                } else {
                    if (accion2.equalsIgnoreCase("Nlike")) {
                        daoL.desLike(idU, idF);
                        inicio.setAttribute("like",valor);
                    }    
                }
                rd.forward(request, response);
                break;
            case "segui":
                int id = Integer.parseInt(request.getParameter("id"));
                idU = Integer.parseInt(request.getParameter("idU"));
                String accion3= request.getParameter("accion2");
                
                AmistadDAO daoA= new AmistadDAO();
                AmistadDTO dtoA= new AmistadDTO();
                 RequestDispatcher rs = request.getRequestDispatcher("perfil.jsp");
                int valor2 = 0;
                int respuest2=daoA.sigoUsuario(id,idU);
                inicio.setAttribute("seguir",respuest2);
                if ( respuest2== 0) {
                    inicio.setAttribute("seguir", respuest2);
                    if (accion3.equalsIgnoreCase("seguir")) {
                        daoA.seguirUsuario(id, idU);
                        valor2 = 1;
                        inicio.setAttribute("seguir", valor2);
                    }
                } else {
                    if (accion3.equalsIgnoreCase("Nseguir")) {
                        daoA.dejarSeguir(id, idU);
                        inicio.setAttribute("seguir",valor2);
                    }    
                }
                rs.forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
