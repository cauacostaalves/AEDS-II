/* 
    vale relembrar que o Shell  tem vantagens e desvantagens:
 * Em comparaçoes a media é teta n², no melhor caso ele faz n-1, ou seja teta de n,
 no pior se o vetor estiver em ordem decrescente sera  de teta de n²
 * faz em media teta de n ² movimentaçoes, no melhor caso pode chegar a teta de 1,
 que é quando o array ja esta ordenado, no piro caso teta de n², quando o array esta 
 em ordem decrescente.
 *Boa opçao se deseja adiconar alguns itens em um vetor ja ordenado 
 porque o custo vai ser linear, teta de 1.
 * Algoritmo estável.
*/

/* 
    O Shell Sort pegando um elemento 
    do vetor da parte nao ordenada e o ordenando na parte ordenada.
*/

public class void Shell(int arra[],int tam ){
    inserctionShell(array,tam,4);
    inserctionShell(array,tam,2);
    inserctionShell(array,tam,1);
}

public class void inserctionShell(int arra[], int tam , int pulos){

    for(int i=0; i < tam;i+=pulos){
        int j = i-1;
        int tmp = array[i]
        while( j>=0 && array[j] > tmp){
            array[j+1] = array[j];
            j--;
        }
        array[j+1] = tmp;
    }

}


public class ShellSort {
    int array[] = { 4, 7 ,3 , 9 ,2, 10 , 6, 1, 5, 8 };
        Shell(array,10);
        for(int i:array){
            System.out.print(i + " ");
        }
}
