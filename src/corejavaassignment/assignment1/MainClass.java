package corejavaassignment.assignment1;
import org.jsoup.Jsoup;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class MainClass {

    public static void countWords(String webPageContent) {
        File file = new File("src/corejavaassignment/assignment1/Words.txt");

        // Putting webpage content in the Arraylist and cleaning all the break words.
        ArrayList<String> list = new ArrayList<>();
        String delimiters = "[-\\s\\t,;.?!:@1234567890$&\\[\\](){}_*/\\+\r\n\"]";
        String[] words = webPageContent.split(delimiters);
        list.addAll(Arrays.asList(words));
        Collections.sort(list);

        //Removing blank spaces from Arraylist
        list.removeAll(Arrays.asList(" ", null));
        list.removeAll(Arrays.asList("", null));
        Map<String, Integer> map = new TreeMap<>();

        // Putting list into Map
        for(String arr : list){
            if (map.containsKey(arr)) {
                    map.put(arr, map.get(arr) + 1);
                } else {
                    map.put(arr, 1);
                }
        }

        //Copying Map elements to a sorted TreeMap in reverse order
        Map<Integer, String> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<String, Integer>  str : map.entrySet()){
            sortedMap.put(str.getValue(), str.getKey());
        }

        //Printing the values from the Map.

        Set set = sortedMap.entrySet();
        Iterator i = set.iterator();
        int flag = 0;
        System.out.println("========");
        while(i.hasNext()){
            Map.Entry entry = (Map.Entry) i.next();
            if(flag == 5)
                break;
            else {
                System.out.println(entry.getValue() + " - " + entry.getKey());
                flag++;
            }
        }
        System.out.println("========");

        // Writing the list to the file
        try(FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){

            for(String str : list){
                bufferedWriter.write(str + System.lineSeparator());
            }

        }catch (IOException ioException){
            ioException.getMessage();
        }
    }

    public static String getUrlContent(String url) throws IOException {

        String content = "";

        URL url1 = new URL(url);
        URLConnection urlConnection = url1.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content = content + line;
        }
        //content = content.replaceAll("\\<.*?\\>", "" );

        //Parsing HTML to text using Jsoup dependency.
        content = Jsoup.parse(content).body().text();
        content = content.toLowerCase();
        return content;
    }

    public static void readURL() {

        File file = new File("src/corejavaassignment/assignment1/url.text");

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String url = line;
                String webpageContent = getUrlContent(url);
                countWords(webpageContent);
                System.out.println(webpageContent);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readURL();
    }
}
