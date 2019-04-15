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
		 * 日志记录
		 */
		Logger logger=Logger.getLogger(AddDBsensorLocal.class);
		logger.debug("AddDBsensorLocal!==============================");
		SqlSession sqlSession=null;
		int count=0,log_count=0;
		
		/***
		 * 读入文件中的数据
		 */
        File file = new File("C:\\Users\\LYL\\Desktop\\最近论文\\1小论文版本更新\\数据集的资料\\位置坐标.txt");//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        int log_n=0;
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            System.out.println(s);
            log_n++;
        }
        bReader.close();
        
        /**
         * 将数据分条读取
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
		        	 * 将数据分数据项读取
		        	 */
			   		String[] tokens=ee.split("\\s");
			   		int n=0,i;
			   		 for(String t:tokens)
			   		 {
			   			 /**
			   			  * 去除子字符串中的开头与结尾的空格
			   			  */
			   			 String t1=t.trim();
			   			 
			   			 /**
			   			  * 将数据读入数据库
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
		logger.debug("日志总数有： "+log_n);
        logger.debug("插入数据库总日志数： "+log_count);
		
	}
}
