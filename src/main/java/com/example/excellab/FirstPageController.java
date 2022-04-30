package com.example.excellab;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class FirstPageController {
    ExportToExcel excelExport = new ExportToExcel();
    ImportFromExcel excelImport = new ImportFromExcel();
    Calculation calculator = new Calculation();
    @FXML
    private Button importButton;

    @FXML
    private Button exportButton;

    @FXML
    protected void importFile() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);

        try {
            excelImport.tablesExtract(file);
            Calculation.makeCalculation(excelImport.getDoubles());
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
    protected void exportFile() {
        FileChooser fc = new FileChooser();
        File file = fc.showSaveDialog(null);

        try {
            ExportToExcel.fillingFinalTable(excelImport.getStrings(), calculator.getCalculationResult(), file);
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