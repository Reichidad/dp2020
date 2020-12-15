package com.holub.database;

import java.io.IOException;

interface ExporterVisitor {
    void visit(CSVExporter csv) throws IOException;
    void visit(HTMLExporter html) throws IOException;
    void visit(XMLExporter xml) throws IOException;
}
