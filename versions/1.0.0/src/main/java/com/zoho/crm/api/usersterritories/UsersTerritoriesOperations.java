package com.zoho.crm.api.usersterritories;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class UsersTerritoriesOperations
{
	/**
	 * The method to get territories of user
	 * @param user A Long representing the user
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getTerritoriesOfUser(Long user) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v5/users/");

		apiPath = apiPath.concat(user.toString());

		apiPath = apiPath.concat("/territories");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to associate territories to user
	 * @param user A Long representing the user
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> associateTerritoriesToUser(Long user, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v5/users/");

		apiPath = apiPath.concat(user.toString());

		apiPath = apiPath.concat("/territories");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get territory of user
	 * @param territory A Long representing the territory
	 * @param user A Long representing the user
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getTerritoryOfUser(Long territory, Long user) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v5/users/");

		apiPath = apiPath.concat(user.toString());

		apiPath = apiPath.concat("/territories/");

		apiPath = apiPath.concat(territory.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to validate before transfer for all territories
	 * @param user A Long representing the user
	 * @return An instance of APIResponse<ValidationHandler>
	 * @throws SDKException
	 */
	public APIResponse<ValidationHandler> validateBeforeTransferForAllTerritories(Long user) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v5/users/");

		apiPath = apiPath.concat(user.toString());

		apiPath = apiPath.concat("/territories/actions/validate_before_transfer");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		return handlerInstance.apiCall(ValidationHandler.class, "application/json");

	}

	/**
	 * The method to validate before transfer
	 * @param territory A Long representing the territory
	 * @param user A Long representing the user
	 * @return An instance of APIResponse<ValidationHandler>
	 * @throws SDKException
	 */
	public APIResponse<ValidationHandler> validateBeforeTransfer(Long territory, Long user) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v5/users/");

		apiPath = apiPath.concat(user.toString());

		apiPath = apiPath.concat("/territories/");

		apiPath = apiPath.concat(territory.toString());

		apiPath = apiPath.concat("/actions/validate_before_transfer");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		return handlerInstance.apiCall(ValidationHandler.class, "application/json");

	}

	/**
	 * The method to delink and transfer from all territories
	 * @param user A Long representing the user
	 * @param request An instance of TransferWrapper
	 * @return An instance of APIResponse<TransferActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<TransferActionHandler> delinkAndTransferFromAllTerritories(Long user, TransferWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v5/users/");

		apiPath = apiPath.concat(user.toString());

		apiPath = apiPath.concat("/territories/actions/transfer_and_delink");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		return handlerInstance.apiCall(TransferActionHandler.class, "application/json");

	}

	/**
	 * The method to delink and transfer from specific territory
	 * @param territory A Long representing the territory
	 * @param user A Long representing the user
	 * @param request An instance of TransferWrapper
	 * @return An instance of APIResponse<TransferActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<TransferActionHandler> delinkAndTransferFromSpecificTerritory(Long territory, Long user, TransferWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v5/users/");

		apiPath = apiPath.concat(user.toString());

		apiPath = apiPath.concat("/territories/");

		apiPath = apiPath.concat(territory.toString());

		apiPath = apiPath.concat("/actions/transfer_and_delink");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		return handlerInstance.apiCall(TransferActionHandler.class, "application/json");

	}
}