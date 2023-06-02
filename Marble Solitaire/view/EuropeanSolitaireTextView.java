package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents a European text view. Allows clients to view
 * the European Solitaire game to desired destination.
 */
public class EuropeanSolitaireTextView extends AbstractMarbleSolitaireView {

  /**
   * Creates a European marble solitaire text view.
   *
   * @param model is the type of model of marble solitaire.
   * @throws IllegalArgumentException if the model is a null.
   */
  public EuropeanSolitaireTextView(MarbleSolitaireModelState model)
          throws IllegalArgumentException {
    super(model);
  }

  /**
   * Creates a European marble solitaire text view.
   *
   * @param model is the type of model of marble solitaire.
   * @throws IllegalArgumentException if the model and object is a null.
   */
  public EuropeanSolitaireTextView(MarbleSolitaireModelState model, Appendable object)
          throws IllegalArgumentException {
    super(model, object);
  }
}
