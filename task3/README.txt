Выполнил: Ростислав Пеховский

Текст хранится в виде древовидной структуры с помощью шаблона Composite.
1) TextComponent объединяет в себе как листья, так и узлы дерева
2) TextNode - узел дерева, имеет состояние в зависимости от того, какой часью
   текста этот узел является (TextState, ParagraphState, SentenceState, LexemeState, ExpressionState,
   WordState, WordCharsState (символы в лексеме не явл. выражением или словом). Реализация - TextNodeImpl
   Состояние определяет парсер, которым будет разбираться строка на меньшие части.
   Для сбора структуры обратно в строку существует специальный метот createText().
3) TextLeaf - лист дерева, хранящий только один символ. Реализация - TextLeafImpl

Для разбора выражения существует несколько классов:
1) ExpressionParser - извлекает из строки числа (операнды) и операции и создает список
   объектов из чисел и операций (список частей выражения)
2) ReversePolishConverter - переводил список частей выражения в форму обратной польской записи
3) InterpreterCalculator - считает выражение, представленное в виде списка частей выражения
   в обратной польской записи (сущ. альтернативная реализация - LambdaCalculator, объединены единым интерфейсом)
   Использует шаблон интерпретатора. Все операции и конкекст класс в пакете interpreter
4) SimpleExpressionCalculator объединяет в себе все функции вышестоящих классов, и позволяет
   за одно действие задав выражение через строку получить на него ответ. Явл. синглтоном, т. к.
   класс нужен часто и нет смысла создавать все время новые объекты данного класса

   Разбор выражения осущетсвляется перед парсингом выражения в ExpressionState.


Для сортировки сущ. 3 класса:
1) ParagraphsInTextSorter - сортирует абзацы по кол-ву предложений.
   Реализован просто: сортируется список children текста по количеству children у каждого child
2) WordInSentenceParser - сортирует слова по длине в предложении (НО ЛЕКСЕМЫ ОСТАЮТСЯ НА МЕСТЕ, т. е.
   знаки препинания и выражения места не меняют, только слова меняют положение)
   Проходится по каждому предложению и в каждом предложении находит слова, формирует список из слов и
   потом их сотрирует, заменяя в лексемах только слова)
3) LexemeInTextParser - сортирует лексемы в тексте по вхождению символа, или по алфавиту,
   если кол-во символов одинаково.
   Обход дерева выполнен рекурсивно: класс рекурсивно формирует список всех лексем (создает копии),
   входя вглубь дерева, пока метод не найдет узел-лексему, сортирует их по признакам и так же рекурсивно
   кладет их обратно.
