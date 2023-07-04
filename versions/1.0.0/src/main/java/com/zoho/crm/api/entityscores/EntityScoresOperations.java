package com.zoho.crm.api.entityscores;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class EntityScoresOperations
{
	private String fields;

	/**
	 * Creates an instance of EntityScoresOperations with the given parameters
	 * @param fields A String representing the fields
	 */
	public EntityScoresOperations(String fields)
	{
		 this.fields = fields;


	}

	/**
	 * The method to get module
	 * @param recordId A Long representing the recordId
	 * @param module A String representing the module
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getModule(Long recordId, String module) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v5/");

		apiPath = apiPath.concat(module.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/Entity_Scores__s");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("fields", "com.zoho.crm.api.EntityScores.GetModuleParam"),  this.fields);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to get modules
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getModules() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v5/Entity_Scores__s");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("fields", "com.zoho.crm.api.EntityScores.GetModulesParam"),  this.fields);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetModuleParam
	{
	}

	public static class GetModulesParam
	{
	}
}