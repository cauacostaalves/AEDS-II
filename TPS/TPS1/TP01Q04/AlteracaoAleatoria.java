import java.util.*;

public class AlteracaoAleatoria {
    public static void main(String Args[]) {
        Random gerador = new Random();
        gerador.setSeed(4);
        while (true) {
            String palavra;
            palavra = MyIO.readLine();
            if (palavra.equals("FIM")) {
                break;
            }

            int letraQvaiSubst = 'a' + Math.abs(gerador.nextInt()) % 26;
            int letraDeSubst = 'a' + Math.abs(gerador.nextInt()) % 26;
            
            StringBuilder temp = new StringBuilder(palavra);
            int tam = palavra.length();
            for (int i = 0; i < tam; i++) {
                if (palavra.charAt(i) == letraQvaiSubst) {
                    char c = (char) letraDeSubst;
                    temp.setCharAt(i, c);
                }
            }
            String resultado = temp.toString();
            MyIO.println(resultado);
        }
    }
}
