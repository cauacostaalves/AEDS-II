
public class ciframentodecesar {
    public static void main(String Args[]) {
        String frase;
        while (true) {
            frase = MyIO.readLine();
            if (frase.equals("FIM")) {
                break;
            }
            int tam = frase.length();
            String temp = "";
            int ASCII = 0;
            
            for (int i = 0; i < tam; i++) {
                ASCII = frase.charAt(i);
                ASCII += 3;
                temp += (char) ASCII;
            }
            MyIO.println(temp);
        }
    }
}
