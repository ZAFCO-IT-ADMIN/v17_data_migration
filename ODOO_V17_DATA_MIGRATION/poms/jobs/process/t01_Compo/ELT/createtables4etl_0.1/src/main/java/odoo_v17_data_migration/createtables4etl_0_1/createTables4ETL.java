
package odoo_v17_data_migration.createtables4etl_0_1;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.Relational;
import routines.GetRandomPhoneNum;
import routines.Mathematical;
import routines.SQLike;
import routines.Numeric;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.MDM;
import routines.StringHandling;
import routines.DemoRoutines;
import routines.TalendDate;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: createTables4ETL Purpose: <br>
 * Description:  <br>
 * @author training@talend.com
 * @version 8.0.1.20241203_0647-patch
 * @status 
 */
public class createTables4ETL implements TalendJob {
	static {System.setProperty("TalendJob.log", "createTables4ETL.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(createTables4ETL.class);
	

protected static void logIgnoredError(String message, Throwable cause) {
       log.error(message, cause);

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";

	public static String taskExecutionId = null;

	public static String jobExecutionId = java.util.UUID.randomUUID().toString();;
	

	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
		

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(id != null){
				
					this.setProperty("id", id.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

public Integer id;
public Integer getId(){
	return this.id;
}
	}
			
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}

	protected java.util.Map<String, String> defaultProperties = new java.util.HashMap<String, String>();
	protected java.util.Map<String, String> additionalProperties = new java.util.HashMap<String, String>();

	public java.util.Map<String, String> getDefaultProperties() {
	    return this.defaultProperties;
	}

	public java.util.Map<String, String> getAdditionalProperties() {
        return this.additionalProperties;
    }

	private final String jobVersion = "0.1";
	private final String jobName = "createTables4ETL";
	private final String projectName = "ODOO_V17_DATA_MIGRATION";
	public Integer errorCode = null;
	private String currentComponent = "";
	public static boolean isStandaloneMS = Boolean.valueOf("false");
	
	private void s(final String component) {
		try {
			org.talend.metrics.DataReadTracker.setCurrentComponent(jobName, component);
		} catch (Exception | NoClassDefFoundError e) {
			// ignore
		}
	}
	
	
	private void mdc(final String subJobName, final String subJobPidPrefix) {
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", subJobName);
		org.slf4j.MDC.put("_subJobPid", subJobPidPrefix + subJobPidCounter.getAndIncrement());
	}
	
	
	private void sh(final String componentId) {
		ok_Hash.put(componentId, false);
		start_Hash.put(componentId, System.currentTimeMillis());
	}

	{
	s("none");
	}

	
	private String cLabel =  null;
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_2XZNsOgjEduQrK0t1cU9cw", "0.1");
private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	
	private String currentComponent = null;
	private String cLabel =  null;
	
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}
	
	private TalendException(Exception e, String errorComponent, String errorComponentLabel, final java.util.Map<String, Object> globalMap) {
		this(e, errorComponent, globalMap);
		this.cLabel = errorComponentLabel;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				createTables4ETL.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(createTables4ETL.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
		if(enableLogStash) {
			talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
			talendJobLogProcess(globalMap);
		}
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tCreateTable_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tCreateTable_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRowGenerator_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tUniqRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMysqlOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tCreateTable_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRowGenerator_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void talendJobLog_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	



public void tCreateTable_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tCreateTable_1_SUBPROCESS_STATE", 0);

	final boolean execStat = this.execStat;

		mdc("tCreateTable_1", "a7LvtR_");

	
		String iterateId = "";
	
	
	String currentComponent = "";
	s("none");
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tCreateTable_1 begin ] start
	 */

	

	
		
		sh("tCreateTable_1");
		
	
	s(currentComponent="tCreateTable_1");
	
			
			
	
			cLabel="tCreateTable_1 \"results\"";
		
		int tos_count_tCreateTable_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tCreateTable_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tCreateTable_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tCreateTable_1 = new StringBuilder();
                    log4jParamters_tCreateTable_1.append("Parameters:");
                            log4jParamters_tCreateTable_1.append("DBTYPE" + " = " + "MYSQL");
                        log4jParamters_tCreateTable_1.append(" | ");
                            log4jParamters_tCreateTable_1.append("TABLEACTION" + " = " + "DROP_IF_EXIST_CREATE");
                        log4jParamters_tCreateTable_1.append(" | ");
                            log4jParamters_tCreateTable_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tCreateTable_1.append(" | ");
                            log4jParamters_tCreateTable_1.append("HOST" + " = " + "\"localhost\"");
                        log4jParamters_tCreateTable_1.append(" | ");
                            log4jParamters_tCreateTable_1.append("DBNAME" + " = " + "\"demoproject\"");
                        log4jParamters_tCreateTable_1.append(" | ");
                            log4jParamters_tCreateTable_1.append("USER" + " = " + "\"root\"");
                        log4jParamters_tCreateTable_1.append(" | ");
                            log4jParamters_tCreateTable_1.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:0W8UaCFPx4NMaZTg/BxPdqsxp279PD2gUHSxd8pc5g0=").substring(0, 4) + "...");     
                        log4jParamters_tCreateTable_1.append(" | ");
                            log4jParamters_tCreateTable_1.append("PORT" + " = " + "\"3306\"");
                        log4jParamters_tCreateTable_1.append(" | ");
                            log4jParamters_tCreateTable_1.append("TEMPTABLE" + " = " + "false");
                        log4jParamters_tCreateTable_1.append(" | ");
                            log4jParamters_tCreateTable_1.append("DB_MYSQL_VERSION" + " = " + "MYSQL_5");
                        log4jParamters_tCreateTable_1.append(" | ");
                            log4jParamters_tCreateTable_1.append("TABLE" + " = " + "\"results\"");
                        log4jParamters_tCreateTable_1.append(" | ");
                            log4jParamters_tCreateTable_1.append("PROPERTIES" + " = " + "\"\"");
                        log4jParamters_tCreateTable_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tCreateTable_1 - "  + (log4jParamters_tCreateTable_1) );
                    } 
                } 
            new BytesLimit65535_tCreateTable_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tCreateTable_1", "tCreateTable_1 \"results\"", "tCreateTable");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

 



		

/**
 * [tCreateTable_1 begin ] stop
 */

	
	/**
	 * [tCreateTable_1 main ] start
	 */

	

	
	
	s(currentComponent="tCreateTable_1");
	
			
			
	
			cLabel="tCreateTable_1 \"results\"";
		

