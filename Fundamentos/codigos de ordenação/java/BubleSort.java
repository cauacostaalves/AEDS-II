public class BubleSort {

    /*
     * vale relembrar que o Buble tem vantagens e desvantagens:
     * Em comparaçoes a media é teta n², no melhor caso ele faz teta de
      n que é se estiver ordenado, no pior se o vetor estiver em ordem decrescente sera de teta de n²
     * faz em media teta de n ² movimentaçoes, no melhor caso pode chegar a teta de 1,
     que é quando o array ja esta ordenado, no piro caso teta de n², quando o array esta
     em ordem decrescente.
     * Algoritmo estável.
     */

    /*
     * O Buble Sort pegando um elemento
     * do vetor da parte nao ordenada e o ordenando na parte ordenada, colocando o
     * maior numero na ultima posiçao do array.
     */

    public static void Buble(int array[], int tam) {
        for (int j = 0; j < tam - 1; j++) {
            for (int i = 0; i < tam-1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
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
        Buble(array,10);
        for(int i:array){
            System.out.print(i + " ");
        } 
    }

}
