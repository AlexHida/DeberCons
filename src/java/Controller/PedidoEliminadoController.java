
package Controller;

import DAO.PedidoEliminadoDao;
import Models.PedidoEliminado;

public class PedidoEliminadoController {
    
    PedidoEliminadoDao pedidoDao;
    PedidoEliminado pedido;
    String message;
    
    public PedidoEliminadoController (){
        //variables globales se instanciaran en el constructor
        pedidoDao = new PedidoEliminadoDao();
        pedido = new PedidoEliminado();
        //Variable mensaje se inicializara en el constructor
        this.message = "Error en los valores ingresados";
    }
    
    public String insertarPedidoEliminado(String fechaPedido, 
            String idUsuario, String descuento, String total){
        
        this.message = "Error en los parametros ingresados";
        pedido.setFechaPedido(fechaPedido);
        pedido.setIdUsuario(idUsuario);
        pedido.setDescuento(descuento);
        pedido.setTotal(total);
        
        if(pedidoDao.insertarPedidoEliminado(pedido)){
            this.message = "Correcto";
        }else{
            this.message = "error de base de datos!";
        }
        
        return this.message;
    }
    
}
