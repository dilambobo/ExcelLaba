package com.example.ecxellab;

import com.example.ecxellab.Tech.Calculator;
import com.example.ecxellab.Tech.ExcelExport;
import com.example.ecxellab.Tech.ExcelImport;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class FirstPageController {

    ExcelExport excelExport = new ExcelExport();
    ExcelImport excelImport = new ExcelImport();
    Calculator calculator = new Calculator();
    @FXML
    private Button importButton;

    @FXML
    private Button exportButton;

    @FXML
    protected void importFile() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);

        try {
            excelImport.arr(file);
            Calculator.makeCalculation(excelImport.getDoubles());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Import");
            alert.setHeaderText(null);
            alert.setContentText("Файл загружен");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ошибка в пути файла");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ошибка в формате файла.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void exportFile() {FileChooser fc = new FileChooser();
        File file = fc.showSaveDialog(null);

        try {
            ExcelExport.export(excelImport.getStrings(), calculator.getCalculationResult(), file);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Import");
            alert.setHeaderText(null);
            alert.setContentText("Файл сохранен");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ошибка в пути файла");
            alert.showAndWait();
        }}

}