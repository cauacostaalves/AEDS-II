import java.util.*;

class QuickPivo {

    public static void QuickSortPadrao(int[] array, int left, int right){
        int i = left , j = right;
        int pivo = array[(left+right)/2];
        while(i <= j){
            
            while(array[i] < pivo){i++;}
            while(array[j] > pivo){j--;}
            
            if(i <=j){
                swap(array,i,j);
                    i++; 
                    j--;
            }
            if (left < j) {QuickSortPadrao(array,left, j);}
            if (i < right) {QuickSortPadrao(array,i, right);}
        }
    }

    public static void QuickSortFirstPivot(int[] array, int left, int right) {
        if (left < right) { 
            int pivo = array[left]; 
            int i = left + 1;
            int j = right;
    
            while (i <= j) {
                while (i <= right && array[i] < pivo) { i++; }
                while (j >= left && array[j] > pivo) { j--; }
    
                if (i <= j) {
                    swap(array, i, j);
                    i++;
                    j--;
                }
            }
    
            swap(array, left, j); 
    
            QuickSortFirstPivot(array, left, j - 1); 
            QuickSortFirstPivot(array, j + 1, right); 
        }
    }

    public static void QuickSortLastPivot(int[] array, int left, int right) {
        if (left < right) { 
            int pivo = array[right]; 
            int i = left ;
            int j = right-1;
    
            while (i <= j) {
                while (i <= right && array[i] < pivo) { i++; }
                while (j >= left && array[j] > pivo) { j--; }
    
                if (i <= j) {
                    swap(array, i, j);
                    i++;
                    j--;
                }
            }
    
            swap(array, i, right); 
    
            QuickSortLastPivot(array, left, j ); 
            QuickSortLastPivot(array, i , right); 
        }
    }

    

    public static void QuickSortMediaOfThreePivot(int[] array, int left, int right) {
        if (left < right) { 
            int pivo = (array[left] + array[right] + array[(left+right)/2])/3 ; 
            int i = left ;
            int j = right;
    
            while (i <= j) {
                while (i <= right && array[i] < pivo) { i++; }
                while (j >= left && array[j] > pivo) { j--; }
    
                if (i <= j) {
                    swap(array, i, j);
                    i++;
                    j--;
                }
            }
    
            swap(array, i, right); 
    
            QuickSortMediaOfThreePivot(array, left, j ); 
            QuickSortMediaOfThreePivot(array, i , right); 
        }
    }

    public static void QuickSortRandomPivot(int[] array, int left, int right) {
        if (left < right) {
            Random rand = new Random();
            
            int randomIndex = left + rand.nextInt(right - left + 1);
            
            int pivo = array[randomIndex];
            
            swap(array, randomIndex, right); 
            
            int i = left;
            int j = right - 1; 
    
            while (i <= j) {
                while (i <= j && array[i] < pivo) {
                    i++;
                }
                while (j >= left && array[j] > pivo) {
                    j--;
                }
    
                if (i <= j) {
                    swap(array, i, j);
                    i++;
                    j--;
                }
            }
    
            swap(array, i, right);
    
            QuickSortRandomPivot(array, left, j); 
            QuickSortRandomPivot(array, i, right); 
        }
    }
    
    public static void swap(int[] array, int i,int j){
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] TamArray(int tam) {
        return new int[tam]; 
    }

    public static void completarray(int[] array){
        Random rand = new Random();
        for(int i =0;i<array.length;i++){
            array[i] = rand.nextInt(100);
        }
    }   

    public static int[] createAlmostSortedArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i + 1; 
        }

        Random rand = new Random();
        for (int i = 0; i < size / 10; i++) { 
            int index1 = rand.nextInt(size);
            int index2 = rand.nextInt(size);
            swap(array, index1, index2);
        }

        return array;
    }

    public static void main(String[] Args){
        int[] array = createAlmostSortedArray(1000);
       // int[] array = TamArray(1000);
        completarray(array);
        
        System.out.println("Antes de Ordenar:");
        for(int num: array){
            System.out.print(num + " ");
        }
        System.out.println();
        
        long startTime = System.nanoTime();
        
        QuickSortPadrao(array, 0 , array.length-1);
       // QuickSortFirstPivot(array, 0, array.length-1);
       // QuickSortLastPivot(array, 0, array.length-1); 
       // QuickSortMediaOfThreePivot( array,0,array.length-1);
       // QuickSortRandomPivot(array, 0, array.length-1);
        long endTime = System.nanoTime();

        System.out.println("Depois de Ordenar:");
        for(int num: array){
            System.out.print(num + " ");
        }
        System.out.println();

        long duration = endTime - startTime;

        double durationInSeconds = duration / 1_000_000_000.0; 
        System.out.printf("Tempo de execução para ordenar: %.9f segundos%n", durationInSeconds);
    }
}
