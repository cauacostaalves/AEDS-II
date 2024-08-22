import java.util.Scanner;

class SEQ_ESP {

    public static String inverteNum(int num) {
        String numeroStr = Integer.toString(num);
        StringBuilder sb = new StringBuilder(numeroStr);
        String numeroInvertidoStr = sb.reverse().toString();

        return numeroInvertidoStr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int comeco = 0;
        int fim = 0;

        while (scan.hasNext()) {
            comeco = scan.nextInt();
            fim = scan.nextInt();
            int tam = fim - comeco + 1;
            int[] seq1 = new int[tam];
            String[] seq2 = new String[tam];

            for (int i = 0; i < tam; i++) {
                seq1[i] = comeco;
                comeco++;
            }
            for (int i = 0; i < tam; i++) {
                String numeroInvertido = inverteNum(fim);
                seq2[i] = numeroInvertido;
                fim--;
            }
            for (int i = 0; i < tam; i++) {
                System.out.print(seq1[i]);
            }

            for (int i = 0; i < tam; i++) {
                System.out.print(seq2[i]);
            }
            System.out.println();
        }
        scan.close();
    }
}