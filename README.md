## Тестовое задание
Необходимо было разработать парсер некоторых древовидных данный, состоящих из узлов и списков. Я использовал базу данных PosgresSQL для сохранния полученного дерева.

#### Развертывание БД
```SQL
    CREATE TABLE elements
    (
    id          INT NOT NULL PRIMARY KEY,
    parent_id   INT,
    name        TEXT,
    value       TEXT,

    CONSTRAINT fk_elements_elements FOREIGN KEY (parent_id) REFERENCES elements (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

    );
```

Поменять данные для входа можно в классе db/ConfigDb

```Java
class ConfigDb {
    public static String urlDb = "jdbc:postgresql://localhost:5432/testSber";
    public static String username = "testSber";
    public static String password = "testSber";
}
```

#### Файл с данными

Файл с данными находится в ресурсах под названием data.txt, в нем можно кидать наше строку.

#### Тест

Данные: 

![](https://i.ibb.co/NZhCLHC/image.png)

Результат:

![](https://i.ibb.co/CvJSrCQ/image.png)

Неправильный формат данных:

![](https://i.ibb.co/q9pFPkd/image.png)

#### Как устроен парсер

Сначала парсер при помощи регулярного выражения подстверждает правильность полученной строки, далее он идет по строке и закидывает данные в дерево, понижая или повышая уровень глубины, смотря на скобки {}. В конце парсер сверяет количество {}, ведь оно должно быть одинаковым, а иначе - ошибка.
