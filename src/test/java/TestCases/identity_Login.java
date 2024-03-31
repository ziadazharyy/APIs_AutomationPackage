package TestCases;

import DTO.Identity_Login;
import Utils.Methods;
import Utils.Requests;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static com.jayway.restassured.RestAssured.given;


public class identity_Login {

    Identity_Login login = new Identity_Login();
    public String email = "admin@connectedapp.com";
    public String password = "Admin123#";
    Requests request = new Requests();

    Methods methods = new Methods();

    @BeforeMethod
    public void BeforeMethod(){

        login.setEmail(email);
        login.setPassword(password);
    }

    @Test
    public void login_HappyScenario(){

        String req = request.identity_Login(login);
        System.out.println("Request : " + req);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(req);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertTrue(resp.jsonPath().get("isSuccess"));
        Assert.assertNull(resp.jsonPath().get("message"));
//        Assert.assertEquals(resp.jsonPath().get("errors"),);
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "200");
        Assert.assertNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));


    }

    @Test
    public void login_InvalidEmail(){

        login.email="ziad@yaho.eg";

        String req = request.identity_Login(login);
        System.out.println("Request : " + req);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(req);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Incorrect Password or Email");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Incorrect Password or Email"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));

    }

    @Test
    public void login_InvalidPassword(){

        login.password = "admin12345";

        String req = request.identity_Login(login);
        System.out.println("Request : " + req);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(req);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Incorrect Password or Email");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Incorrect Password or Email"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));

    }

    @Test
    public void login_withoutEmail(){

        String originalRequest = request.identity_Login(login);
        System.out.println("Original Request : " + originalRequest);

        JSONObject obj = new JSONObject(originalRequest);
        String requestAfterRemove=  methods.removeMultipleJsonElements(obj, new String[]{"email"} );
        System.out.println("Request after removing fields : " + requestAfterRemove);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(requestAfterRemove);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Email is a required field, must be provided");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Email is a required field, must be provided"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));

    }

    @Test
    public void login_withoutPassword(){

        String originalRequest = request.identity_Login(login);
        System.out.println("Original Request : " + originalRequest);

        JSONObject obj = new JSONObject(originalRequest);
        String requestAfterRemove=  methods.removeMultipleJsonElements(obj, new String[]{"password"} );
        System.out.println("Request after removing fields : " + requestAfterRemove);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(requestAfterRemove);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Password is a required field, must be provided");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Password is a required field, must be provided"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));

    }

    @Test
    public void login_withoutEmailAndPassword(){

        String originalRequest = request.identity_Login(login);
        System.out.println("Original Request : " + originalRequest);

        JSONObject obj = new JSONObject(originalRequest);
        String requestAfterRemove=  methods.removeMultipleJsonElements(obj, new String[]{"email","password"} );
        System.out.println("Request after removing fields : " + requestAfterRemove);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(requestAfterRemove);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Email and Password are required fields, must be provided");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Email and Password are required fields, must be provided"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));

    }

    @Test
    public void login_InvalidEmailStructure(){

        login.email="ziad";

        String req = request.identity_Login(login);
        System.out.println("Request : " + req);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(req);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Invalid Email Structure");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Invalid Email Structure"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));

    }

    @Test
    public void login_InvalidPasswordStructure(){

        login.password="16";

        String req = request.identity_Login(login);
        System.out.println("Request : " + req);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(req);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Incorrect Password or Email");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Incorrect Password or Email"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));

    }
    
    @Test
    public void login_EmptyEmail(){

        login.email="";

        String req = request.identity_Login(login);
        System.out.println("Request : " + req);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(req);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Email cannot be null or empty");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Email cannot be null or empty"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));

    }

    @Test
    public void login_EmptyPassword(){

        login.password="";

        String req = request.identity_Login(login);
        System.out.println("Request : " + req);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(req);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Password cannot be null or empty");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Password cannot be null or empty"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));

    }

    @Test
    public void login_EmptyEmailAndPassword(){

        login.email="";
        login.password="";

        String req = request.identity_Login(login);
        System.out.println("Request : " + req);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(req);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Email and Password cannot be null or empty");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Email and Password cannot be null or empty"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));

    }

    @Test
    public void login_NullableEmail(){

        login.email=null;

        String req = request.identity_Login(login);
        System.out.println("Request : " + req);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(req);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Email cannot be null or empty");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Email cannot be null or empty"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));

    }

    @Test
    public void login_NullablePassword(){

        login.password=null;

        String req = request.identity_Login(login);
        System.out.println("Request : " + req);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(req);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Password cannot be null or empty");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Password cannot be null or empty"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));

    }

    @Test
    public void login_NullableEmailAndPassword(){

        login.email=null;
        login.password=null;

        String req = request.identity_Login(login);
        System.out.println("Request : " + req);

        RequestSpecification requestSpec= given().relaxedHTTPSValidation();
        requestSpec.header("Content-Type","application/json");
        requestSpec.body(req);

        Response resp = requestSpec.post(request.base_URL_Login);
        System.out.println("Response : " + resp.asString());

        Assert.assertFalse(resp.jsonPath().get("isSuccess"));
        Assert.assertEquals(resp.jsonPath().get("message"),"Email and Password cannot be null or empty");
        Assert.assertTrue(resp.jsonPath().get("errors").toString().contains("Email and Password cannot be null or empty"));
        Assert.assertTrue(resp.jsonPath().get("timestamp").toString().contains(methods.getDate()));
        Assert.assertEquals(resp.jsonPath().get("statusCode").toString(), "400");
        Assert.assertNotNull(resp.jsonPath().get("stackTrace"));
        Assert.assertNull(resp.jsonPath().get("innerResult"));
        Assert.assertNull(resp.jsonPath().get("correlationId"));


    }

}
