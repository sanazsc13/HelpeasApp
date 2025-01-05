package app.helpeas.Model;

import javafx.scene.image.Image;

import java.time.LocalDate;

public interface IFlashCard {

    String getAnswer();

    String getSubjectfromFlashCard();
    void setSubjectfromFlashCard(String subject);
    String getChapterfromFlashCard();

    void setChapter(String chapter);

    String getQuestion();

    void setQuestion(String question);

    boolean checkAnswer(boolean rep);

    IBox getCurrentBox();

    void setCurrentBox(IBox currentBox);

    LocalDate getCreationDate();

}
