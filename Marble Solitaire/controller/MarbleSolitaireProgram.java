package cs3500.marblesolitaire.controller;

import java.io.InputStreamReader;
import java.io.Reader;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Represents a Marble solitaire programmer. It runs the game by itself so the client
 * can play the game. The interaction is done in the console.
 */
public class MarbleSolitaireProgram {
  /**
   * Runs the program.
   * @param args are the arguments it takes in.
   */
  public static void main(String []args) {
    MarbleSolitaireModel game0 = new TriangleSolitaireModel();
    MarbleSolitaireView game0View = new TriangleSolitaireTextView(game0);
    Reader in = new InputStreamReader(System.in);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game0, game0View, in);
    controller.playGame();
  }
}
