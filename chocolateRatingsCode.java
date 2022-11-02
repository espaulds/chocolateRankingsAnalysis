import java.util.*;
import java.io.*; //io --> input-output //* --> File
public class ChocolateRatingsCode {

    public static void main(String[] args) throws FileNotFoundException {
        //**data set testing**
        System.out.println();
        System.out.println("Chocolate Ratings Dataset Questions:");
        System.out.println();

        //getting all ratings in an AL (used in all questions)
        ArrayList<Double> ratings = parseCSVRatings("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv"); //testRatings

        //question #1 --> which country of origin produces the best chocolate?
        //header that the program wants to get from the CSV file
        String questionOneCol = "Country of Bean Origin";
        //ArrayList holding the String values within the column being parsed
        ArrayList<String> questionOneColAL = parseCSVStrings("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv", questionOneCol); //testValues
        //parsed ArrayList but with no duplicate values
        ArrayList<String> questionOneColALND = getRidOfDuplicates(questionOneColAL); //noDuplicates
        //ArrayList (parallel to original parsed ArrayList) that holds the count of how many times an item was mentioned
        ArrayList<Integer> questionOneCounts = counts(questionOneColAL); //counts
        //ArrayList that holds the rating totals of each item(parallel to noDuplicates)
        ArrayList<Double> questionOneTotRatings = totRatings(questionOneColAL, ratings); //totRatings
        //ArrayList that holds the average rating for each item (parallel to noDuplicates)
        ArrayList<Double> questionOneAverageRatings = averageRating(questionOneColALND, questionOneTotRatings, questionOneCounts); //averageRatings
        //String that holds the item with the highest average rating
        String questionOneHAR = highestAverageRating(questionOneAverageRatings, questionOneColALND);
        //String that holds the item with the lowest average rating
        String questionOneLAR = lowestAverageRating(questionOneAverageRatings, questionOneColALND);
        //Double that holds the value of the item with the highest average rating
        Double questionOneHARV = highestAverageRatingValue(questionOneAverageRatings);
        //Double that holds the value of the item with the lowest average rating
        Double questionOneLARV = lowestAverageRatingValue(questionOneAverageRatings);


        //print statements with questions and answers
        System.out.println("#1: which country of bean origin has the greatest average rating?");
        System.out.println("answer: " + questionOneHAR + " (average rating: " + questionOneHARV + ")");
        System.out.println("the lowest?");
        System.out.println("answer: " + questionOneLAR + " (average rating: " + questionOneLARV + ")");

        System.out.println();
        
        //question #2 --> what cocoa percentage produces the best chocolate?
        String questionTwoCol = "Cocoa Percent";
        ArrayList<String> questionTwoColAL = parseCSVStrings("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv", questionTwoCol); 
        ArrayList<String> questionTwoColALND = getRidOfDuplicates(questionTwoColAL); 
        ArrayList<Integer> questionTwoCounts = counts(questionTwoColAL); 
        ArrayList<Double> questionTwoTotRatings = totRatings(questionTwoColAL, ratings);
        ArrayList<Double> questionTwoAverageRatings = averageRating(questionTwoColALND, questionTwoTotRatings, questionTwoCounts); 
        String questionTwoHAR = highestAverageRating(questionTwoAverageRatings, questionTwoColALND);
        String questionTwoLAR = lowestAverageRating(questionTwoAverageRatings, questionTwoColALND);
        Double questionTwoHARV = highestAverageRatingValue(questionTwoAverageRatings);
        Double questionTwoLARV = lowestAverageRatingValue(questionTwoAverageRatings);

        //print statements with questions and answers
        System.out.println("#2: which cocoa percentage has the greatest average rating?");
        System.out.println("answer: " + questionTwoHAR + " (average rating: " + questionTwoHARV + ")");
        System.out.println("the lowest?");
        System.out.println("answer: " + questionTwoLAR + " (average rating: " + questionTwoLARV + ")");

        System.out.println();

        
        //question #3 --> which company manufacturer gets the best ratings?
        String questionThreeACol = "Company Location";
        ArrayList<String> questionThreeAColAL = parseCSVStrings("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv", questionThreeACol);
        ArrayList<String> questionThreeAColALND = getRidOfDuplicates(questionThreeAColAL);
        ArrayList<Integer> questionThreeACounts = counts(questionThreeAColAL);
        ArrayList<Double> questionThreeATotRatings = totRatings(questionThreeAColAL, ratings);
        ArrayList<Double> questionThreeAAverageRatings = averageRating(questionThreeAColALND, questionThreeATotRatings, questionThreeACounts);
        String questionThreeAHAR = highestAverageRating(questionThreeAAverageRatings, questionThreeAColALND);
        String questionThreeALAR = lowestAverageRating(questionThreeAAverageRatings, questionThreeAColALND);
        Double questionThreeAHARV = highestAverageRatingValue(questionThreeAAverageRatings);
        Double questionThreeALARV = lowestAverageRatingValue(questionThreeAAverageRatings);

        //print statements with questions and answers
        System.out.println("#3A: which country producing chocolate bars has the greatest average rating?");
        System.out.println("answer: " + questionThreeAHAR + " (average rating: " + questionThreeAHARV + ")");
        System.out.println("the lowest?");
        System.out.println("answer: " + questionThreeALAR + " (average rating: " + questionThreeALARV + ")");

        System.out.println();
        
        String questionThreeBCol = "Company (Manufacturer)";
        ArrayList<String> questionThreeBColAL = parseCSVStrings("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv", questionThreeBCol);
        ArrayList<String> questionThreeBColSpecificAL = specificItems(questionThreeAColAL, questionThreeBColAL, questionThreeAHAR);
        ArrayList<String> questionThreeBColSpecificALND = getRidOfDuplicates(questionThreeBColSpecificAL);
        ArrayList<Integer> questionThreeBCounts = counts(questionThreeBColSpecificAL);
        ArrayList<Double> questionThreeBTotRatings = totRatings(questionThreeBColSpecificAL, ratings);
        ArrayList<Double> questionThreeBAverageRatings = averageRating(questionThreeBColSpecificALND, questionThreeBTotRatings, questionThreeBCounts);
        String questionThreeBHAR = highestAverageRating(questionThreeBAverageRatings, questionThreeBColSpecificALND);
        Double questionThreeBHARV = highestAverageRatingValue(questionThreeBAverageRatings);

        //print statements with questions and answers
        System.out.println("#3B: which company/manufacturer within <" + questionThreeAHAR + "> has the greatest average rating?");
        System.out.println("answer: " + questionThreeBHAR + " (average rating: " + questionThreeBHARV + ")");
        
        System.out.println();

        //question #4 --> which year of doing these ratings has the highest average ratings? the lowest?
        String questionFourCol = "Review Date";
        ArrayList<String> questionFourColAL = parseCSVStrings("/Users/espaulding/Desktop/chocolateRatingsAnalysis/ChocolateDataSet.csv", questionFourCol); 
        ArrayList<String> questionFourColALND = getRidOfDuplicates(questionFourColAL); 
        ArrayList<Integer> questionFourCounts = counts(questionFourColAL);
        ArrayList<Double> questionFourTotRatings = totRatings(questionFourColAL, ratings);
        ArrayList<Double> questionFourAverageRatings = averageRating(questionFourColALND, questionFourTotRatings, questionFourCounts);
        String questionFourHAR = highestAverageRating(questionFourAverageRatings, questionFourColALND);
        String questionFourLAR = lowestAverageRating(questionFourAverageRatings, questionFourColALND);
        Double questionFourHARV = highestAverageRatingValue(questionFourAverageRatings);
        Double questionFourLARV = lowestAverageRatingValue(questionFourAverageRatings);

         //print statements with questions and answers
        System.out.println("#4: which year of these reviews has the greatest average rating?");
        System.out.println("answer: " + questionFourHAR + " (average rating: " + questionFourHARV + ")");
        System.out.println("the lowest?");
        System.out.println("answer: " + questionFourLAR + " (average rating: " + questionFourLARV + ")");
    }

