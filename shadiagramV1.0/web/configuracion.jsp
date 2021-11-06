<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${id>0 && user!=null}">
    <%@include file="template/header.jsp" %>
    <link href="css/configuracion.css" rel="stylesheet" type="text/css">
    <style>
        header{
            background: white;
        }
    </style>
    <div class="contenedor-p">
        <div class="contenedor-info">
            <h1 class="text-center">Actualizar Información</h1>
            <div id="alerta" name="alerta"></div>
            <c:if test="${mensaje!=null}">
                <div  class="alert alert-danger">
                    <a  id="alerta3" href="" class="close" data-dismiss="alert">&times;</a>${mensaje}
                </div>
            </c:if>
            <form  name="formV" class="formulario" action="operaciones?accion=actualizarInfo&u=${usuario}" method="post">
                <label>Nombre</label>
                <input type="text" id="nombreU" name="nombreU" value="${user.getNombre()}">
                <label>Apellido</label>
                <input type="text" id="apellidoU" name="apellidoU" value="${user.getApellido()}">
                <label>Descripcion</label>
                <input type="text" id="descripcionU" name="descripcionU" value="${user.getDescripcion()}">
                <label>Telefono</label>
                <input type="text" id="telefonoU" name="telefonoU" value="${user.getTelefono()}">
                <label>Dirreccion</label>
                <input type="text" id="dirreccionU" name="dirreccionU" value="${user.getDireccion()}"> 
                <label>Usuario</label>
                <input type="text" id="usuarioU" name="usuarioU" value="${user.getUsuario()}">
                <label>Email</label>
                <input type="text" id="emailU" name="emailU" value="${user.getEmail()}">
                <label>Fecha Nacimiento: <span style="color: red">${user.getFecha_Nacimiento()}</span></label>
                <input type="date" id="fecha_NacimientoU" name="fecha_NacimientoU">
                <label>Fecha Creacion: <span style="color: red">${user.getFecha_Creacion()}</span></label>
                <label>Sexo</label>
                <input type="text" id="sexoU" name="sexoU" value="${user.getSexo()}">
                <input type="submit" value="Actualizar" onclick="return validarConfiguracion();">
            </form>
        </div>
        <div class="contenedor-img">
            <img src="fotos?accion=fotoPerfil&id=${id}">
            <div class="contenedor-form2">
                <h1 id="h1">Modificar Foto</h1>
                <form name="formFoto" action="operaciones?accion=cambiarFoto&u=${usuario}" method="post" class="formulario2" enctype="multipart/form-data">          
                    <div id="alerta2" name="alerta2"></div>
                    <c:if test="${mensaje2!=null}">
                        <div  class="alert alert-danger">
                            <a  id="alerta3" href="" class="close" data-dismiss="alert">&times;</a>${mensaje2}
                        </div>
                    </c:if>
                    <input type="file" id="fotoU" name="fotoU">
                    <input type="submit" value="Actualizar" onclick="return validarFile();">
                </form>
            </div>

            <div class="form3">
                <h1>Cambiar Contraseña</h1>
                <div id="alerta33" name="alerta33"></div>
                <c:if test="${mensaje3!=null}">
                    <div  class="alert alert-danger">
                        <a  id="alerta3" href="" class="close" data-dismiss="alert">&times;</a>${mensaje3}
                    </div>
                </c:if>

                <form name="formP" action="operaciones?accion=cambiarPassword&u=${usuario}" method="post">
                    <input type="password" placeholder="Digite Contraseña Anterior" id="passwordA" name="passwordA">
                    <input type="password" placeholder="Digite Contraseña Nueva" id="passwordN" name="passwordN">
                    <input type="submit" value="Cambiar" onclick="return validarPassword();">
                </form>
            </div>
        </div>
    </div>

    <%@include file="template/footer.jsp" %>
    <script src="js/validarFile.js" type="text/javascript"></script>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/validarForm.js" type="text/javascriptt"></script>
</c:if>
<c:if test="${id==0 || user==null}">
    <%
        response.sendRedirect("inicio?accion=error");
    %>
</c:if>