    try{
                
                String driverClass_tCreateTable_1 = "com.mysql.jdbc.Driver";
                
        String url_tCreateTable_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "demoproject";
                
                String dbUser_tCreateTable_1 = "root";
	    		log.debug("tCreateTable_1 - Driver ClassName: "+driverClass_tCreateTable_1+".");
			
        
	    		log.debug("tCreateTable_1 - Connection attempt to '" + url_tCreateTable_1 + "' with the username '" + dbUser_tCreateTable_1 + "'.");
			String tableName_tCreateTable_1 = "results";
java.lang.Class jdbcclazz_tCreateTable_1= java.lang.Class.forName("com.mysql.jdbc.Driver");
final String decryptedPassword_tCreateTable_1= routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:hjW/bMWSTLP4rUcniKf4oQGlvLITpOCJFxPMdRS+hzw=");
java.sql.Connection conn_tCreateTable_1= java.sql.DriverManager.getConnection(url_tCreateTable_1,dbUser_tCreateTable_1, decryptedPassword_tCreateTable_1);

	    		log.debug("tCreateTable_1 - Connection to '" + url_tCreateTable_1 + "' has succeeded.");
			
            boolean whetherExist_tCreateTable_1 = false;
                java.sql.DatabaseMetaData dbMetaData_tCreateTable_1 = conn_tCreateTable_1.getMetaData();
                java.sql.ResultSet rsTable_tCreateTable_1 = dbMetaData_tCreateTable_1.getTables("demoproject", null, null, new String[]{"TABLE"});
                while(rsTable_tCreateTable_1.next()) {
                    String table_tCreateTable_1 = rsTable_tCreateTable_1.getString("TABLE_NAME");
                    if(table_tCreateTable_1.equalsIgnoreCase("results")) {
                        whetherExist_tCreateTable_1 = true;
                        break;
                    }
                }  
            rsTable_tCreateTable_1.close();
                if(whetherExist_tCreateTable_1) {
                    java.sql.Statement stmtDrop_tCreateTable_1 = conn_tCreateTable_1.createStatement();
                        log.info("tCreateTable_1 - Droping table '" + tableName_tCreateTable_1 + "'.");
                    stmtDrop_tCreateTable_1.execute("DROP TABLE `" + tableName_tCreateTable_1 + "`");
                        log.info("tCreateTable_1 - Drop table '" + tableName_tCreateTable_1 + "' has succeeded.");
                }
                java.sql.Statement stmt_tCreateTable_1 = conn_tCreateTable_1.createStatement();
                    log.info("tCreateTable_1 - Creating table '" + tableName_tCreateTable_1 + "'.");
                stmt_tCreateTable_1.execute("CREATE TABLE `" + tableName_tCreateTable_1 + "`(`ID` INT(11)  ,`NAME` VARCHAR(50)  ,`ID_MANAGER` INT(11)  ,`NAME_MANAGER` VARCHAR(50)  )"); 
                    log.info("tCreateTable_1 - Create table '" + tableName_tCreateTable_1 + "' has succeeded.");
	            
	    		log.debug("tCreateTable_1 - Closing the connection to the database.");
			
            if(conn_tCreateTable_1 != null && !conn_tCreateTable_1.isClosed()) {
conn_tCreateTable_1.close();
}

	    		log.debug("tCreateTable_1 - Connection to the database closed.");
			
        globalMap.put("tCreateTable_1_QUERY", "CREATE TABLE `" + tableName_tCreateTable_1 + "`(`ID` INT(11)  ,`NAME` VARCHAR(50)  ,`ID_MANAGER` INT(11)  ,`NAME_MANAGER` VARCHAR(50)  )");        
    } catch(java.lang.Exception e) {
        globalMap.put("tCreateTable_1_ERROR_MESSAGE",e.getMessage());
        throw new RuntimeException("Creating table failed", e);
    }


 


	tos_count_tCreateTable_1++;

		

/**
 * [tCreateTable_1 main ] stop
 */

	
	/**
	 * [tCreateTable_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tCreateTable_1");
	
			
			
	
			cLabel="tCreateTable_1 \"results\"";
		

 



		

/**
 * [tCreateTable_1 process_data_begin ] stop
 */

	
	/**
	 * [tCreateTable_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tCreateTable_1");
	
			
			
	
			cLabel="tCreateTable_1 \"results\"";
		

 



		

/**
 * [tCreateTable_1 process_data_end ] stop
 */

	
	/**
	 * [tCreateTable_1 end ] start
	 */

	

	
	
	s(currentComponent="tCreateTable_1");
	
			
			
	
			cLabel="tCreateTable_1 \"results\"";
		

 
                if(log.isDebugEnabled())
            log.debug("tCreateTable_1 - "  + ("Done.") );

ok_Hash.put("tCreateTable_1", true);
end_Hash.put("tCreateTable_1", System.currentTimeMillis());




		

/**
 * [tCreateTable_1 end ] stop
 */

				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tCreateTable_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk16", 0, "ok");
								} 
							
							tRowGenerator_1Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tCreateTable_1 finally ] start
	 */

	

	
	
	s(currentComponent="tCreateTable_1");
	
			
			
	
			cLabel="tCreateTable_1 \"results\"";
		

 



		

