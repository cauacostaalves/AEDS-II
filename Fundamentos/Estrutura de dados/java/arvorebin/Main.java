import java.util.*;

class Main {
    public static void main(String[] args) {
        ArvoreBi teste = new ArvoreBi();
        teste.inserir(6);
        teste.inserir(3);
        teste.inserir(9);
        teste.caminharCentral();
        teste.caminharPre();
        teste.caminharPos();
    }
}