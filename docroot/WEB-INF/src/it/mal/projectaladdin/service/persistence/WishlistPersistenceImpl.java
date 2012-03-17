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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.mal.projectaladdin.NoSuchWishlistException;
import it.mal.projectaladdin.model.Wishlist;
import it.mal.projectaladdin.model.impl.WishlistImpl;
import it.mal.projectaladdin.model.impl.WishlistModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the wishlist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAL
 * @see WishlistPersistence
 * @see WishlistUtil
 * @generated
 */
public class WishlistPersistenceImpl extends BasePersistenceImpl<Wishlist>
	implements WishlistPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WishlistUtil} to access the wishlist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WishlistImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERID = new FinderPath(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID =
		new FinderPath(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByUserId",
			new String[] { Long.class.getName() },
			WishlistModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYUSERID = new FinderPath(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERIDRATING =
		new FinderPath(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByUserIdRating",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERIDRATING =
		new FinderPath(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByUserIdRating",
			new String[] { Long.class.getName(), Integer.class.getName() },
			WishlistModelImpl.USERID_COLUMN_BITMASK |
			WishlistModelImpl.RATING_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYUSERIDRATING = new FinderPath(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByUserIdRating",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYRATING = new FinderPath(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByRating",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYRATING =
		new FinderPath(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByRating",
			new String[] { Integer.class.getName() },
			WishlistModelImpl.RATING_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYRATING = new FinderPath(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByRating",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the wishlist in the entity cache if it is enabled.
	 *
	 * @param wishlist the wishlist
	 */
	public void cacheResult(Wishlist wishlist) {
		EntityCacheUtil.putResult(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistImpl.class, wishlist.getPrimaryKey(), wishlist);

		wishlist.resetOriginalValues();
	}

	/**
	 * Caches the wishlists in the entity cache if it is enabled.
	 *
	 * @param wishlists the wishlists
	 */
	public void cacheResult(List<Wishlist> wishlists) {
		for (Wishlist wishlist : wishlists) {
			if (EntityCacheUtil.getResult(
						WishlistModelImpl.ENTITY_CACHE_ENABLED,
						WishlistImpl.class, wishlist.getPrimaryKey()) == null) {
				cacheResult(wishlist);
			}
			else {
				wishlist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all wishlists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WishlistImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WishlistImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the wishlist.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Wishlist wishlist) {
		EntityCacheUtil.removeResult(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistImpl.class, wishlist.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Wishlist> wishlists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Wishlist wishlist : wishlists) {
			EntityCacheUtil.removeResult(WishlistModelImpl.ENTITY_CACHE_ENABLED,
				WishlistImpl.class, wishlist.getPrimaryKey());
		}
	}

	/**
	 * Creates a new wishlist with the primary key. Does not add the wishlist to the database.
	 *
	 * @param wishlistId the primary key for the new wishlist
	 * @return the new wishlist
	 */
	public Wishlist create(long wishlistId) {
		Wishlist wishlist = new WishlistImpl();

		wishlist.setNew(true);
		wishlist.setPrimaryKey(wishlistId);

		return wishlist;
	}

	/**
	 * Removes the wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wishlistId the primary key of the wishlist
	 * @return the wishlist that was removed
	 * @throws it.mal.projectaladdin.NoSuchWishlistException if a wishlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Wishlist remove(long wishlistId)
		throws NoSuchWishlistException, SystemException {
		return remove(Long.valueOf(wishlistId));
	}

	/**
	 * Removes the wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the wishlist
	 * @return the wishlist that was removed
	 * @throws it.mal.projectaladdin.NoSuchWishlistException if a wishlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Wishlist remove(Serializable primaryKey)
		throws NoSuchWishlistException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Wishlist wishlist = (Wishlist)session.get(WishlistImpl.class,
					primaryKey);

			if (wishlist == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWishlistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wishlist);
		}
		catch (NoSuchWishlistException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Wishlist removeImpl(Wishlist wishlist) throws SystemException {
		wishlist = toUnwrappedModel(wishlist);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, wishlist);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(wishlist);

		return wishlist;
	}

	@Override
	public Wishlist updateImpl(it.mal.projectaladdin.model.Wishlist wishlist,
		boolean merge) throws SystemException {
		wishlist = toUnwrappedModel(wishlist);

		boolean isNew = wishlist.isNew();

		WishlistModelImpl wishlistModelImpl = (WishlistModelImpl)wishlist;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, wishlist, merge);

			wishlist.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WishlistModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((wishlistModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wishlistModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID,
					args);

				args = new Object[] { Long.valueOf(wishlistModelImpl.getUserId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID,
					args);
			}

			if ((wishlistModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERIDRATING.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wishlistModelImpl.getOriginalUserId()),
						Integer.valueOf(wishlistModelImpl.getOriginalRating())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERIDRATING,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERIDRATING,
					args);

				args = new Object[] {
						Long.valueOf(wishlistModelImpl.getUserId()),
						Integer.valueOf(wishlistModelImpl.getRating())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERIDRATING,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERIDRATING,
					args);
			}

			if ((wishlistModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYRATING.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(wishlistModelImpl.getOriginalRating())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYRATING, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYRATING,
					args);

				args = new Object[] {
						Integer.valueOf(wishlistModelImpl.getRating())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYRATING, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYRATING,
					args);
			}
		}

		EntityCacheUtil.putResult(WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistImpl.class, wishlist.getPrimaryKey(), wishlist);

		return wishlist;
	}

	protected Wishlist toUnwrappedModel(Wishlist wishlist) {
		if (wishlist instanceof WishlistImpl) {
			return wishlist;
		}

		WishlistImpl wishlistImpl = new WishlistImpl();

		wishlistImpl.setNew(wishlist.isNew());
		wishlistImpl.setPrimaryKey(wishlist.getPrimaryKey());

		wishlistImpl.setWishlistId(wishlist.getWishlistId());
		wishlistImpl.setUserId(wishlist.getUserId());
		wishlistImpl.setWishId(wishlist.getWishId());
		wishlistImpl.setRating(wishlist.getRating());
		wishlistImpl.setComment(wishlist.getComment());

		return wishlistImpl;
	}

	/**
	 * Returns the wishlist with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the wishlist
	 * @return the wishlist
	 * @throws com.liferay.portal.NoSuchModelException if a wishlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Wishlist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the wishlist with the primary key or throws a {@link it.mal.projectaladdin.NoSuchWishlistException} if it could not be found.
	 *
	 * @param wishlistId the primary key of the wishlist
	 * @return the wishlist
	 * @throws it.mal.projectaladdin.NoSuchWishlistException if a wishlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Wishlist findByPrimaryKey(long wishlistId)
		throws NoSuchWishlistException, SystemException {
		Wishlist wishlist = fetchByPrimaryKey(wishlistId);

		if (wishlist == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + wishlistId);
			}

			throw new NoSuchWishlistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				wishlistId);
		}

		return wishlist;
	}

	/**
	 * Returns the wishlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wishlist
	 * @return the wishlist, or <code>null</code> if a wishlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Wishlist fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the wishlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wishlistId the primary key of the wishlist
	 * @return the wishlist, or <code>null</code> if a wishlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Wishlist fetchByPrimaryKey(long wishlistId)
		throws SystemException {
		Wishlist wishlist = (Wishlist)EntityCacheUtil.getResult(WishlistModelImpl.ENTITY_CACHE_ENABLED,
				WishlistImpl.class, wishlistId);

		if (wishlist == _nullWishlist) {
			return null;
		}

		if (wishlist == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				wishlist = (Wishlist)session.get(WishlistImpl.class,
						Long.valueOf(wishlistId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (wishlist != null) {
					cacheResult(wishlist);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WishlistModelImpl.ENTITY_CACHE_ENABLED,
						WishlistImpl.class, wishlistId, _nullWishlist);
				}

				closeSession(session);
			}
		}

		return wishlist;
	}

	/**
	 * Returns all the wishlists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching wishlists
	 * @throws SystemException if a system exception occurred
	 */
	public List<Wishlist> findByByUserId(long userId) throws SystemException {
		return findByByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Wishlist> findByByUserId(long userId, int start, int end)
		throws SystemException {
		return findByByUserId(userId, start, end, null);
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
	public List<Wishlist> findByByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Wishlist> list = (List<Wishlist>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_WISHLIST_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<Wishlist>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Wishlist findByByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchWishlistException, SystemException {
		List<Wishlist> list = findByByUserId(userId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchWishlistException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Wishlist findByByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchWishlistException, SystemException {
		int count = countByByUserId(userId);

		List<Wishlist> list = findByByUserId(userId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchWishlistException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Wishlist[] findByByUserId_PrevAndNext(long wishlistId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchWishlistException, SystemException {
		Wishlist wishlist = findByPrimaryKey(wishlistId);

		Session session = null;

		try {
			session = openSession();

			Wishlist[] array = new WishlistImpl[3];

			array[0] = getByByUserId_PrevAndNext(session, wishlist, userId,
					orderByComparator, true);

			array[1] = wishlist;

			array[2] = getByByUserId_PrevAndNext(session, wishlist, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Wishlist getByByUserId_PrevAndNext(Session session,
		Wishlist wishlist, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WISHLIST_WHERE);

		query.append(_FINDER_COLUMN_BYUSERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wishlist);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Wishlist> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the wishlists where userId = &#63; and rating = &#63;.
	 *
	 * @param userId the user ID
	 * @param rating the rating
	 * @return the matching wishlists
	 * @throws SystemException if a system exception occurred
	 */
	public List<Wishlist> findByByUserIdRating(long userId, int rating)
		throws SystemException {
		return findByByUserIdRating(userId, rating, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Wishlist> findByByUserIdRating(long userId, int rating,
		int start, int end) throws SystemException {
		return findByByUserIdRating(userId, rating, start, end, null);
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
	public List<Wishlist> findByByUserIdRating(long userId, int rating,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERIDRATING;
			finderArgs = new Object[] { userId, rating };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERIDRATING;
			finderArgs = new Object[] {
					userId, rating,
					
					start, end, orderByComparator
				};
		}

		List<Wishlist> list = (List<Wishlist>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WISHLIST_WHERE);

			query.append(_FINDER_COLUMN_BYUSERIDRATING_USERID_2);

			query.append(_FINDER_COLUMN_BYUSERIDRATING_RATING_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(rating);

				list = (List<Wishlist>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Wishlist findByByUserIdRating_First(long userId, int rating,
		OrderByComparator orderByComparator)
		throws NoSuchWishlistException, SystemException {
		List<Wishlist> list = findByByUserIdRating(userId, rating, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", rating=");
			msg.append(rating);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchWishlistException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Wishlist findByByUserIdRating_Last(long userId, int rating,
		OrderByComparator orderByComparator)
		throws NoSuchWishlistException, SystemException {
		int count = countByByUserIdRating(userId, rating);

		List<Wishlist> list = findByByUserIdRating(userId, rating, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", rating=");
			msg.append(rating);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchWishlistException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Wishlist[] findByByUserIdRating_PrevAndNext(long wishlistId,
		long userId, int rating, OrderByComparator orderByComparator)
		throws NoSuchWishlistException, SystemException {
		Wishlist wishlist = findByPrimaryKey(wishlistId);

		Session session = null;

		try {
			session = openSession();

			Wishlist[] array = new WishlistImpl[3];

			array[0] = getByByUserIdRating_PrevAndNext(session, wishlist,
					userId, rating, orderByComparator, true);

			array[1] = wishlist;

			array[2] = getByByUserIdRating_PrevAndNext(session, wishlist,
					userId, rating, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Wishlist getByByUserIdRating_PrevAndNext(Session session,
		Wishlist wishlist, long userId, int rating,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WISHLIST_WHERE);

		query.append(_FINDER_COLUMN_BYUSERIDRATING_USERID_2);

		query.append(_FINDER_COLUMN_BYUSERIDRATING_RATING_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(rating);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wishlist);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Wishlist> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the wishlists where rating = &#63;.
	 *
	 * @param rating the rating
	 * @return the matching wishlists
	 * @throws SystemException if a system exception occurred
	 */
	public List<Wishlist> findByByRating(int rating) throws SystemException {
		return findByByRating(rating, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Wishlist> findByByRating(int rating, int start, int end)
		throws SystemException {
		return findByByRating(rating, start, end, null);
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
	public List<Wishlist> findByByRating(int rating, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYRATING;
			finderArgs = new Object[] { rating };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYRATING;
			finderArgs = new Object[] { rating, start, end, orderByComparator };
		}

		List<Wishlist> list = (List<Wishlist>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_WISHLIST_WHERE);

			query.append(_FINDER_COLUMN_BYRATING_RATING_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rating);

				list = (List<Wishlist>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Wishlist findByByRating_First(int rating,
		OrderByComparator orderByComparator)
		throws NoSuchWishlistException, SystemException {
		List<Wishlist> list = findByByRating(rating, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("rating=");
			msg.append(rating);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchWishlistException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Wishlist findByByRating_Last(int rating,
		OrderByComparator orderByComparator)
		throws NoSuchWishlistException, SystemException {
		int count = countByByRating(rating);

		List<Wishlist> list = findByByRating(rating, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("rating=");
			msg.append(rating);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchWishlistException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Wishlist[] findByByRating_PrevAndNext(long wishlistId, int rating,
		OrderByComparator orderByComparator)
		throws NoSuchWishlistException, SystemException {
		Wishlist wishlist = findByPrimaryKey(wishlistId);

		Session session = null;

		try {
			session = openSession();

			Wishlist[] array = new WishlistImpl[3];

			array[0] = getByByRating_PrevAndNext(session, wishlist, rating,
					orderByComparator, true);

			array[1] = wishlist;

			array[2] = getByByRating_PrevAndNext(session, wishlist, rating,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Wishlist getByByRating_PrevAndNext(Session session,
		Wishlist wishlist, int rating, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WISHLIST_WHERE);

		query.append(_FINDER_COLUMN_BYRATING_RATING_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rating);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wishlist);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Wishlist> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the wishlists.
	 *
	 * @return the wishlists
	 * @throws SystemException if a system exception occurred
	 */
	public List<Wishlist> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Wishlist> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Wishlist> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Wishlist> list = (List<Wishlist>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WISHLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WISHLIST;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Wishlist>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Wishlist>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the wishlists where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByByUserId(long userId) throws SystemException {
		for (Wishlist wishlist : findByByUserId(userId)) {
			remove(wishlist);
		}
	}

	/**
	 * Removes all the wishlists where userId = &#63; and rating = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param rating the rating
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByByUserIdRating(long userId, int rating)
		throws SystemException {
		for (Wishlist wishlist : findByByUserIdRating(userId, rating)) {
			remove(wishlist);
		}
	}

	/**
	 * Removes all the wishlists where rating = &#63; from the database.
	 *
	 * @param rating the rating
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByByRating(int rating) throws SystemException {
		for (Wishlist wishlist : findByByRating(rating)) {
			remove(wishlist);
		}
	}

	/**
	 * Removes all the wishlists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Wishlist wishlist : findAll()) {
			remove(wishlist);
		}
	}

	/**
	 * Returns the number of wishlists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching wishlists
	 * @throws SystemException if a system exception occurred
	 */
	public int countByByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYUSERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WISHLIST_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYUSERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of wishlists where userId = &#63; and rating = &#63;.
	 *
	 * @param userId the user ID
	 * @param rating the rating
	 * @return the number of matching wishlists
	 * @throws SystemException if a system exception occurred
	 */
	public int countByByUserIdRating(long userId, int rating)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, rating };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYUSERIDRATING,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WISHLIST_WHERE);

			query.append(_FINDER_COLUMN_BYUSERIDRATING_USERID_2);

			query.append(_FINDER_COLUMN_BYUSERIDRATING_RATING_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(rating);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYUSERIDRATING,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of wishlists where rating = &#63;.
	 *
	 * @param rating the rating
	 * @return the number of matching wishlists
	 * @throws SystemException if a system exception occurred
	 */
	public int countByByRating(int rating) throws SystemException {
		Object[] finderArgs = new Object[] { rating };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYRATING,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WISHLIST_WHERE);

			query.append(_FINDER_COLUMN_BYRATING_RATING_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rating);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYRATING,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of wishlists.
	 *
	 * @return the number of wishlists
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WISHLIST);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the wishlist persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.mal.projectaladdin.model.Wishlist")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Wishlist>> listenersList = new ArrayList<ModelListener<Wishlist>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Wishlist>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(WishlistImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = CategoryWishlistPersistence.class)
	protected CategoryWishlistPersistence categoryWishlistPersistence;
	@BeanReference(type = WishPersistence.class)
	protected WishPersistence wishPersistence;
	@BeanReference(type = WishlistPersistence.class)
	protected WishlistPersistence wishlistPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_WISHLIST = "SELECT wishlist FROM Wishlist wishlist";
	private static final String _SQL_SELECT_WISHLIST_WHERE = "SELECT wishlist FROM Wishlist wishlist WHERE ";
	private static final String _SQL_COUNT_WISHLIST = "SELECT COUNT(wishlist) FROM Wishlist wishlist";
	private static final String _SQL_COUNT_WISHLIST_WHERE = "SELECT COUNT(wishlist) FROM Wishlist wishlist WHERE ";
	private static final String _FINDER_COLUMN_BYUSERID_USERID_2 = "wishlist.userId = ?";
	private static final String _FINDER_COLUMN_BYUSERIDRATING_USERID_2 = "wishlist.userId = ? AND ";
	private static final String _FINDER_COLUMN_BYUSERIDRATING_RATING_2 = "wishlist.rating = ?";
	private static final String _FINDER_COLUMN_BYRATING_RATING_2 = "wishlist.rating = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wishlist.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Wishlist exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Wishlist exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WishlistPersistenceImpl.class);
	private static Wishlist _nullWishlist = new WishlistImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Wishlist> toCacheModel() {
				return _nullWishlistCacheModel;
			}
		};

	private static CacheModel<Wishlist> _nullWishlistCacheModel = new CacheModel<Wishlist>() {
			public Wishlist toEntityModel() {
				return _nullWishlist;
			}
		};
}