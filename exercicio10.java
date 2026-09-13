import java.util.Scanner;

public class Main {

    public static boolean verificarPalavra(
            char[][] matriz,
            String palavra,
            int linha,
            int coluna,
            int linhaDirecao,
            int colunaDirecao) {

        for (int i = 0; i < palavra.length(); i++) {

            int novaLinha = linha + i * linhaDirecao;
            int novaColuna = coluna + i * colunaDirecao;

            if (novaLinha < 0 || novaLinha >= matriz.length ||
                novaColuna < 0 || novaColuna >= matriz[0].length) {

                return false;
            }

            if (matriz[novaLinha][novaColuna] != palavra.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void procurar(
            char[][] matriz,
            String palavra) {

        int[] linhas = {
            0, 0, 1, -1,
            1, -1, 1, -1
        };

        int[] colunas = {
            1, -1, 0, 0,
            1, -1, -1, 1
        };

        String[] direcoes = {
            "direita",
            "esquerda",
            "baixo",
            "cima",
            "diagonal inferior direita",
            "diagonal superior esquerda",
            "diagonal inferior esquerda",
            "diagonal superior direita"
        };

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                for (int direcao = 0; direcao < 8; direcao++) {

                    if (verificarPalavra(
                            matriz,
                            palavra,
                            i,
                            j,
                            linhas[direcao],
                            colunas[direcao])) {

                        int fimLinha =
                                i + (palavra.length() - 1) * linhas[direcao];

                        int fimColuna =
                                j + (palavra.length() - 1) * colunas[direcao];

                        System.out.println("Palavra encontrada: " + palavra);
                        System.out.println(
                                "Posição inicial: (" +
                                i + ", " + j + ")"
                        );

                        System.out.println(
                                "Posição final: (" +
                                fimLinha + ", " + fimColuna + ")"
                        );

                        System.out.println(
                                "Direção: " + direcoes[direcao]
                        );

                        return;
                    }
                }
            }
        }

        System.out.println("Palavra não encontrada: " + palavra);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de linhas: ");
        int linhas = scanner.nextInt();

        System.out.print("Digite o número de colunas: ");
        int colunas = scanner.nextInt();

        scanner.nextLine();

        char[][] matriz = new char[linhas][colunas];

        System.out.println("Digite as letras da matriz:");

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                System.out.print(
                        "Posição [" + i + "][" + j + "]: "
                );

                matriz[i][j] =
                        scanner.nextLine().toUpperCase().charAt(0);
            }
        }

        System.out.print("Quantas palavras deseja procurar? ");
        int quantidade = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < quantidade; i++) {

            System.out.print("Digite a palavra " + (i + 1) + ": ");

            String palavra =
                    scanner.nextLine().toUpperCase();

            procurar(matriz, palavra);

            System.out.println();
        }

        scanner.close();
    }
}