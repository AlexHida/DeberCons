
package DAO;

import DataStatic.Conection;
import Models.DetallePedidoEliminado;
import javax.swing.table.DefaultTableModel;

public class DetallePedidoEliminadoDao {
    
    Conection conexion;
    String sql = "";
    
    public DetallePedidoEliminadoDao(){
        //Instanciar la variable global conexion
        conexion = new Conection();
    }
    
    //Metodo para insertar detalle de un pedido eliminado
    public boolean insertarDetallePedidoEliminado(DetallePedidoEliminado detallePedido){
        sql = String.format("insert into detalle_pedido_eliminado "
                + "(cantidad, precio_unit, encabezado_pedido_eliminado_id_pedeliminado, "
                + "producto_id_producto) values(%s, %s, (select id_pedeliminado "
                + "from encabezado_pedido_eliminado order by id_pedeliminado "
                + "desc limit 1), %s)",detallePedido.getCantidad(), detallePedido.getPrecio(), 
                detallePedido.getIdProducto());
        
        return conexion.modifyBD(sql);
    }
    
    //Metodo para pedir el edtalle de los pedidos
    public DefaultTableModel getProductos (String idPedido){
        sql = "select * from detalle_pedido where encabezado_pedido_id_encapedido "
                + "= " + idPedido + "";
        
        System.out.println(sql);
        return conexion.returnRecord(sql);
    }
    
}
