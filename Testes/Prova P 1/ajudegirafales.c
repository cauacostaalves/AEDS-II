#include <stdio.h>
#include <string.h>
int main (){
    int N = 0;
    while(1){
        scanf("%d",&N);
        if(N == 0){
            break;
        }
        int acc =0;
        char nome[20];
        char assinatura[30];
        for(int i=0;i<N;i++){
            scanf("%s",nome);
            scanf("%s",assinatura);
            int erro =0;
                for(int j=0; j<strlen(nome); j++){
                    if(nome[j] != assinatura[j]){
                        erro++;
                    }
                }       
            if(erro>1){
                acc++;
            }
        }
        printf("%d\n",acc);
    }
    return 0;
}