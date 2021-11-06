
package entity;

public class ComentarioDTO {
    private int id;
    private int idUser;
    private int idFoto;
    private String descripcion;
    private String fecha;
    private String usuario;

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    } 

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }  
}
