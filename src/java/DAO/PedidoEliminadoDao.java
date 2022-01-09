
package DAO;

import DataStatic.Conection;
import Models.PedidoEliminado;

public class PedidoEliminadoDao {
    
    Conection conexion;
    String sql = "";
    
    public PedidoEliminadoDao(){
        //instanciamos la variable global conexion
        conexion = new Conection();
    }
    
    //Metodo para insetar los pedidos eliminados
    public boolean insertarPedidoEliminado(PedidoEliminado pedido){
        sql = String.format("insert into encabezado_pedido_eliminado (fecha_eliminar, "
                + "fecha_pedido, usuario_id_usuario, descuento, total) "
                + "values(now(), '%s', %s, %s, %s)",pedido.getFechaPedido(), 
                pedido.getIdUsuario(), pedido.getDescuento(), pedido.getTotal());
        
        return conexion.modifyBD(sql);
    }
}
