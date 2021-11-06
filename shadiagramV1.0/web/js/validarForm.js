function validarTexto(parametro) {
    var expresion = /^[a-zA-Z\s]*$/;
    if (parametro.search(expresion)) {
        return false;
    } else {
        return true;
    }
}

function validarEspacios(parametro) {
    if (/^\s+$/.test(parametro)) {
        return false;
    } else {
        return true;
    }
}

function validarNumero(parametro) {
    if (!/^[0-9]*$/.test(parametro)) {
        return false;
    } else {
        return true;
    }
}

/////////////////////////////// VALIDACIONES 

function validarForm2() {
    var formulario = document.addForm2;
    var usuario, contraseña;

    usuario = formulario.usuarioU.value;
    contraseña = formulario.passwordU.value;

    //Validacion Usuario
    if (usuario === "")
    {
        document.getElementById("alerta2").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar el usuario</div>';
        formulario.usuarioU.focus();
        return false;
    } else if (usuario.length > 15) {
        document.getElementById("alerta2").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo usuario no puede superar los 15 caracteres </div>';
        formulario.usuarioU.focus();
        return false;
    } else if (!validarEspacios(usuario))
    {
        document.getElementById("alerta2").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo usuario tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.usuarioU.focus();
        return false;
    }
    //Validacion Contraseña
    else if (contraseña === "")
    {
        document.getElementById("alerta2").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar la contraseña</div>';
        formulario.passwordU.focus();
        return false;
    } else if (contraseña.length < 8) {
        document.getElementById("alerta2").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor la contraseña  no debe ser menor a 8 caracteres</div>';
        formulario.passwordU.focus();
        return false;
    } else if (contraseña.length > 20) {
        document.getElementById("alerta2").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo contraseña no puede superar los 20 caracteres </div>';
        formulario.passwordU.focus();
        return false;
    } else if (!validarEspacios(contraseña)) {
        document.getElementById("alerta2").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo password tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.passwordU.focus();
        return false;
    } else {
        document.getElementById("alerta2").innerHTML = "";
        return true;
    }
}

function validarActualizar() {
    var formulario = document.formA.formAD.formA2;

    var descripcion, telefono, direccion, sexo;

    descripcion = formulario.descripcionU.value;
    telefono = formulario.telefonoU.value;
    direccion = formulario.dirreccionU.value;
    sexo = formulario.sexoU.value;

    var foto = formulario.foto.value;
    var extenciones = /(.jpg|.JPG|.PNG|.png)$/i;

    if (descripcion === "") {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo descripcion no puede estar vacio</div>';
        formulario.foto.focus();
        return false;

    } else if (descripcion.length > 100) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo descripcion no puede superar los 100 caracteres</div>';
        formulario.foto.focus();
        return false;

    } else if (!validarEspacios(descripcion)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo descripcion no puede estar lleno de espacion en blanco</div>';
        formulario.foto.focus();
        return false;
    } else if (telefono === "") {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo telefono no puede estar vacio</div>';
        formulario.foto.focus();
        return false;

    } else if (telefono.length > 10) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo telefono no puede superar los 10 caracteres</div>';
        formulario.foto.focus();
        return false;

    } else if (validarTexto(telefono)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo telefono solo debe tener numeros/div>';
        formulario.foto.focus();
        return false;
    } else if (!validarEspacios(descripcion)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo descripcion no puede estar lleno de espacion en blanco</div>';
        formulario.foto.focus();
        return false;
    } else if (!extenciones.exec(foto)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Archivo No valido Debe ser .jpg o .png</div>';
        formulario.foto.focus();
        return false;
    } else {
        document.getElementById("alerta").innerHTML = "";
        return false;
    }
}

