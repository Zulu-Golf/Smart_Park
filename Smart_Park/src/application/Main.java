package application;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class Main extends Application {
	private double xOffset=0;
	private double yOffset=0;
	@Override
	    public void start(Stage primaryStage) {
	        try {
	      
	            // Read file fxml and draw interface.
	           Parent auth_scene = FXMLLoader.load(getClass()
	                    .getResource("/application/Auth_Scene.fxml"));
	          /* auth_scene.setOnMousePressed(new EventHandler<MouseEvent>   () {

				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					xOffset= event.getSceneX();
					yOffset= event.getSceneY();
					
				}
			});
	           auth_scene.setOnMouseDragged(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					primaryStage.setX(event.getSceneX() - xOffset);

					primaryStage.setY(event.getSceneY() - yOffset);
					
				}
			});*/
	           primaryStage.initStyle(StageStyle.TRANSPARENT);
	            primaryStage.setTitle("Bibliotheque");
	            Scene scene=new Scene(auth_scene);
	            scene.setFill(Color.TRANSPARENT);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	         
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static void main(String[] args) {
	        launch(args);
	    }
	    
}
