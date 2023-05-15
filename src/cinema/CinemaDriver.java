package cinema;
import java.util.Scanner;

public class CinemaDriver {
	private final Scanner scanner = new Scanner(System.in);
	private final Cinema cinema;
	
	public CinemaDriver() {
		int[] cinemaSize = getRowsAndColsFromUser();
		cinema = new Cinema(cinemaSize);
	}
	
	public int[] getRowsAndColsFromUser() {
		System.out.println("Enter the number of rows: ");
		int rows = scanner.nextInt();
		System.out.println("Enter the number of seats in each row: ");
		int columns = scanner.nextInt();
		
		return new int[] {rows, columns};
	}
	
	public int getUserMenuInput() {
		int input = -1;
		while(input < 0 || input > 2) {
			System.out.println("1. Show the seats\n2. Buy a ticket\n3. Exit");
			input = scanner.nextInt();
		}
		return input;
	}
	
	public void start() {
		
		int userInput = -1;
		
		while (userInput != 0) {
			userInput = getUserMenuInput();
			switch(userInput) {
			case 1:
				cinema.printSeats();
				break;
			case 2:
				System.out.println(cinema.buyTicket());
				break;
			default:
				System.out.println("Good bye:)");
			}
		}
	}
}
