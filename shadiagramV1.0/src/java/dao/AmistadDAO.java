package dao;

import entity.AmistadDTO;
import entity.UsuarioDTO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import util.Conexion;

public class AmistadDAO {

    
    public List<UsuarioDTO> listarUsuarios() {
        Conexion c = new Conexion();
        List<UsuarioDTO> list = new ArrayList<>();
        ResultSet rs = null;
        String com = "select * from usuario";
        PreparedStatement ps = null;
        try {
            ps = c.getConexion().prepareStatement(com);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioDTO a = new UsuarioDTO();
                a.setID(rs.getInt(1));
                a.setUsuario(rs.getString(7));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                list.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
        return list;
    }
    

    public List<AmistadDTO> seguidoresUsuario(int id) {
        Conexion c = new Conexion();
        List<AmistadDTO> list = new ArrayList<>();
        ResultSet rs = null;
        String com = "select * from amistad WHERE id_siguiendo=" + id;
        PreparedStatement ps = null;
        try {
            ps = c.getConexion().prepareStatement(com);
            rs = ps.executeQuery();
            while (rs.next()) {
                AmistadDTO s = new AmistadDTO();
                s.setId(rs.getInt(1));
                s.setIdSeguidor(rs.getInt(2));
                s.setIdSiguiendo(rs.getInt(3));
                s.setFecha(rs.getString(4));
                s.setUsuarioSiguiendo(usuarioID(rs.getInt(3)));
                list.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
        list = ordenarAmistad(list);
        return list;
    }

    public List<AmistadDTO> siguiendoUsuario(int id) {
        List<AmistadDTO> publicaciones = new ArrayList<>();

        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM amistad WHERE id_seguidor = " + id;
        try {
            ps = c.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                AmistadDTO s = new AmistadDTO();
                s.setId(rs.getInt(1));
                s.setIdSeguidor(rs.getInt(2));
                s.setIdSiguiendo(rs.getInt(3));
                s.setFecha(rs.getString(4));
                s.setUsuarioSiguiendo(usuarioID(rs.getInt(3)));
                publicaciones.add(s);
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
        publicaciones = ordenarAmistad(publicaciones);
        return publicaciones;
    }

    public List<AmistadDTO> ordenarAmistad(List<AmistadDTO> p) {
        List<AmistadDTO> ordenada = new ArrayList<>();
        for (int i = (p.size() - 1); i >= 0; i--) {
            ordenada.add(p.get(i));
        }
        return ordenada;
    }

    public boolean seguirUsuario(int id, int idS) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        Calendar f = Calendar.getInstance();
        String dia = Integer.toString(f.get(Calendar.DATE));
        String mes = Integer.toString(f.get(Calendar.MONTH) + 1);
        String annio = Integer.toString(f.get(Calendar.YEAR));
        int tmp = Integer.parseInt(mes);
        mes = (tmp < 10) ? "0" + tmp : "" + tmp;
        String fecha = annio + "-" + mes + "-" + dia;

        String sql = "INSERT INTO Amistad(Id_seguidor,id_siguiendo,fecha)"
                + "VALUES (?,?,?)";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, idS);
            ps.setDate(3, Date.valueOf(fecha));
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

    public boolean dejarSeguir(int id, int siguiendo) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        String sql = "DELETE FROM amistad WHERE id_seguidor =" + id + " AND id_siguiendo=" + siguiendo;
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

    public int sigoUsuario(int id, int siguiendo) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id FROM amistad WHERE id_seguidor = " + id + " AND id_siguiendo=" + siguiendo;
        try {
            ps = c.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()) {
                return 1;
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
        return 0;
    }

    public List<AmistadDTO> seguidorUsuario(int id) {
        List<AmistadDTO> publicaciones = new ArrayList<>();

        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM amistad WHERE id_seguidor = " + id;
        try {
            ps = c.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                AmistadDTO s = new AmistadDTO();
                s.setId(rs.getInt(1));
                s.setIdSeguidor(rs.getInt(2));
                s.setIdSiguiendo(rs.getInt(3));
                s.setFecha(rs.getString(4));
                s.setUsuarioSiguiendo(usuarioID(rs.getInt(3)));
                publicaciones.add(s);
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
        return publicaciones;
    }

    public UsuarioDTO usuario(int id) {
        UsuarioDTO u = new UsuarioDTO();
        Conexion c = new Conexion();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "SELECT * FROM usuario WHERE usuario.id = ?";
        try {
            ps = c.getConexion().prepareStatement(sql);
            u = new UsuarioDTO();
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setID(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellido(rs.getString(3));
                u.setDescripcion(rs.getString(4));
                u.setTelefono(rs.getString(5));
                u.setDireccion(rs.getString(6));
                u.setUsuario(rs.getString(7));
                u.setEmail(rs.getString(8));
                u.setPassword(rs.getString(9));
                u.setFecha_Nacimiento(rs.getString(10));
                u.setFecha_Creacion(rs.getString(11));
                u.setSexo(rs.getString(12));

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
        return u;
    }

    public String usuarioID(int id) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT usuario FROM usuario WHERE id = " + id;
        try {
            ps = c.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);

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
        return null;
    }

    public int siguiendoID(int id) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        int i = 0;

        String sql = "SELECT id FROM amistad WHERE id_seguidor =" + id;
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

    public int seguidoresID(int id) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        int i = 0;

        String sql = "SELECT id FROM amistad WHERE id_siguiendo =" + id;
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
