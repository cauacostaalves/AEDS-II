
class testeselecao {
    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void selecao(int[] array, int n) {
        int cont = 0;
        for (int i = 0; i < n - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < n; j++) {
                 cont++;
                if (array[menor] > array[j]) {
                    menor = j;
                }
            }
            System.out.println(cont);
            swap(i, menor, array);
        }System.out.println(cont);
    }

    public static void main(String[] args) {

        int[] array = { 50, 45, 37, 20, 15, 5, 10 };
        selecao(array, array.length);
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
    }
}
