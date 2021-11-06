
package entity;

public class AmistadDTO {
      
    private int id;
    private int idSeguidor;
    private int idSiguiendo;
    private String usuarioSiguiendo;
    private String fecha;

    public AmistadDTO() {
    }

    public int getId() {
        return id;
    }

    public int getIdSeguidor() {
        return idSeguidor;
    }

    public int getIdSiguiendo() {
        return idSiguiendo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdSeguidor(int idSeguidor) {
        this.idSeguidor = idSeguidor;
    }

    public void setIdSiguiendo(int idSiguiendo) {
        this.idSiguiendo = idSiguiendo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    } 

    public String getUsuarioSiguiendo() {
        return usuarioSiguiendo;
    }

    public void setUsuarioSiguiendo(String usuarioSiguiendo) {
        this.usuarioSiguiendo = usuarioSiguiendo;
    }
}
