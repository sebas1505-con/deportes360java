package modelo;

import dao.conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection conectar() throws Exception {
        conexion cn = new conexion();
        return cn.getConexion();
    }

    public void insertar(Usuario u) throws Exception {

        String sql = "INSERT INTO usuarios (Nombre, Direccion, fechaNacimiento, Barrio, usuEdad, usuTelefono, usuCorreo, Usuario, contraseña) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection con = conectar();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, u.getNombre());
        ps.setString(2, u.getDireccion());
        ps.setString(3, u.getFechaNacimiento());
        ps.setString(4, u.getBarrio());
        ps.setInt(5, u.getEdad());
        ps.setString(6, u.getTelefono());
        ps.setString(7, u.getCorreo());
        ps.setString(8, u.getUsuario());
        ps.setString(9, u.getContraseña());

        ps.execute();
        con.close();
    }

    public List<Usuario> listar() throws Exception {
        List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT * FROM usuarios";
        Connection con = conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario();

            u.setId(rs.getInt("pk_idUsuario"));
            u.setNombre(rs.getString("Nombre"));
            u.setDireccion(rs.getString("Direccion"));
            u.setFechaNacimiento(rs.getString("fechaNacimiento"));
            u.setBarrio(rs.getString("Barrio"));
            u.setEdad(rs.getInt("usuEdad"));
            u.setTelefono(rs.getString("usuTelefono"));
            u.setCorreo(rs.getString("usuCorreo"));
            u.setUsuario(rs.getString("Usuario"));
            u.setContraseña(rs.getString("contraseña"));

            lista.add(u);
        }
        con.close();
        return lista;
    }

    public void eliminar(int id) throws Exception {

        String sql = "DELETE FROM usuarios WHERE pk_idUsuario=?";
        Connection con = conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        con.close();
    }

    public void actualizar(Usuario u) throws Exception {

        String sql = "UPDATE usuarios SET Nombre=?, Direccion=?, fechaNacimiento=?, Barrio=?, usuEdad=?, usuTelefono=?, usuCorreo=?, Usuario=?, contraseña=? "
                + "WHERE pk_idUsuario=?";

        Connection con = conectar();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, u.getNombre());
        ps.setString(2, u.getDireccion());
        ps.setString(3, u.getFechaNacimiento());
        ps.setString(4, u.getBarrio());
        ps.setInt(5, u.getEdad());
        ps.setString(6, u.getTelefono());
        ps.setString(7, u.getCorreo());
        ps.setString(8, u.getUsuario());
        ps.setString(9, u.getContraseña());
        ps.setInt(10, u.getId());

        ps.execute();
        con.close();
    }

    public Usuario login(String correo, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Usuario loginAdmin(String correo, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