/**
 * [tCreateTable_1 finally ] stop
 */

				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tCreateTable_1_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_ODOO_V17_DATA_MIGRATION_createTables4ETL = new byte[0];
    static byte[] commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL = new byte[0];

	
			    public int ID;

				public int getID () {
					return this.ID;
				}

				public Boolean IDIsNullable(){
				    return false;
				}
				public Boolean IDIsKey(){
				    return false;
				}
				public Integer IDLength(){
				    return null;
				}
				public Integer IDPrecision(){
				    return null;
				}
				public String IDDefault(){
				
					return "";
				
				}
				public String IDComment(){
				
				    return "";
				
				}
				public String IDPattern(){
				
					return "";
				
				}
				public String IDOriginalDbColumnName(){
				
					return "ID";
				
				}

				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}

				public Boolean NAMEIsNullable(){
				    return false;
				}
				public Boolean NAMEIsKey(){
				    return false;
				}
				public Integer NAMELength(){
				    return null;
				}
				public Integer NAMEPrecision(){
				    return null;
				}
				public String NAMEDefault(){
				
					return null;
				
				}
				public String NAMEComment(){
				
				    return "";
				
				}
				public String NAMEPattern(){
				
					return "";
				
				}
				public String NAMEOriginalDbColumnName(){
				
					return "NAME";
				
				}

				
			    public int ID_MANAGER;

				public int getID_MANAGER () {
					return this.ID_MANAGER;
				}

				public Boolean ID_MANAGERIsNullable(){
				    return false;
				}
				public Boolean ID_MANAGERIsKey(){
				    return false;
				}
				public Integer ID_MANAGERLength(){
				    return null;
				}
				public Integer ID_MANAGERPrecision(){
				    return null;
				}
				public String ID_MANAGERDefault(){
				
					return "";
				
				}
				public String ID_MANAGERComment(){
				
				    return "";
				
				}
				public String ID_MANAGERPattern(){
				
					return "";
				
				}
				public String ID_MANAGEROriginalDbColumnName(){
				
					return "ID_MANAGER";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL.length) {
				if(length < 1024 && commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL.length == 0) {
   					commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL = new byte[1024];
				} else {
   					commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL, 0, length);
			strReturn = new String(commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL.length) {
				if(length < 1024 && commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL.length == 0) {
   					commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL = new byte[1024];
				} else {
   					commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL, 0, length);
			strReturn = new String(commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ODOO_V17_DATA_MIGRATION_createTables4ETL) {

        	try {

        		int length = 0;
		
			        this.ID = dis.readInt();
					
					this.NAME = readString(dis);
					
			        this.ID_MANAGER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ODOO_V17_DATA_MIGRATION_createTables4ETL) {

        	try {

        		int length = 0;
		
			        this.ID = dis.readInt();
					
					this.NAME = readString(dis);
					
			        this.ID_MANAGER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ID);
					
					// String
				
						writeString(this.NAME,dos);
					
					// int
				
		            	dos.writeInt(this.ID_MANAGER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ID);
					
					// String
				
						writeString(this.NAME,dos);
					
					// int
				
		            	dos.writeInt(this.ID_MANAGER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ID="+String.valueOf(ID));
		sb.append(",NAME="+NAME);
		sb.append(",ID_MANAGER="+String.valueOf(ID_MANAGER));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(ID);
        			
        			sb.append("|");
        		
        				if(NAME == null){
        					sb.append("<null>");
        				}else{
            				sb.append(NAME);
            			}
            		
        			sb.append("|");
        		
        				sb.append(ID_MANAGER);
        			
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_ODOO_V17_DATA_MIGRATION_createTables4ETL = new byte[0];
    static byte[] commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL = new byte[0];

	
			    public int ID;

				public int getID () {
					return this.ID;
				}

				public Boolean IDIsNullable(){
				    return false;
				}
				public Boolean IDIsKey(){
				    return false;
				}
				public Integer IDLength(){
				    return null;
				}
				public Integer IDPrecision(){
				    return null;
				}
				public String IDDefault(){
				
					return "";
				
				}
				public String IDComment(){
				
				    return "";
				
				}
				public String IDPattern(){
				
					return "";
				
				}
				public String IDOriginalDbColumnName(){
				
					return "ID";
				
				}

				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}

				public Boolean NAMEIsNullable(){
				    return false;
				}
				public Boolean NAMEIsKey(){
				    return false;
				}
				public Integer NAMELength(){
				    return null;
				}
				public Integer NAMEPrecision(){
				    return null;
				}
				public String NAMEDefault(){
				
					return null;
				
				}
				public String NAMEComment(){
				
				    return "";
				
				}
				public String NAMEPattern(){
				
					return "";
				
				}
				public String NAMEOriginalDbColumnName(){
				
					return "NAME";
				
				}

				
			    public int ID_MANAGER;

				public int getID_MANAGER () {
					return this.ID_MANAGER;
				}

				public Boolean ID_MANAGERIsNullable(){
				    return false;
				}
				public Boolean ID_MANAGERIsKey(){
				    return false;
				}
				public Integer ID_MANAGERLength(){
				    return null;
				}
				public Integer ID_MANAGERPrecision(){
				    return null;
				}
				public String ID_MANAGERDefault(){
				
					return "";
				
				}
				public String ID_MANAGERComment(){
				
				    return "";
				
				}
				public String ID_MANAGERPattern(){
				
					return "";
				
				}
				public String ID_MANAGEROriginalDbColumnName(){
				
					return "ID_MANAGER";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL.length) {
				if(length < 1024 && commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL.length == 0) {
   					commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL = new byte[1024];
				} else {
   					commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL, 0, length);
			strReturn = new String(commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL.length) {
				if(length < 1024 && commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL.length == 0) {
   					commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL = new byte[1024];
				} else {
   					commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL, 0, length);
			strReturn = new String(commonByteArray_ODOO_V17_DATA_MIGRATION_createTables4ETL, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ODOO_V17_DATA_MIGRATION_createTables4ETL) {

        	try {

        		int length = 0;
		
			        this.ID = dis.readInt();
					
					this.NAME = readString(dis);
					
			        this.ID_MANAGER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ODOO_V17_DATA_MIGRATION_createTables4ETL) {

        	try {

        		int length = 0;
		
			        this.ID = dis.readInt();
					
					this.NAME = readString(dis);
					
			        this.ID_MANAGER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ID);
					
					// String
				
						writeString(this.NAME,dos);
					
					// int
				
		            	dos.writeInt(this.ID_MANAGER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ID);
					
					// String
				
						writeString(this.NAME,dos);
					
					// int
				
		            	dos.writeInt(this.ID_MANAGER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ID="+String.valueOf(ID));
		sb.append(",NAME="+NAME);
		sb.append(",ID_MANAGER="+String.valueOf(ID_MANAGER));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(ID);
        			
        			sb.append("|");
        		
        				if(NAME == null){
        					sb.append("<null>");
        				}else{
            				sb.append(NAME);
            			}
            		
        			sb.append("|");
        		
        				sb.append(ID_MANAGER);
        			
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public void tRowGenerator_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", 0);

	final boolean execStat = this.execStat;

		mdc("tRowGenerator_1", "8C2yRS_");

	
		String iterateId = "";
	
	
	String currentComponent = "";
	s("none");
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();
row2Struct row2 = new row2Struct();





	
	/**
	 * [tMysqlOutput_1 begin ] start
	 */

	

	
		
		sh("tMysqlOutput_1");
		
	
	s(currentComponent="tMysqlOutput_1");
	
			
			
	
			cLabel="tMysqlOutput_1 \"employees\"";
		
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row2");
			
		int tos_count_tMysqlOutput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMysqlOutput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMysqlOutput_1 = new StringBuilder();
                    log4jParamters_tMysqlOutput_1.append("Parameters:");
                            log4jParamters_tMysqlOutput_1.append("DB_VERSION" + " = " + "MYSQL_5");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("HOST" + " = " + "\"localhost\"");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("PORT" + " = " + "\"3306\"");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("DBNAME" + " = " + "\"demoproject\"");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("USER" + " = " + "\"root\"");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:rRstC1OttKwce716ldIu1uwBaZSBHYQcB4Y9bACO3eU=").substring(0, 4) + "...");     
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("TABLE" + " = " + "\"employees\"");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("TABLE_ACTION" + " = " + "DROP_IF_EXISTS_AND_CREATE");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("DATA_ACTION" + " = " + "INSERT");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("DIE_ON_ERROR" + " = " + "true");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("PROPERTIES" + " = " + "\"\"");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("USE_BATCH_SIZE" + " = " + "false");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("COMMIT_EVERY" + " = " + "100");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("ADD_COLS" + " = " + "[]");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("USE_HINT_OPTIONS" + " = " + "false");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("ON_DUPLICATE_KEY_UPDATE" + " = " + "false");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                            log4jParamters_tMysqlOutput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
                        log4jParamters_tMysqlOutput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + (log4jParamters_tMysqlOutput_1) );
                    } 
                } 
            new BytesLimit65535_tMysqlOutput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMysqlOutput_1", "tMysqlOutput_1 \"employees\"", "tMysqlOutput");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			







int nb_line_tMysqlOutput_1 = 0;
int nb_line_update_tMysqlOutput_1 = 0;
int nb_line_inserted_tMysqlOutput_1 = 0;
int nb_line_deleted_tMysqlOutput_1 = 0;
int nb_line_rejected_tMysqlOutput_1 = 0;

int deletedCount_tMysqlOutput_1=0;
int updatedCount_tMysqlOutput_1=0;
int insertedCount_tMysqlOutput_1=0;
int rowsToCommitCount_tMysqlOutput_1=0;
int rejectedCount_tMysqlOutput_1=0;

String tableName_tMysqlOutput_1 = "employees";
boolean whetherReject_tMysqlOutput_1 = false;

java.util.Calendar calendar_tMysqlOutput_1 = java.util.Calendar.getInstance();
calendar_tMysqlOutput_1.set(1, 0, 1, 0, 0, 0);
long year1_tMysqlOutput_1 = calendar_tMysqlOutput_1.getTime().getTime();
calendar_tMysqlOutput_1.set(10000, 0, 1, 0, 0, 0);
long year10000_tMysqlOutput_1 = calendar_tMysqlOutput_1.getTime().getTime();
long date_tMysqlOutput_1;

java.sql.Connection conn_tMysqlOutput_1 = null;
		
			
        String url_tMysqlOutput_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "demoproject" + "?" + "rewriteBatchedStatements=true";

			String driverClass_tMysqlOutput_1 = "com.mysql.jdbc.Driver";
			
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Driver ClassName: ")  + (driverClass_tMysqlOutput_1)  + (".") );
			String dbUser_tMysqlOutput_1 = "root";
			

			 
	final String decryptedPassword_tMysqlOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:OuTcXJqgift6dT7kLGbnFMf6Ges/Gfcwc/L/qogUhDI=");

			String dbPwd_tMysqlOutput_1 = decryptedPassword_tMysqlOutput_1;
			java.lang.Class.forName(driverClass_tMysqlOutput_1);
			
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Connection attempts to '")  + (url_tMysqlOutput_1)  + ("' with the username '")  + (dbUser_tMysqlOutput_1)  + ("'.") );
			conn_tMysqlOutput_1 = java.sql.DriverManager.getConnection(url_tMysqlOutput_1, dbUser_tMysqlOutput_1, dbPwd_tMysqlOutput_1);
			
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Connection to '")  + (url_tMysqlOutput_1)  + ("' has succeeded.") );
			
	resourceMap.put("conn_tMysqlOutput_1", conn_tMysqlOutput_1);
	
			conn_tMysqlOutput_1.setAutoCommit(false);
			int commitEvery_tMysqlOutput_1 = 100;
			int commitCounter_tMysqlOutput_1 = 0;
			
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Connection is set auto commit to '")  + (conn_tMysqlOutput_1.getAutoCommit())  + ("'.") );

		int count_tMysqlOutput_1=0;
		
				
                                java.sql.DatabaseMetaData dbMetaData_tMysqlOutput_1 = conn_tMysqlOutput_1.getMetaData();
                                    java.sql.ResultSet rsTable_tMysqlOutput_1 = dbMetaData_tMysqlOutput_1.getTables("demoproject", null, null, new String[]{"TABLE"});
                                boolean whetherExist_tMysqlOutput_1 = false;
                                while(rsTable_tMysqlOutput_1.next()) {
                                    String table_tMysqlOutput_1 = rsTable_tMysqlOutput_1.getString("TABLE_NAME");
                                    if(table_tMysqlOutput_1.equalsIgnoreCase("employees")) {
                                        whetherExist_tMysqlOutput_1 = true;
                                        break;
                                    }
                                }
                                if(whetherExist_tMysqlOutput_1) {
                                    try (java.sql.Statement stmtDrop_tMysqlOutput_1 = conn_tMysqlOutput_1.createStatement()) {
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Dropping")  + (" table '")  + (tableName_tMysqlOutput_1)  + ("'.") );
                                        stmtDrop_tMysqlOutput_1.execute("DROP TABLE `" + tableName_tMysqlOutput_1 + "`" );
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Drop")  + (" table '")  + (tableName_tMysqlOutput_1)  + ("' has succeeded.") );
                                    }
                                }
                                try(java.sql.Statement stmtCreate_tMysqlOutput_1 = conn_tMysqlOutput_1.createStatement()) {
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Creating")  + (" table '")  + (tableName_tMysqlOutput_1)  + ("'.") );
                                    stmtCreate_tMysqlOutput_1.execute("CREATE TABLE `" + tableName_tMysqlOutput_1 + "`(`ID` INT(11)   not null ,`NAME` VARCHAR(50)   not null ,`ID_MANAGER` INT(50)   not null )");
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Create")  + (" table '")  + (tableName_tMysqlOutput_1)  + ("' has succeeded.") );
                                }
			

		
					String insert_tMysqlOutput_1 = "INSERT INTO `" + "employees" + "` (`ID`,`NAME`,`ID_MANAGER`) VALUES (?,?,?)";
		
					    

					
						java.sql.PreparedStatement pstmt_tMysqlOutput_1 = conn_tMysqlOutput_1.prepareStatement(insert_tMysqlOutput_1);
						resourceMap.put("pstmt_tMysqlOutput_1", pstmt_tMysqlOutput_1);
					

					

		


 



		

/**
 * [tMysqlOutput_1 begin ] stop
 */




	
	/**
	 * [tUniqRow_1 begin ] start
	 */

	

	
		
		sh("tUniqRow_1");
		
	
	s(currentComponent="tUniqRow_1");
	
			
			
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row1");
			
		int tos_count_tUniqRow_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tUniqRow_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tUniqRow_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tUniqRow_1 = new StringBuilder();
                    log4jParamters_tUniqRow_1.append("Parameters:");
                            log4jParamters_tUniqRow_1.append("UNIQUE_KEY" + " = " + "[{CASE_SENSITIVE="+("false")+", KEY_ATTRIBUTE="+("false")+", SCHEMA_COLUMN="+("ID")+"}, {CASE_SENSITIVE="+("false")+", KEY_ATTRIBUTE="+("true")+", SCHEMA_COLUMN="+("NAME")+"}, {CASE_SENSITIVE="+("false")+", KEY_ATTRIBUTE="+("false")+", SCHEMA_COLUMN="+("ID_MANAGER")+"}]");
                        log4jParamters_tUniqRow_1.append(" | ");
                            log4jParamters_tUniqRow_1.append("ONLY_ONCE_EACH_DUPLICATED_KEY" + " = " + "false");
                        log4jParamters_tUniqRow_1.append(" | ");
                            log4jParamters_tUniqRow_1.append("IS_VIRTUAL_COMPONENT" + " = " + "false");
                        log4jParamters_tUniqRow_1.append(" | ");
                            log4jParamters_tUniqRow_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "false");
                        log4jParamters_tUniqRow_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tUniqRow_1 - "  + (log4jParamters_tUniqRow_1) );
                    } 
                } 
            new BytesLimit65535_tUniqRow_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tUniqRow_1", "tUniqRow_1", "tUniqRow");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

	
		class KeyStruct_tUniqRow_1 {
	
			private static final int DEFAULT_HASHCODE = 1;
		    private static final int PRIME = 31;
		    private int hashCode = DEFAULT_HASHCODE;
		    public boolean hashCodeDirty = true;
	
	        
					String NAME;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
								result = prime * result + ((this.NAME == null) ? 0 : this.NAME.hashCode());
								
		    		this.hashCode = result;
		    		this.hashCodeDirty = false;		
				}
				return this.hashCode;
			}
			
			@Override
			public boolean equals(Object obj) {
				if (this == obj) return true;
				if (obj == null) return false;
				if (getClass() != obj.getClass()) return false;
				final KeyStruct_tUniqRow_1 other = (KeyStruct_tUniqRow_1) obj;
				
									if (this.NAME == null) {
										if (other.NAME != null) 
											return false;
								
									} else if (!this.NAME.equals(other.NAME))
								 
										return false;
								
				
				return true;
			}
	  
	        
		}

	
