public  class testeespelho {

        public static void main(String[] args) {
            String palavra;
            StringBuilder novapalavra = new StringBuilder();
            palavra = MyIO.readLine();
            
            // Inicialize o StringBuilder com o tamanho da string original
            novapalavra.setLength(palavra.length());
            
            // Itera sobre a string original de trás para frente
            for (int i = palavra.length() - 1; i >= 0; i--) {
                char c = palavra.charAt(i);
                novapalavra.setCharAt(palavra.length() - 1 - i, c);
            }
            
            // Exibe a palavra invertida
            System.out.println(novapalavra.toString());
        }
}
