<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">  
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Raleway|Ubuntu" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/login.css">
        <title>ShadiaGram |LOGIN</title>
    </head>
    <body>
        <div class="contenedor-formularios">
            <div class="contenedor-logo text-center"><img src="img/logo.png"></div>
            <div class="contenido-tab" name="div">
                <div id="h1"><h1 class="text-center">Recuperar Password</h1></div>
                <div id="alerta"></div>
                <c:if test="${mensaje!=null}">
                    <div  class="alert alert-danger"><a  id="alerta3" href="" class="close" data-dismiss="alert">&times;</a>${mensaje}</div>
                </c:if>
                <form name="addForm" action="login?accion=olvidoP" method="post">
                    <div class="contenedor-input">
                        <label>Usuario <span class="req">*</span> </label>
                        <input type="text" id="usuarioU" name="usuarioU">
                    </div>
                    <div class="contenedor-input">
                        <label> Email <span class="req">*</span>  </label>
                        <input type="text" id="emailU" name="emailU">
                    </div>
                    <div class="contenedor-input">
                        <label> Contraseña Nueva <span class="req">*</span>  </label>
                        <input type="password" id="passwordU" name="passwordU">
                    </div>
                    <div class="forgot"><a href="login.jsp" class="enlace">Iniciar Sesion</a></div>
                    <input type="submit" onclick="return validarEmail();" class="button button-block" value="Enviar">
                </form>
            </div>
        </div>
        <footer class="rounded-top text-center">
            <div class="container py-2"> 
                <p class="text-white my-2">Sergio Buitrago - Leinner - V1.0</p> 
            </div>
        </footer>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/validarForm.js"></script>
        <script type="text/javascript" src="js/main-login.js"></script>
    </body>
</html>