int nb_uniques_tUniqRow_1 = 0;
int nb_duplicates_tUniqRow_1 = 0;
	log.debug("tUniqRow_1 - Start to process the data from datasource.");
KeyStruct_tUniqRow_1 finder_tUniqRow_1 = new KeyStruct_tUniqRow_1();
java.util.Set<KeyStruct_tUniqRow_1> keystUniqRow_1 = new java.util.HashSet<KeyStruct_tUniqRow_1>(); 

 



		

/**
 * [tUniqRow_1 begin ] stop
 */




	
	/**
	 * [tRowGenerator_1 begin ] start
	 */

	

	
		
		sh("tRowGenerator_1");
		
	
	s(currentComponent="tRowGenerator_1");
	
			
			
	
		int tos_count_tRowGenerator_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tRowGenerator_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tRowGenerator_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tRowGenerator_1 = new StringBuilder();
                    log4jParamters_tRowGenerator_1.append("Parameters:");
                if(log.isDebugEnabled())
            log.debug("tRowGenerator_1 - "  + (log4jParamters_tRowGenerator_1) );
                    } 
                } 
            new BytesLimit65535_tRowGenerator_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tRowGenerator_1", "tRowGenerator_1", "tRowGenerator");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			


int nb_line_tRowGenerator_1 = 0;
int nb_max_row_tRowGenerator_1 = 20;


