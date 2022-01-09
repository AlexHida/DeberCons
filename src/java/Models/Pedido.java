
package Models;

public class Pedido {
    
    private String idPedido = "";
    private String idUsuario = "";
    private String fechaPedido = "";
    private String estado = "";
    private int descuento = -1;
    private String total = "";

    public Pedido() {
    }

    //Constructor que inicializara con las variables de la clase
    public Pedido(String idPedido, String idUsuario, String fechaPedido, 
            String estado, int descuento, String total) {
        
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.descuento = descuento;
        this.total = total;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    

}
