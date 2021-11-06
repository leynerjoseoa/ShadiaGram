function validarFile() {
    var formulario = document.formFoto;
    var foto = formulario.fotoU.value;
    var descripcion = formulario.descripcionU.value;

    var extenciones = /(.jpg|.JPG|.PNG|.png)$/i;
    if (!extenciones.exec(foto)) {
        document.getElementById("alerta2").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>Archivo No valido Debe ser .jpg o .png</div>';
        formulario.fotoU.focus();
        return false;
    } else if (descripcion.length > 0) {
        if (descripcion.length > 100) {
            document.getElementById("alerta2").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>La descripcion debe ser menor a 100 caracteres :)</div>';
            formulario.descripcionU.focus();
            return false;
        }
    } else {
        document.getElementById("alerta2").innerHTML = "";
        return true;
    }
}


function  validarComentario(){
    var formulario = document.formComentario;
    var descripcion = formulario.descripcionU.value;
    if (descripcion.length > 0) {
        if (descripcion.length > 1500) {
            document.getElementById("alerta2").innerHTML = '<div class="alert alert-danger">\n\
        <a href="" class="close" data-dismiss="alert">&times;</a>El Comentario debe ser menor a 1500 caracteres :)</div>';
            formulario.descripcionU.focus();
            return false;
        }
    } else {
        document.getElementById("alerta2").innerHTML = "";
        return true;
    }
}


