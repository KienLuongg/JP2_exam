import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListController<BookRepository> implements Initializable {
    public TableView<Object> tbBook;
    public TableColumn<Object, Object> cID;
    public TableColumn<Object, Object> cName;
    public TableColumn<Object, Object> cAuthor;
    public TableColumn<Object, Object> cPrice;

    public void toCreateBook(ActionEvent event) throws IOException {
        Parent createForm = FXMLLoader.load(getClass().getResource("BookCreate.fxml"));
        Scene sc = new Scene(createForm,800,600);
        Main.rootStage.setScene(sc);
    }

    public void exit(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    cID.setCellValueFactory(new PropertyValueFactory<>("id"));
    cName.setCellValueFactory(new PropertyValueFactory<>("name"));
    cAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
    cPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        cID.setText(Main._msg.getString("id"));
        cName.setText(Main._msg.getString("name"));
        cAuthor.setText(Main._msg.getString("author"));
        cPrice.setText(Main._msg.getString("price"));

        try {
            BookRepository sr = new BookRepository();
            ObservableList<Object> ls = null;
            ls.addAll(sr.getClass());
            tbBook.setItems(ls);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
        
    }

}
