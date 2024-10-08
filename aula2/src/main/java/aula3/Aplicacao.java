package aula3;

import java.util.ArrayList;
import java.util.Scanner;

import aula3.dao.UsuarioDAO;
import aula3.model.Usuario;

public class Aplicacao {
	
	@SuppressWarnings("finally")
	public static int leiaInt(String num) {

		int n = 0;

		while (true) {
			try {
				n = Integer.valueOf(num);
			} catch (Exception e) {
				System.out.println("ERRO! Digite apenas números inteiros");				
			} finally {
				return n;
			}
		}
		
	}

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);
		int opc;

		while (true) {

			System.out.println("|ESCOLHA UMA OPÇÃO|");
			System.out.println("|-----------------|");
			System.out.println("|1-Inserir usuário|");
			System.out.println("|2-Listar Banco   |");
			System.out.println("|-----------------|");
			System.out.println("|-----------------|");
			System.out.println("|-----------------|");
			System.out.println("|-----------------|");

			System.out.println("Opção: ");
			opc = leiaInt(entrada.next());
			

			if (opc == 1) {

				System.out.println("\n#### INSERIR USUÁRIO ####\n");

				System.out.println("\nDigite seu cpf: ");
				String cpf = entrada.next();

				UsuarioDAO usuarioDAO = new UsuarioDAO();
				boolean existe;

				existe = usuarioDAO.ifExisteCpf(cpf);

				if (existe) {
					System.out.println("\nCPF já cadastrado na base de dados");

				} else {
					usuarioDAO.inserirUsuario(cpf);
				}
			} else if (opc == 2) {
				
				System.out.println("\n#### LISTAR USUÁRIOS ####\n");

				UsuarioDAO usuarioDAO = new UsuarioDAO();
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
				
				usuarios = usuarioDAO.listarTodos();
				
				for (Usuario usuario : usuarios) {
					System.out.println(usuario);
				}

			}

		}

	}

}
