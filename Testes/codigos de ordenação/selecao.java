import java.util.*;

public class selecao{

    public static int[] swap(int[]array , int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    public static int[] selecaoordem(int[] array){
        int tam = array.length;
        for (int i = 0;i<tam-1;i++){
            int menor = i;
            for(int j = i+1;j<tam;j++){
                if(array[menor] > array[j]){
                    
                    menor = j;
                }
            }
            swap(array, menor, i);
        }
        return array;
    }

    public static int[] selecaoopt(int[] array){
        int tam = array.length;
        for (int i = 0; i<tam-1; i++){
            int menor = i;
            for(int j = i+1;j<tam;j++){
                if(array[menor] > array[j]){
                    menor = j;
                }
            }
            swap(array, menor, i);
        }
        return array;
    }

    public static void imprimirarray(int[]array){
        int tam = array.length;
        for(int i =0;i<tam;i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String Args[]){
        Scanner sc = new Scanner(System.in);
        int[] array = {1,4,6,9,2};
        selecaoordem(array);
        imprimirarray(array);
        sc.close();
    }
}