/*
 * Name: Valentine Ugochukwu Ezenwa
 * Project #2
 * Lab: TR 12:30
 * TA: Patrick Conway
 * I did not collaborate with anyone on this Project 
 */
import java.util.Scanner;
import java.util.Random;
import static java.lang.Math.abs;

public class GolfGame {
	public int yards; //distance from tee to hole in yards
	public int par;
	public int num; //number corresponding to course to select
	public int d; //distance traveled by ball
	public int mean;
	public int sd; //standard deviation for mean
	public int score; //score for each hole
	public int totalScore = 0;

	
	public GolfGame(int num){ //constructor just for the sake of having a separate class to play game 
		this.num = num;
	}
	
	public void course(int num){ //allows player to select a course
		if(num == 1){
			System.out.println("You are playing at the Genesee Valley Park course.");
		}
		else if(num == 2){
			System.out.println("You are playing at the St. Andrews course.");
		}
	}	
	
	public void tee1(int t){ //For Genesee Valley Park course
		if(t == 1){ //1st tee
			yards= 530; par = 5;
		}
		else if(t == 2){ //2nd tee
			yards= 305; par = 4;
		}
		else if(t == 3){
			yards= 331; par = 4;
		}
		else if(t == 4){
			yards= 201; par = 3;
		}
		else if(t == 5){
			yards= 500; par = 5;
		}
		else if(t == 6){
			yards= 226; par = 3;
		}
		else if(t == 7){
			yards= 409; par = 4;
		}
		else if(t == 8){
			yards= 410; par = 4;
		}
		else if(t == 9){
			yards= 229; par = 3;
		}
		else if(t == 10){
			yards= 433; par = 4;
		}
		else if(t == 11){
			yards= 363; par = 4;
		}
		else if(t == 12){
			yards= 174; par = 3;
		}
		else if(t == 13){
			yards= 545; par = 5;
		}
		else if(t == 14){
			yards= 419; par = 4;
		}
		else if(t == 15){
			yards= 512; par = 5;
		}
		else if(t == 16){
			yards= 410; par = 4;
		}
		else if(t == 17){
			yards= 320; par = 4;
		}
		else{
			yards= 170; par = 3;
		}
	}
	
	public void tee2(int t){ //For St. Andrews course
		if(t == 1){
			yards= 376; par = 4;
		}
		else if(t == 2){
			yards= 453; par = 4;
		}
		else if(t == 3){
			yards= 397; par = 4;
		}
		else if(t == 4){
			yards= 480; par = 4;
		}
		else if(t == 5){
			yards= 568; par = 5;
		}
		else if(t == 6){
			yards= 412; par = 4;
		}
		else if(t == 7){
			yards= 371; par = 4;
		}
		else if(t == 8){
			yards= 175; par = 3;
		}
		else if(t == 9){
			yards= 352; par = 4;
		}
		else if(t == 10){
			yards= 386; par = 4;
		}
		else if(t == 11){
			yards= 174; par = 3;
		}
		else if(t == 12){
			yards= 348; par = 4;
		}
		else if(t == 13){
			yards= 465; par = 4;
		}
		else if(t == 14){
			yards= 618; par = 5;
		}
		else if(t == 15){
			yards= 455; par = 4;
		}
		else if(t == 16){
			yards= 423; par = 4;
		}
		else if(t == 17){
			yards= 495; par = 4;
		}
		else{
			yards= 357; par = 4;
		}
	}
	
	public void clubSpec(int club){  //Specification for the non-putting clubs
		if(club == 1){
			mean = 230; sd = 30;
		}
		if(club == 2){
			mean = 215; sd = 20;
		}
		if(club == 3){
			mean = 180; sd = 20;
		}
		if(club == 4){
			mean = 170; sd = 17;
		}
		if(club == 5){
			mean = 155; sd = 15;
		}
		if(club == 6){
			mean = 145; sd = 15;
		}
		if(club == 7){
			mean = 135; sd = 15;
		}
		if(club == 8){
			mean = 125; sd = 15;
		}
		if(club == 9){
			mean = 110; sd = 10;
		}
		if(club == 10){
			mean = 50; sd = 10;
		}
	}
	
