package cinema;
import java.util.Scanner;

public class CinemaDriver {
	private final Scanner scanner = new Scanner(System.in);
	private final int[] cinemaSize;
	private final Cinema cinema;
	
	public CinemaDriver() {
		cinemaSize = getRowsAndColsFromUser();
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
		while(input < 0 || input > 3) {
			System.out.println("1. Show the seats\n2. Buy a ticket\n3.Statistics\n0. Exit");
			input = scanner.nextInt();
		}
		return input;
	}
	
	public int[] getSeatPositionFromUser() {
		System.out.println("Enter a row number: ");
		int row = scanner.nextInt();
		System.out.println("Enter a seat number in that row: ");
		int seat = scanner.nextInt();
		return new int[] {row, seat};
	}
	
	public void purchaseTicket() {
		int[] position = new int[2];
		boolean isSeatBooked = false;
		boolean isSeatValid = false;
		do {
			position = getSeatPositionFromUser();
			isSeatBooked = cinema.checkSeatAvailable(position);
			isSeatValid = validateSeatLocation(position);
			
			if (isSeatBooked) {
				System.out.println("That ticket has already been purchased!");
			} else if (!isSeatValid) {
				System.out.println("Wrong input!");
			}
		} while(isSeatBooked || !isSeatValid);
		if(!isSeatBooked) {
			int price = cinema.buyTicket(position);
			System.out.println("Ticket price: $" + price);
		}
	}
	
	public boolean validateSeatLocation(int[] seatLocation) {
		if (seatLocation[0] > cinemaSize[0] || seatLocation[1] > cinemaSize[1]) {
			return false;
		}
		return true;
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
				purchaseTicket();
				break;
			case 3:
				cinema.showStatistics();
				break;
			default:
				System.out.println("Good bye:)");
			}
		}
	}
}
