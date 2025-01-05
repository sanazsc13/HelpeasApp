package app.helpeas.Model;

import java.util.ArrayList;
import java.util.List;

public class Box implements IBox {

    private int number;
    private List<IFlashCard> mesCartes;

    public Box(int number) {
        this.number = number;
        this.mesCartes = new ArrayList<IFlashCard>();
    }
    @Override
    public int getNumber() {
        return number;
    }
    @Override
    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public List<IFlashCard> getMesCartes() {
        return mesCartes;
    }
    @Override
    public void setMesCartes(List<IFlashCard> mesCartes) {
        this.mesCartes = mesCartes;
    }
    @Override
    public void addMaCarte(IFlashCard maCarte) {
        if(!this.mesCartes.contains(maCarte)) {
            this.mesCartes.add(maCarte);
        }
        if(maCarte instanceof FlashCard) {
            ((IFlashCard) maCarte).setCurrentBox(this);
        }
    }
    @Override
    public void removeMaCarte(IFlashCard maCarte){
        if (this.mesCartes.contains(maCarte)) {
            this.mesCartes.remove(maCarte);
        }
        if (maCarte instanceof IFlashCard){
            ((IFlashCard) maCarte).setCurrentBox(null);
        }
    }
    @Override
    public void moveFlashcardTo(IFlashCard card, IBox targetBox) {
        if (mesCartes.contains(card)) {
            this.removeMaCarte(card);
            targetBox.addMaCarte(card);
            card.setCurrentBox(targetBox);
        }
    }
}
