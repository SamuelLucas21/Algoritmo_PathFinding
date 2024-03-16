package Test1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class TelaController {
    String origem, destino;
    
    @FXML
    private Pane Tela_Screen;

    @FXML
    private Button button1;

    @FXML
    private TextField textField2;

    @FXML
    private TextField textfield1;

    @FXML
    void onClickedPressed(ActionEvent event) {
        origem=textfield1.getText();
        destino=textField2.getText();
        System.out.println(origem+destino);
    }

}
