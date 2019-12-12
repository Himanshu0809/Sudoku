package sudoku;

public class Sudoku {

	private int[][] sudokuTable;

	public Sudoku(int[][] sudokuTable) {
		this.sudokuTable = sudokuTable;
	}

	public void solveSudokuProblem() {
		
		if ( !solve(0, 0) ){
			System.out.println("No feasible solution found...");
		} else {	
			showResult();
		}
	}

	private boolean solve(int rowIndex, int columnIndex) {
		
		System.out.println("Before Called solve method: rowIndex=" + rowIndex+" colIndex=" + columnIndex);
		
		if( rowIndex == Constants.BOARD_SIZE && ++columnIndex == Constants.BOARD_SIZE ){
			System.out.println("Vegere ertunk");
			return true;
		}
		
		System.out.println("After Called solve method: rowIndex=" + rowIndex+" colIndex=" + columnIndex);
		
		if( rowIndex == Constants.BOARD_SIZE){
			System.out.println("Hop to next column, reinitialize rowIndex=0");
			rowIndex=0;
		}
		
		if ( sudokuTable[rowIndex][columnIndex] != 0 ) { // skip filled cells
			return solve(rowIndex + 1, columnIndex);
		}

		for (int numbers = Constants.MIN_NUMBER; numbers <= Constants.MAX_NUMBER; ++numbers) {
			
			if ( valid(rowIndex, columnIndex, numbers) ) {
				
				sudokuTable[rowIndex][columnIndex] = numbers;
				
				if ( solve(rowIndex + 1, columnIndex) )
					return true;
			}
		}
		
		sudokuTable[rowIndex][columnIndex] = 0; // backtracking !!!
		
		return false;
	}

	private boolean valid(int columnIndex, int rowIndex, int actualNumber) {
		
		// if the given number is already in the row: the number cannot be part of the solution
		for (int i = 0; i < Constants.BOARD_SIZE; ++i) // check the rows
			if ( sudokuTable[i][rowIndex] == actualNumber )
				return false;

		// if the given number is already in the column: the number cannot be part of the solution
		for (int k = 0; k < Constants.BOARD_SIZE; ++k) 
			if ( sudokuTable[columnIndex][k] == actualNumber )
				return false;

		// if the given number is already in the box: the number cannot be part of the solution
		int boxRowOffset = (columnIndex / 3) * Constants.BOX_SIZE;
		int boxColumnOffset = (rowIndex / 3) * Constants.BOX_SIZE;
		
		for (int i = 0; i < Constants.BOX_SIZE; ++i)
			for (int j = 0; j < Constants.BOX_SIZE; ++j)
				if (actualNumber == sudokuTable[boxRowOffset + i][boxColumnOffset + j])
					return false;

		return true;
	}

	private void showResult() {
		
		for (int i = 0; i < Constants.BOARD_SIZE; ++i) {
			
			if(i % 3 == 0) System.out.println(" ");
			
			for (int j = 0; j < Constants.BOARD_SIZE; ++j) {
				
				if (j % 3 == 0) System.out.print(" ");
				System.out.print(sudokuTable[i][j]+" ");
			}
			
			System.out.println(" ");
		}	
	}
}