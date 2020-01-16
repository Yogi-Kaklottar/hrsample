package com.axelor.app.service;



import com.axelor.app.AppSettings;
import com.axelor.meta.CallMethod;




public class ImagePathGet{
	@CallMethod
	public String getData()
	{
	
		AppSettings app=AppSettings.get();
		String s=app.get("file.upload.dir");
		//System.out.println(s);
		return s;
		
	}

}
