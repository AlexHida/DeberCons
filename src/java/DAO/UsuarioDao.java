
package DAO;

import DataStatic.Conection;
import Models.Usuario;
import javax.swing.table.DefaultTableModel;

public class UsuarioDao {
    
    Conection conexion;
    String sql = "";
    
    public UsuarioDao() {
        //instanciamos la variable global conexion
        conexion = new Conection();
    }
    
    //Metodo para insertar Usuario
    public boolean insertarUsuario(Usuario usuario){
        sql = String.format("insert into usuario (nombres, apellidos, "
                + "nombre_tienda, estado, tipo_usuario, usuario, contrasenia) "
                + "values('%s','%s','%s','%s','%s','%s','%s')",usuario.getNombres(),
                usuario.getApellidos(), usuario.getNombreTienda(), usuario.getEstado(), 
                usuario.getTipoUsuario(), usuario.getUsuario(), usuario.getContrasenia());
        
        return conexion.modifyBD(sql);
    }
    
    //Metodo para modificar usuario
    public boolean habilitar(Usuario usuario){
        sql = "update usuario set estado = 'a' where id_usuario = "
                + usuario.getIdUsuario() + "";
        
        return conexion.modifyBD(sql);
    }
    
    //Metodo para ingresar al sistema
    public DefaultTableModel login(String nombreUsuario, String contrasenia){
        sql = "select * from usuario where usuario = '" 
                + nombreUsuario + "' and contrasenia = '" + contrasenia + "'";
        
        System.out.println(sql);
        return conexion.returnRecord(sql);
    }
    
    //Metodo para listar usuarios
    public String listarUsuarios(){
        sql = "select * from usuario order by id_usuario";
        return conexion.getRecordsInJson(sql);
    }
   
    
}
