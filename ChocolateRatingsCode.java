import java.util.*;
import java.io.*; //io --> input-output //* --> File
public class ChocolateRatingsCode {

    public static void main(String[] args) throws FileNotFoundException {
       /*
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
        System.out.println(highestAverageRating(averageRatings, noDuplicates)); //should be d
        */
        
        /*
        //test with smaller csv - yogurt brands
        ArrayList<Double> ratingsTest = parseCSVRatings("/Users/espaulding/Desktop/test.csv"); //testRatings

        String testCol = "Brand";
        ArrayList<String> testColAL = parseCSVStrings("/Users/espaulding/Desktop/test.csv", testCol); //testValues
        ArrayList<String> testColALND = getRidOfDuplicates(testColAL); //noDuplicates
        ArrayList<Integer> testCounts = counts(testColAL); //counts
        ArrayList<Double> testTotRatings = totRatings(testColAL, ratingsTest); //totRatings
        ArrayList<Double> testAveRatings = averageRating(testColALND, testTotRatings, testCounts); //averageRatings
        String testHAR = highestAverageRating(testAveRatings, testColALND);
        String testLAR = lowestAverageRating(testAveRatings, testColALND);
        Double testHARV = highestAverageRatingValue(testAveRatings, testColALND);
        Double testLARV = lowestAverageRatingValue(testAveRatings, testColALND);

        //print statements with questions and answers
        System.out.println("which yogurt brand has the greatest average rating?");
        System.out.println("answer: " + testHAR + " (average rating: " + testHARV + ")");
        System.out.println("the lowest?");
        System.out.println("answer: " + testLAR + " (average rating: " + testLARV + ")");
        */

        //**data set testing**
        System.out.println();
        System.out.println("Chocolate Rankings Dataset Questions:");
        System.out.println();

        //getting all ratings in an AL (used in all questions)
        ArrayList<Double> ratings = parseCSVRatings("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv"); //testRatings

        //question #1 --> which country of origin produces the best chocolate?
        String questionOneCol = "Country of Bean Origin";
        ArrayList<String> questionOneColAL = parseCSVStrings("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv", questionOneCol); //testValues
        ArrayList<String> questionOneColALND = getRidOfDuplicates(questionOneColAL); //noDuplicates
        ArrayList<Integer> questionOneCounts = counts(questionOneColAL); //counts
        ArrayList<Double> questionOneTotRatings = totRatings(questionOneColAL, ratings); //totRatings
        ArrayList<Double> questionOneAverageRatings = averageRating(questionOneColALND, questionOneTotRatings, questionOneCounts); //averageRatings
        String questionOneHAR = highestAverageRating(questionOneAverageRatings, questionOneColALND);
        String questionOneLAR = lowestAverageRating(questionOneAverageRatings, questionOneColALND);
        Double questionOneHARV = highestAverageRatingValue(questionOneAverageRatings, questionOneColALND);
        Double questionOneLARV = lowestAverageRatingValue(questionOneAverageRatings, questionOneColALND);


        //print statements with questions and answers
        System.out.println("which country of bean origin has the greatest average rating?");
        System.out.println("answer: " + questionOneHAR + " (average rating: " + questionOneHARV + ")");
        System.out.println("the lowest?");
        System.out.println("answer: " + questionOneLAR + " (average rating: " + questionOneLARV + ")");

        System.out.println();
        
        //question #2 --> what cocoa percentage produces the best chocolate?
        String questionTwoCol = "Cocoa Percent";
        ArrayList<String> questionTwoColAL = parseCSVStrings("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv", questionTwoCol); //testValues
        ArrayList<String> questionTwoColALND = getRidOfDuplicates(questionTwoColAL); //noDuplicates
        ArrayList<Integer> questionTwoCounts = counts(questionTwoColAL); //counts
        ArrayList<Double> questionTwoTotRatings = totRatings(questionTwoColAL, ratings); //totRatings
        ArrayList<Double> questionTwoAverageRatings = averageRating(questionTwoColALND, questionTwoTotRatings, questionTwoCounts); //averageRatings
        String questionTwoHAR = highestAverageRating(questionTwoAverageRatings, questionTwoColALND);
        String questionTwoLAR = lowestAverageRating(questionTwoAverageRatings, questionTwoColALND);
        Double questionTwoHARV = highestAverageRatingValue(questionTwoAverageRatings, questionTwoColALND);
        Double questionTwoLARV = lowestAverageRatingValue(questionTwoAverageRatings, questionTwoColALND);

        //print statements with questions and answers
        System.out.println("which cocoa percentage has the greatest average rating?");
        System.out.println("answer: " + questionTwoHAR + " (average rating: " + questionTwoHARV + ")");
        System.out.println("the lowest?");
        System.out.println("answer: " + questionTwoLAR + " (average rating: " + questionTwoLARV + ")");

        System.out.println();

        
        //question #3 --> which company manufacturer gets the best ratings?
        String questionThreeCol = "Company (Manufacturer)";
        ArrayList<String> questionThreeColAL = parseCSVStrings("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv", questionThreeCol);
        ArrayList<String> questionThreeColALND = getRidOfDuplicates(questionThreeColAL);
        ArrayList<Integer> questionThreeCounts = counts(questionThreeColAL);
        ArrayList<Double> questionThreeTotRatings = totRatings(questionThreeColAL, ratings);
        ArrayList<Double> questionThreeAverageRatings = averageRating(questionThreeColALND, questionThreeTotRatings, questionThreeCounts);
        String questionThreeHAR = highestAverageRating(questionThreeAverageRatings, questionThreeColALND);
        String questionThreeLAR = lowestAverageRating(questionThreeAverageRatings, questionThreeColALND);
        Double questionThreeHARV = highestAverageRatingValue(questionThreeAverageRatings, questionThreeColALND);
        Double questionThreeLARV = lowestAverageRatingValue(questionThreeAverageRatings, questionThreeColALND);

        //print statements with questions and answers
        System.out.println("which company/manufacturer has the greatest average rating?");
        System.out.println("answer: " + questionThreeHAR + " (average rating: " + questionThreeHARV + ")");
        System.out.println("the lowest?");
        System.out.println("answer: " + questionThreeLAR + " (average rating: " + questionThreeLARV + ")");

        System.out.println();
        
        
        //question #4 --> which year of doing these ratings has the highest average ratings? the lowest?
        String questionFourCol = "Review Date";
        //ArrayList<String> questionOneColAL = parseCSVStrings("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv", questionOneCol);
        ArrayList<String> questionFourColAL = parseCSVStrings("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv", questionFourCol); //testValues
        ArrayList<String> questionFourColALND = getRidOfDuplicates(questionFourColAL); //noDuplicates
        ArrayList<Integer> questionFourCounts = counts(questionFourColAL); //counts
        ArrayList<Double> questionFourTotRatings = totRatings(questionFourColAL, ratings); //totRatings
        ArrayList<Double> questionFourAverageRatings = averageRating(questionFourColALND, questionFourTotRatings, questionFourCounts); //averageRatings
        String questionFourHAR = highestAverageRating(questionFourAverageRatings, questionFourColALND);
        String questionFourLAR = lowestAverageRating(questionFourAverageRatings, questionFourColALND);
        Double questionFourHARV = highestAverageRatingValue(questionFourAverageRatings, questionFourColALND);
        Double questionFourLARV = lowestAverageRatingValue(questionFourAverageRatings, questionFourColALND);

         //print statements with questions and answers
        System.out.println("which year of these reviews has the greatest average rating?");
        System.out.println("answer: " + questionFourHAR + " (average rating: " + questionFourHARV + ")");
        System.out.println("the lowest?");
        System.out.println("answer: " + questionFourLAR + " (average rating: " + questionFourLARV + ")");

        System.out.println();
        
        //parseCSVBeanOrigin("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv");
    }

