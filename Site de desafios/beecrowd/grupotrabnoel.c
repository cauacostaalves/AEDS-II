#include <stdio.h>
#include <string.h>

struct Elfo{
    char nome[250];
    int horas;
    char trab[250];
}typedef Elfo;

int main(){
    int N=0;
    scanf("%d",&N);
    int bonecos = 8;
    int arquiteto = 4;
    int musicos = 6;
    int desenhistas = 12;
    struct Elfo elfos[N];
    char nome[250];
    char trab[250];
    int horas; 
        
    for(int i =0;i<N;i++){
        scanf("%s %s %d", nome , trab , &horas);
        strncpy(elfos[i].nome, nome, sizeof(elfos[i].nome));
        strncpy(elfos[i].trab, trab, sizeof(elfos[i].trab));
        elfos[i].horas = horas;            
        }
    
    int contbonecos = 0;
    int contarquiteto = 0;
    int contmusicos = 0;
    int contdesenhistas = 0;

    for (int i = 0; i < N; i++) {
        if (strcmp(elfos[i].trab, "bonecos") == 0) {
            contbonecos += elfos[i].horas;
        } else if (strcmp(elfos[i].trab, "arquitetos") == 0) {
            contarquiteto += elfos[i].horas;
        } else if (strcmp(elfos[i].trab, "musicos") == 0) {
            contmusicos += elfos[i].horas;
        } else if (strcmp(elfos[i].trab, "desenhistas") == 0) {
            contdesenhistas += elfos[i].horas;
        }
    }
    contbonecos = contbonecos/bonecos;
    contarquiteto = contarquiteto/arquiteto;
    contmusicos = contmusicos/musicos;
    contdesenhistas = contdesenhistas/desenhistas;
    int acc = contarquiteto + contbonecos + contdesenhistas + contmusicos;
    printf("%d\n",acc);
    return 0;
}