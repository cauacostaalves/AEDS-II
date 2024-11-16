#include <stdio.h>

void swap(int array[], int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

int selection(int array[], int tam){
    int trocas = 0;
    for(int i=0; i<tam-1; i++){
        int menor = i;
        for(int j =i+1; j<tam;j++){
            if(array[j] < array[menor]){
                menor = j;
            }
            if(menor != i){
                swap(array, i, menor);
                trocas++;
            }
        }
    }
    return trocas;
}

void ler(int array[], int tam){
    for(int i =0; i<tam;i++){
        int x = 0;
        scanf("%d",&x);
        array[i] = x;
    }
}

int main(){
    int N = 0;
    scanf("%d",&N);
    for(int i =0; i<N; i++){
        int tam=0;
        scanf("%d",&tam);
        int array[tam];
        ler(array,tam);
        int x = selection(array, tam);
        printf("%d\n",x);    
    }
    return 0;
}