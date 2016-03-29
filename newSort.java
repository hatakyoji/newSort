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
            // 入力元ファイル、出力先ファイル
            File file = new File("C:/WORK/test.csv");
            //FileWriter fw = new FileWriter("C:/Users/kyoji-ha/Desktop/output.csv", true);  //※１
          	//PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
            br = new BufferedReader(new FileReader(file));
        	String line;
        	
            // １行づつ読み込み出力。
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
                // ストリームは必ず finally で close します。
                br.close();
            } catch (IOException e) {
            }
        }
        roop = i;
		
        //この時点でStrArrayに格納
		System.out.println(roop+"行読み込みました");  

		
        try {
          //出力先を作成する
          	FileWriter fw = new FileWriter("C:/Users/kyoji-ha/Desktop/output.csv", true);  //※１
          	PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
        	for(String key : map.keySet()){
        		
        		pw.println(key + "," + map.get(key).size());
        	}
        	//ファイルに書き出す
        	pw.close();

          //終了メッセージを画面に出力する
         // System.out.println("出力が完了しました。");

      }
		
		
		catch (IOException ex) {
          //例外時処理
          ex.printStackTrace();
      }
      
	}
    }

    /**
     * ファイルを読み込みます。
     *
     */
    