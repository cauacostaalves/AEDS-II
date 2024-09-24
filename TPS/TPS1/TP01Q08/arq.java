
import java.util.Scanner;
import java.io.RandomAccessFile;

public class arq {
    public static void main(String[] args) {
         try {
        Scanner scanf = new Scanner(System.in);
        int n = scanf.nextInt();
        
          RandomAccessFile file1 = new RandomAccessFile("arq.txt", "rw");
            for (int i = 0; i < n; i++) {
                double num = scanf.nextDouble();
                file1.writeDouble(num );
            }
            
            file1.close();

        file1 = new RandomAccessFile("arq.txt", "r");

        long doubleSize = Double.BYTES;
        long pointer = file1.length() - doubleSize;
        // 0000 0001 0010

         for (int i = 0; i < n; i++) {
             file1.seek(pointer);  // Move o ponteiro para a posição desejada
                double num = file1.readDouble();
                 if (num == (int) num) {
                    System.out.println((int) num);
                } else {
                    System.out.println(num);
                }
          pointer -= doubleSize;  // Move o ponteiro para o número anterior
            }


    file1.close();
        scanf.close();
    
      } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
