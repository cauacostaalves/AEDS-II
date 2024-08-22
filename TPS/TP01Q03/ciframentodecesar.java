import java.util.*;

public class ciframentodecesar{
    public static void main (String Args[]){
        String frase;
        frase = MyIO.readLine();
        int ASCII =0;
        for(int i=0;i<frase.length();i++){
            ASCII = frase.chatAt(i) ;
            ASCII += 3;
            frase.chatAt(i) = ASCII;
        }
    }
}
