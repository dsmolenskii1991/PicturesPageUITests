# PicturesPageUITests

Примеры тестов для страницы Картинки в поиске Яндекса

Тест 1 - Поиск через добавление локального файла

Тест 2 - Поиск по URL

Перед запуском нужно:
1) Прописать путь до chromedriver в pathToDriver в config.properties (/src/test/resources/)
2) Прописать путь до файла в examplePictureDirectory в config.properties (/src/test/resources/)
3) Прописать url файла для поиска по url в examplePictureUrl в config.properties (/src/test/resources/)
4) В классе с тестами PicturePageTests установить значение переменной expectedTagText для ожидаемого текста тэга для сравнения с картинкой
