package TPS.TP01Q08;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

public class Arquivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       try{ RandomAccessFile arq = new RandomAccessFile("num.txt" , "rw");
        int x = sc.nextInt();
            for(int i = 0 ; i < x ; i++){
            double n = sc.nextDouble();
            arq.writeDouble(n);
            }
            arq.close();
            sc.close();
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
}
