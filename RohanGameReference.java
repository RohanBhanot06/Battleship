package unit1Game;

/* Name: Rohan Bhanot 
 * Starting Date: Monday, May 15, 2023
 * Ending Date: Thursday, June 1, 2023
 * Teacher: Elena Kapustina
 * Course Code: ICS3U1-03
 * Program Name: RohanBattleshipWithComputer 
 * Description: Creating the 2D array's "map1", "map2", "map3", and "map4" that are 7 rows and 7 columns to play the game of battleship. Also implementing the methods "placeShips", "generalRules", "mapPrint", and "checkGameOver" to simulate a game where the user enters coordinates, finding enemy ships, and takes part in a battle overseas against the computer.
 */

import java.util.Scanner;

public class RohanGameReference {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String userName; // Variable to store the user's name
		int userAge; // Variable to store the user's age
		int[][] map1 = new int[7][7]; // Variable to store the computer's map with fully placed ships
		int[][] map2 = new int[7][7]; // Variable to store the user's map with fully placed ships
		int[][] map3 = new int[7][7]; // Variable to store the user's map with all the guesses
		int[][] map4 = new int[7][7]; // Variable to store the computer's map with all the guesses
		int carrierRow = 0, carrierCol = 0; // Variables to store the user's Carrier Ship coordinates
		int battleshipRow = 0, battleshipCol = 0; // Variables to store the user's Battleship coordinates
		int cruiserRow1 = 0, cruiserRow2 = 0, cruiserCol1 = 0, cruiserCol2 = 0; // Variables to store the user's Cruiser Ship coordinates
		int submarineRow1 = 0, submarineRow2 = 0, submarineCol1 = 0, submarineCol2 = 0; // Variables to store the user's Submarine coordinates
		int destroyerRow = 0, destroyerCol = 0; // Variables to store the user's Destroyer Ship coordinates
		int userShipCount = 0; // Variable to store the user's ship count
		int computerShipCount = 0; // Variable to store the computer's ship count
		int userRow; // Variable to store the user's row guess
		int userCol; // Variable to store the user's column guess
		int computerRow; // Variable to store the computer's row guess
		int computerCol; // Variable to store the computer's column guess
		// Places the ships on the computer's ship map
		placeShips(map1);
		// Displays the game title and instructions to start up the game
		System.out.println("------------------------");
		System.out.println("BATTLESHIP WITH COMPUTER");
		System.out.println("------------------------");
		System.out.println(" ");
		System.out.println("-------------------------------------------------");
		System.out.println("DISCLAIMER: GAME IS BEST PLAYED USING FULL-SCREEN");
		System.out.println("-------------------------------------------------");
		System.out.println(" ");
		System.out.println("To boot up the game, please enter the following information: ");
		System.out.println(" ");
		// Prompts the user to enter their name and age, and checks if the age is valid to play the game
		System.out.print("Enter your name: ");
		userName = input.next();
		System.out.print("Enter your age: ");
		userAge = input.nextInt();
		if (userAge < 7) {
			System.out.println("You have to be 7 and up to play the following game!");
			// Ends the code as the user is not 7 and up
			return;
		}
		// Displays a welcome message to the user and calls the general rules method to display the game rules
		System.out.println(" ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("   Welcome to the Battleship with Computer game! By: Rohan Bhanot");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("  BASED ON THE AGE VERIFICATION YOU ARE ELIGIBLE TO PLAY THE GAME.");
		System.out.println("--------------------------------------------------------------------");
		System.out.println(" ");
		generalRules();
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("DISCLAIMER: The ships on each side cover a total of 7 spaces on the maps.");
		System.out.println("    Three (1 Space) Ships + Two (2 Space) Ships = 7 Total Ship Spaces");
		System.out.println("-------------------------------------------------------------------------");
		// Prompts the user to start entering each ships coordinates
		System.out.println(" ");
		System.out.println(userName + ":");
		System.out.println("-----------------");
		System.out.println("PLACE YOUR SHIPS!");
		System.out.println("-----------------");
		// Displays the user's empty map in order for the user to see the map layout
		System.out.println(" ");
		System.out.println("YOUR MAP:");
		System.out.println(" ");
		mapPrint(map2);
		// Prompts the user to enter the row coordinate for the Carrier Ship
		System.out.println(" ");
		System.out.print("Enter the row coordinate for your carrier ship: ");
		carrierRow = input.nextInt();
		// Checks if the row coordinate inputed is valid or not
		while (carrierRow < 0 || carrierRow > 6 || map2[carrierRow][carrierCol] != 0) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			carrierRow = input.nextInt();
		}
		// Prompts the user to enter the column coordinate for the Carrier Ship
		System.out.print("Enter the column coordinate for your carrier ship: ");
		carrierCol = input.nextInt();
		// Checks if the column coordinate inputed is valid or not
		while (carrierCol < 0 || carrierCol > 6 || map2[carrierRow][carrierCol] != 0) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			carrierCol = input.nextInt();
		}
		// Updates the user's ship map with the letter 'S' based on the coordinates inputed
		System.out.println(" ");
		map2[carrierRow][carrierCol] = 4;
		// Displays the user's updated ship map
		System.out.println("YOUR MAP:");
		System.out.println(" ");
		mapPrint(map2);
		System.out.println(" ");
		// Prompts the user to enter the row coordinate for the Battleship
		System.out.print("Enter the row coordinate for your battleship: ");
		battleshipRow = input.nextInt();
		// Checks if the row coordinate inputed is valid or not
		while (battleshipRow < 0 || battleshipRow > 6 || map2[battleshipRow][battleshipCol] != 0) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			battleshipRow = input.nextInt();
		}
		// Prompts the user to enter the column coordinate for the Battleship
		System.out.print("Enter the column coordinate for your battleship: ");
		battleshipCol = input.nextInt();
		// Checks if the column coordinate inputed is valid or not
		while (battleshipCol < 0 || battleshipCol > 6 || map2[battleshipRow][battleshipCol] != 0) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			battleshipCol = input.nextInt();
		}
		// Updates the user's ship map with the letter 'S' based on the coordinates inputed
		System.out.println(" ");
		map2[battleshipRow][battleshipCol] = 4;
		// Displays the user's updated ship map
		System.out.println("YOUR MAP:");
		System.out.println(" ");
		mapPrint(map2);
		System.out.println(" ");
		System.out.println("MAKE SURE THE COORDINATES ARE PLACED ADJACENTLY FOR THE FOLLOWING SHIP!");
		System.out.println(" ");
		// Prompts the user to enter the first row coordinate for the Cruiser Ship
		System.out.print("Enter the first row coordinate for your cruiser ship: ");
		cruiserRow1 = input.nextInt();
		// Checks if the row coordinate inputed is valid or not
		while (cruiserRow1 < 0 || cruiserRow1 > 6 || map2[cruiserRow1][cruiserCol1] != 0) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			cruiserRow1 = input.nextInt();
		}
		// Prompts the user to enter the first column coordinate for the Cruiser Ship
		System.out.print("Enter the first column coordinate for your cruiser ship: ");
		cruiserCol1 = input.nextInt();
		// Checks if the column coordinate inputed is valid or not
		while (cruiserCol1 < 0 || cruiserCol1 > 6 || map2[cruiserRow1][cruiserCol1] != 0) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			cruiserCol1 = input.nextInt();
		}
		// Prompts the user to enter the second row coordinate for the Cruiser Ship
		System.out.print("Enter the second row coordinate for your cruiser ship: ");
		cruiserRow2 = input.nextInt();
		// Checks if the row coordinate inputed is valid or not
		while (cruiserRow2 < 0 || cruiserRow2 > 6 || map2[cruiserRow2][cruiserCol2] != 0 || (cruiserRow1 == cruiserRow2 && cruiserCol1 == cruiserCol2)) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			cruiserRow2 = input.nextInt();
		}
		// Prompts the user to enter the second column coordinate for the Cruiser Ship
		System.out.print("Enter the second column coordinate for your cruiser ship: ");
		cruiserCol2 = input.nextInt();
		// Checks if the column coordinate inputed is valid or not
		while (cruiserCol2 < 0 || cruiserCol2 > 6 || map2[cruiserRow2][cruiserCol2] != 0 || (cruiserRow1 == cruiserRow2 && cruiserCol1 == cruiserCol2)) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			cruiserCol2 = input.nextInt();
		}
		// Updates the user's ship map with the letter 'S' based on the coordinates inputed
		System.out.println(" ");
		map2[cruiserRow1][cruiserCol1] = 4;
		map2[cruiserRow2][cruiserCol2] = 4;
		// Displays the user's updated ship map
		System.out.println("YOUR MAP:");
		System.out.println(" ");
		mapPrint(map2);
		System.out.println(" ");
		System.out.println("MAKE SURE THE COORDINATES ARE PLACED ADJACENTLY FOR THE FOLLOWING SHIP!");
		System.out.println(" ");
		// Prompts the user to enter the first row coordinate for the Submarine
		System.out.print("Enter the first row coordinate for your submarine: ");
		submarineRow1 = input.nextInt();
		// Checks if the row coordinate inputed is valid or not
		while (submarineRow1 < 0 || submarineRow1 > 6 || map2[submarineRow1][submarineCol1] != 0) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			submarineRow1 = input.nextInt();
		}
		// Prompts the user to enter the first column coordinate for the Submarine
		System.out.print("Enter the first column coordinate for your submarine: ");
		submarineCol1 = input.nextInt();
		// Checks if the column coordinate inputed is valid or not
		while (submarineCol1 < 0 || submarineCol1 > 6 || map2[submarineRow1][submarineCol1] != 0) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			submarineCol1 = input.nextInt();
		}
		// Prompts the user to enter the second row coordinate for the Submarine
		System.out.print("Enter the second row coordinate for your submarine: ");
		submarineRow2 = input.nextInt();
		// Checks if the row coordinate inputed is valid or not
		while (submarineRow2 < 0 || submarineRow2 > 6 || map2[submarineRow2][submarineCol2] != 0 || (submarineRow1 == submarineRow2 && submarineCol1 == submarineCol2)) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			submarineRow2 = input.nextInt();
		}
		// Prompts the user to enter the second column coordinate for the Submarine
		System.out.print("Enter the second column coordinate for your submarine: ");
		submarineCol2 = input.nextInt();
		// Checks if the column coordinate inputed is valid or not
		while (submarineCol2 < 0 || submarineCol2 > 6 || map2[submarineRow2][submarineCol2] != 0 || (submarineRow1 == submarineRow2 && submarineCol1 == submarineCol2)) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			submarineCol2 = input.nextInt();
		}
		// Updates the user's ship map with the letter 'S' based on the coordinates inputed
		System.out.println(" ");
		map2[submarineRow1][submarineCol1] = 4;
		map2[submarineRow2][submarineCol2] = 4;
		// Displays the user's updated ship map
		System.out.println("YOUR MAP:");
		System.out.println(" ");
		mapPrint(map2);
		System.out.println(" ");
		// Prompts the user to enter the row coordinate for the Destroyer Ship
		System.out.print("Enter the row coordinate for your destroyer ship: ");
		destroyerRow = input.nextInt();
		// Checks if the row coordinate inputed is valid or not
		while (destroyerRow < 0 || destroyerRow > 6 || map2[destroyerRow][destroyerCol] != 0) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			destroyerRow = input.nextInt();
		}
		// Prompts the user to enter the column coordinate for the Destroyer Ship
		System.out.print("Enter the column coordinate for your destroyer ship: ");
		destroyerCol = input.nextInt();
		// Checks if the column coordinate inputed is valid or not
		while (destroyerCol < 0 || destroyerCol > 6 || map2[destroyerRow][destroyerCol] != 0) {
			System.out.print("Invalid input or spot already taken! Enter a number between (0-6): ");
			destroyerCol = input.nextInt();
		}
		// Updates the user's ship map with the letter 'S' based on the coordinates inputed
		System.out.println(" ");
		map2[destroyerRow][destroyerCol] = 4;
		// Displays the user's map with fully placed ships
		System.out.println("YOUR MAP WITH FULLY PLACED SHIPS:");
		System.out.println(" ");
		mapPrint(map2);
		// Prints that the computer is deploying it's ships
		System.out.println(" ");
		System.out.println("----------------------------");
		System.out.println("COMPUTER IS DEPLOYING SHIPS:");
		System.out.println("   Carrier Ship Deployed!");
		System.out.println("    Battleship Deployed!");
		System.out.println("   Cruiser Ship Deployed!");
		System.out.println("  Submarine Ship Deployed!");
		System.out.println("  Destroyer Ship Deployed!");
		System.out.println("----------------------------");
		// Displays the computer's map with fully placed ships
		System.out.println(" ");
		System.out.println("COMPUTER MAP WITH FULLY PLACED SHIPS:");
		System.out.println(" ");
		mapPrint(map1);
		// Alerts the user that the game has started
		System.out.println(" ");
		System.out.println("-------------------------");
		System.out.println("     START THE GAME!");
		System.out.println("-------------------------");
		System.out.println(" ");
		while (true) {
			// Prints that it is the user's turn to guess
			System.out.println(userName + ":");
			System.out.println("YOUR TURN TO GUESS!");
			// Prompts the user to enter the row coordinate for their guess
			System.out.println(" ");
			System.out.print("Enter the row coordinate (0-6): ");
			userRow = input.nextInt();
			// Checks if the row coordinate inputed is valid or not
			while (userRow < 0 || userRow > 6) {
				System.out.print("Invalid input! Enter a number between (0-6): ");
				userRow = input.nextInt();
			}
			// Prompts the user to enter the column coordinate for their guess
			System.out.print("Enter the column coordinate (0-6): ");
			userCol = input.nextInt();
			// Checks if the column coordinate inputed is valid or not
			while (userCol < 0 || userCol > 6) {
				System.out.print("Invalid input! Enter a number between (0-6): ");
				userCol = input.nextInt();
			}
			// Checks if the coordinate inputed has already been used or is valid
			while (userRow < 0 || userRow > 6 || userCol < 0 || userCol > 6 || map3[userRow][userCol] != 0) {
				System.out.println("Invalid input or spot already taken! Enter valid coordinates.");
				// Prompts the user to re-enter another row coordinate for their guess
				System.out.print("Enter the row coordinate (0-6): ");
				userRow = input.nextInt();
				// Prompts the user to re-enter another column coordinates for their guess
				System.out.print("Enter the column coordinate (0-6): ");
				userCol = input.nextInt();
			}
			// Displays the user's map with just ships
			System.out.println(" ");
			System.out.println("USER'S MAP WITH SHIPS:");
			System.out.println(" ");
			mapPrint(map2);
			// Checks if the user's guess resulted in a hit
			if (map1[userRow][userCol] == 4) {
				System.out.println(" ");
				System.out.println("You hit the enemy ship!");
				// Updates the computer's ship map with 'X' for a hit based on the coordinates inputed
				map1[userRow][userCol] = 2;
				// Updates the user's guess map with 'X' for a hit based on the coordinates inputed
				map3[userRow][userCol] = 2;
				// Adds one space covered to the user's ship count
				userShipCount++;
				// Checks if the user's guess resulted in a miss
			} else if (map1[userRow][userCol] == 0) {
				System.out.println(" ");
				System.out.println("You missed!");
				// Updates the user's guess map with '0' for a miss based on the coordinates inputed
				map3[userRow][userCol] = 3;
			}
			// Displays the user's map with guesses
			System.out.println(" ");
			System.out.println("USER'S MAP WITH GUESSES:");
			System.out.println(" ");
			mapPrint(map3);
			// Displays the computer's map with just ships
			System.out.println(" ");
			System.out.println("COMPUTER'S MAP WITH SHIPS:");
			System.out.println(" ");
			mapPrint(map1);
			System.out.println(" ");
			// Generates the computer's random row and column guesses
			computerRow = (int) (Math.random() * 7);
			computerCol = (int) (Math.random() * 7);
			// Checks if the computer's random coordinate guesses have to be done again if a space is already covered
			do {
				computerRow = (int) (Math.random() * 7);
				computerCol = (int) (Math.random() * 7);
			} while (map4[computerRow][computerCol] != 0);
			// Checks if the computer's guess resulted in a hit
			if (map2[computerRow][computerCol] == 4) {
				System.out.println("The computer hit your ship!");
				System.out.println(" ");
				// Updates the user's ship map with 'X' for a hit based on the coordinates inputed
				map2[computerRow][computerCol] = 2;
				// Updates the computer's guess map with 'X' for a hit based on the coordinates inputed
				map4[computerRow][computerCol] = 2;
				// Adds one space covered to the computer's ship count
				computerShipCount++;
				// Checks if the computer's guess resulted in a miss
			} else if (map2[computerRow][computerCol] == 0) {
				System.out.println("The computer missed!");
				System.out.println(" ");
				// Updates the computers's guess map with '0' for a miss based on the coordinates inputed
				map4[computerRow][computerCol] = 3;
			}
			// Displays the computer's map with guesses
			System.out.println("COMPUTER'S MAP WITH GUESSES:");
			System.out.println(" ");
			mapPrint(map4);
			// Checks if the game is over for both the user and computer
			if (checkGameOver(userShipCount, computerShipCount, map1, map2, userName)) {
				break;
			}
			System.out.println(" ");
			System.out.println("-------------------------------");
		}
	}

	/*
	 * Purpose: Places the randomized ships into the map for the computer. 
	 * PRE: int[][] map 
	 * POST: None
	 */
	public static void placeShips(int[][] map) {
		int compShipCount = 0; // Variable to store the computer's ship count in order to place ships
		int computerRow; // Variable to store the computer's row coordinate for a ship
		int computerCol; // Variable to store the computer's column coordinate for a ship
		while (compShipCount < 5) {
			// Generates the computer's random row and column coordinates for a ship
			computerRow = (int) (Math.random() * 7);
			computerCol = (int) (Math.random() * 7);
			// Checks if the computer's row and column result in an empty space
			if (map[computerRow][computerCol] == 0) {
				// Checks if the computer's ship count is equal to the 2nd or 3rd ship
				if (compShipCount == 2 || compShipCount == 3) {
					// Creates the Cruiser Ship
					if (computerCol < 6 && map[computerRow][computerCol + 1] == 0) {
						// Updates the computer's ship map with the letter 'S' based on the randomized coordinates
						map[computerRow][computerCol] = 4;
						map[computerRow][computerCol + 1] = 4;
						// Adds one space covered to the computer's ship count
						compShipCount++;
						// Creates the Submarine
					} else if (computerRow < 6 && map[computerRow + 1][computerCol] == 0) {
						// Updates the computer's ship map with the letter 'S' based on the randomized coordinates
						map[computerRow][computerCol] = 4;
						map[computerRow + 1][computerCol] = 4;
						// Adds one space covered to the computer's ship count
						compShipCount++;
					}
					// Creates the Carrier Ship, Battleship, and Destroyer Ship
				} else {
					// Updates the computer's ship map with the letter 'S' based on the randomized coordinates
					map[computerRow][computerCol] = 4;
					// Adds one space covered to the computer's ship count
					compShipCount++;
				}
			}
		}
	}

	/*
	 * Purpose of Method: Prints the general rules of the Battleship with Computer game. 
	 * PRE: None 
	 * POST: None
	 */
	public static void generalRules() {
		// Prints all the general rules to the Battleship with Computer game
		System.out.println("--------------");
		System.out.println("GENERAL RULES:");
		System.out.println("--------------");
		System.out.println(" ");
		System.out.println("OBJECTIVE: Sink all five of your opponent's ships before they sink yours.");
		System.out.println(" ");
		System.out.println("SHIP SIZES:");
		System.out.println("  1. Carrier: Occupies 1 space.");
		System.out.println("  2. Battleship: Occupies 1 space.");
		System.out.println("  3. Cruiser: Occupies 2 adjacent spaces.");
		System.out.println("  4. Submarine: Occupies 2 adjacent spaces.");
		System.out.println("  5. Destroyer: Occupies 1 space.");
		System.out.println(" ");
		System.out.println("SHIP PLACEMENT:");
		System.out.println("  - Cruiser and Submarine must be placed horizontally or vertically.");
		System.out.println("  - Place the coordinates for the Cruiser and Submarine ships side by side.");
		System.out.println("  - Avoid ship overlapping.");
		System.out.println(" ");
		System.out.println("TURN ORDER:");
		System.out.println("  - Alternating turns between the user and computer.");
		System.out.println("  - User makes a guess, followed by the computer.");
		System.out.println(" ");
		System.out.println("COORDINATE FORMAT: Enter the row number and column number as seperate inputs.");
		System.out.println(" ");
		System.out.println("SYMBOL REPRESENTATION:");
		System.out.println("  - '~' indicates empty spaces on the map.");
		System.out.println("  - 'S' indicates a ship on the map.");
		System.out.println("  - 'X' indicates a hit on the opponent's ship.");
		System.out.println("  - '0' indicates a miss.");
		System.out.println(" ");
		System.out.println("SINKING A SHIP: A ship is considered sunk when all its spaces are hit.");
		System.out.println(" ");
		System.out.println("WINNING THE GAME: First player to sink all five of the opponent's ships wins.");
		System.out.println(" ");
	}

	/*
	 * Purpose: Prints the battleship maps for the user and computer to play the game through. 
	 * PRE: int[][] map 
	 * POST: None
	 */
	public static void mapPrint(int[][] map) {
		// Prints the map layout for the columns
		System.out.println("    0 1 2 3 4 5 6");
		System.out.println("    -------------");
		for (int row = 0; row < 7; row++) {
			// Prints the map layout for the rows
			System.out.print(row + " | ");
			for (int col = 0; col < 7; col++) {
				// Checks if the maps coordinates inputed result in an empty space
				if (map[row][col] == 0 || map[row][col] == 1) {
					System.out.print("~ ");
					// Checks if the maps coordinates inputed result in a hit
				} else if (map[row][col] == 2) {
					System.out.print("X ");
					// Checks if the maps coordinates inputed result in a miss
				} else if (map[row][col] == 3) {
					System.out.print("0 ");
					// Checks if the maps coordinates inputed result in a ship
				} else if (map[row][col] == 4)
					System.out.print("S ");
			}
			// Prints the map layout for the rows
			System.out.println("| " + row);
		}
		// Prints the map layout for the columns
		System.out.println("    -------------");
		System.out.println("    0 1 2 3 4 5 6");
	}

	/*
	 * Purpose: Checks if the game is over or not and displays a message for the winner as well as the total ship spaces covered for each side. 
	 * PRE: int userShipCount, int computerShipCount, int[][] map1, int[][] map2, String userName 
	 * POST: boolean (true/false)
	 */
	public static boolean checkGameOver(int userShipCount, int computerShipCount, int[][] map1, int[][] map2, String userName) {
		// Checks if the computer's ship count is equal to 7
		if (computerShipCount == 7) {
			// Displays the user's map and computer's map after the battle
			System.out.println(" ");
			System.out.println("-------------------------------");
			System.out.println("YOUR MAP AFTER BATTLE:");
			System.out.println(" ");
			mapPrint(map2);
			System.out.println(" ");
			System.out.println("COMPUTER'S MAP AFTER BATTLE:");
			System.out.println(" ");
			mapPrint(map1);
			// Prints that the computer has successfully sunk the user's ships
			System.out.println(" ");
			System.out.println("--------------------------------------------------------");
			System.out.println("THE COMPUTER SUNK ALL YOUR SHIPS! BETTER LUCK NEXT TIME!");
			System.out.println("--------------------------------------------------------");
			System.out.println(" ");
			// Displays the total ship spaces covered for both the user and computer
			System.out.println("TOTAL SHIP SPACES COVERED:");
			System.out.println(" ");
			System.out.println("Computer's Ship Spaces Covered: " + userShipCount + " of the computer's ships spaces have been hit.");
			System.out.println("User's Ship Spaces Covered: " + computerShipCount + " of the user's ships spaces have been hit.");
			return true;
		}
		// Checks if the user's ship count is equal to 7
		if (userShipCount == 7) {
			// Displays the user's map and computer's map after the battle
			System.out.println(" ");
			System.out.println("-------------------------------");
			System.out.println("YOUR MAP AFTER BATTLE:");
			System.out.println(" ");
			mapPrint(map2);
			System.out.println(" ");
			System.out.println("COMPUTER'S MAP AFTER BATTLE:");
			System.out.println(" ");
			mapPrint(map1);
			// Prints that the user has successfully sunk the computer's ships
			System.out.println(" ");
			System.out.println(userName + ":");
			System.out.println("----------------------------------------");
			System.out.println("CONGRATULATIONS! YOU SUNK ALL THE SHIPS!");
			System.out.println("----------------------------------------");
			System.out.println(" ");
			// Displays the total ship spaces covered for both the user and computer
			System.out.println("TOTAL SHIP SPACES COVERED:");
			System.out.println(" ");
			System.out.println("Computer's Ship Spaces Covered: " + userShipCount + " of the computer's ships spaces have been hit.");
			System.out.println("User's Ship Spaces Covered: " + computerShipCount + " of the user's ships spaces have been hit.");
			return true;
		}
		return false;

	}

}