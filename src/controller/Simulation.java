package controller;

import controller.*;

public final class Simulation {

	static int counter = 0;
	static int time = 0;

	static void checkNeighbors(Cell[][] array, Cell currentCell, int x, int y) {

		// Sapling growth

		if (counter < 3) {

			if (array[x][y].getType() == 1) {	

				// Testing BottomLeft

				if (currentCell.getTouchBounds() == "BottomLeft") {

					// Is Top cell empty or a sapling ?
					if (array[x][y-1].getType() < 2 || currentCell.getTime() == 0) {
						// Is Top Right cell empty or sapling ?
						if (array[x+1][y-1].getType() < 2 || currentCell.getTime() == 0) {
							// Is Right cell empty or sapling ?
							if (array[x+1][y].getType() < 2 || currentCell.getTime() == 0) {

								currentCell.setType(2);
								Types.changeColor(currentCell.getType(), currentCell);
								currentCell.setTime(time++);
								counter=0;

							}
							else {
								counter++;
							}
						}
						else {
							counter++;
						}
					}
					else {
						counter++;
					}

				}

				// Testing BottomRight

				if (currentCell.getTouchBounds() == "BottomRight") {

					// Is Top cell empty or a sapling ?
					if (array[x][y-1].getType() < 2 || currentCell.getTime() == 0) {
						// Is Top Left cell empty or sapling ?
						if (array[x-1][y-1].getType() < 2 || currentCell.getTime() == 0) {
							// Is Left cell empty or sapling ?
							if (array[x-1][y].getType() < 2 || currentCell.getTime() == 0) {

								currentCell.setType(2);
								Types.changeColor(currentCell.getType(), currentCell);
								currentCell.setTime(time++);
								counter=0;

							}
							else {
								counter++;
							}
						}
						else {
							counter++;
						}
					}
					else {
						counter++;
					}
				}

				// Testing TopLeft

				if (currentCell.getTouchBounds() == "TopLeft") {

					// Is Right cell empty or a sapling ?
					if (array[x+1][y].getType() < 2 || currentCell.getTime() == 0) {
						// Is Bottom Right cell empty or sapling ?
						if (array[x+1][y+1].getType() < 2 || currentCell.getTime() == 0) {
							// Is Down cell empty or sapling ?
							if (array[x][y+1].getType() < 2 || currentCell.getTime() == 0) {

								currentCell.setType(2);
								Types.changeColor(currentCell.getType(), currentCell);
								currentCell.setTime(time++);
								counter=0;

							}
							else {
								counter++;
							}
						}
						else {
							counter++;
						}
					}
					else {
						counter++;
					}
				}

				// Testing Top

				if (currentCell.getTouchBounds() == "Top") {

					// Is Right cell empty or a sapling ?
					if (array[x+1][y].getType() < 2 || currentCell.getTime() == 0) {
						// Is Bottom Right cell empty or sapling ?
						if (array[x+1][y+1].getType() < 2 || currentCell.getTime() == 0) {
							// Is Down cell empty or sapling ?
							if (array[x][y+1].getType() < 2 || currentCell.getTime() == 0) {
								// Is Left Down cell empty or sapling ?
								if (array[x-1][y+1].getType() < 2 || currentCell.getTime() == 0) {
									// Is Left cell empty or sapling ?
									if (array[x-1][y].getType() < 2 || currentCell.getTime() == 0) {

										currentCell.setType(2);
										Types.changeColor(currentCell.getType(), currentCell);
										currentCell.setTime(time++);
										counter=0;

									}
									else {
										counter++;
									}
								}
								else {
									counter++;
								}
							}
							else {
								counter++;
							}
						}
						else {
							counter++;
						}
					}
					else {
						counter++;
					}

				}

				// Testing Right

				if (currentCell.getTouchBounds() == "Right") {

					// Is Top cell empty or a sapling ?
					if (array[x][y-1].getType() < 2 || currentCell.getTime() == 0) {
						// Is Top Left cell empty or sapling ?
						if (array[x-1][y-1].getType() < 2 || currentCell.getTime() == 0) {
							// Is Left cell empty or sapling ?
							if (array[x-1][y].getType() < 2 || currentCell.getTime() == 0) {
								// Is Bottom Left cell empty or sapling ?
								if (array[x-1][y+1].getType() < 2 || currentCell.getTime() == 0) {
									// Is Bottom cell empty or sapling ?
									if (array[x][y+1].getType() < 2 || currentCell.getTime() == 0) {

										currentCell.setType(2);
										Types.changeColor(currentCell.getType(), currentCell);
										currentCell.setTime(time++);
										counter=0;

									}
									else {
										counter++;
									}
								}
								else {
									counter++;
								}
							}
							else {
								counter++;
							}
						}
						else {
							counter++;
						}
					}
					else {
						counter++;
					}

				}

				// Testing Left

				if (currentCell.getTouchBounds() == "Left") {

					// Is Top cell empty or a sapling ?
					if (array[x][y-1].getType() < 2 || currentCell.getTime() == 0) {
						// Is Top Right cell empty or sapling ?
						if (array[x+1][y-1].getType() < 2 || currentCell.getTime() == 0) {
							// Is Right cell empty or sapling ?
							if (array[x+1][y].getType() < 2 || currentCell.getTime() == 0) {
								// Is Bottom Right cell empty or sapling ?
								if (array[x+1][y+1].getType() < 2 || currentCell.getTime() == 0) {
									// Is Bottom cell empty or sapling ?
									if (array[x][y+1].getType() < 2 || currentCell.getTime() == 0) {

										currentCell.setType(2);
										Types.changeColor(currentCell.getType(), currentCell);
										currentCell.setTime(time++);
										counter=0;

									}
									else {
										counter++;
									}
								}
								else {
									counter++;
								}
							}
							else {
								counter++;
							}
						}
						else {
							counter++;
						}
					}
					else {
						counter++;
					}

				}

				// Testing Bottom

				if (currentCell.getTouchBounds() == "Bottom") {

					// Is Left cell empty or a sapling ?
					if (array[x-1][y].getType() < 2 || currentCell.getTime() == 0) {
						// Is Top Left Right cell empty or sapling ?
						if (array[x-1][y-1].getType() < 2 || currentCell.getTime() == 0) {
							// Is Top cell empty or sapling ?
							if (array[x][y-1].getType() < 2 || currentCell.getTime() == 0) {
								// Is Top Right cell empty or sapling ?
								if (array[x+1][y-1].getType() < 2 || currentCell.getTime() == 0) {
									// Is Right cell empty or sapling ?
									if (array[x+1][y].getType() < 2 || currentCell.getTime() == 0) {

										currentCell.setType(2);
										Types.changeColor(currentCell.getType(), currentCell);
										currentCell.setTime(time++);
										counter=0;

									}
									else {
										counter++;
									}
								}
								else {
									counter++;
								}
							}
							else {
								counter++;
							}
						}
						else {
							counter++;
						}
					}
					else {
						counter++;
					}

				}

				// Testing TopRight

				if (currentCell.getTouchBounds() == "TopRight") {

					// Is Left cell empty or a sapling ?
					if (array[x-1][y].getType() < 2 || currentCell.getTime() == 0) {
						// Is Bottom Left cell empty or sapling ?
						if (array[x-1][y+1].getType() < 2 || currentCell.getTime() == 0) {
							// Is Down cell empty or sapling ?
							if (array[x][y+1].getType() < 2 || currentCell.getTime() == 0) {

								currentCell.setType(2);
								Types.changeColor(currentCell.getType(), currentCell);
								currentCell.setTime(time++);
								counter=0;

							}
							else {
								counter++;
							}
						}
						else {
							counter++;
						}
					}
					else {
						counter++;
					}
				}

				// Testing Center

				if (currentCell.getTouchBounds() == "Center") {

					// Is Left cell empty or a sapling ?
					if (array[x-1][y].getType() < 2 || currentCell.getTime() == 0) {
						// Is Top Left cell empty or sapling ?
						if (array[x-1][y-1].getType() < 2 || currentCell.getTime() == 0) {
							// Is Top cell empty or sapling ?
							if (array[x][y-1].getType() < 2 || currentCell.getTime() == 0) {
								// Is Top Right cell empty or sapling ?
								if (array[x+1][y-1].getType() < 2 || currentCell.getTime() == 0) {
									// Is Right cell empty or sapling ?
									if (array[x+1][y].getType() < 2 || currentCell.getTime() == 0) {
										// Is Bottom Right cell empty or sapling ?
										if (array[x+1][y+1].getType() < 2 || currentCell.getTime() == 0) {
											// Is Bottom cell empty or sapling ?
											if (array[x][y+1].getType() < 2 || currentCell.getTime() == 0) {
												// Is Bottom Left cell empty or sapling ?
												if (array[x-1][y+1].getType() < 2 || currentCell.getTime() == 0) {

													currentCell.setType(2);
													Types.changeColor(currentCell.getType(), currentCell);
													currentCell.setTime(time++);
													counter=0;

												}
												else {

												}
											}
										}
										else {

										}
									}
									else {

									}
								}
								else {
									counter++;
								}
							}
							else {
								counter++;
							}
						}
						else {
							counter++;
						}
					}
					else {
						counter++;
					}
				}
			}
		}
	}
}








