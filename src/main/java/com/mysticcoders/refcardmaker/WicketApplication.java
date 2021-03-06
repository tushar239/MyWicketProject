package com.mysticcoders.refcardmaker;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import com.mysticcoders.refcardmaker.borders.CwickPage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see wicket.myproject.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    
    /**
     * Constructor
     */
	public WicketApplication()
	{
	}
	
	/**
	 * @see wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends Page> getHomePage()
	{
		//return HomePage.class;
	    return CwickPage.class;
	}

}
