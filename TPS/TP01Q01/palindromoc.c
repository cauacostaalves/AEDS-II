#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main()
{   
    char palavra[100];
    while (true)
    {
        
        fgets(palavra, sizeof(palavra), stdin);
        palavra[strlen(palavra) - 1] = 0;
        bool teste = true;

        if(!(strcmp(palavra, "FIM"))){  
            return 0;
        }

        int tam = strlen(palavra);
        int j = tam-1;

        for (int i = 0; i < tam / 2; i++)
        {
            if (palavra[i] != palavra[j])
            {
                teste = false;
                break;
            }
            j--;
        }

        if (teste)
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
