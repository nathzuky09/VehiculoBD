
package VConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class VConexionBD {
    private String url="jdbc:mysql://localhost:3306/";
    private String bd="vconexionbd";
    private String user="root";
    private String password="";
    private String driver ="com.mysql.cj.jdbc.Driver";
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    //CONEXION BD
    public VConexionBD(){
        try{
            // Llamada paracargar el driver para poder conectarse a una base de datos
            Class.forName(driver);
            // Este método crea un objeto Connection, que se utiliza para crear sentencias SQL
            con = DriverManager.getConnection(url+bd,user,password);
             // Crea un objeto Statement, que representa una sentencia SQL y estos 
            // los objetos Statement generan objrtos ResultSet, que son una tabla de datos 
            // que representan un conjunto de resultados de una base de datos           
            st=con.createStatement();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    //CONSULTAR DATOS 
    public void consultar(){
         try{
            String query="SELECT * FROM `vehiculos` ";
            // el método Statement.executeQuery, recuperar datos de una tabla utilizando una sentencia SELECT
            rs = st.executeQuery(query);
            while(rs.next()){
                int id_vehiculo = rs.getInt("id_vehiculo");
                String Placa = rs.getString("Placa");
                String Modelo = rs.getString("Modelo");
                String Color = rs.getString("Color");
                System.out.println("Usuario: "+ id_vehiculo + "\nPlaca: " + Placa + "\nModelo: "+ Modelo + "\nColor: "+ Color + "\n");
            }
            rs.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
        //INSERTAR DATOS
       public void insertar(){
        try{
            String query="INSERT INTO `vehiculos`(`id_vehiculo`, `Placa`, `Modelo`, `Color`) VALUES ('3','asd123','ferrari','azul')";
            // el método Statement.executeUpdate, ejecuta la instrucción SQL INSERT, UPDATE, o DELETE, que son  
            // instrucciones SQL que no devuelve nada
            st.executeUpdate(query);
            System.out.println("El vehiculo se ingresó satisactoriamente \n");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
       //ACTUALIZAR DATOS
        public void actualizar() {
        try {
            // Actualiza otros campos sin cambiar el id_vehiculo
            String query = "UPDATE `vehiculos` SET `Placa`='hyt234', `Modelo`='mazda', `Color`='amarillo' WHERE `id_vehiculo`=3";
            st.executeUpdate(query);
            System.out.println("El vehículo se actualizó satisfactoriamente.\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
       
        public void eliminar() {
        try {
            // Eliminar un registro específico
            String query = "DELETE FROM `vehiculos` WHERE `id_vehiculo`=1";
            st.executeUpdate(query);
            System.out.println("El vehículo se eliminó satisfactoriamente.\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
