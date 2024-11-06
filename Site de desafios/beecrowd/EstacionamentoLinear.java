import java.util.Scanner;
import java.util.Stack;

public class EstacionamentoLinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qtdMotoristas;
        int qtdVagas;

        // Loop de leitura até encontrar o caso de término (0 0)
        while (true) {
            // Leitura da quantidade de motoristas e vagas
            qtdMotoristas = sc.nextInt();
            qtdVagas = sc.nextInt();
            sc.nextLine();  // Consumir o '\n' restante após os dois números

            // Caso de parada
            if (qtdMotoristas == 0 && qtdVagas == 0) {
                break;
            }

            boolean possivel = true;
            Stack<Integer> estacionamento = new Stack<>(); // Pilha para simular o estacionamento

            // Processando cada motorista
            for (int i = 0; i < qtdMotoristas && possivel; i++) {
                String[] motorista = sc.nextLine().split(" ");
                int H_entrada = Integer.parseInt(motorista[0]);
                int H_saida = Integer.parseInt(motorista[1]);

                // Remover carros da pilha que devem sair antes da entrada atual
                while (!estacionamento.isEmpty() && estacionamento.peek() <= H_entrada) {
                    estacionamento.pop();
                }

                // Adicionar o carro atual se houver espaço e garantir a ordem de saída
                if (estacionamento.size() < qtdVagas) {
                    if (!estacionamento.isEmpty() && estacionamento.peek() < H_saida) {
                        // Se o próximo carro na pilha tiver que sair antes do H_saida atual, é impossível
                        possivel = false;
                    } else {
                        // Se a saída do carro atual é válida, adicionar na pilha
                        estacionamento.push(H_saida);
                    }
                } else {
                    // Caso o estacionamento esteja cheio, a operação é impossível
                    possivel = false;
                }
            }

            // Imprimir o resultado para o caso de teste atual
            if (possivel) {
                System.out.println("Sim");
            } else {
                System.out.println("Nao");
            }
        }

        // Remover sc.close() para evitar o erro
    }
}
