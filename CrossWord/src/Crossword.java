import java.io.FileNotFoundException;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.*;

public class Crossword extends StackMethods {


    static char [][] WordList;
    static char [][] Board;
    static char [][] Output;

    static int foundRow;
    static int foundColum;


    public static final int x = 50, y = 50;

    public static void main(String[] args) throws FileNotFoundException {
        final long startTime = System.nanoTime();

        WordList = new char[x][y];
        Board = new char[x][y];
        Output = new char[x][y];

        StackMethods<String> stack = new StackMethods<String>();

        Scanner inputFile = null;
        Scanner Words = null;

        try {
            inputFile = new Scanner(new File("puzzleinput.txt"));
            Words = new Scanner(new File("wordlist.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        while (Words.hasNext()) {
            String line = Words.nextLine().toUpperCase();
            stack.push(line);
        }

        String words = " ";

        System.out.println("                                         Crossword Puzzle");
        System.out.print("\n");
        printFirst(words, inputFile);

        System.out.print("\n");
        System.out.print("\n");

        System.out.println("                                         Found Words");

        String word;
        int r = 0;

    while (!stack.isEmpty()) {
        word = stack.pop();

        for (int n = 0; n < x; n++) {

            for (int m = 0; m < y; m++) {

                if (WordList[n][m] == word.charAt(r)) {
                    foundRow = n;
                    foundColum = m;
                    checkCenterRight(word);
                    checkCenterLeft(word);
                    checkCenterBottom(word);
                    checkCenterTop(word);
                    checkTopRight(word);
                    checkTopLeft(word);
                    checkDownRight(word);
                    checkDownLeft(word);
                }
            }
        }
    }
    printFinal ();
    final long durationtime   = System.nanoTime() - startTime;
    final double seconds = ((double)durationtime / 1000000000);
    System.out.print("\n");
    System.out.print("\n");
    System.out.println("NanoTime:" + durationtime);
    System.out.println("Seconds:" + seconds);
    }




    static void printFirst (String words, Scanner inputFile) {

        for (int row = 0; row < x; row++) {

            words = inputFile.nextLine();

            int size = Math.min(words.length(), y);

            for (int col = 0; col < size; col++) {
                WordList[row][col] = words.charAt(col);

                System.out.print(WordList[row][col] + " ");
                Board[row][col] = '_';

                if (col == 49) {
                    System.out.print("\n");
                }
            }
        }
    }
    static void printFinal(){
        for (int row = 0; row < 50; row++) {

            for (int col = 0; col < 50; col++) {

                System.out.print(Board[row][col] + " ");

                if (col == 49) {
                    System.out.print("\n");
                }
            }
        }

    }
    static void checkCenterRight (String Wdsearch){

        for (int i = 1; i < Wdsearch.length(); i++)  {
            if (foundColum + i >= 50) return;
            if (WordList[foundRow][foundColum + i] != Wdsearch.charAt(i)) return;
        }
        for (int i = 0; i <Wdsearch.length(); i++){
            Board[foundRow][foundColum + i] = Wdsearch.charAt(i);
        }
        return;
    }
    static void checkCenterLeft (String Wdsearch){
        for (int i = 1; i < Wdsearch.length(); i++)  {
            if (foundColum - i < 0) return;
            if (WordList[foundRow][foundColum - i] != Wdsearch.charAt(i)) return;
        }
        for (int i = 0; i < Wdsearch.length(); i++){
            Board[foundRow][foundColum - i] = Wdsearch.charAt(i);
        }
        return;
    }

    static void checkCenterTop (String Wdsearch){
        for (int i = 1; i < Wdsearch.length(); i++)  {
            if (foundRow - i < 0) return;
            if (WordList[foundRow - i][foundColum] != Wdsearch.charAt(i)) return;
        }
        for (int i = 0; i <Wdsearch.length(); i++){
            Board[foundRow - i][foundColum] = Wdsearch.charAt(i);
        }
        return;
    }
    static void checkCenterBottom (String Wdsearch){
        for (int i = 1; i < Wdsearch.length(); i++)  {
            if (foundRow + i >= 50) return;
            if (WordList[foundRow + i][foundColum] != Wdsearch.charAt(i)) return;
        }
        for (int i = 0; i <Wdsearch.length(); i++){
            Board[foundRow + i ][foundColum] = Wdsearch.charAt(i);
        }
        return;
    }
    static void checkDownRight (String Wdsearch){
        for (int i = 1; i < Wdsearch.length(); i++)  {
            if (foundRow + i >= 50) return;
            if (foundColum + i >= 50) return;
            if (WordList[foundRow + i][foundColum + i] != Wdsearch.charAt(i)) return;
        }
        for (int i = 0; i <Wdsearch.length(); i++){
            Board[foundRow + i ][foundColum + i] = Wdsearch.charAt(i);
        }
        return;
    }
    static void checkDownLeft (String Wdsearch){
        for (int i = 1; i < Wdsearch.length(); i++)  {
            if (foundRow + i >= 50) return;
            if (foundColum - i < 0) return;
            if (WordList[foundRow + i][foundColum - i] != Wdsearch.charAt(i)) return;
        }
        for (int i = 0; i <Wdsearch.length(); i++){
            Board[foundRow + i ][foundColum - i] = Wdsearch.charAt(i);
        }
        return;
    }
    static void checkTopRight (String Wdsearch){
        for (int i = 1; i < Wdsearch.length(); i++)  {
            if (foundRow - i < 0) return;
            if (foundColum + i >= 50) return;
            if (WordList[foundRow - i][foundColum + i] != Wdsearch.charAt(i)) return;
        }
        for (int i = 0; i <Wdsearch.length(); i++){
            Board[foundRow - i ][foundColum + i] = Wdsearch.charAt(i);
        }
        return;
    }
    static void checkTopLeft (String Wdsearch){
        for (int i = 1; i < Wdsearch.length(); i++)  {
            if (foundRow - i < 0) return;
            if (foundColum - i < 0) return;
            if (WordList[foundRow - i][foundColum - i] != Wdsearch.charAt(i)) return;
        }
        for (int i = 0; i <Wdsearch.length(); i++){
            Board[foundRow - i ][foundColum - i] = Wdsearch.charAt(i);
        }
        return;
    }
}











