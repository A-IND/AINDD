package de.uni_potsdam.utils;

/**
 * @projectName: AproINDAlgo
 * @package: de.uni_potsdam.utils
 * @className: DatabaseUtils
 * @author: SuQingdong
 * @description: TODO
 * @date: 2023/12/23 15:15
 * @version: 1.0
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {
    public DatabaseUtils() {
    }

    public static void close(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

    }

    public static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                if (!connection.getAutoCommit()) {
                    connection.commit();
                }

                connection.close();
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

    }

    public static String[] generateAttributeNames(int numAttributes) {
        String prefix = "A";
        String[] names = new String[numAttributes];

        for(int i = 0; i < numAttributes; ++i) {
            names[i] = prefix + (i + 1);
        }

        return names;
    }

    public static String[] generateAttributeTypes(int numAttributes) {
        String[] types = new String[numAttributes];

        for(int i = 0; i < numAttributes; ++i) {
            types[i] = "VARCHAR(255)";
        }

        return types;
    }

    public static void formatAttributeLabels(String[] firstLine) {
        for(int i = 0; i < firstLine.length; ++i) {
            firstLine[i] = firstLine[i].replace("-", "_").replace("/", "_");
        }

    }

    public static boolean matchSameDataTypeClass(String dataType1, String dataType2) {
        if (dataType1.equals(dataType2)) {
            return true;
        } else if (isNumeric(dataType1) && isNumeric(dataType2)) {
            return true;
        } else if (isString(dataType1) && isString(dataType2)) {
            return true;
        } else {
            return isTemporal(dataType1) && isTemporal(dataType2);
        }
    }

    public static boolean isNumeric(String dataType) {
        if (dataType == null) {
            return false;
        } else {
            String type = dataType.toLowerCase();
            return type.contains("int") || type.contains("float") || type.contains("double") || type.contains("numeric") || type.contains("decimal") || type.contains("real") || type.contains("precision") || type.contains("serial") || type.contains("bit");
        }
    }

    public static boolean isString(String dataType) {
        if (dataType != null && !isLargeObject(dataType)) {
            String type = dataType.toLowerCase();
            return type.contains("char") || type.contains("text");
        } else {
            return false;
        }
    }

    public static boolean isTemporal(String dataType) {
        if (dataType == null) {
            return false;
        } else {
            String type = dataType.toLowerCase();
            return type.contains("date") || type.contains("time") || type.contains("year");
        }
    }

    public static boolean isLargeObject(String dataType) {
        if (dataType == null) {
            return false;
        } else {
            String type = dataType.toLowerCase();
            return type.contains("object") || type.contains("clob") || type.contains("blob");
        }
    }

    public static boolean isIndexable(String dataType) {
        if (dataType != null && !dataType.equals("")) {
            String size = dataType.replaceAll("\\D", "");
            return !size.equals("") && Integer.parseInt(size) <= 200;
        } else {
            return false;
        }
    }
}
