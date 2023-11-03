package com.zoho.crm.api.customviews;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class PinFields implements Model
{
	private String apiName;

	private Choice<Boolean> pin;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of apiName
	 * @return A String representing the apiName
	 */
	public String getAPIName()
	{
		return  this.apiName;

	}

	/**
	 * The method to set the value to apiName
	 * @param apiName A String representing the apiName
	 */
	public void setAPIName(String apiName)
	{
		 this.apiName = apiName;

		 this.keyModified.put("api_name", 1);

	}

	/**
	 * The method to get the value of pin
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getPin()
	{
		return  this.pin;

	}

	/**
	 * The method to set the value to pin
	 * @param pin An instance of Choice<Boolean>
	 */
	public void setPin(Choice<Boolean> pin)
	{
		 this.pin = pin;

		 this.keyModified.put("_pin", 1);

	}

	/**
	 * The method to check if the user has modified the given key
	 * @param key A String representing the key
	 * @return An Integer representing the modification
	 */
	public Integer isKeyModified(String key)
	{
		if((( this.keyModified.containsKey(key))))
		{
			return  this.keyModified.get(key);

		}
		return null;

	}

	/**
	 * The method to mark the given key as modified
	 * @param key A String representing the key
	 * @param modification An Integer representing the modification
	 */
	public void setKeyModified(String key, Integer modification)
	{
		 this.keyModified.put(key, modification);

	}
}