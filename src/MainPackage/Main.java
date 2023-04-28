
package MainPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("/View_FXMLGUI/loginFormFXML.fxml"));
        Stage stage=new Stage();
        stage.setResizable(false);
        stage.setTitle("Login -  P.K. Roy Memorial College Dhanbad - Smart-Ed College ERP v1.1.1");
        stage.getIcons().add(new Image("/MultimediaResources/loginPageTitleIcon.png"));
        Scene scene=new Scene(root,1150, 650);
        
        stage.setScene(scene);
        stage.show();

//
//        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/ShowRoutineFXML.fxml"));
//////        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/MarkDepartmentwiseStudentAttendanceFXML.fxml"));
//        Parent root=loader.load();
//        Stage currentStage=new Stage();
//        Scene scene=new Scene(root);
//        currentStage.setScene(scene);
////        currentStage.setMaximized(true);
//        currentStage.getIcons().add(new Image("/MultimediaResources/pkroylogo.png"));
//        currentStage.setTitle("Manage Students - P.K. Roy Memorial College Dhanbad - College ERP v1.1.1");
//        currentStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
