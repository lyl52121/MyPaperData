
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.cn.lyl.dao.SensorLogMapper;
import com.cn.lyl.pojo.SensorLog;
import com.cn.lyl.tool.MyBatisUtil;

public class AddDBSensorLog {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		/**
		 * ��־��¼
		 */
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
/*		 try {
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
								 if(t1!="")
								 {
								 Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t1);
								 //log.setRequestTime(requestTime);
								 log.setDate(date);
								 }
								 else
								 {
									 Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("0000-00-00 00:00:00");
									 log.setDate(date);
								 }
							 }
							 if(n==2)
							 {
								 if(t1!="")
								 {
								 Integer epoch=Integer.parseInt(t1);
								 log.setEpoch(epoch);
								 }
								 else
								 {
									 log.setEpoch(-1);
								 }
							 }
							 if(n==3)
							 {
								 if(t1!="")
								 {
								 Integer moteId=Integer.parseInt(t1);
								 log.setMoteId(moteId);
								 }
								 else
								 {
									 log.setMoteId(-1);
								 }
							 }
							 if(n==4)
							 {
								 if(t1!="")
								 {
								 Double temperature=Double.parseDouble(t1);
								 log.setTemperature(temperature);
								 }
								 else
								 {
									 log.setTemperature(0.000);
								 }
							 }
							 if(n==5)
							 {
								 if(t1!="")
								 {
								 Double humidity=Double.parseDouble(t1);
								 log.setHumidity(humidity);		
								 }
								 else
								 {
									 log.setHumidity(0.000);	
								 }
							 }
							 if(n==6)
							 {
								 if(t1!="")
								 {
								 Double light=Double.parseDouble(t1);
								 log.setLight(light);
								 }
								 else
								 {
									 log.setLight(0.000);
								 }
							 }
							 if(n==7)
							 {
								 if(t1!="")
								 {
								 Double voltage=Double.parseDouble(t1);
								 log.setVoltage(voltage);
								 }
								 else
								 {
									 log.setVoltage(0.000);
								 }
							 }
				
						n++;
			   		 }
			   			 while(n<=7)
			   			 {
							 n++;
			   			 	 if(n==0)
							 {	
			   			 		 temp="0000-00-00 ";
						         System.out.println(temp);
								// log.setRequestMechineIP(t1);
							 }
								 
							 if(n==1)
							 {
								 temp=temp+"00-00-00";
								 SimpleDateFormat format1 = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss z",Locale.ENGLISH);
								 SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								 Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(temp);
								 //log.setRequestTime(requestTime);
								 log.setDate(date);
							 }
							 if(n==2)
							 {
								 Integer epoch=-1;
								 log.setEpoch(epoch);
							 }
							 if(n==3)
							 {
								 Integer moteId=-1;
								 log.setMoteId(moteId);
							 }
							 if(n==4)
							 {
								 Double temperature=0.000;
								 log.setTemperature(temperature);
							 }
							 if(n==5)
							 {
								 Double humidity=0.000;
								 log.setHumidity(humidity);								 
							 }
							 if(n==6)
							 {
								 Double light=0.000;
								 log.setLight(light);
							 }
							 if(n==7)
							 {
								 Double voltage=0.000;
								 log.setVoltage(voltage);
							 }				
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
