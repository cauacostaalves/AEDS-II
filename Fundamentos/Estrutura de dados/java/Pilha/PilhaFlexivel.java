class PilhaFlexivel {
    public Celula topo;

    public PilhaFlexivel(){
        this.topo = null;
    }

    public void Inserir(int x){  
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }

    public int Remover(){
        if(topo == null){System.out.println("Pilha vazia"); return -1;}
        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }

    public int soma(){
        int resp = 0;
        for(Celula i = topo; i != null; i = i.prox){
            resp += i.elemento;
        }
        return resp;
    }

    public int somaRec(){
        int resp = somaRecursiva(0,topo);
        return resp;
    }

    public int somaRecursiva(int resp,Celula i){
        if(i != null){
            resp += i.elemento;
            return somaRecursiva(resp,i.prox);
        }
            return resp;
    }

    public int maiorElemento(){
        int maior = 0;
        for(Celula i = topo; i != null; i = i.prox){
            if(i.elemento > maior){
                maior = i.elemento;
            }
        }
        return maior;
    }

    public int maiorElementoRec(){
        int resp = maiorEleRecursivo(0,topo);
        return resp;
    }

    public int maiorEleRecursivo(int maior, Celula i){
        if(i != null){
            if(i.elemento > maior){
                return maiorEleRecursivo(i.elemento, i.prox);
            }else{
                return maiorEleRecursivo(maior, i.prox);
            }
        }
        return maior;
    }

    public void mostrarEleERemov(){
        mostrarEleERemovRec();
    }

    public void mostrarEleERemovRec() {
        if(topo != null){
            System.out.print(Remover() + " ");
            mostrarEleERemovRec();
        }
    }

    public void mostrarEleInseridos(){
        mostrarEleInseridosRec(topo);
    }

    public void mostrarEleInseridosRec(Celula i) {
        if(i.prox != null){
            mostrarEleInseridosRec(i.prox);
        }
        System.out.print(i.elemento + " ");
    }

    public void mostrar(){
        System.out.print("[ ");
        for(Celula i = topo; i!=null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
    }
}
