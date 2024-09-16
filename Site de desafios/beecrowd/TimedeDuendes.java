import java.util.*;

public class TimedeDuendes {
    String nome;
    int idade;

    public TimedeDuendes(String n, int i) {
        nome = n;
        idade = i;
    }

    public String toString() {
        return nome + " " + idade;
    }
}


class Main() {    

    public static void selecao(ArrayList<TimedeDuendes> duendes , int QtdDuendes){

        for(int i =0;i<QtdDuendes-1;i++){
            int menor = i;  
            int maior = i;
            for(int j=i+1;j<QtdDuendes;j++){
                if(duendes.get(menor).idade > duendes.get(j).idade){
                    menor = j;
                }
                if(duendes.get(maior).idade < duendes.get(j).idade){
                    maior = j;
                }
            }
            TimedeDuendes temp = duendes.get(menor);
            duendes.set(menor, duendes.get(i));
            duendes.set(i, temp);
        }
    
    }
    public static void main(String[] Args){
        Scanner sc = Scanner(System.in);
        int QtdDuendes = sc.nextInt();
        int QtdTimes = 1;
        
        ArrayList<TimedeDuendes> Duendes = new ArrayList<>(QtdDuendes); 
        
        for(int i = 0;i<QtdTimes;i++){
            String nome = sc.nextLine();
            int idade = sc.nextInt();
            TimedeDuendes Duende = new TimedeDuendes(nome,idade);
            Duendes.add(Duende);
        }
        selecao(Duendes, QtdDuendes);

        for(int i =0;i<QtdDuendes;i++){
            System.out.println("Times" + " " + QtdTimes   );


            QtdTimes++;
        }
        

        sc.close();
    }
}
