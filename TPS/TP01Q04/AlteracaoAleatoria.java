import java.util.*;

public class AlteracaoAleatoria {
    public static void main ( String Args[]){
        Random gerador = new Random();
        gerador.setSeed(6);
        System.out.println((char)('a' + (Math.abs(gerador.nextInt()) % 26)));
    }
}
