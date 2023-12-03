package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Produto;
import entities.Usuario;
import services.CadastroUsuario;
import services.Estoque;

public class Main {
 public static void main(String[] args) {
        CadastroUsuario cadastroUsuario = new CadastroUsuario();
        Estoque estoque = new Estoque();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenuPrincipal();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerenciarUsuarios(cadastroUsuario, scanner);
                    break;
                case 2:
                    gerenciarEstoque(estoque, scanner);
                    break;
                case 0:
                    System.out.println("Sistema Encerrado!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("|----- MENU PRINCIPAL -----|");
        System.out.println("1. Gerenciar Usuários");
        System.out.println("2. Gerenciar Estoque");
        System.out.println("0. Sair");
        System.out.print("Selecione uma opção: ");
    }

    private static void exibirMenuUsuarios() {
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("|----- MENU USUÁRIOS -----|");
        System.out.println("1. Adicionar Usuário");
        System.out.println("2. Remover Usuário");
        System.out.println("3. Buscar Usuário por ID");
        System.out.println("4. Listar Todos os Usuários");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Selecione uma opção: ");
    }

    private static void exibirMenuEstoque() {
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("|----- MENU ESTOQUE -----|");
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Remover Produto");
        System.out.println("3. Buscar Produto por ID");
        System.out.println("4. Listar Todos os Produtos");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Selecione uma opção: ");
    }

    private static void gerenciarUsuarios(CadastroUsuario cadastroUsuario, Scanner scanner) {
        while (true) {
            exibirMenuUsuarios();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarUsuario(cadastroUsuario, scanner);
                    break;
                case 2:
                    removerUsuario(cadastroUsuario, scanner);
                    break;
                case 3:
                    buscarUsuarioPorId(cadastroUsuario, scanner);
                    break;
                case 4:
                    listarTodosUsuarios(cadastroUsuario);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarUsuario(CadastroUsuario cadastroUsuario, Scanner scanner) {
        System.out.print("Digite o ID do usuário: ");
        long id = scanner.nextLong();

        System.out.print("Digite o nome do usuário: ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.print("Digite a descrição do usuário: ");
        String descricao = scanner.nextLine();

        Date dataCriacao = new Date();

        System.out.print("O usuário está ativo? (S - Sim | N - Não): ");
        String resposta = scanner.nextLine();
        boolean ativo = resposta.equalsIgnoreCase("S") ? true : false;

        System.out.print("Digite o email do usuário: ");
        String email = scanner.nextLine();

        System.out.print("Digite a senha do usuário: ");
        String senha = scanner.nextLine();

        Usuario novoUsuario = new Usuario(id, nome, descricao, dataCriacao, ativo, email, senha);
        cadastroUsuario.adicionar(novoUsuario);
        System.out.println("Usuário adicionado com sucesso.");
    }

    private static void removerUsuario(CadastroUsuario cadastroUsuario, Scanner scanner) {
        System.out.print("Digite o ID do usuário a ser removido: ");
        long id = scanner.nextLong();

        cadastroUsuario.remover(id);
        System.out.println("Usuário removido com sucesso.");
    }

    private static void buscarUsuarioPorId(CadastroUsuario cadastroUsuario, Scanner scanner) {
        System.out.print("Digite o ID do usuário a ser buscado: ");
        long id = scanner.nextLong();

        Usuario usuarioEncontrado = (Usuario) cadastroUsuario.buscarPorId(id);
        if (usuarioEncontrado != null) {
            System.out.println();
            System.out.println("----------------------------");
            System.out.println("USUÁRIO ENCONTRADO:");
            System.out.println(usuarioEncontrado.getDetalhes());
        } else {
            System.out.println("Desculpe, este usuário não foi encontrado.");
        }
    }

    private static void listarTodosUsuarios(CadastroUsuario cadastroUsuario) {
        List<Object> usuarios = cadastroUsuario.listarTodos();

        if (!usuarios.isEmpty()) {
            System.out.println();
            System.out.println("----------------------------");
            System.out.println("LISTA DE USUÁRIOS:");
            for (Object obj : usuarios) {
                Usuario usuario = (Usuario) obj;
                System.out.println(usuario.getDetalhes());
            }
        } else {
            System.out.println("Não há usuários cadastrados.");
        }
    }

    private static void gerenciarEstoque(Estoque estoque, Scanner scanner) {
        while (true) {
            exibirMenuEstoque();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProduto(estoque, scanner);
                    break;
                case 2:
                    removerProduto(estoque, scanner);
                    break;
                case 3:
                    buscarProdutoPorId(estoque, scanner);
                    break;
                case 4:
                    listarTodosProdutos(estoque);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarProduto(Estoque estoque, Scanner scanner) {
        System.out.print("Digite o ID do produto: ");
        long id = scanner.nextLong();

        System.out.print("Digite o nome do produto: ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.print("Digite a descrição do produto: ");
        String descricao = scanner.nextLine();

        Date dataCriacao = new Date();

        System.out.print("O produto está ativo? (S - Sim | N - Não): ");
        String resposta = scanner.nextLine();
        boolean ativo = resposta.equalsIgnoreCase("S") ? true : false;

        System.out.print("Digite o preço do produto: ");
        double price = scanner.nextDouble();

        System.out.print("Digite a quantidade em estoque do produto: ");
        int quantidadeEstoque = scanner.nextInt();

        Produto novoProduto = new Produto(id, nome, descricao, dataCriacao, ativo, price, quantidadeEstoque);
        estoque.adicionar(novoProduto);
        System.out.println("Produto adicionado com sucesso.");
    }

    private static void removerProduto(Estoque estoque, Scanner scanner) {
        System.out.print("Digite o ID do produto a ser removido: ");
        long id = scanner.nextLong();

        estoque.remover(id);
        System.out.println("Produto removido com sucesso.");
    }

    private static void buscarProdutoPorId(Estoque estoque, Scanner scanner) {
        System.out.print("Digite o ID do produto a ser buscado: ");
        long id = scanner.nextLong();

        Produto produtoEncontrado = (Produto) estoque.buscarPorId(id);
        if (produtoEncontrado != null) {
            System.out.println();
            System.out.println("----------------------------");
            System.out.println("PRODUTO ENCONTRADO: ");
            System.out.println(produtoEncontrado.getDetalhes());
        } else {
            System.out.println("Desculpe, este produto não foi encontrado.");
        }
    }

    private static void listarTodosProdutos(Estoque estoque) {
        List<Object> produtos = estoque.listarTodos();

        if (!produtos.isEmpty()) {
            System.out.println();
            System.out.println("----------------------------");
            System.out.println("LISTA DE PRODUTOS: ");
            for (Object obj : produtos) {
                Produto produto = (Produto) obj;
                System.out.println(produto.getDetalhes());
            }
        } else {
            System.out.println("Não há produtos no estoque.");
        }
    }
}