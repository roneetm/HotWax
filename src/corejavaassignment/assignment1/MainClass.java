package corejavaassignment.assignment1;

import org.jsoup.Jsoup;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {

    public static void readWords(){
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

    public static String getUrlContent(String url) throws IOException {

        String content ="";

        URL url1 = new URL(url);
        URLConnection urlConnection = url1.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String line;
        while( (line = bufferedReader.readLine()) != null){
            content = content  + line;
        }
        //content = content.replaceAll("\\<.*?\\>", "" );

        //Parsing HTML to text using Jsoup dependency.
        content = Jsoup.parse(content).body().text();
        return content;
    }
    public static void readURL(){

        File file = new File("src/corejavaassignment/assignment1/url.text");

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null){
                String url = line;
                String webpageContent = getUrlContent(url);
                System.out.println(webpageContent);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readURL();

    }
}
