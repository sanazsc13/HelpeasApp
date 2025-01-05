package app.helpeas.Model;

import java.time.LocalDate;

public class FlashCard implements IFlashCard {

    private String subject;
    private String chapter;
    private String Question;
    private String Answer;
    private IBox currentBox;
    private LocalDate creationDate;

    public FlashCard(String chapter, String question, String subject, String Answer) {
        this.subject = subject;
        this.chapter = chapter;
        this.Question = question;
        this.currentBox = IBox.Box1;
        this.Answer = Answer;
        this.creationDate = LocalDate.now();
        //if (!this.subject.getNameSections().contains(chapter)) {
        //  this.subject.addSection(chapter);
        //}
    }

    @Override
    public String getAnswer() {
        return this.Answer;
    }

    @Override
    public String getSubjectfromFlashCard() {
        return this.subject;
    }

    @Override
    public void setSubjectfromFlashCard(String subject) {
        this.subject = subject;
    }

    @Override
    public String getChapterfromFlashCard() {
        return this.chapter;
    }

    @Override
    public void setChapter(String chapter) {
        this.chapter = chapter;


    }

    @Override
    public String getQuestion() {
        return Question;
    }

    @Override
    public void setQuestion(String question) {
        Question = question;
    }

    @Override
    public boolean checkAnswer(boolean outputrep) {
        return outputrep;
    }

    @Override
    public IBox getCurrentBox() {
        return currentBox;
    }

    @Override
    public void setCurrentBox(IBox currentBox) {
        this.currentBox = currentBox;
    }

    @Override
    public String toString() {
        return "Subject" + this.getSubjectfromFlashCard() + "Chapter" + this.getChapterfromFlashCard() + "Q: " + this.Question;
    }

    @Override
    public LocalDate getCreationDate() {
        return this.creationDate;
    }
}
