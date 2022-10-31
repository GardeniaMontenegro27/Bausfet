package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import enumerados.UrlApis;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class StepDefinitions extends ParentStepDefinition {
	
	@Given("Post Pet Payload with {string}, {string}, {string}")
	public void post_pet(String id, String name, String status) throws IOException {
		System.out.println("Payload");
		res = given().spec(util.requestSpecification()).body(data.postPetPayload(id, name, status));
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		UrlApis resourceAPI=UrlApis.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			
		if(method.equalsIgnoreCase("GET")) {
			response =res.when().get(resourceAPI.getResource());
			System.out.println("Response GET: "+response.getBody().asString());
		} else if(method.equalsIgnoreCase("POST")) {
			response =res.when().post(resourceAPI.getResource());
			System.out.println("Response POST: "+response.getBody().asString());
		} else if(method.equalsIgnoreCase("DELETE")) {
			response =res.when().delete(resourceAPI.getResource());
			System.out.println("Response DELETE: "+response.getBody().asString());
		} else if(method.equalsIgnoreCase("PUT")) {
			response =res.when().put(resourceAPI.getResource());
			System.out.println("Response PUT: "+response.getBody().asString());
		}
		
		
	}
	
	public void user_calls_with_http_request_params(String resource, String method, String p) {
		UrlApis resourceAPI=UrlApis.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			
		if(method.equalsIgnoreCase("GETBYPARAM")) {
			response =res.when().get(resourceAPI.getResource()+"/"+p);
			System.out.println("Response GET: "+response.getBody().asString());
		}
	}
	
	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);	
	}
	
	@And("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
		assertEquals(util.getJsonPath(response,keyValue),Expectedvalue);
	}
	
	@Then("verify name created maps to {string} using {string} and id {string}")
	public void verify_Id_usuario_created_maps_to_using(String expectedName, String resource, String id) throws IOException {
		System.out.println("Verifying");
		res=given().urlEncodingEnabled(false).spec(util.requestSpecification());
		user_calls_with_http_request_params(resource,"GETBYPARAM",id);
		String actualName = util.getJsonPath(response,"name");
		System.out.println("Actual name: " + actualName + "\nExpected name: " + expectedName);
		assertEquals(actualName,expectedName);
	}
	
	@Then("UpdatePet id {string} after being created via api with new values {string},{string}")
	public void update_user_after_being_created(String id, String newName, String status) throws IOException {
		if (id.isEmpty()) {
			post_pet("1004","percherito","available");
			user_calls_with_http_request("postPetAPI","POST");
		}
		System.out.println("Pet id to update: " + id);
		res = given().spec(util.requestSpecification()).header("id", id).body(data.updatePetName(id,newName,status));
	}

	
}
