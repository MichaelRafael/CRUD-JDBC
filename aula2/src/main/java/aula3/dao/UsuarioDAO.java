package aula3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.security.sasl.SaslException;

import aula3.interfaceDAO.InterfaceDAO;
import aula3.model.Usuario;
import aula3.utils.FabricaDeConexao;

//DAO = Data access object
public class UsuarioDAO implements InterfaceDAO {

	
	@Override
	public void inserirUsuario(String cpf) {

		Scanner entrada = new Scanner(System.in);
		PreparedStatement pstm;

		String url = "insert into usuario (nome, cpf, idade, altura, genero) values (?, ?, ?, ?, ?)";

		System.out.println("Digite seu nome:  ");
		String nome= entrada.nextLine();		
		
		System.out.println("Digite sua idade ");
		int idade = entrada.nextInt();

		System.out.println("Digite sua altura ");
		double altura = entrada.nextDouble();
		entrada.nextLine();

		System.out.println("Digite seu gênero [M/F] ");
		String genero = entrada.nextLine();

		Usuario usuario = new Usuario(nome, cpf, idade, altura, genero);

		try {

			pstm = FabricaDeConexao.getConnection().prepareStatement(url);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getCpf());
			pstm.setInt(3, usuario.getIdade());
			pstm.setDouble(4, usuario.getAltura());
			pstm.setString(5, usuario.getGenero());

			pstm.execute();
			pstm.close();

			System.out.println("Usuário inserio com sucesso");

		} catch (Exception e) {

			System.out.println("Erro ao inserir usuário");
		}
	}
	
	public boolean ifExisteCpf(String cpf) {
		
		PreparedStatement pstm;
		ResultSet rs;
		boolean existe = false;
		
		String url = "select cpf from usuario where cpf = ?";
		
		try {
			
			pstm = FabricaDeConexao.getConnection().prepareStatement(url);
			pstm.setString(1, cpf);
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				existe = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public ArrayList<Usuario> listarTodos() {
		
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		
		String url = "select * from usuario";
		
		try {
			
			pstm = FabricaDeConexao.getConnection().prepareStatement(url);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				int idade = rs.getInt("idade");
				double altura = rs.getDouble("altura");
				String genero = rs.getString("genero");
				
				Usuario usuario = new Usuario(nome, cpf, idade, altura, genero);
				
				usuarios.add(usuario);
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return usuarios;
	}
	
	

	@Override
	public void listarUsuario(String cpf) {
		
		PreparedStatement pstm;
		ResultSet rs;
		
		String url = "Select * from usuario where cpf = ?";
		
		
		
		try {
			pstm = FabricaDeConexao.getConnection().prepareStatement(url);
			pstm.setString(1, cpf);
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				
				String nome = rs.getString("nome");
				String cpf1 = rs.getString("cpf");
				int idade = rs.getInt("idade");
				double altura = rs.getDouble("altura");
				String genero = rs.getString("genero");
				
				Usuario usuario = new Usuario(nome, cpf, idade, altura, genero);
				
				System.out.println(usuario.toString());
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void atualizarUsuario(String cpf) {
		
		PreparedStatement pstm;
		String url = "update usuario set nome = ?, idade = ? , altura = ?, genero = ? where cpf = ?";
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite seu nome:  ");
		String nome= entrada.nextLine();		
		
		System.out.println("Digite sua idade ");
		int idade = entrada.nextInt();

		System.out.println("Digite sua altura ");
		double altura = entrada.nextDouble();
		entrada.nextLine();
		
		System.out.println("Digite seu gênero [M/F] ");
		String genero = entrada.nextLine();

		try {
			
			pstm = FabricaDeConexao.getConnection().prepareStatement(url);
			
			pstm.setString(1, nome);
			pstm.setString(2, cpf);
			pstm.setInt(3, idade);
			pstm.setDouble(4, altura);
			pstm.setString(5, genero);
			pstm.setString(6, cpf);


			pstm.executeUpdate();				
			
			pstm.close();	
			
			System.out.println("\nDados alterados com sucesso!\n");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void excluirUsuario(String cpf) {

		PreparedStatement pstm;
		
		String url = "delete from usuario where cpf = ?";
		
		try {
			
			pstm = FabricaDeConexao.getConnection().prepareStatement(url);
			pstm.setString(1, cpf);
			
			pstm.execute();
			pstm.close();
			
			System.out.println("\nContato excluido com sucesso!");
			
		} catch (Exception e) {

			System.out.println("\nErro ao excluir contato");
		}

	}

}
