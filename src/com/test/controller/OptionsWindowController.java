package com.test.controller;

import com.test.EmailManager;
import com.test.view.ColorTheme;
import com.test.view.FontSize;
import com.test.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends BaseController implements Initializable {
    @FXML
    private Slider SliderFont;

    public OptionsWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }


    @FXML // fx:id="themePicker"
    private ChoiceBox<ColorTheme> themePicker; // Value injected by FXMLLoader

    @FXML
    void AcceptChangesAction(ActionEvent event) {

    }

    @FXML
    void ApplyChangesAction(ActionEvent event) {
        viewFactory.setColorTheme(themePicker.getValue());
        viewFactory.getFontSize(FontSize.values()[(int)SliderFont.getValue()]);
        System.out.println(viewFactory.getColorTheme());
        System.out.println(viewFactory.getFontSize());
    }

    @FXML
    void CancelChangesAction(ActionEvent event) {
        Stage stage = (Stage) SliderFont.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void ChangeColorAction(ActionEvent event) {

    }

    @FXML
    void FontSizeBiggerAction(MouseEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpThemePicker();
        setUpSizePicker();
    }

    private void setUpSizePicker() {
        SliderFont.setMin(0);
        SliderFont.setMax(FontSize.values().length - 1);
        SliderFont.setValue(viewFactory.getFontSize(FontSize.values()[(int) SliderFont.getValue()]).ordinal());
        SliderFont.setMajorTickUnit(1);
        SliderFont.setMinorTickCount(0);
        SliderFont.setBlockIncrement(1);
        SliderFont.setSnapToTicks(true); //Ticks en la barra señalizando
        SliderFont.setShowTickMarks(true);
        SliderFont.setShowTickLabels(true);
        SliderFont.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double doubleNumber) {
                int i = doubleNumber.intValue();
                return FontSize.values()[i].toString();

            }

            @Override
            public Double fromString(String string) {
                return null;
            }
        });
        SliderFont.valueProperty().addListener((obs, oldVal, newVal) -> {SliderFont.setValue(newVal.intValue());});
    }

    private void setUpThemePicker() {
        themePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        themePicker.setValue(viewFactory.getColorTheme());
    }
}


