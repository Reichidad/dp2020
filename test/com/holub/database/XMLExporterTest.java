package com.holub.database;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static org.junit.Assert.*;

public class XMLExporterTest {
    @Test
    public void export() {
        Table people = new TableForTest().getTable();

        try {
            String tableName = people.rows().tableName();
            Writer out = new FileWriter("C:/dp2020/" + tableName + ".xml");
            people.export(new XMLExporter(out));
            out.close();
        } catch (Exception e) {
            fail("Cannot make XML file!");
        }
    }
}