
package entity;

import java.io.InputStream;


public class UsuarioDTO 
{
    private int ID;
    private String nombre;
    private String apellido;
    private String usuario;
    private String email;
    private String descripcion;
    private String password;
    private String fecha_Nacimiento;
    private String fecha_Creacion;
    private String telefono;
    private String direccion;
    private String Sexo;
    private InputStream imagen;
    

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombre, String apellido, String email, String fecha_Nacimiento, String fecha_Creacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.fecha_Creacion = fecha_Creacion;
    }
    
     public UsuarioDTO(String nombre, String apellido, String usuario, String email, String password, String fecha_Nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.fecha_Nacimiento = fecha_Nacimiento;
    }
     
    public UsuarioDTO(String nombre, String apellido, String usuario, String email, String password, String fecha_Nacimiento, String fecha_Creacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.fecha_Creacion = fecha_Creacion;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public String getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public void setFecha_Creacion(String fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }
}
