package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents a Triangular solitaire text view which allows clients
 * to see the solitaire game.
 */
public class TriangleSolitaireTextView extends AbstractMarbleSolitaireView {

  /**
   * Creates a Triangular marble solitaire text view.
   *
   * @param model is the type of model of marble solitaire.
   * @throws IllegalArgumentException if the model is a null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model) {
    super(model);
  }

  /**
   * Creates a Triangular marble solitaire text view.
   *
   * @param model is the type of model of marble solitaire.
   * @throws IllegalArgumentException if the model or object are a null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable object) {
    super(model, object);
  }

  @Override
  public String toString() {
    String strBoard = "";
    int numSpaces = model.getBoardSize() - 1;
    int rowLength = 1;
    int numMarbles;
    for (int row = 0; row < this.model.getBoardSize(); row++) {
      numMarbles = 0;
      int copyNumSpaces = numSpaces;
      // add spaces
      while (copyNumSpaces > 0) {
        strBoard = strBoard + " ";
        copyNumSpaces--;
      }
      numSpaces--;
      // add marbles
      for (int col = 0; numMarbles < rowLength; col++) {
        strBoard = this.slotToString(row, col, strBoard);
        numMarbles++;
        if (numMarbles == rowLength) {
          if (row < this.model.getBoardSize() - 1) {
            strBoard = strBoard + "\n";
            if (rowLength < this.model.getBoardSize()) {
              rowLength++;
            }
            break;
          }
        }
        if (!isEndOfRow(row, col)) {
          strBoard = strBoard + " ";
        }
      }
    }
    return strBoard;
  }
}
