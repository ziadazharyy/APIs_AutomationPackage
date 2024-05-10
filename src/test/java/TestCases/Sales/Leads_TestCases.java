package TestCases.Sales;

import DTO.Sales.Leads;
import Utils.Methods;
import Utils.Requests;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;

import static com.jayway.restassured.RestAssured.given;

public class Leads_TestCases {

    Leads leads = new Leads();
    Requests requests = new Requests();
    Methods methods = new Methods();

    String firstName, lastName, mobileCode, mobile, email, source, notes, assignedSalesId, customerId, nextSteps, lead_URL;

    @BeforeMethod
    public void BeforeMethod() {

        firstName = "Ziad";
        lastName = "Azhary";
        mobileCode = "+20";
        mobile = "01114775700";
        email = "ziad@email.com";
        source = "AppActivity";
        notes = "any notes";
        assignedSalesId = "3a110db9-f4ce-27ce-5521-2f3afff330b7";
        customerId = "3a110d01-4c93-7317-4131-cf433f738e42";
        nextSteps = "Steps...";

        leads.setFirstName(firstName);
        leads.setLastName(lastName);
        leads.setMobileCode(mobileCode);
        leads.setMobile(mobile);
        leads.setEmail(email);
        leads.setSource(source);
        leads.setNotes(notes);
        leads.setAssignedSalesId(assignedSalesId);
        leads.setCustomerId(customerId);
        leads.setNextSteps(nextSteps);

        lead_URL = "/app/leads";
    }

    public String Leads() {

        BeforeMethod();

        String lead_req = requests.Leads_Req(leads);
        System.out.println("Leads Request : " + lead_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(lead_req);

        Response resp = requestSpec.post(requests.base_URL_Login + lead_URL);
        System.out.println("Leads Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");

        return resp.jsonPath().get("result").toString();
    }

    @Test
    public void leads_HappyScenario() {

        String lead_req = requests.Leads_Req(leads);
        System.out.println("Leads Request : " + lead_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(lead_req);

        Response resp = requestSpec.post(requests.base_URL_Login + lead_URL);
        System.out.println("Leads Response : " + resp.asString());

        Assert.assertNotNull(resp.jsonPath().get("result"));
        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
        Assert.assertNull(resp.jsonPath().get("message"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
        Assert.assertNull(resp.jsonPath().get("stackTrace"));
        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void leads_WithUnregistered_CustomerId() {

        leads.setCustomerId(String.valueOf(UUID.randomUUID()));

        String lead_req = requests.Leads_Req(leads);
        System.out.println("Leads Request : " + lead_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(lead_req);

        Response resp = requestSpec.post(requests.base_URL_Login + lead_URL);
        System.out.println("Leads Response : " + resp.asString());

        Assert.assertNull(resp.jsonPath().get("result"));
        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertNotNull(resp.jsonPath().get("message"));
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("The specified condition was not met for 'Customer Id'."));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
        Assert.assertNotNull(resp.jsonPath().get("correlationId"));
    }
    @Test
    public void leads_WithUnregistered_AssignedSalesId() {

        leads.setAssignedSalesId(String.valueOf(UUID.randomUUID()));

        String lead_req = requests.Leads_Req(leads);
        System.out.println("Leads Request : " + lead_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(lead_req);

        Response resp = requestSpec.post(requests.base_URL_Login + lead_URL);
        System.out.println("Leads Response : " + resp.asString());

        Assert.assertNull(resp.jsonPath().get("result"));
        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertTrue(resp.jsonPath().get("message").toString().contains("An error occurred while saving the entity changes. See the inner exception for details."));
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("An error occurred while saving the entity changes. See the inner exception for details."));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "500");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
        Assert.assertNotNull(resp.jsonPath().get("correlationId"));
    }
    @Test
    public void leads_WithUnregistered_Source() {

        leads.setSource("Source");

        String lead_req = requests.Leads_Req(leads);
        System.out.println("Leads Request : " + lead_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(lead_req);

        Response resp = requestSpec.post(requests.base_URL_Login + lead_URL);
        System.out.println("Leads Response : " + resp.asString());

        Assert.assertNull(resp.jsonPath().get("result"));
        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertNotNull(resp.jsonPath().get("message"));
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Invalid source value"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
        Assert.assertNotNull(resp.jsonPath().get("correlationId"));
    }
    @Test
    public void leads_WithInvalidMobileCode_NotMatchedWithMobile() {

        leads.setMobileCode("+068");

        String lead_req = requests.Leads_Req(leads);
        System.out.println("Leads Request : " + lead_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(lead_req);

        Response resp = requestSpec.post(requests.base_URL_Login + lead_URL);
        System.out.println("Leads Response : " + resp.asString());

        Assert.assertNull(resp.jsonPath().get("result"));
        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertNotNull(resp.jsonPath().get("message"));
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("The specified condition was not met for 'Customer Id'."));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
        Assert.assertNotNull(resp.jsonPath().get("correlationId"));
    }
    @Test
    public void leads_WithInvalidMobile_NotMatchedWithMobileCode() {

        leads.setMobile("698712354");

        String lead_req = requests.Leads_Req(leads);
        System.out.println("Leads Request : " + lead_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(lead_req);

        Response resp = requestSpec.post(requests.base_URL_Login + lead_URL);
        System.out.println("Leads Response : " + resp.asString());

        Assert.assertNull(resp.jsonPath().get("result"));
        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertNotNull(resp.jsonPath().get("message"));
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("The specified condition was not met for 'Customer Id'."));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
        Assert.assertNotNull(resp.jsonPath().get("correlationId"));
    }
    @Test
    public void leads_WithoutTagId() {

        String lead_req = requests.Leads_Req(leads);
        System.out.println("Leads Request : " + lead_req);

        JSONObject obj = new JSONObject(lead_req);
        String leadRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"tagIds"});
        System.out.println("Leads Request after removing fields : " + leadRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(leadRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + lead_URL);
        System.out.println("Leads Response : " + resp.asString());

        Assert.assertNull(resp.jsonPath().get("result"));
        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertNotNull(resp.jsonPath().get("message"));
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("The specified condition was not met for 'Customer Id'."));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
        Assert.assertNotNull(resp.jsonPath().get("correlationId"));
    }
}
