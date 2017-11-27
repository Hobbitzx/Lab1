import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextProcess {
	public static String HandleString(String s) 
	{
		String NotLetter = "[^a-zA-Z]";        //负值字符集合，匹配非字母字符
		s=s.replaceAll(NotLetter," ");     //将s中所有非字母字符换成空格
		s=s.trim();                        //去掉首尾空格
		s=s+" ";                           //每行最后加一个空格
		s=s.replaceAll("\\s{1,}", " ");    //其中\s代表不可见字符（空格，制表符，换页符），\\s匹配\s，{1,}表示至少匹配1次。代表将多余的空格替换成一个空格
		s=s.toLowerCase();                 //将大写字母全部换成小写字母
		return s;
	}
	
 	public static String textProcess(File filepath)
	{
		StringBuilder result = new StringBuilder();//StringBuilder类解决了在对字符串进行重复修改的过程中创建大量对象的问题
		try{
			BufferedReader br = new BufferedReader(new FileReader(filepath));//FileReader:把文件转换为字符流读入，BufferedReader:提供通用的缓冲方式文本读取，针对Reader，提供readline分行读取
			String s = null;
			while((s=br.readLine())!=null)         //当文本没读完时
			{
				s=HandleString(s);
				if(!"".equals(s.trim()))           //去掉空行
				{
					result.append(s);                  //字符拼接到末尾
				}
			}
			result.deleteCharAt(result.length()-1);//删除最后一个空格
			br.close();                            //关闭流
		}catch(Exception e){                       //异常处理
			e.printStackTrace();
		}
		return result.toString();                  //返回处理完毕的字符串
	}
 	
	public static String Input()
	{
	    
			String input = null;
			try{
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				input = in.readLine();
			}catch(IOException e){
				e.printStackTrace();
			}
			return input;
	}
}
