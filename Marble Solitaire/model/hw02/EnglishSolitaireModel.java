package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw04.AbstractMarbleSolitaireModel;

/**
 * This interface represents the English Solitaire.
 */
public class EnglishSolitaireModel extends AbstractMarbleSolitaireModel {

  /**
   * Initializes the board to an arm thickness of 3.
   * Creates the original English Solitaire model. It initializes the board to
   * an arm thickness of 3. The invalid slots positions are calculated based on the arm thickness.
   */
  public EnglishSolitaireModel() {
    super();
    this.board = createBoard();
  }

  /**
   * Creates an English solitaire model in which the board is initialized to have an
   * arm thickness of 3 with a selected empty slot position. The board's invalid slots are
   * calculated based off of the arm thickness.
   *
   * @param sRow is the row the empty slot position is desired to be in.
   * @param sCol is the column the empty slot position is desired to be in.
   * @throws IllegalArgumentException if sRow or sCol are beyond the board's dimensions.
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);
    this.board = this.createBoard();
    this.checkEmpty(sRow, sCol);
  }

  /**
   * Creates a EnglishSolitaireModel. In which the board is initialized to desired
   * arm thickness with its empty slot being calculated based off of the given arm thickness.
   *
   * @param armThickness is the amount of marbles on the top row of the board.
   * @throws IllegalArgumentException if armThickness is negative or an even number.
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    super(armThickness);
    this.board = this.createBoard();
  }

  /**
   * Creates an english solitaire model with given arm thickness and position of empty slot.
   * The invalid slots are determined or calculated by the given arm thickness.
   *
   * @param armThickness is the amount of marbles on the top row of the board.
   * @param sRow is the row the empty slot position is desired to be in.
   * @param sCol is the column the empty slot position is desired to be in.
   * @throws IllegalArgumentException if the arm thickness is negative or an odd number, desired
   *                                  positions (sRow and sCol) is an invalid slot or out of bounds.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
    this.board = this.createBoard();
    this.checkEmpty(sRow, sCol);
  }

  /**
   * Creates the English Solitaire board.
   *
   * @return an array list that represents the board. This array list is a list
   *         of SlotState that represent the rows of the board.
   */
  protected ArrayList<ArrayList<SlotState>> createBoard() {
    ArrayList<ArrayList<SlotState>> board = new ArrayList<>();
    for (int currentRow = 0; currentRow < this.getBoardSize(); currentRow++) {
      ArrayList<SlotState> row = new ArrayList<>();
      for (int currentCol = 0; currentCol < this.getBoardSize(); currentCol++) {
        if (this.isInvalidSlot(currentRow, currentCol)) {
          row.add(SlotState.Invalid);
        } else if (currentRow == this.xEmpty && currentCol == this.yEmpty) {
          row.add(SlotState.Empty);
        } else {
          row.add(SlotState.Marble);
        }
      }
      board.add(row);
    }
    return board;
  }
}