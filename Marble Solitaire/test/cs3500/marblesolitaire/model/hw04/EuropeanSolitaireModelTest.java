package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Represents testing for European Model.
 */
public class EuropeanSolitaireModelTest {

  @Test
  public void testCreateBoard() {
    EuropeanSolitaireModel game0 = new EuropeanSolitaireModel();
    EuropeanSolitaireModel game1 = new EuropeanSolitaireModel(1, 4);
    EuropeanSolitaireModel game2 = new EuropeanSolitaireModel(5);
    EuropeanSolitaireModel game3 = new EuropeanSolitaireModel(5, 4, 3);
    EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(1 , 1);

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> game0Board = new ArrayList<>();

    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Invalid)));
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Empty, Marble, Marble, Marble)));
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Invalid)));
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> game1Board = new ArrayList<>();

    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));
    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Marble, Marble, Marble, Empty, Marble, Invalid)));
    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Invalid)));
    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> game2Board = new ArrayList<>();

    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Invalid, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Empty, Marble, Marble,
                    Marble, Marble, Marble, Marble)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Invalid, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Invalid, Invalid, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> game3Board = new ArrayList<>();

    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Invalid, Invalid, Invalid)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Invalid, Invalid)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble, Invalid)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Empty, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Marble, Invalid)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Marble, Invalid, Invalid)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble, Marble,
                    Marble, Marble, Invalid, Invalid, Invalid)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));

    assertEquals(game0Board, game0.board);
    assertEquals(game1Board, game1.board);
    assertEquals(game2Board, game2.board);
    assertEquals(game3Board, game3.board);

  }

  @Test
  public void testInvalidConstructors() {
    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(-3);
      fail("Constructor has an invalid (negative) arm thickness should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(6);
      fail("Constructor has an invalid (even) arm thickness should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(-3, 3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (-3,3)", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(3, -3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (3,-3)", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(0, 0);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,0)", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(-3, 3, 3);
      fail("Constructor has an invalid arm thickness should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(6, 3, 3);
      fail("Constructor has an invalid arm thickness should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(-3, 3, 3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(6, 3, 3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(4, 3, 3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(7, 0, 2);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,2)", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(5, -3, 3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (-3,3)", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(5, 3, -3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (3,-3)", e.getMessage());
    }

    try {
      EuropeanSolitaireModel game4 = new EuropeanSolitaireModel(5, 0, 0);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,0)", e.getMessage());
    }
  }


  @Test
  public void testMove() {
    EuropeanSolitaireModel game0 = new EuropeanSolitaireModel();

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> game4Board = new ArrayList<>();
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Invalid)));
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Empty, Empty, Marble, Marble, Marble, Marble)));
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Invalid)));
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));

    game0.move(3, 1, 3, 3); // right
    assertEquals(game4Board, game0.board);
    game0.move(5, 1, 3, 1); // up with added marble
    game4Board.get(5).set(1, Empty);
    game4Board.get(4).set(1, Empty);
    game4Board.get(3).set(1, Marble);
    assertEquals(game4Board, game0.board);
    game0.move(2, 1, 4, 1); // down
    game4Board.get(2).set(1, Empty);
    game4Board.get(3).set(1, Empty);
    game4Board.get(4).set(1, Marble);
    assertEquals(game4Board, game0.board);
    game0.move(3, 4, 3, 2); // left
    game4Board.get(3).set(4, Empty);
    game4Board.get(3).set(3, Empty);
    game4Board.get(3).set(2, Marble);
  }

  @Test
  public void testMoveException() {
    EuropeanSolitaireModel game0 = new EuropeanSolitaireModel();

    game0.move(3, 1, 3, 3);
    // moving an empty slot
    try {
      game0.move(3, 1, 3, 0);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    // moving a marble to an empty slot but is jumping over an empty slot
    // (empty slot between from and to)
    try {
      game0.move(3, 0, 3, 2);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // if from and to slots are two away by row but column is not the same
      game0.move(3, 0, 3, 2);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // if from and to slots are two away by row but column is not the same
      game0.move(3, 0, 3, 2);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving a marble to an empty slot that is 5 slots away
      game0.move(3, 6, 3, 1);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving a marble to a marble slot state (2 slots away) with an empty slot between
      game0.move(2, 1, 4, 1);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving an invalid
      game0.move(0, 0, 2, 0);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving an empty
      game0.move(3, 3, 1, 3);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving a marble to an invalid slot
      game0.move(1, 4, 2, 2);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving an out-of-bounds coordinate
      game0.move(-1, 4, 2, 2);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving an out-of-bounds coordinate
      game0.move(1, 4, -2, 2);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }
  }

  @Test
  public void testGameOver() {
    EuropeanSolitaireModel game0 = new EuropeanSolitaireModel();
    assertEquals(false, game0.isGameOver());
    game0.move(1, 3, 3, 3);
    game0.move(1, 5, 1, 3);
    game0.move(1, 2, 1, 4);
    game0.move(2, 1, 2, 3);
    game0.move(4, 2, 2, 2);
    game0.move(2, 3, 2, 1);
    game0.move(2, 0, 2, 2);
    game0.move(2, 5, 2, 3);
    game0.move(0, 4, 2, 4);
    game0.move(0, 2, 0, 4);
    game0.move(3, 0, 3, 2);
    game0.move(2, 2, 4, 2);
    game0.move(2, 3, 2, 5);
    game0.move(4, 3, 2, 3);
    game0.move(6, 3, 4, 3);
    game0.move(5, 5, 5, 3);
    game0.move(4, 4, 2, 4);
    game0.move(5, 3, 3, 3);
    game0.move(4, 1, 4, 3);
    game0.move(2, 4, 2, 2);
    game0.move(3, 5, 1, 5);
    game0.move(3, 3, 5, 3);
    game0.move(5, 2, 5, 4);
    game0.move(6, 4, 4, 4);
    game0.move(4, 5, 4, 3);
    assertEquals(true, game0.isGameOver());
  }

  @Test
  public void testGetSlotAt() {
    EuropeanSolitaireModel game0 = new EuropeanSolitaireModel();

    assertEquals(Invalid, game0.getSlotAt(0, 0));
    assertEquals(Marble, game0.getSlotAt(3, 2));
    assertEquals(Marble, game0.getSlotAt(1, 1));
    assertEquals(Marble, game0.getSlotAt(1, 5));
    assertEquals(Marble, game0.getSlotAt(5, 1));
    assertEquals(Marble, game0.getSlotAt(5, 5));
    assertEquals(Empty, game0.getSlotAt(3, 3));
  }

  @Test
  public void testGetSlotAtException() {
    EuropeanSolitaireModel game0 = new EuropeanSolitaireModel();

    try {
      game0.getSlotAt(-1, 3);
      fail("Should've returned exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid coordinate position", e.getMessage());
    }

    try {
      game0.getSlotAt(1, -3);
      fail("Should've returned exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid coordinate position", e.getMessage());
    }

    try {
      game0.getSlotAt(1, 10);
      fail("Should've returned exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid coordinate position", e.getMessage());
    }

    try {
      game0.getSlotAt(-1, -1);
      fail("Should've returned exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid coordinate position", e.getMessage());
    }
  }

  @Test
  public void testGetBoardSize() {
    EuropeanSolitaireModel game0 = new EuropeanSolitaireModel();
    EuropeanSolitaireModel game2 = new EuropeanSolitaireModel(5);

    assertEquals(7, game0.getBoardSize());
    assertEquals(13, game2.getBoardSize());
  }

  @Test
  public void testGetScore() {
    EuropeanSolitaireModel game0 = new EuropeanSolitaireModel();
    EuropeanSolitaireModel game2 = new EuropeanSolitaireModel(5);

    assertEquals(36, game0.getScore());
    assertEquals(128, game2.getScore());
  }
}