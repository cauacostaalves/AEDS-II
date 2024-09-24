import java.io.*;
import java.net.*;
import java.util.*;

class LeituraHtml {
	public static String getHtml(String endereco){
		StringBuilder resp = new StringBuilder();
		try {
			URL obj = new URL(endereco);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;



				while ((inputLine = in.readLine()) != null) {
					resp.append(inputLine).append("\n");
				}

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
            index += escolhida.length();
        }
        return count;
    }

	public static int contadorConsoantes(String html , String consoantes){
		int count =0;
		for(char c : consoantes.toCharArray()){
			count += contador(html, String.valueOf(c));
		}
		return count;
	}
    
	public static void contadorVogais(String html , char[]vogais){
		int count =0;
		for(int i=0;i<22;i++){
			char c = vogais[i];
			count = contador(html, String.valueOf(c));
			System.out.printf("%s(%d) " , vogais[i] , count );
			count = 0;
		}
	}
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		while(true){

			String pagina = sc.nextLine();

			if(pagina.equals("FIM")){
				break;
			}

        	String endereco, html;

			endereco = sc.nextLine();
			html = getHtml(endereco);
			String consoantes = "bcdfghjklmnpqrstvwxyz" ;
			char [] vogais = { 97, 101, 105, 111, 117, 225, 233, 237, 243, 250, 224, 232, 236, 242, 249, 227, 245, 226, 234,
				238, 244, 251 };
			contadorVogais(html, vogais);

        	int table = contador(html, "<table>");
        	int br = contador(html, "<br>");
			int cons = contadorConsoantes(html , consoantes);

			System.out.print("consoante(" + cons + ") ");
        	System.out.print("<br>(" + br + ") ");
            System.out.print("<table>(" + table + ") ");
			System.out.println(pagina);    	
		}	
		sc.close();
	}
}