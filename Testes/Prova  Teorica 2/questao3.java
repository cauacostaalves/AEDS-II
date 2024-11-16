public static int[] vetorOrdenador(int[] vetA, int[] vetB){
    int tamA = vetA.length;
    int tamB = vetB.length;
    int[] vetC = new int[tamA + tamB];

    int x = 0;
    while( tamA >= 0 && tamB >= 0){
       if(vetA[--tamA] < vetB[--tamB]){
            vetC[x++] = vetA[tamA];
       }else{
        vetC[x++] = vetB[tamB]
       }
    }

    while(tamA >=0){
        vetC[x++] = vetA[--tamA];
    }
    
    while(tamB >=0){
        vetC[x++] = vetB[--tamB];
    }
                
    return vetC;
}