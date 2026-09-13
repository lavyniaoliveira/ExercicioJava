import java.util.Scanner;

public class Main {

    public static void exibir(boolean[][] sala) {

        System.out.println("\n--- MAPA DE ASSENTOS ---");

        for (int i = 0; i < sala.length; i++) {

            System.out.print("Fileira " + (i + 1) + ": ");

            for (int j = 0; j < sala[i].length; j++) {

                if (sala[i][j]) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[O] ");
                }
            }

            System.out.println();
        }
    }

    public static void reservar(boolean[][] sala, Scanner scanner) {

        System.out.print("Digite a fileira: ");
        int fileira = scanner.nextInt() - 1;

        System.out.print("Digite o assento: ");
        int assento = scanner.nextInt() - 1;

        if (fileira < 0 || fileira >= sala.length ||
            assento < 0 || assento >= sala[0].length) {

            System.out.println("Assento inválido.");
            return;
        }

        if (sala[fileira][assento]) {
            System.out.println("Esse assento já está ocupado.");
        } else {
            sala[fileira][assento] = true;
            System.out.println("Assento reservado!");
        }
    }

    public static void cancelar(boolean[][] sala, Scanner scanner) {

        System.out.print("Digite a fileira: ");
        int fileira = scanner.nextInt() - 1;

        System.out.print("Digite o assento: ");
        int assento = scanner.nextInt() - 1;

        if (fileira < 0 || fileira >= sala.length ||
            assento < 0 || assento >= sala[0].length) {

            System.out.println("Assento inválido.");
            return;
        }

        if (!sala[fileira][assento]) {
            System.out.println("Esse assento está livre.");
        } else {
            sala[fileira][assento] = false;
            System.out.println("Reserva cancelada!");
        }
    }

    public static void mostrarOcupacao(boolean[][] sala) {

        int ocupados = 0;
        int total = sala.length * sala[0].length;

        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {

                if (sala[i][j]) {
                    ocupados++;
                }
            }
        }

        double percentual = (double) ocupados / total * 100;

        System.out.println("Assentos ocupados: " + ocupados);
        System.out.printf("Ocupação: %.2f%%%n", percentual);
    }

    public static void maiorOcupacao(boolean[][] sala) {

        int maior = 0;
        int fileiraMaior = 0;

        for (int i = 0; i < sala.length; i++) {

            int ocupados = 0;

            for (int j = 0; j < sala[i].length; j++) {

                if (sala[i][j]) {
                    ocupados++;
                }
            }

            if (ocupados > maior) {
                maior = ocupados;
                fileiraMaior = i;
            }
        }

        System.out.println("Fileira com maior ocupação: " +
                (fileiraMaior + 1));
        System.out.println("Quantidade ocupada: " + maior);
    }

    public static void procurarConsecutivos(
            boolean[][] sala,
            Scanner scanner) {

        System.out.print("Quantos assentos deseja encontrar? ");
        int quantidade = scanner.nextInt();

        if (quantidade <= 0 || quantidade > sala[0].length) {
            System.out.println("Quantidade inválida.");
            return;
        }

        for (int i = 0; i < sala.length; i++) {

            int contador = 0;

            for (int j = 0; j < sala[i].length; j++) {

                if (!sala[i][j]) {
                    contador++;
                } else {
                    contador = 0;
                }

                if (contador == quantidade) {

                    int inicio = j - quantidade + 1;

                    System.out.println(
                            "Encontrado na fileira " + (i + 1)
                    );

                    System.out.println(
                            "Assentos: " + (inicio + 1) +
                            " até " + (j + 1)
                    );

                    return;
                }
            }
        }

        System.out.println("Não foi encontrado um conjunto disponível.");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean[][] sala = new boolean[5][10];

        int opcao;

        do {

            System.out.println("\n--- CINEMA ---");
            System.out.println("1. Exibir mapa");
            System.out.println("2. Reservar assento");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Ocupação");
            System.out.println("5. Fileira com maior ocupação");
            System.out.println("6. Procurar assentos consecutivos");
            System.out.println("7. Encerrar");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    exibir(sala);
                    break;

                case 2:
                    reservar(sala, scanner);
                    break;

                case 3:
                    cancelar(sala, scanner);
                    break;

                case 4:
                    mostrarOcupacao(sala);
                    break;

                case 5:
                    maiorOcupacao(sala);
                    break;

                case 6:
                    procurarConsecutivos(sala, scanner);
                    break;

                case 7:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 7);

        scanner.close();
    }
}