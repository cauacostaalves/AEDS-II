
import java.util.*;


public class InFixParaPosFix {

    public static void InParaPos(String input){
        Stack<Character> operadores = new Stack<>();
        Stack<Character> caracteres = new Stack<>();
        boolean parenteses = false;
        for(int i = 0; i< input.length(); i++){ 
            char tmp = input.charAt(i);
            
            if (tmp == '+' || tmp == '-' || tmp =='*' || tmp == '^') {
                if(!operadores.isEmpty()){
                    char ca = operadores.pop();
                    caracteres.push(ca);
                   
                }
                operadores.push(tmp);
            }else if (tmp == '(' || tmp == ')') {
                if(tmp == '('){parenteses = false;}
                else if(tmp == ')'){parenteses = true;}
            }else{
                caracteres.push(tmp);
            }

            if (parenteses) {
                caracteres.push('/');
                parenteses = false;
            }
        }
        if(!operadores.isEmpty()){
            char ca = operadores.pop();
            caracteres.push(ca);
        }
        for(int i=0; i<caracteres.size(); i++){
            System.out.print(caracteres.get(i));
        }
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
