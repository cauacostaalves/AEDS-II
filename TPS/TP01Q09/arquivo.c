#include <stdio.h>
#include <stdlib.h>

int main (){
    FILE* arq = NULL;
    arq = fopen("numeros.txt" , "w+");
    int tam=0;
    scanf("%d" , &tam);
    float num = 0;
    for(int i =0;i<tam;i++){
        scanf("%f",&num );
        fprintf(arq,"%f\n",num);
    }
    fseek(arq, 0, SEEK_SET);
    float* numtotal = (float*)malloc(tam * sizeof(float));
    for(int i = 0; i<tam ;i++ ){
        fscanf(arq, "%f" , &numtotal[i]);
    }
    for(int i=tam-1;i>=0;i--){
        
        printf("%g\n",numtotal[i]);
    }
    free(numtotal);
    fclose(arq);
    return 0;
}