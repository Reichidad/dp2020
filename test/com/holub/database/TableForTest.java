package com.holub.database;

public class TableForTest {
    private Table table;
    public TableForTest() {
        this.table = TableFactory.create( "people",
                new String[]{ "First", "Last"		} );
        table.insert( new String[]{ "Allen",	"Holub" 	} );
        table.insert( new String[]{ "Ichabod",	"Crane" 	} );
        table.insert( new String[]{ "Rip",		"VanWinkle" } );
        table.insert( new String[]{ "Goldie",	"Locks" 	} );
        table.insert( new String[]{ "Yeonghyeon",	"Kim" 	} );
        table.insert( new String[]{ "Changun",	"Lee" 	} );
    }
    public Table getTable() {
        return this.table;
    }
}
