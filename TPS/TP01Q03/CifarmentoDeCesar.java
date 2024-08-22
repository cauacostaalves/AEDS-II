import java.util.*;

class CiframentoDeCesar {
    public static void main(String[] args) {
        // Lê a frase do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a frase para codificar:");
        String frase = scanner.nextLine();
        
        // Define o valor de deslocamento para o ciframento de César
        int deslocamento = 3;
        
        // Constrói a nova frase codificada usando um StringBuilder
        StringBuilder resultado = new StringBuilder();
        
        // Itera sobre cada caractere da frase
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            int ascii = (int) c;  // Converte o caractere para seu valor ASCII

            // Verifica se o caractere é uma letra maiúscula
            if (Character.isUpperCase(c)) {
                ascii = ((ascii - 'A' + deslocamento) % 26 + 26) % 26 + 'A';  // Aplica o deslocamento e ajusta
            }
            // Verifica se o caractere é uma letra minúscula
            else if (Character.isLowerCase(c)) {
                ascii = ((ascii - 'a' + deslocamento) % 26 + 26) % 26 + 'a';  // Aplica o deslocamento e ajusta
            }
            // Caso não seja letra, mantém o valor ASCII original
            // O caractere não é alterado, apenas adicionado ao resultado
            resultado.append((char) ascii);
        }
        
        // Exibe a frase codificada
        System.out.println("Frase codificada:");
        System.out.println(resultado.toString());
        
        // Fecha o scanner
        scanner.close();
    }
}
