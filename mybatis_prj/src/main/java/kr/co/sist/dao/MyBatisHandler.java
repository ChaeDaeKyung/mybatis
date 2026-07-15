package kr.co.sist.dao;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class MyBatisHandler {
	
	private static MyBatisHandler mbh;
	private static SqlSessionFactory ssf;
	
	private MyBatisHandler() {
		org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
	}
	
	public static MyBatisHandler getInstance() {
		if(mbh == null) {
			mbh = new MyBatisHandler();
		}
		return mbh;
	}// getInstance
	
	private SqlSessionFactory getSessionFactory(String configPath) {
		if(ssf == null) {
			Reader reader = null;
			File file = new File(configPath);
			SAXBuilder builder = new SAXBuilder();
			
			try {
				Document doc = builder.build(file);
				Element rootNode = doc.getRootElement();//최상위 노드찿기
				Element configPathNode = rootNode.getChild("config-path");
				
				//1. 설정 파일 스트림으로 연결
				reader = Resources.getResourceAsReader(configPathNode.getText());
				//2. mybatis framework (SqlSessionFactoryBuilder)를 생성
				ssf = new SqlSessionFactoryBuilder().build(reader);
				
				if(reader != null) {
					reader.close();
				}// end if
				
				
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}// end try catch
			
			//ssf=
		}// end if
		
		return ssf;
	}// getSessionFactory
	
	/**
	 * MyBatis Handler 얻기 : autocommit 설정된 Handler 얻기
	 * @param path config 파일의 경로 : null 또는 empty면 기본 C:/Dev/config/config-path.xml디렉토리에서 읽어들인다.
	 * @return autocommit 설정되지 않은 Handler
	 */
	public SqlSession getMyBatisHandler(String path) {
		// path가 null 이거나 ""이라면 기본 경로의 xml 파일을 로딩
		if(path == null || "".equals(path)) {
			path = "C:/Dev/config/config-path.xml";
		}
		SqlSession ss = getSessionFactory(path).openSession();//autocommit이 false가 기본
		return ss;
	}// getMyBatisHandler
	
	/**
	 * MyBatis Handler 얻기 : autocommit 설정하는 Handler 얻기
	 * @param path config 파일의 경로 : null 또는 empty면 기본 C:/Dev/config/config-path.xml디렉토리에서 읽어들인다.
	 * @param commitFlag true - autocommit 설정, false - autocommit 해제
	 * @return autocommit이 설정된 Handler
	 */
	public SqlSession getMyBatisHandler(String path, boolean commitFlag) {
		// path가 null 이거나 ""이라면 기본 경로의 xml 파일을 로딩
		if(path == null || "".equals(path)) {
			path = "C:/Dev/config/config-path.xml";
		}
		SqlSession ss = getSessionFactory(path).openSession(commitFlag);//autocommit이 false가 기본
		return ss;
	}// getMyBatisHandler
	
	/**
	 * Handler를 닫는 method
	 * @param ss 닫을 Handler
	 */
	public void closeHandler(SqlSession ss) {
		if(ss != null) {
			ss.close();
		}// end if
	}// closeHandler
	
}// class
