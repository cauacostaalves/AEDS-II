import java.util.*;

/* 
    vale relembrar que o quick sort tem vantagens e desvantagens:
 * A razão da sua velocidade é a simplicidade do seu anel interno
 * Extremamente eficiente 
 * Necessita so de uma pilha de memoria 
 * faz em media n * lg (n)  comparaçoes, no pior caso se pegar o maior ou menor numero do vetor
  faz n² compraçoes e no melhor n * lg (n) 
 * No pior caso, ha teto de n/2 trocas ( 3 * teto de n/2) movimentaçoes.
 * Metodo não estavel e implementaçao dificl e delicada
*/

/* 
    O quicksort trabalha pegando um pivo, geralmente no meio do array, e por meio de recursao e swap ele ordena
 o array divindo ele no meio, no qual ele joga os numeros menores que o pivo para um lado e os maiores para o outro 
*/

public class QuickSort {

    public static void swap(int i,int j,int array[]){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void QuickSort(int array[], int esq, int dir){
        int i = esq;
        int j = dir;
        int pivo = array[(esq + dir)/2];


        while(i<=j){
            while(array[i] < pivo){i++; } // pega o maior q o pivo 
            while(array[j] > pivo){j--; } // pega o menor q o pivo 
            if(i<=j){ // se possivel fazer a troca do maior e do menor para a ordenaçao 
                swap(i,j,array);
                i++;
                j--;
            }
        }
        
        if(i <= dir){QuickSort(array,esq,j);} // pega a parte da esquerda para ordenar
        
        if(j >= esq){QuickSort(array,i,dir);} // pega a parte da direita para ordenar
    }

    public static void main(String[] Args){
        int array[]= {1, 5 , 6 , 7 , 9 , 4 , 2 , 10 , 3 ,8};
        QuickSort(array, 0, 9);
        for(int i:array){
            System.out.print(i + " ");
        }
    }

}
