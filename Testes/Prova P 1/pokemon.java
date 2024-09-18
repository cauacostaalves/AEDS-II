import java.util.*;

public class pokemon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int acc =0;
        String array[] = new String[N];
        for(int i =0;i<N;i++){
            array[i] = sc.next();
        }
        for(int i =0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(array[i].equals(array[j]) == true && array[j]!="Achou"){
                    array[j] = "Achou";
                    acc++;
                }
            }
        }
        System.out.println(acc);
        acc = 151-(N-acc);
        System.out.printf("Falta(m) %d pokemon(s).", acc );
        sc.close();
    }
}