class tRowGenerator_1Randomizer {
	public int getRandomID() {
		
		return Numeric.sequence("id",1,1);
		
	}
	public String getRandomNAME() {
		
		return TalendDataGenerator.getLastName();
		
	}
	public int getRandomID_MANAGER() {
		
		int[] ID_MANAGERTable = new int[] { 1,6 };
		java.util.Random randomtRowGenerator_1 = new java.util.Random();
		return ID_MANAGERTable[randomtRowGenerator_1.nextInt(ID_MANAGERTable.length)];
		
	}
}
	tRowGenerator_1Randomizer randtRowGenerator_1 = new tRowGenerator_1Randomizer();
	
    	log.info("tRowGenerator_1 - Generating records.");
	for (int itRowGenerator_1=0; itRowGenerator_1<nb_max_row_tRowGenerator_1 ;itRowGenerator_1++) {
		row1.ID = randtRowGenerator_1.getRandomID();
		row1.NAME = randtRowGenerator_1.getRandomNAME();
		row1.ID_MANAGER = randtRowGenerator_1.getRandomID_MANAGER();
		nb_line_tRowGenerator_1++;
		
			log.debug("tRowGenerator_1 - Retrieving the record " + nb_line_tRowGenerator_1 + ".");
		

 



		

/**
 * [tRowGenerator_1 begin ] stop
 */

	
	/**
	 * [tRowGenerator_1 main ] start
	 */

	

	
	
	s(currentComponent="tRowGenerator_1");
	
			
			
	

 


	tos_count_tRowGenerator_1++;

		

/**
 * [tRowGenerator_1 main ] stop
 */

	
	/**
	 * [tRowGenerator_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tRowGenerator_1");
	
			
			
	

 



		

/**
 * [tRowGenerator_1 process_data_begin ] stop
 */


	
	/**
	 * [tUniqRow_1 main ] start
	 */

	

	
	
	s(currentComponent="tUniqRow_1");
	
			
			
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row1","tRowGenerator_1","tRowGenerator_1","tRowGenerator","tUniqRow_1","tUniqRow_1","tUniqRow"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		
row2 = null;			
if(row1.NAME == null){
	finder_tUniqRow_1.NAME = null;
}else{
	finder_tUniqRow_1.NAME = row1.NAME.toLowerCase();
}	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
if(row1.NAME == null){
	new_tUniqRow_1.NAME = null;
}else{
	new_tUniqRow_1.NAME = row1.NAME.toLowerCase();
}
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
		log.trace("tUniqRow_1 - Writing the unique record " + (nb_uniques_tUniqRow_1+1) + " into row2.");
	
	row2 = new row2Struct();
}row2.ID = row1.ID;			row2.NAME = row1.NAME;			row2.ID_MANAGER = row1.ID_MANAGER;					
		nb_uniques_tUniqRow_1++;
	} else {
	  nb_duplicates_tUniqRow_1++;
	}

 


	tos_count_tUniqRow_1++;

		

/**
 * [tUniqRow_1 main ] stop
 */

	
	/**
	 * [tUniqRow_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tUniqRow_1");
	
			
			
	

 



		

/**
 * [tUniqRow_1 process_data_begin ] stop
 */

