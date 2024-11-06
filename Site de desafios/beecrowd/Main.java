import java.util.*;

class EstacionamentoLinear {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        while (N != 0 && M != 0) {
            Stack<Integer> Motoristas = new Stack<>();
            boolean possivelEstacionar = true;

            for (int i = 0; i < N; i++) {
                int chegada = sc.nextInt();
                int saida = sc.nextInt();

                // Remover os carros que devem sair antes da chegada do novo carro
                while (!Motoristas.isEmpty() && Motoristas.peek() <= chegada) {
                    Motoristas.pop();
                }

                // Verificar se ainda há espaço no estacionamento
                if (Motoristas.size() < M) {
                    Motoristas.push(saida);
                } else {
                    possivelEstacionar = false;
                    // Interromper o loop ao detectar que o estacionamento lotou
                    break;
                }
            }

            System.out.println(possivelEstacionar ? "Sim" : "Nao");

            // Ler o próximo caso de teste
            N = sc.nextInt();
            M = sc.nextInt();
        }

        sc.close();
    }
}
