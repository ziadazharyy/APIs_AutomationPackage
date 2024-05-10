package TestCases.Sales;

import DTO.Sales.Appointments;
import DTO.Sales.Calls;
import DTO.Sales.Leads;
import Utils.Methods;
import Utils.Requests;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;

import static com.jayway.restassured.RestAssured.given;

public class Calls_Testcases {

    Calls calls = new Calls();
    Requests requests = new Requests();
    Methods methods = new Methods();

    Requests_TestCases requestsOriginal = new Requests_TestCases();
    Leads_TestCases leads = new Leads_TestCases();
    Appointments_TestCases appointments = new Appointments_TestCases();

    String assignedUserId;
    String assigningReason;
    String time;
    String reason;
    String notes;
    String summary;
    String status;
    String leadId;
    String requestId;
    String appointmentId;
    String itemId;
    String calls_URL;

    @BeforeMethod
    public void BeforeMethod() {

        assignedUserId = "3a110db2-03d1-6d31-b1b7-e01fee3780ca";
        assigningReason = "assigned reason";
        time = methods.getDateTime();
        reason = "reason";
        notes = "notes to be added";
        summary = "summary to be written";
        status = "Status";
        leadId = "38";
        requestId = "7";
        appointmentId = "3";
        itemId = "18";

        calls.setAppointmentId(appointmentId);
        calls.setAssignedUserId(assignedUserId);
        calls.setAssigningReason(assigningReason);
        calls.setTime(time);
        calls.setReason(reason);
        calls.setNotes(notes);
        calls.setStatus(status);
        calls.setSummary(summary);
        calls.setLeadId(leadId);
        calls.setRequestId(requestId);
        calls.setItemId(itemId);

        calls_URL = "/app/calls";
    }

    @Test
    public void calls_FullCycle() {

        String leadId = leads.Leads();
        String requestId = requestsOriginal.Requests();
        String appointmentId = appointments.Appointments();

//        calls.setAppointmentId(appointmentId);
        calls.setAppointmentId("1");
        calls.setRequestId(requestId);
        calls.setLeadId(leadId);

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(calls_req);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_HappyScenario() {

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(calls_req);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_InvalidAssignedUserId() {

        calls.setAssignedUserId(UUID.randomUUID().toString());

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(calls_req);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_InvalidLeadId() {

        calls.setLeadId("1");

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(calls_req);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_InvalidRequestId() {

        calls.setRequestId("1");

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(calls_req);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_InvalidAppointmentId() {

        calls.setAppointmentId("3");

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(calls_req);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_InvalidItemId() {

        calls.setItemId("2");

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(calls_req);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_InvalidTime_PreviousTime() {

        calls.setTime("2023-05-02 20:29:22");

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(calls_req);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_Without_AssignedUserId() {

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        JSONObject obj = new JSONObject(calls_req);
        String callsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"assignedUserId"});
        System.out.println("Leads Request after removing fields : " + callsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(callsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_Without_AssignedReason() {

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        JSONObject obj = new JSONObject(calls_req);
        String callsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"assignedReason"});
        System.out.println("Leads Request after removing fields : " + callsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(callsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_Without_Time() {

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        JSONObject obj = new JSONObject(calls_req);
        String callsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"time"});
        System.out.println("Leads Request after removing fields : " + callsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(callsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_Without_Reason() {

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        JSONObject obj = new JSONObject(calls_req);
        String callsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"reason"});
        System.out.println("Leads Request after removing fields : " + callsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(callsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_Without_Notes() {

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        JSONObject obj = new JSONObject(calls_req);
        String callsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"notes"});
        System.out.println("Leads Request after removing fields : " + callsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(callsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_Without_Summary() {

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        JSONObject obj = new JSONObject(calls_req);
        String callsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"summary"});
        System.out.println("Leads Request after removing fields : " + callsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(callsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_Without_Status() {

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        JSONObject obj = new JSONObject(calls_req);
        String callsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"status"});
        System.out.println("Leads Request after removing fields : " + callsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(callsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_Without_LeadId() {

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        JSONObject obj = new JSONObject(calls_req);
        String callsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"leadId"});
        System.out.println("Leads Request after removing fields : " + callsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(callsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_Without_RequestId() {

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        JSONObject obj = new JSONObject(calls_req);
        String callsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"requestId"});
        System.out.println("Leads Request after removing fields : " + callsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(callsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_Without_AppointmentId() {

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        JSONObject obj = new JSONObject(calls_req);
        String callsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"appointmentId"});
        System.out.println("Leads Request after removing fields : " + callsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(callsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
    @Test
    public void calls_Without_ItemId() {

        String calls_req = requests.Calls_Req(calls);
        System.out.println("Calls Request : " + calls_req);

        JSONObject obj = new JSONObject(calls_req);
        String callsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"itemId"});
        System.out.println("Leads Request after removing fields : " + callsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(callsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + calls_URL);
        System.out.println("Calls Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");
    }
}
