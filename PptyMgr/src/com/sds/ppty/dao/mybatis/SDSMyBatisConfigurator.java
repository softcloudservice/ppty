package com.sds.ppty.dao.mybatis;


import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

@Component
public class SDSMyBatisConfigurator {
	

	private String sqlMapConfigFilePath;

	private String sqlMapPropertiesFilePath;

	private final String DFLT_ENV_STRING = "LOCAL";

	private final String ENV_PLACEHOLDER_STRING = "${env}";

	private SqlSessionFactory factory = null;

	public SDSMyBatisConfigurator() {

	}

	public void setSqlMapConfigFilePath(String configFilePath) {
		this.sqlMapConfigFilePath = configFilePath;
	}

	public void setSqlMapPropertiesFilePath(String propertiesFilePath) {
		this.sqlMapPropertiesFilePath = propertiesFilePath;
	}	
	
	public void initialize() {
		try {
			String envString = System.getProperty("com.tgt.env");
			
			if (envString == null || envString.trim().equals("")) {
				envString = this.DFLT_ENV_STRING;
			}
			
			if (this.sqlMapConfigFilePath == null) {
				RuntimeException ex = new RuntimeException(
						"SDSMyBatisConfigurator : sqlMapConfigFilePath property is null");				
				throw ex;
			} 
			
			if (this.sqlMapConfigFilePath != null) {
				buildSqlSessionFactory(envString);
			} 
		} catch (Throwable ex) {
			throw new RuntimeException("Error Creating SqlSessionFactory", ex);
		}

	}

	private void buildSqlSessionFactory(String envString) throws IOException {
	
		Properties props = null;		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();		
		
		if (this.sqlMapPropertiesFilePath != null
				&& !this.sqlMapPropertiesFilePath.trim().equals("")) {			
			this.sqlMapPropertiesFilePath = this.sqlMapPropertiesFilePath
					.replace(this.ENV_PLACEHOLDER_STRING, envString).trim();
			props = Resources.getResourceAsProperties(this.sqlMapPropertiesFilePath);
		}

		Reader reader = Resources.getResourceAsReader(this.sqlMapConfigFilePath);
		if (props != null) {
			factory = builder.build(reader, envString, props);
		} else {
			factory = builder.build(reader, envString);
		}
	}

	public SqlSessionFactory getFactory() {
		return factory;
	}


}
