// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

class CoutingSort {
   CoutingSort() {
   }

   public static ArrayList<String> LerCSV() {
      String var0 = "pokemon.csv";
      ArrayList var1 = new ArrayList();

      try {
         BufferedReader var2 = new BufferedReader(new FileReader(var0));
         var2.readLine();

         String var3;
         while((var3 = var2.readLine()) != null) {
            var1.add(var3);
         }

         var2.close();
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return var1;
   }

   public static void matricula(int var0, int var1, double var2) {
      String var4 = "855926\t" + var1 + "\t" + var0 + "\t" + var2;

      try {
         BufferedWriter var5 = new BufferedWriter(new FileWriter("matr\u00edcula_selecao.txt"));

         try {
            var5.write(var4);
         } catch (Throwable var9) {
            try {
               var5.close();
            } catch (Throwable var8) {
               var9.addSuppressed(var8);
            }

            throw var9;
         }

         var5.close();
      } catch (IOException var10) {
         var10.printStackTrace();
      }

   }

   public static ArrayList<Pokemon> OrdenaCoutingSort(ArrayList<Pokemon> var0) {
      int var1 = var0.size();
      int var2 = var0.stream().mapToInt(Pokemon::getCaptureRate).max().orElse(0);
      int[] var3 = new int[var2 + 1];
      ArrayList var4 = new ArrayList(Collections.nCopies(var1, (Object)null));

      Pokemon var6;
      for(Iterator var5 = var0.iterator(); var5.hasNext(); ++var3[var6.getCaptureRate()]) {
         var6 = (Pokemon)var5.next();
      }

      int var10;
      for(var10 = 1; var10 <= var2; ++var10) {
         var3[var10] += var3[var10 - 1];
      }

      for(var10 = var1 - 1; var10 >= 0; --var10) {
         var6 = (Pokemon)var0.get(var10);
         var4.set(var3[var6.getCaptureRate()] - 1, var6);
         --var3[var6.getCaptureRate()];
      }

      ArrayList var11 = new ArrayList();

      for(int var12 = 0; var12 <= var2; ++var12) {
         ArrayList var7 = new ArrayList();
         Iterator var8 = var4.iterator();

         while(var8.hasNext()) {
            Pokemon var9 = (Pokemon)var8.next();
            if (var9 != null && var9.getCaptureRate() == var12) {
               var7.add(var9);
            }
         }

         var7.sort(Comparator.comparing(Pokemon::getName));
         var11.addAll(var7);
      }

      return var11;
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      ArrayList var2 = LerCSV();
      new ArrayList();
      Pokemon var4 = new Pokemon();
      ArrayList var3 = var4.lerPokemon(var2);
      ArrayList var5 = new ArrayList();

      while(true) {
         String var6 = var1.next();
         if (var6.equals("FIM")) {
            ArrayList var11 = new ArrayList();
            Iterator var12 = var5.iterator();

            while(var12.hasNext()) {
               int var8 = (Integer)var12.next();
               Iterator var9 = var3.iterator();

               while(var9.hasNext()) {
                  Pokemon var10 = (Pokemon)var9.next();
                  if (var10.getId() == var8) {
                     var11.add(var10.Pokemonclone());
                  }
               }
            }

            OrdenaCoutingSort(var11);
            var12 = var11.iterator();

            while(var12.hasNext()) {
               Pokemon var13 = (Pokemon)var12.next();
               var13.imprimirPokemon();
            }

            var1.close();
            return;
         }

         int var7 = Integer.parseInt(var6);
         var5.add(var7);
      }
   }
}