function  validarConfiguracion() {
    var formulario = document.formV;
    var nombre, apellido, descripcion, telefono, direccion, usuario, email, fechaNacimiento, sexo;

    nombre = formulario.nombreU.value;
    apellido = formulario.apellidoU.value;
    descripcion = formulario.descripcionU.value;
    telefono = formulario.telefonoU.value;
    direccion = formulario.dirreccionU.value;
    usuario = formulario.usuarioU.value;
    email = formulario.emailU.value;
    fechaNacimiento = formulario.fecha_NacimientoU.value;
    sexo = formulario.sexoU.value;

    var expresion = /\w+@gmail.com/;
    var fecha = new Date(), fecha2;
    var anoActual = fecha.getFullYear(), anioNacimiento;

    fecha2 = new Date(fechaNacimiento);
    anioNacimiento = fecha2.getFullYear();

    // Nombre
    if (nombre.length > 25) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo nombre no puede superar los 25 caracteres </div>';
        formulario.nombreU.focus();
        return false;
    } else if (!validarTexto(nombre)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar solo texto en el campo nombre</div>';
        formulario.nombreU.focus();
        return false;
    } else if (!validarEspacios(nombre)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo nombre tiene que tener caracteres, no puede estar lleno de espacios blancos, si no quiere llenar el campo dejelo en blanco sin espacios </div>';
        formulario.nombreU.focus();
        return false;
    }

    // Apellido
    else if (!validarTexto(apellido)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar solo texto en el campo apellido</div>';
        formulario.apellidoU.focus();
        return false;

    } else if (apellido.length > 25) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo apellido no puede superar los 25 caracteres </div>';
        formulario.apellidoU.focus();
        return false;
    } else if (!validarEspacios(apellido)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo apellido tiene que tener caracteres, no puede estar lleno de espacios blancos,, si no quiere llenar el campo dejelo en blanco sin espacios </div>';
        formulario.apellidoU.focus();
        return false;
    }

    // Descripcion
    else if (descripcion.length > 100) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo descripcion no puede superar los 100 caracteres </div>';
        formulario.descripcionU.focus();
        return false;
    } else if (!validarEspacios(descripcion)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo descripcion tiene que tener caracteres, no puede estar lleno de espacios blancos,, si no quiere llenar el campo dejelo en blanco sin espacios </div>';
        formulario.usuarioU.focus();
        return false;
    }

    // Telefono
    else if (telefono.length > 10) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo telefono no puede superar los 10 caracteres </div>';
        formulario.telefonoU.focus();
        return false;
    } else if (!validarEspacios(telefono)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo telefono tiene que tener caracteres, no puede estar lleno de espacios blancos, si no quiere llenar el campo dejelo en blanco sin espacios </div>';
        formulario.usuarioU.focus();
        return false;
    } else if (!validarNumero(telefono)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar solo numeros en el campo telefono</div>';
        formulario.telefonoU.focus();
        return false;
    }

    // Direccion
    else if (direccion.length > 30) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo direccion no puede superar los 30 caracteres</div>';
        formulario.telefonoU.focus();
        return false;
    } else if (!validarEspacios(direccion)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo direccion tiene que tener caracteres, no puede estar lleno de espacios blancos, si no quiere llenar el campo dejelo en blanco sin espacios </div>';
        formulario.usuarioU.focus();
        return false;
    }

    // Usuario
    else if (usuario.length > 15) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo usuario no puede superar los 15 caracteres </div>';
        formulario.usuarioU.focus();
        return false;
    } else if (!validarEspacios(usuario)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo usuario tiene que tener caracteres, no puede estar lleno de espacios blancos, si no quiere llenar el campo dejelo en blanco sin espacios </div>';
        formulario.usuarioU.focus();
        return false;
    }

    // Email
    else if (email.length > 30) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo email no puede superar los 30 caracteres </div>';
        formulario.emailU.focus();
        return false;
    } else if (!validarEspacios(email)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo email tiene que tener caracteres, no puede estar lleno de espacios blancos, si no quiere llenar el campo dejelo en blanco sin espacios </div>';
        formulario.emailU.focus();
        return false;
    } else if (!expresion.test(email)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo email no es valido, el correo debe ser gmail </div>';
        formulario.emailU.focus();
        return false;
    }

    //Fecha Nacimiento 
    else if (!validarEspacios(fechaNacimiento)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo fecha nacimiento  tiene que tener caracteres, no puede estar lleno de espacios blancos, si no quiere llenar el campo dejelo en blanco sin espacios </div>';
        formulario.fecha_NacimientoU.focus();
        return false;
    } else if (anoActual - anioNacimiento < 18) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Para Estar en AngieGram tienes que ser mayor de edad</div>';
        formulario.fecha_NacimientoU.focus();
        return false;
    }

    //Sexo
    else if (sexo.length > 10) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo Sexo no puede superar los 10 caracteres </div>';
        formulario.sexoU.focus();
        return false;
    } else {
        document.getElementById("alerta").innerHTML = "";
        return true;
    }
}



