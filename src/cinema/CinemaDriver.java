package cinema;
import java.util.Scanner;

public class CinemaDriver {
	private final Scanner scanner = new Scanner(System.in);
	
	public int[] getRowsAndColsFromUser() {
		System.out.println("Enter the number of rows: ");
		int rows = scanner.nextInt();
		System.out.println("Enter the number of seats in each row: ");
		int columns = scanner.nextInt();
		
		return new int[] {rows, columns};
	}
	
	public void start() {
		int[] cinemaSize = getRowsAndColsFromUser();
		Cinema cinema = new Cinema(cinemaSize);
		cinema.printSeats();
	}
}
