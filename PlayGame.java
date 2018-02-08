import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		System.out.println("Welcome to TTY Golf!");
		String ans;
		do{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please select a course:");
		System.out.println("1. Genesse Valley Park Course");
		System.out.println("2. St. Andrews Course");
		System.out.print("Enter your choice (1 or 2): ");
		int num =  scan.nextInt(); 	
		GolfGame a = new GolfGame(num);
		a.course(num);
		a.round();	
		Scanner in = new Scanner(System.in);
		System.out.print("Do you want to quit the game (Yes or No): ");		
		ans =  scan.next(); 	
		} while(ans.equals("No")); //Quits game after a round if answer is Yes
}
}