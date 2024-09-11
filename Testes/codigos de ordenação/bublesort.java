import java.util.*;

public class bublesort {
    
    public static int[] buble(int[] array){
        int tam = array.length;
        for(int i=0;i<tam-1;i++){
            for(int j = 0; j<tam-1-i; j++){
                if(array[j] >  array[j+1]){
                    swap(array,j,j+1);
                }   
             }
        }
        return array;
    }

    public static int[] bubleopt(int[] array) {
        int tam = array.length;
        int temp = tam - 1;
        for (int i = 0; i < tam - 1; i++) {
            int new_temp = -1; 
            for (int j = 0; j < temp; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    new_temp = j;
                }
                imprimirarray(array);
                System.out.println();
            }
            if (new_temp == -1) {
                break; 
            }
            temp = new_temp;
        }
        return array;
    }

    public static int[] swap(int[]array , int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    public static void imprimirarray(int[]array){
        int tam = array.length;
        for(int i =0;i<tam;i++){
            System.out.print(array[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {4,3,9,10,7,0};
        bubleopt(array);
        imprimirarray(array);
        sc.close();
    }
}