    //method to get AL of ratings
    public static ArrayList<Double> parseCSVRatings(String filename) throws FileNotFoundException {
        Scanner key = new Scanner(new File(filename));
        String header = key.nextLine();
        //parsing header
        String[] arrHeader = header.split(",");
        ArrayList<String> headerAL = new ArrayList<String>(Arrays.asList(arrHeader));

        //creating ArrayList for all values in Rating column
        ArrayList<Double> ratings = new ArrayList<>();

        //getting index of Rating in dataset
        int index = headerAL.indexOf("Rating"); //finding index

        while(key.hasNextLine() == true){
            //parsing each individual line
            String line = key.nextLine();
            //splits the tokens up in a line with the delimeter (","), but accounts for if the comma is within quotes (won't be read as a delimeter)
            String[] arrOfLine = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            ArrayList<String> alOfLine = new ArrayList<>(Arrays.asList(arrOfLine));

            //grabbing Rating in each line
            //adding value all the values in the Rating col into ArrayList
            ratings.add(Double.parseDouble(alOfLine.get(index)));
        }   
        key.close(); //closing scanner
        return ratings; //returning ArrayList of column ratings
    }

    //method to get AL of a proposed col that holds strings (input is file and name of col (ex. country of bean origin))
        //used to be for one col, but since most of other questions will use a similar method, wanted to paramaterize and make it more accessable/usable to entire class
    public static ArrayList<String> parseCSVStrings(String filename, String colName) throws FileNotFoundException {
        Scanner key = new Scanner(new File(filename));
        String header = key.nextLine();
        //parsing header
        String[] arrHeader = header.split(",");
        ArrayList<String> headerAL = new ArrayList<String>(Arrays.asList(arrHeader));

        //creating ArrayList for all values in the column that are Strings
        ArrayList<String> col = new ArrayList<>();

        //getting index of column in dataset
        int index = headerAL.indexOf(colName); //finding index

        while(key.hasNextLine() == true){
            //parsing each individual line
            String line = key.nextLine();
             //splits the tokens up in a line with the delimeter (","), but accounts for if the comma is within quotes (won't be read as a delimeter)
            String[] arrOfLine = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            ArrayList<String> alOfLine = new ArrayList<>(Arrays.asList(arrOfLine));

            //grabbing col in each line
            //adding value all the values in the col into ArrayList
            col.add(alOfLine.get(index));
        }   
        key.close(); //closing scanner
        return col; //returning ArrayList of column 
    }

