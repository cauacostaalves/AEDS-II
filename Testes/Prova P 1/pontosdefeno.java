import java.util.*;

public class pontosdefeno {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        String[] cargo=new String[M];
        int []valor = new int[M];
        for(int i=0;i<M;i++){
            cargo[i] = sc.next();
            valor[i] = sc.nextInt();
            sc.nextLine();
        }
        int acc=0;
        for(int i=0;i<N;i++){
            while(true){
                String palavra = sc.next();
                
                if(palavra.equals(".")){
                    System.out.println(acc);
                    acc=0;
                    break;
                }
                for(int j =0;j<M;j++){
                    if(palavra.equals(cargo[j])){
                        acc += valor[j];
                    }
                }
            }
        }
        sc.close();
    }
}
