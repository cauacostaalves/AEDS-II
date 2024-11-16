class No{
    No direita;
    No esquerda;
    int elemento;

    No(){
       this.direita = null;
       this.esquerda = null;
       this.elemento = 0 ; 
    }

    No(int ele){
        this.direita = null;
        this.esquerda = null;
        this.elemento = ele ; 
    }

    No(int ele, No dir, No esq){
        this.direita = dir;
        this.esquerda = esq;
        this.elemento = ele ; 
    }

}