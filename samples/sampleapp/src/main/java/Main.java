import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.crm.api.Initializer;

import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.UserSignature;
import com.zoho.crm.api.dc.DataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.record.APIException;
import com.zoho.crm.api.record.RecordOperations;
import com.zoho.crm.api.record.ResponseHandler;
import com.zoho.crm.api.record.ResponseWrapper;

import com.zoho.crm.api.util.APIResponse;

public class Main
{
	/**
	 * Function to establish integration between Zylker and Zoho CRM.
	 * Enough to call this once for a new integration
	 * 
	 * @param location String - Obtained from the redirect_uri of the authorization request
	 * @param grant_token String - Obtained from the redirect_uri of the authorization request
	 * @param user_email String - Obtained from the current login user details of Zylker
	 * **/
	public static Boolean integrateZohoCRM(String location, String grant_token, String user_email) 
	{
		Boolean integrationStatus = Boolean.FALSE;     
    	
		try {
			Environment environment = DataCenter.get(location);
	    	OAuthToken userToken = new OAuthToken.Builder()
	    	                .clientID(OAuthClientDetails.CLIENT_ID)
	    	                .clientSecret(OAuthClientDetails.CLIENT_SECRET)
	    	                .grantToken(grant_token)
	    	                .redirectURL(OAuthClientDetails.REDIRECT_URL)
	    			        .userSignature(new UserSignature(user_email)) //email of the user who is trying to integrate with Zoho CRM
	    	                .build();
	    	new Initializer.Builder().environment(environment).token(userToken).initialize(); 
	    	integrationStatus = Boolean.TRUE;
	    	
		} catch (SDKException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return integrationStatus;
	}
	
	/***
	 * Fetch CRM Data wrt to the input email
	 * @param email String
	 * **/
	public static void fetchCRMData(String email) throws Exception {
		
		/**
		 * Following code sets the context of SDK to fire API calls with respect to the input email. 
		 * It's enough to call this once in a single thread and not necessary to call this before
		 * every CRM data fetch.
		 * **/
		OAuthToken userToken1 = new OAuthToken.Builder()
			        .userSignature(new UserSignature(email)) 
			        .build();
		new Initializer.Builder().token(userToken1).initialize();
		
		/**
		 * Sample SDK code to fetch "Company,Email" field of the Leads module. 
		 * The records which is accessible to **email** will be fetched. 
		 * **/

        RecordOperations ro = new RecordOperations();
        ParameterMap paramInstance = new ParameterMap();
        List<String> fieldNames = new ArrayList<>(Arrays.asList("Company", "Email"));
        paramInstance.add(RecordOperations.GetRecordsParam.FIELDS, String.join(",", fieldNames));
        @SuppressWarnings("rawtypes")
        APIResponse response = ro.getRecords("Leads", paramInstance, null);
        if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ResponseHandler responseHandler = (ResponseHandler) response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<com.zoho.crm.api.record.Record> records = responseWrapper.getData();
					for (com.zoho.crm.api.record.Record record : records)
					{
						System.out.println("Record ID: " + record.getId());
						for (Map.Entry<String, Object> entry : record.getKeyValues().entrySet())
						{
							String keyName = entry.getKey();
							Object value = entry.getValue();
							if (value instanceof List)
							{
								System.out.println("Record KeyName : " + keyName);
								List<?> dataList = (List<?>) value;
								for (Object data : dataList)
								{
									if (data instanceof Map)
									{
										System.out.println("Record KeyName : " + keyName + " - Value : ");
										for (Map.Entry<String, Object> mapValue : ((HashMap<String, Object>) data).entrySet())
										{
											System.out.println(mapValue.getKey() + " : " + mapValue.getValue());
										}
									}
									else
									{
										System.out.println(data);
									}
								}
							}
							else if (value instanceof Map)
							{
								System.out.println("Record KeyName : " + keyName + " - Value : ");
								for (Map.Entry<String, Object> mapValue : ((HashMap<String, Object>) value).entrySet())
								{
									System.out.println(mapValue.getKey() + " : " + mapValue.getValue());
								}
							}
							else
							{
								System.out.println("Record KeyName : " + keyName + " - Value : " + value);
							}
						}
					}
				}
				else if (responseHandler instanceof APIException)
				{
					APIException exception = (APIException) responseHandler;
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
	
    public static void main(String[] args) throws Exception
    {
    	String email = "patricia@gmail.com"; //auto set by the redirect-uri code logic w.r.t to logged in user of Zylker (using cookies)
      
    	/**
    	 * 
    	 * It's enough to call this integrateZohoCRM code once during the integration setup. 
    	 * After that, calling the fetchCRMData function with the email is enough to do any operation in Zoho CRM with respect to the email
    	 * 
    	 * 3 parameters to the function integrateZohoCRM are obtained based on the context of the redirect-uri
    	 * **/
    	String location = "us"; //auto set by request.getParameter("location")
    	String grant_token = "1000.xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"; //auto set by request.getParameter("code")
    	Boolean integrationStatus = integrateZohoCRM(location, grant_token, email);
    	
    	if(integrationStatus.booleanValue() == true) {
    		fetchCRMData(email);
    	}
    }
}