package com.holub.database;

import javax.swing.*;
import java.io.*;
import java.util.*;

// Modified by 20145822 김영현
// Must 확장 기능 1번 - HTML Exporter
// 기본 형태는 CSVExporter 클래스와 동일

// Table 객체를 export할 때
// Writer out = new FileWriter("C:/dp2020/" + tableName + ".html");
// table.export(new HTMLExporter(out));

public class HTMLExporter implements Table.Exporter, ExporterElement
{
    private final Writer out;
    private 	  int	 width;

    public HTMLExporter( Writer out )
    {	this.out = out;
    }

    public void storeMetadata( String tableName,
                               int width,
                               int height,
                               Iterator columnNames ) throws IOException

    {	this.width = width;
        out.write(tableName == null ? "<anonymous>" : tableName );
        out.write("<br>"); // html 가독성을 위해 줄바꿈
        storeRow( columnNames ); // comma separated list of columns ids
    }

    public void storeRow( Iterator data ) throws IOException
    {	int i = width;
        while( data.hasNext() )
        {	Object datum = data.next();

            // Null columns are represented by an empty field
            // (two commas in a row). There's nothing to write
            // if the column data is null.
            if( datum != null )
                out.write( datum.toString() );

            if( --i > 0 ) // \t 대신 html의 띄어쓰기인 &nbsp;를 write
                out.write(",&nbsp;");
        }
        out.write("<br>"); // \n 대신 html의 줄바꿈 태그 <br>을 write
    }

    public void startTable() throws IOException {/*nothing to do*/}
    public void endTable()   throws IOException {/*nothing to do*/}
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