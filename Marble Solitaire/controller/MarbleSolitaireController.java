package cs3500.marblesolitaire.controller;

/**
 * Represents a marble solitaire controller which takes in client's input and
 * sends it to the marble solitaire model and allows the
 * client to view the state of the game.
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new game.
   *
   * @throws IllegalStateException if controller is unable to read input or transmit output.
   */
  void playGame() throws IllegalStateException;
}
