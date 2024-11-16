#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct Celula{
    struct Celula* prox;
    int elemento;
}Celula;

typedef struct Pilha
{
    Celula* topo;
}Pilha;

void PUSH(Pilha* pilha, int x){
    Celula* tmp = (Celula*)malloc(sizeof(Celula));
    if(tmp == NULL){
        printf("Erro de alocaçao na celula push\n");
        return;
    }
    tmp->elemento = x;
    tmp->prox = pilha->topo;
    pilha->topo = tmp;
}

int POP(Pilha* pilha){
    Celula* tmp = (Celula*)malloc(sizeof(Celula));
    if(pilha->topo == NULL){
        printf("EMPTY\n");
        return -1; 
    }
    int removido = pilha->topo->elemento;
    tmp = pilha->topo;
    pilha->topo = pilha->topo->prox;
    free(tmp);
    return removido;
}

int MIN(Pilha* pilha){
    if(pilha->topo == NULL){
        printf("EMPTY\n");
        return -1; 
    }
    int menor = pilha->topo->elemento;
    for(Celula* tmp = pilha->topo; tmp != NULL; tmp = tmp->prox){
        if(tmp->elemento < menor){
            menor = tmp->elemento;
        }
    }
    return menor;
}

int main(){
    int N=0;
    scanf("%d", &N);
    Pilha pilha;
    pilha.topo = NULL;
    for(int i=0; i<N; i++){
        char op[5];
        scanf("%4s",op);
        if(strcmp(op, "PUSH") == 0){
            int x=0;
            scanf("%d",&x);
            PUSH(&pilha,x);
        }
        if(strcmp(op, "POP") == 0){
            int x = POP(&pilha);
        }
        if(strcmp(op, "MIN") == 0){
            int x = MIN(&pilha);
              if(x != -1){
                printf("%d\n",x);
            }
        }
    }
    return 0;
}