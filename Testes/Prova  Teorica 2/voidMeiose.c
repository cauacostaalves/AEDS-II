typdef struct Celula{
    int elemento;
    struct Celula* prox;
}Celula;

Celula* incio;
Celula* fim;

void Meiose(){
    for(Celula* i = incio; i != fim; i = i->prox){
        Celula* tmp = (Celula*) malloc(sizeof * (Celula));
        tmp->elemento = i->elemento/2;
        i->elemento = tmp->elemento;
        tmp->prox = i->prox;
        i->prox = tmp;
        i = i.prox;
    }
}
