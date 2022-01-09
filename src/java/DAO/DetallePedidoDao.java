
package DAO;

import DataStatic.Conection;
import Models.DetallePedido;

public class DetallePedidoDao {

    Conection conexion;
    String sql = "";

    public DetallePedidoDao() {
        //Instanciar la variable global conexion
        conexion = new Conection();
    }
    
    //Metodo para insertar detalle de pedido
    public boolean insertarDetallePedido(DetallePedido detallePedido) {
        sql = String.format("insert into detalle_pedido (producto_id_producto, "
                + "cantidad, precio_unit, encabezado_pedido_id_encapedido) "
                + "values (%s, %s, %s, (select id_encapedido "
                + "from encabezado_pedido order by id_encapedido desc limit 1))"
                , detallePedido.getIdProducto(), detallePedido.getCantidad(), 
                detallePedido.getPrecio());
        
        return conexion.modifyBD(sql);
    }
    
    //Metodo para cancelar pedido
    public boolean cancelarPedido(DetallePedido detallePedido) {
        sql = String.format("delte from detalle_pedido where "
                + "encabezado_pedido_id_encapedido = %s", 
                detallePedido.getIdPedido());
        
        return conexion.modifyBD(sql);
    }
    
    //Metodo para reducir stock
    public boolean disminuirStock(DetallePedido detallePedido) {
        sql = String.format("update producto set stock = stock - %s "
                + "where id_producto = %s", detallePedido.getCantidad(), 
                detallePedido.getIdProducto());
        
        return conexion.modifyBD(sql);
    }
    
    //Metodo para aumentar stock
    public boolean aumentarStock(DetallePedido detallePedido) {
        sql = String.format("update producto set stock = stock + %s "
                + "where id_producto = %s", detallePedido.getCantidad(), 
                detallePedido.getIdProducto());
        
        return conexion.modifyBD(sql);
    }

}
