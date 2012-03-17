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

import it.mal.projectaladdin.model.Wishlist;

import java.util.List;

/**
 * The persistence utility for the wishlist service. This utility wraps {@link WishlistPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAL
 * @see WishlistPersistence
 * @see WishlistPersistenceImpl
 * @generated
 */
public class WishlistUtil {
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
	public static void clearCache(Wishlist wishlist) {
		getPersistence().clearCache(wishlist);
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
	public static List<Wishlist> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Wishlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Wishlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Wishlist update(Wishlist wishlist, boolean merge)
		throws SystemException {
		return getPersistence().update(wishlist, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Wishlist update(Wishlist wishlist, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(wishlist, merge, serviceContext);
	}

	/**
	* Caches the wishlist in the entity cache if it is enabled.
	*
	* @param wishlist the wishlist
	*/
	public static void cacheResult(
		it.mal.projectaladdin.model.Wishlist wishlist) {
		getPersistence().cacheResult(wishlist);
	}

	/**
	* Caches the wishlists in the entity cache if it is enabled.
	*
	* @param wishlists the wishlists
	*/
	public static void cacheResult(
		java.util.List<it.mal.projectaladdin.model.Wishlist> wishlists) {
		getPersistence().cacheResult(wishlists);
	}

	/**
	* Creates a new wishlist with the primary key. Does not add the wishlist to the database.
	*
	* @param wishlistId the primary key for the new wishlist
	* @return the new wishlist
	*/
	public static it.mal.projectaladdin.model.Wishlist create(long wishlistId) {
		return getPersistence().create(wishlistId);
	}

	/**
	* Removes the wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wishlistId the primary key of the wishlist
	* @return the wishlist that was removed
	* @throws it.mal.projectaladdin.NoSuchWishlistException if a wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wishlist remove(long wishlistId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishlistException {
		return getPersistence().remove(wishlistId);
	}

	public static it.mal.projectaladdin.model.Wishlist updateImpl(
		it.mal.projectaladdin.model.Wishlist wishlist, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(wishlist, merge);
	}

	/**
	* Returns the wishlist with the primary key or throws a {@link it.mal.projectaladdin.NoSuchWishlistException} if it could not be found.
	*
	* @param wishlistId the primary key of the wishlist
	* @return the wishlist
	* @throws it.mal.projectaladdin.NoSuchWishlistException if a wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wishlist findByPrimaryKey(
		long wishlistId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishlistException {
		return getPersistence().findByPrimaryKey(wishlistId);
	}

	/**
	* Returns the wishlist with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wishlistId the primary key of the wishlist
	* @return the wishlist, or <code>null</code> if a wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wishlist fetchByPrimaryKey(
		long wishlistId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(wishlistId);
	}

	/**
	* Returns all the wishlists where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wishlist> findByByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByUserId(userId);
	}

	/**
	* Returns a range of all the wishlists where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of wishlists
	* @param end the upper bound of the range of wishlists (not inclusive)
	* @return the range of matching wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wishlist> findByByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the wishlists where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of wishlists
	* @param end the upper bound of the range of wishlists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wishlist> findByByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first wishlist in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wishlist
	* @throws it.mal.projectaladdin.NoSuchWishlistException if a matching wishlist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wishlist findByByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishlistException {
		return getPersistence().findByByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last wishlist in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wishlist
	* @throws it.mal.projectaladdin.NoSuchWishlistException if a matching wishlist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wishlist findByByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishlistException {
		return getPersistence().findByByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the wishlists before and after the current wishlist in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param wishlistId the primary key of the current wishlist
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wishlist
	* @throws it.mal.projectaladdin.NoSuchWishlistException if a wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wishlist[] findByByUserId_PrevAndNext(
		long wishlistId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishlistException {
		return getPersistence()
				   .findByByUserId_PrevAndNext(wishlistId, userId,
			orderByComparator);
	}

	/**
	* Returns all the wishlists where userId = &#63; and rating = &#63;.
	*
	* @param userId the user ID
	* @param rating the rating
	* @return the matching wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wishlist> findByByUserIdRating(
		long userId, int rating)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByUserIdRating(userId, rating);
	}

	/**
	* Returns a range of all the wishlists where userId = &#63; and rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param rating the rating
	* @param start the lower bound of the range of wishlists
	* @param end the upper bound of the range of wishlists (not inclusive)
	* @return the range of matching wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wishlist> findByByUserIdRating(
		long userId, int rating, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByUserIdRating(userId, rating, start, end);
	}

	/**
	* Returns an ordered range of all the wishlists where userId = &#63; and rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param rating the rating
	* @param start the lower bound of the range of wishlists
	* @param end the upper bound of the range of wishlists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wishlist> findByByUserIdRating(
		long userId, int rating, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByUserIdRating(userId, rating, start, end,
			orderByComparator);
	}

	/**
	* Returns the first wishlist in the ordered set where userId = &#63; and rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wishlist
	* @throws it.mal.projectaladdin.NoSuchWishlistException if a matching wishlist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wishlist findByByUserIdRating_First(
		long userId, int rating,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishlistException {
		return getPersistence()
				   .findByByUserIdRating_First(userId, rating, orderByComparator);
	}

	/**
	* Returns the last wishlist in the ordered set where userId = &#63; and rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wishlist
	* @throws it.mal.projectaladdin.NoSuchWishlistException if a matching wishlist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wishlist findByByUserIdRating_Last(
		long userId, int rating,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishlistException {
		return getPersistence()
				   .findByByUserIdRating_Last(userId, rating, orderByComparator);
	}

	/**
	* Returns the wishlists before and after the current wishlist in the ordered set where userId = &#63; and rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param wishlistId the primary key of the current wishlist
	* @param userId the user ID
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wishlist
	* @throws it.mal.projectaladdin.NoSuchWishlistException if a wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wishlist[] findByByUserIdRating_PrevAndNext(
		long wishlistId, long userId, int rating,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishlistException {
		return getPersistence()
				   .findByByUserIdRating_PrevAndNext(wishlistId, userId,
			rating, orderByComparator);
	}

	/**
	* Returns all the wishlists where rating = &#63;.
	*
	* @param rating the rating
	* @return the matching wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wishlist> findByByRating(
		int rating) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByRating(rating);
	}

	/**
	* Returns a range of all the wishlists where rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param rating the rating
	* @param start the lower bound of the range of wishlists
	* @param end the upper bound of the range of wishlists (not inclusive)
	* @return the range of matching wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wishlist> findByByRating(
		int rating, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByRating(rating, start, end);
	}

	/**
	* Returns an ordered range of all the wishlists where rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param rating the rating
	* @param start the lower bound of the range of wishlists
	* @param end the upper bound of the range of wishlists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wishlist> findByByRating(
		int rating, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByRating(rating, start, end, orderByComparator);
	}

	/**
	* Returns the first wishlist in the ordered set where rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wishlist
	* @throws it.mal.projectaladdin.NoSuchWishlistException if a matching wishlist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wishlist findByByRating_First(
		int rating,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishlistException {
		return getPersistence().findByByRating_First(rating, orderByComparator);
	}

	/**
	* Returns the last wishlist in the ordered set where rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wishlist
	* @throws it.mal.projectaladdin.NoSuchWishlistException if a matching wishlist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wishlist findByByRating_Last(
		int rating,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishlistException {
		return getPersistence().findByByRating_Last(rating, orderByComparator);
	}

	/**
	* Returns the wishlists before and after the current wishlist in the ordered set where rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param wishlistId the primary key of the current wishlist
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wishlist
	* @throws it.mal.projectaladdin.NoSuchWishlistException if a wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Wishlist[] findByByRating_PrevAndNext(
		long wishlistId, int rating,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishlistException {
		return getPersistence()
				   .findByByRating_PrevAndNext(wishlistId, rating,
			orderByComparator);
	}

	/**
	* Returns all the wishlists.
	*
	* @return the wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wishlist> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the wishlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wishlists
	* @param end the upper bound of the range of wishlists (not inclusive)
	* @return the range of wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wishlist> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the wishlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wishlists
	* @param end the upper bound of the range of wishlists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Wishlist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the wishlists where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByUserId(userId);
	}

	/**
	* Removes all the wishlists where userId = &#63; and rating = &#63; from the database.
	*
	* @param userId the user ID
	* @param rating the rating
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByUserIdRating(long userId, int rating)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByUserIdRating(userId, rating);
	}

	/**
	* Removes all the wishlists where rating = &#63; from the database.
	*
	* @param rating the rating
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByRating(int rating)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByRating(rating);
	}

	/**
	* Removes all the wishlists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of wishlists where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByUserId(userId);
	}

	/**
	* Returns the number of wishlists where userId = &#63; and rating = &#63;.
	*
	* @param userId the user ID
	* @param rating the rating
	* @return the number of matching wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByUserIdRating(long userId, int rating)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByUserIdRating(userId, rating);
	}

	/**
	* Returns the number of wishlists where rating = &#63;.
	*
	* @param rating the rating
	* @return the number of matching wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByRating(int rating)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByRating(rating);
	}

	/**
	* Returns the number of wishlists.
	*
	* @return the number of wishlists
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WishlistPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WishlistPersistence)PortletBeanLocatorUtil.locate(it.mal.projectaladdin.service.ClpSerializer.getServletContextName(),
					WishlistPersistence.class.getName());

			ReferenceRegistry.registerReference(WishlistUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(WishlistPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(WishlistUtil.class, "_persistence");
	}

	private static WishlistPersistence _persistence;
}