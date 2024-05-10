package TestCases;

import DTO.Account_Register;
import Utils.Methods;
import Utils.Requests;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class account_Register {

    Account_Register register = new Account_Register();
    Requests requests = new Requests();
    Methods methods = new Methods();
    public String registerURL = "/account/register";
    public String username = "ziadTestAdmin"+methods.random() + methods.random();
    public String emailAddress = "ziadTestAdmin" + methods.random() + methods.random() + "@email.com";
    public String password = "Admin@123";
    public String appName = "ConnectedApp";
    public String surname = "ziad";

    @BeforeMethod
    public void BeforeMethod() {
        register.setUsername(username);
        register.setEmailAddress(emailAddress);
        register.setPassword(password);
        register.setAppName(appName);
        register.setSurname(surname);
    }

    public Account_Register register() {

        BeforeMethod();

        String [] credentials = new String[2];

        String request = requests.account_Register(register);
        System.out.println("Register Request : " + request);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(request);

        Response resp = requestSpec.post(requests.base_URL_Login + registerURL);
        System.out.println("Register Response : " + resp.asString());

//        Assert.assertEquals(resp.jsonPath().get("tenantId"), "");
//        Assert.assertEquals(resp.jsonPath().get("username"), register.getUsername());
//        Assert.assertEquals(resp.jsonPath().get("name"), "");
//        Assert.assertEquals(resp.jsonPath().get("surname"), "");
//        Assert.assertEquals(resp.jsonPath().get("email"), register.getEmailAddress());
//        Assert.assertTrue(resp.jsonPath().get("emailConfirmed"));
//        Assert.assertEquals(resp.jsonPath().get("phoneNumber"), "");
//        Assert.assertTrue(resp.jsonPath().get("phoneNumberConfirmed"));
//        Assert.assertTrue(resp.jsonPath().get("isActive"));
//        Assert.assertTrue(resp.jsonPath().get("lockoutEnabled"));
//        Assert.assertEquals(resp.jsonPath().get("accessFailedCount"), "0");
//        Assert.assertEquals(resp.jsonPath().get("lockoutEnd"), "");
//        Assert.assertEquals(resp.jsonPath().get("concurrencyStamp"), "7a8dd4fc8d5840029ea5ca9852002849");
//        Assert.assertEquals(resp.jsonPath().get("entityVersion"), "2");
//        Assert.assertTrue(resp.jsonPath().get("lastPasswordChangeTime").toString().contains(methods.getDate()));
//        Assert.assertFalse(resp.jsonPath().get("isDeleted"));
//        Assert.assertEquals(resp.jsonPath().get("deleterId"), "");
//        Assert.assertEquals(resp.jsonPath().get("deletionTime"), "");
//        Assert.assertTrue(resp.jsonPath().get("lastModificationTime").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("lastModifierId"), "");
//        Assert.assertTrue(resp.jsonPath().get("creationTime").toString().contains(methods.getDate()));
//        Assert.assertEquals(resp.jsonPath().get("creatorId"), "");
//        Assert.assertEquals(resp.jsonPath().get("id"), "");
//        Assert.assertEquals(resp.jsonPath().get("extraProperties"), "");
        // return values for login credentials


        return register;
    }
    @Test
    public void register_HappyScenario() {

        String request = requests.account_Register(register);
        System.out.println("Request : " + request);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(request);

        Response resp = requestSpec.post(requests.base_URL_Login + registerURL);
        System.out.println("Response : " + resp.asString());

        Assert.assertEquals(resp.jsonPath().get("tenantId"), "");
        Assert.assertEquals(resp.jsonPath().get("username"), register.getUsername());
        Assert.assertEquals(resp.jsonPath().get("name"), "");
        Assert.assertEquals(resp.jsonPath().get("surname"), "");
        Assert.assertEquals(resp.jsonPath().get("email"), register.getEmailAddress());
        Assert.assertTrue(resp.jsonPath().get("emailConfirmed"));
        Assert.assertEquals(resp.jsonPath().get("phoneNumber"), "");
        Assert.assertTrue(resp.jsonPath().get("phoneNumberConfirmed"));
        Assert.assertTrue(resp.jsonPath().get("isActive"));
        Assert.assertTrue(resp.jsonPath().get("lockoutEnabled"));
        Assert.assertEquals(resp.jsonPath().get("accessFailedCount"), "0");
        Assert.assertEquals(resp.jsonPath().get("lockoutEnd"), "");
        Assert.assertEquals(resp.jsonPath().get("concurrencyStamp"), "7a8dd4fc8d5840029ea5ca9852002849");
        Assert.assertEquals(resp.jsonPath().get("entityVersion"), "2");
        Assert.assertTrue(resp.jsonPath().get("lastPasswordChangeTime").toString().contains(methods.getDate()));
        Assert.assertFalse(resp.jsonPath().get("isDeleted"));
        Assert.assertEquals(resp.jsonPath().get("deleterId"), "");
        Assert.assertEquals(resp.jsonPath().get("deletionTime"), "");
        Assert.assertTrue(resp.jsonPath().get("lastModificationTime").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("lastModifierId"), "");
        Assert.assertTrue(resp.jsonPath().get("creationTime").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("creatorId"), "");
        Assert.assertEquals(resp.jsonPath().get("id"), "");
        Assert.assertEquals(resp.jsonPath().get("extraProperties"), "");

    }

    @Test
    public void register_DuplicateUserNameAndEmail() {

        register.setUsername("ziadTestAdmin");
        register.setEmailAddress("ziadTestAdmin@email.com");

        String request = requests.account_Register(register);
        System.out.println("Request : " + request);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(request);

        Response resp = requestSpec.post(requests.base_URL_Login + registerURL);
        System.out.println("Response : " + resp.asString());

        Assert.assertEquals(resp.jsonPath().get("error.code"), "12345");
        Assert.assertEquals(resp.jsonPath().get("error.message"), "Username '" + register.getUsername() + "' is already taken., Email '" + register.getEmailAddress() + "' is already taken.");
        Assert.assertEquals(resp.jsonPath().get("error.details"), "");
        Assert.assertEquals(resp.jsonPath().get("error.data.0"), register.getUsername());
        Assert.assertEquals(resp.jsonPath().get("error.validationErrors"), "");
    }

    @Test
    public void register_DuplicateUserName() {

        register.setUsername("ziadTestAdmin");

        String request = requests.account_Register(register);
        System.out.println("Request : " + request);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(request);

        Response resp = requestSpec.post(requests.base_URL_Login + registerURL);
        System.out.println("Response : " + resp.asString());

        Assert.assertEquals(resp.jsonPath().get("error.code"), "12345");
        Assert.assertEquals(resp.jsonPath().get("error.message"), "Username '" + register.getUsername() + "' is already taken.");
        Assert.assertEquals(resp.jsonPath().get("error.details"), "");
        Assert.assertEquals(resp.jsonPath().get("error.data.0"), register.getUsername());
        Assert.assertEquals(resp.jsonPath().get("error.validationErrors"), "");
    }

    @Test
    public void register_DuplicateEmail() {

        register.setEmailAddress("ziadTestAdmin@email.com");

        String request = requests.account_Register(register);
        System.out.println("Request : " + request);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(request);

        Response resp = requestSpec.post(requests.base_URL_Login + registerURL);
        System.out.println("Response : " + resp.asString());

        Assert.assertEquals(resp.jsonPath().get("error.code"), "12345");
        Assert.assertEquals(resp.jsonPath().get("error.message"), "Email 'ziadTestAdmin@email.com' is already taken.");
        Assert.assertEquals(resp.jsonPath().get("error.details"), "");
        Assert.assertEquals(resp.jsonPath().get("error.data.0"), "ziadTestAdmin@email.com");
        Assert.assertEquals(resp.jsonPath().get("error.validationErrors"), "");
    }

    @Test
    public void register_withoutUsername() {


        String request = requests.account_Register(register);
        System.out.println("Request : " + request);

        JSONObject obj = new JSONObject(request);
        String requestAfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"userName"});
        System.out.println("Request after removing fields : " + requestAfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(requestAfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + registerURL);
        System.out.println("Response : " + resp.asString());

        Assert.assertEquals(resp.jsonPath().get("error.code"), "12345");
        Assert.assertEquals(resp.jsonPath().get("error.message"), "Your request is not valid!");
        Assert.assertEquals(resp.jsonPath().get("error.details"), "The following errors were detected during validation. - The UserName field is required.");
        Assert.assertEquals(resp.jsonPath().get("error.data.0"), "");
        Assert.assertEquals(resp.jsonPath().get("error.validationErrors.message"), "The UserName field is required.");
        Assert.assertTrue(resp.jsonPath().get("error.validationErrors.members").toString().contains("userName"));
    }

    @Test
    public void register_withoutEmail() {


        String request = requests.account_Register(register);
        System.out.println("Request : " + request);

        JSONObject obj = new JSONObject(request);
        String requestAfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"emailAddress"});
        System.out.println("Request after removing fields : " + requestAfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(requestAfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + registerURL);
        System.out.println("Response : " + resp.asString());

        Assert.assertEquals(resp.jsonPath().get("error.code"), "12345");
        Assert.assertEquals(resp.jsonPath().get("error.message"), "Your request is not valid!");
        Assert.assertEquals(resp.jsonPath().get("error.details"), "The following errors were detected during validation. - The EmailAddress field is required.");
        Assert.assertEquals(resp.jsonPath().get("error.data.0"), "");
        Assert.assertEquals(resp.jsonPath().get("error.validationErrors.message"), "The EmailAddress field is required.");
        Assert.assertTrue(resp.jsonPath().get("error.validationErrors.members").toString().contains("emailAddress"));
    }

    @Test
    public void register_withoutPassword() {


        String request = requests.account_Register(register);
        System.out.println("Request : " + request);

        JSONObject obj = new JSONObject(request);
        String requestAfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"password"});
        System.out.println("Request after removing fields : " + requestAfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(requestAfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + registerURL);
        System.out.println("Response : " + resp.asString());

        Assert.assertEquals(resp.jsonPath().get("error.code"), "12345");
        Assert.assertEquals(resp.jsonPath().get("error.message"), "Your request is not valid!");
        Assert.assertEquals(resp.jsonPath().get("error.details"), "The following errors were detected during validation. - The Password field is required.");
        Assert.assertEquals(resp.jsonPath().get("error.data.0"), "");
        Assert.assertEquals(resp.jsonPath().get("error.validationErrors.message"), "The Password field is required.");
        Assert.assertTrue(resp.jsonPath().get("error.validationErrors.members").toString().contains("password"));
    }

    @Test
    public void register_withoutSurname() {


        String request = requests.account_Register(register);
        System.out.println("Request : " + request);

        JSONObject obj = new JSONObject(request);
        String requestAfterRemove = methods.removeMultipleJsonElements(obj, new String[]{"surname"});
        System.out.println("Request after removing fields : " + requestAfterRemove);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(requestAfterRemove);

        Response resp = requestSpec.post(requests.base_URL_Login + registerURL);
        System.out.println("Response : " + resp.asString());


        Assert.assertEquals(resp.jsonPath().get("tenantId"), "");
        Assert.assertEquals(resp.jsonPath().get("username"), register.getUsername());
        Assert.assertEquals(resp.jsonPath().get("name"), "");
        Assert.assertEquals(resp.jsonPath().get("surname"), "");
        Assert.assertEquals(resp.jsonPath().get("email"), register.getEmailAddress());
        Assert.assertTrue(resp.jsonPath().get("emailConfirmed"));
        Assert.assertEquals(resp.jsonPath().get("phoneNumber"), "");
        Assert.assertTrue(resp.jsonPath().get("phoneNumberConfirmed"));
        Assert.assertTrue(resp.jsonPath().get("isActive"));
        Assert.assertTrue(resp.jsonPath().get("lockoutEnabled"));
        Assert.assertEquals(resp.jsonPath().get("accessFailedCount"), "0");
        Assert.assertEquals(resp.jsonPath().get("lockoutEnd"), "");
        Assert.assertEquals(resp.jsonPath().get("concurrencyStamp"), "7a8dd4fc8d5840029ea5ca9852002849");
        Assert.assertEquals(resp.jsonPath().get("entityVersion"), "2");
        Assert.assertTrue(resp.jsonPath().get("lastPasswordChangeTime").toString().contains(methods.getDate()));
        Assert.assertFalse(resp.jsonPath().get("isDeleted"));
        Assert.assertEquals(resp.jsonPath().get("deleterId"), "");
        Assert.assertEquals(resp.jsonPath().get("deletionTime"), "");
        Assert.assertTrue(resp.jsonPath().get("lastModificationTime").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("lastModifierId"), "");
        Assert.assertTrue(resp.jsonPath().get("creationTime").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("creatorId"), "");
        Assert.assertEquals(resp.jsonPath().get("id"), "");
        Assert.assertEquals(resp.jsonPath().get("extraProperties"), "");
    }

    @Test
    public void register_invalidEmailFormat() {

        register.setEmailAddress("adminEmail");

        String request = requests.account_Register(register);
        System.out.println("Request : " + request);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(request);

        Response resp = requestSpec.post(requests.base_URL_Login + registerURL);
        System.out.println("Response : " + resp.asString());

        Assert.assertEquals(resp.jsonPath().get("error.code"), "12345");
        Assert.assertEquals(resp.jsonPath().get("error.message"), "Your request is not valid!");
        Assert.assertEquals(resp.jsonPath().get("error.details"), "The following errors were detected during validation. - The EmailAddress field is not a valid e-mail address.");
        Assert.assertEquals(resp.jsonPath().get("error.data"), "");
        Assert.assertEquals(resp.jsonPath().get("error.validationErrors.message"), "The EmailAddress field is not a valid e-mail address.");
        Assert.assertEquals(resp.jsonPath().get("error.validationErrors.members"), "emailAddress");
    }
    @Test
    public void register_invalidPasswordFormat() {

        register.setPassword("ziad12");

        String request = requests.account_Register(register);
        System.out.println("Request : " + request);

        RequestSpecification requestSpec = given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(request);

        Response resp = requestSpec.post(requests.base_URL_Login + registerURL);
        System.out.println("Response : " + resp.asString());

        Assert.assertEquals(resp.jsonPath().get("error.code"), "12345");
        Assert.assertEquals(resp.jsonPath().get("error.message"), "Passwords must have at least one non alphanumeric character., Passwords must have at least one uppercase ('A'-'Z').");
        Assert.assertEquals(resp.jsonPath().get("error.details"), "");
        Assert.assertEquals(resp.jsonPath().get("error.data"), "");
        Assert.assertEquals(resp.jsonPath().get("error.validationErrors.message"), "");
        Assert.assertEquals(resp.jsonPath().get("error.validationErrors.members"), "");
    }

}
