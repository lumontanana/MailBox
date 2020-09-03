package com.test.view;

import com.test.EmailManager;
import com.test.controller.BaseController;
import com.test.controller.LoginWindowControler;
import com.test.controller.MainWindowControler;
import com.test.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    private EmailManager emailManager;

    public ViewFactory(EmailManager emailManager){
        this.emailManager = emailManager;
    }


    //View options handling:
    private  ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public FontSize getFontSize(FontSize value) {
        return fontSize;
    }

    public void showLoginWindow(){

        System.out.println("Show login window called");
        BaseController controller = new LoginWindowControler(emailManager,this,"LoginWindow.fxml");
        initializeStage(controller);
    }

    public void showMainWindow(){
        System.out.println("Show main window called");
        BaseController controller = new MainWindowControler(emailManager, this, "MainWindow.fxml");
        initializeStage(controller);

    }

    public void showOptionsWindow(){
        System.out.println("Showing options pane");
        BaseController controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
        initializeStage(controller);
    }


    private void initializeStage(BaseController controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent root;
        try {
            root = fxmlLoader.load();
        }catch (IOException e){
            e.printStackTrace();
            return;
        }


        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    public void closeStage(Stage stageToClose){
        stageToClose.close();
    }


}
