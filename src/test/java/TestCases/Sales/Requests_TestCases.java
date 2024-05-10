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

public class Requests_TestCases {

    DTO.Sales.Requests requests = new DTO.Sales.Requests();
    Requests req = new Requests();
    Methods methods = new Methods();

    String customerId;
    String itemId;
    String assignedUserId;
    String notes;
    String comments;
    String followUpDate;
    String requests_URL;

    @BeforeMethod
    public void BeforeMethod() {

        itemId = "16";
        notes = "any notes";
        assignedUserId = "3a110db2-03d1-6d31-b1b7-e01fee3780ca";
        customerId = "3a110db8-77b0-62b6-4172-4602ea5f88a0";
        comments = "comment";
        followUpDate = methods.getDateTime();

        requests.setCustomerId(customerId);
        requests.setItemId(itemId);
        requests.setNotes(notes);
        requests.setComments(comments);
        requests.setAssignedUserId(assignedUserId);
        requests.setFollowUpDate(followUpDate);

        requests_URL = "/app/requests";
    }

    public String Requests() {

        BeforeMethod();

        String request_req = req.Requests_Req(requests);
        System.out.println("Request Request : " + request_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(request_req);

        Response resp = requestSpec.post(req.base_URL_Login + requests_URL);
        System.out.println("Request Response : " + resp.asString());

        return resp.jsonPath().get("result").toString();

    }

    @Test
    public void requests_HappyScenario() {

        String request_req = req.Requests_Req(requests);
        System.out.println("Request Request : " + request_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(request_req);

        Response resp = requestSpec.post(req.base_URL_Login + requests_URL);
        System.out.println("Request Response : " + resp.asString());

    }
    @Test
    public void requests_InvalidCustomerId() {

        requests.setCustomerId(UUID.randomUUID().toString());

        String request_req = req.Requests_Req(requests);
        System.out.println("Request Request : " + request_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(request_req);

        Response resp = requestSpec.post(req.base_URL_Login + requests_URL);
        System.out.println("Request Response : " + resp.asString());

    }
    @Test
    public void requests_InvalidAssignedUserId() {

        requests.setAssignedUserId(UUID.randomUUID().toString());

        String request_req = req.Requests_Req(requests);
        System.out.println("Request Request : " + request_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(request_req);

        Response resp = requestSpec.post(req.base_URL_Login + requests_URL);
        System.out.println("Request Response : " + resp.asString());

    }
    @Test
    public void requests_InvalidItemId() {

        requests.setItemId("5222");

        String request_req = req.Requests_Req(requests);
        System.out.println("Request Request : " + request_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(request_req);

        Response resp = requestSpec.post(req.base_URL_Login + requests_URL);
        System.out.println("Request Response : " + resp.asString());

    }
    @Test
    public void requests_withoutItemId() {

        String request_req = req.Requests_Req(requests);
        System.out.println("Request Request : " + request_req);

        JSONObject obj = new JSONObject(request_req);
        String Request_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"itemId"});
        System.out.println("Request Request after removing fields : " + Request_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(Request_AfterRemove);

        Response resp = requestSpec.post(req.base_URL_Login + requests_URL);
        System.out.println("Request Response : " + resp.asString());

    }
    @Test
    public void requests_withoutAssignedUserId() {

        String request_req = req.Requests_Req(requests);
        System.out.println("Request Request : " + request_req);

        JSONObject obj = new JSONObject(request_req);
        String Request_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"assignedUserId"});
        System.out.println("Request Request after removing fields : " + Request_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(Request_AfterRemove);

        Response resp = requestSpec.post(req.base_URL_Login + requests_URL);
        System.out.println("Request Response : " + resp.asString());

    }
    @Test
    public void requests_withoutCustomerId() {

        String request_req = req.Requests_Req(requests);
        System.out.println("Request Request : " + request_req);

        JSONObject obj = new JSONObject(request_req);
        String Request_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"customerId"});
        System.out.println("Request Request after removing fields : " + Request_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(Request_AfterRemove);

        Response resp = requestSpec.post(req.base_URL_Login + requests_URL);
        System.out.println("Request Response : " + resp.asString());

    }
    @Test
    public void requests_withoutNotes() {

        String request_req = req.Requests_Req(requests);
        System.out.println("Request Request : " + request_req);

        JSONObject obj = new JSONObject(request_req);
        String Request_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"notes"});
        System.out.println("Request Request after removing fields : " + Request_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(Request_AfterRemove);

        Response resp = requestSpec.post(req.base_URL_Login + requests_URL);
        System.out.println("Request Response : " + resp.asString());

    }
    @Test
    public void requests_withoutFollowUpDate() {

        String request_req = req.Requests_Req(requests);
        System.out.println("Request Request : " + request_req);

        JSONObject obj = new JSONObject(request_req);
        String Request_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"followUpDate"});
        System.out.println("Request Request after removing fields : " + Request_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(Request_AfterRemove);

        Response resp = requestSpec.post(req.base_URL_Login + requests_URL);
        System.out.println("Request Response : " + resp.asString());

    }
    @Test
    public void requests_PreviousFollowUpDate() {

        requests.setFollowUpDate("2023-05-02 20:29:22");

        String request_req = req.Requests_Req(requests);
        System.out.println("Request Request : " + request_req);

        JSONObject obj = new JSONObject(request_req);
        String Request_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{""});
        System.out.println("Request Request after removing fields : " + Request_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(Request_AfterRemove);

        Response resp = requestSpec.post(req.base_URL_Login + requests_URL);
        System.out.println("Request Response : " + resp.asString());

    }
}
