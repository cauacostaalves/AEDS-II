#include <stdio.h>

typedef struct Paciente{
    int hora;
    int minuto;
    int critico;
}Paciente;

typedef struct Celula{
    struct Celula* prox;
}Celula;

typedef struct Fila{
    struct Celula* primeiro;
}Fila;

int main(){

    return 0;
}