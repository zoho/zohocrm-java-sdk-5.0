package samples.shifthours;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.shifthours.APIException;
import com.zoho.crm.api.shifthours.ActionHandler;
import com.zoho.crm.api.shifthours.ActionResponse;
import com.zoho.crm.api.shifthours.ActionWrapper;
import com.zoho.crm.api.shifthours.BodyWrapper;
import com.zoho.crm.api.shifthours.BreakCustomTiming;
import com.zoho.crm.api.shifthours.BreakHours;
import com.zoho.crm.api.shifthours.Holidays;
import com.zoho.crm.api.shifthours.ShiftHours;
import com.zoho.crm.api.shifthours.ShiftHoursOperations;
import com.zoho.crm.api.shifthours.SuccessResponse;
import com.zoho.crm.api.shifthours.Users;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class UpdateShiftHours
{
	public static void updateShiftHours() throws Exception
	{
		ShiftHoursOperations shifthoursoperations = new ShiftHoursOperations("440248020813");
		BodyWrapper request = new BodyWrapper();
		List<ShiftHours> shiftHours = new ArrayList<>();
		ShiftHours shifthours = new ShiftHours();
		shifthours.setId(4402481024794L);
		shifthours.setTimezone(TimeZone.getTimeZone("Asia/Kolkata"));
		shifthours.setName("shift hours holiday10");
		shifthours.setSameAsEveryday(true);
		List<Holidays> holidays = new ArrayList<>();
		Holidays holiday = new Holidays();
		holiday.setDate(LocalDate.of(2023, 05, 8));
		holiday.setId(23456L);
		holiday.setName("Holi10");
		holiday.setYear(2023);
		holidays.add(holiday);
		shifthours.setHolidays(holidays);
		List<BreakHours> breakHours = new ArrayList<>();
		BreakHours breakhour = new BreakHours();
		breakhour.setId(4402481024795L);
		List<String> breakDays = new ArrayList<>();
		breakDays.add("Monday");
		breakhour.setBreakDays(breakDays);
		breakhour.setSameAsEveryday(true);
		// when same_as_everday is True
		List<String> dailytimingforBreakHours = new ArrayList<>();
		dailytimingforBreakHours.add("12:00");
		dailytimingforBreakHours.add("12:15");
		breakhour.setDailyTiming(dailytimingforBreakHours);
		breakHours.add(breakhour);
		shifthours.setBreakHours(breakHours);
//		//when same_as_everyday is false
		List<BreakCustomTiming> customtimingsforBreakHours = new ArrayList<>();
		BreakCustomTiming customTimingforBreakHour = new BreakCustomTiming();
		List<String> breakTimings = new ArrayList<>();
		breakTimings.add("12:00");
		breakTimings.add("12:15");
		customTimingforBreakHour.setBreakTiming(breakTimings);
		customTimingforBreakHour.setDays("Monday");
		customtimingsforBreakHours.add(customTimingforBreakHour);
		breakhour.setCustomTiming(customtimingsforBreakHours);
		breakHours.add(breakhour);
		shifthours.setBreakHours(breakHours);
		//
		List<Users> users = new ArrayList<>();
		Users user = new Users();
		user.setId(440248254001L);
		user.setEffectiveFrom(LocalDate.of(2023, 10, 12));
		users.add(user);
		shifthours.setUsers(users);
		shiftHours.add(shifthours);
		request.setShiftHours(shiftHours);
		APIResponse<ActionHandler> response = shifthoursoperations.updateShiftHours(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getShiftHours();
					for (ActionResponse actionResponse : actionResponses)
					{
						if (actionResponse instanceof SuccessResponse)
						{
							SuccessResponse successresponse = (SuccessResponse) actionResponse;
							System.out.println("Status: " + successresponse.getStatus().getValue());
							System.out.println("Code: " + successresponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : successresponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + successresponse.getMessage());
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
				Field[] fields = clas.getDeclaredFields();
				for (Field field : fields)
				{
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			updateShiftHours();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
