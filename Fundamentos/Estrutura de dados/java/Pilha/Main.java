public class Main {
    public static void main(String[] Args){
        Pilha pilha = new Pilha(3);
        pilha.mostrarPilha();
        int removido = pilha.Remover();
        System.out.println("Removido: " + removido);
        pilha.Inserir(2);
        pilha.Inserir(4);
        pilha.Inserir(7);
        pilha.Inserir(2);
        pilha.mostrarPilha();
        removido = pilha.Remover();
        System.out.println("Removido: " + removido);
        pilha.mostrarPilha();

        
    }
}
