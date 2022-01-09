
package Controller;

import DAO.PedidoDao;
import Models.Pedido;

public class PedidoController {

    PedidoDao pedidoDao;
    Pedido valorPedido;
    String message;

    public PedidoController() {
        //variables globales se instanciaran en el constructor
        pedidoDao = new PedidoDao();
        valorPedido = new Pedido();
        //Variable mensaje se inicializara en el constructor
        this.message = "Error en los valores ingresados";
    }

    public String insertarPedido(String estado, String idUsuario, String total) {

        valorPedido.setEstado(estado);
        valorPedido.setIdUsuario(idUsuario);
        valorPedido.setTotal(total);
        
        //Validación de los descuentos
        int descuento = Integer.parseInt(pedidoDao.cantidadVentasPorMes
        (idUsuario));
        valorPedido.setDescuento(descuento == 0 ? descuento : (
                descuento > 0 && descuento < 11) ? descuento : 10);

        if (pedidoDao.insertarPedido(valorPedido)) {
            this.message = "Procesando...";
        } else {
            this.message = "Error de base de datos!";
        }
        return this.message;
    }

    public String listarPedidos(String idUsuario) {
        return pedidoDao.listarPedidos(idUsuario);
    }
    
    public String listarPedidosCancelados(String idUsuario) {
        return pedidoDao.listarPedidosCancelados(idUsuario);
    }
    
    public String listarPedidosTienda(String idUsuario){
        valorPedido.setIdUsuario(idUsuario);
        return pedidoDao.listarPedidosTienda(valorPedido);
    }
    
    public String cancelarPedido (String idPedido){
        pedidoDao = new PedidoDao();
        if(pedidoDao.cancelarPedido(idPedido)){
                this.message = "Pedido cancelado correctamente";
        }else{
            this.message = "Error";
        }
        return this.message;
    }
    
    public String despacharPedido (String idPedido){
        pedidoDao = new PedidoDao();
        if(pedidoDao.despacharPedido(idPedido)){
                this.message = "Pedido despachado correctamente";
        }else{
            this.message = "Error";
        }
        return this.message;
    }
    
    public String cantidadDescuento(String idUsuario){
        int descuento = Integer.parseInt(pedidoDao.cantidadVentasPorMes(idUsuario));
        int respuestaDescuento = (descuento == 0 ? descuento : (descuento > 0 
                && descuento < 11) ? descuento : 10);
        return  String.valueOf(respuestaDescuento);
    }
    
}