function validarForm() {

    var formulario = document.addForm;
    var nombre, apellido, usuario, correo, contraseña, repetir, nacimiento, expresion;
    var fecha = new Date(), fecha2;
    var anoActual = fecha.getFullYear(), anioNacimiento;


    nombre = formulario.nombreU.value;
    apellido = formulario.apellidoU.value;
    usuario = formulario.usuarioU.value;
    correo = formulario.emailU.value;
    contraseña = formulario.passwordU.value;
    repetir = formulario.repetir.value;
    nacimiento = formulario.fecha_NacimientoU.value;

    fecha2 = new Date(nacimiento);
    anioNacimiento = fecha2.getFullYear();

    expresion = /\w+@gmail.com/;

    //Validacion nombre

    ///////////////////////////////////////////////// LOGIN //////////////////////////////////////////////////
    if (nombre === "")
    {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar el nombre</div>';
        formulario.nombreU.focus();
        return false;
    } else if (!validarTexto(nombre)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar solo texto en el campo nombre</div>';
        formulario.nombreU.focus();
        return false;
    } else if (nombre.length > 25) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo nombre no puede superar los 25 caracteres </div>';
        formulario.nombreU.focus();
        return false;
    } else if (!validarEspacios(nombre)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo nombre tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.nombreU.focus();
        return false;
    }

    //Validacion apellido
    else if (apellido === "")
    {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar el apellido</div>';
        formulario.apellidoU.focus();
        return false;
    } else if (!validarTexto(apellido)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar solo texto en el campo apellido</div>';
        formulario.apellidoU.focus();
        return false;

    } else if (apellido.length > 25) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo apellido no puede superar los 25 caracteres </div>';
        formulario.apellidoU.focus();
        return false;
    } else if (!validarEspacios(apellido)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo apellido tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.apellidoU.focus();
        return false;
    }

    //Validacion Usuario
    else if (usuario === "")
    {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar el usuario</div>';
        formulario.usuarioU.focus();
        return false;
    } else if (usuario.length > 15) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo usuario no puede superar los 15 caracteres </div>';
        formulario.usuarioU.focus();
        return false;
    } else if (!validarEspacios(usuario)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo usuario tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.usuarioU.focus();
        return false;
    }

    //Validacion email
    else if (correo === "")
    {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar el email</div>';
        formulario.emailU.focus();
        return false;
    } else if (correo.length > 30) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo email no puede superar los 30 caracteres </div>';
        formulario.emailU.focus();
        return false;
    } else if (!validarEspacios(correo)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo email tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.emailU.focus();
        return false;
    } else if (!expresion.test(correo)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo email no es valido, el correo debe ser gmail </div>';
        formulario.emailU.focus();
        return false;
    }

    //Validacion Contraseña
    else if (contraseña === "")
    {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar la contraseña</div>';
        formulario.passwordU.focus();
        return false;
    } else if (!validarEspacios(contraseña)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo password tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.passwordU.focus();
        return false;
    } else if (contraseña.length < 8) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor la contraseña  no debe ser menor a 8 caracteres</div>';
        formulario.passwordU.focus();
        return false;
    } else if (repetir === "")
    {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar la contraseña repetir</div>';
        formulario.repetir.focus();
        return false;
    } else if (contraseña.length > 20 || repetir.length > 20) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo contraseña no puede superar los 20 caracteres </div>';
        formulario.passwordU.focus();
        return false;
    } else if (contraseña !== repetir) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Las dos contraseñas no coinciden </div>';
        formulario.passwordU.focus();
        return false;
    } else if (!validarEspacios(repetir)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo password repetir tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.repetir.focus();
        return false;
    } else if (validarNumero(contraseña)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Las contraseña debe ser mas dificil, agregale letras </div>';
        formulario.passwordU.focus();
        return false;
    } else if (validarTexto(contraseña)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Las contraseña debe ser mas dificil, agregale numeros </div>';
        formulario.passwordU.focus();
        return false;
    }

    //Validacion Fecha Nacimiento
    else if (nacimiento === "")
    {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar la fecha de nacimiento </div>';
        formulario.fecha_NacimientoU.focus();
        return false;
    } else if (!validarEspacios(nacimiento)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo fecha nacimiento  tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.fecha_NacimientoU.focus();
        return false;
    } else if (anoActual - anioNacimiento < 18) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Para registrarse en AngieGram tienes que ser mayor de edad</div>';
        formulario.fecha_NacimientoU.focus();
        return false;
    } else {
        document.getElementById("alerta").innerHTML = "";
        return true;
    }
}



