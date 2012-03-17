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

import it.mal.projectaladdin.model.CategoryWishlist;

import java.util.List;

/**
 * The persistence utility for the category wishlist service. This utility wraps {@link CategoryWishlistPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAL
 * @see CategoryWishlistPersistence
 * @see CategoryWishlistPersistenceImpl
 * @generated
 */
public class CategoryWishlistUtil {
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
	public static void clearCache(CategoryWishlist categoryWishlist) {
		getPersistence().clearCache(categoryWishlist);
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
	public static List<CategoryWishlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CategoryWishlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CategoryWishlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CategoryWishlist update(CategoryWishlist categoryWishlist,
		boolean merge) throws SystemException {
		return getPersistence().update(categoryWishlist, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CategoryWishlist update(CategoryWishlist categoryWishlist,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(categoryWishlist, merge, serviceContext);
	}

	/**
	* Caches the category wishlist in the entity cache if it is enabled.
	*
	* @param categoryWishlist the category wishlist
	*/
	public static void cacheResult(
		it.mal.projectaladdin.model.CategoryWishlist categoryWishlist) {
		getPersistence().cacheResult(categoryWishlist);
	}

	/**
	* Caches the category wishlists in the entity cache if it is enabled.
	*
	* @param categoryWishlists the category wishlists
	*/
	public static void cacheResult(
		java.util.List<it.mal.projectaladdin.model.CategoryWishlist> categoryWishlists) {
		getPersistence().cacheResult(categoryWishlists);
	}

	/**
	* Creates a new category wishlist with the primary key. Does not add the category wishlist to the database.
	*
	* @param categoryWishlistPK the primary key for the new category wishlist
	* @return the new category wishlist
	*/
	public static it.mal.projectaladdin.model.CategoryWishlist create(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK categoryWishlistPK) {
		return getPersistence().create(categoryWishlistPK);
	}

	/**
	* Removes the category wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryWishlistPK the primary key of the category wishlist
	* @return the category wishlist that was removed
	* @throws it.mal.projectaladdin.NoSuchCategoryWishlistException if a category wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.CategoryWishlist remove(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK categoryWishlistPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryWishlistException {
		return getPersistence().remove(categoryWishlistPK);
	}

	public static it.mal.projectaladdin.model.CategoryWishlist updateImpl(
		it.mal.projectaladdin.model.CategoryWishlist categoryWishlist,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(categoryWishlist, merge);
	}

	/**
	* Returns the category wishlist with the primary key or throws a {@link it.mal.projectaladdin.NoSuchCategoryWishlistException} if it could not be found.
	*
	* @param categoryWishlistPK the primary key of the category wishlist
	* @return the category wishlist
	* @throws it.mal.projectaladdin.NoSuchCategoryWishlistException if a category wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.CategoryWishlist findByPrimaryKey(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK categoryWishlistPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryWishlistException {
		return getPersistence().findByPrimaryKey(categoryWishlistPK);
	}

	/**
	* Returns the category wishlist with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryWishlistPK the primary key of the category wishlist
	* @return the category wishlist, or <code>null</code> if a category wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.CategoryWishlist fetchByPrimaryKey(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK categoryWishlistPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryWishlistPK);
	}

	/**
	* Returns all the category wishlists.
	*
	* @return the category wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.CategoryWishlist> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the category wishlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category wishlists
	* @param end the upper bound of the range of category wishlists (not inclusive)
	* @return the range of category wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.CategoryWishlist> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the category wishlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category wishlists
	* @param end the upper bound of the range of category wishlists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of category wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.CategoryWishlist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the category wishlists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of category wishlists.
	*
	* @return the number of category wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CategoryWishlistPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CategoryWishlistPersistence)PortletBeanLocatorUtil.locate(it.mal.projectaladdin.service.ClpSerializer.getServletContextName(),
					CategoryWishlistPersistence.class.getName());

			ReferenceRegistry.registerReference(CategoryWishlistUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CategoryWishlistPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CategoryWishlistUtil.class,
			"_persistence");
	}

	private static CategoryWishlistPersistence _persistence;
}