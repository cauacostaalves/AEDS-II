

class Lista{
    CelulaLista inicio;
    CelulaLista FIm;
}

class CelulaLista{
    CelulaLista topo;
    CelulaLista prox;

    CelulaLista maiorPilha(){
        CelulaLista maior;
        int acc =0;
        int temp = 0;
        for(CelulaLista i = inicio; i != null; i = i.prox ){
            acc = 0;
            for(CelulaPilha t = i.topo; t  != null; t = t.prox){
               acc++;
            }

            if(temp > acc){
                maior = i;
                temp = acc;
            }
        }
        return maior;
    }
}

class CelulaPilha{
    int elemento;
    CelulaPilha prox;
}


class questao1{
   
    public static void main(String[] args) {
        Lista newlista ;
    }

}