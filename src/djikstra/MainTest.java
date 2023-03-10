package djikstra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainTest {
	
	public static int getOracle(String line) {
		
		GraphReader gr = new GraphReader();
		int curValue = 0;
		char curChar = line.charAt(curValue);
		for( ; curChar != '@';  ) {
			
			curValue ++ ;
			curChar = line.charAt(curValue);

		}
		
		
		curValue ++ ;
		
		curChar = line.charAt(curValue);
		int oracle;
		if(Character.isDigit(curChar)) {
			
			int [] oracleInfo = gr.readNumber(line, curChar, curValue);	
			oracle = oracleInfo[0];
			
		}else {
			oracle = -1;
		}
		
		return oracle ;
		
	}

	public static void main(String[] args) {
		
    	File inputFile = new  File("./tests/test_input.txt"); 
    	File outputFile = new File("./tests/test_output.txt");
    	GraphReader graphReader = new GraphReader();
    	
	
		try(FileReader fr = new FileReader(inputFile);
			FileWriter fw = new FileWriter(outputFile,false);
			BufferedReader br = new BufferedReader(fr) ){

			String line ;
			while( (line = br.readLine()) != null && line.length() > 0) {
				
				ShortestPaths djikstra = new ShortestPaths();
				graphReader.readLine(line);
				Integer minCost = djikstra.findShortestPaths(graphReader.getGraph(), graphReader.getSource(), graphReader.getNbNodes(), graphReader.getDestination());
				Integer oracle = getOracle(line);
				String result = "oracle = " + oracle + "\n"
								+"coût minimum calculé = " + minCost + "\n" ;
				if(minCost == oracle) {
					result += "Test réussi\n";
						
				}else {
					result += "Test échoué\n";
				}
				
				fw.write(result);
				
			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
