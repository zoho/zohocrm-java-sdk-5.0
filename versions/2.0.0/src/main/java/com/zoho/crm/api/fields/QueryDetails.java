package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.Map;

public class QueryDetails implements Model
{
	private Long queryId;

	private Map<String, Object> criteria;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of queryId
	 * @return A Long representing the queryId
	 */
	public Long getQueryId()
	{
		return  this.queryId;

	}

	/**
	 * The method to set the value to queryId
	 * @param queryId A Long representing the queryId
	 */
	public void setQueryId(Long queryId)
	{
		 this.queryId = queryId;

		 this.keyModified.put("query_id", 1);

	}

	/**
	 * The method to get the value of criteria
	 * @return An instance of Map<String,Object>
	 */
	public Map<String, Object> getCriteria()
	{
		return  this.criteria;

	}

	/**
	 * The method to set the value to criteria
	 * @param criteria An instance of Map<String,Object>
	 */
	public void setCriteria(Map<String, Object> criteria)
	{
		 this.criteria = criteria;

		 this.keyModified.put("criteria", 1);

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