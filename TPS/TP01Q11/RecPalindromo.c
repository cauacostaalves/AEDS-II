#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool ispalindroma(int i, int j, char palavra[]) {
    if (i >= j) {
        return true;
    } else {
        if (palavra[i] != palavra[j]) {
            return false;
        }
        return ispalindroma(i + 1, j - 1, palavra);
    }
}

int main()
{
    char palavra[100];
    while (true)
    {
        fgets(palavra, sizeof(palavra), stdin);
        palavra[strlen(palavra) - 1] = 0;

        if (!(strcmp(palavra, "FIM")))
        {
            return 0;
        }

        int tam = strlen(palavra);
        bool teste = ispalindroma(0,tam-1,palavra);
        if (teste == true )
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
    }
    return 0;
}
