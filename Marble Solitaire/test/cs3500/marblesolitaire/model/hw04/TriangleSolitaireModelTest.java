package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Represents testing for Triangle Solitaire model.
 */
public class TriangleSolitaireModelTest {
  @Test
  public void testTriangleModel() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    TriangleSolitaireModel model1 = new TriangleSolitaireModel(6);
    TriangleSolitaireModel model2 = new TriangleSolitaireModel(6, 4, 1);
    TriangleSolitaireModel model3 = new TriangleSolitaireModel(4, 1);

    model.move(0, 0, 2, 0);

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> modelBoard = new ArrayList<>();
    modelBoard.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Empty)));
    modelBoard.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble)));
    modelBoard.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble)));
    modelBoard.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble, Marble)));
    modelBoard.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble, Marble, Marble)));

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> model1Board = new ArrayList<>();
    model1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Empty)));
    model1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble)));
    model1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble)));
    model1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble, Marble)));
    model1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble, Marble, Marble)));
    model1Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble, Marble, Marble, Marble)));

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> model2Board = new ArrayList<>();
    model2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble)));
    model2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble)));
    model2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble)));
    model2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble, Marble)));
    model2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Empty, Marble, Marble, Marble)));
    model2Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble, Marble, Marble, Marble)));

    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> model3Board = new ArrayList<>();
    model3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble)));
    model3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble)));
    model3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble)));
    model3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble, Marble)));
    model3Board.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Empty, Marble, Marble, Marble)));

    assertEquals(modelBoard, model.board);
    assertEquals(model1Board, model1.board);
    assertEquals(model2Board, model2.board);
    assertEquals(model3Board, model3.board);
  }

  @Test
  public void testInvalidConstructors() {
    try {
      TriangleSolitaireModel game4 = new TriangleSolitaireModel(-3);
      fail("Constructor has an invalid (negative) arm thickness should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      TriangleSolitaireModel game4 = new TriangleSolitaireModel(-3, 3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (-3,3)", e.getMessage());
    }

    try {
      TriangleSolitaireModel game4 = new TriangleSolitaireModel(3, 5);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (3,5)", e.getMessage());
    }

    try {
      TriangleSolitaireModel game4 = new TriangleSolitaireModel(3, -3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (3,-3)", e.getMessage());
    }

    try {
      TriangleSolitaireModel game4 = new TriangleSolitaireModel(-3, 3, 3);
      fail("Constructor has an invalid arm thickness should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness", e.getMessage());
    }

    try {
      TriangleSolitaireModel game4 = new TriangleSolitaireModel(7, 0, 2);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,2)", e.getMessage());
    }

    try {
      TriangleSolitaireModel game4 = new TriangleSolitaireModel(5, -3, 3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (-3,3)", e.getMessage());
    }

    try {
      TriangleSolitaireModel game4 = new TriangleSolitaireModel(5, 3, -3);
      fail("Constructor has an invalid position for empty slot should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (3,-3)", e.getMessage());
    }
  }

  @Test
  public void testMoveTriangleModel() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> modelBoard = new ArrayList<>();
    modelBoard.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Empty)));
    modelBoard.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble)));
    modelBoard.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble)));
    modelBoard.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble, Marble)));
    modelBoard.add(new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(
            Marble, Marble, Marble, Marble, Marble)));

    // up right
    model.move(2, 0, 0, 0);
    modelBoard.get(2).set(0, Empty);
    modelBoard.get(1).set(0, Empty);
    modelBoard.get(0).set(0, Marble);
    assertEquals(modelBoard, model.board);
    //left
    model.move(2, 2, 2, 0);
    modelBoard.get(2).set(2, Empty);
    modelBoard.get(2).set(1, Empty);
    modelBoard.get(2).set(0, Marble);
    assertEquals(modelBoard, model.board);
    //down right
    model.move(0, 0, 2, 2);
    modelBoard.get(0).set(0, Empty);
    modelBoard.get(1).set(1, Empty);
    modelBoard.get(2).set(2, Marble);
    assertEquals(modelBoard, model.board);
    // up left
    model.move(3 , 3, 1, 1);
    modelBoard.get(3).set(3, Empty);
    modelBoard.get(2).set(2, Empty);
    modelBoard.get(1).set(1, Marble);
    assertEquals(modelBoard, model.board);
    model.move(4, 3, 2, 1);
    modelBoard.get(4).set(3, Empty);
    modelBoard.get(3).set(2, Empty);
    modelBoard.get(2).set(1, Marble);
    model.move(4, 1, 4, 3);
    modelBoard.get(4).set(1, Empty);
    modelBoard.get(4).set(2, Empty);
    modelBoard.get(4).set(3, Marble);
    // down left
    model.move(2, 1, 4, 1);
    modelBoard.get(2).set(1, Empty);
    modelBoard.get(3).set(1, Empty);
    modelBoard.get(4).set(1, Marble);
    assertEquals(modelBoard, model.board);
  }

  @Test
  public void testGameOver() {
    MarbleSolitaireModel model = new TriangleSolitaireModel(6, 3, 1);
    assertFalse(model.isGameOver());
    model.move(5, 3, 3, 1);
    model.move(5, 5, 5, 3);
    model.move(5, 2, 5, 4);
    model.move(2, 2, 4, 2);
    model.move(5, 4, 3, 2);
    model.move(2, 0, 2, 2);
    model.move(0, 0, 2, 0);
    model.move(4, 1, 2, 1);
    model.move(3, 2, 1, 0);
    model.move(2, 0, 0, 0);
    model.move(3, 3, 5, 5);
    model.move(1, 1, 3, 3);
    model.move(5, 0, 5, 2);
    model.move(5, 2, 3, 2);
    model.move(3, 3, 3, 1);
    model.move(3, 0, 3, 2);
    assertTrue(model.isGameOver());
  }

  @Test
  public void testMoveException() {
    TriangleSolitaireModel game0 = new TriangleSolitaireModel();

    game0.move(2, 0, 0, 0);
    game0.move(4, 0, 2, 0);
    // moving an empty slot
    try {
      game0.move(1, 0, 3, 0);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    // moving a marble to an empty slot but is jumping over an empty slot
    // (empty slot between from and to)
    try {
      game0.move(2, 0, 4, 0);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // if from and to slots are two away by row but is not moving diagonally (straight)
      game0.move(3, 1, 1, 0);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving a marble to an empty slot that is 4 slots away
      game0.move(4, 4, 4, 0);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving a marble to a marble slot state (2 slots away) with an empty slot between
      game0.move(2, 0, 0, 0);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // from is out of bounds
      game0.move(0, 1, 2, 0);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving a marble to an out of bounds
      game0.move(2, 1, 2, 3);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving an empty
      game0.move(3, 0, 1, 0);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving an out-of-bounds coordinate
      game0.move(3, -2, 2, 2);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }

    try { // moving an out-of-bounds coordinate
      game0.move(3, 2, -1, 0);
      fail("Move method did not throw an exception when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move", e.getMessage());
    }
  }

  @Test
  public void testGetSlotAt() {
    TriangleSolitaireModel game0 = new TriangleSolitaireModel();

    assertEquals(Marble, game0.getSlotAt(3, 2));
    assertEquals(Empty, game0.getSlotAt(0, 0));
  }

  @Test
  public void testGetSlotAtException() {
    TriangleSolitaireModel game0 = new TriangleSolitaireModel();

    try {
      game0.getSlotAt(-1, 0);
      fail("Should've returned exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid coordinate position", e.getMessage());
    }

    try {
      game0.getSlotAt(1, -1);
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
    TriangleSolitaireModel game0 = new TriangleSolitaireModel();
    TriangleSolitaireModel game2 = new TriangleSolitaireModel(6);

    assertEquals(5, game0.getBoardSize());
    assertEquals(6, game2.getBoardSize());
  }

  @Test
  public void testGetScore() {
    TriangleSolitaireModel game0 = new TriangleSolitaireModel();
    TriangleSolitaireModel game2 = new TriangleSolitaireModel(6);

    assertEquals(14, game0.getScore());
    assertEquals(20, game2.getScore());
  }

}