#include <stdio.h>

void swap(int comp[], int i, int j){
    int temp = comp[i];
    comp[i] = comp[j];
    comp[j] = temp;
}

int selecao(int comp[], int ordem[], int tam){
    int mov =0;
    for(int i=0;i<tam;i++){
        for(int j=0;j<tam;j++){
            if(ordem[i] == comp[j] && i!=j){
                swap(comp,i,j);
                mov = ordem[i] - comp[j];
            }
        }
    }
    return mov;
}


int main(){

    int cabo =1;
    while(cabo >0){

        int N =0; //competidores
        scanf("%d",&N);

        int competidores[N] ;
        for(int i=0;i<N;i++){
            scanf("%d", &competidores[i]);
        }
    
        int ordemchegada[N] ;
        for(int i=0;i<N;i++){
            scanf("%d", &ordemchegada[i]);
        }

        int retorno = selecao(competidores , ordemchegada , N); 
        printf("%d\n",retorno);
        cabo--;
    }

    return 0;
}