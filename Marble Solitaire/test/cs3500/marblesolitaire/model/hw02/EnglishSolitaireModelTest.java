package cs3500.marblesolitaire.model.hw02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Represents english solitaire model tests.
 */
public class EnglishSolitaireModelTest {

  @Test
  public void testCreateBoard() {
    EnglishSolitaireModel game0 = new EnglishSolitaireModel();
    EnglishSolitaireModel game1 = new EnglishSolitaireModel(1, 4);
    EnglishSolitaireModel game2 = new EnglishSolitaireModel(5);
    EnglishSolitaireModel game3 = new EnglishSolitaireModel(5, 4, 3);

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> game0Board = new ArrayList<>();
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Empty, Marble, Marble, Marble)));
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));
    game0Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> game1Board = new ArrayList<>();

    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));
    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Empty, Invalid, Invalid)));
    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));
    game1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> game2Board = new ArrayList<>();

    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
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
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> game3Board = new ArrayList<>();

    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
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
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
    game3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                    Marble, Invalid, Invalid, Invalid, Invalid)));
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
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(-3);
      fail("Constructor has an invalid (negative) arm thickness should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(6);
      fail("Constructor has an invalid (even) arm thickness should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(-3, 3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (-3,3)", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(3, -3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (3,-3)", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(0, 0);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,0)", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(-3, 3, 3);
      fail("Constructor has an invalid arm thickness should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(6, 3, 3);
      fail("Constructor has an invalid arm thickness should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(-3, 3, 3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(6, 3, 3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(4, 3, 3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(7, 0, 2);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,2)", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(5, -3, 3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (-3,3)", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(5, 3, -3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (3,-3)", e.getMessage());
    }

    try {
      EnglishSolitaireModel game4 = new EnglishSolitaireModel(5, 0, 0);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,0)", e.getMessage());
    }
  }

  @Test
  public void testMove() {
    EnglishSolitaireModel game0 = new EnglishSolitaireModel();

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> game4Board = new ArrayList<>();
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Empty, Empty, Marble, Marble, Marble, Marble)));
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble)));
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));
    game4Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(
            Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid)));

    game0.move(3, 1, 3, 3); // right
    assertEquals(game4Board, game0.board);
    game0.move(5,2, 3, 2); // up
    game4Board.get(5).set(2, Empty);
    game4Board.get(4).set(2, Empty);
    game4Board.get(3).set(2, Marble);
    assertEquals(game4Board, game0.board);
    game0.move(2,2, 4, 2);// down
    game4Board.get(2).set(2, Empty);
    game4Board.get(3).set(2, Empty);
    game4Board.get(4).set(2, Marble);
    assertEquals(game4Board, game0.board);
    game0.move(2,4, 2, 2); // left
    game4Board.get(2).set(4, Empty);
    game4Board.get(2).set(3, Empty);
    game4Board.get(2).set(2, Marble);
    assertEquals(game4Board, game0.board);
    game0.move(4,3, 2, 3); // up
    game4Board.get(4).set(3, Empty);
    game4Board.get(3).set(3, Empty);
    game4Board.get(2).set(3, Marble);
    assertEquals(game4Board, game0.board);
  }

  @Test
  public void testMoveException() {
    EnglishSolitaireModel game0 = new EnglishSolitaireModel();

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
  public void testIsGameOver() {
    EnglishSolitaireModel game0 = new EnglishSolitaireModel();

    assertEquals(false, game0.isGameOver());
    game0.move(3, 1, 3, 3);
    game0.move(1, 2, 3, 2);
    game0.move(3, 3, 3, 1);
    game0.move(3, 0, 3, 2);
    game0.move(2, 0, 2, 2);
    game0.move(2, 3, 2, 1);
    game0.move(0, 3, 2, 3);
    game0.move(2, 4, 2, 2);
    game0.move(5, 3, 3, 3);
    game0.move(2, 1, 2, 3);
    game0.move(3, 3, 3, 1);
    game0.move(4, 1, 2, 1);
    game0.move(5, 2, 3, 2);
    game0.move(4, 4, 2, 4);
    game0.move(1, 4, 3, 4);
    game0.move(3, 5, 3, 3);
    game0.move(3, 3, 1, 3);
    game0.move(2, 6, 2, 4);
    game0.move(6, 4, 4, 4);
    game0.move(4, 5, 4, 3);
    game0.move(4, 6, 2, 6);
    game0.move(6, 2, 6, 4);
    // no more moves
    assertEquals(true, game0.isGameOver());
  }

  @Test
  public void testGetSlotAt() {
    EnglishSolitaireModel game0 = new EnglishSolitaireModel();

    assertEquals(Invalid, game0.getSlotAt(0, 0));
    assertEquals(Marble, game0.getSlotAt(3, 2));
    assertEquals(Empty, game0.getSlotAt(3, 3));
  }

  @Test
  public void testGetSlotAtException() {
    EnglishSolitaireModel game0 = new EnglishSolitaireModel();

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
    EnglishSolitaireModel game0 = new EnglishSolitaireModel();
    EnglishSolitaireModel game2 = new EnglishSolitaireModel(5);

    assertEquals(7, game0.getBoardSize());
    assertEquals(13, game2.getBoardSize());
  }

  @Test
  public void testGetScore() {
    EnglishSolitaireModel game0 = new EnglishSolitaireModel();
    EnglishSolitaireModel game2 = new EnglishSolitaireModel(5);

    assertEquals(32, game0.getScore());
    assertEquals(104, game2.getScore());
  }
}