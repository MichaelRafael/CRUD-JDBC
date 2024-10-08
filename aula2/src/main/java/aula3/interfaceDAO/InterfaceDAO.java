package aula3.interfaceDAO;

import java.util.ArrayList;

import aula3.model.Usuario;

public interface InterfaceDAO {
	
	public void inserirUsuario(String cpf);
	public ArrayList<Usuario> listarTodos();
	public void listarUsuario(String cpf);
	public void atualizarUsuario(String cpf);
	public void excluirUsuario(String cpf);

}
