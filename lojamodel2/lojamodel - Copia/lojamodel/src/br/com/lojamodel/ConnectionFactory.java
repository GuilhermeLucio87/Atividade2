package br.com.lojamodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class ConnectionFactory {

	private static Connection conn;

	public static Connection getConnectionJDBC() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:h2:bancodedados/db", "sa", "");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return conn;
	}

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:h2:bancodedados/db", "sa", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws SQLException {

        // conectando
        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
            // cria um preparedStatement
            String sql = "insert into contatos" +
                    " (nome,email,endereco,dataNascimento)" +
                    " values (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            // preenche os valores
            stmt.setString(1, "Uninove");
            stmt.setString(2, "contato@uninove.com.br");
            stmt.setString(3, "R. Bla Bla ");
            stmt.setDate(4, new java.sql.Date(
                    Calendar.getInstance().getTimeInMillis()));

            // executa
            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");            
        }catch(SQLException e) {
        	System.out.println(e);
		} finally {
			con.close();
		}
	}

     
    }
