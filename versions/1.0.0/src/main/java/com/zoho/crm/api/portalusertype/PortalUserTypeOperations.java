package com.zoho.crm.api.portalusertype;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class PortalUserTypeOperations
{
	private String portal;

	/**
	 * Creates an instance of PortalUserTypeOperations with the given parameters
	 * @param portal A String representing the portal
	 */
	public PortalUserTypeOperations(String portal)
	{
		 this.portal = portal;


	}

	/**
	 * The method to get user types
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getUserTypes(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v5/settings/portals/");

		apiPath = apiPath.concat( this.portal.toString());

		apiPath = apiPath.concat("/user_type");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to get user type
	 * @param userTypeId A String representing the userTypeId
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getUserType(String userTypeId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v5/settings/portals/");

		apiPath = apiPath.concat( this.portal.toString());

		apiPath = apiPath.concat("/user_type/");

		apiPath = apiPath.concat(userTypeId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetUserTypesParam
	{
		public static final Param<String> INCLUDE = new Param<String>("include", "com.zoho.crm.api.PortalUserType.GetUserTypesParam");

	}
}