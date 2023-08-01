package com.zoho.crm.api.mailmerge;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Address implements Model
{
	private AddressValueMap addressValueMap;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of addressValueMap
	 * @return An instance of AddressValueMap
	 */
	public AddressValueMap getAddressValueMap()
	{
		return  this.addressValueMap;

	}

	/**
	 * The method to set the value to addressValueMap
	 * @param addressValueMap An instance of AddressValueMap
	 */
	public void setAddressValueMap(AddressValueMap addressValueMap)
	{
		 this.addressValueMap = addressValueMap;

		 this.keyModified.put("Address_Value_Map", 1);

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