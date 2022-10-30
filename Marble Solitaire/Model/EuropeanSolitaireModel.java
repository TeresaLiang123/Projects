package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;

/**
 * Represents a European Solitaire Model which has an English Solitaire board
 * within its board. Everything is mostly the same compare to the English Solitaire model,
 * but the board.
 */
public class EuropeanSolitaireModel extends AbstractMarbleSolitaireModel {

  EnglishSolitaireModel englishBaseBoard;

  /**
   * Creates a default European solitaire model.
   */
  public EuropeanSolitaireModel() {
    super();
    this.englishBaseBoard = new EnglishSolitaireModel();
    this.board = this.createBoard();
    this.setEmpty(3, 3);
  }

  /**
   * Creates a European solitaire model given desired empty slot.
   * @param sRow is row of desired empty slot.
   * @param sCol is column of desired empty slot.
   * @throws IllegalArgumentException if given empty slot coordinates are invalid; negative,
   *                                  invalid, or out of bounds.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);
    this.englishBaseBoard = new EnglishSolitaireModel();
    this.board = this.createBoard();
    this.checkEmpty(sRow, sCol);
    this.setEmpty(sRow, sCol);
  }

  /**
   * Creates a European solitaire model with given desired size.
   * @param armThickness is the desired size.
   * @throws IllegalArgumentException if desired size is negative.
   */
  public EuropeanSolitaireModel(int armThickness) throws IllegalArgumentException {
    super(armThickness);
    this.englishBaseBoard = new EnglishSolitaireModel(armThickness);
    this.board = this.createBoard();
    this.setEmpty(this.xEmpty, this.yEmpty);
  }

  /**
   * Creates a European solitaire model with desired size and empty slot.
   * @param armThickness is the desired size.
   * @param sRow is row of desired empty slot.
   * @param sCol is column of desired empty slot.
   * @throws IllegalArgumentException if arm thickness or desired empty slot are invalid.
   */
  public EuropeanSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
    this.englishBaseBoard = new EnglishSolitaireModel(armThickness);
    this.board = this.createBoard();
    this.checkEmpty(sRow, sCol);
    this.setEmpty(sRow, sCol);
  }

  /**
   * Creates a European solitaire board.
   * @return the board in a form of a list of slot state lists.
   */
  @Override
  protected ArrayList<ArrayList<SlotState>> createBoard() {
    ArrayList<ArrayList<SlotState>> copy = this.englishBaseBoard.board;
    int lColIndex = this.invalidYRangeLeftCorners();
    int rightColIndex = this.invalidYRangeRightCorners() - 1;
    int distance = 0;
    int distance2 = 0;
    for (int currentTopRow = 1; currentTopRow < this.invalidXRangeTopCorners(); currentTopRow++) {
      lColIndex--;
      rightColIndex++;
      int copyRightColIndex = rightColIndex;
      if (lColIndex >= 0 && rightColIndex < this.getBoardSize()) {
        this.createBoardHelper(copy, distance, distance2, lColIndex, copyRightColIndex
                , rightColIndex, currentTopRow);
      }
    }
    //bottom corners
    lColIndex = 0;
    rightColIndex = this.getBoardSize() - 1;
    for (int currentBotRow = this.invalidXRangeBottomCorners()
         ; currentBotRow < this.getBoardSize() - 1; currentBotRow++) {
      lColIndex++;
      rightColIndex--;
      int rColIndex = rightColIndex;
      if (lColIndex < this.invalidYRangeLeftCorners()
              && rightColIndex >= this.invalidYRangeRightCorners()) {
        this.createBoardHelper(copy, distance, distance2, lColIndex, rColIndex, rightColIndex
                , currentBotRow);
      }
    }
    // convert empty slot made from english solitaire model to marble
    for (int currentRow = 0; currentRow < this.getBoardSize(); currentRow++) {
      for (int currentCol = 0; currentCol < this.getBoardSize(); currentCol++) {
        if (copy.get(currentRow).get(currentCol) == SlotState.Empty) {
          copy.get(currentRow).set(currentRow, SlotState.Marble);
        }
      }
    }
    return copy;
  }

  /**
   * Changes the invalid slots to marble slots.
   * @param copy is the board.
   * @param distance is the distance from the y range left corner to the current slot position.
   * @param distance2 is the distance from the y range right corner to the current slot position.
   * @param lColIndex is the left column index.
   * @param rColIndex is the right column index.
   * @param rightColIndex is a copy of the rColIndex.
   * @param currentRow is the current row.
   */
  private void createBoardHelper(ArrayList<ArrayList<SlotState>> copy, int distance, int distance2,
                             int lColIndex, int rColIndex, int rightColIndex, int currentRow ) {
    distance = this.invalidYRangeLeftCorners() - lColIndex;
    distance2 = Math.abs(this.invalidYRangeRightCorners() - 1 - rightColIndex);
    while (distance != 0 && distance2 != 0) {
      copy.get(currentRow).set(lColIndex, SlotState.Marble);
      copy.get(currentRow).set(rColIndex, SlotState.Marble);
      distance--;
      distance2--;
      lColIndex++;
      rColIndex--;
    }
  }
}