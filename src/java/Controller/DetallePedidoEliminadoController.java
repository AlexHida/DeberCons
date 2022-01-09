package Controller;

import DAO.DetallePedidoEliminadoDao;
import Models.DetallePedidoEliminado;
import javax.swing.table.DefaultTableModel;

public class DetallePedidoEliminadoController {

    DetallePedidoEliminadoDao detallePedidoDao;
    DetallePedidoEliminado detallePedido;
    String message;

    public DetallePedidoEliminadoController() {
        //variables globales se instanciaran en el constructor
        detallePedidoDao = new DetallePedidoEliminadoDao();
        detallePedido = new DetallePedidoEliminado();
        //Variable mensaje se inicializara en el constructor
        this.message = "Error en los valores ingresados";
    }

    public String insertarDetallePedidoEliminado(String cantidad, 
            String precio, String idProducto) {

        detallePedido.setCantidad(cantidad);
        detallePedido.setPrecio(precio);
        detallePedido.setIdProducto(idProducto);

        if (detallePedidoDao.insertarDetallePedidoEliminado(detallePedido)) {
            this.message = "Correcto";
        } else {
            this.message = "Error en la base de datos!";
        }
        return this.message;
    }

    public String getProductos(String idPedido) {
        
        detallePedidoDao = new DetallePedidoEliminadoDao();
        DefaultTableModel table = detallePedidoDao.getProductos(idPedido);
        String detalle = "";
        
        for (int i = 0; i < table.getRowCount(); i++) {
            detalle += table.getValueAt(i, 4).toString() + ";" + 
                    table.getValueAt(i, 1).toString() + ";" + 
                    table.getValueAt(i, 3).toString();
            
            if (i < table.getRowCount() - 1) {
                detalle += "/";
            }
        }
        System.out.println(detalle);
        return detalle;
    }

}