   //method that finds and returns the item within the noDuplicates ArrayList that has the highest average rating
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
    public static Double highestAverageRatingValue(ArrayList<Double> averageRatings){
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

    //method that finds and returns the item within the noDuplicates ArrayList that has the lowest average rating
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
    public static Double lowestAverageRatingValue(ArrayList<Double> averageRatings){
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

    //helper method that takes out all the duplicates in an Array:ist
    public static ArrayList<String> getRidOfDuplicates(ArrayList<String> withDuplicates){
        ArrayList<String> noDuplicates = new ArrayList<>();

        for(int i = 0; i < withDuplicates.size(); i++){
            if(noDuplicates.indexOf(withDuplicates.get(i)) == -1){
                noDuplicates.add(withDuplicates.get(i));
            }
        }
        return noDuplicates;
    }

    //helper method that returns how many times a specific item in an ArrayList was mentioned; parallel to noDuplicates AL
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

        //loops through the length of withDuplicates (parallel to ratings for original question, but makes more local to whatever is input (for question #3))
        for(int i = 0; i<withDuplicates.size(); i++){
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
    
    //methods specifically for newly added question 3B which is finding the best rated chocolate manufacturer from the best rated country of production
    //method gets only the items from one column based on the prior one
    public static ArrayList<String> specificItems(ArrayList<String> priorCol, ArrayList<String> currentCol, String item){
        ArrayList<String> onlyItem = new ArrayList<>();
        for(int i = 0; i<priorCol.size(); i++){
            if(priorCol.get(i).equals(item)){
                onlyItem.add(currentCol.get(i));
            }
        }
        return onlyItem;
    }
}
