package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static java.lang.Integer.parseInt;

/**
 * Represents a marble solitaire controller.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private boolean quit = false;
  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView view;
  private final Readable in;

  /**
   * Creates a Marble Solitaire controller.
   *
   * @param model is the type of marble solitaire model.
   * @param view  is the output to the user that is transmitted to a view.
   * @param in    is the input from the user.
   * @throws IllegalArgumentException if any of the parameters are null.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable in) throws IllegalArgumentException {
    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    this.model = model;
    this.view = view;
    this.in = in;
  }

  /**
   * Plays a new game where it renders the board, messages, sends data to model, and
   * interact with player.
   * @throws IllegalStateException if there are no more inputs, the destination for the
   *                               data is not appendable, and cannot the inputs are not readable.
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner scan = new Scanner(this.in);
    while (!this.model.isGameOver()) {
      int[] params = new int[4];
      try {
        this.view.renderBoard();
        this.view.renderMessage("\n");
        this.scoreMessage();
      }
      catch (IOException e) {
        throw new IllegalStateException(e);
      }
      for (int i = 0; i < 4; i++) {
        if (!scan.hasNext()) {
          throw new IllegalStateException("No more inputs");
        }
        //System.out.println("Enter an input: ");
        this.gatherInputs(i, scan, params);
        if (this.quit) {
          break;
        }
      }
      if (this.quit) {
        break;
      }
      this.updateMoveAndScore(params);
    }

    if (this.model.isGameOver()) {
      try {
        this.view.renderMessage("Game over!" + System.lineSeparator());
        this.view.renderBoard();
        this.view.renderMessage("\n");
        this.scoreMessage();
      }
      catch (IOException e) {
        throw new IllegalStateException(e);
      }
    }
  }

  /**
   * Updates the board and score of the game after a successful move.
   * @param params is the list of four inputs made by the client.
   *
   * @throws IllegalStateException if transmission of the message to the
   *                               provided data destination fails
   */
  private void updateMoveAndScore(int[] params) throws IllegalStateException {
    try {
      this.model.move(params[0], params[1], params[2], params[3]);
      try {
        this.view.renderMessage("\n");
      }
      catch (IOException e) {
        throw new IllegalStateException(e);
      }
    }
    catch (IllegalArgumentException e) {
      if (this.quit) {
        try {
          this.view.renderMessage("\n");
        } catch (IOException ex) {
          throw new IllegalStateException(ex);
        }
      }
      else {
        try {
          this.view.renderMessage("Invalid move. Play again. " + e.getMessage()
                  + System.lineSeparator());
        } catch (IOException ex) {
          throw new IllegalStateException(ex);
        }
      }
    }
  }

  /**
   * Gathers valid inputs from the client. Valid inputs are anything but negative numbers and
   * the letter q (uppercase or lowercase). If inputted an invalid, it will ask the client
   * to re-enter a valid input.
   *
   * @param index is the index of params. (list of inputs).
   * @param scan is the scanner that allows the client to interact with the program.
   * @param params is the list of inputs from the client.
   * @throws IllegalStateException if transmission of the board or message to the provided
   *                               data destination fails.
   */
  private void gatherInputs(int index, Scanner scan, int[] params) throws IllegalStateException {
    String input = scan.next();
    try {
      int intInput = parseInt(input);
      if (intInput < 0) {
        this.reEnter();
        this.gatherInputs(index, scan, params);
      } else {
        params[index] = intInput - 1;
      }
    } catch (NumberFormatException e) {
      if (input.equalsIgnoreCase("q")) {

        try {
          this.view.renderMessage("Game quit!" + System.lineSeparator());
          this.view.renderMessage("State of game when quit:" + System.lineSeparator());
          this.view.renderBoard();
          this.view.renderMessage("\n");
          this.view.renderMessage("Score: " + this.model.getScore());
          this.quit = true;
        } catch (IOException e2) {
          throw new IllegalStateException(e2);
        }
      } else {
        this.reEnter();
        this.gatherInputs(index, scan, params);
      }
    }
  }

  /**
   * Transmits a message instructing the client to re-enter a valid value.
   *
   * @throws IllegalStateException if transmission of the message to the provided
   *                               data destination fails
   */
  private void reEnter() throws IllegalStateException {
    try {
      this.view.renderMessage("Enter valid value:" + System.lineSeparator());
    } catch (IOException ex) {
      throw new IllegalStateException(ex);
    }
  }

  /**
   * Transmits the current score.
   *
   * @throws IllegalStateException if transmission of the message to the provided data
   *                               destination fails.
   */
  private void scoreMessage() throws IllegalStateException {
    try {
      this.view.renderMessage("Score: " + this.model.getScore() + System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