// Start of branch "row2"
if(row2 != null) { 



	
	/**
	 * [tMysqlOutput_1 main ] start
	 */

	

	
	
	s(currentComponent="tMysqlOutput_1");
	
			
			
	
			cLabel="tMysqlOutput_1 \"employees\"";
		
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row2","tUniqRow_1","tUniqRow_1","tUniqRow","tMysqlOutput_1","tMysqlOutput_1 \"employees\"","tMysqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		



        whetherReject_tMysqlOutput_1 = false;
                        pstmt_tMysqlOutput_1.setInt(1, row2.ID);

                        if(row2.NAME == null) {
pstmt_tMysqlOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tMysqlOutput_1.setString(2, row2.NAME);
}

                        pstmt_tMysqlOutput_1.setInt(3, row2.ID_MANAGER);

                try {
                    nb_line_tMysqlOutput_1++;
                    int processedCount_tMysqlOutput_1 = pstmt_tMysqlOutput_1.executeUpdate();
                    insertedCount_tMysqlOutput_1 += processedCount_tMysqlOutput_1;
                    rowsToCommitCount_tMysqlOutput_1 += processedCount_tMysqlOutput_1;
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Inserting")  + (" the record ")  + (nb_line_tMysqlOutput_1)  + (".") );
                } catch(java.lang.Exception e) {
                    globalMap.put("tMysqlOutput_1_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tMysqlOutput_1 = true;
                        throw(e);
                }
                commitCounter_tMysqlOutput_1++;

                if(commitEvery_tMysqlOutput_1 <= commitCounter_tMysqlOutput_1) {

                    if(rowsToCommitCount_tMysqlOutput_1 != 0){
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tMysqlOutput_1)  + (" record(s).") );
                    }
                    conn_tMysqlOutput_1.commit();
                    if(rowsToCommitCount_tMysqlOutput_1 != 0){
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Connection commit has succeeded.") );
                        rowsToCommitCount_tMysqlOutput_1 = 0;
                    }
                    commitCounter_tMysqlOutput_1=0;
                }

 


	tos_count_tMysqlOutput_1++;

		

/**
 * [tMysqlOutput_1 main ] stop
 */

	
	/**
	 * [tMysqlOutput_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tMysqlOutput_1");
	
			
			
	
			cLabel="tMysqlOutput_1 \"employees\"";
		

 



		

/**
 * [tMysqlOutput_1 process_data_begin ] stop
 */

	
	/**
	 * [tMysqlOutput_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tMysqlOutput_1");
	
			
			
	
			cLabel="tMysqlOutput_1 \"employees\"";
		

 



		

/**
 * [tMysqlOutput_1 process_data_end ] stop
 */


} // End of branch "row2"




	
	/**
	 * [tUniqRow_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tUniqRow_1");
	
			
			
	

 



		

/**
 * [tUniqRow_1 process_data_end ] stop
 */




	
	/**
	 * [tRowGenerator_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tRowGenerator_1");
	
			
			
	

 



		

/**
 * [tRowGenerator_1 process_data_end ] stop
 */

	
	/**
	 * [tRowGenerator_1 end ] start
	 */

	

	
	
	s(currentComponent="tRowGenerator_1");
	
			
			
	

}
globalMap.put("tRowGenerator_1_NB_LINE",nb_line_tRowGenerator_1);
	log.info("tRowGenerator_1 - Generated records count:" + nb_line_tRowGenerator_1 + " .");

 
                if(log.isDebugEnabled())
            log.debug("tRowGenerator_1 - "  + ("Done.") );

ok_Hash.put("tRowGenerator_1", true);
end_Hash.put("tRowGenerator_1", System.currentTimeMillis());




		

/**
 * [tRowGenerator_1 end ] stop
 */


	
	/**
	 * [tUniqRow_1 end ] start
	 */

	

	
	
	s(currentComponent="tUniqRow_1");
	
			
			
	

globalMap.put("tUniqRow_1_NB_UNIQUES",nb_uniques_tUniqRow_1);
globalMap.put("tUniqRow_1_NB_DUPLICATES",nb_duplicates_tUniqRow_1);
	log.info("tUniqRow_1 - Unique records count: " + (nb_uniques_tUniqRow_1)+" .");
	log.info("tUniqRow_1 - Duplicate records count: " + (nb_duplicates_tUniqRow_1)+" .");

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row1",2,0,
			 			"tRowGenerator_1","tRowGenerator_1","tRowGenerator","tUniqRow_1","tUniqRow_1","tUniqRow","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tUniqRow_1 - "  + ("Done.") );

ok_Hash.put("tUniqRow_1", true);
end_Hash.put("tUniqRow_1", System.currentTimeMillis());




		

/**
 * [tUniqRow_1 end ] stop
 */


	
	/**
	 * [tMysqlOutput_1 end ] start
	 */

	

	
	
	s(currentComponent="tMysqlOutput_1");
	
			
			
	
			cLabel="tMysqlOutput_1 \"employees\"";
		



		

		if(pstmt_tMysqlOutput_1 != null) {
			
				pstmt_tMysqlOutput_1.close();
				resourceMap.remove("pstmt_tMysqlOutput_1");
			
		}
		
	resourceMap.put("statementClosed_tMysqlOutput_1", true);
	
			if (commitCounter_tMysqlOutput_1 > 0 && rowsToCommitCount_tMysqlOutput_1 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tMysqlOutput_1)  + (" record(s).") );
			}
			conn_tMysqlOutput_1.commit();
			if (commitCounter_tMysqlOutput_1 > 0 && rowsToCommitCount_tMysqlOutput_1 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Connection commit has succeeded.") );
				rowsToCommitCount_tMysqlOutput_1 = 0;
			}
			commitCounter_tMysqlOutput_1 = 0;
			
		
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Closing the connection to the database.") );
		conn_tMysqlOutput_1 .close();
		
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Connection to the database has closed.") );
		resourceMap.put("finish_tMysqlOutput_1", true);
	

	nb_line_deleted_tMysqlOutput_1=nb_line_deleted_tMysqlOutput_1+ deletedCount_tMysqlOutput_1;
	nb_line_update_tMysqlOutput_1=nb_line_update_tMysqlOutput_1 + updatedCount_tMysqlOutput_1;
	nb_line_inserted_tMysqlOutput_1=nb_line_inserted_tMysqlOutput_1 + insertedCount_tMysqlOutput_1;
	nb_line_rejected_tMysqlOutput_1=nb_line_rejected_tMysqlOutput_1 + rejectedCount_tMysqlOutput_1;
	
        globalMap.put("tMysqlOutput_1_NB_LINE",nb_line_tMysqlOutput_1);
        globalMap.put("tMysqlOutput_1_NB_LINE_UPDATED",nb_line_update_tMysqlOutput_1);
        globalMap.put("tMysqlOutput_1_NB_LINE_INSERTED",nb_line_inserted_tMysqlOutput_1);
        globalMap.put("tMysqlOutput_1_NB_LINE_DELETED",nb_line_deleted_tMysqlOutput_1);
        globalMap.put("tMysqlOutput_1_NB_LINE_REJECTED", nb_line_rejected_tMysqlOutput_1);
    

	
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Has ")  + ("inserted")  + (" ")  + (nb_line_inserted_tMysqlOutput_1)  + (" record(s).") );

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row2",2,0,
			 			"tUniqRow_1","tUniqRow_1","tUniqRow","tMysqlOutput_1","tMysqlOutput_1 \"employees\"","tMysqlOutput","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Done.") );

ok_Hash.put("tMysqlOutput_1", true);
end_Hash.put("tMysqlOutput_1", System.currentTimeMillis());




		

