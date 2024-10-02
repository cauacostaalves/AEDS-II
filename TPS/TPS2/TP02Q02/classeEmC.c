#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include <unistd.h>

#define MAX_NAME_LEN 50
#define MAX_DESC_LEN 200
#define MAX_TYPE_LEN 20
#define MAX_ABILITIES 10
#define MAX_DATE_LEN 11
#define MAX_LINE_LEN 512

typedef struct {
    int id;
    int generation;
    char *name;
    char *description;
    char *type1;
    char *type2;
    char abilities[MAX_ABILITIES][MAX_TYPE_LEN];
    int ability_count;
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    char *captureDate;
} Pokemon;

void trimWhitespace(char *str) {
    char *end;
    while (isspace((unsigned char)*str)) str++;
    if (*str == 0) return;
    end = str + strlen(str) - 1;
    while (end > str && isspace((unsigned char)*end)) end--;
    end[1] = '\0';
}

void parseAbilities(char *abilitiesString, Pokemon *pokemon) {
    char *token = strtok(abilitiesString, ",");
    pokemon->ability_count = 0;

    while (token != NULL && pokemon->ability_count < MAX_ABILITIES) {
        trimWhitespace(token);
        if (token[0] == '\'') memmove(token, token + 1, strlen(token));
        if (token[strlen(token) - 1] == '\'') token[strlen(token) - 1] = '\0';
        strcpy(pokemon->abilities[pokemon->ability_count++], token);
        token = strtok(NULL, ",");
    }
}

void initializePokemon(Pokemon *pokemon) {
    pokemon->name = malloc(MAX_NAME_LEN);
    pokemon->description = malloc(MAX_DESC_LEN);
    pokemon->type1 = malloc(MAX_TYPE_LEN);
    pokemon->type2 = malloc(MAX_TYPE_LEN);
    pokemon->captureDate = malloc(MAX_DATE_LEN);
    pokemon->ability_count = 0;
    pokemon->weight = -1.0;
    pokemon->height = -1.0;
    pokemon->captureRate = -1;
    pokemon->isLegendary = false;
}

void freePokemon(Pokemon *pokemon) {
    free(pokemon->name);
    free(pokemon->description);
    free(pokemon->type1);
    free(pokemon->type2);
    free(pokemon->captureDate);
}

bool lerPokemon(int id, Pokemon *pokemon) {
    if (access("pokemon.csv", F_OK) == -1) {
        printf("Arquivo não encontrado no caminho especificado.\n");
        return false;
    }

    FILE *file = fopen("pokemon.csv", "r");
    if (!file) {
        printf("ERROR: File Not Found.\n");
        return false;
    }

    char line[MAX_LINE_LEN];
    fgets(line, sizeof(line), file); // Ignorar cabeçalho

    while (fgets(line, sizeof(line), file)) {
        int file_id;
        if (sscanf(line, "%d", &file_id) != 1) {
            continue; // Pula para a próxima linha
        }

        if (file_id == id) {
            initializePokemon(pokemon);

            char abilitiesString[MAX_LINE_LEN] = "";
            int legendary;
            char type2_temp[MAX_TYPE_LEN] = "";

            // Ajustando o sscanf para tratar a ausência de type2
            int matched = sscanf(line, "%d,%d,%49[^,],%199[^,],%19[^,],%19[^,],\"%[^\"]\",%lf,%lf,%d,%d,%10[^\n",
                                 &pokemon->id, &pokemon->generation,
                                 pokemon->name, pokemon->description,
                                 pokemon->type1, type2_temp,
                                 abilitiesString,
                                 &pokemon->weight, &pokemon->height,
                                 &pokemon->captureRate, &legendary,
                                 pokemon->captureDate);

            // Se type2 não foi lido, deixar vazio
            if (matched < 6 || strlen(type2_temp) == 0) {
                strcpy(pokemon->type2, "");
            } else {
                strcpy(pokemon->type2, type2_temp);
            }

            // Remove colchetes e aspas
            char *start = abilitiesString;
            char *end = abilitiesString + strlen(abilitiesString) - 1;
            while (*start == '[' || *start == '\'' || *start == ' ') start++;
            while (*end == ']' || *end == '\'' || *end == ' ') end--;
            *(end + 1) = '\0';

            parseAbilities(start, pokemon);
            pokemon->isLegendary = (bool)legendary;

            fclose(file);
            return true;
        }
    }

    fclose(file);
    return false;
}

void imprimirPokemon(Pokemon *pokemon) {
    printf("[#%d -> %s: %s - [", pokemon->id, pokemon->name, pokemon->description);
    printf("'%s'", pokemon->type1);

    // Apenas imprime type2 se não estiver vazio
    if (strlen(pokemon->type2) > 0) {
        printf(", '%s'", pokemon->type2);
    } else {
        printf(", 'N/A'"); // Indica que não há type2
    }
    printf("] - [");

    for (int i = 0; i < pokemon->ability_count; i++) {
        printf("'%s'%s", pokemon->abilities[i], (i < pokemon->ability_count - 1) ? ", " : "");
    }
    printf("] - ");

    // Imprimir peso e altura ou 'N/A' se não estiver disponível
    printf("%.1fkg - %.1fm - ", 
           (pokemon->weight >= 0) ? pokemon->weight : -1.0, 
           (pokemon->height >= 0) ? pokemon->height : -1.0);

    // Imprimir taxa de captura ou 'N/A'
    printf("%d%% - %s - %d gen] - %s\n",
           (pokemon->captureRate >= 0) ? pokemon->captureRate : -1,
           pokemon->isLegendary ? "true" : "false",
           pokemon->generation,
           (pokemon->captureDate[0] != '\0') ? pokemon->captureDate : "N/A");
}

int main() {
    Pokemon pokemon;
    char input[10];

    while (true) {
        fgets(input, sizeof(input), stdin);
        input[strcspn(input, "\r")] = '\0'; 
        trimWhitespace(input);

        if (strcasecmp(input, "FIM") == 0) {
            break; 
        }

        int idParaBuscar = atoi(input); 
        if (lerPokemon(idParaBuscar, &pokemon)) {
            imprimirPokemon(&pokemon); 
        } else {
            printf("Pokémon não encontrado.\n");
        }

        // Libera a memória após imprimir
        freePokemon(&pokemon);
    }

    return 0;
}
