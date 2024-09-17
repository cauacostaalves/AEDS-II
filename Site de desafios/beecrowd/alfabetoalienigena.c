#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char alfabeto[250];
    char frase[250];
    while (fgets(alfabeto , sizeof(alfabeto),stdin) && fgets(frase , sizeof(frase),stdin) ) {
        int cont = 0;
        int tamfrase = strlen(frase);
        int tamalfabeto = strlen(alfabeto);
        for (int i = 0; i < tamfrase; i++) {
            for (int j = 0; j < tamalfabeto; j++) {
                if (frase[i] == alfabeto[j]) {
                    cont++;
                }
            }
        }
        printf("%d\n", cont-1);
    }
    return 0;
}
