import java.util.*;

class Paciente{
    int horas;
    int minutos;
    int critico;

    Paciente(int h, int m, int c){
        this.horas = h;
        this.minutos = m;
        this.critico = c;
    }

    int TempoEmMinutos(){
        return ( horas*60 ) + minutos;
    }
}

class FilaSus {
    
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNext()) {
            ArrayList<Paciente> Pacientes = new ArrayList<>();
            
            int N = sc.nextInt();
            for(int i=0; i<N; i++){
                int horas = sc.nextInt();
                int minutos = sc.nextInt();
                int critico = sc.nextInt();

                Paciente p = new Paciente(horas,minutos,critico);
                Pacientes.add(p);
            }

            int morreu = 0;
            int TempoAtual = 420; // 7 horas em minutos
            for(Paciente p: Pacientes){

                int tmp = p.TempoEmMinutos()+p.critico;
                if(tmp < TempoAtual){
                    morreu++;
                    TempoAtual += 30;
                }else{
                    if(TempoAtual > p.TempoEmMinutos()){
                        TempoAtual += 30;
                    }else{
                        TempoAtual += (p.TempoEmMinutos() - TempoAtual) + 30; 
                    }
                }
            }  
            System.out.println(morreu);
        }
        
        sc.close();
    }    
}
