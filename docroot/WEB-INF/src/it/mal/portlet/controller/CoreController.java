package it.mal.portlet.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CoreController
 */
public class CoreController extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(CoreController.class);
 
	public void login(ActionRequest actionRequest, ActionResponse actionResponse) {
		String username = ParamUtil.getString(actionRequest, CoreControllerConstants.USERNAME);
		String password = ParamUtil.getString(actionRequest, CoreControllerConstants.PASSWORD);
	
		_log.info("username: " + username);
		_log.info("password: " + password);
	}

}
