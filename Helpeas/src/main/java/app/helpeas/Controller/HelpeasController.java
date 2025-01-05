package app.helpeas.Controller;

import app.helpeas.Model.DataGestion;
import app.helpeas.Model.FlashCard;
import app.helpeas.Model.IFlashCard;
import app.helpeas.Model.LeitnerMeth;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class HelpeasController {
    private DataGestion dataGestion;
    private LeitnerMeth leitnerMeth = new LeitnerMeth();
    private int CurrentBoxId = 1;
    IFlashCard card1 = new FlashCard("Addition", "2+2", "Maths", "4");
    IFlashCard card2 = new FlashCard("Substraction", "2-2", "Maths", "0");
    IFlashCard card3 = new FlashCard("add", "2+8", "maths","10");
    public HelpeasController(){
        leitnerMeth.addFlashCard(card1);
        leitnerMeth.addFlashCard(card2);
        leitnerMeth.MovingFlashCard(card1, true);
        leitnerMeth.addFlashCard(card3);
        //leitnerMeth.MovingFlashCard(card2, true);
    }
    @FXML
    public void initialize() {
        dataGestion = new DataGestion(leitnerMeth.getFlashCards());
        // Si nécessaire, mettre à jour d'autres parties de l'interface
        System.out.println("Contrôleur initialisé avec des cartes !");

    }
    @FXML
    private VBox ContentVbox;
    @FXML
    private Text ContentTextVbox;

    public void showBoxContent(int id){
        if (leitnerMeth.getBox(id) == null) {
            System.out.println("No Box with the id : " + id);
            ContentVbox.getChildren().clear();
            ContentTextVbox.setText("Inexistent Box or Empty Box");
            return;
        }
        List<IFlashCard> cartes = leitnerMeth.getBox(id).getMesCartes();
        ContentVbox.getChildren().clear();
        for (IFlashCard flash: cartes){
            VBox card = createCardView(flash);
            ContentVbox.getChildren().add(card);
            //Fondu = animation
            FadeTransition fadIn = new FadeTransition(Duration.millis(500), card);
            fadIn.setFromValue(0);
            fadIn.setToValue(1);
            fadIn.play();
        }
    }
    @FXML
    public void clickBox1(ActionEvent event){
        CurrentBoxId = 1;
        showBoxContent(1);
    }
    @FXML
    public void clickBox2(ActionEvent event){
        CurrentBoxId = 2;
        showBoxContent(2);
    }
    @FXML
    public void clickBox3(ActionEvent event){
        CurrentBoxId = 3;
        showBoxContent(3);
    }
    @FXML
    public void clickBox4(ActionEvent event){
        CurrentBoxId = 4;
        showBoxContent(4);
    }
    @FXML
    public void clickBox5(ActionEvent event){
        CurrentBoxId = 5;
        showBoxContent(5);
    }
    public VBox createCardView(IFlashCard flash){
        VBox card = new VBox(10);
        card.getStyleClass().add("card");
        //Title
        Text titre = new Text(flash.getSubjectfromFlashCard()+" - "+flash.getChapterfromFlashCard());
        titre.getStyleClass().add("card-title");
        //Question
        Text question = new Text("Question : " + flash.getQuestion());
        question.getStyleClass().add("card-description");
        // Date of Creation
        LocalDate creationDate = flash.getCreationDate(); // Date de création de la carte
        Text dateText = new Text("Creation Date : " + creationDate.toString()); // Format standard ISO (yyyy-MM-dd)
        dateText.getStyleClass().add("card-date");
        //Answer
        VBox answerBox = new VBox();
        answerBox.setVisible(false);
        // Contenu de la réponse (texte ou image)
        if (flash.getAnswer() != null && !flash.getAnswer().isEmpty()) {
            Text reponseText = new Text(flash.getAnswer());
            reponseText.getStyleClass().add("card-answer");
            answerBox.getChildren().add(reponseText);
        }
        // Hide and Seek with the answer
        Button showAnswerButton = new Button("I want to see the answer");
        showAnswerButton.setOnAction(event -> {
            answerBox.setVisible(true); // Afficher la réponse
        });
        //Wrong or Right
        HBox buttonBox = new HBox(10);
        Button correctButton = new Button("Correct");
        Button incorrectButton = new Button("Incorrect");
        Button deleteButton = new Button("Delete");
        //Action of when Correct
        correctButton.setOnAction(actionEvent -> {leitnerMeth.MovingFlashCard(flash, true );
        refreshCurrentBox();
        });
        //Incorrect
        incorrectButton.setOnAction(actionEvent -> {leitnerMeth.MovingFlashCard(flash, false ); refreshCurrentBox();
        });
        //Delete
        deleteButton.setOnAction(event -> {
            Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationDialog.setTitle("Delete Confirmation");
            confirmationDialog.setHeaderText("Are you sure you want to delete this beautiful and useful card ?");
            confirmationDialog.setContentText(flash.getQuestion());

            Optional<ButtonType> result = confirmationDialog.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                leitnerMeth.removeFlashCard(flash); // Supprimer la carte
                refreshCurrentBox(); // Rafraîchir la vue
            }
        });
        buttonBox.getChildren().addAll(correctButton, incorrectButton, deleteButton);
        //put everything together
        card.getChildren().addAll(titre, question, dateText,showAnswerButton, answerBox, buttonBox);
        return card;
    }
    //Méthode pour rafraîchir la vue après le déplacement d'une carte
    private void refreshCurrentBox(){
        showBoxContent(CurrentBoxId);
    }
    @FXML
    private TextField subjectField;
    @FXML
    private TextField chapterField;

    @FXML
    private TextField questionField;

    @FXML Text notallrequired;
    @FXML TextField answerField;

    @FXML
    public void addCard(){
        String subject = subjectField.getText();
        String chapter = chapterField.getText();
        String question = questionField.getText();
        String answer = answerField.getText();

        //chapter, subject, question must not be empty
        if (chapter.isEmpty() || question.isEmpty()|| subject.isEmpty()){
            notallrequired.setText("Please fill in all required fields");
            return;
        }
        IFlashCard newCarte = new FlashCard(chapter, question, subject, answer);
        //Card added to leitnerMeth
        leitnerMeth.addFlashCard(newCarte);
        //Updating the visual to box 1
        showBoxContent(1);
        //Réinitialiser the fields
        questionField.clear();
        chapterField.clear();
        subjectField.clear();
        answerField.clear();
    }
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}