package app.helpeas.Model;

import java.util.List;

public interface IBox {

    public Box Box1 =  new Box(1);
    int getNumber();
    void setNumber(int number);

    List<IFlashCard> getMesCartes();

    void setMesCartes(List<IFlashCard> mesCartes);

    void addMaCarte(IFlashCard maCarte);

    void removeMaCarte(IFlashCard maCarte);

    void moveFlashcardTo(IFlashCard card, IBox targetBox);
}
