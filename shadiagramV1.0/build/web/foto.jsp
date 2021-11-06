<%-- 
    Document   : foto
    Created on : 5/05/2019, 06:40:00 PM
    Author     : Sergio Barrios
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${id>0 && user!=null}">
    <%@include file="template/header.jsp" %>
    <link rel="stylesheet" href="css/foto.css" type="text/css">
    <style>
        header{
            background: white;
        }
    </style>
    <div class="contenedorP">
        <div class="contenedor-publicacion">
            <div class="icon">
                <a href="inicio?accion=perfil&id=${infoF.getIdUser()}&user=${infoF.getUsuario()}">
                    <img src="fotos?accion=fotoPerfil&id=${infoF.getIdUser()}">
                    <h2>${infoF.getUsuario()}</h2>
                </a>      
            </div>    
            <div class="foto">
                <img src="fotos?accion=fotoAmigos&id=${infoF.getId()}">
                <p>Fecha publicación <span>${infoF.getFecha()}</span></p>
            </div>
            <div class="fechaP"> 
                <c:if test="${like==0}">
                    <a href="fotos?accion=abrirFoto&id=${infoF.getIdUser()}&idF=${infoF.getId()}&idU=${id}&accion2=like">
                       ${likes} <i class="far fa-heart"></i>
                    </a>
                </c:if>
                <c:if test="${like==1}">
                    <a href="fotos?accion=abrirFoto&id=${infoF.getIdUser()}&idF=${infoF.getId()}&idU=${id}&accion2=Nlike"
                       style="color: red">
                        ${likes}<i class="far fa-heart"></i>
                    </a>
                </c:if>

                <a href="" target="_blank" data-toggle="modal"  data-target="#exampleModalScrollable">
                    ${comentarios}<i class="fas fa-comment"></i>
                </a>
            </div>
        </div>
        <div class="comentarios">
            <h2>Comentarios: </h2>
            <jsp:useBean id="co" class="dao.ComentarioDAO" scope="page"></jsp:useBean>
            <c:set var="lista" scope="session" value="${co.comentariosFoto(infoF.getId())}"/>
            <c:if test="${lista.size()>0}">
                <c:forEach var="sig" items="${lista}">
                    <div class="comentariosU">
                        <div class="user">
                            <a href="inicio?accion=perfil&id=${sig.getIdUser()}&user=${sig.getUsuario()}">
                                <img src="fotos?accion=fotoPerfil&id=${sig.getIdUser()}">
                            </a>
                        </div>
                        <div class="descripcion">
                            ${sig.getDescripcion()}
                            </br><i>Fecha Publicacion ${sig.getFecha()}</i>
                        </div>
                    </div>    
                </c:forEach>
            </c:if>
            <c:if test="${lista.size()==0}">
                <div  class="alert alert-danger" style="font-size: 22px; margin-top: 40px">
                    <a  id="alerta3" href="" class="close" data-dismiss="alert">&times;</a>No hay Comentarios :(
                </div>
            </c:if>
        </div>
        <div class="modal fade" id="exampleModalScrollable" tabindex="-1" role="dialog"  
             aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header text-center" style="background: #1ab188; text-align: center">
                        <h5 class="modal-title" id="exampleModalScrollableTitle" style="color: white" >
                            Comentar Fotografia de ${infoF.getUsuario()}</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div id="alerta2" name="alerta2"></div>
                        <c:if test="${mensaje2!=null}">
                            <div  class="alert alert-danger">
                                <a  id="alerta3" href="" class="close" data-dismiss="alert">&times;</a>${mensaje2}
                            </div>
                        </c:if>  
                        <div class="contenedor-form">        
                            <form name="formComentario" class="text-center" action="operaciones?accion=comentar&id=${id}&idF=${infoF.getId()}" method="post">
                                <textarea id="descripcionU" name="descripcionU" placeholder="Deja tu comentario ${usuario}.."></textarea>
                                <input type="submit" value="subir" onclick="return validarComentario();">
                            </form>
                        </div>
                    </div>    
                </div>
            </div>
        </div>
    </div>
    <script src="js/validarFile.js" type="text/javascript"></script>
    <%@include file="template/footer.jsp" %>
</c:if>
<c:if test="${id==0 || user==null}">
    <%
        response.sendRedirect("inicio?accion=error");
    %>
</c:if>