
package DAO;

import DataStatic.Conection;
import Models.Producto;

public class ProductoDao {
    
    Conection conexion;
    String sql = "";
    
    public ProductoDao(){
        //instanciamos la variable global conexion
        conexion = new Conection();
    }
    
    //Metodo para insertar productos
    public boolean insertarProducto(Producto producto){
        sql = String.format("insert into producto(nombre, stock, precio_unit, "
                + "usuario_id_usuario) values('%s', %s, %s, %s)",producto.getNombre(), 
                producto.getCantidad(), producto.getPrecio(), producto.getIdUsuario());
        
        return conexion.modifyBD(sql);
    }
    
    //metodo para listar productos
    public String listarProductos(Producto producto){
        sql = "select * from producto where usuario_id_usuario = "
                +producto.getIdUsuario()+" and stock > 0 order by id_producto asc";
        
        return conexion.getRecordsInJson(sql);
    }
    
    //Metodo para listar los productos de la tienda
    public String listarProductosTienda(Producto producto){
        sql = "select * from producto where usuario_id_usuario = " 
                + producto.getIdUsuario() + " and stock > 0 order by id_producto asc";
        
        return conexion.getRecordsInJson(sql);
    }

}
