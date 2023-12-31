package com.zoho.crm.api.usersterritories;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Territory implements Model
{
	private String id;

	private Manager manager;

	private Manager reportingTo;

	private String name;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of id
	 * @return A String representing the id
	 */
	public String getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A String representing the id
	 */
	public void setId(String id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of manager
	 * @return An instance of Manager
	 */
	public Manager getManager()
	{
		return  this.manager;

	}

	/**
	 * The method to set the value to manager
	 * @param manager An instance of Manager
	 */
	public void setManager(Manager manager)
	{
		 this.manager = manager;

		 this.keyModified.put("Manager", 1);

	}

	/**
	 * The method to get the value of reportingTo
	 * @return An instance of Manager
	 */
	public Manager getReportingTo()
	{
		return  this.reportingTo;

	}

	/**
	 * The method to set the value to reportingTo
	 * @param reportingTo An instance of Manager
	 */
	public void setReportingTo(Manager reportingTo)
	{
		 this.reportingTo = reportingTo;

		 this.keyModified.put("Reporting_To", 1);

	}

	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return  this.name;

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.name = name;

		 this.keyModified.put("Name", 1);

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