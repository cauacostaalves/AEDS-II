import java.util.*;


public class AvaliadorExpressaoBooleana {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine().trim();
            if (linha.isEmpty()) continue;

            String resultado = processaExpressao(linha);

            System.out.println(resultado);
        }

        scanner.close();
    }

    private static String processaExpressao(String entrada) {
        String[] partes = entrada.split(" ", 2);
        int n = Integer.parseInt(partes[0]);
        String restante = partes[1].trim();

        // Divide os valores e a expressão
        String valoresParte = restante.substring(0, n * 2 - 1); // n valores binários
        String expressao = restante.substring(n * 2).trim(); // A expressão booleana

        // Converte os valores binários em um array de booleanos
        boolean[] valores = new boolean[n];
        for (int i = 0; i < n; i++) {
            valores[i] = valoresParte.charAt(i * 2) == '1';
        }

        // Avalia a expressão booleana
        boolean resultado = avaliaExpressao(expressao, valores);

        return resultado ? "SIM" : "NÃO";
    }

    private static boolean avaliaExpressao(String expressao, boolean[] valores) {
        expressao = expressao.trim();

        // Substitui variáveis na expressão
        for (int i = 0; i < valores.length; i++) {
            expressao = expressao.replace("A" + i, valores[i] ? "true" : "false");
        }

        // Avalia a expressão booleana
        return avaliaExpressaoBooleana(expressao);
    }

    private static boolean avaliaExpressaoBooleana(String expressao) {
        // Remove espaços e substitui operadores booleanos
        expressao = expressao.replaceAll("\\s+", ""); // Remove espaços
        expressao = expressao.replaceAll("and", "&&");
        expressao = expressao.replaceAll("or", "\\|\\|");
        expressao = expressao.replaceAll("not", "!");

        // Verifica se a expressão é uma expressão booleana simples
        if (expressao.equals("true")) {
            return true;
        } else if (expressao.equals("false")) {
            return false;
        }

        // Avalia a expressão manualmente (simples parser de operadores booleanos)
        return evalSimpleBooleanExpression(expressao);
    }

    private static boolean evalSimpleBooleanExpression(String expressao) {
        Stack<Boolean> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i = 0;

        while (i < expressao.length()) {
            char c = expressao.charAt(i);

            if (c == 't' || c == 'f') {
                boolean value = c == 't';
                values.push(value);
                i++; // Skip 'r' and 'u' for 'true' and 'a' for 'false'
                if (i < expressao.length() && expressao.charAt(i) == 'r') {
                    i++;
                    if (i < expressao.length() && expressao.charAt(i) == 'u') {
                        i++;
                    }
                } else if (i < expressao.length() && expressao.charAt(i) == 'a') {
                    i++;
                }
            } else if (c == '!') {
                // operador NOT
                i++;
                if (i < expressao.length() && (expressao.charAt(i) == 't' || expressao.charAt(i) == 'f')) {
                    boolean value = expressao.charAt(i) == 't';
                    values.push(!value);
                    i++; // skip next character(s)
                    if (i < expressao.length() && expressao.charAt(i) == 'r') {
                        i++;
                        if (i < expressao.length() && expressao.charAt(i) == 'u') {
                            i++;
                        }
                    } else if (i < expressao.length() && expressao.charAt(i) == 'a') {
                        i++;
                    }
                }
            } else if (c == '&' || c == '|') {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(c);
                i++;
            } else {
                i++;
            }
        }

        while (!ops.isEmpty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.isEmpty() ? false : values.pop();
    }

    private static int precedence(char op) {
        switch (op) {
            case '!':
                return 3;
            case '&':
                return 2;
            case '|':
                return 1;
        }
        return -1;
    }

    private static boolean applyOp(char op, boolean b, boolean a) {
        switch (op) {
            case '&':
                return a && b;
            case '|':
                return a || b;
        }
        return false;
    }
}
