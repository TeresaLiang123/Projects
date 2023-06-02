package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents an abstract marble solitaire contains duplicate methods across
 * all solitaire methods.
 */
public abstract class AbstractMarbleSolitaireModel implements MarbleSolitaireModel {

  protected static final int DEFAULT_ARM = 3;
  protected final int arm;
  public ArrayList<ArrayList<SlotState>> board;
  protected final int xEmpty;
  protected final int yEmpty;

  /**
   * Creates a default abstract marble solitaire model.
   *
   * @throws IllegalArgumentException if sRow or sCol are beyond the board's dimensions.
   */
  public AbstractMarbleSolitaireModel() {
    this.arm = DEFAULT_ARM;
    this.xEmpty = Math.round(this.getBoardSize() / 2);
    this.yEmpty = this.xEmpty;
  }

  /**
   * Creates a abstract marble solitaire model given desired empty slots.
   *
   * @param sRow is desired row of empty slot.
   * @param sCol is desired column of empty slot.
   * @throws IllegalArgumentException if sRow or sCol are beyond the board's dimensions.
   */
  public AbstractMarbleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this.arm = DEFAULT_ARM;
    this.xEmpty = sRow;
    this.yEmpty = sCol;
  }

  /**
   * Creates aan abstract  marble solitaire. In which the board is initialized to desired
   * arm thickness with its empty slot being calculated based off of the given arm thickness.
   *
   * @param armThickness is the amount of marbles on the top row of the board.
   * @throws IllegalArgumentException if armThickness is negative or an even number depending
   *                                  on the model being made.
   */
  public AbstractMarbleSolitaireModel(int armThickness) throws IllegalArgumentException {
    this.checkArm(armThickness);
    this.arm = armThickness;
    this.xEmpty = Math.round(this.getBoardSize() / 2);
    this.yEmpty = this.xEmpty;
  }

  /**
   * Creates an abstract marble solitaire model with given arm thickness and position of empty slot.
   * The invalid slots are determined or calculated by the given arm thickness.
   *
   * @param armThickness is the amount of marbles on the top row of the board.
   * @param sRow         is the row the empty slot position is desired to be in.
   * @param sCol         is the column the empty slot position is desired to be in.
   * @throws IllegalArgumentException if the arm thickness is negative or an odd number, desired
   *                                  positions (sRow and sCol) is an invalid slot or out of bounds.
   */
  public AbstractMarbleSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    this.checkArm(armThickness);
    this.arm = armThickness;
    this.xEmpty = sRow;
    this.yEmpty = sCol;
  }

  /**
   * Sets the empty slot to the board.
   */
  protected void setEmpty(int sRow, int sCol) {
    this.board.get(sRow).set(sCol, SlotState.Empty);
  }

  /**
   * Calculates the y-range of the invalid slots for the left side corners.
   *
   * @return the y-range of the left corner invalid slots.
   */
  protected int invalidYRangeLeftCorners() {
    int invalidSlots = this.getBoardSize() - this.arm;
    return invalidSlots / 2;
  }

  /**
   * Calculates the y-range of the invalid slots for the right side corners.
   *
   * @return the y-range of the right corner invalid slots.
   */
  protected int invalidYRangeRightCorners() {
    return this.getBoardSize() - this.invalidYRangeLeftCorners();
  }

  /**
   * Gives the x range for top corners.
   *
   * @return the x range for top corners.
   */
  protected int invalidXRangeTopCorners() {
    return this.invalidYRangeLeftCorners();
  }

  /**
   * Gives the x range for bottom corners.
   *
   * @return gives the x range for the bottom corners.
   */
  protected int invalidXRangeBottomCorners() {
    return this.invalidYRangeRightCorners();
  }

  /**
   * Checks if given position for empty slot is valid; row and column are not negative
   * and is not an Invalid SlotState.
   *
   * @param sRow the desired row for the empty slot.
   * @param sCol the desired column for the empty slot.
   */
  protected void checkEmpty(int sRow, int sCol) {
    if (sRow < 0 || sCol < 0 || this.board.get(sRow).get(sCol) == SlotState.Invalid) {
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
  protected void checkArm(int armThickness) throws IllegalArgumentException {
    if (armThickness < 0 || armThickness % 2 == 0) {
      throw new IllegalArgumentException("Invalid arm thickness");
    }
  }

  /**
   * Determines if given row number and column number are coordinates to an Invalid slot.
   *
   * @param row is the current row on the board.
   * @param col is the current column on the board.
   * @return true if given coordinates is located where an invalid slot would be on the board.
   *         Otherwise, false.
   */
  protected boolean isInvalidSlot(int row, int col) {
    if ((row >= 0 && row < this.invalidXRangeTopCorners())
            || (row >= this.invalidXRangeBottomCorners() && row < this.getBoardSize())) {
      if ((col >= 0 && col < this.invalidYRangeLeftCorners())
              || (col >= this.invalidYRangeRightCorners() && col < this.getBoardSize())) {
        return true;
      }
    }
    return false;
  }

  /**
   * Allows a player to move a piece only if it is valid:
   * if the from position is a marble, the slot next to it is empty depending on which direction
   * the direction it is moving to, the to position is an empty slot, the from and to positions
   * must be two slots away from each other from each direction (up, down, left, or right), and
   * the from or to slots are not out of bounds (out of the dimensions of the board).
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if either from or to is out of bounds, to slot is not empty,
   *                                  from slot is not a marble, both positions are not two
   *                                  slots away vertically or
   *                                  horizontally, and the next slot from the from slot
   *                                  is not a marble.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (!(this.outOfBounds(fromRow, fromCol)) // frm is not out of bounds
            && !(this.outOfBounds(toRow, toCol)) // to is not out of bounds
            && this.isSlotEmpty(toRow, toCol) // to is empty
            && this.isSlotMarble(fromRow, fromCol) // from is marble
            // to and from are two away
            && (this.isTwoAwayV(fromRow, fromCol, toRow, toCol)
            || this.isTwoAwayH(fromRow, fromCol, toRow, toCol))
            && this.isNextMarbleThenEmpty(fromRow, fromCol)) { // next slot is empty
      String direction = this.moveDirection(fromRow, fromCol, toRow, toCol);
      // change empty slot with marble
      ArrayList<SlotState> toRowList = this.board.get(toRow);
      toRowList.set(toCol, SlotState.Marble);
      // set from slot to empty
      ArrayList<SlotState> fromRowList = this.board.get(fromRow);
      fromRowList.set(fromCol, SlotState.Empty);
      this.makeEmpty(direction, fromRow, fromCol);
    } else {
      throw new IllegalArgumentException("Invalid move");
    }
  }

  /**
   * Makes the slot that is between the from and to slots (the one that is being hopped over)
   * into an Empty slot.
   *
   * @param direction is the direction the marble is moving towards.
   * @param fromRow   is the row representing the marble's, that is being moved, position it is in.
   * @param fromCol   is the column the marble is positioned in.
   */
  protected void makeEmpty(String direction, int fromRow, int fromCol) {
    switch (direction) {
      case "up":
        ArrayList<SlotState> nextRow = this.board.get(fromRow - 1);
        nextRow.set(fromCol, SlotState.Empty);
        break;
      case "down":
        ArrayList<SlotState> prevRow = this.board.get(fromRow + 1);
        prevRow.set(fromCol, SlotState.Empty);
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

  /**
   * Gives the direction the player wants to move.
   *
   * @param fromRow is the row the marble is moving from.
   * @param fromCol is the column the marble is moving from.
   * @param toRow   is the row the marble is moving to.
   * @param toCol   is the column the marble is moving to.
   * @return up, down, right, left for the direction of the desired move in a string.
   */
  protected String moveDirection(int fromRow, int fromCol, int toRow, int toCol) {
    if (this.isTwoAwayV(fromRow, fromCol, toRow, toCol) && fromRow > toRow) {
      return "up";
    } else if (this.isTwoAwayV(fromRow, fromCol, toRow, toCol) && fromRow < toRow) {
      return "down";
    } else if (this.isTwoAwayH(fromRow, fromCol, toRow, toCol) && fromCol < toCol) {
      return "right";
    } else { // (this.isTwoAwayH(fromRow, fromCol, toRow, toCol) && fromCol > toCol)
      return "left";
    }
  }

  /**
   * Determines if given coordinates/location's slot state is a Marble.
   *
   * @param row is the row on the board.
   * @param col is the column on the board.
   * @return true if the slot state is a Marble. Otherwise, false.
   */
  protected boolean isSlotMarble(int row, int col) {
    try {
      this.getSlotAt(row, col);
      return this.getSlotAt(row, col) == SlotState.Marble;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  /**
   * Determines if given coordinates/location's slot state is Empty.
   *
   * @param row is the row on the board.
   * @param col is the column on the board.
   * @return true if the slot state is Empty. Otherwise, false.
   */
  public boolean isSlotEmpty(int row, int col) {
    try {
      this.getSlotAt(row, col);
      return this.getSlotAt(row, col) == SlotState.Empty;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  /**
   * Determines if given from position is two away from to position vertically.
   *
   * @param fromRow is the row the marble is moving from.
   * @param fromCol is the column the marble is moving from.
   * @param toRow   is the row the marble is moving to.
   * @param toCol   is the column the marble is moving to.
   * @return true if the position the player wants to move to is in the same column
   *         as the desired marble they want to move and is two away from it either from
   *         below or above. Otherwise, false.
   */
  protected boolean isTwoAwayV(int fromRow, int fromCol, int toRow, int toCol) {
    return ((fromCol == toCol) && ((fromRow + 2 == toRow || fromRow - 2 == toRow)));
  }

  /**
   * Determines if given from position is two away from to position horizontally.
   *
   * @param fromRow is the row the marble is moving from.
   * @param fromCol is the column the marble is moving from.
   * @param toRow   is the row the marble is moving to.
   * @param toCol   is the column the marble is moving to.
   * @return true if the position the player wants to move to is in the same row
   *         as the desired marble they want to move and is two away from it either from
   *         the left or right. Otherwise, false.
   */
  protected boolean isTwoAwayH(int fromRow, int fromCol, int toRow, int toCol) {
    return ((fromRow == toRow) && ((fromCol + 2 == toCol) || (fromCol - 2 == toCol)));
  }

  /**
   * Checks if the game is over.
   *
   * @return true of there are no marbles next to each other and the slot next to that is empty
   *         (a valid jump or move).
   */
  @Override
  public boolean isGameOver() {
    for (int currentRow = 0; currentRow < this.getBoardSize(); currentRow++) {
      for (int col = 0; col < this.getBoardSize(); col++) {
        // if current slot is marble
        if (this.isSlotMarble(currentRow, col) && this.isNextMarbleThenEmpty(currentRow, col)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Checks if current slot state, marble, has any marbles next to it (right, left, top, or bottom)
   * and that the next two slots from any direction is empty.
   *
   * @param currentRow the row we are currently checking.
   * @param col        the column we are checking.
   * @return true if there is a marble next to current slot and if there is an empty slot that is
   *         two slots away from it. Otherwise, false.
   */
  protected boolean isNextMarbleThenEmpty(int currentRow, int col) {
    return (this.isNextMarbleThenEmptyHelper(currentRow, col)
            || (this.isSlotMarble(currentRow - 1, col)
            && this.isSlotEmpty(currentRow - 2, col))
            || (this.isSlotMarble(currentRow + 1, col)
            && this.isSlotEmpty(currentRow + 2, col)));
  }

  /**
   * Checks if the left or right slot is a marble and the slot after that is empty.
   *
   * @param currentRow is the current row of given position..
   * @param col is the given column of position.
   * @return true if left or right slot is a marble along with an empty slot after it. Otherwise,
   *         false.
   */
  protected boolean isNextMarbleThenEmptyHelper(int currentRow, int col) {
    return (this.isSlotMarble(currentRow, col - 1)
            && this.isSlotEmpty(currentRow, col - 2))
            || (this.isSlotMarble(currentRow, col + 1)
            && this.isSlotEmpty(currentRow, col + 2));
  }

  /**
   * Calculates and gives the board size.
   *
   * @return the board size.
   */
  @Override
  public int getBoardSize() {
    return this.arm + 2 * (this.arm - 1);
  }

  /**
   * Gets the slot at given position.
   *
   * @param row the row of the position sought, starting at 0.
   * @param col the column of the position sought, starting at 0.
   * @return the slot state of the given position.
   * @throws IllegalArgumentException if the position is out of bounds.
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (this.outOfBounds(row, col)) {
      throw new IllegalArgumentException("Invalid coordinate position");
    }
    return this.board.get(row).get(col);
  }

  /**
   * Determines if position is out of bounds.
   *
   * @param row is the row on the board.
   * @param col is the column on the board.
   * @return true if given position is not in dimensions of the board. Either it is not negative
   *         or it does not go beyond or is equal to the board size. Otherwise, false.
   */
  protected boolean outOfBounds(int row, int col) {
    return row < 0 || col < 0 || row >= this.getBoardSize() || col >= this.getBoardSize();
  }

  /**
   * Gets the current score depending on how many marbles are on the board.
   *
   * @return the number of marbles on the board.
   */
  @Override
  public int getScore() {
    int score = 0;
    for (int row = 0; row < this.getBoardSize(); row++) {
      for (int col = 0; col < this.getBoardSize(); col++) {
        if (this.board.get(row).get(col) == SlotState.Marble) {
          score++;
        }
      }
    }
    return score;
  }

  protected abstract ArrayList<ArrayList<SlotState>> createBoard();
}
