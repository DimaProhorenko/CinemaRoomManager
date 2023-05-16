package cinema;
import java.util.List;
import java.util.ArrayList;


public class Cinema {
	private final int rows;
	private final int columns;
	private final String[][] seats;
	private final List<String> bookedSeats = new ArrayList<>();
	private final int totalSeats;
	private int numberOfPurchasedTickets = 0;
	private int currentIncome = 0;
	
	
	public Cinema(int[] size) {
		this(size[0], size[1]);
	}
	
	public Cinema(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.seats = createSeatsArray();
		totalSeats = this.rows * this.columns;
		
	}
	
	public int getNumberOfPurchasedTickets() {
		return numberOfPurchasedTickets;
	}
	
	public void printSeats() {
		System.out.println("Cinema: ");
		for (int r = -1; r < rows; r++) {
			
			if (r >= 0) {
				for (int c = 0; c < columns; c++) {
					if (c == 0) {
						System.out.print(r + 1 + " " + seats[r][c] + " ");
					} else {
						System.out.print(seats[r][c] + " ");
					}
				}
			} else {
				for (int c = 0; c <= columns; c++) {
					if(c == 0) {
						System.out.print("  ");
						continue;
					}
					System.out.print(c + " ");
				}
			}
			
			System.out.println();
		}
	}
	
	public int calcTotalIncome() {
		if (totalSeats < 60) {
			return totalSeats * 10;
		}
		if (rows % 2 == 0) {
			return (rows / 2 * columns * 10) + (rows / 2 * columns * 8); 
		}
		// 288 + 
		return (rows / 2 * columns * 10) + ((rows / 2 + 1) * columns * 8);
	}
	
	public int buyTicket(int[] seatLocation) {
		bookSeat(seatLocation);
		int price = calcSeatPrice(seatLocation);
		currentIncome += price;
		return price;
	}
	
	public boolean checkSeatAvailable(int[] seatLocation) {
		return bookedSeats.contains("" + seatLocation[0] + seatLocation[1]);
	}
	
	
	public void showStatistics() {
		System.out.println("Number of purchased tickets: " + numberOfPurchasedTickets);
		System.out.printf("Percentage: %.2f%%\n", getPercantageOfPurchasedTickets());
		System.out.println("Current income: $" + currentIncome);
		System.out.println("Total income: $" + calcTotalIncome());
		
	}
	
	public float getPercantageOfPurchasedTickets() {
		return (float) numberOfPurchasedTickets / totalSeats * 100;
	}
	
	private boolean bookSeat(int[] seatLocation) {
		try {
			seats[seatLocation[0]-1][seatLocation[1]-1] = "B";
			bookedSeats.add("" + seatLocation[0] + seatLocation[1]);
			numberOfPurchasedTickets++;
			return true;
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	private int calcSeatPrice(int[] seatLocation) {
		if (totalSeats < 60) {
			return 10;
		}
		if (seatLocation[0] > (rows / 2)) {
			return 8;
		}
		
		return 10;
	}
	
	
	private String[][] createSeatsArray() {
		String[][] result = new String[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result[i][j] = "S";
			}
		}
		
		return result;
	}
}
