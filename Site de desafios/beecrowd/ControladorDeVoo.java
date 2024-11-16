import java.util.*;

public class ControladorDeVoo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> Oeste = new ArrayList<>();
        ArrayList<String> Leste = new ArrayList<>();
        ArrayList<String> Norte = new ArrayList<>();
        ArrayList<String> Sul = new ArrayList<>();
        
        String input = "";
        String direcao = "";

        while(!((input = sc.next()).equals("0"))){
            if(!(input.startsWith("A"))){
                direcao = input;
            }
            if(input.startsWith("A")){
                if(direcao.equals("-1")){
                    Oeste.add(input);
                }else if(direcao.equals("-2")){
                    Sul.add(input);
                }else if(direcao.equals("-3")){
                    Norte.add(input);
                }else if(direcao.equals("-4")){
                    Leste.add(input);
                }
            }
        }
        ArrayList<String> resposta = new ArrayList<>();

        while(!Oeste.isEmpty() || !Leste.isEmpty() || !Sul.isEmpty() || !Norte.isEmpty() ){
            if(!Oeste.isEmpty()){
                resposta.add(Oeste.get(0));
                Oeste.remove(0);
            }
            if(!Norte.isEmpty()){
                resposta.add(Norte.get(0));
                Norte.remove(0);
            }
            if(!Sul.isEmpty()){
                resposta.add(Sul.get(0));
                Sul.remove(0);
            }
            if(!Leste.isEmpty()){
                resposta.add(Leste.get(0));
                Leste.remove(0);
            }
        }

        String s ;
        int tam = resposta.size();
        for(int i =0; i < tam; i++){
            s = resposta.get(0);
            System.out.print(s);
            resposta.remove(0);

            if(i < tam-1){
                System.out.print(" ");
            }

        }
        System.out.println();
        sc.close();
    }
}
