import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;

public class newSort{

	public static void main(String[] args) {
 //   	String[] StrArray = new String[1500000000];
    	
    	BufferedReader br = null;
    	int i = 0;
    	int roop = 0;
		int j = 0;
    	Map<String, Map<String,String>> map = new HashMap<String, Map<String,String>>(1300000);

        try {
            // ���͌��t�@�C���A�o�͐�t�@�C��
            File file = new File("C:/WORK/test.csv");
            //FileWriter fw = new FileWriter("C:/Users/kyoji-ha/Desktop/output.csv", true);  //���P
          	//PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
            br = new BufferedReader(new FileReader(file));
        	String line;
        	
            // �P�s�Âǂݍ��ݏo�́B
            while ((line = br.readLine()) != null) {
            	String[] split = line.split(",",-1);

            	j++;
            	
            	if(map.containsKey(split[0])){
            		if(map.get(split[0]).containsKey(split[1])){
           				;
            		}else{
            			map.get(split[0]).put(split[1],split[0]);
            			i++;
            			if(map.containsKey(split[1])){
            				map.get(split[1]).put(split[0],split[1]);
            				i++;
            			}else{
            				map.put(split[1], new HashMap<String,String>());
            				map.get(split[1]).put(split[0],split[1]);
            				i++;
            			}
            		}
            	}else{
            		map.put(split[0], new HashMap<String,String>());
           			map.get(split[0]).put(split[1],split[0]);
            		i++;
            		if(map.containsKey(split[1])){
            			map.get(split[1]).put(split[0],split[1]);
            			i++;
            		}else{
            		map.put(split[1], new HashMap<String,String>());
            		map.get(split[1]).put(split[0],split[1]);
            		i++;
            		}
            	}
            	
            	
            	if(j%100==0) System.out.println(j);
            	
            }
        	
        	//pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // �X�g���[���͕K�� finally �� close ���܂��B
                br.close();
            } catch (IOException e) {
            }
        }
        roop = i;
		
        //���̎��_��StrArray�Ɋi�[
		System.out.println(roop+"�s�ǂݍ��݂܂���");  

		
        try {
          //�o�͐���쐬����
          	FileWriter fw = new FileWriter("C:/Users/kyoji-ha/Desktop/output.csv", true);  //���P
          	PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
        	for(String key : map.keySet()){
        		
        		pw.println(key + "," + map.get(key).size());
        	}
        	//�t�@�C���ɏ����o��
        	pw.close();

          //�I�����b�Z�[�W����ʂɏo�͂���
         // System.out.println("�o�͂��������܂����B");

      }
		
		
		catch (IOException ex) {
          //��O������
          ex.printStackTrace();
      }
      
	}
    }

    /**
     * �t�@�C����ǂݍ��݂܂��B
     *
     */
    