
package Models;

public class Producto {
    private String idProducto = "";
    private String idUsuario = "";
    private String nombre = "";
    private String cantidad = "";
    private String precio = "";

    public Producto() {
    }

    //Constructor que inicializara las variables de la clase
    public Producto(String idProducto, String idUsuario, String nombre, 
            String cantidad, String precio) {
        
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
