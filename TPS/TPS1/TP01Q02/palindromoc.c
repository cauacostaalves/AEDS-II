#include <stdio.h>
#include <string.h>
#include <stdbool.h>
int verInput(char* input){

    int i = 0;
    int j = strlen(input)-1;

    while ( i <= j){

        int skip = 0;

        if ( input[i] == -61 ) i++;
        if ( input[j] == -61 ) j--;

        if ( input[i] == -17 ) i+=2, skip = 1;

        if ( input[i] != input[j] ) return 0;

        if ( skip ) j-=2;

        i++;
        j--;
       
    }
    
    return 1;

}

int main()
{   
    char palavra[100];
    while (true)
    {
        
        fgets(palavra, sizeof(palavra), stdin);
        palavra[strlen(palavra) - 1] = 0;
      

        if(!(strcmp(palavra, "FIM"))){  
            return 0;
        }

        int tam = strlen(palavra);
        int j = tam-1;

      

        if (verInput(palavra))
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
