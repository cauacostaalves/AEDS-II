
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Scanner;

public class ControladorDeVoo {
 
    String input; 
    String direcao;
    ArrayList<String> Oeste = new ArrayList<>();

    while(!(input = Scanner.next()).equals("0")){
        if (!input.startsWith("A")) {
            direcao = input;
        }

        if(input.startsWith("A")){
            if(direcao == -1){
                Oeste.add(input);
            }
        }
    }

}
