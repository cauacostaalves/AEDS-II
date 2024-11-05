import java.util.*;

public class menorDaPilha {
    public static int Min(Stack<Integer> pilha){
        if (pilha.isEmpty()) {
            throw new IllegalStateException("EMPTY\n");
        }
        int menor = pilha.peek();
        for (int elemento : pilha) {
            if (elemento < menor) {
                menor = elemento;
            }
        }
        return menor;
    }
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> presentes = new Stack<>();
        for(int i=0; i<N; i++){
            String op = sc.next();
            switch (op) {
                case "POP":
                    presentes.pop();
                    break;
                
                case "PUSH":
                    int input = sc.nextInt();
                    presentes.push(input);
                    break;
                
                case "MIN":
                    System.out.println(Min(presentes));
                    break;

                default:
                    break;
            }
        }
        sc.close();
    }    
}
