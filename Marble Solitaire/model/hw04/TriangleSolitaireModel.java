package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

/**
 * Represents a Triangle Solitaire Model that is different from the English and European model.
 * The implementation of moves, game over, creating board, and so on are different, but the logic
 * is the same.
 */
public class TriangleSolitaireModel extends AbstractMarbleSolitaireModel {
  private static final int DEFAULT_ARM = 5;
  private final int arm;
  private final int xEmpty;
  private final int yEmpty;

  /**
   * Creates a default triangle solitaire model.
   */
  public TriangleSolitaireModel() {
    this.arm = DEFAULT_ARM;
    this.xEmpty = 0;
    this.yEmpty = 0;
    this.board = this.createBoard();
  }

  /**
   * Creates a triangle solitaire model with desired size.
   * @param armThickness is the desired size.
   */
  public TriangleSolitaireModel(int armThickness) {
    this.checkArm(armThickness);
    this.arm = armThickness;
    this.xEmpty = 0;
    this.yEmpty = 0;
    this.board = this.createBoard();
    this.setEmpty(this.xEmpty, this.yEmpty);
  }

  /**
   * Creates a triangle solitaire model with desired empty slot position.
   * @param sRow is the row of desired empty slot.
   * @param sCol is the column of desired empty slot.
   */
  public TriangleSolitaireModel(int sRow, int sCol) {
    this.arm = DEFAULT_ARM;
    this.xEmpty = sRow;
    this.yEmpty = sCol;
    this.board = this.createBoard();
    this.checkEmpty(sRow, sCol);
    this.setEmpty(sRow, sCol);
  }

  /**
   * Creates a triangle solitaire model with desired size and empty slot position.
   * @param armThickness is the desired size.
   * @param sRow is the row of desired empty slot.
   * @param sCol is the column of desired empty slot.
   */
  public TriangleSolitaireModel(int armThickness, int sRow, int sCol) {
    this.checkArm(armThickness);
    this.arm = armThickness;
    this.xEmpty = sRow;
    this.yEmpty = sCol;
    this.board = this.createBoard();
    this.checkEmpty(sRow, sCol);
  }

  /**
   * Checks if the desired empty slot is valid.
   * @param sRow the desired row for the empty slot.
   * @param sCol the desired column for the empty slot.
   */
  @Override
  protected void checkEmpty(int sRow, int sCol) {
    if (this.outOfBounds(sRow, sCol)) {
      throw new IllegalArgumentException(String.format("Invalid empty cell position ("
              + sRow + "," + sCol + ")"));
    }
  }

  /**
   * Checks if given arm thickness is valid; isn't negative or odd.
   *
   * @param armThickness the amount of marbles on the top row of the board.
   * @throws IllegalArgumentException if arm thickness is negative or odd.
   */
  @Override
  protected void checkArm(int armThickness) throws IllegalArgumentException {
    if (armThickness < 0) {
      throw new IllegalArgumentException("Invalid arm thickness");
    }
  }

  /**
   * Creates a triangle solitaire board.
   * @return a board.
   */
  @Override
  protected ArrayList<ArrayList<SlotState>> createBoard() {
    ArrayList<ArrayList<SlotState>> board = new ArrayList<>();
    int rowLength = 1;
    for (int currentRow = 0; currentRow < this.arm; currentRow++) {
      ArrayList<SlotState> row = new ArrayList<>();
      for (int currentCol = 0; currentCol < rowLength; currentCol++) {
        if (currentRow == this.xEmpty && currentCol == this.yEmpty) {
          row.add(SlotState.Empty);
        } else {
          row.add(SlotState.Marble);
        }
      }
      rowLength++;
      board.add(row);
    }
    return board;
  }

  /**
   * Determines which direction the marble is moving towards. The marble can be moving
   * up right, up left, down left, down right, right, or left.
   *
   * @param fromRow is the row the marble is moving from.
   * @param fromCol is the column the marble is moving from.
   * @param toRow is the row the marble is moving to.
   * @param toCol is the column the marble is moving to.
   *
   * @return The direction the marble is moving towards in a string.
   */
  protected String moveDirection(int fromRow, int fromCol, int toRow, int toCol) {
    if (this.isUpRight(fromRow, fromCol, toRow, toCol)) {
      return "up right";
    } else if (this.isUpLeft(fromRow, fromCol, toRow, toCol)) {
      return "up left";
    } else if (this.isDownRight(fromRow, fromCol, toRow, toCol) && fromRow < toRow) {
      return "down right";
    } else if (this.isDownLeft(fromRow, fromCol, toRow, toCol) && fromRow < toRow) {
      return "down left";
    } else if (this.isTwoAwayH(fromRow, fromCol, toRow, toCol) && fromCol < toCol) {
      return "right";
    } else { // (this.isTwoAwayH(fromRow, fromCol, toRow, toCol) && fromCol > toCol)
      return "left";
    }
  }

  /**
   * Checks if the direction the marble is moving to is up right.
   *
   * @param fromRow is the row the marble is moving from.
   * @param fromCol is the column the marble is moving from.
   * @param toRow is the row the marble is moving to.
   * @param toCol is the column the marble is moving to.
   *
   * @return true if the direction is up right. Otherwise, false.
   */
  private boolean isUpRight(int fromRow, int fromCol, int toRow, int toCol) {
    return fromRow - 2 == toRow && fromCol == toCol;
  }

  /**
   * Checks if the direction the marble is moving to is up left.
   *
   * @param fromRow is the row the marble is moving from.
   * @param fromCol is the column the marble is moving from.
   * @param toRow is the row the marble is moving to.
   * @param toCol is the column the marble is moving to.
   *
   * @return true if the direction is up left. Otherwise, false.
   */
  private boolean isUpLeft(int fromRow, int fromCol, int toRow, int toCol) {
    return fromRow - 2 == toRow && fromCol - 2 == toCol;
  }

