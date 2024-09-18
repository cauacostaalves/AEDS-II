import java.util.*;

public class brinquedosnoel {
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        sc.nextLine();
        int bonecas=0;
        int carrinhos =0;
        String [] array = new String[N];
        for(int i =0;i<N;i++){
            array[i] = sc.nextLine();
        }
        for(int i =0;i<N;i++){
            String temp = array[i];
            int tam = temp.length();
            if(temp.charAt(tam-1) == 'F'){
                bonecas++;
            }else if(temp.charAt(tam-1) == 'M'){
                carrinhos++;
            }
        }
        System.out.printf("%d carrinhos\n%d bonecas\n",carrinhos,bonecas );
        sc.close();
    }
}
