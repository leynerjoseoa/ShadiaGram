
package entity;

public class LikeDTO {
    
    private int id;
    private int idUsuario;
    private int idFoto;
    private String Fecha;

    public LikeDTO() {
    }

    public LikeDTO(int id, int idUsuario, int idFoto, String Fecha) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idFoto = idFoto;
        this.Fecha = Fecha;
    }

    
    
    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
}
