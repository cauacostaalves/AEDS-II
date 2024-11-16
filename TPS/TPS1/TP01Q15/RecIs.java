
public class RecIs {

    public static boolean IsVogal(String frase, int tam, int i) {
        String vogais = "aeiouAEIOU";
        
        if (i >= tam) {
            return true; 
        }
        
        char c = frase.charAt(i);
        if (vogais.indexOf(c) == -1) {
            return false; 
        }
        
        return IsVogal(frase, tam, i + 1);
    }

    
    public static boolean IsConsoante(String frase,int tam,int i) {
       
        if(i>=tam){
            return true;
        }
        
        String vogais = "aeiouAEIOU";
        
        char c = frase.charAt(i);
        if (Character.isLetter(c) ) {
             if (vogais.indexOf(c) != -1) {
                    return false;
                }
         } else {
                 return false;
             }
        
        return IsConsoante(frase,tam,i+1);
    }

    public static boolean IsInteiro(String frase,int tam,int i) {
        if(i>=tam){
            return true;
        }

        char c = frase.charAt(i);
        if (!Character.isDigit(c)) {
             return false;
         }
        
        return IsInteiro(frase,tam,i+1);
    }

    public static boolean IsReal(String frase, int tam , int i ,int erro) {
        
        if(i>=tam){
            return true;
        }
        if ( frase.charAt(i) == '.' ||  frase.charAt(i) == ',') {
               erro++;
                 if (erro > 1) {
                        return false;
                    } 
                }else if ( frase.charAt(i) < '0' ||  frase.charAt(i)> '9') {
                    return false;
                }   
                return IsReal(frase,tam,i+1,erro);
    
        }

       
    public static void main(String[] args) {
        String frase;
        while (true) {
            frase = MyIO.readLine();
            int tam = frase.length();
            if (frase.equals("FIM")) {
                break;
            }
            if ( IsVogal(frase , tam  , 0)  ) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (IsConsoante(frase,tam,0)) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (IsInteiro(frase,tam,0)) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (IsReal(frase,tam,0,0)) {
                MyIO.print("SIM");
            } else {
                MyIO.print("NAO");
            }
            MyIO.print("\n");
        }
    }
}
