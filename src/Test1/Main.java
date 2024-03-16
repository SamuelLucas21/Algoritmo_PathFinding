package Test1;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
		public static void main(String args[])throws Exception{
		 	launch(args);
		}

		@Override
		public void start(Stage arg0) throws Exception {
			TelaMain screenMain = new TelaMain("First_Window");
			screenMain.Display(true);
		}
}
