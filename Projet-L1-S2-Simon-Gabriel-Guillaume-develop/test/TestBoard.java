package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBoard {

	@Test
	void testCreateBoard() {
		int [] boardTest = main.Board.createBoard();
		if(boardTest.length != 0) {
			fail("Le tableau est trop grand");
		}
	}

	@Test
	void testCreateBoardInt() {
		int [] boardTest = main.Board.createBoard(5);
		if(boardTest.length < 5) 
			fail("Le tableau est trop petit pour 5");
		else if(boardTest.length > 5)
			fail("Tableau trop grand pour 5");
		
		boardTest = main.Board.createBoard(0);
		if(boardTest.length < 0) 
			fail("Le tableau est trop petit pour 0");
		else if(boardTest.length > 0)
			fail("Tableau trop grand pour 0");
	}

	@Test
	void testStateBoard() {
		int [] boardTest1 = {1,3,5,7,9};
		
		
		main.Board.stateBoard(0, 4, boardTest1);
		if(boardTest1[0] != -3)
			fail("ERROR -3 expected");
		
		int [] boardTest2 = {1,3,5,7,9};
		main.Board.stateBoard(1, 4, boardTest2);
		if(boardTest2[1] != -1)
			fail("ERROR -1 expected");
		
		int [] boardTest3 = {1,3,5,7,9};
		main.Board.stateBoard(4, 4, boardTest3);
		if(boardTest3[4] != 5)
			fail("ERROR 5 expected");
		
		int [] boardTest4 = {1,3,5,7,9};
		main.Board.stateBoard(0, 0, boardTest4);
		if(boardTest4[0] != 1)
			fail("ERROR 1 expected as " + boardTest4[0] + " is wrong.");
		
		int [] boardTest5 = {1,3,5,7,9};
		main.Board.stateBoard(0, -1, boardTest5);
		if(boardTest5[0] != 2)
			fail("ERROR 2 expected");
	}

	@Test
	void testMain() {
		//TODO or not TODO, that is the question
	}

}
