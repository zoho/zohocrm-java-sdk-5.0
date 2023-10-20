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

import com.zoho.crm.api.record.APIException;
import com.zoho.crm.api.record.Info;
import com.zoho.crm.api.record.RecordOperations;
import com.zoho.crm.api.record.ResponseHandler;
import com.zoho.crm.api.record.ResponseWrapper;

import com.zoho.crm.api.util.APIResponse;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		Environment environment = DataCenter.get("us"); // or Environment environment = USDataCenter.PRODUCTION;
		OAuthToken userToken = new OAuthToken.Builder()
				.clientID(OAuthClientDetails.CLIENT_ID)
				.clientSecret(OAuthClientDetails.CLIENT_SECRET)
				.grantToken("1000.xxx.xxxx")
				.redirectURL(OAuthClientDetails.REDIRECT_URL)
				.userSignature(new UserSignature("patricia@gmail.com")) // email of the user who is trying to integrate with Zoho CRM
				.build();
		new Initializer.Builder()
		.environment(environment)
		.token(userToken)
		.initialize();

		OAuthToken userToken1 = new OAuthToken.Builder()
				.userSignature(new UserSignature("patricia@gmail.com")) // email of the user who is trying to integrate with Zoho CRM
				.build();
		new Initializer.Builder()
		.token(userToken1)
		.initialize();

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
						com.zoho.crm.api.users.MinifiedUser createdBy = record.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("Record Created By User-ID: " + createdBy.getId());
							System.out.println("Record Created By User-Name: " + createdBy.getName());
							System.out.println("Record Created By User-Email: " + createdBy.getEmail());
						}
						System.out.println("Record CreatedTime: " + record.getCreatedTime());
						com.zoho.crm.api.users.MinifiedUser modifiedBy = record.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("Record Modified By User-ID: " + modifiedBy.getId());
							System.out.println("Record Modified By User-Name: " + modifiedBy.getName());
							System.out.println("Record Modified By User-Email: " + modifiedBy.getEmail());
						}
						System.out.println("Record ModifiedTime: " + record.getModifiedTime());
						// To get particular field value
						System.out.println("Record Field Value: " + record.getKeyValue("Last_Name"));// FieldApiName
						System.out.println("Record KeyValues: ");
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
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getCount() != null)
						{
							System.out.println("Record Info Count: " + info.getCount().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Record Info MoreRecords: " + info.getMoreRecords().toString());
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
}
