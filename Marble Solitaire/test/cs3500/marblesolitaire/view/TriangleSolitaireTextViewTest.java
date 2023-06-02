package cs3500.marblesolitaire.view;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Represents testing for TriangleSolitaire Text View.
 */
public class TriangleSolitaireTextViewTest {
  @Test
  public void testTriangleView() {
    MarbleSolitaireModel model1 = new TriangleSolitaireModel(7);
    MarbleSolitaireView model1View = new TriangleSolitaireTextView(model1);
    MarbleSolitaireModel model2 = new TriangleSolitaireModel(7, 2, 2);
    MarbleSolitaireView model2View = new TriangleSolitaireTextView(model2);
    MarbleSolitaireModel model3 = new TriangleSolitaireModel(3, 1);
    MarbleSolitaireView model3View = new TriangleSolitaireTextView(model3);
    MarbleSolitaireModel model4 = new TriangleSolitaireModel();
    MarbleSolitaireView model4View = new TriangleSolitaireTextView(model4);
    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", model1View.toString());
    assertEquals("      O\n" +
            "     O O\n" +
            "    O O _\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", model2View.toString());
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O _ O O\n" +
            "O O O O O", model3View.toString());
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", model4View.toString());
  }

  @Test
  public void testMoveToString() {
    MarbleSolitaireModel model4 = new TriangleSolitaireModel();
    model4.move(2, 0, 0, 0);
    MarbleSolitaireView model4View = new TriangleSolitaireTextView(model4);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", model4View.toString());
  }

  @Test
  public void testInvalidConstructor() {
    try {
      MarbleSolitaireView game4 = new EuropeanSolitaireTextView(null);
      fail("Constructor cannot be a null, should've thrown exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid model", e.getMessage());
    }
  }

  @Test
  public void testRenderBoardWhenMove() {
    StringBuilder expectedOut = new StringBuilder();
    expectedOut.append(
                     "    O\n" +
                    "   _ O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O");

    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    model.move(2, 0, 0, 0);
    MarbleSolitaireView game0View = new TriangleSolitaireTextView(model, output);
    assertEquals(expectedOut.toString(), game0View.toString());
  }

  @Test
  public void testRenderBoard() {
    MarbleSolitaireView game0 = new TriangleSolitaireTextView(new TriangleSolitaireModel());
    MarbleSolitaireView game1 = new TriangleSolitaireTextView(new TriangleSolitaireModel(
            4, 2));
    MarbleSolitaireView game2 = new TriangleSolitaireTextView(new TriangleSolitaireModel(
            5));
    try {
      game0.renderBoard();
      game0.renderMessage("\n");
      game0.renderMessage("Score: 14");
      game0.renderMessage("\n");
    } catch (IOException e) {
      assertEquals("Transmission of board to provided data destination is invalid",
              e.getMessage());
    }

    try {
      game1.renderBoard();
    } catch (IOException e) {
      assertEquals("Transmission of board to provided data destination is invalid",
              e.getMessage());
    }

    try {
      game2.renderBoard();
    } catch (IOException e) {
      assertEquals("Transmission of board to provided data destination is invalid",
              e.getMessage());
    }
  }

  @Test
  public void testRenderBoardIOException() {
    MarbleSolitaireView game4 = new MarbleSolitaireTextView(new TriangleSolitaireModel(
            7),
            new PrintStream(new ByteArrayOutputStream()));
    try {
      game4.renderBoard();
    }
    catch (IOException e) {
      assertEquals("Transmission of board to provided data destination is invalid"
              , e.getMessage());
    }
  }

  @Test
  public void testRenderMessage() {
    MarbleSolitaireView game0 = new TriangleSolitaireTextView(new TriangleSolitaireModel());
    try {
      game0.renderMessage("Score: 14");
    } catch (IOException e) {
      assertEquals("Transmission of message to provided data destination is invalid",
              e.getMessage());
    }
  }

  @Test
  public void testRenderMessageIOException() {
    MarbleSolitaireView game4 = new MarbleSolitaireTextView(new TriangleSolitaireModel(
            6),
            new PrintStream(new ByteArrayOutputStream()));

    // FileWriter
    try {
      MarbleSolitaireView game5 = new MarbleSolitaireTextView(new TriangleSolitaireModel(
              5, 4, 4), new FileWriter("text.txt"));
      game5.renderMessage("Game Over!");
    } catch (IOException e) {
      assertEquals("Transmission of message to provided data destination is invalid"
              , e.getMessage());
    }

    // PrintStream
    try {
      game4.renderMessage("Game Over!");
    } catch (IOException e) {
      assertEquals("Transmission of message to provided data destination is invalid"
              , e.getMessage());
    }
  }
}