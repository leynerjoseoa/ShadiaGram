package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection c;
    
    private static String url= "jdbc:mysql://localhost/";
    private static String url2="?useTimezone=True&serverTimezone=UTC";
    private static String dbName = "angiegram";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String userName = "root";
    private static String password = "";

    public Conexion() {
    }
    
    
    
    public static Connection getConexion()
    {       
        try{
              Class.forName(driver);
              c= (Connection)DriverManager.getConnection(url+dbName+url2,userName,password);
              //JOptionPane.showMessageDialog(null,"Conexion Exitosa");
              System.out.println("Exitosa");
        } catch (ClassNotFoundException |SQLException e)  {e.printStackTrace(); } 
           catch (Exception e) {  e.printStackTrace(); }
        
        return c;
    }
    
    public void cerrarConexion(){
		try {c.close();}
                catch (SQLException e) {e.printStackTrace();}
	}
    
    
}
