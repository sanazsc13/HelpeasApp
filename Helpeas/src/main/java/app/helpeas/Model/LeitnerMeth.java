package app.helpeas.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeitnerMeth {
    private Map<Integer, IBox> myBoxes;
    private List<String> mySubjects;
    private List<IFlashCard> myFlashCards;

    public LeitnerMeth() {
        int numBoxes = 5;
        myBoxes = new HashMap<>();
        for (int i = 1; i <= numBoxes; i++) {
            myBoxes.put(i, new Box(i));
        }
        mySubjects = new ArrayList<String>();
        myFlashCards = new ArrayList<>();
    }
    public Map<Integer, IBox> getMyBoxes() {
        return myBoxes;
    }
    public IBox getBox(int id) {
        return myBoxes.get(id);
    }
    public List<String> getMySubjects() {
        return mySubjects;
    }

    public void addFlashCard(IFlashCard flashCard) {

        myBoxes.get(1).addMaCarte(flashCard);
        if (!mySubjects.contains(flashCard.getSubjectfromFlashCard())){
            mySubjects.add(flashCard.getSubjectfromFlashCard());}
        myFlashCards.add(flashCard);
    }
    public void removeFlashCard(IFlashCard flashCard){
            flashCard.getCurrentBox().removeMaCarte(flashCard);
            myFlashCards.remove(flashCard);

    }
    public void MovingFlashCard(IFlashCard flashCard, boolean answer) {
        int currentLevel = flashCard.getCurrentBox().getNumber();
        if (answer) {
            if (currentLevel < myBoxes.size()) {
                myBoxes.get(currentLevel).moveFlashcardTo(flashCard, myBoxes.get(currentLevel + 1));
            }
            else{
                myBoxes.get(currentLevel).moveFlashcardTo(flashCard, myBoxes.get(currentLevel));
            }
        }
        else {
            myBoxes.get(currentLevel).moveFlashcardTo(flashCard, myBoxes.get(1));
        }
    }
    public List<IFlashCard> getFlashCardsfrombox(int level) {
        return myBoxes.get(level).getMesCartes();
    }
    public List<IFlashCard> getFlashCards(){
        List<IFlashCard> flashCards = new ArrayList<>();
        for (IBox box : myBoxes.values()) {
            flashCards.addAll(box.getMesCartes());
        }
        return flashCards;
    }
    public void setFlashCards(List<IFlashCard> flashCards) {
        this.myFlashCards = flashCards;
    }
}
