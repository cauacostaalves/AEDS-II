#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

#define MAX_TYPES 2
#define MAX_ABILITIES 1
#define MAX_NAME_LENGTH 40
#define MAX_DESCRIPTION_LENGTH 100
#define MAX_POKEMON 802

typedef struct {
    int id;
    int generation;
    char name[MAX_NAME_LENGTH];
    char description[MAX_DESCRIPTION_LENGTH];
    char types[MAX_TYPES][20]; // Supondo um máximo de 2 tipos
    char abilities[MAX_ABILITIES][20]; // Supondo um máximo de 1 habilidade
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    struct tm captureDate; // Usando struct tm para data
} Pokemon;

void imprimirPokemon(Pokemon *poke) {
    char dateStr[11];
    strftime(dateStr, sizeof(dateStr), "%d/%m/%Y", &poke->captureDate);

    printf("[#%d -> %s: %s - [", poke->id, poke->name, poke->description);
    for (int i = 0; i < MAX_TYPES; i++) {
        if (strlen(poke->types[i]) > 0) {
            printf("'%s'", poke->types[i]);
            if (i < MAX_TYPES - 1 && strlen(poke->types[i + 1]) > 0) {
                printf(", ");
            }
        }
    }
    printf("] - [%s] - %.2f kg - %.2f m - %d%% - %s - %d gen] - %s\n",
           poke->abilities[0],
           poke->weight,
           poke->height,
           poke->captureRate,
           poke->isLegendary ? "true" : "false",
           poke->generation,
           dateStr);
}

int lerPokemon(FILE *file, Pokemon *pokedex, int max_pokemon) {
    char line[256];
    int count = 0;

    while (count < max_pokemon && fgets(line, sizeof(line), file)) {
        Pokemon poke;
        char types[MAX_TYPES][20] = {0};
        char abilities[MAX_ABILITIES][20] = {0};
        int isLegendaryTemp; // Variável temporária para isLegendary

        sscanf(line, "%d,%d,%39[^,],%99[^,],%19[^,],%19[^,],%19[^,],%lf,%lf,%d,%d,%d/%d/%d",
               &poke.id, &poke.generation, poke.name, poke.description,
               types[0], types[1], abilities[0],
               &poke.weight, &poke.height, &poke.captureRate,
               &isLegendaryTemp, // Agora usando a variável temporária
               &poke.captureDate.tm_mday, &poke.captureDate.tm_mon, &poke.captureDate.tm_year);

        // Ajustar a data (tm_year é a partir de 1900)
        poke.captureDate.tm_year -= 1900;
        poke.captureDate.tm_mon -= 1;

        // Copiar tipos e habilidades
        strcpy(poke.types[0], types[0]);
        if (strlen(types[1]) > 0) {
            strcpy(poke.types[1], types[1]);
        }
        strcpy(poke.abilities[0], abilities[0]);

        // Atribuir o valor a isLegendary
        poke.isLegendary = (isLegendaryTemp == 1);

        pokedex[count++] = poke;
    }
    return count;
}

int main() {
    FILE *file = fopen("/tmp/pokemon.csv", "r");
    if (!file) {
        perror("Failed to open file");
        return EXIT_FAILURE;
    }

    Pokemon pokedex[MAX_POKEMON];
    int numPokemon = lerPokemon(file, pokedex, MAX_POKEMON);
    fclose(file);

    char idPokemon[4];
    while (true) {
        scanf("%s", idPokemon);
        if (strcmp(idPokemon, "FIM") == 0) {
            break;
        }
        int idPok = atoi(idPokemon);
        if (idPok > 0 && idPok <= numPokemon) {
            imprimirPokemon(&pokedex[idPok ]);
        } else {
            printf("Pokémon não encontrado!\n");
        }
    }

    return 0;
}
