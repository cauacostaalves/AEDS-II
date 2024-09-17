import java.util.*;

class etiquetadenoel {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int qtdIdiomas = sc.nextInt();
        ArrayList<String> idiomas = new ArrayList<>(qtdIdiomas);
        ArrayList<String> traducoes = new ArrayList<>(qtdIdiomas);
        
        for(int i =0;i<qtdIdiomas;i++){
            String idioma = sc.nextLine();
            String traducao = sc.nextLine();
            idiomas.add(idioma);
            traducoes.add(traducao);
        }
        
        int qtdPessoas = sc.nextInt();
        for(int i =0;i<qtdPessoas;i++){
            String pessoa = sc.nextLine();
            String idiomapessoa = sc.nextLine();
            for(int j=0;j<qtdIdiomas;j++){ 
                if(idiomas.get(j).equals(idiomapessoa)){
                    System.out.println(pessoa);
                    System.out.println(traducoes.get(j));
                    System.out.println();
                }
            }
        }
    }
}