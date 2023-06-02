package cs3500.marblesolitaire.controller;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.Random;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.EuropeanSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Represents tests for marble solitaire controller impl.
 */
public class MarbleSolitaireControllerImplTest {

  /**
   * Represents a mock model of marble solitaire model.
   */
  class MockModel extends AbstractMock {

    public MockModel(StringBuilder stringBuilder) {
      super(stringBuilder);
    }

    @Override
    public int getScore() {
      return 32;
    }
  }

  @Test
  public void testControllerInputs() {
    Readable in = null;
    StringBuilder allInputs = new StringBuilder();
    StringBuilder expectedLogs = new StringBuilder();

    Random r = new Random(100);
    String input = "";
    for (int i = 0; i < 10; i++) {
      int fromRow = r.nextInt(7);
      int fromCol = r.nextInt(7);
      int toRow = r.nextInt(7);
      int toCol = r.nextInt(7);

      input = (fromRow + " " + fromCol + " " + toRow + " " + toCol);
      allInputs.append(input + "\n");

      fromRow--;
      fromCol--;
      toRow--;
      toCol--;
      expectedLogs.append("Move Inputs: " + fromRow + ", " + fromCol + ", "
              + toRow + ", " + toCol + "\n");
    }

    in = new StringReader(allInputs.toString());
    Appendable out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel game0 = new EnglishSolitaireModel(3);
    MarbleSolitaireView game0View = new MarbleSolitaireTextView(game0, out);
    MockModel model = new MockModel(log);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, game0View, in);
    controller.playGame();
    assertEquals(expectedLogs.toString(), log.toString());
  }

  @Test
  public void testOutputs() {
    Readable in = null;
    StringBuilder expectedOut = new StringBuilder();

    expectedOut.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "\n" +
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31");

    in = new StringReader("2 4 4 4 q");
    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView game0View = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, game0View, in);
    controller.playGame();
    assertEquals(expectedOut.toString(), output.toString().replace("\r", ""));
  }

  @Test
  public void testConstructor() {
    // null view
    try {
      MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(
              new EnglishSolitaireModel(), null, new StringReader("3 2 3 3"));
      fail("Should've thrown exception, arguments cannot be null");
    } catch (IllegalArgumentException e) {
      assertEquals("Arguments cannot be null", e.getMessage());
    }

    // null readable
    try {
      MarbleSolitaireModel game0 = new EnglishSolitaireModel(3);
      MarbleSolitaireView game0View = new MarbleSolitaireTextView(game0, new StringBuilder());
      MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(
              new EnglishSolitaireModel(), game0View, null);
      fail("Should've thrown exception, arguments cannot be null");
    } catch (IllegalArgumentException e) {
      assertEquals("Arguments cannot be null", e.getMessage());
    }

    // null model
    try {
      MarbleSolitaireModel game0 = new EnglishSolitaireModel(3);
      MarbleSolitaireView game0View = new MarbleSolitaireTextView(game0, new StringBuilder());
      MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(
              null, game0View, new StringReader("3 2 3 3"));
      fail("Should've thrown exception, arguments cannot be null");
    } catch (IllegalArgumentException e) {
      assertEquals("Arguments cannot be null", e.getMessage());
    }
  }

  @Test
  public void testPlayGameException() {
    MarbleSolitaireModel game0 = new EnglishSolitaireModel(3);
    MarbleSolitaireView game0View = new MarbleSolitaireTextView(game0, new StringBuilder());
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game0, game0View,
            new StringReader("4 3 4 4"));
    // no more inputs
    try {
      controller.playGame();
      fail("Should've thrown exception, arguments cannot be null");
    } catch (IllegalStateException e) {
      assertEquals("No more inputs", e.getMessage());
    }

    // all null
    try {
      new MarbleSolitaireControllerImpl(null, null, null).
              playGame();
      fail("Should've thrown exception, arguments cannot be null");
    } catch (IllegalArgumentException e) {
      assertEquals("Arguments cannot be null", e.getMessage());
    }
    // null view
    try {
      new MarbleSolitaireControllerImpl(new EnglishSolitaireModel(),
              null, new StringReader("3 2 3 3")).playGame();
      fail("Should've thrown exception, arguments cannot be null");
    } catch (IllegalArgumentException e) {
      assertEquals("Arguments cannot be null", e.getMessage());
    }

    // null readable
    try {
      MarbleSolitaireModel game1 = new EnglishSolitaireModel(3);
      MarbleSolitaireView game1View = new MarbleSolitaireTextView(game1, new StringBuilder());
      new MarbleSolitaireControllerImpl(new EnglishSolitaireModel(), game1View, null).playGame();
      fail("Should've thrown exception, arguments cannot be null");
    } catch (IllegalArgumentException e) {
      assertEquals("Arguments cannot be null", e.getMessage());
    }

    // null model
    try {
      MarbleSolitaireModel game1 = new EnglishSolitaireModel(3);
      MarbleSolitaireView game1View = new MarbleSolitaireTextView(game1, new StringBuilder());
      new MarbleSolitaireControllerImpl(null, game0View, new StringReader("3 2 3 3")).
              playGame();
      fail("Should've thrown exception, arguments cannot be null");
    } catch (IllegalArgumentException e) {
      assertEquals("Arguments cannot be null", e.getMessage());
    }

    try {
      MarbleSolitaireModel game1 = new EnglishSolitaireModel(3);
      MarbleSolitaireView game1View = new MarbleSolitaireTextView(game1,
              new FileWriter(""));
      MarbleSolitaireController controller1 = new MarbleSolitaireControllerImpl(game1
              , game1View, new StringReader("1 2 3 4"));
      controller1.playGame();
      fail("Should've thrown exception, arguments cannot be null");
    } catch (IOException e) {
      assertEquals("", e.getMessage());
    }
  }

  @Test
  public void testNoMoreInputs() {
    // no more inputs
    Readable in = null;
    StringBuilder expectedOut = new StringBuilder();

    expectedOut.append("Move Inputs: ");

    in = new StringReader("2 4 4 4");
    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView game0View = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, game0View, in);
    try {
      controller.playGame();
      fail("Not enough inputs, should've thrown exception");
    } catch (IllegalStateException e) {
      assertEquals("No more inputs", e.getMessage());
    }
  }

  @Test
  public void testPlayGame() {
    Readable in = null;
    StringBuilder expectedOut = new StringBuilder();
    try {
      in = new FileReader("moves.text");
    } catch (FileNotFoundException e) {
      fail("Input file not present");
    }

    expectedOut.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "\n" +
                    "    O O O\n" +
                    "    _ O O\n" +
                    "O O _ O O O O\n" +
                    "O _ O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 30\n" +
                    "\n" +
                    "    O O O\n" +
                    "    _ O O\n" +
                    "O O _ O O O O\n" +
                    "O O _ _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 29\n" +
                    "\n" +
                    "    O O O\n" +
                    "    _ O O\n" +
                    "O O _ O O O O\n" +
                    "_ _ O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 28\n" +
                    "\n" +
                    "    O O O\n" +
                    "    _ O O\n" +
                    "_ _ O O O O O\n" +
                    "_ _ O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 27\n" +
                    "\n" +
                    "    O O O\n" +
                    "    _ O O\n" +
                    "_ O _ _ O O O\n" +
                    "_ _ O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 26\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ _ O\n" +
                    "_ O _ O O O O\n" +
                    "_ _ O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 25\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ _ O\n" +
                    "_ O O _ _ O O\n" +
                    "_ _ O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 24\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ _ O\n" +
                    "_ O O _ _ O O\n" +
                    "_ _ O O O O O\n" +
                    "O O O _ O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 23\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ _ O\n" +
                    "_ _ _ O _ O O\n" +
                    "_ _ O O O O O\n" +
                    "O O O _ O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 22\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ _ O\n" +
                    "_ _ _ O _ O O\n" +
                    "_ O _ _ O O O\n" +
                    "O O O _ O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 21\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ _ O\n" +
                    "_ O _ O _ O O\n" +
                    "_ _ _ _ O O O\n" +
                    "O _ O _ O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 20\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ _ O\n" +
                    "_ O _ O _ O O\n" +
                    "_ _ O _ O O O\n" +
                    "O _ _ _ O O O\n" +
                    "    _ _ O\n" +
                    "    O O O\n" +
                    "Score: 19\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ _ O\n" +
                    "_ O _ O O O O\n" +
                    "_ _ O _ _ O O\n" +
                    "O _ _ _ _ O O\n" +
                    "    _ _ O\n" +
                    "    O O O\n" +
                    "Score: 18\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ _ _\n" +
                    "_ O _ O _ O O\n" +
                    "_ _ O _ O O O\n" +
                    "O _ _ _ _ O O\n" +
                    "    _ _ O\n" +
                    "    O O O\n" +
                    "Score: 17\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ _ _\n" +
                    "_ O _ O _ O O\n" +
                    "_ _ O O _ _ O\n" +
                    "O _ _ _ _ O O\n" +
                    "    _ _ O\n" +
                    "    O O O\n" +
                    "Score: 16\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ O _\n" +
                    "_ O _ _ _ O O\n" +
                    "_ _ O _ _ _ O\n" +
                    "O _ _ _ _ O O\n" +
                    "    _ _ O\n" +
                    "    O O O\n" +
                    "Score: 15\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ O _\n" +
                    "_ O _ _ O _ _\n" +
                    "_ _ O _ _ _ O\n" +
                    "O _ _ _ _ O O\n" +
                    "    _ _ O\n" +
                    "    O O O\n" +
                    "Score: 14\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ O _\n" +
                    "_ O _ _ O _ _\n" +
                    "_ _ O _ _ _ O\n" +
                    "O _ _ _ O O O\n" +
                    "    _ _ _\n" +
                    "    O O _\n" +
                    "Score: 13\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ O _\n" +
                    "_ O _ _ O _ _\n" +
                    "_ _ O _ _ _ O\n" +
                    "O _ _ O _ _ O\n" +
                    "    _ _ _\n" +
                    "    O O _\n" +
                    "Score: 12\n" +
                    "\n" +
                    "    O _ O\n" +
                    "    _ O _\n" +
                    "_ O _ _ O _ O\n" +
                    "_ _ O _ _ _ _\n" +
                    "O _ _ O _ _ _\n" +
                    "    _ _ _\n" +
                    "    O O _\n" +
                    "Score: 11\n" +
                    "\n" +
                    "Game over!\n" +
                    "    O _ O\n" +
                    "    _ O _\n" +
                    "_ O _ _ O _ O\n" +
                    "_ _ O _ _ _ _\n" +
                    "O _ _ O _ _ _\n" +
                    "    _ _ _\n" +
                    "    _ _ O\n" +
                    "Score: 10\n");
    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView game0View = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, game0View, in);
    controller.playGame();
    model.isGameOver();
    assertEquals(expectedOut.toString(), output.toString().replace("\r", ""));
  }

  @Test
  public void testReEnter() {
    Readable in = null;
    int validInputOne = 2;
    int validInputTwo = 4;
    String invalidInputThree = "t";
    int validInputFour = 4;
    String invalidInputFive = "k";
    int invalidInputSix = 4;
    String quit = "Q";

    String input = validInputOne + " " + validInputTwo + " " + invalidInputThree + " "
            + validInputFour + " " + invalidInputFive + " " + invalidInputSix + " " + quit;

    in = new StringReader(input);
    Appendable output = new StringBuilder();
    StringBuilder out = new StringBuilder();
    out.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Enter valid value:\n" +
                    "Enter valid value:\n" +
                    "\n" +
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31");
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals(out.toString(), output.toString().replace("\r", ""));

  }

  @Test
  public void testReEnter2() {
    Readable in = null;
    String validInputOne = "2";
    String validInputTwo = "4";
    String invalidInputThree = "-";
    String validInputFour = "4";
    String invalidInputFive = "/";
    int invalidInputSix = 4;
    String quit = "Q";

    String input = validInputOne + " " + validInputTwo + " " + invalidInputThree + " "
            + validInputFour + " " + invalidInputFive + " " + invalidInputSix + " " + quit;

    in = new StringReader(input);
    Appendable output = new StringBuilder();
    StringBuilder out = new StringBuilder();
    out.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Enter valid value:\n" +
                    "Enter valid value:\n" +
                    "\n" +
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31");
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals(out.toString(), output.toString().replace("\r", ""));
  }

  @Test
  public void testQuitFromRow() {
    Readable in = null;
    in = new StringReader("q 3 3 3");
    Appendable out = new StringBuilder(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32");

    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals(out.toString()
            , output.toString().replace("\r", ""));
  }

  @Test
  public void testQuitFromCol() {
    Readable in = null;
    in = new StringReader("1 q 3 3");
    Appendable out = new StringBuilder(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32");
    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals(out.toString(), output.toString().replace("\r", ""));

  }

  @Test
  public void testQuitToRow() {
    Readable in = null;
    in = new StringReader("1 3 q 3");
    Appendable out = new StringBuilder(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32");
    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals(out.toString(), output.toString().replace("\r", ""));

  }

  @Test
  public void testQuitToCol() {
    Readable in = null;
    in = new StringReader("1 3 3 q");
    Appendable out = new StringBuilder(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32");
    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals(out.toString(), output.toString().replace("\r", ""));
  }

  @Test
  public void testCapQuitFromRow() {
    Readable in = null;
    in = new StringReader("Q 3 3 3");
    Appendable out = new StringBuilder(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32");

    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals(out.toString()
            , output.toString().replace("\r", ""));
  }

  @Test
  public void testCapQuitFromCol() {
    Readable in = null;
    in = new StringReader("1 Q 3 3");
    Appendable out = new StringBuilder(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32");
    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals(out.toString(), output.toString().replace("\r", ""));

  }

  @Test
  public void testCapQuitToRow() {
    Readable in = null;
    in = new StringReader("1 3 Q 3");
    Appendable out = new StringBuilder(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32");
    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals(out.toString(), output.toString().replace("\r", ""));

  }

  @Test
  public void testCapQuitToCol() {
    Readable in = null;
    in = new StringReader("1 3 3 Q");
    Appendable out = new StringBuilder(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32");
    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals(out.toString(), output.toString().replace("\r", ""));
  }





  @Test
  public void testEuropeanControllerInputs() {
    Readable in = null;
    StringBuilder allInputs = new StringBuilder();
    StringBuilder expectedLogs = new StringBuilder();

    Random r = new Random(100);
    String input = "";
    for (int i = 0; i < 10; i++) {
      int fromRow = r.nextInt(7);
      int fromCol = r.nextInt(7);
      int toRow = r.nextInt(7);
      int toCol = r.nextInt(7);

      input = (fromRow + " " + fromCol + " " + toRow + " " + toCol);
      allInputs.append(input + "\n");

      fromRow--;
      fromCol--;
      toRow--;
      toCol--;
      expectedLogs.append("Move Inputs: " + fromRow + ", " + fromCol + ", "
              + toRow + ", " + toCol + "\n");
    }

    in = new StringReader(allInputs.toString());
    Appendable out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel game0 = new EuropeanSolitaireModel(3);
    MarbleSolitaireView game0View = new EuropeanSolitaireTextView(game0, out);
    MockModel model = new MockModel(log);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, game0View, in);
    controller.playGame();
    assertEquals(expectedLogs.toString(), log.toString());
  }

  /**
   * Represents an abstract mock. Contains duplicate methods across all mocks.
   */
  public abstract class AbstractMock implements MarbleSolitaireModel {
    private StringBuilder log;

    private int counter = 0;

    public AbstractMock(StringBuilder stringBuilder) {
      this.log = stringBuilder;
    }

    @Override
    public void move(int fromRow, int fromCol, int toRow, int toCol)
            throws IllegalArgumentException {
      this.log.append("Move Inputs: " + fromRow + ", " + fromCol + ", "
              + toRow + ", " + toCol + "\n");
    }

    @Override
    public boolean isGameOver() {
      counter++;
      return counter > 10;
    }

    @Override
    public int getBoardSize() {
      return 7;
    }

    @Override
    public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
      return null;
    }
  }

  /**
   * Represents a mock model of marble solitaire model.
   */
  class MockEuropeanModel extends AbstractMock {

    public MockEuropeanModel(StringBuilder stringBuilder) {
      super(stringBuilder);
    }

    @Override
    public int getScore() {
      return 36;
    }
  }

  /**
   * Represents a mock model of marble solitaire model.
   */
  class MockTriangleModel extends AbstractMock {

    public MockTriangleModel(StringBuilder stringBuilder) {
      super(stringBuilder);
    }

    @Override
    public int getScore() {
      return 14;
    }
  }

  @Test
  public void testTriangleControllerInputs() {
    Readable in = null;
    StringBuilder allInputs = new StringBuilder();
    StringBuilder expectedLogs = new StringBuilder();

    Random r = new Random(100);
    String input = "";
    for (int i = 0; i < 10; i++) {
      int fromRow = r.nextInt(7);
      int fromCol = r.nextInt(7);
      int toRow = r.nextInt(7);
      int toCol = r.nextInt(7);

      input = (fromRow + " " + fromCol + " " + toRow + " " + toCol);
      allInputs.append(input + "\n");

      fromRow--;
      fromCol--;
      toRow--;
      toCol--;
      expectedLogs.append("Move Inputs: " + fromRow + ", " + fromCol + ", "
              + toRow + ", " + toCol + "\n");
    }

    in = new StringReader(allInputs.toString());
    Appendable out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel game0 = new TriangleSolitaireModel(6);
    MarbleSolitaireView game0View = new TriangleSolitaireTextView(game0, out);
    MockTriangleModel model = new MockTriangleModel(log);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, game0View, in);
    controller.playGame();
    assertEquals(expectedLogs.toString(), log.toString());
  }

  @Test
  public void testEuropeanOutputs() {
    Readable in = null;
    StringBuilder expectedOut = new StringBuilder();

    expectedOut.append(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n" +
                    "\n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35");

    in = new StringReader("2 4 4 4 q");
    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel(3);
    MarbleSolitaireView game0View = new EuropeanSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, game0View, in);
    controller.playGame();
    assertEquals(expectedOut.toString(), output.toString().replace("\r", ""));
  }

  @Test
  public void testTriangleOutputs() {
    Readable in = null;
    StringBuilder expectedOut = new StringBuilder();

    expectedOut.append(
            "     _\n" +
                    "    O O\n" +
                    "   O O O\n" +
                    "  O O O O\n" +
                    " O O O O O\n" +
                    "O O O O O O\n" +
                    "Score: 20\n" +
                    "\n" +
                    "     O\n" +
                    "    _ O\n" +
                    "   _ O O\n" +
                    "  O O O O\n" +
                    " O O O O O\n" +
                    "O O O O O O\n" +
                    "Score: 19\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "     O\n" +
                    "    _ O\n" +
                    "   _ O O\n" +
                    "  O O O O\n" +
                    " O O O O O\n" +
                    "O O O O O O\n" +
                    "Score: 19");

    in = new StringReader("3 1 1 1 q");
    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel(6);
    MarbleSolitaireView game0View = new TriangleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, game0View, in);
    controller.playGame();
    assertEquals(expectedOut.toString(), output.toString().replace("\r", ""));
  }
}
