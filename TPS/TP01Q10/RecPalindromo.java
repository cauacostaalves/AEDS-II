
public class RecPalindromo {
  public static boolean ispalindromo(String frase, int i, int tam) {
    if (i >= tam) {
      return true;
    } else {
      if (frase.charAt(i) != frase.charAt(tam)) {
        return false;
      }
    }
    return ispalindromo(frase, i + 1, tam - 1);
  }

  public static void main(String[] args) {
    
    String frase;
    frase = MyIO.readLine();
    while (!frase.equals("FIM")) {
      if (ispalindromo(frase, 0, frase.length() - 1)) {
        MyIO.println("SIM");
      } else {
          MyIO.println("NAO");
      }
      frase = MyIO.readLine();
    }
    
  }
}