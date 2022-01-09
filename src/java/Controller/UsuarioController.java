
package Controller;

import DAO.UsuarioDao;
import Models.UserSession;
import Models.Usuario;
import javax.swing.table.DefaultTableModel;

public class UsuarioController {

    UsuarioDao usuarioDao;
    Usuario usuario;
    String message;

    public UsuarioController() {
        //variables globales se instanciaran en el constructor
        usuarioDao = new UsuarioDao();
        usuario = new Usuario();
        //Variable mensaje se inicializara en el constructor
        message = "Error en los valores ingresados";
    }

    public String insertarUsuario(String nombres, String apellidos, 
            String nombreTienda, String estado, String tipoUsuario, String user, 
            String contrasenia) {

        usuario.setNombres(nombres);
        usuario.setApellidos(apellidos);
        usuario.setNombreTienda(nombreTienda);
        usuario.setEstado(estado);
        usuario.setTipoUsuario(tipoUsuario);
        usuario.setUsuario(user);
        usuario.setContrasenia(contrasenia);
        if(usuarioDao.insertarUsuario(usuario)){
            this.message = "Usuario registrado correctamente";
        }else{
            this.message = "Erro al agregar un nuevo usuario!";
        }
        return this.message;
    }
    
    public String habilitarUsuario (String idUsuario){
        this.message = "Error en los parametros de entrada.";
        usuario.setIdUsuario(idUsuario);
        if(usuarioDao.habilitar(usuario)){
            this.message = "Usuario habilitado correctamente";
        }else{
            this.message = "Error al habilitar el usuario!";
        }
        return this.message;
    }
    
    public UserSession login(String user, String contrasenia){
        UserSession valorUsuario = null;
        usuarioDao = new UsuarioDao();
        DefaultTableModel employeeresponse = usuarioDao.login(user, contrasenia);
        if (employeeresponse.getRowCount() > 0) {
            valorUsuario = new UserSession();
            valorUsuario.setIdUser(employeeresponse.getValueAt(0, 0).toString());
            valorUsuario.setNombre(employeeresponse.getValueAt(0, 1).toString());
            valorUsuario.setApellido(employeeresponse.getValueAt(0, 2).toString());
            valorUsuario.setNombreUsuario(employeeresponse.getValueAt(0, 6).toString());
            valorUsuario.setCargo(employeeresponse.getValueAt(0, 5).toString());
            valorUsuario.setEstado(employeeresponse.getValueAt(0, 4).toString());
        } else {
            valorUsuario = null;
        }
        return valorUsuario;
    }
    
    public String listarUsuarios(){
        usuarioDao = new UsuarioDao();
        return usuarioDao.listarUsuarios();
    }

}
