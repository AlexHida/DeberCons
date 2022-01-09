
package Models;

public class DetallePedido {
    //Variable con mejor presentacion
    private String idDetallePedido = "";
    private String idPedido = "";
    private String idUsuario = "";
    private String idProducto = "";
    private String precio = "";
    private String cantidad = "";

    public DetallePedido() {
    }
    
    //Constructor que inicializara las variables de la clase
    public DetallePedido(String idDetallePedido, String idPedido, 
            String idUsuario, String idProducto, String precio, String cantidad) {
        
        this.idDetallePedido = idDetallePedido;
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(String idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