    //method to get AL of ratings
    public static ArrayList<Double> parseCSVRatings(String filename) throws FileNotFoundException {
        Scanner key = new Scanner(new File(filename));
        String header = key.nextLine();
        //parsing header
        String[] arrHeader = header.split(",");
        ArrayList<String> headerAL = new ArrayList<String>(Arrays.asList(arrHeader));

        //creating arraylist for all values in Rating column
        ArrayList<Double> ratings = new ArrayList<>();

        //getting index of Rating in dataset
        int index = headerAL.indexOf("Rating"); //finding index

        while(key.hasNextLine() == true){
            //parsing each individual line
            String line = key.nextLine();
            String[] arrOfLine = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            ArrayList<String> alOfLine = new ArrayList<>(Arrays.asList(arrOfLine));
            //also could convert manually into AL using for each loop

            //grabbing Rating in each line
            //adding value all the values in the Rating col into arraylist
            ratings.add(Double.parseDouble(alOfLine.get(index)));
        }   
        key.close(); //closing scanner
        return ratings; //returning arraylist of column ratings
    }

    //method to get AL of a proposed col that holds strings (input is file and name of col (ex. country of bean origin))
        //used to be for one col, but since most of other questions will use a similar method, wanted to paramaterize and make it more accessable/usable to entire class
    public static ArrayList<String> parseCSVStrings(String filename, String colName) throws FileNotFoundException {
        Scanner key = new Scanner(new File(filename));
        String header = key.nextLine();
        //parsing header
        String[] arrHeader = header.split(",");
        ArrayList<String> headerAL = new ArrayList<String>(Arrays.asList(arrHeader));

        //creating arraylist for all values in the column that are Strings
        ArrayList<String> col = new ArrayList<>();

        //getting index of column in dataset
        int index = headerAL.indexOf(colName); //finding index

        while(key.hasNextLine() == true){
            //parsing each individual line
            String line = key.nextLine();
            String[] arrOfLine = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
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
    public static String highestAverageRating(ArrayList<Double> averageRatings, ArrayList<String> noDuplicates){
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
        return noDuplicates.get(index);
    }

    //gets the average rating value so the viewer can see the rating of the highest term
    public static Double highestAverageRatingValue(ArrayList<Double> averageRatings, ArrayList<String> noDuplicates){
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
        return averageRatings.get(index);
    }

    public static String lowestAverageRating(ArrayList<Double> averageRatings, ArrayList<String> noDuplicates){
        //test for the lowest average
        double lowest = averageRatings.get(0);
        //holder for the index of  the lowest average rating
        int index = 0;
        //can use either noDuplicates or averageRatings bc they are parallel
        for(int i = 0; i<averageRatings.size(); i++){
            if(averageRatings.get(i) < lowest){
                lowest = averageRatings.get(i);
                index = i;
            }
        }
        //if tie, will just go to first index
        return noDuplicates.get(index);
    }

    //gets the average rating value so the viewer can see the rating of the lowest term
    public static Double lowestAverageRatingValue(ArrayList<Double> averageRatings, ArrayList<String> noDuplicates){
        //test for the lowest average
        double lowest = averageRatings.get(0);
        //holder for the index of  the lowest average rating
        int index = 0;
        //can use either noDuplicates or averageRatings bc they are parallel
        for(int i = 0; i<averageRatings.size(); i++){
            if(averageRatings.get(i) < lowest){
                lowest = averageRatings.get(i);
                index = i;
            }
        }
        //if tie, will just go to first index
        return averageRatings.get(index);
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