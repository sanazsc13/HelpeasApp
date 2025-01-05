package app.helpeas.Model;
import java.io.*;
import java.util.List;

public class DataGestion {
    private List<IFlashCard> flashCards;

    public DataGestion(List<IFlashCard> flashCards) {
        this.flashCards = flashCards;
    }

    // Méthode pour sauvegarder les cartes dans un fichier
    public void saveCardsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cards.dat"))) {
            oos.writeObject(flashCards); // Sauvegarder la liste des cartes dans le fichier
            System.out.println("Cards have been saved.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving cards.");
        }
    }

    // Méthode pour charger les cartes à partir d'un fichier
    public List<IFlashCard> loadCardsFromFile() {
        List<IFlashCard> cards = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cards.dat"))) {
            cards = (List<IFlashCard>) ois.readObject(); // Lire la liste des cartes depuis le fichier
            System.out.println("Cards have been loaded.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading cards.");
        }
        return cards;
    }

    // Vous pouvez également ajouter un getter pour accéder aux cartes actuelles
    public List<IFlashCard> getFlashCards() {
        return flashCards;
    }

    // Vous pouvez également ajouter un setter pour modifier les cartes
    public void setFlashCards(List<IFlashCard> flashCards) {
        this.flashCards = flashCards;
    }
}
