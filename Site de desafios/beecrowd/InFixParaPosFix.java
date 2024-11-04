
import java.util.*;


public class InFixParaPosFix {

    public static void InParaPos(String input){
        for (int i =0; i<input.length(); i++) {
            char tmp = input.charAt(i);
            if (tmp.) {
                String saida += tmp;    
            }
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
