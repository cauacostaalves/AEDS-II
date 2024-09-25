package TPS.TPS2.TP02Q01;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class classeEmJava {
    
    public static void LerCSV(){
        String csvFile = "pokemon.csv";
        try{
            BufferedReader br = new BufferedReader(csvFile);
            br.readLine();
            String LinhaCSV;
            while((LinhaCSV = br.readLine()) != null ){
                LinhaCSV;
            }
        }catch(Exception e){e.printStackTrace();}
    }

    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        Pokemon[] Pokedex = new Pokemon[801];
        while(true){
            String idPokemon = sc.next();
            if(idPokemon.equals("FIM")){
            break;
            }
        }
        sc.close();
    }
}
