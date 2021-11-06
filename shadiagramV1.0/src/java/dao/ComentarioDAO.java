package dao;

import entity.ComentarioDTO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import util.Conexion;

public class ComentarioDAO {

    public boolean saveComentario(ComentarioDTO d) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        String sql = "INSERT INTO Comentario(id_seguidor,id_foto,descripcion,fecha) VALUES (?,?,?,?)";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setInt(1, d.getIdUser());
            ps.setInt(2, d.getIdFoto());
            ps.setString(3, d.getDescripcion());
            Calendar s = Calendar.getInstance();
            String dias = Integer.toString(s.get(Calendar.DATE));
            String mess = Integer.toString(s.get(Calendar.MONTH) + 1);
            String annios = Integer.toString(s.get(Calendar.YEAR));
            int tmps = Integer.parseInt(mess);
            mess = (tmps < 10) ? "0" + tmps : "" + tmps;
            String fechass = annios + "-" + mess + "-" + dias;
            
            d.setFecha(fechass);
            ps.setDate(4, Date.valueOf(d.getFecha()));
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

    public List<ComentarioDTO> comentariosFoto(int id) {
        List<ComentarioDTO> comentario = new ArrayList<>();
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM comentario WHERE id_foto = " + id;
        try {
            ps = c.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ComentarioDTO s = new ComentarioDTO();
                s.setId(rs.getInt(1));
                s.setIdUser(rs.getInt(2));
                s.setIdFoto(rs.getInt(3));
                s.setDescripcion(rs.getString(4));
                s.setFecha(rs.getString(5));

                String sql2 = "SELECT usuario FROM usuario WHERE id = " + s.getIdUser();
                Conexion c2 = new Conexion();
                PreparedStatement ps2 = null;
                ResultSet rs2 = null;
                try {
                    ps2 = c2.getConexion().prepareStatement(sql2);
                    rs2 = ps2.executeQuery();
                    rs2.next();
                    s.setUsuario(rs2.getString(1));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                } finally {
                    try {
                        ps2.close();
                        rs2.close();
                        c2.cerrarConexion();
                    } catch (Exception ex) {
                    }
                }
                comentario.add(s);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                c.cerrarConexion();
            } catch (Exception ex) {
            }
        }
        comentario=ordenar(comentario);
        return comentario;
    }
    
    public List<ComentarioDTO> ordenar(List<ComentarioDTO> p) {
        List<ComentarioDTO> ordenada = new ArrayList<>();
        for (int i = (p.size() - 1); i >= 0; i--) {
            ordenada.add(p.get(i));
        }
        return ordenada;
    }
    
    public int cantidadComentarios(int id) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int i = 0;

        String sql = "SELECT id FROM comentario WHERE id_foto =" + id;
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
