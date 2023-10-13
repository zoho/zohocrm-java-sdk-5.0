package com.zoho.crm.api.emailcomposemeta;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ComposeSettings implements Model
{
	private DefaultForm defaultFromAddress;

	private Integer fontSize;

	private String fontFamily;

	private List<Object> emailSignatures;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of defaultFromAddress
	 * @return An instance of DefaultForm
	 */
	public DefaultForm getDefaultFromAddress()
	{
		return  this.defaultFromAddress;

	}

	/**
	 * The method to set the value to defaultFromAddress
	 * @param defaultFromAddress An instance of DefaultForm
	 */
	public void setDefaultFromAddress(DefaultForm defaultFromAddress)
	{
		 this.defaultFromAddress = defaultFromAddress;

		 this.keyModified.put("default_from_address", 1);

	}

	/**
	 * The method to get the value of fontSize
	 * @return An Integer representing the fontSize
	 */
	public Integer getFontSize()
	{
		return  this.fontSize;

	}

	/**
	 * The method to set the value to fontSize
	 * @param fontSize An Integer representing the fontSize
	 */
	public void setFontSize(Integer fontSize)
	{
		 this.fontSize = fontSize;

		 this.keyModified.put("font_size", 1);

	}

	/**
	 * The method to get the value of fontFamily
	 * @return A String representing the fontFamily
	 */
	public String getFontFamily()
	{
		return  this.fontFamily;

	}

	/**
	 * The method to set the value to fontFamily
	 * @param fontFamily A String representing the fontFamily
	 */
	public void setFontFamily(String fontFamily)
	{
		 this.fontFamily = fontFamily;

		 this.keyModified.put("font_family", 1);

	}

	/**
	 * The method to get the value of emailSignatures
	 * @return An instance of List<Object>
	 */
	public List<Object> getEmailSignatures()
	{
		return  this.emailSignatures;

	}

	/**
	 * The method to set the value to emailSignatures
	 * @param emailSignatures An instance of List<Object>
	 */
	public void setEmailSignatures(List<Object> emailSignatures)
	{
		 this.emailSignatures = emailSignatures;

		 this.keyModified.put("email_signatures", 1);

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