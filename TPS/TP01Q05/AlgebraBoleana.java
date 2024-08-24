import java.util.*;

public class AlgebraBoleana{
    public static void main(String Args[]){
        String frase;
        frase =MyIO.readLine();
        MyIO.print(frase);
        int tam = frase.length();
        for(int i=0;i<tam;i++){
            MyIO.println(frase.charAt(i)); 
        }
    }
}