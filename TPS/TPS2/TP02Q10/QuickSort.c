#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

// Atributos de um pokemon
typedef struct
{
    int id;
    int generation;
    char name[80];
    char description[80];
    char type1[80];
    char type2[80];
    char abilities[200];
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    char captureDate[12];
} Pokemon;

// Declaração das funções
void printPokemon(const Pokemon *pokemon);
char *strsep(char **stringp, const char *delim);
void formatarString(char *str);
void adicionarPokemon(char *linha, Pokemon *pokemon);
void lerArquivo(const char *nomeArquivo, Pokemon pokemons[], int *totalPokemons);
int buscarPokemonID(int id, Pokemon pokemons[], int totalPokemons);

// Printar um pokemon em tal formato
void printPokemon(const Pokemon *pokemon)
{
    printf("[#%d -> %s: %s - ['%s'", 
           pokemon->id, 
           pokemon->name, 
           pokemon->description, 
           pokemon->type1);
    
    if (strcmp(pokemon->type2, "") != 0)
    {
        printf(", '%s']", pokemon->type2);
    } else
    {
        printf("]");
    }

    printf(" - %s - %.1fkg - %.1fm - %d%% - %s - %d gen] - %s", 
           pokemon->abilities, 
           pokemon->weight, 
           pokemon->height, 
           pokemon->captureRate, 
           pokemon->isLegendary ? "true" : "false", 
           pokemon->generation, 
           pokemon->captureDate);
}

// Função manual para strsep
char *strsep(char **stringp, const char *delim)
{
    char *start = *stringp;
    char *p;

    if (start == NULL)
    {
        return NULL;
    }

    p = strpbrk(start, delim);
    if (p)
    {
        *p = '\0';
        *stringp = p + 1;
    }
    else
    {
        *stringp = NULL;
    }

    return start;
}

// Retirar as " da string e substituir todas as , foras de [ ] por ; 
void formatarString(char *str)
{
    int dentroColchetes = 0;  
    int j = 0;  

    for (int i = 0; str[i] != '\0'; i++)
    {
        if (str[i] == '[')
        {
            dentroColchetes = 1;  
        } else if (str[i] == ']')
        {
            dentroColchetes = 0; 
        }

        if (str[i] == ',' && dentroColchetes == 0)
        {
            str[j++] = ';';
        }
        else if (str[i] != '"')
        {
            str[j++] = str[i];
        }
    }

    str[j] = '\0'; 
}

// Adicionar um pokemon ao array
void adicionarPokemon(char *linha, Pokemon *pokemon)
{
    char *token;
    token = strsep(&linha, ";");
    pokemon->id = atoi(token);

    token = strsep(&linha, ";");
    pokemon->generation = atoi(token);

    token = strsep(&linha, ";");
    strcpy(pokemon->name, token);

    token = strsep(&linha, ";");
    strcpy(pokemon->description, token);

    token = strsep(&linha, ";");
    strcpy(pokemon->type1, token);

    token = strsep(&linha, ";");
    if (token[0] != 0) strcpy(pokemon->type2, token);

    token = strsep(&linha, ";");
    strcpy(pokemon->abilities, token);

    token = strsep(&linha, ";");
    pokemon->weight = atof(token);  

    token = strsep(&linha, ";");
    pokemon->height = atof(token);

    token = strsep(&linha, ";");
    pokemon->captureRate = atoi(token);

    token = strsep(&linha, ";");
    pokemon->isLegendary = atoi(token);  

    token = strsep(&linha, ";");
    strcpy(pokemon->captureDate, token);
}

// Ler o CSV linha por linha e ir setando os pokemons
void lerArquivo(const char *nomeArquivo, Pokemon pokemons[], int *totalPokemons)
{
    FILE *arquivo = fopen(nomeArquivo, "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo %s\n", nomeArquivo);
        return;
    }

    char linha[512];
    *totalPokemons = 0;

    while (fgets(linha, sizeof(linha), arquivo))
    {
        formatarString(linha);  
        adicionarPokemon(linha, &pokemons[*totalPokemons]);
        (*totalPokemons)++;
    }

    fclose(arquivo);
}

// Retornar o indice de um pokemon buscado por ID
int buscarPokemonID(int id, Pokemon pokemons[], int totalPokemons)
{
    for (int i = 0; i < totalPokemons; i++)
    {
        if (pokemons[i].id == id)
        {
            return i;
        }
    }

    return -1;
}

<<<<<<< Updated upstream
void quickSort(Pokemon pokes[801], int left, int right) {
    int i = left;
    int j = right;
    Pokemon piv = pokes[(left + right) / 2]; // meio

    while (j >= i) {
        // Comparação para geração e nome
        while (pokes[i].generation < piv.generation || 
               (pokes[i].generation == piv.generation && strcmp(pokes[i].name,piv.name) < 0)) {
            i++;
        }
        while (pokes[j].generation > piv.generation || 
               (pokes[j].generation == piv.generation && strcmp(pokes[j].name,piv.name) > 0)) {
            j--;
        }

        if (j >= i) {
            Pokemon temp = pokes[i];
            pokes[i] = pokes[j];
            pokes[j] = temp;
=======
void QuickSort(Pokemon NewPokedex[801] , int tam , int left , int right){
 
    int i = left;
    int j = right;
    int piv = array[(left + right)/2];
    while ( j >= i )
    {
        while ( array[i] < piv ) i++;
        while ( array[j] > piv ) j--;

        if ( j >= i ) 
        {
            swap(array, i, j);
>>>>>>> Stashed changes
            i++;
            j--;
        }
    }
<<<<<<< Updated upstream

    // Recursão
    if (left < j) quickSort(pokes, left, j);
    if (i < right) quickSort(pokes, i, right);
}


=======
   
    if ( left < j ) QuickSort(NewPokedex,tam, left, j);
    if ( right > i ) QuickSort(NewPokedex,tam, i, right);

}

>>>>>>> Stashed changes
int main(void)
{
    Pokemon pokemons[1000];
    int totalPokemons;

<<<<<<< Updated upstream
    lerArquivo("/tmp/pokemon.csv", pokemons, &totalPokemons);
=======
    lerArquivo("pokemon.csv", pokemons, &totalPokemons);
>>>>>>> Stashed changes

    char input[15];
    int i=0;
    Pokemon NewPokemons[801];

    while (true)
    {
        scanf(" %s", input);
        
        if (strcmp(input, "FIM") == 0)
        {
            break;
        }

        int id = atoi(input);
        NewPokemons[i++] = pokemons[id];

    }
<<<<<<< Updated upstream

    quickSort(NewPokemons, 0, i-1);

=======
    QuickSort(NewPokemons, i);
    
>>>>>>> Stashed changes
    for(int j =0;j<i;j++){
        printPokemon(&NewPokemons[j]);
    }
    
    return 0;
}
