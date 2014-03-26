package com.sds.ppty.dao.mybatis;

import java.util.List;
import java.util.Map;

public interface SDSMyBatisTemplate {
	public Object queryForObject(String sqlMapStatementId);

	public Object queryForObject(String sqlMapStatementId, Object parameterObject);

	public List queryForList(String sqlMapStatementId);

	public List queryForList(String sqlMapStatementId, Object parameterObject);

	public List queryForList(String sqlMapStatementId, int skip, int max);

	public List queryForList(String sqlMapStatementId, Object parameterObject, int skip, int max);

	public List queryPaginatedList(String sqlMapStatementId, int startIndex, int sizeOfAPage, int numOfPages);

	public List queryPaginatedList(java.lang.String id, int startIndex, int sizeOfAPage, int numOfPages, java.lang.Object parameterObject);
	
	public Map queryForMap(String sqlMapStatementId, Object parameterObject, String keyProperties);
	
	public Map queryForMap(String sqlMapStatementId, Object parameterObject, String keyProperties, String valueProperties);

	public int insert(String sqlMapStatementId);

	public int insert(String sqlMapStatementId, Object parameterObject);
	
	public int update(String sqlMapStatementId);

	public int update(String sqlMapStatementId, Object parameterObject);
	
	public int delete(String sqlMapStatementId);

	public int delete(String sqlMapStatementId, Object parameterObject);
}
