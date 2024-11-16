public class Fila {
    public int[] array;
    public int posicao; 
    public int tam; 

    Fila(){
        this.tam =0;
        this.array = new int[tam];
        this.posicao = 0;
    }

    Fila(int tam){
        this.tam = tam;
        this.array = new int[tam];
        this.posicao = 0;
    }

    public void inserirFinal(int x){
        if(posicao >= tam){
            System.out.println("Erro!!! Pilha cheia.");
            return;
        }
        array[posicao++] = x;
    }

    public int removerInicio(){
        if(posicao <= 0){
            System.out.println("Erro!!! Pilha vazia.");
            return -1;
        }
        int elemento = array[0];
        for(int i=0; i<posicao-1; i++){
            array[i] = array[i+1];
        }
        posicao--;
        return elemento;
    }

    public void mostrar(){
        System.out.print("[ ");
        for(int i =0;i<posicao;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }
}
