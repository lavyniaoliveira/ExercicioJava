import java.util.Scanner;

public class Exercicio1 {
	public static double calcularMedia(double nota1, double nota2, double nota3) {
		return (nota1 + nota2 +nota3) / 3;
	}

	public static String frequenciaMedia(double media, double frequencia) {
		if ( frequencia < 75) {
			return "Reprovado por frequência";
		}
		else if (media >= 7) {
			return "Aprovado";
		}
		else if (media >= 5) {
			return "Recuperação";
		}
		else {
			return "Reprovado por nota";
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite o nome do aluno: ");
		String nome = scanner.nextLine();
		
		System.out.print("Digite a primeira nota do aluno: ");
		double nota1 = scanner.nextDouble();
	
		System.out.print("Digite a segunda nota do aluno: ");
		double nota2 = scanner.nextDouble();
		
		System.out.print("Digite a terceira nota do aluno: ");	
		double nota3 = scanner.nextDouble();
		
		System.out.print("Digite a frequência do aluno: ");
		double frequencia = scanner.nextDouble();
		
		double media = calcularMedia(nota1, nota2, nota3);
		String situação= frequenciaMedia(media, frequencia);
	        System.out.println("/n--- Situação do aluno ---");
	        	System.out.println("Aluno: " + nome);
	        		System.out.println("frequência: " + frequencia);
	        			System.out.println("Média: " + media);
	        				System.out.println("Situação: " + situação);
	        
	    scanner.close();
	}
}