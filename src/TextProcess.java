import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextProcess {
	public static String HandleString(String s) 
	{
		String NotLetter = "[^a-zA-Z]";        //��ֵ�ַ����ϣ�ƥ�����ĸ�ַ�
		s=s.replaceAll(NotLetter," ");     //��s�����з���ĸ�ַ����ɿո�
		s=s.trim();                        //ȥ����β�ո�
		s=s+" ";                           //ÿ������һ���ո�
		s=s.replaceAll("\\s{1,}", " ");    //����\s�����ɼ��ַ����ո��Ʊ������ҳ������\\sƥ��\s��{1,}��ʾ����ƥ��1�Ρ���������Ŀո��滻��һ���ո�
		s=s.toLowerCase();                 //����д��ĸȫ������Сд��ĸ
		return s;
	}
	
 	public static String textProcess(File filepath)
	{
		StringBuilder result = new StringBuilder();//StringBuilder�������ڶ��ַ��������ظ��޸ĵĹ����д����������������
		try{
			BufferedReader br = new BufferedReader(new FileReader(filepath));//FileReader:���ļ�ת��Ϊ�ַ������룬BufferedReader:�ṩͨ�õĻ��巽ʽ�ı���ȡ�����Reader���ṩreadline���ж�ȡ
			String s = null;
			while((s=br.readLine())!=null)         //���ı�û����ʱ
			{
				s=HandleString(s);
				if(!"".equals(s.trim()))           //ȥ������
				{
					result.append(s);                  //�ַ�ƴ�ӵ�ĩβ
				}
			}
			result.deleteCharAt(result.length()-1);//ɾ�����һ���ո�
			br.close();                            //�ر���
		}catch(Exception e){                       //�쳣����
			e.printStackTrace();
		}
		return result.toString();                  //���ش�����ϵ��ַ���
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