	public int nextDistance(int power) { //calculates how far the player hits the ball
		double mean_adj = mean * power / 10.0;
		double stddev_adj = sd * power / 10.0;
		do {
		Random random = new Random();
		double val = (random.nextGaussian() * stddev_adj) + mean_adj;
		d = (int)val;
		} while (d < 0);
		return d;
	}
	
	public void puttPower(int p){ //specifications for the putt power, distance units are in feet
		if(p == 10){
			mean = 40; sd = 5;
		}
		else if(p == 9){
			mean = 30; sd = 5;
		}
		else if(p == 8){
			mean = 25; sd = 4;
		}
		else if(p == 7){
			mean = 20; sd = 4;
		}
		else if(p == 6){
			mean = 16; sd = 3;
		}
		else if(p == 5){
			mean = 12; sd = 3;
		}
		else if(p == 4){
			mean = 8; sd = 2;
		}
		else if(p == 3){
			mean = 4; sd = 2;
		}
		else if(p == 2){
			mean = 2; sd = 1;
		}
		else{
			mean = 1; sd = 1;
		}
	}
	
	public void dCheck(){  //checks where the ball is relative to the hole
		
		while(abs(d-yards) > 20){
			System.out.println("You are in the fairway. Take another shot");
			yards = abs(d-yards); //assigns new distance away from the hole
			System.out.println("The hole is "+yards+" yards away.");
			
			Scanner scan = new Scanner(System.in);
			System.out.print("Choose your club [1-10]: ");
			int club =  scan.nextInt(); 
			clubSpec(club);
			System.out.print("Power [1-10]: ");
			int power =  scan.nextInt(); 	
			nextDistance(power); //returns d in yards
			System.out.println("You hit the ball "+d+" yards");
			System.out.println();
			scoreTracker();
		}
		
		int yft = yards*3; //distance away from the hole in ft
		int dft = d*3;  // distance the ball goes in ft 
		while(abs(dft-yft) > 1){
			System.out.println("You are on the green.");
			yft = abs(dft-yft); //assigns new distance away from the hole
			System.out.println("The hole is "+yft+" feet away.");
			Scanner scan = new Scanner(System.in);
			System.out.print("Putt power [1-10]: ");
			int p =  scan.nextInt(); //p = putt power
			puttPower(p);
			nextDistance(p); //returns distance d in feet
			dft = d;
			//System.out.println(mean);
			//System.out.println(sd);
			//System.out.println(dft);

			if(dft > (yft+60)){ //puts a threshold that ensures ball doesn't leave the green
				dft = yft+60;
				System.out.println("Careful. Your ball is at the edge of the green");
			}
			System.out.println("You hit the ball "+dft+" feet");
			System.out.println();
			scoreTracker();
		}
		
			System.out.println("It's in the hole!");	
			if(score == par){
				System.out.println("You made par on this hole.");
				}
				else{
					System.out.println("Your score is "+ (score-par));
				}
			totalScore += (score-par); //keeps track of total score for the round
			System.out.println("Your total score is "+ totalScore);
			System.out.println();
		}		
	
	public int scoreTracker(){ //keeps track of score
		score += 1;
		return score;
	}
		
	
	public void round(){ //initiates a round
		for(int t=1; t<=18; t++){ //loops through all 18 tees and their holes
			if(num == 1){
				tee1(t);
			}
			else{
				tee2(t);
			}
			System.out.printf("You are are at tee %d. %d yards from hole, par %d%n",t,yards,par);
				
			Scanner scan = new Scanner(System.in);
			System.out.print("Choose your club [1-10]: ");
			int club =  scan.nextInt(); 
			clubSpec(club);
			System.out.print("Power [1-10]: ");
			int power =  scan.nextInt(); 	
			nextDistance(power);
			System.out.println("You hit the ball "+d+" yards");
			System.out.println();
			score = 0; //reassigns score to 0 after each hole is made
			scoreTracker();
			dCheck();
		}						
	}
}
	
		



