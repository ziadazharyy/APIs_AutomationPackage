package Utils;

import DTO.Identity_Login;

import org.json.JSONObject;

public class Requests {

    public String base_URL_Login = "https://api.ligare.app/api/app/identity/login";

    public String identity_Login(Identity_Login login){

        JSONObject mainJson = new JSONObject();

        mainJson.put("email",login.email);
        mainJson.put("password",login.password);

        return mainJson.toString();

    }
}
