package dao;

import entity.UsuarioDTO;
import java.io.InputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Conexion;

public class UsuarioDAO {

    /**
     * Metodo que permite guardar un usuario
     *
     * @param u , representa el usuario a guardar
     */
    public void SaveUsuario(UsuarioDTO u) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        String sql = "INSERT INTO Usuario(nombre,apellido,usuario,email,password,fecha_nacimiento,fecha_creacion)"
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getUsuario());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getPassword());
            ps.setDate(6, Date.valueOf(u.getFecha_Nacimiento()));
            ps.setDate(7, Date.valueOf(u.getFecha_Creacion()));
            ps.executeUpdate();
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
    }
    
    /**
     * Metodo que permite guardar una foto a la base de datos
     * @param inputStream representa el archivo de la imagen
     * @param user, representa el usuario
     * @return true si la guardo false si no
     */
    public boolean savePhoto(InputStream inputStream, String user) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        String sql = "UPDATE usuario SET foto=? WHERE usuario.id="+conocerID(user);
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setBlob(1, inputStream);
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

    /**
     * Metodo que permite averiguar si conside la contraseña con el usuario
     *
     * @param user, representa el nombre usuario
     * @param contraseña, representa la contraseña
     * @return un boolean true si es correcto y false si no
     */
    public boolean concidePassword(String user, String contraseña) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT password FROM usuario WHERE usuario.usuario = ?";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            rs.next();
            if (rs.getString(1).equals(contraseña)) {
                return true;
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
        return false;
    }
    
    /**
     * Metodo que permite cambiar la contraseña
     * @param usuario, representa el user
     * @param contraseñaAnterior, representa la contraseña anterior
     * @param contraseñaNueva, representa la contraseña nueva
     * @return 
     */
    public boolean cambiarPassword(String usuario, String contraseñaAnterior, String contraseñaNueva) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        if (concidePassword(usuario, contraseñaAnterior)) {
            String sql = "UPDATE usuario SET  password = ? WHERE id =" + conocerID(usuario);
            try {
                ps = c.getConexion().prepareStatement(sql);
                ps.setString(1, contraseñaNueva);
                ps.executeUpdate();
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } finally {
                try {
                    ps.close();
                    c.cerrarConexion();
                } catch (Exception ex) {
                }
            }
        }
        return false;
    }
    
    /**
     * Metodo que permite modificar un dato de un usuario
     * @param user, representa el user a modificar
     * @param u, representa la informacion nueva del usuario
     * @return true si lo modifico false si no
     */
    public boolean ModificarUsuario(String user, UsuarioDTO u) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        String sql = "UPDATE usuario SET nombre = ?, apellido = ?, descripcion = ?,"
                + "telefono = ?, direccion = ? , usuario = ?, email = ?, "
                + "fecha_nacimiento = ?, sexo=? WHERE id =" + conocerID(user);
        try {
            ps = c.getConexion().prepareStatement(sql);
            UsuarioDTO tmp = conocerUsuario(user);
            ps.setString(1, (u.getNombre() != null) ? u.getNombre() : tmp.getNombre());
            ps.setString(2, (u.getApellido() != null) ? u.getApellido() : tmp.getApellido());
            ps.setString(3, (u.getDescripcion() != null) ? u.getDescripcion() : tmp.getDescripcion());
            ps.setString(4, (u.getTelefono() != null) ? u.getTelefono() : tmp.getTelefono());
            ps.setString(5, (u.getDireccion() != null) ? u.getDireccion() : tmp.getDireccion());
            ps.setString(6, (u.getUsuario() != null) ? u.getUsuario() : tmp.getUsuario());
            ps.setString(7, (u.getEmail() != null) ? u.getEmail() : tmp.getEmail());
            ps.setDate(8, (u.getFecha_Nacimiento().length()>0) ? Date.valueOf(u.getFecha_Nacimiento()) : Date.valueOf(tmp.getFecha_Nacimiento()));
            ps.setString(9, (u.getSexo() != null) ? u.getSexo() : tmp.getSexo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
    
    /**
     * Metodo que permite consultar un usuario
     *
     * @param usuario, representa el nombre de usuario que se quiere consultar
     * @return el usuario
     */
    public UsuarioDTO conocerUsuario(String usuario) {
        UsuarioDTO u = null;
        Conexion c = new Conexion();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "SELECT * FROM usuario WHERE usuario.usuario = ?";
        try {
            ps = c.getConexion().prepareStatement(sql);
            u = new UsuarioDTO();
            ps.setString(1, usuario);
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
                u.setImagen(rs.getAsciiStream(13));
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
    
    /**
     * Metodo que permite averiguar si existe un usuario
     *
     * @param usuario, representa el user que se quiere consultar
     * @return true si existe false si no
     */
    public boolean existeUser(String usuario) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT email FROM usuario WHERE usuario.usuario = ?";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
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
        return false;
    }

    /**
     * Metodo que permite averiguar si el email digita le pertenece al usuario
     * seleccionado
     *
     * @param user, representa el usuario
     * @param email, representa el email
     * @return un true si existe false si no
     */
    public boolean concideEmailUsuario(String user, String email) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT email FROM usuario WHERE usuario.usuario = ? AND usuario.email = ?";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
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
        return false;
    }

    

    /**
     * Metodo que permite averiguar si existe un usuario
     *
     * @param usuario, representa el user que se quiere consultar
     * @return true si existe false si no
     */
    public boolean existeUsuario(String usuario) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT email FROM usuario WHERE usuario.usuario = ?";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
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
        return false;
    }

    /**
     * Metodo que permite averiguar si conside la contraseña con el EMAIL Y
     * PASSWORD
     *
     * @param email, representa el email
     * @param password, representa la contraseña
     * @return un boolean true si es correcto y false si no
     */
    public String existeUserEmail(String email, String password) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT usuario FROM usuario WHERE usuario.email = ? AND usuario.password=?";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
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

    /**
     * Metodo que permite conocer si ya existe el email registrado
     *
     * @param email, representa el email a consultar
     * @return un boolean true si existe false si no
     */
    public boolean existeEmail(String email) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT email FROM usuario WHERE usuario.email = ?";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
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
        return false;
    }

    /**
     * Metodo que permite conocer la llave principal de un usuario
     *
     * @param usuario, representa el nombre de usuario a consultar
     * @return un entero con la llave del usuario, -1 si no existe el usuario
     */
    public int conocerID(String usuario) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id FROM usuario WHERE usuario.usuario = ?";
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
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
        return -1;
    }

    /**
     * Metodo que permite cambiar la contraseña
     *
     * @param id, representa el user
     * @param contraseñaNueva, representa la contraseña nueva
     * @return true si la cambio false si no
     */
    public boolean cambiarPasswordID(int id, String contraseñaNueva) {
        Conexion c = new Conexion();
        PreparedStatement ps = null;
        String sql = "UPDATE usuario SET  password = ? WHERE id =" + id;
        try {
            ps = c.getConexion().prepareStatement(sql);
            ps.setString(1, contraseñaNueva);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
}
