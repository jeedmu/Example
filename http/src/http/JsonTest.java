package http;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

	public static void main(String[] args) throws IOException {
		Person person = new Person();
		person.setNavn("Hans");
		person.setAdresse("Herning");
		
		ObjectMapper mapper = new ObjectMapper(new JsonFactory());
		String json = mapper.writeValueAsString(person);
		System.out.println(json);
		
		Person p1 = mapper.readValue(json, Person.class);
		System.out.println(p1);
				
//		HttpClient client = HttpClient.newHttpClient();
//		HttpRequest.Builder builder = HttpRequest.newBuilder();
//		builder = builder.uri(URI.create("https://api.openfigi.com/v1/mapping"));
//		builder = builder.header("Content-type", "application/json");
//		builder = builder.POST();
//		HttpRequest request = builder.build();

	}

}
