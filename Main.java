import java.util.*; //Salman Syed Ahmed

public class Game {
    private Player player;          // The player object
    private Room[] rooms;           // Array to hold the rooms in the dungeon
    private Scanner scanner = new Scanner(System.in); // Input scanner

    public static void main(String[] args) {
        Game game = new Game();     // Create a new Game object
        game.startGame();           // Start the game
    }

    // Method to initialize the game setup
    public void startGame() {
        System.out.println("Dungeon Game - Welcome to the locked dungeon, where lives are lost on a daily basis (hehe). Few make it through. Will you be one of them…?
How to get out you ask?? Oh you didn't... Well that’s awkward... Well I'm going to tell you anyway. You have three rooms to get through. Each room will be different. The walls may close in, the floor may drop from under you. Who knows, you may be perfectly fine.
    You get the chance to find items in each room… What items you ask, well I'm not telling… you were very rude earlier.
Ok you twisted my arm.. Health is one of them… maybe more, maybe not. Could find a dead body, could find a secret room. Object of the game. Find the key to get out. Only have to go through 2 rooms to get there. 
Sounds simple, right? Well each room has three questions, you get two chances. Answer wrong , lose health and try again. All 3 must be correct to move on. Fail twice GAME OVER…. 
Once you reach the third room ….CONGRATULATIONS… you have reached the end only if you find the key that is. Well thats it…..Goood Luuck …(well the dragon’s got more dinner tonight…..)
");

        //**space for backstory to be added**//

        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Get player's name

        // Create a new player with 100 health points
        player = new Player(name, 100);

        // Create rooms for the game
        Room entrance = new Room("Entrance", "A dark and damp dungeon entrance.");
        Room treasureRoom = new Room("Treasure Room", "Glittering with mystery. Maybe something useful lies here.");
        Room exitRoom = new Room("Exit Room", "The heavy iron door stands before you, locked tight.");

        // Link rooms with directions (like a map)
        entrance.exits.put("forward", treasureRoom);
        treasureRoom.exits.put("back", entrance);
        treasureRoom.exits.put("forward", exitRoom);
        exitRoom.exits.put("back", treasureRoom);

        // Randomly place the key and potion between treasure room & exit room
        if (new Random().nextBoolean()) {
            treasureRoom.addItem("Key");
            exitRoom.addItem("Potion");
        } else {
            treasureRoom.addItem("Potion");
            exitRoom.addItem("Key");
        }

        // Store all rooms in the array
        rooms = new Room[]{entrance, treasureRoom, exitRoom};

        // Place the player in the entrance to start
        player.moveTo(entrance);

        // Begin the main game loop
        play();
    }

    // Method to display available actions to the player
    public void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Look around");      // See room description, items, exits
        System.out.println("2. Move");             // Move to another room
        System.out.println("3. Check inventory");  // See what items you have
        System.out.println("4. Use item");         // Use something from inventory
        System.out.println("5. Quit");             // Exit the game
        System.out.print("Choose an action: ");
    }

    // Main game loop - keeps running until player wins, dies, or quits
    public void play() {
        boolean running = true; // Controls the loop

        while (running) {
            // Check if the player has died
            if (player.getHealth() <= 0) {
                System.out.println("You have run out of health. Game over!");
                break;
            }

            // Check win condition: Player must have the key in inventory at the exit room
            if (player.getLocation().getName().equals("Exit Room")
                    && player.getLocation().getItems().contains("Key")
                    && player.getInventory().contains("Key")) {
                System.out.println("You unlock the door and escape! You win!");
                break;
            }

            // Show available actions to the player
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine()); // Read player's choice

            switch (choice) {
                case 1:
                    // Look around the room
                    System.out.println(player.getLocation().getDescription());
                    System.out.println("Items: " + player.getLocation().getItems());
                    System.out.println("Exits: " + player.getLocation().exits.keySet());
                    break;
                case 2:
                    // Move to another room
                    System.out.print("Which direction? ");
                    String direction = scanner.nextLine();
                    Room next = player.getLocation().exits.get(direction);

                    if (next != null) {
                        // If moving into Treasure Room, player must solve puzzle first
                        if (next.getName().equals("Treasure Room")) {
                            Puzzle puzzle = new Puzzle();
                            if (!puzzle.askQuestion()) {
                                player.takeDamage(20); // Wrong answer: lose health
                                System.out.println("Wrong! You lost health. Current health: " + player.getHealth());
                                break; // Stay in current room if puzzle failed
                            }
                        }
                        // Move to the next room if allowed
                        player.moveTo(next);
                        System.out.println("You moved to " + next.getName());
                    } else {
                        System.out.println("You can't go that way!");
                    }
                    break;
                case 3:
                    // Show player’s inventory
                    System.out.println("Inventory: " + player.getInventory());
                    break;
                case 4:
                    // Use an item from inventory
                    System.out.print("Enter item name to use: ");
                    String item = scanner.nextLine();
                    player.useItem(item);
                    break;
                case 5:
                    // Quit the game
                    System.out.println("You gave up. Game over.");
                    running = false;
                    break;
                default:
                    // Invalid input handling
                    System.out.println("Invalid choice.");
            }
        }
    }
}
