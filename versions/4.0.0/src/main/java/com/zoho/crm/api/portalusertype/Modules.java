package com.zoho.crm.api.portalusertype;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Modules implements Model
{
	private Long id;

	private String pluralLabel;

	private Choice<String> sharedType;

	private String apiName;

	private List<Filters> filters;

	private List<Fields> fields;

	private List<Layouts> layouts;

	private Views views;

	private Permissions permissions;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of pluralLabel
	 * @return A String representing the pluralLabel
	 */
	public String getPluralLabel()
	{
		return  this.pluralLabel;

	}

	/**
	 * The method to set the value to pluralLabel
	 * @param pluralLabel A String representing the pluralLabel
	 */
	public void setPluralLabel(String pluralLabel)
	{
		 this.pluralLabel = pluralLabel;

		 this.keyModified.put("plural_label", 1);

	}

	/**
	 * The method to get the value of sharedType
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getSharedType()
	{
		return  this.sharedType;

	}

	/**
	 * The method to set the value to sharedType
	 * @param sharedType An instance of Choice<String>
	 */
	public void setSharedType(Choice<String> sharedType)
	{
		 this.sharedType = sharedType;

		 this.keyModified.put("shared_type", 1);

	}

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
	 * The method to get the value of filters
	 * @return An instance of List<Filters>
	 */
	public List<Filters> getFilters()
	{
		return  this.filters;

	}

	/**
	 * The method to set the value to filters
	 * @param filters An instance of List<Filters>
	 */
	public void setFilters(List<Filters> filters)
	{
		 this.filters = filters;

		 this.keyModified.put("filters", 1);

	}

	/**
	 * The method to get the value of fields
	 * @return An instance of List<Fields>
	 */
	public List<Fields> getFields()
	{
		return  this.fields;

	}

	/**
	 * The method to set the value to fields
	 * @param fields An instance of List<Fields>
	 */
	public void setFields(List<Fields> fields)
	{
		 this.fields = fields;

		 this.keyModified.put("fields", 1);

	}

	/**
	 * The method to get the value of layouts
	 * @return An instance of List<Layouts>
	 */
	public List<Layouts> getLayouts()
	{
		return  this.layouts;

	}

	/**
	 * The method to set the value to layouts
	 * @param layouts An instance of List<Layouts>
	 */
	public void setLayouts(List<Layouts> layouts)
	{
		 this.layouts = layouts;

		 this.keyModified.put("layouts", 1);

	}

	/**
	 * The method to get the value of views
	 * @return An instance of Views
	 */
	public Views getViews()
	{
		return  this.views;

	}

	/**
	 * The method to set the value to views
	 * @param views An instance of Views
	 */
	public void setViews(Views views)
	{
		 this.views = views;

		 this.keyModified.put("views", 1);

	}

	/**
	 * The method to get the value of permissions
	 * @return An instance of Permissions
	 */
	public Permissions getPermissions()
	{
		return  this.permissions;

	}

	/**
	 * The method to set the value to permissions
	 * @param permissions An instance of Permissions
	 */
	public void setPermissions(Permissions permissions)
	{
		 this.permissions = permissions;

		 this.keyModified.put("permissions", 1);

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