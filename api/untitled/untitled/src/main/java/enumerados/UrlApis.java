package enumerados;

public enum UrlApis {
	
	getPetAPI("/pet"),
	postPetAPI("/pet"),
	putPetAPI("/pet");
	
	private String resource;
	
	UrlApis(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
}