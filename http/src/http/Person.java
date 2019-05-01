package http;

public class Person {
	private String navn;
	private String adresse;
	
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		return "Person [navn=" + navn + ", adresse=" + adresse + "]";
	}

}
