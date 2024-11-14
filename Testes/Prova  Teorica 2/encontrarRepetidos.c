typedef struct Celula{
    int numero;
    Celula* prox;
}Celula;

typedef struct CelulaMatriz{
    int numero;
    CelulaMatriz *prox, *ant;
    CelulaMatriz *sup, *inf;
}CelulaMatriz;

typedef struct No{
    int numero;
    No *esq, *dir;
}No;

Celula* encontrarRepetidos(No* raiz, CelulaMatriz* inicio){
    Celula* sentinela;
    raiz = caminharEinserir(&raiz, &sentinela, &inicio);
    ListaDecrescente(&sentinela);
    return sentinela;
}

No* caminharEinserir(No* raiz, Celula* sentinela, CelulaMatriz* inicio){
    if(raiz != NULL){
        int x = 0;
        for(CelulaMatriz* i = inicio; i != null; i = i.prox){
            for(CelulaMatriz* j = i; j != null; j = j.inf){
                x = j->numero;
                if(raiz->numero == x){
                    inserirLista(&sentinela, raiz->numero);
                }
            }
        }
        raiz->esq = caminharEinserir(&sentinela, &raiz->esq);
        raiz->dir = caminharEinserir(&sentinela, &raiz->dir);
    }
    return raiz;
}

void inserirLista(Celula* sentinela, int x){
    Celula* tmp = (Celula*) malloc(sizeof * Celula);
    tmp->numero = x;
    tmp->prox = sentinela->prox;
    sentinela->prox = tmp;
}

void ListaDecrescente(Celula* sentinela){
    for(Celula* i = sentinela->prox; i != NULL; i = i->prox){
        for(Celula* j = i->prox; j != NULL; j = j->prox){
            if(j->numero > i->numero){
                int tmp = i->numero;
                i->numero = j->numero;
                j->numero = tmp;
            }
        }
    }
}