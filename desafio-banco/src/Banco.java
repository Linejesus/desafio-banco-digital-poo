import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {

	private String nome;
	private List<Conta> contas;
	private List<Cliente> clientes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public List<Cliente> getClientes() {
        return clientes;
    }

    public Banco() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

	public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void deletarCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome());
        }
    }

	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			Banco banco = new Banco();

			int opcao = -1;

			while (opcao != 0) {    
			System.out.println("Menu Principal: ");
			System.out.println("1. Novo cliente");
			System.out.println("2. Deletar cliente");
			System.out.println("3. Listar clientes");
			System.out.println("0. Sair");
			System.out.println("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();

			if(opcao == 0){
				System.out.println("Saindo da Conta...");
			}
			else if(opcao == 1)
			{
				System.out.print("Digite o nome do novo cliente: ");
                String nomeUsuario = scanner.next();
                Cliente novoCliente = new Cliente();
                novoCliente.setNome(nomeUsuario);
                banco.adicionarCliente(novoCliente);
			}
			else if(opcao == 2)
			{
				System.out.print("Digite o nome do cliente que deseja deletar: ");
                String clienteDeletar = scanner.next();
                List<Cliente> clientes = banco.getClientes();
                Cliente clienteParaDeletar = null;
                for (Cliente c : clientes) {
                    if (c.getNome().equals(clienteDeletar)) {
                        clienteParaDeletar = c;
                        break;
                    }
                }
                if (clienteParaDeletar != null) {
                    banco.deletarCliente(clienteParaDeletar);
                    System.out.println("Cliente deletado com sucesso.");
                } else {
                    System.out.println("Cliente não encontrado.");
                }
			}
			else if(opcao == 3)
			{
				System.out.println("Lista de clientes:");
				banco.listarClientes();
			}
			else {
				System.out.println("Digite uma opção válida!");
			}

		}

        scanner.close();
    }

}