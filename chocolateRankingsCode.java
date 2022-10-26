import java.util.*;
import java.io.*; //io --> input-output //* --> File
public class chocolateRankingsCode{

    public static void main(String[] args){
        
    }

    public static ArrayList<Double> parseCSVRatings(String filename) throws FileNotFoundException {
        Scanner key = new Scanner(new File(filename));
        String header = key.nextLine();

        while(key.hasNextLine() == true){
            //parsing each individual line
            String line = key.nextLine();
            String[] arrOfLine = fileScan.nextLine().split(",");
            ArrayList<String> alofLine = new ArrayList<>(Arrays.asList(arrOfLine));
            //also could convert manually into AL using for each loop

            //grabbing Ratings in each line
            //parsing header
            Stirng[] arrHeader = header.split(",");
            ArratList<String> headerAL = new ArrayList<String>(Arrays.asList(arrHeader));

            //creating arraylist for all values in Ratings column
            ArrayList<Double> ratings = new ArrayList<>();
            //getting index of Ratings in dataset
            int index = headerAL.indexOf("Ratings"); //finding index
            //adding value all the values in the Ratings col into arraylist
            ratings.add(Double.parseDouble(alOfLine.get(index)));
        }   
        key.close();
        return ratings;
    }

    public static ArrayList<String> parseCSVBeanOrigin(String filename) throws FileNotFoundException {
        Scanner key = new Scanner(new File(filename));
        String header = key.nextLine();

        while(key.hasNextLine() == true){
            //parsing each individual line
            String line = key.nextLine();
            String[] arrOfLine = fileScan.nextLine().split(",");
            ArrayList<String> alofLine = new ArrayList<>(Arrays.asList(arrOfLine));
            //also could convert manually into AL using for each loop

            //grabbing country of bean origin in each line
            //parsing header
            Stirng[] arrHeader = header.split(",");
            ArratList<String> headerAL = new ArrayList<String>(Arrays.asList(arrHeader));

            //creating arraylist for all values in country of bean origin column
            ArrayList<String> beanOriginCol = new ArrayList<>();
            //getting index of country of bean origin in dataset
            int index = headerAL.indexOf("Country of Bean Origin"); //finding index
            //adding value all the values in the bean origin col into arraylist
            beanOriginCol.add(alOfLine.get(index));
        }   
        key.close();
        return beanOriginCol;
    }

    public static String getHighestAveRating(ArrayList<String> comparison, ArrayListing<Ratings>){
        ArrayList<String> countries = new Arraylist<>();
        ArrayList<Integer> counts = new ArrayList<>();
        
        for(int i = 0; i<comparison.size(); i++){
            for(int j  0; j<countries.size; i++){
                if(comparisons.get(i).equals(countries.get(j))){
                    
                }
            }
        }
        


    }

}