package Utils;

import DTO.Account_Register;
import DTO.Identity_Login;

import DTO.Sales.Appointments;
import DTO.Sales.Calls;
import DTO.Sales.Leads;
import org.json.JSONArray;
import org.json.JSONObject;

public class Requests {

    public String base_URL_Login = "https://api.ligare.app/api";

    public String identity_Login(Identity_Login login){

        JSONObject mainJson = new JSONObject();

        mainJson.put("email",login.email);
        mainJson.put("password",login.password);

        return mainJson.toString();

    }

    public String account_Register(Account_Register register){

        JSONObject mainJson = new JSONObject();

        mainJson.put("userName",register.username);
        mainJson.put("emailAddress",register.emailAddress);
        mainJson.put("password",register.password);
        mainJson.put("appName",register.appName);
        mainJson.put("surname",register.surname);

        return mainJson.toString();

    }

    public String Leads_Req(Leads leads){

        JSONObject mainJson = new JSONObject();
        JSONObject basicInfo = new JSONObject();
        JSONObject tagJson = new JSONObject();
        JSONArray tagId = new JSONArray();

        basicInfo.put("firstName",leads.getFirstName());
        basicInfo.put("lastName",leads.getLastName());
        basicInfo.put("mobileCode",leads.getMobileCode());
        basicInfo.put("mobile",leads.getMobile());
        basicInfo.put("email",leads.getEmail());
        basicInfo.put("tagIds",tagId);

        tagId.put(5);

        mainJson.put("basicInfo",basicInfo);
        mainJson.put("source",leads.getSource());
        mainJson.put("notes",leads.getNotes());
        mainJson.put("assignedSalesId",leads.getAssignedSalesId());
        mainJson.put("customerId",leads.getCustomerId());
        mainJson.put("nextSteps",leads.getNextSteps());

        return mainJson.toString();

    }

    public String Requests_Req(DTO.Sales.Requests requests){

        JSONObject mainJson = new JSONObject();

        mainJson.put("customerId",requests.getCustomerId());
        mainJson.put("itemId",requests.getItemId());
        mainJson.put("assignedUserId",requests.getAssignedUserId());
        mainJson.put("notes",requests.getNotes());
        mainJson.put("comments",requests.getComments());
        mainJson.put("followUpDate",requests.getFollowUpDate());

        return mainJson.toString();

    }

    public String Calls_Req(Calls calls){

        JSONObject mainJson = new JSONObject();

        mainJson.put("assignedUserId",calls.getAssignedUserId());
        mainJson.put("assigningReason",calls.getAssigningReason());
        mainJson.put("time",calls.getTime());
        mainJson.put("reason",calls.getReason());
        mainJson.put("notes",calls.getNotes());
        mainJson.put("summary",calls.getSummary());
        mainJson.put("status",calls.getStatus());
        mainJson.put("leadId",calls.getLeadId());
        mainJson.put("requestId",calls.getRequestId());
        mainJson.put("appointmentId",calls.getAppointmentId());
        mainJson.put("itemId",calls.getItemId());

        return mainJson.toString();

    }

    public String Appointmnts_Req(Appointments appointments){

        JSONObject mainJson = new JSONObject();

        mainJson.put("itemId",appointments.getItemId());
        mainJson.put("customerId",appointments.getCustomerId());
        mainJson.put("assignedToUserId",appointments.getAssignedToUserId());
        mainJson.put("selectedTime",appointments.getSelectedTime());
        mainJson.put("followUpDate",appointments.getFollowUpDate());
        mainJson.put("selectedSlot",appointments.getSelectedSlot());
        mainJson.put("location",appointments.getLocation());
        mainJson.put("meetingReason",appointments.getMeetingReason());
        mainJson.put("status",appointments.getStatus());

        return mainJson.toString();

    }
}
