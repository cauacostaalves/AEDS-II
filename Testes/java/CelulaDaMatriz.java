class CelulaDaMatriz{
    public int elemento;
    public CelulaDaMatriz esq, dir, sup, inf;

    public CelulaDaMatriz(){
        this(0);
    }

    public CelulaDaMatriz(int elemento){
        this(elemento,null,null,null,null);
    }

    public CelulaDaMatriz(int elemento, CelulaDaMatriz esq, CelulaDaMatriz dir, 
    CelulaDaMatriz sup,CelulaDaMatriz inf){
        this.elemento = elemento;
        this.esq = esq;
        this.inf = inf;
        this.sup = sup;
        this.dir = dir;
    }
}


class Matriz{
    private CelulaDaMatriz inicio; 
    private int linha,coluna;
    
    public Matriz(){
        this(3,3); // exemplo de tamanho 3 por 3
    }

    public Matriz(int linha,int coluna){
        this.linha = linha;
        this.coluna = coluna;
        //resto do codigo
    }

    public Matriz MatrizSoma(Matriz a , Matriz b){
        Matriz resp = null;
        if ((a.linha == b.linha) && (a.coluna == b.coluna)){
            resp = new Matriz(a.linha,a.coluna);
        }
        
        for(int i = 0 ; i < a.linha; i++, a.inicio = dir b.inicio  = dir){
            for(int j =0; j < a.coluna; j++ ){
                 //resto codigo
            }
        }
        return resp;
    }
    
}



public static void main(String[] Args){

} 