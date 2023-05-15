package cinema;

public class Cinema {
	private final int rows;
	private final int columns;
	private final String[][] seats;
	
	
	public Cinema(int[] size) {
		this(size[0], size[1]);
	}
	
	public Cinema(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.seats = createSeatsArray();
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
