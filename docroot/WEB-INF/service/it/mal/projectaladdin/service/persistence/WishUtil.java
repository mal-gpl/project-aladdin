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

package it.mal.projectaladdin.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.mal.projectaladdin.model.Wish;

import java.util.List;

/**
 * The persistence utility for the wish service. This utility wraps {@link WishPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAL
 * @see WishPersistence
 * @see WishPersistenceImpl
 * @generated
 */
public class WishUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Wish wish) {
		getPersistence().clearCache(wish);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Wish> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Wish> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Wish> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Wish update(Wish wish, boolean merge)
		throws SystemException {
		return getPersistence().update(wish, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Wish update(Wish wish, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(wish, merge, serviceContext);
	}

	/**
	* Caches the wish in the entity cache if it is enabled.
	*
	* @param wish the wish
	*/
	public static void cacheResult(it.mal.projectaladdin.model.Wish wish) {
		getPersistence().cacheResult(wish);
	}

	/**
	* Caches the wishs in the entity cache if it is enabled.
	*
	* @param wishs the wishs
	*/
	public static void cacheResult(
		java.util.List<it.mal.projectaladdin.model.Wish> wishs) {
		getPersistence().cacheResult(wishs);
	}

	/**
	* Creates a new wish with the primary key. Does not add the wish to the database.
	*
	* @param wishId the primary key for the new wish
	* @return the new wish
	*/
	public static it.mal.projectaladdin.model.Wish create(long wishId) {
		return getPersistence().create(wishId);
	}

	/**
	* Removes the wish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wishId the primary key of the wish
	* @return the wish that was removed
	* @throws it.mal.projectaladdin.NoSuchWishException if a wish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wish remove(long wishId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishException {
		return getPersistence().remove(wishId);
	}

	public static it.mal.projectaladdin.model.Wish updateImpl(
		it.mal.projectaladdin.model.Wish wish, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(wish, merge);
	}

	/**
	* Returns the wish with the primary key or throws a {@link it.mal.projectaladdin.NoSuchWishException} if it could not be found.
	*
	* @param wishId the primary key of the wish
	* @return the wish
	* @throws it.mal.projectaladdin.NoSuchWishException if a wish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wish findByPrimaryKey(long wishId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishException {
		return getPersistence().findByPrimaryKey(wishId);
	}

	/**
	* Returns the wish with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wishId the primary key of the wish
	* @return the wish, or <code>null</code> if a wish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wish fetchByPrimaryKey(
		long wishId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(wishId);
	}

	/**
	* Returns all the wishs where name = &#63;.
	*
	* @param name the name
	* @return the matching wishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wish> findByByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByName(name);
	}

	/**
	* Returns a range of all the wishs where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of wishs
	* @param end the upper bound of the range of wishs (not inclusive)
	* @return the range of matching wishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wish> findByByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the wishs where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of wishs
	* @param end the upper bound of the range of wishs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wish> findByByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first wish in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wish
	* @throws it.mal.projectaladdin.NoSuchWishException if a matching wish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wish findByByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishException {
		return getPersistence().findByByName_First(name, orderByComparator);
	}

	/**
	* Returns the last wish in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wish
	* @throws it.mal.projectaladdin.NoSuchWishException if a matching wish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wish findByByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishException {
		return getPersistence().findByByName_Last(name, orderByComparator);
	}

	/**
	* Returns the wishs before and after the current wish in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param wishId the primary key of the current wish
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wish
	* @throws it.mal.projectaladdin.NoSuchWishException if a wish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wish[] findByByName_PrevAndNext(
		long wishId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishException {
		return getPersistence()
				   .findByByName_PrevAndNext(wishId, name, orderByComparator);
	}

	/**
	* Returns all the wishs.
	*
	* @return the wishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wish> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the wishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wishs
	* @param end the upper bound of the range of wishs (not inclusive)
	* @return the range of wishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wish> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the wishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wishs
	* @param end the upper bound of the range of wishs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of wishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wish> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the wishs where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByName(name);
	}

	/**
	* Removes all the wishs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of wishs where name = &#63;.
	*
	* @param name the name
	* @return the number of matching wishs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByName(name);
	}

	/**
	* Returns the number of wishs.
	*
	* @return the number of wishs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WishPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WishPersistence)PortletBeanLocatorUtil.locate(it.mal.projectaladdin.service.ClpSerializer.getServletContextName(),
					WishPersistence.class.getName());

			ReferenceRegistry.registerReference(WishUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(WishPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(WishUtil.class, "_persistence");
	}

	private static WishPersistence _persistence;
}