  /**
   * Checks if the direction the marble is moving to is down right.
   *
   * @param fromRow is the row the marble is moving from.
   * @param fromCol is the column the marble is moving from.
   * @param toRow is the row the marble is moving to.
   * @param toCol is the column the marble is moving to.
   *
   * @return true if the direction is down right. Otherwise, false.
   */
  private boolean isDownRight(int fromRow, int fromCol, int toRow, int toCol) {
    return fromRow + 2 == toRow && fromCol + 2 == toCol;
  }

  /**
   * Checks if the direction the marble is moving to is down left.
   *
   * @param fromRow is the row the marble is moving from.
   * @param fromCol is the column the marble is moving from.
   * @param toRow is the row the marble is moving to.
   * @param toCol is the column the marble is moving to.
   *
   * @return true if the direction is down left. Otherwise, false.
   */
  private boolean isDownLeft(int fromRow, int fromCol, int toRow, int toCol) {
    return fromRow + 2 == toRow && fromCol == toCol;
  }

  /**
   * Makes the marble slot that is being jumped over an empty slot.
   * @param direction is the direction the marble is moving towards.
   * @param fromRow is the row representing the marble's, that is being moved, position it is in.
   * @param fromCol is the column the marble is positioned in.
   */
  @Override
  protected void makeEmpty(String direction, int fromRow, int fromCol) {
    switch (direction) {
      case "up right":
        ArrayList<SlotState> nextRowToRight = this.board.get(fromRow - 1);
        nextRowToRight.set(fromCol, SlotState.Empty);
        break;
      case "up left":
        ArrayList<SlotState> nextRowToLeft = this.board.get(fromRow - 1);
        nextRowToLeft.set(fromCol - 1, SlotState.Empty);
        break;
      case "down left":
        ArrayList<SlotState> prevRowLeft = this.board.get(fromRow + 1);
        prevRowLeft.set(fromCol, SlotState.Empty);
        break;
      case "down right":
        ArrayList<SlotState> prevRowRight = this.board.get(fromRow + 1);
        prevRowRight.set(fromCol + 1, SlotState.Empty);
        break;
      case "right":
        ArrayList<SlotState> currentRow1 = this.board.get(fromRow);
        currentRow1.set(fromCol + 1, SlotState.Empty);
        break;
      default: // left
        ArrayList<SlotState> currentRow2 = this.board.get(fromRow);
        currentRow2.set(fromCol - 1, SlotState.Empty);
    }
  }

  @Override
  public int getBoardSize() {
    return this.arm;
  }


  /**
   * Determines if the marble is moving diagonally; up left, down right, up right, and down left.
   *
   * @param fromRow is the row the marble is moving from.
   * @param fromCol is the column the marble is moving from.
   * @param toRow   is the row the marble is moving to.
   * @param toCol   is the column the marble is moving to.
   * @return true if it is moving diagonally. Otherwise, false.
   */
  @Override
  protected boolean isTwoAwayV(int fromRow, int fromCol, int toRow, int toCol) {
    return this.isUpLeft(fromRow, fromCol, toRow, toCol)
            || this.isDownRight(fromRow, fromCol, toRow, toCol)
            || this.isUpRight(fromRow, fromCol, toRow, toCol)
            || this.isDownLeft(fromRow, fromCol, toRow, toCol);
  }

  /**
   * Checks if the next slot is a marble and then an empty.
   * @param currentRow the row we are currently checking.
   * @param col        the column we are checking.
   * @return true if next slot is a marble and the following is empty.
   */
  @Override
  protected boolean isNextMarbleThenEmpty(int currentRow, int col) {
    return (this.isNextMarbleThenEmptyHelper(currentRow, col))
            || (this.isSlotMarble(currentRow - 1, col - 1) // down left
            && this.isSlotEmpty(currentRow - 2, col - 2))
            || (this.isSlotMarble(currentRow + 1, col + 1) // down right
            && this.isSlotEmpty(currentRow + 2, col + 2))
            || (this.isSlotMarble(currentRow + 1, col) // up right
            && this.isSlotEmpty(currentRow + 2, col))
            || (this.isSlotMarble(currentRow - 1, col) // up left
            && this.isSlotEmpty(currentRow - 2, col));
  }

  /**
   * Checks if the game is over.
   *
   * @return true of there are no marbles next to each other and the slot next to that is empty
   *         (a valid jump or move).
   */
  @Override
  public boolean isGameOver() {
    int rowLength = 1;
    int numMarbles;
    for (int currentRow = 0; currentRow < this.getBoardSize(); currentRow++) {
      numMarbles = 0;
      for (int col = 0; numMarbles < rowLength; col++) {
        // if current slot is marble
        if (this.isSlotMarble(currentRow, col) && this.isNextMarbleThenEmpty(currentRow, col)) {
          return false;
        }
        numMarbles++;
      }
      rowLength++;
    }
    return true;
  }

  /**
   * Determines if given position is out of bounds.
   * @param row is the row on the board.
   * @param col is the column on the board.
   * @return true if out of bounds. Otherwise, false.
   */
  @Override
  protected boolean outOfBounds(int row, int col) {
    return row < 0 || col < 0 || row >= this.getBoardSize() || col >= row + 1;
  }

  @Override
  public int getScore() {
    int score = 0;
    int rowLength = 1;
    int numMarbles;
    for (int row = 0; row < this.getBoardSize(); row++) {
      numMarbles = 0;
      for (int col = 0; numMarbles < rowLength; col++) {
        if (this.board.get(row).get(col) == SlotState.Marble) {
          score++;
        }
        numMarbles++;
      }
      rowLength++;
    }
    return score;
  }
}