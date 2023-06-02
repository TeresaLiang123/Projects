package cs3500.marblesolitaire.view;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Represents testing for European Solitaire text view.
 */
public class EuropeanSolitaireTextViewTest {
  @Test
  public void testEuropeanToString() {
    MarbleSolitaireView game = new MarbleSolitaireTextView(new EuropeanSolitaireModel());
    MarbleSolitaireView game1 = new MarbleSolitaireTextView(new EuropeanSolitaireModel(
                                  5));
    MarbleSolitaireView game2 = new MarbleSolitaireTextView(
            new EuropeanSolitaireModel(5, 4, 3));
    MarbleSolitaireView game3 = new MarbleSolitaireTextView(new EuropeanSolitaireModel(
                                  1, 4));

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", game.toString());
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", game1.toString());
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", game2.toString());
    assertEquals("    O O O\n" +
            "  O O O _ O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", game3.toString());
  }

  @Test
  public void testToStringMove() {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    model.move(1, 3, 3, 3);
    MarbleSolitaireView game = new EuropeanSolitaireTextView(model);
    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", game.toString());

  }

  @Test
  public void testRenderBoard() {
    MarbleSolitaireView game0 = new MarbleSolitaireTextView(new EuropeanSolitaireModel());
    MarbleSolitaireView game1 = new MarbleSolitaireTextView(
            new EuropeanSolitaireModel(1, 4));
    MarbleSolitaireView game2 = new MarbleSolitaireTextView(
            new EuropeanSolitaireModel(5));
    try {
      game0.renderBoard();
      game0.renderMessage("\n");
      game0.renderMessage("Score: 36");
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
    MarbleSolitaireView game4 = new MarbleSolitaireTextView(new EuropeanSolitaireModel(
            3),
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
    MarbleSolitaireView game0 = new MarbleSolitaireTextView(new EuropeanSolitaireModel());
    try {
      game0.renderMessage("Score: 36");
    } catch (IOException e) {
      assertEquals("Transmission of message to provided data destination is invalid",
              e.getMessage());
    }
  }

  @Test
  public void testRenderMessageIOException() {
    MarbleSolitaireView game4 = new MarbleSolitaireTextView(new EuropeanSolitaireModel(
            3),
            new PrintStream(new ByteArrayOutputStream()));

    // FileWriter
    try {
      MarbleSolitaireView game5 = new MarbleSolitaireTextView(new EuropeanSolitaireModel(
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