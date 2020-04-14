
package lifesimple1;

/**
 *Una versión muy simple del juego de programación LIFE
 * author
 * https://www.geeksforgeeks.org/program-for-conways-game-of-life/
 
 *  la siguiente generacion se calcula, pero no genera la nueva matriz
 */
public class LifeSimple1 {

  
    public static void main(String[] args) {
        // TODO code application logic here

		int M = 10, N = 20; 

		// Intiliazing the grid. 
		int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0 }, 
			{ 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0 }, 
			{ 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } 
		}; 
                int future [][]; 
                future = new int  [M][N] ;
		// Displaying the grid 
		System.out.println("Original Generation"); 
		for (int i = 0; i < M; i++) 
		{ System.out.print("          ");
			for (int j = 0; j < N; j++) 
			{ 
				if (grid[i][j] == 0) 
					System.out.print(" "); 
				else
					System.out.print("*"); 
			} 
			System.out.println(); 
		} 
		System.out.println(); 
                
        /*  y ahora repetimos unas cuantas veces */
        for (int i = 1; i < 20; i++) {
            nextGeneration(grid, M, N, future);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                // try y catch sirve para tratar excepciones, errores.
            }// fin de las operaciones si salta la excepción
            System.out.println();
            /* ahora future es grid */
            nextGeneration(future, M, N, grid);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                // try y catch sirve para tratar excepciones, errores.
            }// fin de las operaciones si salta la excepción

        }

	
	} 

	// Function to print next generation 
	static void nextGeneration(int grid[][], int M, int N, int future [][]) 
	{ 
		//int[][] future = new int[M][N]; 

		// Loop through every cell 
		for (int l = 1; l < M - 1; l++) 
		{ 
			for (int m = 1; m < N - 1; m++) 
			{ 
				// finding no Of Neighbours that are alive 
				int aliveNeighbours = 0; 
				for (int i = -1; i <= 1; i++) 
					for (int j = -1; j <= 1; j++) 
						aliveNeighbours += grid[l + i][m + j]; 

				// The cell needs to be subtracted from 
				// its neighbours as it was counted before 
				aliveNeighbours -= grid[l][m]; 

				// Implementing the Rules of Life 

				// Cell is lonely and dies 
				if ((grid[l][m] == 1) && (aliveNeighbours < 2)) 
					future[l][m] = 0; 

				// Cell dies due to over population 
				else if ((grid[l][m] == 1) && (aliveNeighbours > 3)) 
					future[l][m] = 0; 

				// A new cell is born 
				else if ((grid[l][m] == 0) && (aliveNeighbours == 3)) 
					future[l][m] = 1; 

				// Remains the same 
				else
					future[l][m] = grid[l][m]; 
			} 
		} 
                System.out.println(); System.out.println();
		System.out.println("Next Generation"); 
                System.out.println(); System.out.println(); 
		for (int i = 0; i < M; i++) 
		{ System.out.print("          ");
			for (int j = 0; j < N; j++) 
			{ 
				if (future[i][j] == 0) 
					System.out.print(" "); 
				else
					System.out.print("*"); 
			} 
			System.out.println(); 
                       
		} 
	} 
} 