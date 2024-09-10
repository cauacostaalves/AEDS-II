import java.util.*;

public class insercao {

    public static int[] insercaoordem(int[]array){
        int tam = array.length;
        for(int i = 1; i<tam;i++){
            int menor = array[i] ;
            int j =i-1;
            while(j>=0 && menor < array[j]){
               array[j+1] = array[j];
               j--;
            }
            array[j+1] = menor;
        }   
        return array;
    }

    public static int[] insercaoordemopt(int[]array){
        int tam = array.length;
        for(int i = 1; i<tam;i++){
            int menor = array[i] ;
            int j =i-1;
            while(j>=0 && menor < array[j]){
               array[j+1] = array[j];
               j--;
            }
            array[j+1] = menor;
        }   
        return array;
    }

    public static int buscabinaria(int[] array, int num){
        int tam = array.length;
        int esq =0;
        int dir = tam-1;
        while(esq <= dir){
            int meio = (dir+esq) /2;
            if(array[meio] == num){
                return meio;
            }
            else if(array[meio] > num ){
                dir = meio -1;
            }else {esq = meio + 1;}
        }
        return esq;
    }

    public static void imprimirarray(int[]array){
        int tam = array.length;
        for(int i =0;i<tam;i++){
            System.out.print(array[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int array[] = { 1,4,5,3,9,0};
        insercaoordem(array);
        imprimirarray(array);

        sc.close();
    }   
}
