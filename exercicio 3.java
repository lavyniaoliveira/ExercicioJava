import java.util.Scanner;

public class Main {

    public static double soma(double a, double b) {
        return a + b;
    }

    public static double subtracao(double a, double b) {
        return a - b;
    }

    public static double multiplicacao(double a, double b) {
        return a * b;
    }

    public static double divisao(double a, double b) {
        return a / b;
    }

    public static double potenciacao(double a, double b) {
        return Math.pow(a, b);
    }

    public static double resto(double a, double b) {
        return a % b;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n--- CALCULADORA ---");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Potenciação");
            System.out.println("6. Resto da divisão");
            System.out.println("7. Encerrar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 6) {

                System.out.print("Digite o primeiro valor: ");
                double valor1 = scanner.nextDouble();

                System.out.print("Digite o segundo valor: ");
                double valor2 = scanner.nextDouble();

                switch (opcao) {
                    case 1:
                        System.out.println("Resultado: " + soma(valor1, valor2));
                        break;

                    case 2:
                        System.out.println("Resultado: " + subtracao(valor1, valor2));
                        break;

                    case 3:
                        System.out.println("Resultado: " + multiplicacao(valor1, valor2));
                        break;

                    case 4:
                        if (valor2 == 0) {
                            System.out.println("Erro: não é possível dividir por zero.");
                        } else {
                            System.out.println("Resultado: " + divisao(valor1, valor2));
                        }
                        break;

                    case 5:
                        System.out.println("Resultado: " + potenciacao(valor1, valor2));
                        break;

                    case 6:
                        if (valor2 == 0) {
                            System.out.println("Erro: não é possível calcular resto com divisor zero.");
                        } else {
                            System.out.println("Resultado: " + resto(valor1, valor2));
                        }
                        break;
                }

            } else if (opcao != 7) {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 7);

        System.out.println("Calculadora encerrada.");

        scanner.close();
    }
}
