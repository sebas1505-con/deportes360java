
package Bean;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Usuario;
import modelo.UsuarioDAO;

@ManagedBean
@SessionScoped
public class AdminBean implements Serializable {

    private String correo;
    private String password;

    private Usuario adminLogueado;

    public String login() {

        UsuarioDAO dao = new UsuarioDAO();
        adminLogueado = dao.loginAdmin(correo, password);

        if (adminLogueado != null) {
            return "/admin/admin?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Datos incorrectos", "Usuario o contraseña inválidos"));

            return null;
        }
    }

    public void verificarSesion() {
        try {
            if (adminLogueado == null) {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("../login.xhtml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String logout() {
        adminLogueado = null;
        correo = null;
        password = null;
        return "/login.xhtml?faces-redirect=true";
    }

    // GETTERS & SETTERS

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getAdminLogueado() {
        return adminLogueado;
    }
    public void setAdminLogueado(Usuario adminLogueado) {
        this.adminLogueado = adminLogueado;
    }
}
