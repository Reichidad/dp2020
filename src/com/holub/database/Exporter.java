package com.holub.database;

import java.io.FileWriter;
import java.io.IOException;

public class Exporter implements ExporterElement {
    ExporterElement[] elements;
    Table table;
    String tableName;

    public ExporterElement[] getElements() {
        return elements.clone();
    }
    public Exporter(Table inputTable) throws IOException {
        this.table = inputTable;
        this.tableName = this.table.rows().tableName();
        this.elements = new ExporterElement[]{
                new CSVExporter(new FileWriter("C:/dp2020/" + this.tableName + ".csv")),
                new HTMLExporter(new FileWriter("C:/dp2020/" + this.tableName + ".html")),
                new XMLExporter(new FileWriter("C:/dp2020/" + this.tableName + ".xml"))
        };
    }
    public void accept(ExporterVisitor visitor) {
        for (ExporterElement element : this.getElements()) {
            element.accept(visitor);
        }
    }
}
