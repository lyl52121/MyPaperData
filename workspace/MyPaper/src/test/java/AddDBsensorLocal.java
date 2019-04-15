import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.cn.lyl.dao.SensorLocalMapper;
import com.cn.lyl.dao.SensorLogMapper;
import com.cn.lyl.pojo.SensorLocal;
import com.cn.lyl.pojo.SensorLog;
import com.cn.lyl.tool.MyBatisUtil;

public class AddDBsensorLocal {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		/**
		 * ��־��¼
		 */
		Logger logger=Logger.getLogger(AddDBsensorLocal.class);
		logger.debug("AddDBsensorLocal!==============================");
		SqlSession sqlSession=null;
		int count=0,log_count=0;
		
		/***
		 * �����ļ��е�����
		 */
        File file = new File("C:\\Users\\LYL\\Desktop\\�������\\1С���İ汾����\\���ݼ�������\\λ������.txt");//����һ��file����������ʼ��FileReader
        FileReader reader = new FileReader(file);//����һ��fileReader����������ʼ��BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//newһ��BufferedReader���󣬽��ļ����ݶ�ȡ������
        StringBuilder sb = new StringBuilder();//����һ���ַ������棬���ַ�����Ż�����
        String s = "";
        int log_n=0;
        while ((s =bReader.readLine()) != null) {//���ж�ȡ�ļ����ݣ�����ȡ���з���ĩβ�Ŀո�
            sb.append(s + "\n");//����ȡ���ַ�����ӻ��з����ۼӴ���ڻ�����
            System.out.println(s);
            log_n++;
        }
        bReader.close();
        
        /**
         * �����ݷ�����ȡ
         */
        String sf = sb.toString();
        String[] local_data=sf.split("\\n");
		sqlSession=MyBatisUtil.createSqlSession();
		String temp="";
		SensorLocal local=new SensorLocal();
		 try {
		        for(String ee:local_data)
		        {      	
		        	
		        	/**
		        	 * �����ݷ��������ȡ
		        	 */
			   		String[] tokens=ee.split("\\s");
			   		int n=0,i;
			   		 for(String t:tokens)
			   		 {
			   			 /**
			   			  * ȥ�����ַ����еĿ�ͷ���β�Ŀո�
			   			  */
			   			 String t1=t.trim();
			   			 
			   			 /**
			   			  * �����ݶ������ݿ�
			   			  */

		
			   			 	 if(n==0)
							 {	
			   			 		 Integer sensorId=Integer.parseInt(t1);
						         System.out.println(sensorId);
						         local.setSensorId(sensorId);
								// log.setRequestMechineIP(t1);
							 }
								 
							 if(n==1)
							 {
								 Double x=Double.parseDouble(t1);
								 local.setX(x);
								 
							 }
							 if(n==2)
							 {
								 Double y=Double.parseDouble(t1);
								 local.setY(y);
							 }
				
						n++;
			   		  }
			   			 
					count=sqlSession.getMapper(SensorLocalMapper.class).addSensorLocal(local);
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
		}
		logger.debug("��־�����У� "+log_n);
        logger.debug("�������ݿ�����־���� "+log_count);
		
	}
}
