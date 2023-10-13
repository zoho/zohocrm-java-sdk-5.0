package samples.territories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.territories.APIException;
import com.zoho.crm.api.territories.ActionHandler;
import com.zoho.crm.api.territories.ActionResponse;
import com.zoho.crm.api.territories.ActionWrapper;
import com.zoho.crm.api.territories.SuccessResponse;
import com.zoho.crm.api.territories.TerritoriesOperations;
import com.zoho.crm.api.territories.TransferBodyWrapper;
import com.zoho.crm.api.territories.TransferTerritory;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class TransferAndDeleteTerritories
{
	public static void transferAndDeleteTerritories() throws Exception
	{
		TerritoriesOperations territoriesOperations = new TerritoriesOperations();
		TransferBodyWrapper request = new TransferBodyWrapper();
		List<TransferTerritory> territories = new ArrayList<>();
		TransferTerritory territory = new TransferTerritory();
		territory.setId(323243123123l);
		territory.setTransferToId(32322131232l);
		territory.setDeletePreviousForecasts(false);
		territories.add(territory);
		request.setTerritories(territories);
		APIResponse<ActionHandler> response = territoriesOperations.transferAndDeleteTerritories(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getTerritories();
					if (actionResponses != null)
					{
						for (ActionResponse actionResponse : actionResponses)
						{
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
								System.out.println("Message: " + successResponse.getMessage());
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
				for (java.lang.reflect.Field field2 : fields)
				{
					System.out.println(field2.getName() + ":" + field2.get(responseObject));
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
			transferAndDeleteTerritories();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}