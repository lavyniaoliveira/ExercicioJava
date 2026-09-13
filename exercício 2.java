import java.util.Scanner;

public class Main {

    public static boolean bissexto(int ano) {
        return ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0);
    }

    public static int diasMes(int mes, int ano) {

        if (mes == 2) {
            if (bissexto(ano)) {
                return 29;
            } else {
                return 28;
            }
        }

        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        }

        return 31;
    }

    public static boolean validar(int dia, int mes, int ano) {

        if (ano <= 0 || mes < 1 || mes > 12) {
            return false;
        }

        if (dia < 1 || dia > diasMes(mes, ano)) {
            return false;
        }

        return true;
    }

    public static int posicaoAno(int dia, int mes, int ano) {

        int total = dia;

        for (int i = 1; i < mes; i++) {
            total += diasMes(i, ano);
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o dia: ");
        int dia = scanner.nextInt();

        System.out.print("Digite o mês: ");
        int mes = scanner.nextInt();

        System.out.print("Digite o ano: ");
        int ano = scanner.nextInt();

        if (validar(dia, mes, ano)) {

            int trimestre = (mes - 1) / 3 + 1;
            int posicao = posicaoAno(dia, mes, ano);

            System.out.println("Data válida!");
            System.out.println("Trimestre: " + trimestre + "º");
            System.out.println("Posição no ano: " + posicao + "º dia");

        } else {

            System.out.println("Data inválida!");

        }

        scanner.close();
    }
}