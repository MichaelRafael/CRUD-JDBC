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

		String url = "insert into usuario (cpf, idade, altura, genero) values (?, ?, ?, ?)";

		System.out.println("Digite sua idade ");
		int idade = entrada.nextInt();

		System.out.println("Digite sua altura ");
		double altura = entrada.nextDouble();
		entrada.nextLine();

		System.out.println("Digite seu gênero [M/F] ");
		String genero = entrada.nextLine();

		Usuario usuario = new Usuario(cpf, idade, altura, genero);

		try {

			pstm = FabricaDeConexao.getConnection().prepareStatement(url);
			pstm.setString(1, usuario.getCpf());
			pstm.setInt(2, usuario.getIdade());
			pstm.setDouble(3, usuario.getAltura());
			pstm.setString(4, usuario.getGenero());

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
				
				String cpf = rs.getString("cpf");
				int idade = rs.getInt("idade");
				double altura = rs.getDouble("altura");
				String genero = rs.getString("genero");
				
				Usuario usuario = new Usuario(cpf, idade, altura, genero);
				
				usuarios.add(usuario);
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return usuarios;
	}
	
	

	@Override
	public void listarUsuario(String cpf) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizarUsuario(String cpf) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluirUsuario(String cpf) {
		// TODO Auto-generated method stub

	}
//inserir (insert), excluir (delete), alterar (update) e consultar (select)
//inserir (create), e consultar (recovery), alterar (update), excluir (delete)

}
