import java.util.*;
import java.io.*;

public class alfabetoindigena {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String alfabeto = sc.nextLine();
        String frase = sc.nextLine();
        if ( alfabeto.length() > n & frase.length() > m){
            System.out.println("ERRO!");
        }
        boolean erro = false;
        for( int i =0 ;i < frase.length();i++){
           char temp =  frase.charAt(i);
            if(alfabeto.indexOf(temp) == -1) {
                erro = true;        
                break;
            }
        }
        if(erro){
        System.out.println("N");
        }else {
            System.out.println("S");
        }
        sc.close();
    }
}
