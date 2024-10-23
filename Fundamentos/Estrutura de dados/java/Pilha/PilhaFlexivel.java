class PilhaFlexivel {
    public Celula topo;

    public PilhaFlexivel(){
        this.topo = null; // cabeça
    }

    public void Inserir(int x){  
        Celula tmp = new Celula(x);
        topo.prox = tmp;
        tmp.prox = null;
        

    }

    public int Remover(){
        int elemento ;
        return elemento;
    }

    public void mostrar(){
        
    }
}
