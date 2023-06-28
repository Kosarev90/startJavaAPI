package ru.kosarev.lesson_2;


// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class JsonParse {
    public static void main(String[] args) {
        String sqlQuery = "select * from students where ";
        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        StringBuilder builder = new StringBuilder();

        try {
            // Удаление фигурных скобок из JSON-строки
            String trimmedParams = json.replace("{", "").replace("}", "");
            // Разделение параметров по запятой
            String[] params = trimmedParams.split(", ");

            boolean isFirstCondition = true;

            for (String param : params) {
                // Разделение ключа и значения параметра
                String[] keyValue = param.split(":");
                String key = keyValue[0].replace("\"", "");
                String value = keyValue[1].replace("\"", "");

                if (!value.equals("null")) {
                    if (!isFirstCondition) {
                        builder.append(" and ");
                    } else {
                        isFirstCondition = false;
                    }

                    builder.append(key).append(" = ");

                    // Добавление кавычек для строковых значений
                    if (!value.equals("null")) {
                        builder.append("'").append(value).append("'");
                    } else {
                        builder.append(value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        sqlQuery += builder.toString();
        System.out.println(sqlQuery);
    }
}
