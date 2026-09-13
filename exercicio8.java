import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void adicionar(
            ArrayList<String> nomes,
            ArrayList<Integer> quantidades,
            ArrayList<Double> precos,
            Scanner scanner) {

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        int posicao = nomes.indexOf(nome);

        if (posicao >= 0) {
            System.out.println("Esse produto já existe.");
            System.out.print("Deseja aumentar a quantidade? (s/n): ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                System.out.print("Digite a quantidade para adicionar: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                if (quantidade > 0) {
                    quantidades.set(posicao, quantidades.get(posicao) + quantidade);
                    System.out.println("Quantidade atualizada!");
                } else {
                    System.out.println("Quantidade inválida.");
                }
            }

            return;
        }

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        if (quantidade <= 0 || preco <= 0) {
            System.out.println("Quantidade ou preço inválido.");
            return;
        }

        nomes.add(nome);
        quantidades.add(quantidade);
        precos.add(preco);

        System.out.println("Produto adicionado!");
    }

    public static void alterarQuantidade(
            ArrayList<String> nomes,
            ArrayList<Integer> quantidades,
            Scanner scanner) {

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        int posicao = nomes.indexOf(nome);

        if (posicao >= 0) {
            System.out.print("Digite a nova quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            if (quantidade > 0) {
                quantidades.set(posicao, quantidade);
                System.out.println("Quantidade alterada!");
            } else {
                System.out.println("Quantidade inválida.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void alterarPreco(
            ArrayList<String> nomes,
            ArrayList<Double> precos,
            Scanner scanner) {

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        int posicao = nomes.indexOf(nome);

        if (posicao >= 0) {
            System.out.print("Digite o novo preço: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            if (preco > 0) {
                precos.set(posicao, preco);
                System.out.println("Preço alterado!");
            } else {
                System.out.println("Preço inválido.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void remover(
            ArrayList<String> nomes,
            ArrayList<Integer> quantidades,
            ArrayList<Double> precos,
            Scanner scanner) {

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        int posicao = nomes.indexOf(nome);

        if (posicao >= 0) {
            nomes.remove(posicao);
            quantidades.remove(posicao);
            precos.remove(posicao);

            System.out.println("Produto removido!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void pesquisar(
            ArrayList<String> nomes,
            ArrayList<Integer> quantidades,
            ArrayList<Double> precos,
            Scanner scanner) {

        System.out.print("Digite o nome ou parte do nome: ");
        String busca = scanner.nextLine().toLowerCase();

        boolean encontrou = false;

        for (int i = 0; i < nomes.size(); i++) {

            if (nomes.get(i).toLowerCase().contains(busca)) {
                double subtotal = quantidades.get(i) * precos.get(i);

                System.out.println(
                        nomes.get(i) +
                        " | Quantidade: " + quantidades.get(i) +
                        " | Preço: R$ " + precos.get(i) +
                        " | Subtotal: R$ " + subtotal
                );

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void listar(
            ArrayList<String> nomes,
            ArrayList<Integer> quantidades,
            ArrayList<Double> precos) {

        if (nomes.isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }

        for (int i = 0; i < nomes.size(); i++) {

            double subtotal = quantidades.get(i) * precos.get(i);

            System.out.println(
                    (i + 1) + ". " + nomes.get(i) +
                    " | Quantidade: " + quantidades.get(i) +
                    " | Preço: R$ " + precos.get(i) +
                    " | Subtotal: R$ " + subtotal
            );
        }
    }

    public static double valorTotal(
            ArrayList<Integer> quantidades,
            ArrayList<Double> precos) {

        double total = 0;

        for (int i = 0; i < quantidades.size(); i++) {
            total += quantidades.get(i) * precos.get(i);
        }

        return total;
    }

    public static void maiorSubtotal(
            ArrayList<String> nomes,
            ArrayList<Integer> quantidades,
            ArrayList<Double> precos) {

        if (nomes.isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }

        int maior = 0;

        for (int i = 1; i < nomes.size(); i++) {

            double subtotalAtual = quantidades.get(i) * precos.get(i);
            double subtotalMaior = quantidades.get(maior) * precos.get(maior);

            if (subtotalAtual > subtotalMaior) {
                maior = i;
            }
        }

        double subtotal = quantidades.get(maior) * precos.get(maior);

        System.out.println("Produto com maior subtotal: " + nomes.get(maior));
        System.out.println("Subtotal: R$ " + subtotal);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();
        ArrayList<Double> precos = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n--- LISTA DE COMPRAS ---");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Alterar quantidade");
            System.out.println("3. Alterar preço");
            System.out.println("4. Remover produto");
            System.out.println("5. Pesquisar produto");
            System.out.println("6. Listar produtos");
            System.out.println("7. Valor total");
            System.out.println("8. Maior subtotal");
            System.out.println("9. Encerrar");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    adicionar(nomes, quantidades, precos, scanner);
                    break;

                case 2:
                    alterarQuantidade(nomes, quantidades, scanner);
                    break;

                case 3:
                    alterarPreco(nomes, precos, scanner);
                    break;

                case 4:
                    remover(nomes, quantidades, precos, scanner);
                    break;

                case 5:
                    pesquisar(nomes, quantidades, precos, scanner);
                    break;

                case 6:
                    listar(nomes, quantidades, precos);
                    break;

                case 7:
                    System.out.println("Valor total: R$ " +
                            valorTotal(quantidades, precos));
                    break;

                case 8:
                    maiorSubtotal(nomes, quantidades, precos);
                    break;

                case 9:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 9);

        scanner.close();
    }
}