## Исходное задание:
###Предметная область
В модели предметной области имеются сущности (в скобках указаны обязательные атрибуты):
-	Товар (Артикул, Наименование, Цена последней закупки, Цена последней продажи).
-	Склад (Наименование). На складе может храниться несколько товаров.
####Документы:
-	Поступление (Номер, Склад, Список товаров). Заводится при поступлении товара. Содержит список товаров, их количество и закупочные цены. В документе указывается склад, на который поступают товары.
-	Продажа (Номер, Склад, Список товаров). Заводится при продаже товара. Содержит список товаров, их количество и цены продажи. В документе указывается склад, с которого списывают товары.
-	Перемещение (Номер, Склад1, Склад2, Список товаров). Заводится при перемещении товара между складами. Содержит список товаров и их количество. В документе указывается склад, с которого списывают товары и склад, на который они поступают.
###Постановка задачи (backend)
Необходимо реализовать серверную часть приложения по учету товаров на складе.
Приложение должно включать API для просмотра, создания, редактирования и удаления сущностей.
На вход приложению поступают документы: API включает операции импорта (создания) и просмотра документов.
На выходе имеется возможность сформировать отчеты:
-	Общий список товаров (артикул, наименование, цены закупки и продажи). В качестве опционального параметра может быть передан фильтр по имени товара.
-	Остатки товаров на складах (артикул, наименование, остаток по всем складам). В качестве опционального параметра может быть передан фильтр по складу.

API для работы с сущностями оперирует форматом JSON.
Работу с документами также можно проводить в формате JSON, либо использовать другой человеко-читаемый формат (например CSV).
Формат выводимых отчетов на выбор: JSON, CSV, HTML (а можно и все три :) ).

####Функциональные требования
-	Предусмотреть валидацию входных параметров. Программа не должна «упасть» на некорректных данных.
-	Выполнение любой операции должно возвращать результат — ОК либо сообщение/код ошибки.
####Нефункциональные требования
-	Язык разработки: Java.
-	Фреймворк: использование Spring нежелательно, лучше обойтись без него.
-	Данные можно хранить в памяти (например, в виде списка), либо использовать для хранения PostgreSQL / H2 (будет плюсом).
-	Сборка с помощью инструмента Maven без установки или настройки каких-либо дополнительных компонент.
-	Выполненное задание должно быть размещено в публичном репозитории на Github / Bitbucket.
-	Файл README должен содержать инструкцию по сборке, настройке, конфигурированию и развертыванию приложения (если необходимо).
####Дополнительные возможности
К реализованному API можно составить небольшую документацию — список возможных команд с передаваемыми в них параметрами и возможными ответами на запрос. Файл с документацией может быть в формате Markdown, либо с использованием инструментов для документирования АПИ( API Blueprint, Swagger и подобные).

Реализованный функционал желательно покрыть юнит-тестами и интеграционными тестами.

##Моя документация
###план работы:
- описание API в виде swagger
  - прочитать вики про Rest API
  - прочитать статью про проектирование Rest API
  - описать API своими словами
  - прочитать вики про swagger
  - найти и прочитать документацию swagger
  - написать простое API (hello world)
  - перевести на язык swagger
- написание классов моделей
  - список всех необходимых классов 
  - описать связь классов 
  - штука, которая содержит все описания полей и методов
  
- формулирование бизнес логики (в виде тестов)
 - написать сценарии использования, покрывающие тз:
 - написания ограничений и критических ситуаций
   - технические ограничения
   - бизнесс ограничения
 - написать сценарии, используя API

  
- написание контроллеров
  - определение основных end points (описание, список) 
  - написание выше описанных end points на языке java соответствующих методов
  - серверная часть сможет взаимодействовать с клиентом
  - убедиться, что работает серверная часть с помощью инструменов (с помощью тестов)
  - написать тесты контроллеров 

  
- имплементация бизнес логики
  - написание java кода, соответствующего бизнесс правилам
  - написание схемы базы данных
   - создание самое бд
   - создание отдельных таблиц бд
   - создание столбцов таблиц
- тестирование 
 - продумать, что можно протестировать, составить список
 - протестировать по списку


## Сценарии использования :
### Добавление товара на склад
**КОГДА** пришел товар.

**ТО** Создаем документ поступления.

**И** Проверяем, есть ли этот товар в нашей БД. 

**ЕСЛИ** нет, заводим сведения о новом товаре в бД.

**И** Заполняем документ поступления

**ИНАЧЕ** Отправляем его на склад обновлением количество этого товара. 

**И** Заполняем документ поступления

### Продажа товара
**ДОПУСТИМ** Товар существует на запрашиваемом складе в нужном количестве

**КОГДА** Поступил запрос на продажу товара

**ТО** Проверяем наличие товара в заданном количестве.

**ЕСЛИ** Количество товара на складе больше 

**ИЛИ** равно требуемому для продажи

**ТО** Обновляем информацию о товаре на складе.

**И** Создаем документ продажи

**ДОПУСТИМ** Товар НЕ существует на запрашиваемом складе

**Тогда** Выдаем ошибку о том, что не хватает товара на данном складе.

**КОГДА** Поступил запрос на продажу товара

**ТО** Проверяем наличие товара в заданном количестве.

**ЕСЛИ** Количество товара на складе меньше

**ТО** Выдаем ошибку "Недостаточно товара на складе X"

### Перемещение товара

**КОГДА** Переместили товар

**ТО** Создаем документ перемещения

**И** Проверяем наличие товара в заданном количестве.

//TODO закончить ...
...
...
...
...