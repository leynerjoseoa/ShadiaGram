<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>

<c:if test="${id>0 && user!=null}">

    <%@include file="template/header.jsp" %>
    <link type="text/css" href="css/perfil.css" rel="stylesheet">
    <style>
        header{
            background: white;
        }
    </style>

    <div class="contenedor-perfil" >
        <div class="contenedor-arriba">
            <a href="inicio?accion=perfil&id=${user.getID()}&user=${user.getUsuario()}">
                <img src="fotos?accion=fotoPerfil&id=${user.getID()}">
            </a>
            <div class="descripcion">
                <h1>Información</h1>
                <p id="usuario">${user.getUsuario()}</p>
                <p id="descripcion">${user.getDescripcion()}</p>
            </div> 
        </div> 
        <div class="contenedor-navegacion">
            <nav class="mostrar-nav">
                <ul>
                    <li><a style="color:white; cursor: pointer"> 
                            <i>${publicaciones } </i> Publicaciones
                        </a>
                    </li>
                    <li>
                        <a href="seguidores.jsp"> 
                            <i>${seguidores } </i> Seguidores
                        </a>
                    </li>
                    <li id="bajar">
                        <a href="siguiendo.jsp"> 
                            <i>${siguiendo } </i>Siguiendo
                        </a>
                    </li>
                </ul>
            </nav> 
        </div>
        <c:if test="${user.getID()!=id}">
            <c:if test="${seguir==0}">
                <a href="fotos?accion=segui&id=${id}&idU=${user.getID()}&accion2=seguir" class="botonS">
                    <input type="submit" value="Seguir">
                </a>
            </c:if>
            <c:if test="${seguir==1}">
                <a href="fotos?accion=segui&id=${id}&idU=${user.getID()}&accion2=Nseguir" class="botonS">
                    <input type="submit" value="Dejar Seguir">
                </a>
            </c:if> 
        </c:if>
        <c:if test="${user.getID()==id}">
            <div class="botonC">
                <a class="subirPhoto" href="" target="_blank" data-toggle="modal"  data-target="#exampleModalScrollable">
                    <i class="fas fa-camera"></i>
                </a>
            </div>
            <div class="modal fade" id="exampleModalScrollable" tabindex="-1" role="dialog"  aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-scrollable" role="document">
                    <div class="modal-content">
                        <div class="modal-header text-center" style="background: #1ab188; text-align: center">
                            <h5 class="modal-title" id="exampleModalScrollableTitle" style="color: white" >Subir Fotografia</h5>
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
                                <form name="formFoto" class="text-center" action="operaciones?accion=subirFoto&id=${user.getID()}"  method="post" enctype="multipart/form-data">
                                    <input type="file" id="fotoU" name="fotoU">
                                    <textarea id="descripcionU" name="descripcionU" placeholder="Describate">      
                                    </textarea>
                                    <input type="submit" value="subir" onclick="return validarFile();">
                                </form>
                            </div>
                        </div>    
                    </div>
                </div>
            </div>
        </c:if> 
    </div>
    <div class="divi">
        <h2>Fotos Subidas</h2>
    </div>
    <div class="contenedor-photo">
        <div class="photo">
            <c:if test="${fotosS!=null}">
                <c:forEach var="foto" items="${fotosS}">
                    <div class="contenedor-result-img">
                        <a href="fotos?accion=abrirFoto&idU=${foto.getIdUser()}&idF=${foto.getId()}&accion2=n">
                            <img src="fotos?accion=fotoAmigos&id=${foto.getId()}">
                        </a>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${fotosS.size()==0}">
                <div  class="alert alert-danger text-center" style="margin-top: 100px; margin-bottom: 100px;">
                    <a  id="alerta" href="" class="close" data-dismiss="alert">&times;</a> No hay publicaciones :(
                </div>
            </c:if>
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