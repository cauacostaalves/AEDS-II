  /* Pilha Padrao
        Possui:
     //contrutor com definição   
     Pilha(int tam) 
     //construtor vazio
     Pilha()
     // inserção de um elemento
     void Inserir(int elemento)
     // Remoção de um elemento retorn o proprio
     int Remover()
     // Imprimir a pilha na tela com o padrao [ x x x ]
     void mostrarPilha()
     */

 class Pilha {
    public int posicoes;
    public int[] array;
    public int tam;

    public Pilha(int tam){
        this.tam = tam;
        this.array = new int[tam];
        this.posicoes = 0;
    }

    public Pilha(){
        this.array = null;
        this.tam = 0;
        this.posicoes = 0;
    }

    public void Inserir(int elemento){
        if(posicoes == tam){
            System.out.println("Erro!!!  Pilha cheia.");
            return;
        }
        array[posicoes++] = elemento;    }

    public int Remover(){
        if(posicoes <= 0){
            System.out.println("Erro!!!  Pilha vazia.");
            return -1;
        }
        int elemento = array[--posicoes];
        return elemento;
    }

    public void mostrarPilha(){
        if(posicoes <= 0){
            System.out.println("Erro!!!  Sem elemento.");
            return;
        }
        System.out.print("[ ");
        for(int i =posicoes-1;i>=0;i--){
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }
}