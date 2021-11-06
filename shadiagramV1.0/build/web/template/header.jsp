<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/template.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    </head>
    <body>
        <header>
            <div class="menu_bar">
                <a href="#" class="bt-menu"><i class="fas fa-bars"></i>Menu</a>
            </div>
            <nav>
                <ul>
                    <li><a href="inicio?accion=inicio&id=${id}" id="logoE">
                            <img src="img/portada.png" id="logo">
                        </a>
                    </li>
                    <li class="mover"><a href="inicio?accion=perfil&id=${id}&user=${usuario}">
                            <img src="img/iconos/usuario.png">
                            <i> Perfil ( @${usuario} )</i>
                        </a>
                    </li>
                    <li class="mover">
                        <a href="#" target="_blank" data-toggle="modal"  
                           data-target="#exampleModalScrollable2" 
                           data-dismiss="modal">
                            <img src="img/iconos/buscar.png">
                            <i> Buscar</i>
                        </a>
                    </li>
                    <li class="mover">
                        <a href="inicio?accion=configuracion&usuario=${usuario}">
                            <img src="img/iconos/configuracion.png">
                            <i> Configuración</i>
                        </a>
                    </li>
                    <li class="mover"> 
                        <a href="inicio?accion=cerrar">
                            <img src="img/iconos/salir.png">
                            <i> Cerrar Sesion</i>
                        </a>
                    </li>
                </ul>
            </nav>
        </header>
        <div class="modal fade" id="exampleModalScrollable2" tabindex="-2" role="dialog" 
             aria-labelledby="exampleModalScro" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header"  class="text-center" style="background: #1ab188; text-align: center">
                        <div class="container">
                            <div class="d-flex justify-content-center">
                                <div class="searchbar">
                                    <input id="searchTerm" class="search_input" type="text" name=""onkeyup="doSearch()" placeholder="Buscar...">
                                    <a href="#" class="search_icon"><i class="fas fa-search"></i></a>
                                </div>
                            </div>
                        </div>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <table id="datos">
                            <thead>
                            <th></th>
                            </thead>
                            <tbody>
                                <jsp:useBean id="ono" class="dao.AmistadDAO" scope="page"></jsp:useBean>
                            <c:set var="idd" scope="session" value="${id}"/>
                            <c:set var = "lista" scope = "session" value = "${ono.listarUsuarios()}"/>  
                            <c:forEach var="m" items="${lista}">
                                <tr>
                                    <td> 
                                        <h1 style="display:none"> ${m.getNombre()} ${m.getApellido()} </h1>
                                        <div class="imagen">
                                            <a href="inicio?accion=perfilA&id=${id}&idU=${m.getID()}&user=${m.getUsuario()}">
                                                <img src="fotos?accion=fotoPerfil&id=${m.getID()}"> 
                                            </a>
                                        </div>
                                    </td>
                                    <td> 
                                        <h2 >${m.getNombre()} ${m.getApellido()}</h2>
                                        <h2 style="display: none">${m.getUsuario()}</h2>
                                        <h2 style="display: none">${ m.getNombre()}}</h2>
                                    </td>
                                </tr>
                            </c:forEach>        
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>


