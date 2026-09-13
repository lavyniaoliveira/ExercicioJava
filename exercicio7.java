import java.util.Scanner;

public class Main {

    public static int encontrarPares(int[] vetor, int alvo) {

        int quantidade = 0;

        for (int i = 0; i < vetor.length; i++) {

            for (int j = i + 1; j < vetor.length; j++) {

                if (vetor[i] + vetor[j] == alvo) {

                    System.out.println("Valores: " + vetor[i] + " e " + vetor[j]);
                    System.out.println("Índices: " + i + " e " + j);
                    System.out.println("Soma: " + (vetor[i] + vetor[j]));
                    System.out.println();

                    quantidade++;
                }
            }
        }

        return quantidade;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do vetor: ");
        int tamanho = scanner.nextInt();

        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            System.out.print("Digite o valor " + i + ": ");
            vetor[i] = scanner.nextInt();
        }

        System.out.print("Digite o valor alvo: ");
        int alvo = scanner.nextInt();

        int quantidade = encontrarPares(vetor, alvo);

        if (quantidade == 0) {
            System.out.println("Nenhum par encontrado.");
        } else {
            System.out.println("Quantidade de pares encontrados: " + quantidade);
        }

        scanner.close();
    }
}