package com.holub.database;

import com.holub.database.Table.Exporter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

// Modified by 20145822 김영현
// Must 확장 기능 1번 - HTML Exporter
// 기본 형태는 CSVExporter 클래스와 동일

// Table 객체를 export할 때
// Writer out = new FileWriter("C:/dp2020/" + tableName + ".xml");
// table.export(new XMLExporter(out));

public class XMLExporter implements Table.Exporter, ExporterElement {
    private final Writer out;
    private int width;
    private boolean columnNameFlag = true;
    public XMLExporter(Writer out) {
        this.out = out;
    }

    public void storeMetadata(String tableName, int width, int height, Iterator columnNames) throws IOException {
        this.width = width;
        this.out.write("\t<tableName>"); // tableName 태그 열기
        this.out.write(tableName == null ? "<anonymous>" : tableName);
        this.out.write("</tableName>\n"); // tableName 태그 닫기
        this.storeRow(columnNames);
    }

    public void storeRow(Iterator data) throws IOException {
        int i = this.width;
        if(columnNameFlag) this.out.write("\t<columnName>");
        else this.out.write("\t<row>"); // 한 row의 시작에 태그 열기
        while(data.hasNext()) {
            Object datum = data.next();
            if (datum != null) {
                this.out.write(datum.toString());
            }

            --i;
            if (i > 0) {
                this.out.write(",\t");
            }
        }
        if(columnNameFlag) {
            this.out.write("</columnName>\n");
            this.columnNameFlag = false;
        }
        else this.out.write("</row>\n"); // row의 끝에 태그 닫기
    }

    public void startTable() throws IOException {
        // xml 선언
        this.out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        // xml 태그 table 열기
        this.out.write("<table>\n");
    }

    public void endTable() throws IOException {
        // xml 태그 table 닫기
        this.out.write("</table>");
    }
    public void accept(ExporterVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Writer getOut() {
        return this.out;
    }
}