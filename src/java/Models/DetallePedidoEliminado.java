
package Models;

public class DetallePedidoEliminado {
    private String idDetallePedidoEliminado = "";
    private String idPedidoEliminado = "";
    private String idProducto = "";
    private String cantidad = "";
    private String precio = "";

    public DetallePedidoEliminado() {
    }
    
    //Constructor que inicializara las variables de la clase
    public DetallePedidoEliminado(String idDetallePedidoEliminado, 
            String idPedidoEliminado, String idProducto, String cantidad, String precio) {
        
        this.idDetallePedidoEliminado = idDetallePedidoEliminado;
        this.idPedidoEliminado = idPedidoEliminado;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }


    public String getIdDetallePedidoEliminado() {
        return idDetallePedidoEliminado;
    }

    public void setIdDetallePedidoEliminado(String idDetallePedidoEliminado) {
        this.idDetallePedidoEliminado = idDetallePedidoEliminado;
    }

    public String getIdPedidoEliminado() {
        return idPedidoEliminado;
    }

    public void setIdPedidoEliminado(String idPedidoEliminado) {
        this.idPedidoEliminado = idPedidoEliminado;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
}
