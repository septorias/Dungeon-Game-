import java.util.Scanner; // start of code for Zykia Tinkler
public class Quizquestions {
    // This will take care of the questions that are asked for user to advance to the next room
    // They get two tries before game over if all three answered correctly the advance to the next room
    // Missing a question means losing health. There is one potion in each room to gain health
    // The key to get out is in room three once all questions answered correctly you find the key
    // 3 question per room related to dungeons, this has to call the player and the room number
    //when that code is done it can be adding to this method
    public boolean Questionset1(player, int roomnumber);
        Scanner scanner = new Scanner(System.in);
        questionscorrect = 0; // name for health and questionscorrect may change based on what group members did
        playerhealth = 30;
        attempt = 0;

        for (int attempt = 1; int attempt <= 2; int attempt ++){
            int correct = 0;// name of room num may change based on who did that room file
            System.out.println("Welcome to Room" + roomNumber + "You have two tries to answer three questions correctly or game over.");

            //Questions for room 2
        System.out.println("How many rooms do you have to get through before you get the key?: " );
        if (scanner.nextLine().equalsIgnoreCase("2"));
            questionscorrect ++;
        else playerealth - 10;

        System.out.println("What movie has an orge, a donkey, and a princess/orge?:");
        if (scanner.nextLine().equalsIgnoreCase("sherek"));
        questionscorrect ++;
        else playerealth - 10;

        System.out.println("What runs but never walks, often mummers but never talks,has a bed but never sleeps, and an open mouth that never eats?:");
        if (scanner.nextLine().equalsIgnoreCase("river"));
        questionscorrect ++;
        else playerealth - 10;


        //Questions for room 1
        System.out.println("What room are you currently in?: " );
        if (scanner.nextLine()== roomnumber);
        questionscorrect ++;
        else playerealth - 10;

        System.out.println("How much health do you lose when you answer a question wrong?:");
        if (scanner.nextLine().equalsIgnoreCase("10");
        questionscorrect ++;
        else playerealth - 10;

        System.out.println("what do you need to get out of the locked dungeon (hint:one word)?:");
        if (scanner.nextLine().equalsIgnoreCase("key"));
        questionscorrect ++;
        else playerealth - 10;
        //have to check answers
        if (questionscorrect == 3) {
            System.out.println("Good Job, On to the next room");
            return true;
        } else {
            System.out.println("Not quite, Try again");
        }
            // failed both attempts
        System.out.println("Hmmm I expected more from you, GAME OVER!!!!");
        return false;
        }// End of code for Zykia Tinkler











}