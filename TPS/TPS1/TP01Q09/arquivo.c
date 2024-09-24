#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *file;
    int n;
    

    scanf("%d", &n);

    // Abre o arquivo para escrita binária
    file = fopen("arq.bin", "wb");
    if (file == NULL) {
        return 1;
    }

    
    for (int i = 0; i < n; i++) {
        double num;
        scanf("%lf", &num);
        fwrite(&num, sizeof(double), 1, file); // variavel q recebe , tamanho dela , quantas delas , e pra onde vai
    }
    fclose(file);

    // Abre o arquivo para leitura binária
    file = fopen("arq.bin", "rb");
    if (file == NULL) {
        return 1;
    }

    // Move o ponteiro para o final do arquivo
    fseek(file, 0, SEEK_END); // move o ponteiro do arq pra onde eu quero 
    long fileSize = ftell(file); // retorna a posiçao atual do ponteiro, ou seja, como eu movi para o final o ponteiro retorna a quantidade de bytes no arquivo 
    long doubleSize = sizeof(double); // fala q o tamanho dos itens podem ser double 
    long pointer = fileSize - doubleSize; // pega o tamanho do arquivo (fileSize) - o tamanho de um numero (double) = a posiaçao do ultimo valor 

    // Lê e imprime os números doubles em ordem reversa
    for (int i = 0; i < n; i++) {
        fseek(file, pointer, SEEK_SET);  // Move o ponteiro para a posição desejada
        double num;
        fread(&num, sizeof(double), 1, file); // le um arq binario e faz o mesmo q o fwrite = variavel q recebe , tamanho dela , quantas delas , e pra onde vai

        if (num == (int)num) {
            printf("%d\n", (int)num);
        } else {
            printf("%g\n", num);
        }
        pointer -= doubleSize;  // Move o ponteiro para o número anterior
    }

    fclose(file);
    return 0;
}
