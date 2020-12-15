package com.holub.database;

import java.io.IOException;

public class StartExport implements ExporterVisitor {
    Table table;
    public StartExport(Table inputTable) {
        this.table = inputTable;
    }
    public void visit(CSVExporter csv) throws IOException {
        this.table.export(csv);
        csv.getOut().close();
    }
    public void visit(HTMLExporter html) throws IOException {
        this.table.export(html);
        html.getOut().close();
    }
    public void visit(XMLExporter xml) throws IOException {
        this.table.export(xml);
        xml.getOut().close();
    }
}
