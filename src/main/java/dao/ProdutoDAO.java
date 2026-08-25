package dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.ProdutoModel;

public class ProdutoDAO {

    public List<ProdutoModel> listarTodos() {
        List<ProdutoModel> produtos = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = new Conexao().conectar();
            stmt = con.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoModel p = new ProdutoModel();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                produtos.add(p);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return produtos;
    }

    public boolean inserir(ProdutoModel produto) {
        try (Connection con = new Conexao().conectar();
             PreparedStatement statement = con.prepareStatement(
                     "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)")) {

            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());
            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
            return false;
        }
    }

    public ProdutoModel buscarPorId(int id) {
        ProdutoModel produto = null;

        try (Connection con = new Conexao().conectar();
             PreparedStatement statement = con.prepareStatement(
                     "SELECT * FROM produtos WHERE id = ?")) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                produto = new ProdutoModel();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
        }

        return produto;
    }

    public boolean editar(ProdutoModel produto) {
        try (Connection con = new Conexao().conectar();
             PreparedStatement statement = con.prepareStatement(
                     "UPDATE produtos SET nome = ?, preco = ?, quantidade = ? WHERE id = ?")) {

            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());
            statement.setInt(4, produto.getId());
            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao editar produto: " + e.getMessage());
            return false;
        }
    }

    public boolean deletar(int id) {
        try (Connection con = new Conexao().conectar();
             PreparedStatement statement = con.prepareStatement(
                     "DELETE FROM produtos WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
            return false;
        }
    }
}
