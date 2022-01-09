
package Controller;

import DAO.DetallePedidoDao;
import Models.DetallePedido;

public class DetallePedidoController {
    
    DetallePedidoDao detallePedidoDao;
    String message;
    DetallePedido detalleModelo;

    public DetallePedidoController() {
        //variables globales se instanciaran en el constructor
        detallePedidoDao = new DetallePedidoDao();
        detalleModelo = new DetallePedido();
        //Variable mensaje se inicializara en el constructor
        this.message = "Error en los valores ingresados";
    }

    public String insertarDetallePedido(String idProducto, String cantidad, 
            String precio) {
        
        //uso directo de las variables globales instanciadas en el constructor
        detalleModelo.setCantidad(cantidad);
        detalleModelo.setPrecio(precio);
        detalleModelo.setIdProducto(idProducto);

        if (detallePedidoDao.insertarDetallePedido(detalleModelo)) {
            this.message = "Pedido realizado con exito";
        } else {
            this.message = "Error de base de datos!";
        }
        return this.message;
    }

    public String disminuirStock(String idProducto, String idCantidad) {

        detalleModelo.setIdProducto(idProducto);
        detalleModelo.setCantidad(idCantidad);

        if (detallePedidoDao.disminuirStock(detalleModelo)) {
            this.message = "Stock actualizado correctamente";
        } else {
            this.message = "Error de base de datos!";
        }
        return this.message;
    }
    
    public String aumentarStock(String idProducto, String idCantidad) {

        detalleModelo.setIdProducto(idProducto);
        detalleModelo.setCantidad(idCantidad);

        if (detallePedidoDao.aumentarStock(detalleModelo)) {
            this.message = "Stock actualizado correctamente";
        } else {
            this.message = "Error de base de datos!";
        }
        return this.message;
    }

}
