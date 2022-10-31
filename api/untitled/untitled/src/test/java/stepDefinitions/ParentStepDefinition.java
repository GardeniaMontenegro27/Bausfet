package stepDefinitions;

import common.Utilities;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import jsonBuild.JsonBuild;

public class ParentStepDefinition {

	static RequestSpecification res;
	static ResponseSpecification resspec;
	static Response response;
	Utilities util = new Utilities();
	JsonBuild data = new JsonBuild();
	
}
