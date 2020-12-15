package com.holub.database;

import com.holub.text.ParseFailure;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void execute() throws IOException {
        Database testDB = new Database("c:/dp2020");
        String sql = "select * from address, name where address.addrId = name.addrId";
        try {
            Table testResult = testDB.execute(sql);
            System.out.println(testResult);
        } catch (Exception e) {
            fail(sql + "\n query failed!");
        }
    }
}