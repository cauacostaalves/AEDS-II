import java.io.*;
import java.net.*;
import java.util.*;

class leituraHtml {
	public static String getHtml(String endereco){
		StringBuffer resp = new StringBuffer();
		try {
			URL obj = new URL(endereco);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// Método de requisição
			con.setRequestMethod("GET");

			// Código de resposta da conexão
			int responseCode = con.getResponseCode();

			// Se a conexão foi bem-sucedida (código 200)
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;



				while ((inputLine = in.readLine()) != null) {
					resp.append(inputLine);
				}

				// Fecha os buffers
				in.close();

			} else {
				System.out.println("Erro na conexão: " + responseCode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}      

		return resp.toString();
	}
    
    public static int contador(String string, String escolhida){
        int count =0;
        int index =0;
        while((index = string.indexOf(escolhida,index)) != -1 ){
            count++;
        }
        return count;
    }
    
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		String pagina = sc.nextLine();
        String endereco, html;
		endereco = sc.nextLine();
		html = getHtml(endereco);
        int table = contador(html, "<table>");
        int br = contador(html, "<br>");
        System.out.println(table);
        System.out.println(br);
    
        sc.close();
	}
}