import java.util.*;

public class balancoParenteses {
    public static void main(String Args[]){
        String frase;
        while(!(frase = MyIO.readLine()).equals("FIM")){
            int tam = frase.length();
            int acc =0;
            char c;
            boolean bool = true;
            for(int i =0;i< tam ;i++){
                c =frase.charAt(i);
                if( c== '(' ){
                     acc ++;
                    }
                        else if(c == ')' ){
                            acc--;
                            if(acc < 0){
                                bool = false;
                            }
                        }
                }        
                if(acc!=0){
                    bool = false;
                }
            if(bool ){
                MyIO.println("correto");
            }else{
                MyIO.println("incorreto");
            }
        }
    }
}