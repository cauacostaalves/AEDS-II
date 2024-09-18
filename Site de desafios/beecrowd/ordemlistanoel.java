import java.util.*;


public class ordemlistanoel {

    public static void bublesort(String[]array,int tam){
        for(int i=0;i<tam-1;i++){
            for(int j =0;j<tam-1-i;j++){
                if(array[j].compareTo(array[j+1]) > 0 ){
                String temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
               }
            }
        }
    }

    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        sc.nextLine();
        String[] lista = new String[N];
        for(int i=0;i<N;i++){
            lista[i] = sc.nextLine().trim();
        }
        int bom =0;
        int mal =0;
        for(int i=0;i<N;i++){
            String temp = lista[i];
            if(temp.charAt(0) == '+'){
                bom++;
            }else if(temp.charAt(0) == '-'){
                mal++;
            }        
        }
        
        for(int i =0;i<N;i++){
            if(lista[i].startsWith("+") || lista[i].startsWith("-")){
                lista[i] = lista[i].substring(1).trim();
            } 
        }
        bublesort(lista, N);
        for(int i =0;i<N;i++){
            System.out.println(lista[i]);
        }
        
        System.out.printf("Se comportaram: %d | Nao se comportaram: %d\n",bom,mal);
        sc.close();
    }
}
