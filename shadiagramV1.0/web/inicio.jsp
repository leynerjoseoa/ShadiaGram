<%-- 
    Document   : inicio
    Created on : 5/05/2019, 06:24:01 PM
    Author     : Sergio Barrios
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${id>0 && user!=null}">

    <%@include file="template/header.jsp" %>
    <link href="css/inicio.css" type="text/css" rel="stylesheet">
    <style>
        header{
            background: white;
        }
    </style>
    <div class="contenedor-user">    
        <c:if test="${publicacionesA!=null}">
            
            <c:forEach var="fotoA" items="${publicacionesA}">
                
                <div class="publicaciones">
                    <div class="enlaces">
                        <a href="inicio?accion=perfilA&id=${id}&idU=${fotoA.getIdUser()}&user=${fotoA.getUsuario()}">
                            <p><img  id="img" src="fotos?accion=fotoPerfil&id=${fotoA.getIdUser()}">
                                ${fotoA.getUsuario()}</p>
                        </a>
                    </div>
                    <div class="fotos">
                        <a href="fotos?accion=abrirFoto&id=${fotoA.getIdUser()}&idF=${fotoA.getId()}&idU=${user.getID()}&accion2=n">
                            <img src="fotos?accion=fotoAmigos&id=${fotoA.getId()}"> </a>                 
                        <p class="text-center" id="descripcion">${fotoA.getDescripcion()}</p>
                    </div>
                </div>   
                    
            </c:forEach> 
            
        </c:if>
        <c:if test="${publicacionesA.size()==0}">
            <div  class="alert alert-danger" style="font-size: 22px; margin-top: 30px;margin-bottom: 390px">
                <a  id="alerta3" href="" class="close" data-dismiss="alert">&times;</a>No hay publicaciones de Amigos
            </div>
        </c:if>
    </div>
    <%@include file="template/footer.jsp" %>
</c:if>
<c:if test="${id==0 || user==null}">
    <%
        response.sendRedirect("inicio?accion=error");
    %>
</c:if>

