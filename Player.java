import java.util.ArrayList;

public class Player {
    public String location;
    public ArrayList<String> inventory;

    // Default constructor
    public Player() {
    }

    // Overloaded constructor
    public Player(String startLocation) {
        this.location = startLocation;
        this.inventory = new ArrayList<String>();
    }

    // Move to a new location
    public void moveTo(String newLocation) {
        this.location = newLocation;
        System.out.println("You move to " + newLocation + ".");
    }

    // Pick up an item
    public void pickUp(String item) {
        inventory.add(item);
        System.out.println("You picked up " + item + ".");
    }

    // Drop an item
    public void drop(String item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            System.out.println("You dropped " + item + ".");
        } else {
            System.out.println("You don't have " + item + ".");
        }
    }

    // Look at an item
    public void lookAt(String item) {
        if (inventory.contains(item)) {
            System.out.println("You look at the " + item + ". It seems useful.");
        } else {
            System.out.println("You don't have " + item + " to look at.");
        }
    }

    // Use an item
    public void use(String item) {
        if (inventory.contains(item)) {
            System.out.println("You use the " + item + ".");
            // Add additional logic here
        } else {
            System.out.println("You don't have " + item + " to use.");
        }
    }

    // Eat an item
    public void eat(String item) {
        if (inventory.contains(item)) {
            inventory.remove(item);  // Assume it's consumed
            System.out.println("You eat the " + item + ".");
        } else {
            System.out.println("You don't have " + item + " to eat.");
        }
    }
}
