public class Main {
    public static void main(String[] Args){
        FilaFlexivel fila = new FilaFlexivel();
        fila.inserirFinal(3);
        fila.inserirFinal(5);
        fila.inserirFinal(7);
        fila.mostrar();
        int elemento = fila.removerInicioCelula();
        System.out.println(elemento);
        fila.mostrar();
        fila.inserirFinal(3);
        fila.inserirFinal(100);
        elemento = fila.maiorElemento();
        System.out.println(elemento);
        fila.mostrar();
        elemento = fila.soma();
        System.out.println(elemento);
    }
}
