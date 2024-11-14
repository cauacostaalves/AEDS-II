class ArvoreArvore{
    No raiz;
}

class No{
    char letra;
    No esq, dir;
    No2 raiz;
}

class No2{
    String palavra;
    No2 esq, dir;
}

int contarPalavras(String nome){
    return caminhar1(nome, raiz);
}

int caminhar1(String nome, No i){ 
    if(i == null){
        return 0;
    }else if(nome.charAt(0) == i.letra){
        return caminhar2(i.raiz, nome);
    }else{
       return caminhar1(nome, i.esq) + caminhar1(nome, i.dir);
    }
}

int caminhar2(No2 i, String nome){
    if(i == null){
        return 0;
    }
    int acc = 0;
    if(nome.length() == i.palavra.length()){
        acc++;
    }
    return acc + caminhar2(i.esq, nome) + caminhar2(i.dir, nome);
}