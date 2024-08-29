
public class Is {
    public static boolean IsVogal(String frase) {
        int tam = frase.length();
        String vogais = "aeiouAEIOU";
        for (int i = 0; i < tam; i++) {
            char c = frase.charAt(i);
            if (vogais.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean IsConsoante(String frase) {
        int tam = frase.length();
        String vogais = "aeiouAEIOU";
        for (int i = 0; i < tam; i++) {
            char c = frase.charAt(i);
            if (Character.isLetter(c) == true) {
                if (vogais.indexOf(c) != -1) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean IsInteiro(String frase) {
        int tam = frase.length();
        for (int i = 0; i < tam; i++) {
            char c = frase.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean IsReal(String frase) {
        int tam = frase.length();
        int erro = 0;

        for (int i = 0; i < tam; i++) {
                if ( frase.charAt(i) == '.' ||  frase.charAt(i) == ',') {
                    erro++;
                    if (erro > 1) {
                        return false;
                    } 
                }else if ( frase.charAt(i) < '0' ||  frase.charAt(i)> '9') {
                    return false;
                }   
        }
        return true;
    }

    public static void main(String[] args) {
        String frase;
        while (true) {
            frase = MyIO.readLine();
            if (frase.equals("FIM")) {
                break;
            }
            if (IsVogal(frase)) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (IsConsoante(frase)) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (IsInteiro(frase)) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (IsReal(frase)) {
                MyIO.print("SIM");
            } else {
                MyIO.print("NAO");
            }
            MyIO.print("\n");
        }
    }
}
