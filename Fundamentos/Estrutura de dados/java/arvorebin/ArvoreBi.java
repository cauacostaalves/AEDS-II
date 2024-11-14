class ArvoreBi{
    No raiz;

    ArvoreBi(){
        this.raiz = null;
    }

    void inserir(int elemento){
        raiz = inserir(raiz,elemento);
    }

    No inserir(No tmp,int elemento){
            if(tmp == null){
                tmp = new No(elemento);
            }else if(elemento < tmp.elemento){
                tmp.esquerda = inserir(tmp.esquerda,elemento); 
            }else if(elemento > tmp.elemento){
                tmp.direita = inserir(tmp.direita, elemento);      
            }else{
                System.out.println("Ja existe o elemento na arvore.");
            }
            return tmp;
    } 

    void caminharCentral() {
		System.out.print("[ ");
		caminharCentral(raiz);
		System.out.println("]");
	}

	void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esquerda); 
			System.out.print(i.elemento + " "); 
			caminharCentral(i.direita); 
		}
	}

    public void caminharPre() {
		System.out.print("[ ");
		caminharPre(raiz);
		System.out.println("]");
	}

	private void caminharPre(No i) {
		if (i != null) {
			System.out.print(i.elemento + " ");
			caminharPre(i.esquerda); 
			caminharPre(i.direita); 
		}
	}

	public void caminharPos() {
		System.out.print("[ ");
		caminharPos(raiz);
		System.out.println("]");
	}

	private void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esquerda);
			caminharPos(i.direita); 
			System.out.print(i.elemento + " "); 
		}
	}


}


