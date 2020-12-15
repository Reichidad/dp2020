package com.holub.database;

interface ExporterElement {
    void accept(ExporterVisitor visitor);
}
