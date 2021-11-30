package es.ubu.asi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
	
	public static String getResponse(HttpURLConnection con) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
			    content.append(inputLine);
			}
			in.close();
			return content.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		URL url;
		HttpURLConnection con;
		String apiTextos = "http://localhost:8080/TablonWS/webapi/textos";
		String apiTexto = "http://localhost:8080/TablonWS/webapi/textos/1";

		try {
			url = new URL(apiTextos);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			System.out.println(getResponse(con));
			con.disconnect();
			
			url = new URL(apiTexto);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			System.out.println(getResponse(con));
			con.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