/**
 * [tMysqlOutput_1 end ] stop
 */







				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRowGenerator_1 finally ] start
	 */

	

	
	
	s(currentComponent="tRowGenerator_1");
	
			
			
	

 



		

/**
 * [tRowGenerator_1 finally ] stop
 */


	
	/**
	 * [tUniqRow_1 finally ] start
	 */

	

	
	
	s(currentComponent="tUniqRow_1");
	
			
			
	

 



		

/**
 * [tUniqRow_1 finally ] stop
 */


	
	/**
	 * [tMysqlOutput_1 finally ] start
	 */

	

	
	
	s(currentComponent="tMysqlOutput_1");
	
			
			
	
			cLabel="tMysqlOutput_1 \"employees\"";
		



    try {
    if (resourceMap.get("statementClosed_tMysqlOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tMysqlOutput_1 = null;
                if ((pstmtToClose_tMysqlOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tMysqlOutput_1")) != null) {
                    pstmtToClose_tMysqlOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tMysqlOutput_1") == null){
            java.sql.Connection ctn_tMysqlOutput_1 = null;
            if((ctn_tMysqlOutput_1 = (java.sql.Connection)resourceMap.get("conn_tMysqlOutput_1")) != null){
                try {
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Closing the connection to the database.") );
                    ctn_tMysqlOutput_1.close();
                if(log.isDebugEnabled())
            log.debug("tMysqlOutput_1 - "  + ("Connection to the database has closed.") );
                } catch (java.sql.SQLException sqlEx_tMysqlOutput_1) {
                    String errorMessage_tMysqlOutput_1 = "failed to close the connection in tMysqlOutput_1 :" + sqlEx_tMysqlOutput_1.getMessage();
            log.error("tMysqlOutput_1 - "  + (errorMessage_tMysqlOutput_1) );
                    System.err.println(errorMessage_tMysqlOutput_1);
                }
            }
        }
    }
 



		

/**
 * [tMysqlOutput_1 finally ] stop
 */







				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", 1);
	}
	


public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

	final boolean execStat = this.execStat;


	
		String iterateId = "";
	
	
	String currentComponent = "";
	s("none");
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [talendJobLog begin ] start
	 */

	

	
		
		sh("talendJobLog");
		
	
	s(currentComponent="talendJobLog");
	
			
			
	
		int tos_count_talendJobLog = 0;
		

	for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
		org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
			.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid).custom("father_pid", fatherPid).custom("root_pid", rootPid);
		org.talend.logging.audit.Context log_context_talendJobLog = null;
		
		
		if(jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE){
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.sourceId(jcm.sourceId).sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
				.targetId(jcm.targetId).targetLabel(jcm.targetLabel).targetConnectorType(jcm.targetComponentName)
				.connectionName(jcm.current_connector).rows(jcm.row_count).duration(duration).build();
			auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
			auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
		
			log_context_talendJobLog = builder_talendJobLog
				.timestamp(jcm.moment).duration(duration).status(jcm.status).build();
			auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label).build();
			auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {//log current component input line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {//log current component output/reject line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
			java.lang.Exception e_talendJobLog = jcm.exception;
			if(e_talendJobLog!=null) {
				try(java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
					e_talendJobLog.printStackTrace(pw_talendJobLog);
					builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
				}
			}

			if(jcm.extra_info!=null) {
				builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
			}
				
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
				.connectorId(jcm.component_id)
				.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label).build();

			auditLogger_talendJobLog.exception(log_context_talendJobLog);
		}
		
		
		
	}

 



		

