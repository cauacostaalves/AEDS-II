import java.io.*;
import java.util.*;

 
class tecladoquebrado {
    public static StringBuilder OrganizaString(String texto){
        int tam = texto.length();
        char home = '['; // vai pro começo da frase
        char end = ']'; // vai pro final da frase
        StringBuilder novotexto = new StringBuilder() ;
        for(int i =0;i< tam;i++){
            char temp = texto.charAt(i);
            if(temp == home){
                int j =i+1;
                while(texto.charAt(i) != end && j < tam){
                    temp = texto.charAt(j);
                    novotexto.insert(0,temp);
                    j++;
                }
                i = j-1;
            }else if (temp == end){
                    temp = texto.charAt(i+1);
                    novotexto.append(temp);                 
            }else{
                    novotexto.append(temp);
            }
        }
        
        return novotexto;
    } 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();
        System.out.print(OrganizaString(texto));  
        sc.close();  
    }
 
}