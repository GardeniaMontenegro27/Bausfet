package jsonBuild;

import apiModels.Pet;

public class JsonBuild {

	public Pet postPetPayload(String id, String name, String status) {
		Pet p = new Pet();
		p.setId(id);
		p.setName(name);
		p.setStatus(status);
		return p;
	}
	
	public Pet updatePetName(String id, String name, String status) {
		Pet a = new Pet();
		a.setId(id);
		a.setName(name);
		a.setStatus(status);
		return a;
	}
	
	
}
