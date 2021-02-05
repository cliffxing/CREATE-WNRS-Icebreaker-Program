import java.util.Scanner;
import java.util.Random;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * The program helps run tge CREATE WNRS icebreaker! Enter the 
 * number of delegates playing and begin the game. To give the next player
 * a wild card, enter 'W', and to start a team wildcard round, enter 'T'
 *
 * @Cliff Xing
 * @January 2021 
 */
public class Main
{
    // instance variables - replace the example below with your own
    private static String beginInput="";
    private static int numPlayers=0;
    private static boolean isDone = false;
    private static String questionInput;

    static Scanner scan= new Scanner(System.in);


    static Random int1 = new Random();
    static Random int2 = new Random();

   static  int playerRandom;
   static  int questionRandom;

    private static String[] questions;
    private static String[] wildcards;
    private static String[] teamcards;

    /**
     * Constructor for objects of class program
     */
    public static void main(String[] args)
    {
        questions = new String[]{ "What was your first impression of me?",
            "On a scale from 1-10, how messy do you think my room is?",
            "Do you think I like to read?",
            "What do you think I'm going to do in the future (work/employment)?",
            "Do you think I have any siblings? Older or younger?",
            "What fast food restaurant do you think i'm most likely to drive through? What's my order?",
            "Do you think I'm a morning person or a night owl? Why?",
            "What compliment do you think I hear the most?",
            "What subject do you think I thrive at school, do you think I failed any? ",
            "Do you think I'm usually early, late, or on time for events? ",
            "As a child, what do you think I wanted to be in the future? ",
            "What does my phone wallpaper tell you about me?",
            "If you were to buy me a present knowing nothing about me other than what i look like, what would it be?",
            "What do you think my go to karaoke song is?",
            "Do I seem like a coffee or tea person? Sweetened or unsweetened?",
            "What's the first thing you noticed about me?",
            "Who do you think my celebrity crush is?",
            "Do I remind you of anyone?",
            "Finish this sentence: Just by looking at me you'd think: __________",
            "What do you think im most likely to splurge on",
            "Do I seem like someone who would get a tattoo? Small or big? Why or why not?",
            "How many times do you think I've gotten detention in my life?",
            "Do I seem like more of a creative or analytical type?",
            "What does my outfit tell you about me?",
            "Do I seem like a cat or dog person?",
            "What reality show do you think I'm most likely to binge?",
            "How likely am I to go camping? How high maintenance is my set up?",
            "Do you think I intimidate others? Why or why not?",
            "Make an assumption about me.",
            "What do you think is my go-to drink order? (Starbucks or BBT?)"};
            
        wildcards = new String[] {"Show the first photo in your camera roll, explain", 
            "Read out loud your most recent note on your notes app, explain.",
            "Open safari/chrome/your internet browser and read the last thing you searched up. Explain.",
            "Sing the chorus of your favorite song of all time. Get into it!",
            "Share an embarrassing fun fact about yourselves?",
            "Press shuffle on your music library. Explain the first song that comes up!" };    

        teamcards = new String[] {"Think of your favourite childhood tv show of all time. On the count of three say it out loud (everyone)",
            "Think of your favourite brand of cereal. On the count of three say your answers out loud",
            "Draw a portrait of each other to the best of our ability (1 minute), then exchange",
            "Write down something others would never guess about you just by looking at you (both players), compare.",
            "Ask and answer the next question in a different accent (both players)",
            "Close your eyes: what colour is my shirt?"
        };

        initialize();
        beginGame();

    }

    public static void initialize(){
        System.out.println("Welcome to the CREATE WNRS Icebreaker! Program made by Cliff Xing");
        System.out.println("Please enter any key to begin");
        beginInput = scan.nextLine();

        while (isDone == false)
        {
            try
            {
                System.out.println("Please enter how many delegates are playing: ");
                numPlayers = scan.nextInt();
                scan.nextLine();
                System.out.println("The icebreaker will have "+numPlayers+" players.");
                System.out.println("Is this correct? (please type 'Y' to confirm, and anything else to change answer)");
                beginInput = scan.nextLine();
                if (beginInput.equals("Y") || beginInput.equals("y"))
                {
                    isDone = true;
                    break;
                }

            }
            catch (Exception e)
            {
                System.out.println("ERROR: Please enter a number!");
                scan.nextLine();
            }

        }

    }


    public static void beginGame()
    {
        
            questionInput = "";
        for (int i =1; i<numPlayers+1; i++)
        {
            playerRandom = int1.nextInt(numPlayers)+1;
            if (questionInput.equals("W") || questionInput.equals("w"))
            {
                questionRandom = int2.nextInt(wildcards.length);
                System.out.println("----------------------------");
                System.out.println("CREATE WNRS WILDCARD ROUND: "+i);
                System.out.println("To player "+i+": ");
                System.out.println("Question: "+wildcards[questionRandom]);
                System.out.println("Please enter any key to continue, or enter 'W' for individual wildcard, or 'T' for team wildcard");
                questionInput = scan.nextLine();
            }

            else 
            {
                while (i == playerRandom)
                {
                    playerRandom = int1.nextInt(numPlayers)+1;
                }
                questionRandom = int2.nextInt(questions.length);
                System.out.println("----------------------------");
                System.out.println("CREATE WNRS Icebreaker: Round "+i);
                System.out.println("Player "+playerRandom+" asks Player "+i);
                System.out.println("Question: "+questions[questionRandom]);
                System.out.println("Please enter any key to continue, or enter 'W' for individual wildcard, or 'T' for team wildcard");
                questionInput = scan.nextLine();
            }

            while (questionInput.equals("T") || questionInput.equals("t"))
            {
                questionRandom = int2.nextInt(teamcards.length);
                System.out.println("----------------------------");
                System.out.println("CREATE WNRS TEAM WILDCARD ROUND" );
                System.out.println("Question: "+teamcards[questionRandom]);
                System.out.println("Please enter any key to continue, or enter 'W' for individual wildcard, or 'T' for team wildcard");
                questionInput = scan.nextLine();
            }

        }
        System.out.println("Thanks for playing, and enjoy CREATE!");

        



    }

}




