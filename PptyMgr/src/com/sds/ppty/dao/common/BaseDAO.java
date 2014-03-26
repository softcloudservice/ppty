package com.sds.ppty.dao.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sds.ppty.dao.mybatis.SDSMyBatisTemplate;

@Repository("baseDAO")
public class BaseDAO {

	@Autowired
	@Qualifier("SDSMyBatisTemplate")
	private SDSMyBatisTemplate template;

	public SDSMyBatisTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SDSMyBatisTemplate template) {
		this.template = template;
	}
	
	/**
	 * @param id ;
	 *            this is the ID of the statement in sqlmap file.
	 * @return number of rows that were updated
	 * @throws DAOException
	 * @modelguid {C28B477A-B24F-485C-9036-70CA884B3BCC}
	 */
	public int update(java.lang.String id) // throws DAOException
	{
		try
		{
			int numOfRecordsUpdated = 0;
			numOfRecordsUpdated = this.getTemplate().update(id);
			return numOfRecordsUpdated;
		}
		catch (SDSSystemException  tdae)
		{
			throw tdae;
		}
	}

	/**
	 * @param id ;
	 *            this is the ID of the statement in sqlmap file.
	 * @param parameterObject ;
	 *            This is the input VO which has the fields that will be used in
	 *            the where clause of the stmt.
	 * @return number of rows that were updated
	 * @throws DAOException
	 * @modelguid {6241C86D-4EEF-4BBF-9096-86BE0B53DC27}
	 */
	public int update(java.lang.String id, java.lang.Object parameterObject) // throws
																				// DAOException
	{
		try
		{
			int numOfRecordsUpdated = 0;
			numOfRecordsUpdated = this.getTemplate()
			        .update(id, parameterObject);
			return numOfRecordsUpdated;
		}
		catch (SDSSystemException  tdae)
		{
			throw tdae;
		}
	}

	/**
	 * @param id ;
	 *            this is the ID of the statement in sqlmap file.
	 * @return ; The inserted Object with its PK value filled.
	 * @throws DAOException
	 * @modelguid {DD3999DA-EF96-4DE9-B561-BCECCC33AEC4}
	 */
	public java.lang.Object insert(java.lang.String id) // throws DAOException
	{
		try
		{
			// objInserted has the PK of the inserted object
			Object objInserted = null;
			objInserted = this.getTemplate().insert(id);
			return objInserted;
		}
		catch (SDSSystemException  tdae)
		{
			throw tdae;
		}
	}

	/**
	 * @param id ;
	 *            this is the ID of the statement in sqlmap file.
	 * @param parameterObject ;
	 *            This is the input VO which has the fields that will be used in
	 *            the where clause of the stmt.
	 * @return ; The inserted Object with its PK value filled.
	 * @throws DAOException
	 * @modelguid {D0211664-A577-4431-B660-ADFA9698DBB3}
	 */
	public java.lang.Object insert(java.lang.String id,
	        java.lang.Object parameterObject) // throws DAOException
	{
		try
		{
			// objInserted has the PK of the inserted object
			Object objInserted = null;
			objInserted = this.getTemplate().insert(id, parameterObject);
			return objInserted;
		}
		catch (SDSSystemException  tdae)
		{
			throw tdae;
		}

	}

	/**
	 * @param id ;
	 *            this is the ID of the statement in sqlmap file.
	 * @return ; The number of rows that were deleted.
	 * @throws DAOException
	 */
	/**
	 * @param id
	 * @return
	 * @throws DAOException
	 * @modelguid {B9C4BCCF-FD20-4745-90AB-8F5A2CC91019}
	 */
	public int delete(java.lang.String id) // throws DAOException
	{
		try
		{
			int numOfRowsDeleted = 0;
			numOfRowsDeleted = this.getTemplate().delete(id);
			return numOfRowsDeleted;
		}
		catch (SDSSystemException  tdae)
		{
			throw tdae;
		}

	}

	/**
	 * @param id;
	 *            this is the ID of the statement in sqlmap file.
	 * @param parameterObject;
	 *            This is the input VO which has the fields that will be used in
	 *            the where clause of the stmt.
	 * @return; the number of rows that were deleted.
	 * @throws DAOException
	 * @modelguid {CFACF619-C7C6-49C7-A2C1-32B9EA5A0B0E}
	 */
	public int delete(java.lang.String id, java.lang.Object parameterObject) // throws
																				// DAOException
	{
		try
		{
			int numOfRowsDeleted = 0;
			numOfRowsDeleted = this.getTemplate().delete(id, parameterObject);
			return numOfRowsDeleted;
		}
		catch (SDSSystemException  tdae)
		{
			throw tdae;
		}
	}

	/**
	 * @param id;
	 *            this is the ID of the statement in sqlmap file.
	 * @return; A List of Objects returned after executing the query. The
	 *          Objects in the list are of type as mapped in the sqlmap file.
	 *          The properties are filled with the column names as mapped in
	 *          sqlmap file.
	 * @throws DAOException
	 * @modelguid {846147F1-6C55-4E9B-BBB2-6ADE88F3AA03}
	 */
	public java.util.List queryForList(java.lang.String id) // throws
															// DAOException
	{
		try
		{
			List listOfQueriedObjects = null;
			listOfQueriedObjects = this.getTemplate().queryForList(id);
			return listOfQueriedObjects;
		}
		catch (SDSSystemException  tdae)
		{
			throw tdae;
		}
	}

	/**
	 * @param id;
	 *            this is the ID of the statement in sqlmap file.
	 * @param parameterObject;
	 *            This is the input VO which has the fields that will be used in
	 *            the where clause of the stmt.
	 * @return A List of Objects returned after executing the query. The Objects
	 *         in the list are of type as mapped in the sqlmap file. The
	 *         properties are filled with the column names as mapped in sqlmap
	 *         file.
	 * @throws DAOException
	 * @modelguid {CED9F505-D753-423F-ABC2-7BDB74729BC4}
	 */
	public java.util.List queryForList(java.lang.String id,
	        java.lang.Object parameterObject) // throws DAOException
	{
		try
		{
			List listOfQueriedObjects = null;
			listOfQueriedObjects = this.getTemplate().queryForList(id,
			        parameterObject);
			return listOfQueriedObjects;
		}
		catch (SDSSystemException  tdae)
		{
			throw tdae;
		}
	}

	/** @modelguid {8033FC74-4044-498C-AF98-54EEBDC5CC2E} */
	public java.util.List queryForList(java.lang.String id, int skip, int max) // throws
																				// DAOException
	{
		try
		{
			List listOfQueriedObjects = null;
			listOfQueriedObjects = this.getTemplate().queryForList(id, skip,
			        max);
			return listOfQueriedObjects;
		}
		catch (SDSSystemException  tdae)
		{
			throw tdae;
		}
	}

	/** @modelguid {9916E377-4A6E-4BC4-A320-3C7DA33A3C22} */
	public java.util.List queryForList(java.lang.String id,
	        java.lang.Object parameterObject, int skip, int max) // throws
																	// DAOException
	{
		try
		{
			List listOfQueriedObjects = null;
			listOfQueriedObjects = this.getTemplate().queryForList(id,
			        parameterObject, skip, max);
			return listOfQueriedObjects;
		}
		catch (SDSSystemException  tdae)
		{
			throw tdae;
		}
	}

	/**
	 * @param id;this
	 *            is the ID of the statement in sqlmap file.
	 * @return
	 * @throws DAOException
	 * @modelguid {BB84C08F-5502-40BD-A4BE-A52B63BD23FB}
	 */
	public java.lang.Object queryForObject(java.lang.String id) // throws
																// DAOException
	{
		try
		{
			Object queriedObj = null;
			queriedObj = this.getTemplate().queryForObject(id);
			return queriedObj;
		}
		catch (SDSSystemException  tdae)
		{
			throw tdae;
		}
	}

	/** @modelguid {FFEEF1F9-1897-4451-88EC-17046597938F} */
	public java.lang.Object queryForObject(java.lang.String id,
	        java.lang.Object parameterObject) // throws DAOException
	{
		try
		{
			Object queriedObj = null;
			queriedObj = this.getTemplate().queryForObject(id, parameterObject);
			return queriedObj;
		}
		catch (SDSSystemException  tdae)
		{
			throw tdae;
		}
	}

}
