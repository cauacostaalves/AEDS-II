public class SelectionSort {

    /* 
    vale relembrar que o Selection  tem vantagens e desvantagens:
 * Necessita de uma quantidade constante de memória adicional (in-place).
 * faz em media 3*(n-1), ou seja teta de n movimentaçoes.
 * Em comparaçoes a media é n(n-1)/2 ou seja teta de n².
 * Metodo não estavel e implementaçao facil.
 * Custo linera no tamanho do registro, pode ser utilizado se há registros muito grandes
 * Não adaptavel.
*/

/* 
    O Selection Sort trabalha utilizando dois loops. Um loop pega um elemento do array e 
 o outro encontra o menor elemento restante, trocando-o para que todos os números menores
 fiquem à frente na ordenação.
*/

    public static void Selection(int array[], int tam){
        for(int i =0;i<tam-1;i++){
            int menor = i;
            for(int j=i+1;j<tam;j++){
                if(array[menor] > array[j]){
                    menor = j;
                }
                swap(array, menor, i);
            }
        }
    }

    public static void swap(int array[], int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int array[] = { 4, 7 ,3 , 9 ,2, 10 , 6, 1, 5, 8 };
        Selection(array,10);
        for(int i:array){
            System.out.print(i + " ");
        }
    }
}
