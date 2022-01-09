
package Models;

public class Usuario {
    
    private String idUsuario = "";
    private String nombres = "";
    private String apellidos = "";
    private String nombreTienda = "";
    private String telefono = "";
    private String cedula = "";
    private String estado = "";
    private String tipoUsuario = "";
    private String usuario = "";
    private String contrasenia = "";

    public Usuario() {
    }
    
    //Constructor que inicializara las variables de la clase
    public Usuario(String idUsuario, String nombres, String apellidos, 
            String nombreTienda, String telefono, String cedula, String estado, 
            String tipoUsuario, String usuario, String contrasenia) {
        
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nombreTienda = nombreTienda;
        this.telefono = telefono;
        this.cedula = cedula;
        this.estado = estado;
        this.tipoUsuario = tipoUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    

}
