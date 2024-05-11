package TestCases.Sales;

import DTO.Sales.Appointments;
import Utils.Methods;
import Utils.Requests;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;

import static com.jayway.restassured.RestAssured.given;

public class Appointments_TestCases {

    Appointments appointments = new Appointments();
    Requests requests = new Requests();
    Methods methods = new Methods();

    String itemId;
    String customerId;
    String assignedToUserId;
    String selectedTime;
    String followUpDate;
    String selectedSlot;
    String location;
    String meetingReason;
    String status;
    String appointments_URL;


    @BeforeMethod
    public void BeforeMethod() {

        itemId = "17";
        customerId = "3a110db8-77b0-62b6-4172-4602ea5f88a0";
        assignedToUserId= "3a110d01-4c93-7317-4131-cf433f738e42";
        selectedTime = methods.getDateTime();
        followUpDate = methods.getDateTime();
        selectedSlot = "04:30 PM - 05:00 PM";
        location = "office";
        meetingReason = "urgent !!!";
        status = "Pending";

        appointments_URL = "/app/appointments";

        appointments.setCustomerId(customerId);
        appointments.setAssignedToUserId(assignedToUserId);
        appointments.setSelectedSlot(selectedSlot);
        appointments.setLocation(location);
        appointments.setSelectedTime(selectedTime);
        appointments.setFollowUpDate(followUpDate);
        appointments.setStatus(status);
        appointments.setMeetingReason(meetingReason);
        appointments.setItemId(itemId);


    }

    public String Appointments() {

        BeforeMethod();

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointments_req);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

//        Assert.assertNotNull(resp.jsonPath().get("result"));
//        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
//        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
//        Assert.assertNull(resp.jsonPath().get("stackTrace"));
//        Assert.assertEquals(resp.jsonPath().get("innerResult"), "");
//        Assert.assertEquals(resp.jsonPath().get("correlationId"), "");

        return resp.jsonPath().get("result");
    }
    @Test
    public void appointments_HappyScenario() {

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointments_req);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

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
    public void appointments_HappyScenario_Testtttttttttt() {

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointments_req);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

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
    public void appointments_InvalidItemId() {

        appointments.setItemId("988700");

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointments_req);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

    }
    @Test
    public void appointments_InvalidCustomerId() {

        appointments.setCustomerId(UUID.randomUUID().toString());

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointments_req);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

    }
    @Test
    public void appointments_InvalidAssignedToUserId() {

        appointments.setCustomerId(assignedToUserId);

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointments_req);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

    }
    @Test
    public void appointments_PreviousSelectedTime() {

        appointments.setSelectedTime("2023-05-02 20:29:22");

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointments_req);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

    }
    @Test
    public void appointments_PreviousFollowUpDate() {

        appointments.setFollowUpDate("2023-05-02 20:29:22");

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointments_req);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

    }
    @Test
    public void appointments_InvalidDateFormat_SelectedTime() {

        appointments.setSelectedTime("20!3-0s-@2 20:2o:22");

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointments_req);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

    }
    @Test
    public void appointments_WithoutItemId() {

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        JSONObject obj = new JSONObject(appointments_req);
        String appointmentsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"itemId"});
        System.out.println("Appointments Request after removing fields : " + appointmentsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointmentsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

    }
    @Test
    public void appointments_WithoutCustomerId() {

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        JSONObject obj = new JSONObject(appointments_req);
        String appointmentsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"customerId"});
        System.out.println("Appointments Request after removing fields : " + appointmentsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointmentsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

    }
    @Test
    public void appointments_WithoutAssignedToUserId() {

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        JSONObject obj = new JSONObject(appointments_req);
        String appointmentsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"assignedToUserId"});
        System.out.println("Appointments Request after removing fields : " + appointmentsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointmentsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

    }
    @Test
    public void appointments_WithoutSelectedTime() {

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        JSONObject obj = new JSONObject(appointments_req);
        String appointmentsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"selectedTime"});
        System.out.println("Appointments Request after removing fields : " + appointmentsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointmentsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

    }
    @Test
    public void appointments_WithoutSelectedSlot() {

        String appointments_req = requests.Appointmnts_Req(appointments);
        System.out.println("Appointments Request : " + appointments_req);

        JSONObject obj = new JSONObject(appointments_req);
        String appointmentsRequest_AfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"selectedSlot"});
        System.out.println("Appointments Request after removing fields : " + appointmentsRequest_AfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(appointmentsRequest_AfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + appointments_URL);
        System.out.println("Appointments Response : " + resp.asString());

    }
}
