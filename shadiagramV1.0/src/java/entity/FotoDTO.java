
package entity;

import java.io.FileInputStream;


public class FotoDTO {

    private String fecha;
    private String descripcion;
    private int id;
    private int idUser;
    private String usuario;
    private FileInputStream imagen;
    private byte[] imagen2;

    public FotoDTO() {
    }

    public FotoDTO(String fecha, String descripcion, int id, byte[] imagen2) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.id = id;
        this.imagen2 = imagen2;
    }

    public FotoDTO(String fecha, String descripcion, int id, FileInputStream imagen, byte[] imagen2) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.id = id;
        this.imagen = imagen;
        this.imagen2 = imagen2;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }

    public FileInputStream getImagen() {
        return imagen;
    }

    public byte[] getImagen2() {
        return imagen2;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImagen(FileInputStream imagen) {
        this.imagen = imagen;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setImagen2(byte[] imagen2) {
        this.imagen2 = imagen2;
    }  
}
