class Matriz {
    private Celula inicio;
    private int NumLinhas;
    private int NumColunas;

    Matriz(){
        inicio = createLinha();
        Celula linhaAbaixo = createLinha();

        for (Celula i = inicio, tmp = linhaAbaixo; i != null; i = i.dir) {
            i.inf = tmp;
            tmp.sup = i;

            tmp = tmp.dir;
        }
        NumLinhas = 2;
        NumColunas = 2;
    }

    Celula createLinha(){
        Celula i = new Celula();
        Celula j = new Celula();

        i.dir = j;
        j.esq = i;

        return i;
    }

    Celula createLinha(int x){
        Celula i = new Celula();
        Celula tmp = i;

        for (int j = 0; j < x - 1; j++) {
            Celula nova = new Celula();
            tmp.dir = nova;
            nova.esq = tmp;
            tmp = nova;
        }

        return i;
    }

    Celula createColuna(int x){
        Celula i = new Celula();
        Celula tmp = i;

        for (int j = 0; j < x - 1; j++) {
            Celula nova = new Celula();
            tmp.inf = nova;
            nova.sup = tmp;

            tmp = nova;
        }

        return i;
    }

    void addLinha(){
        Celula i;
        for (i = inicio; i.inf != null; i = i.inf)
            ;
        for (Celula j = createLinha(NumColunas); j != null; j = j.dir) {
            i.inf = j;
            j.sup = i;

            i = i.dir;
        }
        NumLinhas++;
    }

    void addColuna(){
        Celula i;
        for (i = inicio; i.dir != null; i = i.dir)
            ;
        for (Celula j = createColuna(NumLinhas); j != null; j = j.inf) {
            i.dir = j;
            j.esq = i;

            i = i.inf;
        }

        NumColunas++;
    }

    void addElemento(int x, int linhaPos, int colunaPos){
        if(linhaPos >= NumLinhas || colunaPos >= NumColunas || linhaPos < 0 || colunaPos < 0){
            try{
                throw new Exception("Posicao invalida");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            Celula tmp = inicio;
            for(int i = 0; i < colunaPos; i++){
                tmp = tmp.dir;
            }
            for(int i = 0; i < linhaPos; i++){
                tmp = tmp.inf;
            }
            tmp.elemento = x;
        }
    }

    void getDiagonal(){
        if(NumColunas != NumLinhas){
            try{
                throw new Exception("Esta matriz nao possui Diagonal Principal");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            Celula i = inicio;

            while(i != null){
                System.out.print(i.elemento + " ");
                i = i.dir;
                if(i != null){
                    i = i.inf;
                }
            }
            System.out.println("\n");
        }

    }

    void getDiagonalSecundaria() {
        if (NumColunas != NumLinhas) {
            try {
                throw new Exception("Esta matriz não possui Diagonal Secundária");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
        
            Celula i = inicio;
            while (i.dir != null) {
                i = i.dir;  
            }
    
            while (i != null) {
                System.out.print(i.elemento + " ");
                i = i.esq;  
                if (i != null) {
                    i = i.inf;  
                }
            }
            System.out.println("\n");
        }
    }
    

    void mostra(){
        for (Celula i = inicio; i != null; i = i.inf) {
            for (Celula j = i; j != null; j = j.dir) {
                System.out.print(j.elemento + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}