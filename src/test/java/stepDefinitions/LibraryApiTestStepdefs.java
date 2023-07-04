package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;

import java.net.URI;
import java.net.URISyntaxException;

public class LibraryApiTestStepdefs {

    private static Logger logger = LogManager.getLogger(LibraryApiTestStepdefs.class);

    private Scenario scenario;
    private Response response;
    private final String BASE_URL = "http://library.com.au/listOfBooks";

    @When("I query for the book using author parameter {string}")
    public void iQueryForTheBookUsingAuthorParameter(String arg0) throws URISyntaxException {
        RequestSpecification req = RestAssured.given();
        response = req.queryParam("author", arg0).when().get(new URI(BASE_URL));
    }


    @When("I query for the book using title parameter {string}")
    public void iQueryForTheBookUsingTitleParameter(String arg0) throws URISyntaxException {
        RequestSpecification req = RestAssured.given();
        response = req.queryParam("author", arg0).when().get(new URI(BASE_URL));
    }

    @Then("the list of books are returned {string}")
    public void theListOfBooksAreReturned(String arg0) {
        response.then().statusCode(200);
        response = response.then().extract().response();

        JSONObject resJson = new JSONObject(response.asString());
        //Get the value of the book using the key
        String message = resJson.getString("get_Value_Using_Key");
        Assert.assertEquals(arg0, message);
    }


}
