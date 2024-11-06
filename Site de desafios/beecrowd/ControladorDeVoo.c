#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct Celula{
    char elemento[4];
    struct Celula* prox;
}Celula;

typedef struct Fila{
    Celula* primeiro;
    Celula* ultimo;
}Fila;

void FilaConstrutor(Fila* fila){
    fila->primeiro = NULL;
    fila->ultimo = NULL;    
}

void FilaDestrutor(Fila* fila){
    while (fila->primeiro != NULL) {
        Celula* tmp = fila->primeiro;
        fila->primeiro = fila->primeiro->prox;
        free(tmp);
    } // tem que dar free em todas celulas.
}

void add(Fila* fila, char input[4]){
    Celula* tmp = (Celula*)malloc(sizeof(Celula));
    strcpy(tmp->elemento,input);
    tmp->prox = NULL;
    if(fila->primeiro == NULL){
        fila->primeiro = fila->ultimo = tmp;
    }else{
        fila->ultimo->prox = tmp;
        fila->ultimo = tmp;
    }
}

void remover(Fila* fila){
    if(fila->primeiro == NULL){
        printf("EMPTY\n");
        return;
    }
    Celula* tmp = fila->primeiro;
    printf("%s ",tmp->elemento);

    fila->primeiro = fila->primeiro->prox;
    tmp->prox = NULL;
    free(tmp);
    if(fila->primeiro == NULL){
        fila->ultimo = NULL;
    }
}

bool isEmpty(Fila* fila){
    if(fila->primeiro == NULL){
        return true;
    }
    return false;
}

int main(){
    Fila Oeste;
    FilaConstrutor(&Oeste);
    Fila Norte;
    FilaConstrutor(&Norte);
    Fila Sul;
    FilaConstrutor(&Sul);
    Fila Leste;
    FilaConstrutor(&Leste);
    
    char input[5];
    scanf("%4s", input);
    char direcao[5];
    while(strcmp(input, "0") != 0 ){
        if(input[0] != 'A'){
            strcpy(direcao,input);
        }

        if(input[0] == 'A'){
            if(strcmp(direcao, "-1") == 0){
                add(&Oeste, input);
            }
            if(strcmp(direcao, "-2") == 0){
                add(&Sul, input);
            }
            if(strcmp(direcao, "-3") == 0){
                add(&Norte, input);
            }
            if(strcmp(direcao, "-4") == 0){
                add(&Leste, input);
            }
        }

        scanf("%4s", input);
    }
 
    while(!isEmpty(&Oeste) || !isEmpty(&Sul) || !isEmpty(&Leste) || !isEmpty(&Norte)){
        if(!isEmpty(&Oeste)){
            remover(&Oeste);
        }
        if(!isEmpty(&Norte)){
            remover(&Norte);
        }
        if(!isEmpty(&Sul)){
            remover(&Sul);
        }
        if(!isEmpty(&Leste)){
            remover(&Leste);
        }
    }

    FilaDestrutor(&Oeste);
    FilaDestrutor(&Sul);
    FilaDestrutor(&Leste);
    FilaDestrutor(&Norte);
    return 0;
}
