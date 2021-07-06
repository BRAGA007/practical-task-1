import java.util.Scanner;
public class Dice {
	 public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Enter the value K(number of cubes): ");
	int k = scanner.nextInt();
	System.out.print("Enter the value N(number of players): ");
	int n  = scanner.nextInt();
	int[] array_of_players;
	array_of_players = new int[n]; // array for storing points for the current round
	int[] array_of_wins;
	array_of_wins = new int[n]; // array for storing player wins in rounds
	int[] array_of_names;
	array_of_names = new int[n]; // array for changing the first dice thrower
	for(int i = 0; i < n; i++) {
		array_of_names[i]=i+1; // filling the array with names(ID)
	}
	int maximum = array_of_wins[0];
	for (int i = 0; i < array_of_wins.length; i++) maximum = Math.max(maximum, array_of_wins[i]);
	while(maximum < 7) {
		Round(n,k,array_of_players,array_of_wins, array_of_names, 1);
		for (int i = 0; i < array_of_wins.length; i++) maximum = Math.max(maximum, array_of_wins[i]);
	}
	for(int i = 0; i < array_of_wins.length; i++) {
		if (array_of_wins[i]==7){
			if (i+1!=n) {     // is the player a computer
			System.out.println("Winner is "+(i+1)+" Player ");}
			else {
				System.out.println("Winner is Computer ");
			}
		}
	}
	
	 }
	 
	 
	 
	 
	 public static void Round(int n,int k, int[] array_of_players,int[] array_of_wins, int[] array_of_names, int winner) {
			for(int i = 0; i < n; i++) {
				if(array_of_names[i]!=n) { // if player is not a computer
				Scanner scanner = new Scanner(System.in);
				System.out.print("Press Enter to roll the dice");
				String str = scanner.nextLine();
				str = ""; // protection against incorrect input from the user
				if (str=="")  {
					int a = k + (int) ( Math.random() * ((6 * k - k)+1)); // roll of the K dice 
				array_of_players[array_of_names[i]-1] += a;
				System.out.println(array_of_names[i]+" Player points: "+array_of_players[array_of_names[i]-1]);
							}
											}
				else { //if player is a computer
					int a = k + (int) ( Math.random() * ((6 * k - k)+1));  // roll of the K dice 
					array_of_players[array_of_names[i]-1] += a;
					System.out.println("Computer points: "+array_of_players[array_of_names[i]-1]);
				}
			}
			int max = array_of_players[0];
			int champion = 0;
			for (int i = 0; i < array_of_players.length; i++) max = Math.max(max, array_of_players[array_of_names[i]-1]);
			for (int i = 0; i < array_of_players.length; i++) {
				if(array_of_players[array_of_names[i]-1] == max) {
					array_of_wins[array_of_names[i]-1]+=1; // if several players have the same maximum they are both winners
					champion = i; // saving the winner's ID
				}
			}
			for (int i = 0; i < array_of_players.length; i++) {
				array_of_players[i]=0; // zeroing the array of the current round
			}
			int t;
			t = array_of_names[0];
			array_of_names[0] = array_of_names[champion];
			array_of_names[champion]=t; // changing the order of the dice roll between the winner of the current and previous rounds
			}
}