package samples.entityscores;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.entityscores.APIException;
import com.zoho.crm.api.entityscores.EntityScores;
import com.zoho.crm.api.entityscores.EntityScoresOperations;
import com.zoho.crm.api.entityscores.Info;
import com.zoho.crm.api.entityscores.ResponseHandler;
import com.zoho.crm.api.entityscores.ResponseWrapper;
import com.zoho.crm.api.entityscores.ScoringRuleStructure;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.dc.DataCenter.Environment;

public class GetModule
{
	public static void getModule(Long recordId, String module) throws Exception
	{
		EntityScoresOperations entityScoresOperations = new EntityScoresOperations("Positive_Score");
		APIResponse<ResponseHandler> response = entityScoresOperations.getModule(recordId, module);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (Arrays.asList(204, 304).contains(response.getStatusCode()))
			{
				System.out.println(response.getStatusCode() == 204 ? "No Content" : "Not Modified");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<EntityScores> data = responseWrapper.getData();
					if (data != null)
					{
						for (EntityScores score : data)
						{
							System.out.println("Score : " + score.getScore());
							System.out.println("PositiveScore : " + score.getPositiveScore());
							System.out.println("TouchPointScore : " + score.getTouchPointScore());
							System.out.println("NegativeScore : " + score.getNegativeScore());
							System.out.println("touchPointNegativeScore : " + score.getTouchPointNegativeScore());
							System.out.println("touchPointPositiveScore : " + score.getTouchPointPositiveScore());
							System.out.println("Id : " + score.getId());
							System.out.println("ZiaVisions : " + score.getZiaVisions());
							ScoringRuleStructure scoringRule = score.getScoringRule();
							if (scoringRule != null)
							{
								System.out.println("ScoringRule Id : " + scoringRule.getId());
								System.out.println("ScoringRule Name : " + scoringRule.getName());
							}
							List<Object> fieldStates = score.getFieldStates();
							for (Object field : fieldStates)
							{
								System.out.println("fieldStates : " + field);
							}
						}
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("Info Page: " + info.getPage());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Info MoreRecords: " + info.getMoreRecords().toString());
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
			else
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();
				for (java.lang.reflect.Field field : fields)
				{
					System.out.println(field.getName() + ":" + field.get(responseObject));
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
			long recordId = 440248001177154l;
			String module = "leads";
			getModule(recordId, module);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
