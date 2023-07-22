package com.zoho.crm.api.notifications;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class DeleteDetails implements Model
{
	private Long resourceId;

	private String resourceUri;

	private String channelId;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of resourceId
	 * @return A Long representing the resourceId
	 */
	public Long getResourceId()
	{
		return  this.resourceId;

	}

	/**
	 * The method to set the value to resourceId
	 * @param resourceId A Long representing the resourceId
	 */
	public void setResourceId(Long resourceId)
	{
		 this.resourceId = resourceId;

		 this.keyModified.put("resource_id", 1);

	}

	/**
	 * The method to get the value of resourceUri
	 * @return A String representing the resourceUri
	 */
	public String getResourceUri()
	{
		return  this.resourceUri;

	}

	/**
	 * The method to set the value to resourceUri
	 * @param resourceUri A String representing the resourceUri
	 */
	public void setResourceUri(String resourceUri)
	{
		 this.resourceUri = resourceUri;

		 this.keyModified.put("resource_uri", 1);

	}

	/**
	 * The method to get the value of channelId
	 * @return A String representing the channelId
	 */
	public String getChannelId()
	{
		return  this.channelId;

	}

	/**
	 * The method to set the value to channelId
	 * @param channelId A String representing the channelId
	 */
	public void setChannelId(String channelId)
	{
		 this.channelId = channelId;

		 this.keyModified.put("channel_id", 1);

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