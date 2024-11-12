class CelulaMat{
    CelulaMat prox, ant , ant , sup, inf;
    Celula primeiro, ultimo;
    public CelulaMat(){
        prox = ant = sup = inf = null;
        primeiro = ultimo = new Celula();
    }
}

class Celula{
    int numero;
    Celula prox;
    public Celula(){
        this Celula(0);
    }
    public Celula(int elemento){
        this.numero = elemento;
        this.prox = null;
    }
}

class Matriz{
    CelulaMat inicio;

    void RemoveImparListas(){
        RemoveImparListasRec(inicio);
    }

    void RemoveImparListasRec(CelulaMat i){
        for(CelulaMat tmpI = i; tmpI != null; tmpI = tmpI.dir){
            for(CelulaMat tmpJ = i; tmpJ != null; tmpJ = tmpJ.inf){
                RemoveImparListas2(tmpJ.primeiro, tmpJ.ultimo);
            }
        }
    }

    void RemoveImparListas2(Celula p, Celula u){
        for(Celula tmpP = p; tmpP != u; tmpP = tmpP.prox){
            if(tmpP.prox.elemento %2 == 1){
                Celula x = tmpP.prox;
                tmpP = x.prox;
                x.prox = null;
                x = null;
            }
        }
    }
}