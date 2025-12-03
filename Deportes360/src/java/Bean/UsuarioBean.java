package Bean;


import modelo.Usuario;
import modelo.UsuarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="usuarioBean")
@ViewScoped
public class UsuarioBean {

    private Usuario usuario = new Usuario();
    private List<Usuario> lista;

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<Usuario> getLista() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            lista = dao.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void guardar() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.insertar(usuario);
            usuario = new Usuario();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void actualizar() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.actualizar(usuario);
            usuario = new Usuario();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void eliminar(int id) {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.eliminar(id);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void cargarUsuario(Usuario u) {
        this.usuario = u;
    }
}
