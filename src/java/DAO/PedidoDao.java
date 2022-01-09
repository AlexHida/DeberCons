
package DAO;

import DataStatic.Conection;
import Models.Pedido;

public class PedidoDao {

    Conection conexion;
    String sql = "";

    public PedidoDao() {
        //Instanciar varable global conexion
        conexion = new Conection();
    }
    
    //Metodo para insertar pedido
    public boolean insertarPedido(Pedido pedido) {
        sql = String.format("insert into encabezado_pedido (fecha_venta, estado, "
                + "usuario_id_usuario, total, descuento) values "
                + "(now(),'%s',%s, %s, %s)", pedido.getEstado(), pedido.getIdUsuario(), 
                pedido.getTotal(), pedido.getDescuento());
        
        return conexion.modifyBD(sql);
    }

    //Metodo para obtener la cantidad de ventas por mes
    public String cantidadVentasPorMes(String idUsuario) {
        sql = String.format("select count(id_encapedido) \n"
                + "from encabezado_pedido where DATE_PART('day', now() - "
                + "fecha_venta) <= 30 and usuario_id_usuario = %s", idUsuario);
        
        return conexion.fillString(sql);
    }
    
    //Metodo para cancelar pedidos
    public boolean cancelarPedido(Pedido pedido) {
        sql = String.format("delte from encabezado_pedido where "
                + "id_encapedido = %s", pedido.getIdPedido());
        return conexion.modifyBD(sql);
    }

    //Metodo para listra pedidos
    public String listarPedidos(String idUsuario) {
        sql = "select distinct ep.id_encapedido,ep.fecha_venta, "
                + "us.nombre_tienda, ep.total, ep.descuento, ep.estado\n"
                + "from encabezado_pedido as ep inner join detalle_pedido as "
                + "dp on ep.id_encapedido = dp.encabezado_pedido_id_encapedido\n"
                + "inner join producto as pr on dp.producto_id_producto = pr.id_producto \n"
                + "inner join usuario as us on pr.usuario_id_usuario = us.id_usuario\n"
                + "where ep.usuario_id_usuario = " + idUsuario + "\n"
                + "group by ep.total, ep.id_encapedido, dp.id_detpedido, "
                + "pr.id_producto, us.id_usuario "
                + "order by ep.id_encapedido asc";
        
        return conexion.getRecordsInJson(sql);
    }

    //Metodo para listar pedidos cancelados
    public String listarPedidosCancelados(String idUsuario) {
        sql = "select distinct ep.id_pedeliminado, ep.fecha_pedido, ep.fecha_pedido, "
                + "us.nombre_tienda, ep.total, ep.descuento, ep.descuento\n"
                + "from encabezado_pedido_eliminado as ep inner join detalle_pedido_eliminado "
                + "as dp on ep.id_pedeliminado = dp.encabezado_pedido_eliminado_id_pedeliminado\n"
                + "inner join producto as pr on dp.producto_id_producto = pr.id_producto \n"
                + "inner join usuario as us on pr.usuario_id_usuario = us.id_usuario\n"
                + "where ep.usuario_id_usuario = " + idUsuario + "\n"
                + "group by ep.total, ep.id_pedeliminado, "
                + "dp.id_detalle_pedelimnado, pr.id_producto, us.id_usuario \n"
                + "order by ep.id_pedeliminado asc";
        
        return conexion.getRecordsInJson(sql);
    }

    //Metodo para listar pedidos de la tienda
    public String listarPedidosTienda(Pedido pedido) {
        sql = "select distinct ep.id_encapedido,ep.fecha_venta, ep.total, "
                + "ep.descuento, ep.estado, ep.usuario_id_usuario\n"
                + "from encabezado_pedido as ep inner join detalle_pedido as "
                + "dp on ep.id_encapedido = dp.encabezado_pedido_id_encapedido\n"
                + "inner join producto as pr on dp.producto_id_producto = pr.id_producto \n"
                + "inner join usuario as us on pr.usuario_id_usuario = us.id_usuario\n"
                + "where us.id_usuario = " + pedido.getIdUsuario() + "\n"
                + "group by ep.total, ep.id_encapedido, dp.id_detpedido, "
                + "pr.id_producto, us.id_usuario \n"
                + "order by ep.id_encapedido asc";
        
        System.out.println(sql);
        return conexion.getRecordsInJson(sql);
    }

    //Metodo para cancelar pedidos
    public boolean cancelarPedido(String idPedido) {
        sql = "delete from detalle_pedido where encabezado_pedido_id_encapedido = " 
                + idPedido + "";
        
        System.out.println(sql);
        
        if (conexion.modifyBD(sql)) {
            sql = "delete from encabezado_pedido where id_encapedido = " 
                    + idPedido + "";
        }
        return conexion.modifyBD(sql);
    }

    //metodo para deapachar pedidos
    public boolean despacharPedido(String idPedido) {
        sql = "update encabezado_pedido set estado = 'd' where id_encapedido = " 
                + idPedido + "";
        
        System.out.println(sql);
        return conexion.modifyBD(sql);
    }

}
