package com.sds.ppty.dao.mybatis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SDSMyBatisTemplateImpl implements SDSMyBatisTemplate{
	
	private SDSMyBatisConfigurator myBatisConfigurator;

	private SqlSessionFactory factory;
	
	private SqlSession batchSQLSession;
    /**
     * Initialiaze sql session factory object from configurator
     */
	public void initialize() {
		if (myBatisConfigurator == null) {			
			
		}
		this.factory = this.myBatisConfigurator.getFactory();
	}

	public void setMyBatisConfigurator(SDSMyBatisConfigurator myBatisConfigurator) {
		this.myBatisConfigurator = myBatisConfigurator;
	}


	public Object queryForObject(String sqlMapStatementId) {
		SqlSession session = null ;
		Object result=null;
		try {
			session = this.factory.openSession() ;
			result=  session.selectOne(sqlMapStatementId);
		} 
		catch (PersistenceException ex){			
			throw ex;
		}
		catch (Exception ex) {
			
			ex.printStackTrace();
		} 
		finally {
			session.close();
		}
		return result;
	}


	public Object queryForObject(String sqlMapStatementId, Object parameterObject) {
		SqlSession session = null ;
		Object result=null;
		try {
			session = this.factory.openSession() ;
			result = session.selectOne(sqlMapStatementId, parameterObject);			
		} 
		catch (PersistenceException ex){
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
				session.close();
		}
		return result;
	}	

	public List queryForList(String sqlMapStatementId) {
		SqlSession session = null ;
		List result=null;
		try {			
			session = this.factory.openSession() ;			
			result = session.selectList(sqlMapStatementId);
		} 
		catch (PersistenceException ex){
			
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public List queryForList(String sqlMapStatementId, Object parameterObject) {
		SqlSession session = null ;
		List result = null;
		try {
			
			session = this.factory.openSession() ;			
			result = session.selectList(sqlMapStatementId, parameterObject);
		} 
		catch (PersistenceException ex){			
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public List queryForList(String sqlMapStatementId, int skip, int max) {
		SqlSession session = null ;
		List result = null;
		try {
			session = this.factory.openSession() ;
			RowBounds rowBounds = new RowBounds(skip, max);
			result = session.selectList(sqlMapStatementId, null , rowBounds);
		} 
		catch (PersistenceException ex){
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public List queryForList( String sqlMapStatementId, Object parameterObject,
							  int skip, int max) {
		SqlSession session = null ;
		List result = null;
		try {
			session = this.factory.openSession() ;
			RowBounds rowBounds = new RowBounds(skip, max);
			result = session.selectList(sqlMapStatementId, parameterObject, rowBounds);
		} 
		catch (PersistenceException ex){
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}	

	public List queryPaginatedList(	String sqlMapStatementId, int startIndex,
									int sizeOfAPage, int numOfPages) {
		return queryForList(sqlMapStatementId, (startIndex * sizeOfAPage),
				(numOfPages * sizeOfAPage));
	}

	public List queryPaginatedList(	String sqlMapStatementId, int startIndex,
									int sizeOfAPage, int numOfPages, java.lang.Object parameterObject) {
		return queryForList(sqlMapStatementId, parameterObject,
				(startIndex * sizeOfAPage), (numOfPages * sizeOfAPage));
	}	

	public Map queryForMap( String sqlMapStatementId, Object parameterObject,
							String keyProperties) {
		SqlSession session = null ;
		Map<Object, Object> result = null;
		try {
			session = this.factory.openSession() ;
			result = session.selectMap(sqlMapStatementId, parameterObject, keyProperties);
		} 
		catch (PersistenceException ex){
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public Map queryForMap(	String sqlMapStatementId, Object parameterObject,
							String keyProperties, String valueProperties) {		
		Map keyValueMap = new HashMap();
		Map queryMap  = this.queryForMap(sqlMapStatementId, parameterObject, keyProperties) ;
		Set keySet = queryMap.keySet() ;
		Iterator it = keySet.iterator();
		while(it.hasNext()) {
			Object keyObj = it.next();
			MetaObject mo = MetaObject.forObject(queryMap.get(keyObj),
													SystemMetaObject.DEFAULT_OBJECT_FACTORY,
													SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
			Object valueObj = mo.getValue(valueProperties);
			keyValueMap.put(keyObj, valueObj);		
		}		
		return keyValueMap;
		
	}	
	
	
	public int insert(String sqlMapStatementId) {
		SqlSession session = null ;
		int result=-1;
		try {
			session = this.factory.openSession() ;
			result =  session.insert(sqlMapStatementId);
		} 
		catch (PersistenceException ex){
			
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public int insert(String sqlMapStatementId, Object parameterObject) {
		SqlSession session = null ;
		int result = -1;
		try {
			session = this.factory.openSession() ;
			return session.insert(sqlMapStatementId, parameterObject);
		} 
		catch (PersistenceException ex){
			
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public int update(String sqlMapStatementId) {
		SqlSession session = null ;
		int result = -1;
		try {
			session = this.factory.openSession();
			result = session.update(sqlMapStatementId);			
		} 
		catch (PersistenceException ex){
			
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}


	public int update(String sqlMapStatementId, Object parameterObject) {
		SqlSession session = null ;
		int result = -1;
		try {
			session = this.factory.openSession();
			result = session.update(sqlMapStatementId, parameterObject);
		} 
		catch (PersistenceException ex){
			
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	public int delete(String sqlMapStatementId) {
		SqlSession session = null ;
		int result = -1;
		try {
			session = this.factory.openSession();			
			result =  session.delete(sqlMapStatementId);
		} 
		catch (PersistenceException ex){
			
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public int delete(String sqlMapStatementId, Object parameterObject) {
		SqlSession session = null ;
		int result = -1;
		try {
			 session = this.factory.openSession();
			 result =  session.delete(sqlMapStatementId, parameterObject);
		} 
		catch (PersistenceException ex){
			
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}	
}