function validarUser() {
    var formulario = document.addForm;
    var correo, expresion, password;

    expresion = /\w+@gmail.com/;
    correo = formulario.emailU.value;
    password = formulario.passwordU.value;

    if (correo.length > 30) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo email no puede superar los 30 caracteres </div>';
        formulario.emailU.focus();
        return false;
    } else if (!validarEspacios(correo)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo email tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.emailU.focus();
        return false;
    } else if (!expresion.test(correo)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo email no es valido, el correo debe ser gmail </div>';
        formulario.emailU.focus();
        return false;
    } else if (password === "") {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar la contraseña</div>';
        formulario.passwordU.focus();
        return false;
    } else if (!validarEspacios(password)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo password tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.passwordU.focus();
        return false;
    } else if (password.length < 8) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor la contraseña  no debe ser menor a 8 caracteres</div>';
        formulario.passwordU.focus();
        return false;
    } else if (password.length > 20) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo contraseña no puede superar los 20 caracteres </div>';
        formulario.passwordU.focus();
        return false;
    } else if (validarNumero(password)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Las contraseña debe ser mas dificil, agregale letras </div>';
        formulario.passwordU.focus();
        return false;
    } else if (validarTexto(password)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Las contraseña debe ser mas dificil, agregale numeros </div>';
        formulario.passwordU.focus();
        return false;
    } else {
        document.getElementById("alerta").innerHTML = "";
        return true;
    }
}


function validarEmail() {
    var formulario = document.addForm;
    var correo, expresion, usuario, password;

    expresion = /\w+@gmail.com/;
    correo = formulario.emailU.value;
    usuario = formulario.usuarioU.value;
    password = formulario.passwordU.value;
    if (usuario === "")
    {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar el usuario</div>';
        formulario.usuarioU.focus();
        return false;
    } else if (usuario.length > 15) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo usuario no puede superar los 15 caracteres </div>';
        formulario.usuarioU.focus();
        return false;
    } else if (!validarEspacios(usuario))
    {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo usuario tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.usuarioU.focus();
        return false;
    }
    ///// Correo electronico
    else if (correo === "")
    {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar el email</div>';
        formulario.emailU.focus();
        return false;
    } else if (correo.length > 30) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo email no puede superar los 30 caracteres </div>';
        formulario.emailU.focus();
        return false;
    } else if (!validarEspacios(correo)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo email tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.emailU.focus();
        return false;
    } else if (!expresion.test(correo)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo email no es valido, el correo debe ser gmail </div>';
        formulario.emailU.focus();
        return false;
    }
    ///// password
    else if (password === "") {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor ingresar la contraseña</div>';
        formulario.passwordU.focus();
        return false;
    } else if (!validarEspacios(password)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo password tiene que tener caracteres, no puede estar lleno de espacios blancos </div>';
        formulario.passwordU.focus();
        return false;
    } else if (password.length < 8) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Favor la contraseña  no debe ser menor a 8 caracteres</div>';
        formulario.passwordU.focus();
        return false;
    } else if (password.length > 20) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El campo contraseña no puede superar los 20 caracteres </div>';
        formulario.passwordU.focus();
        return false;
    } else if (validarNumero(password)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Las contraseña debe ser mas dificil, agregale letras </div>';
        formulario.passwordU.focus();
        return false;
    } else if (validarTexto(password)) {
        document.getElementById("alerta").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Las contraseña debe ser mas dificil, agregale numeros </div>';
        formulario.passwordU.focus();
        return false;
    } else {
        document.getElementById("alerta").innerHTML = "";
        return true;
    }
}





