package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * To represent the marble solitaire text view allowing the client to view
 * the solitaire game.
 */
public class MarbleSolitaireTextView extends AbstractMarbleSolitaireView {

  /**
   * Creates a marble solitaire text view.
   *
   * @param model is the type of model of marble solitaire.
   * @throws IllegalArgumentException if the model is a null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model) throws IllegalArgumentException {
    super(model);
  }

  /**
   * Creates a marble solitaire text view.
   *
   * @param model is the type of model of marble solitaire.
   * @param object is what this view uses as its destination.
   * @throws IllegalArgumentException if given model or object is a null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable object) {
    super(model, object);
  }
}
