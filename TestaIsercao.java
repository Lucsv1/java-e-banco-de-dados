ipackage Testes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.Doc;

import DAO.ContatoDao;
import DAO.VeiculosDao;
import Models.Contato;
import Models.Veiculo;

public class TestaIsercao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner ent = new Scanner(System.in);
		Contato contato = new Contato();
		ContatoDao daoc = new ContatoDao();
		ArrayList<Contato> listaContatos = new ArrayList<Contato>();
		ArrayList<Contato> listaTipo = new ArrayList<Contato>();
		int opAlt = 0;
		int op = 0;
		System.out.println("1- Adicionar\n 2- buscar todas as infos\n 3- buscar tipo\n 4 - Remover contato\\n 5 - Alterar algum dado");
		op = ent.nextInt();
		while(op != 6) {
			if(op == 1 ) {
				System.out.println("Digite o nome do contato: ");
				contato.setNome(ent.next());
				System.out.println("Digite o numero do celualar: ");
				contato.setCelular(ent.next());
				System.out.println("Digite o email: ");
				contato.setEmail(ent.next());
				System.out.println("Digite o tipo de contato: ");
				contato.setTipo(ent.next());
				System.out.println("Digite o id do contato");
				contato.setId(ent.nextInt());
				daoc.inserir(contato);
				break;
				
			}
			else {
				break;
			}
		}
		
		if (op == 2) {
		listaContatos = daoc.busacarTodosContatos();
		String dados = "";
		for (Contato contato2 : listaContatos) {
			dados += "-----------------------------\n";
		    dados += "Id " + contato2.getId() + "\n";
		    dados += "Nome " + contato2.getNome() + "\n";
		    dados += "Celular " + contato2.getCelular() + "\n";
		    dados += "Email " + contato2.getEmail()+ "\n";
		    dados += "Tipo " + contato2.getTipo()+ "\n";
		    dados += "------------------------------\n";}
		    System.out.println(dados);
		}
		if (op == 3) {
			System.out.println("Digite qual o id que deseja procurar para o tipo: ");
			int id = ent.nextInt();
			listaTipo = daoc.buscarPorTipo(id);
			String dadosTipo = "";
			for (Contato contatoTipo : listaTipo) {
				dadosTipo += "Tipo: " + contatoTipo.getTipo() + "\n";
				System.out.println(dadosTipo);
			}
			
		}
		 if(op == 4) {
		    	Contato c = new Contato();
		    	System.out.println("Digite o ID do cadastro que deseja excluir");
		    	c.setId(ent.nextInt());
		    	daoc.remover(c);
	}
		 if (op == 5) {
			 System.out.println("Digite o id no qual deseja alterar");
			 int id = ent.nextInt();
			 daoc.buscarId(id);
			 ent = new Scanner(System.in);
		 while(opAlt != 5) {	 
				 System.out.println("Qual campo deseja fazer a atleração ?\n 1- nome \n2- numero \n3- email \n4- Tipo do contato ");
				 opAlt = ent.nextInt();
				 switch (opAlt) {
				case 1: {
					System.out.println("Altere o nome: ");
					contato.setNome(ent.next());
					System.out.println("Deseja continuar ? 1- Nao 2 Sim");
				}break;
				case 2: {
					System.out.println("Altere o numero de celular: ");
					contato.setCelular(ent.next());
				}break;
				case 3: {
					System.out.println("Altere o email : ");
					contato.setEmail(ent.next());
				}break;
				case 4: {
					System.out.println("Altere o tipo do contato: ");
					contato.setTipo(ent.next());
				}break;
				
		     }
				 
		 }
		 daoc.alterar(contato);
		}
		 else {
			 
		 }
		/*Veiculo veic = new Veiculo();
		VeiculosDao daov = new VeiculosDao();
		
		System.out.println("Digite a placa: ");
		veic.setPlaca(ent.nextLine());
		System.out.println("Digite a renavam: ");
		veic.setRenavam(ent.nextLine());
		System.out.println("Digite o ano: ");
		veic.setAno(ent.nextLine());
		System.out.println("Digite o ID do carro:");
		veic.setId(ent.nextInt());
		
		daov.inserir(veic);*/
	
		
		
	}

}
