package dao;

import entity.LikeDTO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Conexion;

public class LikeDAO {

    public boolean saveLike(LikeDTO like) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        String sql = "INSERT INTO Likes(id_usuario, id_foto,fecha) VALUES (?,?,?)";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setInt(1, like.getIdUsuario());
            ps.setInt(2, like.getIdFoto());
            ps.setDate(3, Date.valueOf(like.getFecha()));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("A " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("B " + ex.getMessage());
        } finally {
            try {
                ps.close();
                c.cerrarConexion();
            } catch (Exception ex) {
            }
        }
        return false;
    }

    public int existeLike(int idF, int idU) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id FROM likes WHERE id_usuario=" + idU + " AND id_foto=" + idF;
        try {
            ps = c.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return 1;
            }

        } catch (SQLException ex) {
            System.out.println("A " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("B " + ex.getMessage());
        } finally {
            try {
                ps.close();
                c.cerrarConexion();
                rs.close();
            } catch (Exception ex) {
            }
        }
        return 0;
    }

    public boolean desLike(int id, int foto) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        String sql = "DELETE FROM likes WHERE id_usuario =" + id + " AND id_foto=" + foto;
        try {
            ps = c.getConexion().prepareStatement(sql);
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                c.cerrarConexion();
            } catch (Exception ex) {
            }
        }
        return false;
    }

    public int cantidadLikes(int id) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int i = 0;

        String sql = "SELECT id FROM likes WHERE id_foto =" + id;
        try {
            ps = con.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                con.cerrarConexion();
            } catch (Exception ex) {
            }
        }
        return i;
    }
}
