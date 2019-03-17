package controller;

import controller.*;

public final class Simulation {

	static int counter = 0;
	static int time = 0;
	static int[] treeCount = new int[4];
	static int sapling = 0;
	static int bush = 0;
	static int tree = 0;
	static int[][] checkListX = new int[3][3];
	static int[][] checkListY = new int[3][3];
	
	static int[] checkAround(Cell[][] array, Cell currentCell, int stateNumber) {
		
		int[] stateArray = new int[stateNumber];
		
		for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
            	
            	if (array[i][j].getY() == currentCell.getY() - 1 || array[i][j].getY() == currentCell.getY() + 1) {
                    if ((array[i][j].getX() >= currentCell.getX() - 1) && (array[i][j].getX() <= currentCell.getX() + 1)) {
                    	
                    	for (int z = 0; z <= stateArray.length; z++) {
                    		if (array[i][j].getType() == z) {
                        		
                    			stateArray[z]++;
                    			
                        	}
                    	}
                    	
                    }
            	}
            	else if (array[i][j].getY() == currentCell.getY()) {
            		if (array[i][j].getX() == currentCell.getX() - 1 || array[i][j].getX() == currentCell.getX() + 1) {
            			
            			for (int z = 0; z <= stateArray.length; z++) {
                    		if (array[i][j].getType() == z) {
                        		
                    			stateArray[z]++;
                    			
                        	}
                    	}
            			
            		}
            	}
            }
		}
        		
    			return stateArray;
	}
	
	public static void stepGrowth(Cell[][] array, Cell currentCell,Cell dupeCell, int stateNumber) {
		
		int[] stateArray = checkAround(array, currentCell, stateNumber);
		int emptyR = stateArray[0];
		int saplingR = stateArray[1];
		int bushR = stateArray[2];
		int treeR = stateArray[3];
		int fireR = stateArray[4];
		int ashR = stateArray[5];
		int infectionR = stateArray[6];
		
		// Sapling vers Bush
		if (currentCell.getType() == 1) {
			if (bushR <= 3 || treeR <= 3 ) {
				dupeCell.setType(2);
			}
		}
		
		// Bush to Tree
		if (currentCell.getType() == 2) {
			dupeCell.setType(2);
			dupeCell.setBushGrowth(dupeCell.getBushGrowth()+1);
			if (dupeCell.getBushGrowth() == 2) {
				dupeCell.setType(3);
				dupeCell.setBushGrowth(0);
			}
			else if (currentCell.getType() == 3) {
				dupeCell.setType(3);
			}
			
		}
		
		// Naissance Sapling
		if (currentCell.getType() == 0) {
			if (treeR >= 2 || bushR >= 3 || (treeR == 1 && bushR == 2)) {
				dupeCell.setType(1);
			}
		}
		
		// Fire
		
		// Sapling in Fire
		if (currentCell.getType() == 1) {
			if (fireR >= 1) {
				if (Math.random() <= 0.25) {
					dupeCell.setType(4);
				}
			}
		}
		
		// Bush in Fire
		if (currentCell.getType() == 2) {
			if (fireR >= 1) {
				if (Math.random() <= 0.50) {
					dupeCell.setType(4);
				}
			}
		}
		
		// Tree in Fire
		if (currentCell.getType() == 3) {
			if (fireR >= 1) {
				if (Math.random() <= 0.75) {
					dupeCell.setType(4);
				}
			}
		}
		
		// Fire to Ashes
		if (currentCell.getType() == 4) {
				dupeCell.setType(5);
		}
		
		// Ashes to empty
		if (currentCell.getType() == 5) {
			dupeCell.setType(0);
	}
		
	}
}
	








