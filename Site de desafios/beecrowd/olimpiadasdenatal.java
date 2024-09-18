//import java.util.*;

class Pais{
    String nome;
    int ouro;
    int prata;
    int bronze;

    public Pais(String n, int o, int p, int b){
        nome = n;
        ouro = o;
        prata = p ;
        bronze = b;
    }

    public int compareTo(Pais comp){
        if(this.ouro != comp.ouro){
            return comp.ouro - this.ouro;
        }else if(this.prata != comp.prata){
            return comp.prata - this.prata;
        }else if(this.bronze != comp.bronze){
            return comp.bronze - this.bronze;
        }else {
            return this.nome.compareTo(comp.nome);
        }
    }

    public String print(){
        return nome + " " + ouro + " " + prata + " " + bronze + "\n";
    }
}

public class olimpiadasdenatal {
    public static void main(String [] Args){
     //   Pais [] quadrodemedalhas ;
    }
}
