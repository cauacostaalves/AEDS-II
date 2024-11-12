class Matriz{
    CelulaMatriz inicio;
    int linha, coluna;

    CelulaDupla diagUnificada(){
        return caminharDiagonal(inicio);
    }

    CelulaDupla caminharDiagonal(CelulaMatriz i){
        CelulaDupla sentinela;
        while(i != null){
            MontaLista(sentinela, i.inicio, i.fim);
            i = i.dir;
            if(i != null){
                i = i.inf;
            }
        }
        return sentinela;
    }

    void MontaLista(CelulaDupla sentinela, Celula incio, Celula fim){
        for(Celula tmp = inicio; tmp != fim; tmp = tmp.prox){
            inserirListaDupla(sentinela, tmp.elemento);
        }
    }

    void inserirListaDupla(CelulaDupla sentinela, int x){
        CelulaDupla tmp = new CelulaDupla(x);
        tmp = sentinela.prox;
        sentinela.prox = tmp;
        tmp.prox.ant = tmp;
        tmp.ant = sentinela;
    }

}

class CelulaMatriz{
    CelulaMatriz esq, dis, inf , sup;
    Celula incio,fim;
}

class Celula{
    int elemento;
    Celula prox;
}

class CelulaDupla{
    int elemento;
    CelulaDupla prox,ant;
}