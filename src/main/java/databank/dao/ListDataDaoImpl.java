/******************************************************
 * File:  ListDataDaoImpl.java Course materials (23W) CST8277
 *
 * @author Teddy Yap
 */
package databank.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

@SuppressWarnings("unused")
/**
 * Description:  API for reading list data from the database
 */
@Named
@ApplicationScoped
public class ListDataDaoImpl implements ListDataDao, Serializable {
	/** Explicitly set serialVersionUID */
	private static final long serialVersionUID = 1L;

	private static final String DATABANK_DS_JNDI = "java:app/jdbc/databank";
	private static final String READ_ALL_DEGREES = "SELECT * FROM degree";
	private static final String READ_ALL_MAJORS = "SELECT * FROM major";

	@Inject
	protected ExternalContext externalContext;

	private void logMsg(String msg) {
		((ServletContext) externalContext.getContext()).log(msg);
	}

	@Resource(lookup = DATABANK_DS_JNDI)
	protected DataSource databankDS;

	protected Connection conn;
	protected PreparedStatement readAllDegreesPstmt;
	protected PreparedStatement readAllMajorsPstmt;

	@PostConstruct
	protected void buildConnectionAndStatements() {
		try {
			logMsg("building connection and stmts");
			conn = databankDS.getConnection();
			//TODO Initialize PreparedStatements
		} catch (Exception e) {
			logMsg("something went wrong getting connection from database:  " + e.getLocalizedMessage());
		}
	}

	@PreDestroy
	protected void closeConnectionAndStatements() {
		try {
			logMsg("closing stmts and connection");
			//TODO Close PreparedStatements
			conn.close();
		} catch (Exception e) {
			logMsg("something went wrong closing stmts or connection:  " + e.getLocalizedMessage());
		}
	}

	@Override
	public List<String> readAllDegrees() {
		logMsg("reading all degrees");
		List<String> degrees = new ArrayList<>();
		//TODO Complete the retrieval of all degrees
		//TODO Be sure to use try-and-catch statement
		return degrees;

	}

	@Override
	public List<String> readAllMajors() {
		logMsg("reading all majors");
		List<String> majors = new ArrayList<>();
		//TODO Complete the retrieval of all majors
		//TODO Be sure to use try-and-catch statement
		return majors;

	}
	
}
