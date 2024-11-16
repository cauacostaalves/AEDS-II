#include <stdio.h>
#include <stdlib.h>

typedef struct Celula {
    int elemento;
    struct Celula* prox;
} Celula;

typedef struct Pilha {
    Celula* topo;
} Pilha;

Celula* criarCelula(int x) {
    Celula* nova = (Celula*)malloc(sizeof(Celula));
    nova->elemento = x;
    nova->prox = NULL;
    return nova;
}

void inserir(Pilha* pilha, int x) {
    Celula* nova = criarCelula(x);
    nova->prox = pilha->topo;
    pilha->topo = nova;
}

int remover(Pilha* pilha) {
    if (pilha->topo == NULL) {
        printf("Pilha Vazia\n");
        return -1;
    }
    Celula* tmp = pilha->topo;
    int removido = tmp->elemento;
    pilha->topo = tmp->prox;
    free(tmp);
    return removido;
}

void mostrar(Pilha* pilha) {
    printf("\n[");
    for (Celula* i = pilha->topo; i != NULL; i = i->prox) {
        printf(" %d,", i->elemento);
    }
    printf(" ]\n");
}

int main() {
    Pilha pilha;
    pilha.topo = NULL;

    inserir(&pilha, 2);
    inserir(&pilha, 3);
    int removido = remover(&pilha);
    printf("Removido: %d\n", removido);
