class Lista{
    CelulaLista inicio;
    CelulaLista fim;
}

class CelulaLista{
    CelulaPilha topo;
    CelulaLista prox;
}

class CelulaPilha{
    CelulaPilha prox;
    int elemento;
}

public int maior;

CelulaLista maiorPilha(){
    return maiorPilha(inicio);
}

CelulaLista maiorPilha(CelulaLista i){
    CelulaLista x = null;
    if(i == null){
        return x; // erro lista vazia 
    }else{
        for(CelulaLista tmp = i; tmp != null; i = i.prox){
            int newtam = maiorPilha(tmp.topo);
            if(newtam > maior){
                maior = newtam;
                x = i;
            }
        }
    }
    return x;
}

int maiorPilha(CelulaPilha i){
    int acc = 0;
    for(CelulaPilha tmp = i; tmp != null; i = i.prox){
        acc++;
    }
    return acc;
}

