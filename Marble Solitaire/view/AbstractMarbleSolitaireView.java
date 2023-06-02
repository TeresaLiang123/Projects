package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents an abstract marble solitaire view that contains all the duplicate
 * code across all views. This allows clients to view the solitaire game.
 */
public abstract class AbstractMarbleSolitaireView implements MarbleSolitaireView {

  protected MarbleSolitaireModelState model;
  protected final Appendable object;

  /**
   * Creates a marble solitaire text view.
   *
   * @param model is the type of model of marble solitaire.
   * @throws IllegalArgumentException if the model is a null.
   */
  public AbstractMarbleSolitaireView(MarbleSolitaireModelState model)
          throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Invalid model");
    }
    this.model = model;
    this.object = System.out;
  }

  /**
   * Creates a marble solitaire text view.
   *
   * @param model is the type of model of marble solitaire.
   * @param object is what this view uses as its destination.
   * @throws IllegalArgumentException if given model or object is a null.
   */
  public AbstractMarbleSolitaireView(MarbleSolitaireModelState model, Appendable object)
          throws IllegalArgumentException {
    if (model == null || object == null) {
      throw new IllegalArgumentException("Invalid model or object");
    }
    this.model = model;
    this.object = object;
  }

  /**
   * Converts the current board state to a string.
   *
   * @return the string version of the board.
   */
  @Override
  public String toString() {
    String strBoard = "";
    for (int row = 0; row < this.model.getBoardSize(); row++) {
      for (int col = 0; col < this.model.getBoardSize(); col++) {
        strBoard = this.slotToString(row, col, strBoard);
        if (this.isEndOfRow(row, col)) { // if current is marble and next is invalid or OOB
          if (row < this.model.getBoardSize() - 1) {
            strBoard = strBoard + "\n";
            break;
          }
          break;
        }
        if (!isEndOfRow(row, col)) {
          strBoard = strBoard + " ";
        }
      }
    }
    return strBoard;
  }

  /**
   * Determines if given position is at the end of a row. It is at the end of the row if
   * the given position is a marble or an empty slot and the right of the position is out of
   * bounds or invalid.
   *
   * @param row is the row on the board.
   * @param col is the column on the board.
   * @return true if given slot is a marble or empty and the next slot is out of bounds.
   *         Otherwise, false.
   */
  protected boolean isEndOfRow(int row, int col) {
    return (this.model.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Marble
            || this.model.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Empty)
            && this.isOutOfBounds(row, col + 1);
  }

  /**
   * Checks if given position of slot is out of bounds or an invalid.
   *
   * @param row is the row on the board.
   * @param col is the column on the board.
   * @return true if position is an invalid slot or out of the board size dimensions.
   */
  private boolean isOutOfBounds(int row, int col) {
    try {
      this.model.getSlotAt(row, col); // if there is a marble/empty/invalid next
      return this.model.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Invalid;
    } catch (IllegalArgumentException e) {
      return true;
    }
  }

  /**
   * Converts a SlotState into a string. If Empty "_", Marble "O", and Invalid " ".
   *
   * @param row is the row on the board.
   * @param col is the column on the board.
   * @param strRow the string version of a row of the board.
   * @return the string version of a slot state.
   */
  protected String slotToString(int row, int col, String strRow) {
    switch (this.model.getSlotAt(row, col)) {
      case Empty:
        strRow = strRow + "_";
        break;
      case Marble:
        strRow = strRow + "O";
        break;
      default: // invalid
        strRow = strRow + " ";
    }
    return strRow;
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above.
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    String board = this.toString();
    try {
      this.object.append(board);
    }
    catch (IOException e) {
      throw new IOException("Transmission of board to provided data destination is invalid");
    }
  }

  @Override
  public void renderMessage(String message) throws IOException {
    try {
      this.object.append(message);
    }
    catch (IOException e) {
      throw new IOException("Transmission of message to provided data destination is invalid");
    }
  }
}
