//EscapeDungeon;
//Chiamaka Irika
class Room {
	protected String name;
	protected String description;
	protected String item;
	protected String[] questions = new String[3];
	protected boolean itemPresent; //tracks if the item is in the room
	
	Room(String name, String description, String item, String q1, String q2, String q3) {
		this.name = name;
		this.description = description;
		this.item = item;
		this.questions[0] = q1;
		this.questions[0] = q2;
		this.questions[0] = q3;
		this.itemPresent = true;
	}
	
	//Presents the room descriptions
	void getDescription() {
		System.out.println(description);
				//+ "room 1 has a potion and 3 questions, room 2 has a potion and 3 questions, room 3 has the key and you leave
	}
	
	//prints out questions
	public void showQuestions() {
		for(int i = 0; i < questions.length; i++) {
			System.out.println("Question " + (i+1) + ": " + questions[i]);
		}
	}
	void removeItem() {
		System.out.println("You have lost this item:" + item);
	}
}