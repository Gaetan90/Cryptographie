import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Main {
	public static String keyS = "vrhpaf";
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String result = "";
		String resultCrypt = "";
		Crypto c = new Crypto();
		try {

            File f = new File("C:/Users/Gaetan90/Desktop/fichierCrypter/PA.txt");
            File dico = new File("C:/Users/Gaetan90/Desktop/fichierCrypter/liste_francais.txt");

            System.out.println("Reading files using Apache IO:");

            List<String> lines = FileUtils.readLines(f, "UTF-8");
            List<String> dicoL = FileUtils.readLines(dico, "UTF-8");
            for (String line : lines) {
            	System.out.println(c.decode_operation( line, keyS));
                resultCrypt += line;
            }
            System.out.println("Reading files using Apache IO2:");
          // System.out.println(c.decode_operation( resultCrypt, keyS));
            String key= "";
            String r = "";
            int nbrMot =0;
            String[] splitResult = null;
            char charAlphabet[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
            for(int a1 =5;a1<26;a1++){
    			for(int a2 =0;a2<26;a2++){
    				for(int a3 =15;a3<26;a3++){
    					for(int a4 =3;a4<26;a4++){
    						System.out.println(key);
    						for(int a5 =12;a5<26;a5++){
    							for(int a6 =15;a6<26;a6++){
    								c.spos =0;
    								key="";
    								key += charAlphabet[a6];
    								key +=charAlphabet[a5];
    								key +=charAlphabet[a4];
    								key +=charAlphabet[a3];
    								key +=charAlphabet[a2];
    								key +=charAlphabet[a1];
    								
    								result = c.decode_operation( resultCrypt, key);
    								r = result.substring(0,70);
    								splitResult = r.split(" ");
    								nbrMot =0;
    								for(int i=0 ; i<splitResult.length; i++){
    									if(dicoL.contains(splitResult[i])){
    										nbrMot++;
    									}
    								}
    								if(nbrMot>3){
    									System.out.println(key);
										System.out.println(result);
										System.exit(0);
    								}
    							
    								
    							}
    							
    						}
    					}
    				}
    			}
    		}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	

}
