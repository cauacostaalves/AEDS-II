import java.util.*;

public class OrganizadorDeVagoes{

    public static int bublesort(int[] array, int tam){
        int swaps = 0;
        for(int i =0; i<array.length-1; i++){
            for(int j =0;j<array.length-1; j++){
                if(array[j] > array[j+1]){
                    swap(array, j , j+1);
                    swaps++;
                }
            }
        }
        return swaps;
    }

    public static void swap(int[] array, int i , int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            int tam = sc.nextInt();
            int[] array = new int[tam];

            for(int j=0;j<tam;j++){
                int input = sc.nextInt();
                array[j] = input;
            }
            int swap = bublesort(array,tam);
            System.out.printf("Optimal train swapping takes %d swaps.\n",swap);
        }
        sc.close();
    }

}