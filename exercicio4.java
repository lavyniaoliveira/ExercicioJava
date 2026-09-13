import java.util.Scanner;

public class Main {

    public static int contarLetras(String frase) {
        int total = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (Character.isLetter(frase.charAt(i))) {
                total++;
            }
        }

        return total;
    }

    public static int contarVogais(String frase) {
        int total = 0;

        for (int i = 0; i < frase.length(); i++) {
            char letra = Character.toLowerCase(frase.charAt(i));

            if (letra == 'a' || letra == 'e' || letra == 'i' ||
                letra == 'o' || letra == 'u') {
                total++;
            }
        }

        return total;
    }

    public static int contarConsoantes(String frase) {
        int total = 0;

        for (int i = 0; i < frase.length(); i++) {
            char letra = Character.toLowerCase(frase.charAt(i));

            if (Character.isLetter(letra) &&
                letra != 'a' && letra != 'e' && letra != 'i' &&
                letra != 'o' && letra != 'u') {
                total++;
            }
        }

        return total;
    }

    public static int contarNumeros(String frase) {
        int total = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (Character.isDigit(frase.charAt(i))) {
                total++;
            }
        }

        return total;
    }

    public static int contarEspacos(String frase) {
        int total = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                total++;
            }
        }

        return total;
    }

    public static int contarOutros(String frase) {
        int total = 0;

        for (int i = 0; i < frase.length(); i++) {
            char caractere = frase.charAt(i);

            if (!Character.isLetterOrDigit(caractere) && caractere != ' ') {
                total++;
            }
        }

        return total;
    }

    public static int contarPalavras(String frase) {
        String[] palavras = frase.trim().split("\\s+");

        return palavras.length;
    }

    public static String maiorPalavra(String frase) {
        String[] palavras = frase.trim().split("\\s+");
        String maior = "";

        for (int i = 0; i < palavras.length; i++) {
            if (palavras[i].length() > maior.length()) {
                maior = palavras[i];
            }
        }

        return maior;
    }

    public static int frequenciaLetra(String frase, char letraEscolhida) {
        int total = 0;

        letraEscolhida = Character.toLowerCase(letraEscolhida);

        for (int i = 0; i < frase.length(); i++) {
            char letra = Character.toLowerCase(frase.charAt(i));

            if (letra == letraEscolhida) {
                total++;
            }
        }

        return total;
    }

    public static boolean palindromo(String frase) {
        String texto = "";

        for (int i = 0; i < frase.length(); i++) {
            char letra = Character.toLowerCase(frase.charAt(i));

            if (Character.isLetterOrDigit(letra)) {
                texto += letra;
            }
        }

        String invertido = "";

        for (int i = texto.length() - 1; i >= 0; i--) {
            invertido += texto.charAt(i);
        }

        return texto.equals(invertido);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();

        System.out.print("Digite uma letra: ");
        char letra = scanner.nextLine().charAt(0);

        System.out.println("\n--- ANÁLISE ---");

        System.out.println("Caracteres: " + frase.length());
        System.out.println("Letras: " + contarLetras(frase));
        System.out.println("Vogais: " + contarVogais(frase));
        System.out.println("Consoantes: " + contarConsoantes(frase));
        System.out.println("Algarismos: " + contarNumeros(frase));
        System.out.println("Espaços: " + contarEspacos(frase));
        System.out.println("Outros caracteres: " + contarOutros(frase));
        System.out.println("Palavras: " + contarPalavras(frase));
        System.out.println("Maior palavra: " + maiorPalavra(frase));
        System.out.println("Frequência da letra: " + frequenciaLetra(frase, letra));

        if (palindromo(frase)) {
            System.out.println("É um palíndromo.");
        } else {
            System.out.println("Não é um palíndromo.");
        }

        scanner.close();
    }
}