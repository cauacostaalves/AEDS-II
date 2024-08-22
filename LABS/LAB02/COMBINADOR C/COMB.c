#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int main() {
    char palavra1[100];
    char palavra2[100];
    char construida[200]; 

    while (true) {
       
        if (scanf("%s", palavra1) == EOF) break;
        if (scanf("%s", palavra2) == EOF) break;

        int tam1 = strlen(palavra1);
        int tam2 = strlen(palavra2);
        int tam3 = 0; 
        int i = 0, j = 0; 

        
        while (i < tam1 || j < tam2) {
            if (i < tam1) {
                construida[tam3++] = palavra1[i++];
            }
            if (j < tam2) {
                construida[tam3++] = palavra2[j++];
            }
        }
        construida[tam3] = '\0'; 

        printf("%s\n", construida);

        memset(construida, 0, sizeof(construida));
    }

    return 0;
}
