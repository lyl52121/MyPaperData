import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.cn.lyl.dao.SensorLogMapper;
import com.cn.lyl.pojo.SensorLog;
import com.cn.lyl.tool.MyBatisUtil;

public class AddEmptyData {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Logger logger=Logger.getLogger(AddDBSensorLog.class);
		logger.debug("LogInputDBTest!==============================");
		SqlSession sqlSession=null;
		int count=0,log_count=0;
		
        
		/***
		 * �����ļ��е�����
		 */
        File file = new File("C:\\Users\\LYL\\Desktop\\�������\\1С���İ汾����\\���ݼ�������\\data.txt");//����һ��file����������ʼ��FileReader
        FileReader reader = new FileReader(file);//����һ��fileReader����������ʼ��BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//newһ��BufferedReader���󣬽��ļ����ݶ�ȡ������
        StringBuilder sb = new StringBuilder();//����һ���ַ������棬���ַ�����Ż�����
        String s = "";
        int log_n=0;
        while ((s =bReader.readLine()) != null) {//���ж�ȡ�ļ����ݣ�����ȡ���з���ĩβ�Ŀո�
            sb.append(s + "\n");//����ȡ���ַ�����ӻ��з����ۼӴ���ڻ�����
            if(log_n>=129120 && log_n<=129500)
            	System.out.println(s);
            log_n++;
        }
        bReader.close();
        
        /**
         * �����ݷ�����ȡ
         */
        String sf = sb.toString();
        String[] log_data=sf.split("\\n");
		sqlSession=MyBatisUtil.createSqlSession();
		String temp="";
		SensorLog log=new SensorLog();
		
		/*try {
	        for(String ee:log_data)
	        {      	
	        	
	        	*//**
	        	 * �����ݷ��������ȡ
	        	 *//*
		   		String[] tokens=ee.split("\\s");
		   		int n=0,i;
		   		 for(String t:tokens)
		   		 {
		   			 *//**
		   			  * ȥ�����ַ����еĿ�ͷ���β�Ŀո�
		   			  *//*
		   			 String t1=t.trim();
		   			 
		   			 *//**
		   			  * �����ݶ������ݿ�
		   			  *//*

	
		   			 	 if(n==0)
						 {	
		   			 		 temp=t1;
					         System.out.println(temp);
							// log.setRequestMechineIP(t1);
						 }
							 
						 if(n==1)
						 {
							 
							 t1=temp+" "+t1;
							 SimpleDateFormat format1 = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss z",Locale.ENGLISH);
							 SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							 try {
								Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t1);
								 //log.setRequestTime(requestTime);
								 log.setDate(date);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								 log.setDate(null);
							}
						 }
						 if(n==2)
						 {
							 try {
								Integer epoch=Integer.parseInt(t1);
								 log.setEpoch(epoch);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								 log.setEpoch(null);
							}
						 }
						 if(n==3)
						 {

							 try {
								Integer moteId=Integer.parseInt(t1);
								 log.setMoteId(moteId);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								 log.setMoteId(null);
							}
						 }
						 if(n==4)
						 {
							 try {
								Double temperature=Double.parseDouble(t1);
								 log.setTemperature(temperature);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								log.setTemperature(null);
							}
						 }
						 if(n==5)
						 {
							 try {
								Double humidity=Double.parseDouble(t1);
								 log.setHumidity(humidity);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								log.setHumidity(null);
							}	
						 }
						 if(n==6)
						 {							 
							 try {
								Double light=Double.parseDouble(t1);
								 log.setLight(light);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								log.setLight(null);
							}
						 }
						 if(n==7)
						 {							 
							 try {
								Double voltage=Double.parseDouble(t1);
								 log.setVoltage(voltage);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								log.setVoltage(null);
							}
						 }
			
					n++;
		   		 }
					count=sqlSession.getMapper(SensorLogMapper.class).addSensorLog(log);
					sqlSession.commit();
					log_count++;
					logger.debug("AddLogData:"+count);
		        }
		 } catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				sqlSession.rollback();
				count=0;
		}finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}*/
		logger.debug("��־�����У� "+log_n);
		logger.debug("�������ݿ�����־���� "+log_count);
	}

}
