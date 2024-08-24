#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

void trocaletras(char palavra[100],int i,int tam, char  letraDeSubst, char letraQvaiSubst){
if(i>=tam){
    printf("%s\n",palavra);
    return;
}else{
    if(palavra[i] == letraQvaiSubst){
        palavra[i] = letraDeSubst;
    }
    trocaletras(palavra,i+1,tam,letraDeSubst,letraQvaiSubst);
}
 }
int main (){

srand(4);
char palavra[1000];
    
while(1){
    
    fgets(palavra, sizeof(palavra), stdin);
    palavra[strlen(palavra) - 1] = 0;

    if(strcmp(palavra,"FIM") == 0){
        break;
    }

    char letraQvaiSubst = 'a' + (rand() % 26);
    char letraDeSubst = 'a' + (rand() % 26);

    int tam = strlen(palavra);
    
    trocaletras(palavra,0,tam,letraDeSubst,letraQvaiSubst);
}
return 0;
}
