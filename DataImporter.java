/*ORIGINAL NOTE: I do not have outside knowledge about data importation in coding/Java, and with the accidental non-inclusion of instructions or an assignment related to learning how to import data from CSV's, I
felt like I wasn't prepared enough to do this part of the project. I was fortunate enough to receive some guidance from a fellow classmate on the project, and while I could've just copied the majority of their
work and/or use AI to teach me how to do it, I ultimately decided not to, as A) I felt as though rolling into class into class on Day 1 acting like I knew what I was doing would result in me being lost
for the rest of the year trying to catch up, and B) it didn't feel like an honest choice (also, AI is unpredicatable in the guidance it gives, and seeing as though the few instructions provided were limited,
the model could give me/teach me information I am not supposed to know). Therefore, my choice remains to skip this part for now until I can actually learn how to do it when class starts*/

/*NEW NOTE: with new knowledge in tow from class about data importation and its syntax, I was able to more-or-less complete the summer work finally. This code is likely not perfect, as despite the fact I 
know much better now how to analyze and read from CSV's, I do not know everything, and there is still a lot of instructions missing from the assignment which, for me, led to some unintented confusion
regarding how I was actually supposed to structure the codes and various methods. However, I still gave this assignment my best attempt and am otherwise happy with the result. I tested it to nauseum on
PickCode, and everything complies and works. Thank you for understanding*/

//Bo MacDonald - 9/7/2025 - Data importation and analysis

import java.util.Scanner;
import java.io.*;
public class DataImporter {

    public static void main(String [] args) throws IOException {

        //Two different scanners are made here, one to count the total lines of the csv and one used for the analysis methods
        File myFile = new File("superbowl.csv");
        Scanner lineCounter = new Scanner(myFile);
        Scanner reader = new Scanner(myFile);

        int lines = 0;
        while (lineCounter.hasNextLine()) {
            lineCounter.nextLine();
            lines++;
        }

        // (1/2) The data point method is called here to pick a data point (line)...
        int request = chooseDataPoint(lines);

        int counter = 0;
        String header = "";
        while (reader.hasNextLine()) {
            counter++;
            String tmp = reader.nextLine();
            if(header.length() == 0) {
                header = tmp;
            // (2/2) ...and, once that line equals the correct line needed in the other scanner, it outputs some statistics
            } else if (request == counter) {
                String date = extract(tmp, 0);
                String title = extract(tmp, 1);
                String winner  = extract(tmp, 2);
                double winAVG = Double.parseDouble(extract(tmp, 3));;
                String loser = extract(tmp, 4);
                double loseAVG = Double.parseDouble(extract(tmp, 5));

                //Calls constructor method to create a SuperBowl object
                SuperBowl sbowl = new SuperBowl(date, title, winner, winAVG, loser, loseAVG);
                System.out.println(sbowl);
            }
        }
        //The analyzeData method is called here
        analyzeData(myFile, header);
        lines--;

        //Final statistics round-up
        System.out.println("\nReading from: " + myFile);
        System.out.println("Number of records: " + lines);
        System.out.println("There are " + (countCommas(header))*lines + " data points in total, and " + (countCommas(header)) + " data points per record.");
    }

    // Method to extract the neccesary data from a tmp in the csv
    public static String extract(String data, int labelNum) {
        int count = 0;
        int index = 0;
        int nexti = data.indexOf(",", index);
        while (count < labelNum) {
            index = nexti + 1;
            nexti = data.indexOf(",", index + 1);
            if (nexti == -1)
                nexti = data.length();
            count++;
        }
        return data.substring(index, nexti);
    }

    //Method that counts the number of types of data (commas) in a data point/record
    public static int countCommas(String header) {
        int commas = 1;
        int index = 0;
        while (index < header.length()) {
            if (header.substring(index, index+1).equals(","))
                commas++;
            index++;
        }
        return commas;
    }

    //Method that asks for and returns the user's choice of which column they want to analyze
    public static int getColumnValue(String header) {
        int commas = countCommas(header);
        for (int i = 0; i < commas; i++) {
            System.out.println("Column " + i + ": " + extract(header, i));
        }
        int answer = -1;
        while (answer < 0 || answer >= commas) {
            answer = Custom.nextInt("\nWhich column number from 0 to " + (commas - 1) + " do you want to analyze? ");
        }
        return answer;
    }

    //Method that asks for and returns the user's choice of which data point (line) they want to analyze
    public static int chooseDataPoint(int lines) {
        System.out.println("There are " + (lines - 1) + " data lines total, numbering from line 1 to line " + lines);
        int register = 0;
        while (register < 1 || register > lines) {
            register = Custom.nextInt("Which data point (line number) would you like to analyze from the ones given above? ");
        }
        return register;
    }

    //Method that calls the getColumnValue method and uses scanners to read from the csv, loop through all the data from a certain column and then finds stats about it
    public static void analyzeData(File myFile, String header) throws IOException {
        Scanner reader = new Scanner(myFile);
        reader.nextLine(); //because it can't start on the header
        int columnValue = getColumnValue(header);
        double min = 0;
        double max = 0;
        double sum = 0;
        double count = 0;
        boolean firstNumber = true;

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String value = extract(line, columnValue);
            if (columnValue == 3 || columnValue == 5) {
                double num = Double.parseDouble(value);
                if (firstNumber) {
                    min = num;
                    max = num;
                    firstNumber = false;
                } else {
                    if (num < min) min = num;
                    if (num > max) max = num;
                }
                sum += num;
                count++;
            } else {
                System.out.println("Column " + columnValue + " contains no numbers, and therefore has no statistics.");
                break;
            }
        }
        double avg = sum / count;
        System.out.println("\nAverage of Column: " + avg + "\nMinimum of Column: " + min + "\nMaximum of Column: " + max);
    }
}
