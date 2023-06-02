package cs3500.marblesolitaire.view;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * represents marble solitaire text view tests.
 */
public class MarbleSolitaireTextViewTest {
  MarbleSolitaireView game0 = new MarbleSolitaireTextView(new EnglishSolitaireModel());
  MarbleSolitaireView game1 = new MarbleSolitaireTextView(new EnglishSolitaireModel(
          1, 4));
  MarbleSolitaireView game2 = new MarbleSolitaireTextView(new EnglishSolitaireModel(
          5));
  MarbleSolitaireView game3 = new MarbleSolitaireTextView(new EnglishSolitaireModel(
          5, 4,3));

  @Test
  public void testToString() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", game0.toString());
    assertEquals("    O O O\n" +
            "    O O _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", game1.toString());
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", game2.toString());
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", game3.toString());
  }

  @Test
  public void testInvalidConstructor() {
    try {
      MarbleSolitaireView game4 = new MarbleSolitaireTextView(null);
      fail("Constructor cannot be a null, should've thrown exception");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid model", e.getMessage());
    }
  }

  @Test
  public void testRenderBoardWhenMove() {
    StringBuilder expectedOut = new StringBuilder();
    expectedOut.append(
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O");

    Appendable output = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    model.move(1, 3, 3, 3);
    MarbleSolitaireView game0View = new MarbleSolitaireTextView(model, output);
    assertEquals(expectedOut.toString(), game0View.toString());
  }

  @Test
  public void testRenderBoard() {
    try {
      game0.renderBoard();
      game0.renderMessage("\n");
      game0.renderMessage("Score: 32");
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
    MarbleSolitaireView game4 = new MarbleSolitaireTextView(new EnglishSolitaireModel(3),
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
    try {
      game0.renderMessage("Score: 32");
    } catch (IOException e) {
      assertEquals("Transmission of message to provided data destination is invalid",
              e.getMessage());
    }
  }

  @Test
  public void testRenderMessageIOException() {
    MarbleSolitaireView game4 = new MarbleSolitaireTextView(new EnglishSolitaireModel(3),
            new PrintStream(new ByteArrayOutputStream()));

    // FileWriter
    try {
      MarbleSolitaireView game5 = new MarbleSolitaireTextView(new EnglishSolitaireModel(
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