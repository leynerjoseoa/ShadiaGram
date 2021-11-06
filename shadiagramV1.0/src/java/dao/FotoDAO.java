package dao;

import entity.FotoDTO;
import entity.AmistadDTO;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

public class FotoDAO {

    /**
     * Metodo que permite listar las publicaciones de un usuario en especifico
     *
     * @param id, representa el id del usuario
     * @return una lista con las publicaciones del usuario
     */
    public List<FotoDTO> Listar_FotoID(int id) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FotoDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM foto WHERE id_usuario=" + id;
        try {
            ps = c.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                FotoDTO img = new FotoDTO();
                img.setId(rs.getInt(1));
                img.setImagen2(rs.getBytes(2));
                img.setDescripcion(rs.getString(3));
                img.setFecha(rs.getString(4));
                img.setIdUser(id);
                img.setUsuario(usuario(id));
                list.add(img);
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
        list=ordenarPublicaciones(list);
        return list;
    }

    public boolean savePhoto(FotoDTO f, InputStream inputStream) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        String sql = "INSERT INTO Foto(foto,descripcion,fecha_publicacion,id_usuario) VALUES (?,?,?,?)";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setBlob(1, inputStream);
            ps.setString(2, f.getDescripcion());
            ps.setDate(3, Date.valueOf(f.getFecha()));
            ps.setInt(4, f.getIdUser());
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

    public FotoDTO informacionFoto(int id) {
        FotoDTO info = new FotoDTO();
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int i = 0;
        String sql = "SELECT * FROM foto WHERE foto.id = ?";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                info.setId(rs.getInt(1));
                info.setImagen2(rs.getBytes(2));
                info.setDescripcion(rs.getString(3));
                info.setFecha(rs.getString(4));
                info.setIdUser(rs.getInt(5));
                info.setUsuario(usuario(info.getIdUser()));
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
        return info;
    }

    public String usuario(int id) {
        Conexion c = new Conexion();
        String sql = "SELECT usuario FROM usuario WHERE id=" + id;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
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
        return null;
    }

    public List<FotoDTO> ordenarPublicaciones(List<FotoDTO> p) {
        List<FotoDTO> ordenada = new ArrayList<>();
        for (int i = (p.size() - 1); i >= 0; i--) {
            ordenada.add(p.get(i));
        }
        return ordenada;
    }

    /**
     * Metodo que permite mostrar una imagen con su id del usuario
     *
     * @param idUser representa el id del usuario
     * @return un arreglo de byte con la imagen
     */
    public byte[] mostrarFoto(int idUser) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;
        try {
            ps = con.getConexion().prepareStatement("SELECT foto FROM usuario WHERE id =" + idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosIMAGEN = new byte[tamanoInput];
            bos.read(datosIMAGEN, 0, tamanoInput);
            b = datosIMAGEN;
            bos.close();
            ps.close();
            rs.close();
            con.cerrarConexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return b;
    }

    /**
     * Metodo que permite mostrar una imagen con su id del usuario
     *
     * @param id representa el id del usuario
     * @return un arreglo de byte con la imagen
     */
    public byte[] mostrarFotoAmigos(int id) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;
        try {
            ps = con.getConexion().prepareStatement("SELECT foto FROM foto WHERE id =" + id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosIMAGEN = new byte[tamanoInput];
            bos.read(datosIMAGEN, 0, tamanoInput);
            b = datosIMAGEN;
            bos.close();
            ps.close();
            rs.close();
            con.cerrarConexion();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return b;
    }

    public List<FotoDTO> publicacionesAmigos(int id) {
        List<FotoDTO> publicaciones = new ArrayList<>();

        AmistadDAO s = new AmistadDAO();
        List<AmistadDTO> siguiendo = s.siguiendoUsuario(id);

        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        int size = siguiendo.size();

        for (int i = 0; i < size; i++) {
            String sql = "SELECT * FROM foto WHERE id_usuario = ?";
            try {
                ps = c.getConexion().prepareStatement(sql);
                ps.setInt(1, siguiendo.get(i).getIdSiguiendo());
                rs = ps.executeQuery();
                while (rs.next()) {
                    FotoDTO img = new FotoDTO();
                    img.setId(rs.getInt(1));
                    img.setImagen2(rs.getBytes(2));
                    img.setDescripcion(rs.getString(3));
                    img.setFecha(rs.getString(4));
                    img.setIdUser(siguiendo.get(i).getIdSiguiendo());
                    img.setUsuario(siguiendo.get(i).getUsuarioSiguiendo());
                    publicaciones.add(img);
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
        }
        publicaciones=ordenarPublicaciones(publicaciones);
        return publicaciones;
    }

    public int publicacioneID(int id) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        int i = 0;

        String sql = "SELECT foto FROM foto WHERE id_usuario =" + id;
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
