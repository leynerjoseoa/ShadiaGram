<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <ul class="contenedor-tabs">
                <li class="tab tab-segunda active"><a href="#iniciar-sesion">Iniciar Sesión</a></li>
                <li class="tab tab-primera"><a href="#registrarse">Registrarse</a></li>
            </ul>
            <div class="contenido-tab" name="div">
                <div id="alerta2" name="alerta2"></div>
                <c:if test="${mensaje!=null}">
                    <div  class="alert alert-danger"><a  id="alerta3" href="" class="close" data-dismiss="alert">&times;</a>${mensaje}</div>
                </c:if>

                <div id="iniciar-sesion">
                    <h1>Iniciar Sesión</h1>
                    <form name="addForm2" action="login?accion=login" method="post" >
                        <div class="contenedor-input">
                            <label>  &#128247 | Usuario <span class="req">*</span>  </label>
                            <input type="text" id="usuarioU" nombre="usuarioU" name="usuarioU">
                        </div>
                        <div class="contenedor-input">
                            <label>  &#128272 | Contraseña <span class="req">*</span> </label>
                            <input type="password" id="passwordU" password="passwordU" name="passwordU">
                        </div>
                        <p class="forgot"><a href="olvidoPassword.jsp" >Se te olvidó la contraseña?</a>
                        </p>
                        <p class="forgot"><a href="olvidoUsuario.jsp">Se te olvidó el usuario?</a></p>
                        <input type="submit" onclick="return validarForm2();" class="button button-block" value="Iniciar Sesión">                                              
                    </form>
                </div>
                    
                <div id="registrarse">
                    <div id="alerta" name="alerta"></div>
                    <c:if test="${mensaje2!=null}">
                        <div  class="alert alert-danger">  <a href="" class="close" data-dismiss="alert">&times;</a>${mensaje2} </div> 
                    </c:if>
                    <h1>Registrarse</h1>
                    <form name="addForm" action="login?accion=registro" method="post" >
                        <div class="fila-arriba">
                            <div class="contenedor-input">
                                <label>Nombre<span class="req">*</span></label>
                                <input type="text" id="nombreU" name="nombreU" >
                            </div>
                            <div class="contenedor-input">
                                <label>Apellido </label>
                                <input type="text" id="apellidoU" name="apellidoU">
                            </div>
                        </div>
                        <div class="contenedor-input">
                            <label>Usuario <span class="req">*</span> </label>
                            <input type="text" id="usuarioU" name="usuarioU">
                        </div>
                        <div class="contenedor-input">
                            <label> Email <span class="req">*</span>  </label>
                            <input type="text" id="emailU" name="emailU">
                        </div>
                        <div class="contenedor-input">
                            <label>Contraseña <span class="req">*</span>  </label>
                            <input type="password" id="passwordU" name="passwordU">
                        </div>
                        <div class="contenedor-input">
                            <label>Repetir Contraseña <span class="req">*</span> </label>
                            <input type="password" id="repetir">
                        </div>
                        <div class="contenedor-input">
                            <p id="fechaS">Fecha Nacimiento <span class="req">*</span></p>
                            <input id="date" type="date" id="fecha_NacimientoU" name="fecha_NacimientoU">
                        </div>                        
                        <div class="contenedor-input res">
                            <p id="terminos"> Haciendo click en <em>Registrase</em> Acepta los 
                                <a href="" target="_blank" data-toggle="modal"  data-target="#exampleModalScrollable">
                                    Terminos y Condiciones del servicio</a>
                            </p>                                                                      
                        </div>
                        <input type="submit" onclick="return validarForm();" class="button button-block" value="Registrarse">

                        <div class="modal fade" id="exampleModalScrollable" tabindex="-1" role="dialog" 
                             aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-scrollable" role="document">
                                <div class="modal-content">
                                    <div class="modal-header text-center" style="background: #1ab188; text-align: center">
                                        <h5 class="modal-title" id="exampleModalScrollableTitle" style="color: white" >Terminos
                                            y condiciones</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        Aceptamos proporcionarte el Servicio de AngieGram, que incluye
                                        todos los productos, las funciones, las aplicaciones, los
                                        servicios, las tecnologías y el software que ofrecemos para cumplir
                                        la misión de AngieGram: acercarte a las personas y cosas que te
                                        encantan. El Servicio se compone de los siguientes aspectos (el
                                        "Servicio"):
                                        <ul style="list-style: none; padding-top: 15px">
                                            <li><span class="font-weight-bolder text-center">Ofrecer
                                                    oportunidades personalizadas para crear, conectar, comunicar,
                                                    descubrir y compartir.</span></br></br> Cada persona es distinta. Queremos
                                                fortalecer las relaciones por medio de experiencias compartidas
                                                que realmente te interesen. Por lo tanto, creamos sistemas que
                                                intentan entender quiénes o qué cosas te interesan y les
                                                interesan a los demás, y usamos esa información para ayudarte a
                                                crear, encontrar, unir y compartir experiencias que te resulten
                                                relevantes. Parte de esto consiste en destacar el contenido, las
                                                funciones, las ofertas y las cuentas que te pueden interesar, y
                                                ofrecerte formas de experimentar Instagram en función de lo que
                                                tú y otras personas hacen tanto dentro como fuera de Instagram.</li>
                                            <li style="padding-top: 15px"><span class="font-weight-bolder text-center">Fomentar un
                                                    ambiente positivo, inclusivo y seguro.</span></br></br> Desarrollamos y usamos
                                                herramientas, y ofrecemos recursos a los miembros de nuestra
                                                comunidad que contribuyen a que estos vivan experiencias
                                                positivas e inclusivas, incluso cuando creemos que pueden
                                                necesitar ayuda. También contamos con equipos y sistemas cuyo
                                                trabajo es combatir el abuso y las violaciones de nuestras
                                                Condiciones y políticas, así como combatir comportamientos
                                                perjudiciales y engañosos. Usamos toda la información que
                                                tenemos, incluida la tuya, para proteger nuestra plataforma.
                                                Asimismo, es posible que compartamos información sobre usos
                                                indebidos o contenido perjudicial con otras empresas de Facebook
                                                o con las fuerzas del orden. Obtén más información en la Política
                                                de datos.</li>
                                            <li style="padding-top: 15px"><span class="font-weight-bolder text-center">Desarrollar y
                                                    usar tecnologías que nos ayuden a respaldar continuamente a
                                                    nuestra comunidad en constante crecimiento.</span> </br></br>Organizar y analizar
                                                información de nuestra creciente comunidad es central para
                                                nuestro Servicio. Gran parte de nuestro Servicio consiste en
                                                crear y usar tecnologías de vanguardia que nos ayuden a
                                                personalizar, proteger y mejorar nuestro Servicio a gran escala
                                                para una amplia comunidad internacional. Tecnologías como la
                                                inteligencia artificial y el aprendizaje automático nos dan el
                                                poder de aplicar procesos complejos en todo nuestro Servicio. Las
                                                tecnologías automatizadas también nos permiten garantizar la
                                                funcionalidad y la integridad de nuestro Servicio.</li>
                                        </ul>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" 
                                                data-dismiss="modal" style="background: #1ab188">Cerrar
                                        </button>
                                        <button type="button" class="btn btn-primary" name="aceptoTerminos" 
                                                data-dismiss="modal" style="background: #1ab188"> Aceptar
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
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
