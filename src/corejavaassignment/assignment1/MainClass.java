package corejavaassignment.assignment1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/corejavaassignment/assignment1/Words.txt");
        HashMap<String, Integer> map = new HashMap<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            while((line = bufferedReader.readLine()) != null){

                if(map.containsKey(line)) {
                    map.put(line, map.get(line)+1);
                }
                else {
                    map.put(line, 1);
                }
                //System.out.println(line);
            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }

        Map<String, Integer> hashMap = new TreeMap<>(map);
//        for(Map.Entry<String, Integer> entry : map.entrySet() ){
//            System.out.println(entry);
//        }
        System.out.println(hashMap);
    }
}
