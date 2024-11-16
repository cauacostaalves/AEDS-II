class FilaFlexivel {
    public Celula primeiro, ultimo;

    FilaFlexivel(){
        this.primeiro = new Celula();
        ultimo = primeiro;   
    }

    public void inserirFinal(int x){
        Celula tmp = new Celula(x);
        ultimo.prox = tmp;
        ultimo = tmp;
        tmp.prox = null;
        tmp = null;
    }

    public int removerInicio(){
        if(primeiro == ultimo){
            System.out.println("Erro!!! Fila vazia.");
            return -1;
        }
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    public int removerInicioCelula(){
        if(primeiro == ultimo){
            System.out.println("Erro!!! Fila vazia.");
            return -1;
        }
        Celula tmp = primeiro.prox;
        int resp = primeiro.prox.elemento;
        primeiro.prox = tmp.prox;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    public int maiorElemento(){
        int resp = 0;
        for( Celula i = primeiro; i !=null; i = i.prox){
            if(i.elemento > resp){
                resp = i.elemento;
            }
        }
        return resp;
    }

    public int soma(){
        int resp = 0;
        for(Celula i = primeiro; i != null; i = i.prox){
            resp += i.elemento;
        }
        return resp;
    }

    public void inverterFila(){
            
    }


    public void mostrar(){
        System.out.print("[ ");
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
    }
}
