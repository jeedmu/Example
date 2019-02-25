package http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

public class Figi {
	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create("https://api.openfigi.com/v1/mapping"))
		      .header("Content-type", "application/json")
		      .POST(BodyPublishers.ofString("[{\"idType\":\"ID_WERTPAPIER\",\"idValue\":\"851399\",\"exchCode\":\"US\"}]"))
		      .build();
		System.out.println(client.send(request, BodyHandlers.ofString())
		      .body());

	}
}
