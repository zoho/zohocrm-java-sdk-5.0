package samples.appointmentpreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.appointmentpreference.APIException;
import com.zoho.crm.api.appointmentpreference.ActionHandler;
import com.zoho.crm.api.appointmentpreference.ActionResponse;
import com.zoho.crm.api.appointmentpreference.ActionWrapper;
import com.zoho.crm.api.appointmentpreference.AppointmentPreference;
import com.zoho.crm.api.appointmentpreference.AppointmentPreferenceOperations;
import com.zoho.crm.api.appointmentpreference.BodyWrapper;
import com.zoho.crm.api.appointmentpreference.Field;
import com.zoho.crm.api.appointmentpreference.FieldMappings;
import com.zoho.crm.api.appointmentpreference.Layout;
import com.zoho.crm.api.appointmentpreference.SuccessResponse;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class UpdateAppointmentPreference
{
	public static void updateAppointmentPreference() throws Exception
	{
		AppointmentPreferenceOperations appointmentPreferenceOperations = new AppointmentPreferenceOperations();
		BodyWrapper request = new BodyWrapper();
		AppointmentPreference appointmentPreferences = new AppointmentPreference();
		appointmentPreferences.setAllowBookingOutsideBusinesshours(false);
		appointmentPreferences.setAllowBookingOutsideServiceAvailability(true);
		appointmentPreferences.setWhenAppointmentCompleted(new Choice<String>("create_deal"));
		appointmentPreferences.setWhenDurationExceeds(new Choice<String>("ask_appointment_provider_to_complete"));
		appointmentPreferences.setShowJobSheet(true);
		Map<String, Object> dealRecordConfiguration = new HashMap<>();
		Layout layout = new Layout();
		layout.setAPIName("Standard");
		layout.setId(44024800173l);
		dealRecordConfiguration.put("layout", layout);
		List<FieldMappings> mappings = new ArrayList<>();
		FieldMappings fieldMappings = new FieldMappings();
		fieldMappings.setType(new Choice<String>("static"));
		fieldMappings.setValue("Closed Won");
		Field field = new Field();
		field.setAPIName("Stage");
		field.setId(44024800807l);
		fieldMappings.setField(field);
		mappings.add(fieldMappings);
		
		FieldMappings fieldMappings1 = new FieldMappings();
		fieldMappings1.setType(new Choice<String>("merge_field"));
		fieldMappings1.setValue("Closed Won");
		Field field1 = new Field();
		field1.setAPIName("Deal_Name");
		field1.setId(440248000801l);
		fieldMappings1.setField(field1);
		mappings.add(fieldMappings1);
		
		FieldMappings fieldMappings2 = new FieldMappings();
		fieldMappings2.setType(new Choice<String>("static"));
		fieldMappings2.setValue("Closed Won");
		Field field2 = new Field();
		field2.setAPIName("Account_Name");
		field2.setId(440248000807l);
		fieldMappings2.setField(field2);
		mappings.add(fieldMappings2);
		
		FieldMappings fieldMappings3 = new FieldMappings();
		fieldMappings3.setType(new Choice<String>("static"));
		fieldMappings3.setValue("Closed Won");
		Field field3 = new Field();
		field3.setAPIName("Closing_Date");
		field3.setId(44024000803l);
		fieldMappings3.setField(field3);
		mappings.add(fieldMappings3);
		
		FieldMappings fieldMappings4 = new FieldMappings();
		fieldMappings4.setType(new Choice<String>("static"));
		fieldMappings4.setValue("Closed Won");
		Field field4 = new Field();
		field4.setAPIName("Pipeline");
		field4.setId(440240807l);
		fieldMappings4.setField(field4);
		mappings.add(fieldMappings4);
		
		dealRecordConfiguration.put("field_mappings", mappings);
		appointmentPreferences.setDealRecordConfiguration(dealRecordConfiguration);
		request.setAppointmentPreferences(appointmentPreferences);
		APIResponse<ActionHandler> response = appointmentPreferenceOperations.updateAppointmentPreference(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					ActionResponse actionResponse = actionWrapper.getAppointmentPreferences();
					if (actionResponse instanceof SuccessResponse)
					{
						SuccessResponse successResponse = (SuccessResponse) actionResponse;
						System.out.println("Status: " + successResponse.getStatus().getValue());
						System.out.println("Code: " + successResponse.getCode().getValue());
						System.out.println("Details: ");
						for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
						{
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
						System.out.println("Message: " + successResponse.getMessage().getValue());
					}
					else if (actionResponse instanceof APIException)
					{
						APIException exception = (APIException) actionResponse;
						System.out.println("Status: " + exception.getStatus().getValue());
						System.out.println("Code: " + exception.getCode().getValue());
						System.out.println("Details: ");
						for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
						{
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
						System.out.println("Message: " + exception.getMessage());
					}
				}
				else if (actionHandler instanceof APIException)
				{
					APIException exception = (APIException) actionHandler;
					System.out.println("Status: " + exception.getStatus().getValue());
					System.out.println("Code: " + exception.getCode().getValue());
					System.out.println("Details: ");
					for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
					{
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					System.out.println("Message: " + exception.getMessage());
				}
			}
			else
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();
				for (java.lang.reflect.Field field5 : fields)
				{
					System.out.println(field5.getName() + ":" + field5.get(responseObject));
				}
			}
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			updateAppointmentPreference();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
