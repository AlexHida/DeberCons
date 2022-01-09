
package Controller;

import DAO.ProductoDao;
import Models.Producto;

public class ProductoController {
    
    ProductoDao productoDao;
    Producto producto;
    String message;
    
    public ProductoController (){
        //variables globales se instanciaran en el constructor
        productoDao = new ProductoDao();
        producto = new Producto();
        //Variable mensaje se inicializara en el constructor
        this.message = "Error en los valores ingresados";
    }
    
    public String insertarProducto(String nombre, String stock, 
            String precioUnitario, String idUsuario){
        
        producto.setNombre(nombre);
        producto.setCantidad(stock);
        producto.setPrecio(precioUnitario);
        producto.setIdUsuario(idUsuario);
        if(productoDao.insertarProducto(producto)){
            this.message = "Producto agregado correctamente";
        }else{
            this.message = "Error al agregar producto!";
        }
        return this.message;
    }
    
    public String listarProductos(String idUsuario){
        producto.setIdUsuario(idUsuario);
        return productoDao.listarProductos(producto);
    }
    
    public String listarProductosTienda(String idUsuario){
        producto.setIdUsuario(idUsuario);
        return productoDao.listarProductosTienda(producto);
    }
    
}
