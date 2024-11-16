class No{
    public int elemento;
    public No esq, dir;
    public acc ;

    No(int x){
        this.elemento = x;
        this.esq = this.dir  = null;
        this.acc = 1;
    }
}

public class Arvore{
    private No raiz;

    public void inserir(int x){
        raiz = inserir(raiz, x);
    }

    private No inserir(No i, int x){
        if(i == null){
            i = new No(x);
        }else if(i.elemento == x){
            i.acc ++;
        }else if(i.elemento < x){
            i.esq = inserir(i.esq, x);
        }else{
            i.dir = inserir(i.dir,x);
        }
        return i;
    }
}