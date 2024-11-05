

public class questao3 {
    // deve ser teta (m+n)
    public static int[] vetorOrdenado(int[] vetA, int[] vetB){
        int tamA = vetA.length;
        int tamB = vetB.length;
        int[] vetC = new int[tamA + tamB];
        int i =0;
        tamA --;
        tamB --;
        while(tamA >= 0 && tamB >= 0){
            if(vetA[tamA] > vetB[tamB]){
                vetC[i] = vetA[tamA];
                tamA--;
                i++;
            }else{
                vetC[i] = vetB[tamB];
                tamB--;
                i++;
            }
        }

        while(tamA >= 0){
            vetC[i] = vetA[tamA];
                tamA--;
                i++;
        }

        while(tamB >= 0){
            vetC[i] = vetB[tamB];
                tamB--;
                i++;
        }

        return vetC;
    }

    public static void main(String[] args) {
        int[] vetA = {46, 38, 22, 10}; 
        int[] vetB = {57, 33, 21};

        int[] vetC = vetorOrdenado(vetA, vetB);
        
        for(int i: vetC ){
            System.out.print(i + " ");
        }
    }
}
