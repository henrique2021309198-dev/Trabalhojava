package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import model.UsuarioModel;

public class UsuarioDAO {

    public static boolean inserir(UsuarioModel usuario) {
        try {
            Connection conn = new Conexao().conectar();

            PreparedStatement statement = conn
                    .prepareStatement("INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)");

            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());

            statement.execute();

            conn.close();

            return true;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public static UsuarioModel login(String email, String senha) {
        UsuarioModel p = new UsuarioModel();

        try {
            Connection conn = new Conexao().conectar();

            PreparedStatement statement = conn
                    .prepareStatement("SELECT * FROM usuarios WHERE email = ?");

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                if (BCrypt.checkpw(senha, resultSet.getString("senha"))) {
                    p.setId(resultSet.getInt("id"));
                    p.setNome(resultSet.getString("nome"));
                    p.setEmail(resultSet.getString("email"));
                }
            }

            conn.close();

            return p;
        } catch (Exception e) {
            return null;
        }
    }
}