/**
 * [talendJobLog begin ] stop
 */

	
	/**
	 * [talendJobLog main ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 


	tos_count_talendJobLog++;

		

/**
 * [talendJobLog main ] stop
 */

	
	/**
	 * [talendJobLog process_data_begin ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 



		

/**
 * [talendJobLog process_data_begin ] stop
 */

	
	/**
	 * [talendJobLog process_data_end ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 



		

/**
 * [talendJobLog process_data_end ] stop
 */

	
	/**
	 * [talendJobLog end ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 

ok_Hash.put("talendJobLog", true);
end_Hash.put("talendJobLog", System.currentTimeMillis());




		

/**
 * [talendJobLog end ] stop
 */

				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [talendJobLog finally ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 



		

/**
 * [talendJobLog finally ] stop
 */

				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;
    
    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    
    
    private final static java.util.Properties jobInfo = new java.util.Properties();
    private final static java.util.Map<String,String> mdcInfo = new java.util.HashMap<>();
    private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();


    public static void main(String[] args){
        final createTables4ETL createTables4ETLClass = new createTables4ETL();

        int exitCode = createTables4ETLClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'createTables4ETL' - Done.");
	        }

        System.exit(exitCode);
    }
	

	
	
	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if(path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
			readJobInfo(new java.io.File(BUILD_PATH));
	}

    private void readJobInfo(java.io.File jobInfoFile){
	
        if(jobInfoFile.exists()) {
            try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
            	jobInfo.load(is);
            } catch (IOException e) {
            	 
                log.debug("Read jobInfo.properties file fail: " + e.getMessage());
                
            }
        }
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s",
				projectName,jobName,jobInfo.getProperty("gitCommitId"), "8.0.1.20241203_0647-patch"));
		
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }

        final boolean enableCBP = false;
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (!inOSGi) {
        if(org.talend.metrics.CBPClient.getInstanceForCurrentVM() == null) {
            try {
                org.talend.metrics.CBPClient.startListenIfNotStarted(enableCBP, true);
            } catch (java.lang.Exception e) {
                errorCode = 1;
                status = "failure";
                e.printStackTrace();
                return 1;
            }
        }
        }
        
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

	        if(!"".equals(log4jLevel)){
	        	
				
				
				if("trace".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.OFF);
				}
				org.apache.logging.log4j.core.config.Configurator.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());
				
			}

	        getjobInfo();
			log.info("TalendJob: 'createTables4ETL' - Start.");
		

                java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
                for(Object jobInfoKey: jobInfoKeys) {
                    org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
                }
                org.slf4j.MDC.put("_pid", pid);
                org.slf4j.MDC.put("_rootPid", rootPid);
                org.slf4j.MDC.put("_fatherPid", fatherPid);
                org.slf4j.MDC.put("_projectName", projectName);
                org.slf4j.MDC.put("_startTimestamp",java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC ).format( java.time.format.DateTimeFormatter.ISO_INSTANT ));
                org.slf4j.MDC.put("_jobRepositoryId","_2XZNsOgjEduQrK0t1cU9cw");
                org.slf4j.MDC.put("_compiledAtTimestamp","2025-01-14T03:35:18.330618Z");

                java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
                String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
                if (mxNameTable.length == 2) {
                    org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
                } else {
                    org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
                }

		
		
			if(enableLogStash) {
				java.util.Properties properties_talendJobLog = new java.util.Properties();
				properties_talendJobLog.setProperty("root.logger", "audit");
				properties_talendJobLog.setProperty("encoding", "UTF-8");
				properties_talendJobLog.setProperty("application.name", "Talend Studio");
				properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
				properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
				properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
				properties_talendJobLog.setProperty("log.appender", "file");
				properties_talendJobLog.setProperty("appender.file.path", "audit.json");
				properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
				properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
				properties_talendJobLog.setProperty("host", "false");

				System.getProperties().stringPropertyNames().stream()
					.filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()), System.getProperty(key)));

				
				
				
				org.apache.logging.log4j.core.config.Configurator.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);
				
				auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory.createJobAuditLogger(properties_talendJobLog);
			}
		

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

            org.slf4j.MDC.put("_pid", pid);

        if (rootPid==null) {
            rootPid = pid;
        }

            org.slf4j.MDC.put("_rootPid", rootPid);

        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }
            org.slf4j.MDC.put("_fatherPid", fatherPid);

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }

        try {
            java.util.Dictionary<String, Object> jobProperties = null;
            if (inOSGi) {
                jobProperties = routines.system.BundleUtils.getJobProperties(jobName);
    
                if (jobProperties != null && jobProperties.get("context") != null) {
                    contextStr = (String)jobProperties.get("context");
                }

                if (jobProperties != null && jobProperties.get("taskExecutionId") != null) {
                    taskExecutionId = (String)jobProperties.get("taskExecutionId");
                }

                // extract ids from parent route
                if(null == taskExecutionId || taskExecutionId.isEmpty()){
                    for(String arg : args) {
                        if(arg.startsWith("--context_param")
                                && (arg.contains("taskExecutionId") || arg.contains("jobExecutionId"))){

                            String keyValue = arg.replace("--context_param", "");
                            String[] parts = keyValue.split("=");
                            String[] cleanParts = java.util.Arrays.stream(parts)
                                    .filter(s -> !s.isEmpty())
                                    .toArray(String[]::new);
                            if (cleanParts.length == 2) {
                                String key = cleanParts[0];
                                String value = cleanParts[1];
                                if ("taskExecutionId".equals(key.trim()) && null != value) {
                                    taskExecutionId = value.trim();
                                }else if ("jobExecutionId".equals(key.trim()) && null != value) {
                                    jobExecutionId = value.trim();
                                }
                            }
                        }
                    }
                }
            }

            // first load default key-value pairs from application.properties
            if(isStandaloneMS) {
                context.putAll(this.getDefaultProperties());
            }
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = createTables4ETL.class.getClassLoader().getResourceAsStream("odoo_v17_data_migration/createtables4etl_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = createTables4ETL.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
    	                defaultProps.load(inContext);
    	                if (inOSGi && jobProperties != null) {
                             java.util.Enumeration<String> keys = jobProperties.keys();
                             while (keys.hasMoreElements()) {
                                 String propKey = keys.nextElement();
                                 if (defaultProps.containsKey(propKey)) {
                                     defaultProps.put(propKey, (String) jobProperties.get(propKey));
                                 }
                             }
    	                }
    	                context = new ContextProperties(defaultProps);
                    }
                    if(isStandaloneMS) {
                        // override context key-value pairs if provided using --context=contextName
                        defaultProps.load(inContext);
                        context.putAll(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }
            // override key-value pairs if provided via --config.location=file1.file2 OR --config.additional-location=file1,file2
            if(isStandaloneMS) {
                context.putAll(this.getAdditionalProperties());
            }
            
            // override key-value pairs if provide via command line like --key1=value1,--key2=value2
            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("id", "id_Integer");
                        if(context.getStringValue("id") == null) {
                            context.id = null;
                        } else {
                            try{
                                context.id=routines.system.ParserUtils.parseTo_Integer (context.getProperty("id"));
                            } catch(NumberFormatException e){
                                log.warn(String.format("Null value will be used for context parameter %s: %s", "id", e.getMessage()));
                                context.id=null;
                            }
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("id")) {
                context.id = (Integer) parentContextMap.get("id");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,ContextProperties.class,parametersToEncrypt));

            org.slf4j.MDC.put("_context", contextStr);
            log.info("TalendJob: 'createTables4ETL' - Started.");
            java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob




		if(enableLogStash) {
	        talendJobLog.addJobStartMessage();
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }

this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tCreateTable_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tCreateTable_1) {
globalMap.put("tCreateTable_1_SUBPROCESS_STATE", -1);

e_tCreateTable_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : createTables4ETL");
        }
		if(enableLogStash) {
	        talendJobLog.addJobEndMessage(startTime, end, status);
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    if (!inOSGi) {
    if(org.talend.metrics.CBPClient.getInstanceForCurrentVM() != null) {
        s("none");
        org.talend.metrics.CBPClient.getInstanceForCurrentVM().sendData();
    }
    }

    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");
    resumeUtil.flush();


        org.slf4j.MDC.remove("_subJobName");
        org.slf4j.MDC.remove("_subJobPid");
        org.slf4j.MDC.remove("_systemPid");
        log.info("TalendJob: 'createTables4ETL' - Finished - status: " + status + " returnCode: " + returnCode );

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {
  // add CBP code for OSGI Executions
  if (null != taskExecutionId && !taskExecutionId.isEmpty()) {
     try {
	   org.talend.metrics.DataReadTracker.setExecutionId(taskExecutionId, jobExecutionId, false);
	   org.talend.metrics.DataReadTracker.sealCounter();
	   org.talend.metrics.DataReadTracker.reset();
	} catch (Exception | NoClassDefFoundError e) {
	   // ignore
	}
  }



    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--context_file")) {
        	String keyValue = arg.substring(15);
        	String filePath = new String(java.util.Base64.getDecoder().decode(keyValue));
        	java.nio.file.Path contextFile = java.nio.file.Paths.get(filePath);
            try (java.io.BufferedReader reader = java.nio.file.Files.newBufferedReader(contextFile)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    int index = -1;
                    if ( (index = line.indexOf('=')) > -1) {
							if (line.startsWith("--context_param")) {
								if ("id_Password".equals(context_param.getContextType(line.substring(16, index)))) {
									context_param.put(line.substring(16, index), routines.system.PasswordEncryptUtil.decryptPassword(
											line.substring(index + 1)));
								} else {
									context_param.put(line.substring(16, index), line.substring(index + 1));
								}
							}else {//--context_type
								context_param.setContextType(line.substring(15, index), line.substring(index + 1));
							}
                    }
                }
            } catch (java.io.IOException e) {
            	System.err.println("Could not load the context file: " + filePath);
                e.printStackTrace();
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     100306 characters generated by Talend Cloud Data Management Platform 
 *     on the 14 January 2025 at 7:35:18 AM GST
 ************************************************************************************************/