import java.util.Scanner;

public class encontrandoa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a expressão:");
        String input = scanner.nextLine();
        
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            if (token.equals("not")) {
                System.out.println("Encontrado operador NOT");
            } else if (token.equals("and")) {
                System.out.println("Encontrado operador AND");
            }
        }
        
        scanner.close();
    }
}
 
