import java.io.*;
import java.util.*;

public class Main {

    public static 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i =0;i<n;i++){
            String pa = sc.nextLine();
            StringBuilder palavra = new StringBuilder();
            int tam = pa.length();
            for(int j =0;j<tam;j++){
                int temp = pa.charAt(j);
                temp = temp + 3;
                palavra.append((char)temp);
            }        
            System.out.println(palavra);        
        }        
        sc.close();
    }
}