import java.util.Scanner;

public class AlgebraBoleana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Leitura da string
        String frase = scanner.nextLine();
        
        // Supondo que a string tenha o formato "A B C", onde A, B e C são valores booleanos (0 ou 1)
        // Exemplo de entrada: "1 0 1"
        
        String[] parts = frase.split(" "); // Divide a string em partes separadas por espaço
        
        if (parts.length >= 3) {
            // Converte as partes para inteiros
            int A = Integer.parseInt(parts[2]);
            int B = Integer.parseInt(parts[4]);
            int C = Integer.parseInt(parts[6]);
            
            // Calcula o número de variáveis que são 1
            int acc = 0;
            if (A == 1) acc++;
            if (B == 1) acc++;
            if (C == 1) acc++;
            
            // Impressão dos valores
            System.out.println("Variaveis: " + acc);
            System.out.println("A: " + A + " B: " + B + " C: " + C);
        } else {
            System.out.println("Entrada inválida. Certifique-se de fornecer três valores separados por espaços.");
        }
        
        scanner.close();
    }
}
