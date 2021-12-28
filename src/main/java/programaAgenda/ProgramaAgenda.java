package programaAgenda;

import java.util.Objects;

import javax.swing.JOptionPane;

import dataBase.CriarBancoDados;
import rotinas.AtualizarContato;
import rotinas.DeletarContato;
import rotinas.ExibirContatos;
import rotinas.NovoContato;
import rotinas.ProcurarPorNome;

public class ProgramaAgenda {

	public static void main(String[] args) {

		int controle = 1;

		while (controle != 0) {
			try {
				String escolha = JOptionPane.showInputDialog(null,
						"Digite a opção desejada: \n".toUpperCase() 
						+ "1- Cadastrar Novo Contato \n"
						+ "2- Atualizar Contato \n" 
						+ "3- Deletar Contato \n"
						+ "4- Exibir Todos os Contatos \n"
						+ "5- Procurar por nome \n", "MENU PRINCIPAL", JOptionPane.PLAIN_MESSAGE);

				if (Objects.nonNull(escolha)) {
					switch (Integer.parseInt(escolha)) {
					case 0:
						controle = 0;
						break;
					case 1:
						CriarBancoDados.criar();
						NovoContato.cadastrar();
						break;
					case 2:						
						String att = JOptionPane.showInputDialog(null,
								"Digite a opção desejada: \n".toUpperCase() 
								+ "1- Atualizar Nome. \n"
								+ "2- Atualizar E-mail. \n" 
								+ "3- Atualizar Telefone. \n"
								+ "4- Atualizar Endereço. \n"
								+ "5- Atualizar Tudo. \n", "MENU ATUALIZAR", JOptionPane.PLAIN_MESSAGE);
						if(Objects.isNull(att)) {
							break;
						}						
						String id = JOptionPane.showInputDialog(null, "ID: ", "ATUALIZAR CONTATO", JOptionPane.PLAIN_MESSAGE);		
						if(Objects.isNull(id)) {
							break;
						}
						AtualizarContato.menuAtualizar(id, att);						
						break;
					case 3:
						id = JOptionPane.showInputDialog(null, "ID: ", "DELETAR CONTATO", JOptionPane.PLAIN_MESSAGE);
						if(Objects.isNull(id)) {
							break;
						}
						DeletarContato.deletarContato(Integer.parseInt(id));
						break;
					case 4:
						ExibirContatos.exibirTodos();
						break;
					case 5:
						String nome = JOptionPane.showInputDialog(null, "NOME: ", "PROCURAR POR NOME", JOptionPane.PLAIN_MESSAGE);	
						if(Objects.isNull(nome)) {
							break;
						}
						ProcurarPorNome.procurar(nome);
						break;
					default:
						JOptionPane.showMessageDialog(null,"OPÇÃO ESCOLHIDA É INVÁLIDA", "OPÇÃO INVÁLIDA", JOptionPane.PLAIN_MESSAGE);
						break;
					}
				} else {
					controle = 0;
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Entrada Inválida. Digite Novamente.", "ERRO", JOptionPane.PLAIN_MESSAGE);
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, "Erro Desconhecido", "ERRO", JOptionPane.PLAIN_MESSAGE);
				System.out.println(e);
			}

		}

	}

}
