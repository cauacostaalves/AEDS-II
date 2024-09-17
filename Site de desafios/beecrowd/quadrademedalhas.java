import java.util.*;
class Paises {
    String nome;
    int ouro;
    int prata;
    int bronze; //declarando o valor de cada variavel
    public  Paises(String n, int o , int p, int b){
        nome = n;
        ouro = o;
        prata = p;
        bronze = b;
    } // colocando em ordem crescente de medalhas ouro prata bronze
    public int compareTo(Paises outro){
        if (this.ouro != outro.ouro) {
            return outro.ouro - this.ouro; 
        } 
        else if (this.prata != outro.prata) {
            return outro.prata - this.prata; 
        } 
        else if(this.bronze != outro.bronze){
            return outro.bronze - this.bronze; 
        }else{
            return this.nome.compareTo(outro.nome); // compara os nomes 
        }
    }
    public String toString() {
        return nome + " " + ouro + " " + prata + " " + bronze;
    }
}
class quadrademedalhas {
   public static void bublesort(Paises [] pais , int qtdPaises){
        int tam = qtdPaises;
        for(int i=0; i < tam-1; i++){
            for(int j = 0 ;j< tam - i - 1;j++){
                if(pais[j].compareTo(pais[j+1]) > 0 ){
                    Paises temp = pais[j];
                    pais[j] = pais[j+1];
                    pais[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int qtdPaises = sc.nextInt();
        sc.nextLine(); // limpa o buffer
        Paises [] quadromedalhas = new Paises [qtdPaises];
        for(int i =0;i<qtdPaises;i++){
            String nome = sc.next();
            int ouro =sc.nextInt();
            int prata =sc.nextInt();
            int bronze =sc.nextInt();
            sc.nextLine(); // limpa o buffer
            quadromedalhas[i] = new Paises(nome,ouro,prata,bronze);
        }
        bublesort(quadromedalhas, qtdPaises);
        for(int i =0 ; i <qtdPaises;i++){
            System.out.println(quadromedalhas[i].toString());
        }
        sc.close();
    }
}
