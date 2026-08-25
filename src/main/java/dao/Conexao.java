package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public String driver = "com.mysql.cj.jdbc.Driver";
    public final String url = "jdbc:mysql://localhost:3306/java";
    public String USUARIO = "root";
    public String SENHA = "";

    public Connection conectar() {
        try {
            Connection conexao = null;
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, USUARIO, SENHA);
            System.out.println("Conexão realizada com sucesso!");
            return conexao;
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.toString());
            return null;
        }
    }
}
