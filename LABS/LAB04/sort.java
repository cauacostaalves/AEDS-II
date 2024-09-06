import java.util.*;

public class sort {

    public static int[] OrdemModulo(int[] array , int Modulo){
        for(int i=0; i<array.length; i++){
            int temp = array[i];
            temp = temp % Modulo;
            if(temp < 0){
                temp = 0;
            }
            array[i] = temp;
        }
        return array;
    }

    public static void printArray(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void swap(int [] array, int i,int j ){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void ordenando(int[] array , int[] Modulado){
        for(int i = 0; i < (array.length - 1); i++){
            int menor = i;
            for(int j = i+1; j<array.length; j++){
                if(Modulado[menor] > array[j]){
                    menor = j;
                }
            }
            swap(Modulado,menor,i);
            swap(array,menor,i);
        }
    }

    public static void conferir(int[] vet1, int[] vet2) {
        boolean trocou;
        int tam = vet2.length;
        do {
            trocou = false;
            for (int i = 0; i < tam - 1; i++) {
                if (vet2[i] == vet2[i + 1]) {
                    if (deveTrocarParImpar(vet1[i], vet1[i + 1])) {
                        swap(vet1, i, i + 1);
                        trocou = true;
                    } else if (deveTrocarImpares(vet1[i], vet1[i + 1])) {
                        swap(vet1, i, i + 1);
                        trocou = true;
                    } else if (deveTrocarPares(vet1[i], vet1[i + 1])) {
                        swap(vet1, i, i + 1);
                        trocou = true;
                    }
                }
            }
        } while (trocou);
    }

    private static boolean deveTrocarParImpar(int num1, int num2) {
        return num1 % 2 == 0 && num2 % 2 != 0;
    }

    private static boolean deveTrocarImpares(int num1, int num2) {
        return num1 % 2 != 0 && num2 % 2 != 0 && num1 < num2;
    }

    private static boolean deveTrocarPares(int num1, int num2) {
        return (num1 % 2 == 0) && (num2 % 2 == 0) && (num2 < num1);
    }

    public static void main(String Args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
            int QtdNumeros = sc.nextInt();
            int Modulo = sc.nextInt();
            if(QtdNumeros == 0 && Modulo == 0){
                break;
            }
            int[] array = new int[QtdNumeros];
            int[] Modulado = new int[QtdNumeros]; 

            for(int i = 0; i<QtdNumeros; i++){
                int num = sc.nextInt();
                array[i] = num;
                Modulado[i] = num;
            }
            OrdemModulo(Modulado, Modulo);

            printArray(array);
            printArray(Modulado);

            ordenando(array,Modulado);
            conferir(array,Modulado);
            
            printArray(array);
            printArray(Modulado);
            
        }
        System.out.print("0 0");
        sc.close();
    }
}