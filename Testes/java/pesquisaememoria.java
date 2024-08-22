
import java.util.Scanner; // importa a biblioteca de scan
import java.io.File;
import java.io.FileNotFoundException;

public class pesquisaememoria {
    public static void main(String[] args) { // cria o main
        System.out.println("Está rodando.");
        File arquivo = new File("Testes/java/dados.txt"); // Caminho para o arquivo
        int x = 3, n = 10;
        boolean resp = false;
        int[] array = new int[n];
        try {
            Scanner scanner = new Scanner(arquivo);
            for (int j = 0; j < n; j++) {
                array[j] = scanner.nextInt();
            }
            scanner.close();

            for (int k = 0; k < n; k++) {
                System.out.print(array[k] + " ");
            }

            for (int i = 0; i < n; i++) {
                if (array[i] == x) {
                    resp = true;
                    i = n;
                }
            }

            if (resp) {
                System.out.println("O valor " + x + " está presente no array.");
            } else {
                System.out.println("O valor " + x + " não foi encontrado no array.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}
