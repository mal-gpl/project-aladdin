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

import com.liferay.portal.service.persistence.BasePersistence;

import it.mal.projectaladdin.model.CategoryWishlist;

/**
 * The persistence interface for the category wishlist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAL
 * @see CategoryWishlistPersistenceImpl
 * @see CategoryWishlistUtil
 * @generated
 */
public interface CategoryWishlistPersistence extends BasePersistence<CategoryWishlist> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoryWishlistUtil} to access the category wishlist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the category wishlist in the entity cache if it is enabled.
	*
	* @param categoryWishlist the category wishlist
	*/
	public void cacheResult(
		it.mal.projectaladdin.model.CategoryWishlist categoryWishlist);

	/**
	* Caches the category wishlists in the entity cache if it is enabled.
	*
	* @param categoryWishlists the category wishlists
	*/
	public void cacheResult(
		java.util.List<it.mal.projectaladdin.model.CategoryWishlist> categoryWishlists);

	/**
	* Creates a new category wishlist with the primary key. Does not add the category wishlist to the database.
	*
	* @param categoryWishlistPK the primary key for the new category wishlist
	* @return the new category wishlist
	*/
	public it.mal.projectaladdin.model.CategoryWishlist create(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK categoryWishlistPK);

	/**
	* Removes the category wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryWishlistPK the primary key of the category wishlist
	* @return the category wishlist that was removed
	* @throws it.mal.projectaladdin.NoSuchCategoryWishlistException if a category wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.CategoryWishlist remove(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK categoryWishlistPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryWishlistException;

	public it.mal.projectaladdin.model.CategoryWishlist updateImpl(
		it.mal.projectaladdin.model.CategoryWishlist categoryWishlist,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the category wishlist with the primary key or throws a {@link it.mal.projectaladdin.NoSuchCategoryWishlistException} if it could not be found.
	*
	* @param categoryWishlistPK the primary key of the category wishlist
	* @return the category wishlist
	* @throws it.mal.projectaladdin.NoSuchCategoryWishlistException if a category wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.CategoryWishlist findByPrimaryKey(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK categoryWishlistPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryWishlistException;

	/**
	* Returns the category wishlist with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryWishlistPK the primary key of the category wishlist
	* @return the category wishlist, or <code>null</code> if a category wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.CategoryWishlist fetchByPrimaryKey(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK categoryWishlistPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the category wishlists.
	*
	* @return the category wishlists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.mal.projectaladdin.model.CategoryWishlist> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.mal.projectaladdin.model.CategoryWishlist> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.mal.projectaladdin.model.CategoryWishlist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the category wishlists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of category wishlists.
	*
	* @return the number of category wishlists
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}