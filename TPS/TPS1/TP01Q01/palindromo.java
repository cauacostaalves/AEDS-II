import java.util.Scanner;

public class palindromo {
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
    Scanner scan = new Scanner(System.in);
    String frase;
    frase = scan.nextLine();
    while (!frase.equals("FIM")) {
      if (ispalindromo(frase, 0, frase.length() - 1)) {
        System.out.println("SIM");
      } else {
        System.out.println("NAO");
      }
      frase = scan.nextLine();
    }
    scan.close();
  }
}