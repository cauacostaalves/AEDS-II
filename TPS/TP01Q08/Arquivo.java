
import java.io.*;
import java.util.Scanner;

class Arquivo {

    public static void main(String[] args) throws Exception {
        RandomAccessFile arq = new RandomAccessFile("arquivo.txt", "rw");
        arq.setLength(0);
        
        Scanner sc = new Scanner(System.in);

        float input = 0;
        int totalNum = 0;
        float actualNum = 0;
        totalNum = sc.nextInt();

        for (int i = 0; i < totalNum; i++) {
            String inputStr = sc.next();
            inputStr = Formatar(inputStr);

            input = Float.parseFloat(inputStr);
            arq.writeFloat(input);
        }

        int arqTotal = (int)arq.length();

        do {
            arqTotal -= 4;
            arq.seek((long)arqTotal);
            actualNum = arq.readFloat();
            if ((actualNum - (int)actualNum) == 0){
                System.out.println((int)actualNum);
            }
            else{
                System.out.println(actualNum);
            } 
        } while ( arqTotal >= 4 );

        arq.close();
        sc.close();
    }

    public static String Formatar(String str) {
        int i = 0, len = str.length();

        while (i < len && str.charAt(i) == '0') i++;

        str = str.substring(i, len);

        if (str.contains(".")) {
            i = str.length() - 1;

            while (str.charAt(i) == '0') i--;
            
            if (str.charAt(i) == '.') i--;
            
            str = str.substring(0, i + 1);
        }

        if (str.charAt(0) == '.')  str = "0" + str;

        return str;
    }

}
    