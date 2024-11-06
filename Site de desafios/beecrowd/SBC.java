import java.util.*;

class Reloginho{
    int tempo;
    int ciclos;

    Reloginho(int tempo, int ciclos){
        this.tempo = tempo;
        this.ciclos = ciclos;
    }
}

class SBC{
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);       
        while(sc.hasNext()){
        int N = sc.nextInt();
        int tempo = sc.nextInt();
        int ciclos = sc.nextInt();
        Reloginho tmp = new Reloginho(tempo,ciclos);
        for(int i =0; i<N; i++){
            
        }
        }
        
        sc.close();
    }
}