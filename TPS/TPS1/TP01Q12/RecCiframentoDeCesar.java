
public class RecCiframentoDeCesar {
    public static void codificando(String frase, int tam, int i,String temp){
        int ASCII = 0;

        if(i>=tam ){
            MyIO.println(temp);
            return;
        }else{
            ASCII = frase.charAt(i);
            ASCII += 3;
            codificando(frase, tam, i+1 , temp +=(char)ASCII);
        }
        
    }
    public static void main(String Args[]) {
        String frase;
        while (true) {
            frase = MyIO.readLine();
            if (frase.equals("FIM")) {
                break;
            }
            int tam = frase.length();
            codificando(frase, tam, 0,"");
        }
    }
}
