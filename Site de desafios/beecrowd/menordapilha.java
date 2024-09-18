import java.util.*;

class Pilha{
    int tam;
    int []pilha;
    int topo;

    public Pilha(int t){
        this.tam = t;
        this.pilha = new int[tam];
        this.topo = -1;
    }

    public boolean inserirpilha(int valor){
        boolean flag = false;
        if(topo > tam -1){
            System.out.print("ERRO");
            return flag;
        }
        topo++;
        pilha[topo] = valor; 
        flag = true;
        return flag;
    }

    public int removerpilha(){
         if(topo < 0){
            System.out.print("ERRO");
            return -1;
        }
        int removido = pilha[topo];
        topo--;
        return removido;
    }

    public int menorvalorpilha(){
        int menor = pilha[0];
        for(int i = 1;i<=topo;i++){
            if(menor > pilha[i]){
                menor = pilha[i];
            }
        }
        return menor;
    }

    public void imprimirpilha(){ 
        for (int i = topo ; i >= 0;i--){
            System.out.print( pilha[i] + " ");
        }
    }
}

public class menordapilha{

    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int acoes = sc.nextInt();
        sc.nextLine();
        Pilha pil = new Pilha(acoes);
        while(acoes > 0 ){
            String acao = sc.next();
            if(acao.equals("PUSH")){ 
                int num = sc.nextInt();
                sc.nextLine();
                System.out.println(pil.inserirpilha(num));
            }
            else if(acao.equals("MIN")){
                System.out.println(pil.menorvalorpilha());
            }else if(acao.equals("POP")){
                pil.removerpilha();
            }
            
            acoes --;
        }
        sc.close();
    }
}