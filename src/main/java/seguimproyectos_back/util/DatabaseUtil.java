package seguimproyectos_back.util;

import oracle.jdbc.OracleConnection;

import java.sql.Array;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.List;
import java.util.Objects;

public final class DatabaseUtil {
    public static Array createArray(String tabName, String rowName, List<Object[]> list, OracleConnection connection) throws SQLException {
        Struct[] structArray = {};
        if (Objects.nonNull(list) && !list.isEmpty()) {
            structArray = new Struct[list.size()];
            int index=0;
            for (Object[] obj: list) {
                Struct struct = connection.createStruct(rowName, obj);
                structArray[index]=struct;
                index++;
            }
        }
        return connection.createOracleArray(tabName, structArray);
    }
}
