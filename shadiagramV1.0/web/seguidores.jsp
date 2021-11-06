<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>

<c:if test="${id>0 && user!=null}">
    <%@include file="template/header.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="css/siguiendo.css" rel="stylesheet" type="text/css">
    <style>
        header{
            background: white;
        }
    </style>
    <div class="centro"> 
        <h1>Seguidores</h1>
        <jsp:useBean id="cd" class="dao.AmistadDAO" scope="page"></jsp:useBean>
        <c:set var="lista" scope="session" value="${cd.seguidoresUsuario(user.getID())}"/>  
        <div class="contenedor">      
            <c:if test="${lista.size()>0}">
                <c:forEach var="mm" items="${lista}">
                    <c:set var = "mostrarU" scope = "session" value = "${cd.usuario(mm.getIdSeguidor())}"/>   
                    <div class="contenedor-img">                  
                        <a href="inicio?accion=perfil&id=${mostrarU.getID()}&user=${mostrarU.getUsuario()}">
                            <img src="fotos?accion=fotoPerfil&id=${mostrarU.getID()}">
                            <h2 >${mostrarU.getNombre()} ${mostrarU.getApellido()}</h2> 
                        </a>
                    </div> 
                </c:forEach>   
            </c:if>

            <c:if test="${lista.size()==0}">
                <div  class="alert alert-danger" style="font-size: 22px; margin-top: 30px;margin-bottom: 390px">
                    <a  id="alerta3" href="" class="close" data-dismiss="alert">&times;</a>No Sigues a Nadie
                </div>
            </c:if>
        </div>
    </div>  
    <%@include file="template/footer.jsp" %>
</c:if>
<c:if test="${id==0 || user==null}">
    <%
        response.sendRedirect("inicio?accion=error");
    %>
</c:if>
