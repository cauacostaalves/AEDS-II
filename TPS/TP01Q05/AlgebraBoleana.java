import java.util.*;

public class AlgebraBoleana{
    public static void main(String Args[]){
        String frase;
        frase =MyIO.readLine();
        int A=1,B=1,C=1; // false = 0 , true = 1
        int acc=0;
        int tam = frase.length();
        for(int i =0;i<tam;i++){
            acc = (int)frase.charAt(0);
            A = (int)frase.charAt(2);
            B = (int)frase.charAt(4);
            if(acc == 3 ){
                C = (int)frase.charAt(6);
            }
          }
          MyIO.println("Variaveis: "+acc);
          MyIO.print("A: " + A + " B " + B + " C " + C);
        }
    }
