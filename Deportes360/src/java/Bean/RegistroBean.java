package Bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "registroBean")
@SessionScoped
public class RegistroBean {

    private String nombre;
    private String correo;
    private String usuario;
    private String password;
    private String confirmar;
    private String telefono;
    private String direccion;
    private String fechaNacimiento;
    private String barrio;

    public RegistroBean() {}

    public String registrar() {
        System.out.println("Registrando usuario: " + nombre);
        return null;
    }

    // GETTERS Y SETTERS
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmar() { return confirmar; }
    public void setConfirmar(String confirmar) { this.confirmar = confirmar; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getBarrio() { return barrio; }
    public void setBarrio(String barrio) { this.barrio = barrio; }
}
