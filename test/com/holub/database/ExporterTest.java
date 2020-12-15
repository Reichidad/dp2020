package com.holub.database;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ExporterTest {

    @Test
    public void accept() {
        try {
            Table people = new TableForTest().getTable();
            Exporter ex = new Exporter(people);
            ex.accept(new StartExport(people));
        } catch (IOException e) {
            fail("Visitor Pattern test failed with " + e);
        }
    }
}