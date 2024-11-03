
import java.util.Scanner;
import java.util.Stack;

public class InFixParaPosFix {

    public static void PosFix( String input){
        Stack<String> pilha = new Stack();
        String tmp = input ;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        for (int i=0;i<n;i++) {
            String input = sc.next();
            PosFix(input);
        }    
        sc.close();
    }
}
