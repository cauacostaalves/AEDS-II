import java.util.*;
import java.text.DecimalFormat;

class Presente{
    String nome;
    double preco;
    int preferencia;

    public Presente(String n, double p, int pre){
        nome =n;
        preco =p;
        preferencia = pre;
    }

    public int compareTo(Presente comp){
        if(this.preferencia != comp.preferencia){
            return comp.preferencia - this.preferencia;
        }else if(this.preco != comp.preco){
            return Double.compare(this.preco, comp.preco);
        }else{
            return this.nome.compareTo(comp.nome);
        }
    }

    public String imprimir(){
        DecimalFormat df = new DecimalFormat("#.00");
        return nome + " - R$" + df.format(preco);    
    }
}

public class presentedenatal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String pessoa = sc.next();
            int tam = sc.nextInt();
            sc.nextLine();
            Presente [] lista = new Presente[tam];

            for(int i =0;i<tam;i++){
                String nome = sc.next();
                double preco = sc.nextDouble();
                int preferencia = sc.nextInt();
                sc.nextLine();
                lista[i] = new Presente(nome, preco, preferencia);
            }

            for(int i =0;i< tam-1;i++){
                for(int j =0;j<tam-i-1;j++){
                    if(lista[j].compareTo(lista[j+1]) > 0 ){
                       Presente temp = lista[j];
                       lista[j] = lista[j+1];
                       lista[j+1] = temp;
                    }
                }
            }

            System.out.println("Lista de " + pessoa);
            for(int i =0 ; i<tam;i++){
                System.out.println(lista[i].imprimir());
            }System.out.println();
        }
        sc.close();
    }
}
