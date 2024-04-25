package Test1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TelaMain {
    private Stage stage = new Stage();
    public TelaMain(String newName){
        try{
			TelaController control = new TelaController();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Tela.fxml"));
			loader.setController(control);
			Pane pane = loader.load();
			Scene scene = new Scene(pane);
			stage.setTitle(newName);
			stage.setScene(scene);
			stage.show();
			}catch(Exception ie){
				ie.printStackTrace();
			}			
    }
    public void Display(boolean visual){
        if(visual == true) stage.show();
        else stage.close();
    }
	public void addConponet(Circle newCircle, int locateX, int locateY){

	}
    
}
