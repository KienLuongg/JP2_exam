import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;


import java.io.IOException;

public class CreateController<BookRepository> {

    public TextField txtID;
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtPrice;



    public void backToList(ActionEvent event) throws IOException {
        Parent listScene = FXMLLoader.load(getClass().getResource("TableView.fxml"));
        Scene sc = new Scene(listScene,800,600);
        Main.rootStage.setScene(sc);
    }

    public void save(ActionEvent event) {
        try {
            Integer p = Integer.parseInt(txtPrice.getText());
            Book Book = new Book(txtID.getId(), txtName.getText(), txtAuthor.getText(), p);


        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void exit(ActionEvent event) {
    }
}
