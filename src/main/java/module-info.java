/**
 *
 */
module com.example.ecxellab {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.apache.poi.ooxml;
    requires commons.math3;
    requires org.apache.logging.log4j;
    requires org.apache.poi.examples;
    requires org.apache.poi.ooxml.schemas;
    requires org.apache.poi.scratchpad;
    requires org.apache.xmlbeans;

    opens com.example.excellab to javafx.fxml;
    exports com.example.excellab;
}