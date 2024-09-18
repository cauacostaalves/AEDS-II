#include <stdio.h>
 
 void swap(int array[] , int j){
    int temp = array[j];
    array[j] = array[j+1];
    array[j+1] = temp;
 }


 void ordernar(int array[] , int tam){
    for (int i =0;i<tam-1;i++){
        for(int j =0;j<tam-i-1;j++){
            if(array[j] > array[j+1]){
                swap(array,j);
            }
        }
    }
 }

 int contapresentes(int array[] , int tam){
    int presentes =0;
    int cont =1;
    for(int i=0;i<tam;i++){

        if(array[i] == array[i+1]){
            presentes += cont;
        }else{
            presentes += cont;
            cont++;
        }
    }

    return presentes;
 }
int main() {
 
    int N =0;
    scanf("%d",&N);//qtd de crianças
    
    int boasacoes [N];
    
    for(int i =0;i<N;i++){
        scanf("%d",&boasacoes[i]);
    }
    
    ordernar(boasacoes , N);
    int presentes = contapresentes(boasacoes , N);
    printf("%d\n",presentes);
    return 0;
}