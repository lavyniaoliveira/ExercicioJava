import java.util.Scanner;

public class Main {

    public static boolean positivo(int numero) {
        return numero > 0;
    }

    public static boolean negativo(int numero) {
        return numero < 0;
    }

    public static boolean par(int numero) {
        return numero % 2 == 0;
    }

    public static boolean multiploDeTres(int numero) {
        return numero % 3 == 0;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numero;
        int quantidade = 0;
        int soma = 0;
        int maior = 0;
        int menor = 0;
        int positivos = 0;
        int negativos = 0;
        int pares = 0;
        int impares = 0;
        int multiplosDeTres = 0;

        System.out.println("Digite números inteiros");
        System.out.println("Digite 0 para encerrar");

        while (true) {

            System.out.print("Digite um número: ");
            numero = scanner.nextInt();

            if (numero == 0) {
                break;
            }

            if (quantidade == 0) {
                maior = numero;
                menor = numero;
            }

            quantidade++;
            soma += numero;

            if (numero > maior) {
                maior = numero;
            }

            if (numero < menor) {
                menor = numero;
            }

            if (positivo(numero)) {
                positivos++;
            }

            if (negativo(numero)) {
                negativos++;
            }

            if (par(numero)) {
                pares++;
            } else {
                impares++;
            }

            if (multiploDeTres(numero)) {
                multiplosDeTres++;
            }
        }

        System.out.println("\n--- ESTATÍSTICAS ---");

        if (quantidade == 0) {
            System.out.println("Nenhum número foi digitado.");
        } else {

            double media = (double) soma / quantidade;

            System.out.println("Quantidade de números: " + quantidade);
            System.out.println("Soma: " + soma);
            System.out.printf("Média: %.2f%n", media);
            System.out.println("Maior valor: " + maior);
            System.out.println("Menor valor: " + menor);
            System.out.println("Valores positivos: " + positivos);
            System.out.println("Valores negativos: " + negativos);
            System.out.println("Valores pares: " + pares);
            System.out.println("Valores ímpares: " + impares);
            System.out.println("Múltiplos de três: " + multiplosDeTres);
        }

        scanner.close();
    }
}