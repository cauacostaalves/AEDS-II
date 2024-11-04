
import java.util.*;


public class InFixParaPosFix {
    // +,-,*,/,^, parênteses, letras e números

    public static void InParaPos(String input){
        Stack<String> operadores = new Stack<>();
        Stack<String> caracteres = new Stack<>();
        
        for(int i = 0; i< input.length(); i++){ 
            char tmp = input.charAt(i);
            boolean parenteses = false;
            if (tmp == '+' || tmp == '-' || tmp =='*' || tmp == '^') {
                
            }else if (tmp == '(') {
                
            }
            
        }

        System.out.println(caracteres);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        for (int i=0;i<n;i++) {
            String input = sc.next();
            InParaPos(input);
        }    
        sc.close();
    }
}
