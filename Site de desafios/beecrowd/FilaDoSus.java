import java.util.*;

class Paciente{
    int horas;
    int minutos;
    int condicao;

    Paciente(int h, int m, int c){
        this.horas = h;
        this.minutos = m;
        this.condicao = c;
    }

    int TempoAtual(){
        return ((this.horas - 7) * 60) + (this.minutos);
    }

}

class FilaDoSus{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
            ArrayList<Paciente> Pacientes = new ArrayList<>();
            int N = sc.nextInt();
            for(int i=0; i<N; i++){
                int horas = sc.nextInt();
                int minutos = sc.nextInt();
                int condicao = sc.nextInt();

                Paciente paciente = new Paciente(horas, minutos, condicao);
                Pacientes.add(paciente);
            }
            int tempoAtual = 0;
            int morreu = 0;
            for (Paciente paciente : Pacientes) {
                int chegada = paciente.TempoAtual();
                tempoAtual = Math.max(tempoAtual, chegada); 

                if (tempoAtual - chegada >= paciente.condicao) {
                    morreu++;
                }

                tempoAtual += 30; 
            }
            System.out.println(morreu);

        }
        sc.close();
    }
}