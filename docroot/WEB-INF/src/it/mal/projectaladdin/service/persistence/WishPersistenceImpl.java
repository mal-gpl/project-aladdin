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

import it.mal.projectaladdin.NoSuchWishException;
import it.mal.projectaladdin.model.Wish;
import it.mal.projectaladdin.model.impl.WishImpl;
import it.mal.projectaladdin.model.impl.WishModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the wish service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAL
 * @see WishPersistence
 * @see WishUtil
 * @generated
 */
public class WishPersistenceImpl extends BasePersistenceImpl<Wish>
	implements WishPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WishUtil} to access the wish persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WishImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYNAME = new FinderPath(WishModelImpl.ENTITY_CACHE_ENABLED,
			WishModelImpl.FINDER_CACHE_ENABLED, WishImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNAME =
		new FinderPath(WishModelImpl.ENTITY_CACHE_ENABLED,
			WishModelImpl.FINDER_CACHE_ENABLED, WishImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByName",
			new String[] { String.class.getName() },
			WishModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYNAME = new FinderPath(WishModelImpl.ENTITY_CACHE_ENABLED,
			WishModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WishModelImpl.ENTITY_CACHE_ENABLED,
			WishModelImpl.FINDER_CACHE_ENABLED, WishImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WishModelImpl.ENTITY_CACHE_ENABLED,
			WishModelImpl.FINDER_CACHE_ENABLED, WishImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WishModelImpl.ENTITY_CACHE_ENABLED,
			WishModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the wish in the entity cache if it is enabled.
	 *
	 * @param wish the wish
	 */
	public void cacheResult(Wish wish) {
		EntityCacheUtil.putResult(WishModelImpl.ENTITY_CACHE_ENABLED,
			WishImpl.class, wish.getPrimaryKey(), wish);

		wish.resetOriginalValues();
	}

	/**
	 * Caches the wishs in the entity cache if it is enabled.
	 *
	 * @param wishs the wishs
	 */
	public void cacheResult(List<Wish> wishs) {
		for (Wish wish : wishs) {
			if (EntityCacheUtil.getResult(WishModelImpl.ENTITY_CACHE_ENABLED,
						WishImpl.class, wish.getPrimaryKey()) == null) {
				cacheResult(wish);
			}
			else {
				wish.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all wishs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WishImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WishImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the wish.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Wish wish) {
		EntityCacheUtil.removeResult(WishModelImpl.ENTITY_CACHE_ENABLED,
			WishImpl.class, wish.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Wish> wishs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Wish wish : wishs) {
			EntityCacheUtil.removeResult(WishModelImpl.ENTITY_CACHE_ENABLED,
				WishImpl.class, wish.getPrimaryKey());
		}
	}

	/**
	 * Creates a new wish with the primary key. Does not add the wish to the database.
	 *
	 * @param wishId the primary key for the new wish
	 * @return the new wish
	 */
	public Wish create(long wishId) {
		Wish wish = new WishImpl();

		wish.setNew(true);
		wish.setPrimaryKey(wishId);

		return wish;
	}

	/**
	 * Removes the wish with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wishId the primary key of the wish
	 * @return the wish that was removed
	 * @throws it.mal.projectaladdin.NoSuchWishException if a wish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Wish remove(long wishId) throws NoSuchWishException, SystemException {
		return remove(Long.valueOf(wishId));
	}

	/**
	 * Removes the wish with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the wish
	 * @return the wish that was removed
	 * @throws it.mal.projectaladdin.NoSuchWishException if a wish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Wish remove(Serializable primaryKey)
		throws NoSuchWishException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Wish wish = (Wish)session.get(WishImpl.class, primaryKey);

			if (wish == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWishException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wish);
		}
		catch (NoSuchWishException nsee) {
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
	protected Wish removeImpl(Wish wish) throws SystemException {
		wish = toUnwrappedModel(wish);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, wish);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(wish);

		return wish;
	}

	@Override
	public Wish updateImpl(it.mal.projectaladdin.model.Wish wish, boolean merge)
		throws SystemException {
		wish = toUnwrappedModel(wish);

		boolean isNew = wish.isNew();

		WishModelImpl wishModelImpl = (WishModelImpl)wish;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, wish, merge);

			wish.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WishModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((wishModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { wishModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNAME,
					args);

				args = new Object[] { wishModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(WishModelImpl.ENTITY_CACHE_ENABLED,
			WishImpl.class, wish.getPrimaryKey(), wish);

		return wish;
	}

	protected Wish toUnwrappedModel(Wish wish) {
		if (wish instanceof WishImpl) {
			return wish;
		}

		WishImpl wishImpl = new WishImpl();

		wishImpl.setNew(wish.isNew());
		wishImpl.setPrimaryKey(wish.getPrimaryKey());

		wishImpl.setWishId(wish.getWishId());
		wishImpl.setName(wish.getName());
		wishImpl.setDescription(wish.getDescription());
		wishImpl.setPrice(wish.getPrice());
		wishImpl.setUrl(wish.getUrl());
		wishImpl.setImage(wish.getImage());
		wishImpl.setCreationDate(wish.getCreationDate());
		wishImpl.setModifiedDate(wish.getModifiedDate());

		return wishImpl;
	}

	/**
	 * Returns the wish with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the wish
	 * @return the wish
	 * @throws com.liferay.portal.NoSuchModelException if a wish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Wish findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the wish with the primary key or throws a {@link it.mal.projectaladdin.NoSuchWishException} if it could not be found.
	 *
	 * @param wishId the primary key of the wish
	 * @return the wish
	 * @throws it.mal.projectaladdin.NoSuchWishException if a wish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Wish findByPrimaryKey(long wishId)
		throws NoSuchWishException, SystemException {
		Wish wish = fetchByPrimaryKey(wishId);

		if (wish == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + wishId);
			}

			throw new NoSuchWishException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				wishId);
		}

		return wish;
	}

	/**
	 * Returns the wish with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wish
	 * @return the wish, or <code>null</code> if a wish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Wish fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the wish with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wishId the primary key of the wish
	 * @return the wish, or <code>null</code> if a wish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Wish fetchByPrimaryKey(long wishId) throws SystemException {
		Wish wish = (Wish)EntityCacheUtil.getResult(WishModelImpl.ENTITY_CACHE_ENABLED,
				WishImpl.class, wishId);

		if (wish == _nullWish) {
			return null;
		}

		if (wish == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				wish = (Wish)session.get(WishImpl.class, Long.valueOf(wishId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (wish != null) {
					cacheResult(wish);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WishModelImpl.ENTITY_CACHE_ENABLED,
						WishImpl.class, wishId, _nullWish);
				}

				closeSession(session);
			}
		}

		return wish;
	}

	/**
	 * Returns all the wishs where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching wishs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Wish> findByByName(String name) throws SystemException {
		return findByByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Wish> findByByName(String name, int start, int end)
		throws SystemException {
		return findByByName(name, start, end, null);
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
	public List<Wish> findByByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYNAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Wish> list = (List<Wish>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_WISH_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_BYNAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BYNAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_BYNAME_NAME_2);
				}
			}

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

				if (name != null) {
					qPos.add(name);
				}

				list = (List<Wish>)QueryUtil.list(q, getDialect(), start, end);
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
	public Wish findByByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchWishException, SystemException {
		List<Wish> list = findByByName(name, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchWishException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Wish findByByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchWishException, SystemException {
		int count = countByByName(name);

		List<Wish> list = findByByName(name, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchWishException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Wish[] findByByName_PrevAndNext(long wishId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchWishException, SystemException {
		Wish wish = findByPrimaryKey(wishId);

		Session session = null;

		try {
			session = openSession();

			Wish[] array = new WishImpl[3];

			array[0] = getByByName_PrevAndNext(session, wish, name,
					orderByComparator, true);

			array[1] = wish;

			array[2] = getByByName_PrevAndNext(session, wish, name,
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

	protected Wish getByByName_PrevAndNext(Session session, Wish wish,
		String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WISH_WHERE);

		if (name == null) {
			query.append(_FINDER_COLUMN_BYNAME_NAME_1);
		}
		else {
			if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYNAME_NAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_BYNAME_NAME_2);
			}
		}

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

		if (name != null) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wish);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Wish> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the wishs.
	 *
	 * @return the wishs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Wish> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Wish> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Wish> findAll(int start, int end,
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

		List<Wish> list = (List<Wish>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WISH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WISH;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Wish>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Wish>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the wishs where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByByName(String name) throws SystemException {
		for (Wish wish : findByByName(name)) {
			remove(wish);
		}
	}

	/**
	 * Removes all the wishs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Wish wish : findAll()) {
			remove(wish);
		}
	}

	/**
	 * Returns the number of wishs where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching wishs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WISH_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_BYNAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BYNAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_BYNAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of wishs.
	 *
	 * @return the number of wishs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WISH);

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
	 * Initializes the wish persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.mal.projectaladdin.model.Wish")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Wish>> listenersList = new ArrayList<ModelListener<Wish>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Wish>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WishImpl.class.getName());
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
	private static final String _SQL_SELECT_WISH = "SELECT wish FROM Wish wish";
	private static final String _SQL_SELECT_WISH_WHERE = "SELECT wish FROM Wish wish WHERE ";
	private static final String _SQL_COUNT_WISH = "SELECT COUNT(wish) FROM Wish wish";
	private static final String _SQL_COUNT_WISH_WHERE = "SELECT COUNT(wish) FROM Wish wish WHERE ";
	private static final String _FINDER_COLUMN_BYNAME_NAME_1 = "wish.name IS NULL";
	private static final String _FINDER_COLUMN_BYNAME_NAME_2 = "wish.name = ?";
	private static final String _FINDER_COLUMN_BYNAME_NAME_3 = "(wish.name IS NULL OR wish.name = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wish.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Wish exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Wish exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WishPersistenceImpl.class);
	private static Wish _nullWish = new WishImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Wish> toCacheModel() {
				return _nullWishCacheModel;
			}
		};

	private static CacheModel<Wish> _nullWishCacheModel = new CacheModel<Wish>() {
			public Wish toEntityModel() {
				return _nullWish;
			}
		};
}