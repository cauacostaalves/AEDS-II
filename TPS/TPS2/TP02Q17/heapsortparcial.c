#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

// Atributos de um pokemon
typedef struct {
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
void heapsort(Pokemon pokes[], int tam);
void redoHeap(Pokemon pokes[], int tam, int i);
void swap(Pokemon pokes[], int i, int j);

void printPokemon(const Pokemon *pokemon) {
    printf("[#%d -> %s: %s - ['%s'", 
           pokemon->id, 
           pokemon->name, 
           pokemon->description, 
           pokemon->type1);
    
    if (strcmp(pokemon->type2, "") != 0) {
        printf(", '%s']", pokemon->type2);
    } else {
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

char *strsep(char **stringp, const char *delim) {
    char *start = *stringp;
    char *p;

    if (start == NULL) {
        return NULL;
    }

    p = strpbrk(start, delim);
    if (p) {
        *p = '\0';
        *stringp = p + 1;
    } else {
        *stringp = NULL;
    }

    return start;
}

void formatarString(char *str) {
    int dentroColchetes = 0;  
    int j = 0;  

    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] == '[') {
            dentroColchetes = 1;  
        } else if (str[i] == ']') {
            dentroColchetes = 0; 
        }

        if (str[i] == ',' && !dentroColchetes) {
            str[j++] = ';';
        } else if (str[i] != '"') {
            str[j++] = str[i];
        }
    }

    str[j] = '\0'; 
}

void adicionarPokemon(char *linha, Pokemon *pokemon) {
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
    strcpy(pokemon->type2, token[0] != '\0' ? token : "");

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

void lerArquivo(const char *nomeArquivo, Pokemon pokemons[], int *totalPokemons) {
    FILE *arquivo = fopen(nomeArquivo, "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo %s\n", nomeArquivo);
        return;
    }

    char linha[512];
    *totalPokemons = 0;

    while (fgets(linha, sizeof(linha), arquivo)) {
        formatarString(linha);  
        adicionarPokemon(linha, &pokemons[*totalPokemons]);
        (*totalPokemons)++;
    }

    fclose(arquivo);
}

int buscarPokemonID(int id, Pokemon pokemons[], int totalPokemons) {
    for (int i = 0; i < totalPokemons; i++) {
        if (pokemons[i].id == id) {
            return i;
        }
    }

    return -1;
}

void heapsort(Pokemon pokes[], int tam) {
    for (int i = tam / 2 - 1; i >= 0; i--) {
        redoHeap(pokes, tam, i);
    }

    for (int endIndex = tam - 1; endIndex > 0; endIndex--) {
        swap(pokes, 0, endIndex);
        redoHeap(pokes, endIndex, 0);
    }
}

void redoHeap(Pokemon pokes[], int tam, int i) {
    int maior = i; 
    int esquerda = 2 * i + 1; 
    int direita = 2 * i + 2; 

    if (esquerda < tam) {
        if (pokes[esquerda].height > pokes[maior].height ||
            (pokes[esquerda].height == pokes[maior].height &&
             strcmp(pokes[esquerda].name, pokes[maior].name) > 0)) {
            maior = esquerda;
        }
    }

    if (direita < tam) {
        if (pokes[direita].height > pokes[maior].height ||
            (pokes[direita].height == pokes[maior].height &&
             strcmp(pokes[direita].name, pokes[maior].name) > 0)) {
            maior = direita;
        }
    }

    if (maior != i) {
        swap(pokes, i, maior);
        redoHeap(pokes, tam, maior);
    }
}

void swap(Pokemon pokes[], int i, int j) {
    Pokemon temp = pokes[i];
    pokes[i] = pokes[j];
    pokes[j] = temp;
}

int main(void) {
    Pokemon pokemons[1000];
    int totalPokemons;

    lerArquivo("/tmp/pokemon.csv", pokemons, &totalPokemons);

    char input[15];
    int i = 0;
    Pokemon NewPokemons[801];

    while (true) {
        scanf(" %s", input);
        
        if (strcmp(input, "FIM") == 0) {
            break;
        }

        int id = atoi(input);
        if (id >= 0 && id < totalPokemons) { // Validate the ID
            NewPokemons[i++] = pokemons[id];
        } else {
            printf("ID inválido: %d\n", id);
        }
    }

    heapsort(NewPokemons, i);

    for (int j = 0; j < 10 && j < i; j++) {
        printPokemon(&NewPokemons[j]);
    }
    
    return 0;
}
