import java.util.*;
import java.io.*; //io --> input-output //* --> File
public class chocolateRatingsCode{

    public static void main(String[] args){
        //testing helper methods: getRidOfDuplicates, counts, totRatings, averageRating
            //getRideOfDuplicates test
        ArrayList<String> testValues = new ArrayList<>(Arrays.asList("a", "b", "c", "a", "b", "d"));
        System.out.println(getRidOfDuplicates(testValues)); //should be ["a", "b", "c", "d"]
            //counts test
        System.out.println(counts(testValues)); //should be [2, 2, 1, 1]
            //totRatings test
        ArrayList<Double> testRatings = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 1.0, 2.0, 4.0));
        System.out.println(totRatings(testValues, testRatings)); //should be [2.0, 4.0, 3.0, 4.0]
            //averageRating test
        ArrayList<String> noDuplicates = getRidOfDuplicates(testValues);
        ArrayList<Integer> counts = counts(testValues);
        ArrayList<Double> totRatings = totRatings(testValues, testRatings);
        System.out.println(averageRating(noDuplicates, totRatings, counts)); //should be [1.0, 2.0, 3.0, 4.0]

        ArrayList<Double> averageRatings = averageRating(noDuplicates, totRatings, counts);
        System.out.println(highestAverageRating(averageRatings, noDuplicates));
        //getting all ratings in an AL (used in all questions)
        //ArrayList<Double> ratings = parseCSVRatings("/Users/espaulding/Desktop/chocolateRatingssAnalysis/ChocolateDataSet.csv");

        //question #1 --> which country of origin produces the best chocolate?
        //String questionOneCol = "Country of Bean Origin"
        //ArrayList<String> questionOneColAL = parseCSVCol("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv", questionOneCol);
        //ArrayList<String> questionOneColAlND = getRidOfDuplicates(questionOneColAL);
        //ArrayList<Integer> questionOneCounts = counts(questionOneColAlND);
        //ArrayList<Double> questionOneTotRatings = totRatings(questionOneColAlND, ratings);
        //ArrayList<Double> questionOneAverageRatings = averageRating(questionOneColAlND, questionOneTotRatings, questionOneCounts);



        //question #2 --> what cocoa percentage produces the best chocolate?
        //question #3 --> which company manufacturer gets the best ratings?
        //question #4 --> which year of doing these ratings has the highest average ratings? the lowest?
        
        
        //parseCSVBeanOrigin("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv");
    }

    //method to get AL of ratings
    public static ArrayList<Double> parseCSVRatings(String filename) throws FileNotFoundException {
        Scanner key = new Scanner(new File(filename));
        String header = key.nextLine();
        //parsing header
        String[] arrHeader = header.split(",");
        ArrayList<String> headerAL = new ArrayList<String>(Arrays.asList(arrHeader));

        //creating arraylist for all values in Ratings column
        ArrayList<Double> ratings = new ArrayList<>();

        //getting index of Ratings in dataset
        int index = headerAL.indexOf("Ratings"); //finding index

        while(key.hasNextLine() == true){
            //parsing each individual line
            String line = key.nextLine();
            String[] arrOfLine = line.split(",");
            ArrayList<String> alOfLine = new ArrayList<>(Arrays.asList(arrOfLine));
            //also could convert manually into AL using for each loop

            //grabbing Ratings in each line
            //adding value all the values in the Ratings col into arraylist
            ratings.add(Double.parseDouble(alOfLine.get(index)));
        }   
        key.close(); //closing scanner
        return ratings; //returning arraylist of column ratings
    }

    //method to get AL of a proposed col (input is file and name of col (ex. country of bean origin))
        //used to be for one col, but since most of other questions will use a similar method, wanted to paramaterize and make it more accessable/usable to entire class
    public static ArrayList<String> parseCSVCol(String filename, String colName) throws FileNotFoundException {
        Scanner key = new Scanner(new File(filename));
        String header = key.nextLine();
        //parsing header
        String[] arrHeader = header.split(",");
        ArrayList<String> headerAL = new ArrayList<String>(Arrays.asList(arrHeader));

        //creating arraylist for all values in the column
        ArrayList<String> col = new ArrayList<>();

        //getting index of column in dataset
        int index = headerAL.indexOf(colName); //finding index

        while(key.hasNextLine() == true){
            //parsing each individual line
            String line = key.nextLine();
            String[] arrOfLine = line.split(",");
            ArrayList<String> alOfLine = new ArrayList<>(Arrays.asList(arrOfLine));
            //also could convert manually into AL using for each loop

            //grabbing col in each line
            //adding value all the values in the col into arraylist
            col.add(alOfLine.get(index));
        }   
        key.close(); //closing scanner
        return col; //returning arraylist of column 
    }

    //method for question #1 --> which country of origin produces the best chocolate? (highest average)
    public static  String highestAverageRating(ArrayList<Double> averageRatings, ArrayList<String> noDuplicates){
        //test for the largest average
        double largest = averageRatings.get(0);
        //holder for the index of  the largest average rating
        int index = 0;
        //can use either noDuplicates or averageRatings bc they are parallel
        for(int i = 0; i<averageRatings.size(); i++){
            if(averageRatings.get(i) > largest){
                largest = averageRatings.get(i);
                index = i;
            }
        }
        //if tie, will just go to first index
        //should I not have return but have print of highest three?
        return noDuplicates.get(index);
    }

    //helper methods

    //helper method that takes out all the duplicates in an arraylist
    public static ArrayList<String> getRidOfDuplicates(ArrayList<String> withDuplicates){
        ArrayList<String> noDuplicates = new ArrayList<>();

        for(int i = 0; i < withDuplicates.size(); i++){
            if(noDuplicates.indexOf(withDuplicates.get(i)) == -1){
                noDuplicates.add(withDuplicates.get(i));
            }
        }
        return noDuplicates;
    }
    //helper method that returns how many times a specific item in an arraylist was mentioned; parallel to noDuplicates AL
    public static ArrayList<Integer> counts(ArrayList<String> withDuplicates){
        ArrayList<String> noDuplicates = new ArrayList<>(); //to make parallel to and for if/else expression

        //could call getRidOfDuplicates method but for sake of clarity and debugging gonna keep same code here
        for(int i = 0; i < withDuplicates.size(); i++){
            if(noDuplicates.indexOf(withDuplicates.get(i)) == -1){
                noDuplicates.add(withDuplicates.get(i));
            }
        }
        //ArrayList<Integer> counts = new ArrayList<>(Arrays.asList(new Integer[noDuplicates.size()]));
        //commented code above works for making counts AL parallel to noDuplicates, however, values are null (bc Integer is object type, not primiatve)

        //for loop so AL are the same size, however values aren't null
        ArrayList<Integer> counts = new ArrayList<>();
        for(int i = 0; i<noDuplicates.size(); i++){
            counts.add(0);
        }

        for(int i = 0; i<withDuplicates.size(); i++){
            //finding index of the item in the noDuplicates AL
            int index = noDuplicates.indexOf(withDuplicates.get(i));
            //getting value (num times that item has been said in withDuplicates AL) in counts at that same index (bc parallel arrays)
            Integer value = counts.get(index);
            //incrementing that value by 1
            value = value + 1;
            //setting that value at that same index
            counts.set(index, value);
        }
        return counts;
    }
    //helper method that gets the total of the ratings for a column
    public static ArrayList<Double> totRatings(ArrayList<String> withDuplicates, ArrayList<Double> ratings){
        //need this to get parallel index
        ArrayList<String> noDuplicates = getRidOfDuplicates(withDuplicates);

        //new AL for the totals of the rankings (parallel to noDuplicates)
        ArrayList<Double> totRatings = new ArrayList<>();
        //for loop so AL are the same size, however values aren't null
        for(int i = 0; i<noDuplicates.size(); i++){
            totRatings.add(0.0);
        }

        for(int i = 0; i<ratings.size(); i++){
            //finding index of the item in the noDuplicates AL
            int index = noDuplicates.indexOf(withDuplicates.get(i));
            //at that index, add the ratings
            Double tot = totRatings.get(index);
            //adding all ratings of that certain item together (can use i bc ratings is parallel to withDuplicates)
            tot = tot + ratings.get(i);
             //setting that value at that same index
            totRatings.set(index, tot);
        }
        return totRatings;
    }

    //helper method to calculate averages of ratings for a distict column
    public static ArrayList<Double> averageRating(ArrayList<String> noDuplicates, ArrayList<Double> totRatings, ArrayList<Integer> counts){
        ArrayList<Double> averageRating = new ArrayList<>();

        //since all AL input arrays should be parallel, can add averages one at a time
        for(int i = 0; i<noDuplicates.size(); i++){
            averageRating.add(totRatings.get(i)/counts.get(i));
        }

        return averageRating;
    }

}