/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.mal.projectaladdin.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import it.mal.projectaladdin.model.CategoryClp;
import it.mal.projectaladdin.model.CategoryWishlistClp;
import it.mal.projectaladdin.model.WishClp;
import it.mal.projectaladdin.model.WishlistClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"project-aladin-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"project-aladin-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "project-aladin-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CategoryClp.class.getName())) {
			return translateInputCategory(oldModel);
		}

		if (oldModelClassName.equals(CategoryWishlistClp.class.getName())) {
			return translateInputCategoryWishlist(oldModel);
		}

		if (oldModelClassName.equals(WishClp.class.getName())) {
			return translateInputWish(oldModel);
		}

		if (oldModelClassName.equals(WishlistClp.class.getName())) {
			return translateInputWishlist(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCategory(BaseModel<?> oldModel) {
		CategoryClp oldCplModel = (CategoryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("it.mal.projectaladdin.model.impl.CategoryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setCategoryId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getCategoryId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value1 = oldCplModel.getName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setAuthor",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getAuthor());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value3 = oldCplModel.getDescription();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setParentCategory",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getParentCategory());

				method4.invoke(newModel, value4);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputCategoryWishlist(BaseModel<?> oldModel) {
		CategoryWishlistClp oldCplModel = (CategoryWishlistClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("it.mal.projectaladdin.model.impl.CategoryWishlistImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setCategoryId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getCategoryId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setWishlistId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getWishlistId());

				method1.invoke(newModel, value1);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputWish(BaseModel<?> oldModel) {
		WishClp oldCplModel = (WishClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("it.mal.projectaladdin.model.impl.WishImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setWishId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getWishId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value1 = oldCplModel.getName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value2 = oldCplModel.getDescription();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setPrice",
						new Class[] { Double.TYPE });

				Double value3 = new Double(oldCplModel.getPrice());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setUrl",
						new Class[] { String.class });

				String value4 = oldCplModel.getUrl();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setImage",
						new Class[] { String.class });

				String value5 = oldCplModel.getImage();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setCreationDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getCreationDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getModifiedDate();

				method7.invoke(newModel, value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputWishlist(BaseModel<?> oldModel) {
		WishlistClp oldCplModel = (WishlistClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("it.mal.projectaladdin.model.impl.WishlistImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setWishlistId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getWishlistId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getUserId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setWishId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getWishId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setRating",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getRating());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setComment",
						new Class[] { String.class });

				String value4 = oldCplModel.getComment();

				method4.invoke(newModel, value4);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"it.mal.projectaladdin.model.impl.CategoryImpl")) {
			return translateOutputCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"it.mal.projectaladdin.model.impl.CategoryWishlistImpl")) {
			return translateOutputCategoryWishlist(oldModel);
		}

		if (oldModelClassName.equals(
					"it.mal.projectaladdin.model.impl.WishImpl")) {
			return translateOutputWish(oldModel);
		}

		if (oldModelClassName.equals(
					"it.mal.projectaladdin.model.impl.WishlistImpl")) {
			return translateOutputWishlist(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputCategory(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CategoryClp newModel = new CategoryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getCategoryId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setCategoryId(value0);

				Method method1 = oldModelClass.getMethod("getName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setName(value1);

				Method method2 = oldModelClass.getMethod("getAuthor");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setAuthor(value2);

				Method method3 = oldModelClass.getMethod("getDescription");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setDescription(value3);

				Method method4 = oldModelClass.getMethod("getParentCategory");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setParentCategory(value4);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputCategoryWishlist(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CategoryWishlistClp newModel = new CategoryWishlistClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getCategoryId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setCategoryId(value0);

				Method method1 = oldModelClass.getMethod("getWishlistId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setWishlistId(value1);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputWish(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				WishClp newModel = new WishClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getWishId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setWishId(value0);

				Method method1 = oldModelClass.getMethod("getName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setName(value1);

				Method method2 = oldModelClass.getMethod("getDescription");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setDescription(value2);

				Method method3 = oldModelClass.getMethod("getPrice");

				Double value3 = (Double)method3.invoke(oldModel, (Object[])null);

				newModel.setPrice(value3);

				Method method4 = oldModelClass.getMethod("getUrl");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setUrl(value4);

				Method method5 = oldModelClass.getMethod("getImage");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setImage(value5);

				Method method6 = oldModelClass.getMethod("getCreationDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setCreationDate(value6);

				Method method7 = oldModelClass.getMethod("getModifiedDate");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputWishlist(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				WishlistClp newModel = new WishlistClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getWishlistId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setWishlistId(value0);

				Method method1 = oldModelClass.getMethod("getUserId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setUserId(value1);

				Method method2 = oldModelClass.getMethod("getWishId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setWishId(value2);

				Method method3 = oldModelClass.getMethod("getRating");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setRating(value3);

				Method method4 = oldModelClass.getMethod("getComment");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setComment(value4);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}