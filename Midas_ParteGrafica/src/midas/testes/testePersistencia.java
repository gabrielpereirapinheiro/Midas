package midas.testes;

import static org.junit.Assert.*;

import java.awt.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import midas.dao.UsuarioDAO;
import midas.entidades.Usuario;

@RunWith(JUnit4.class)
public class testePersistencia {

	private Usuario user;
	private Usuario user2;
	private Usuario user3;
	private UsuarioDAO bd;
	private List nao_autorizados;

	@Before 
	public void setUp(){
		user = new Usuario();
		user.setCpf("11111111111");
		user.setEmail("pepeca_colorida@gmail.com");
		user.setEndereco("De baixo da ponte");
		user.setNivelDeAcesso(0);
		user.setSenha("alvinlelek");
		user.setProfissao("engenheiro");
		user.setNome("Ismael");
		user.setSexo('M');
		user.setDataNascimento("");
		
		bd = new UsuarioDAO();
	}
	
	public void comecarOperacoes(){
		UsuarioDAO.comecarOperacoes();
	}
	public void finalizarOperacoes(){
		UsuarioDAO.finalizarOperacoes();
	}

	
	
	
	public void testRemover(){
		comecarOperacoes();
		bd.remover("11111111110");
		finalizarOperacoes();
	}
	
	
	public void testInsere() {

		comecarOperacoes();
		bd.inserir(user);
		finalizarOperacoes();
	}
	@Test
	public void testRecupera(){
		comecarOperacoes();
		user2 = bd.recuperar(user.getCpf());
		//System.out.println("CPF DO USER: "+ user2.getCpf());
		finalizarOperacoes();
	}
	@Test
	public void testListarNaoAutorizados(){
		comecarOperacoes();
		nao_autorizados = (List) bd.listarNaoAutorizado();
		
		finalizarOperacoes();
	}
	@Test
	public void testLogin(){ // deu como teste correto mas retornou Usuario e senha não batem
		comecarOperacoes();
		boolean cadastrado = bd.login("11111111110", "alvinlelek");
		if (cadastrado == true)
			System.out.println("Usuario e senha são corretas");
		else
			System.out.println("Usuario e senha não batem");
	}
	
	@Test
	public void testAutorizar(){
		comecarOperacoes();
		
		boolean acesso = bd.autorizar("11111111110");
		if (acesso == true)
			System.out.println("Nivel de acesso: 1");
		else
			System.out.println("Nivel de acessso: 0");
		
		
		finalizarOperacoes();
		
	}
	@Test
	public void testVeirificaUsuario(){
		comecarOperacoes();
		
//		boolean existe = bd.verificaExisteUsuario("11111111110");
//		if (existe == true)
//			System.out.println("Usuario existe");
//		else
//			System.out.println("Usuario não existe");
		if(null != bd.recuperar("11111111110"))
			System.out.println("Usuario existe");
		else
			System.out.println("Usuario não existe");
		
		finalizarOperacoes();
	}
	
}