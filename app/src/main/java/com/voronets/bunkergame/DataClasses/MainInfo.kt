package com.voronets.bunkergame.DataClasses

/**
 * This class was made for containing info about heroes and situations
 */

object MainInfo{
    var catast = hashMapOf<String,String>(
        "Супервулкан" to "Взрыв Йеллоустонского супервулкана пошатнул Землю выброшенный в атмосферу пепел закрыл Солнце на несколько месяцев На планете началась \"ядерная зима\" средняя температура опустилась на 11 градусов погибли пять из каждых шести населявших Землю существ Климат существенно изменился На планете теперь царит глобальная засуха\n" +
            "Остаток выжившего населения: 7%\n" +
            "Разрушения на поверхности: 9%.",
        "Экологическая\n катастрофа и глобальный голод" to " \nИнтенсивное ведение сельского хозяйства и деградация почв вкупе с засухой привели к пыльным бурям которые массово уничтожают посевы и приводят к неурожаю и значительному уменьшению запасов пищи Концентрация кислорода в атмосфере падает и климат значительно ухудшается\n" +
                "Остаток выжившего населения: 17%\n" +
                "Разрушения на поверхности: 4%.",
        "Метеорит " to "На планету падает космический объект огромных размеров создавая мощную ударную волну которая сносит все на своем пути На месте падения образовывается масштабный кратер Повсюду проходят сильные землетрясения и цунами Пожары охватывают всю Землю а из-за количество пыли которое поднялось в атмосферу на планете настает долгая \"ядерная зима\"\n" +
                "Остаток выжившего населения: 30%\n" +
                "Разрушения на поверхности: 22%.",
        "Проект «Стрела» " to "Военные работавшие над проектом нечаянно открыли вход в иное измерение Густой неестественный белый туман медленно начал заполонять огромные участки поверхности Видимость практически нулевая По миру стали бродить неведомые чудовища которые могут уничтожить все человечество Разрушения глобальные\n" +
                "Остаток выжившего населения: 1%\n" +
                "Разрушения на поверхности: 26%.",
        "Суперкомпьютер" to " Искусственный интеллект который задумывался для управления системами обороны вышел из строя и посчитал человечество большой опасностью Это привело к тому что искусственный интеллект отключил инструкцию \"не убивать человека\" и взял под контроль процедуры управления военными роботами которые начали истреблять человечество Суперкомпьютер захватил власть над планетой выжившим людям пришлось прятаться в старых бункерах\n" +
                "Остаток выжившего населения: 4%\n" +
                "Разрушения на поверхности: 32%.",
        "Химическая война " to "В результате применения химического и бактериологического оружия был нарушен микробиологический состав почв значительно изменился экологический баланс растения почва и вода были отравлены На Земле остался малый процент населяющих её живых существ\n" +
                "Остаток выжившего населения: 1%\n" +
                "Разрушения на поверхности: 10%.",
        "Инопланетная раса\n решила захватить Землю" to " \nМежпланетные аппараты падают на поверхность планеты один за другим Оружие военных оказывается бессильным против них и постепенно пришельцы истребляют большую часть населения После выхода из бункера подавляющее большинство инопланетян погибло из-за неприспособленности к микроорганизмами населяющими Землю\n" +
                "Остаток выжившего населения: 1%\n" +
                "Разрушения на поверхности: 18%.",
        "Ядерная война " to "Несколько противоборствующих сторон одновременно запустили друг на друга залп ядерных боеголовок После взрывов погибло большое количество людей и разразились огромные пожары Всю планету окутала ядерная пыль закрывшая солнечный свет и приведшая к долгой ядерной зиме Наблюдаются проблемы с почвой водой и растительностью на поверхности нужна химическая обработка\n" +
                "Остаток выжившего населения: 28%\n" +
                "Разрушения на поверхности: 44%.",
        "Биотерроризм " to "Создавая более заразный и смертоносный штамм вируса в стенах исследовательской лабораторий один из работников случайно им заразился в результате чего вирус вышел из-под контроля и очень быстро распространился по всей планете Большой процент всех живых существ погиб У остальных существ и растений развились мутации\n" +
                "Остаток выжившего населения: 29%\n" +
                "Разрушения на поверхности: 10%.",
        "Зомби-апокалипсис " to "Неизвестный возбудитель стал причиной превращения людей в кровожадных зомби Коллапс системы Больницы более не функционируют Тотальная паника армия начинает стрелять на поражение при попытке покинуть карантинную зону Власть уже не может контролировать ситуацию Начинается тотальное мародерство и анархия После выхода из бункера малый процент зомби останется в живых\n" +
                "Остаток выжившего населения: 21%\n" +
                "Разрушения на поверхности: 12%.",
        "Глобальный потоп " to "Из-за деятельности человека все полярные снега растаяли покрыв всю Землю водой Климат серьезно нарушился тропики теперь повсюду Появились новые виды растений и насекомые крупных размеров После выхода из бункера многие выжившие переквалифицировались в менял торговцев и бандитов которые бороздят водные просторы и совершают разбои организованными группами\n" +
                "Остаток выжившего населения: 25%\n" +
                "Разрушения на поверхности: 1%.",
        "Симианский грипп " to "Созданный учеными штамм \"лекарства\" от болезни Альцгеймера в итоге стал смертельным для людей что привело к пандемии симианского гриппа и восходу эволюционировавших обезьян У всех оставшихся людей есть иммунитет к вирусу но он способен мутировать Больший процент обезьян настроен враждебно по отношению к людям\n" +
                "Остаток выжившего населения: 4%\n" +
                "Разрушения на поверхности: 24%.")

    var professions = arrayListOf<String>("Винодел", "Сексолог", "Юрист", "Аллерголог", "Хирург", "Хакер", "Биохимик", "Кассир", "Предприниматеь", "Писатель",
        "Продавец оружия (+К багажу: Пистолет(разряженный))", "Полицейский", "Педиатр", "Экономист", "Инженер", "Охранник", "Кинолог", "Пилот",
        "Грузчик", "Военный", "Священник", "Военный лётчик", "Нейрохирург", "Слесарь", "Фермер", "Гид", "Сварщик",
        "Дипломат (Может сделать враждебный бункер дружелюбным)", "Учитель", "Психолог", "Дизайнер", "Диетолог", "Проктолог", "Бухгалер", "Геолог", "Биофизик",
        "Связист", "Каскадёр", "Блогер", "Слесарь", "Землекоп", "Кузнец", "Плотник", "Сварщик", "Шахтёр", "Типограф", "Таксист", "Актёр", "Певец", "Изобретатель",
        "Повар", "Музыкант", "Ювелир", "Художник", "Бармен", "Библиотекарь", "Няня", "Официант", "Парикмахер", "Садовник", "Уборщик", "Педагог", "Пекарь",
        "Агроном", "Животновод", "Мясник", "Тракторист", "Водолаз", "Барыга", "Мошенник", "Колхозник", "Переводчик", "Аналитик", "Археолог", "Стриптизёр", "Дрессировщик",
        "Охотник", "Флорист", "Столяр", "Каменщик", "Сапожник", "Швея", "Киллер", "Курьер", "Почтальон", "Проститутка", "Ботаник", "Механик", "Электрик", "Филолог",
        "Гитарист", "физик-ядерщик", "оператор", "стоматолог")

    var reproduction = arrayListOf<String>("Плодовитый","Плодовитый","Плодовитый", "Чайлдфри", "Бесплоден")

    var orientation = arrayListOf<String>("Гомосексуальность", "Гетеросексуальность", "Гетеросексуальность", "Гетеросексуальность", "Гетеросексуальность")

    var health = arrayListOf<String>("ВИЧ","авитаминоз","алкоголизм","аллергия на животных","анорексия","астма","бессонница",
        "биполярное расстройство","болезнь Альцгеймера","ветрянка","гайморит","гастрит","гемофилия","гепатит B","глаукома","глухонемота",
        "дальтонизм","депрессия","диарея","заикание","кариес","косоглазие","межпозвоночная грыжа","мигрень","мочекаменная болезнь","наркомания",
        "недержание мочи","ожирение","остеохондроз"," отсутствие ноги","отсутствие руки","паранойя","плоскостопие","пневмония","простуда",
        "псориаз","птичий грипп","рак крови","рак лёгкого","сахарный диабет второго типа","сахарный диабет первого типа","синдром Туретта",
        "слепота","туберкулёз","умственная отсталость","цинга","шизофрения","эпилепсия","язва желудка","порок сердца", "аллергия на пыль",
        "нарушение липидного обмена", "рак поджелудочной железы", "рак груди", "малярия", "холера", "гипертония", "пониженное давление",
        "лучевая болезнь", "бешенство", "брюшной тиф", "ветрянка", "гепатит А", "коронавирус", "грипп", "дифтерия", "крапивница", "ОРВИ",
        "лишай", "сифилис", "столбняк", "чесотка", "чума", "лихорадка", "изжога", "рак желудка", "аритмия", "склероз", "сердечная недостаточность",
        "радикулит", "сколиоз", "кифоз", "рвота, тошнота", "опухоль мозга", "паралич", "расстройства психики",
        "эпилепсия", "гнойное воспаление ануса", "геморрой", "рак прямой кишки", "анальная трещина", "понос", "гиперактивность", "педофилия", "насморк",
        "перелом двух ребёр", "отсутствие зубов", "эбола", "оспа")

    var body = arrayListOf<String>("Худой", "Полный", "Атлетическое", "Ожирение слабое", "Ожирение сильное", "Крепкий")

    var fear = arrayListOf<String>("арахнофобия","нет фобий","клаустрофобия"," боязнь темноты"," боязнь высоты"," боязнь страха",
        "боязнь крови","фобия страха","боязнь утонуть","агорафобия","айхмофобия (боязнь острые предметы)","боязнь громких звуков",
        "нет фобий","боязнь противоположного пола","охлофобия (боязнь массового скопления)","децидофобия (боязнь принятие решений)",
        "боязнь собак","боязнь компуктера","педофобия (боязнь детей)","петтофобия (боязнь пукнуть в присутсвие людей)",
        "ректофобия (боязнь некаканья)","сомнифобия (боязнь спать)","боязнь грызунов","боязнь призраков","боязнь скелетов",
        "аблутофобия (состояние, при котором люди боятся плавать)", "боязнь тараканов", "вагинофобия (боязнь женских гениталий)", "боязнь тумана",
        "гомофобия", "боязнь врачей", "криофобия (страх холода)", "макрофобия (боязнь долгого ожидания)", "уринофобия (боязнь мочеиспускания)",
        "юдофобия (боязнь всего еврейского)", "боязнь собак")


    var hobby = arrayListOf<String>("Рисование","Писательство","Программирование","Вышивание","Увлекается скрапбукингом","Танцы",
        "Интересуется светскими новостями","Астрология","Картография","Биология","Физика","Математика","Делать украшения из бисера",
        "Делать мозайки","Бег","Азартные игры","Шутки шутить","Изготовлять куклы","Плетение корзин из любых веток",
        "Животноводство","Выращивание растений","Занимается ювелирством","Коллекционирует монеты","Коллекционирует сушеных насекомых",
        "Готовка","Альпинизм","Тенис","Баскетбол","Волейбол","Верховая езда","Стрельба из лука","Стрелять из оружия",
        "Увлекается иностранными языками","Разрабатывание сайтов","Выращивание кристаллов","Лепит горшки и посуду из глины",
        "Разводить животных","Разыгрывать всех подряд","Плаванье","Спорт","Дрочка","Автомобили Ароматерапия","Астрономия","Аэробика",
        "Аэрография","Бадминтон","Батик","Батут"," Бильярд","Блоггерство","Бодиарт","Боевые искусства","Бонсай","Боулинг","Велосипед",
        "Видеомонтаж","Выращивание кристаллов","Выращивание растений и цветов","Вязание","Гербарий","Головоломки","Гольф","Горные лыжи",
        "Граффити","Дайвинг","Дартс","Декупаж","Дерево (выжигание и резьба)","Диггерство","Дизайн интерьера","Дизайн одежды",
        "Животные (разведение и уход)","Жонглирование","Зентангл","Игра на музыкальных инструментах","Игрушки и куклы",
        "Игры на компьютерах и приставках","Изделия из металла и кузнечное дело","Изучение новых компьютерных программ","Икебана",
        "Иностранные языки","Йога","Исторические реконструкции","Кайтинг","Каллиграфия","Карвинг","Картинг и квадроциклы","Квест-комнаты",
        "Кладоискательство и археология","Клубный отдых","Коллекционирование","Компьютерная графика","Концерты (посещение)","Коньки и ролики",
        "Косплей","Кроссворды (составление и разгадывание)","Кулинария","Лазертаг","Лепка","Лошади (верховая езда/уход)","Лыжи","Массаж",
        "Моделирование","Музеи и выставки","Музыка(написание ремиксы)","Мыловарение","Настольные игры","Оригами",
        "Открытки (изготовление своими руками/обмен ( посткроссинг))","Охота","Пазлы","Парашютный спорт","Паркур","Пейнтбол","Пение и караоке",
        "Переписка по обычной почте","Пикап","Пилатес","Писательская деятельность и журналистика","Плавание","Плетение",
        "Получение научных званий и степеней","Предпринимательство","Программирование","Психология и тренинги","Путешествия","Пчеловодство",
        "Радиовещание","Разработка сайтов","Рисование","Робототехника","Рукоделия из кожи (одежда аксессуары)","Рыбалка",
        "Самодельные вещи: одежда обувь аксессуары","Серфинг","Силовые тренировки","Скейтборд","Скрапбукинг (фотоальбомы своими руками)",
        "Сноуборд","Собирание грибов и ягод","Спорт-фанат","Стекло (изготовление украшений и предметов интерьера)","Страйкбол","Стрельба",
        "Танцы и балет","Татуировки и пирсинг","Театр (театральный кружок)","Теннис","Файер-шоу","Фейерверки","Фокусы","Фотография и фотокниги",
        "Футбол","Шитье и вышивание","Чтение книг","Наблюдение за птицами","Гадание на картах","Ребусы","Мода","Флористика","Каратэ","Теквандо",
        "Дзюдо","Бодибилдинг","Фотография","Скалолазание","Парусный спорт","Викторины","Сыроварение","Домохозяйство","Космология","Косметология",
        "Сбор грибов","Садоводство","Музыка","Кунг-Фу","Занимается изучением медицины","Изучение почвоведения","Изучение психологии",
        "Оброботка металла","Битбокс")

    var character = arrayListOf<String>("властность","внимательность","внушаемость","ворчливость","гостеприимность","грубость","деликатность","добродушие",
        "доброта","доверчивость","жадность","жестокость","жизнерадостность","истеричность","конфликтность","лицемерие",
        "любезность","надёжность","невозмутимость","нежность","ненадёжность","неравнодушие","неусидчивость","обидчивость",
        "осторожность","пофигизм","предприимчивость","равнодушие","расчётливость","самовлюбленность","самостоятельность",
        "сдержанность","скандальность","слабохарактерность","собранность","терпеливость","тревожность","трусость",
        "усидчивость","флегматичность","харизматичность","храбрость","эгоизм", "щедрость", "лояльность", "послушный", "справедливый", "убедительность",
        "решительность", "целеустремлённость", "мудрость", "организованность", "самоконтроль", "выносливость", "внимательность", "энтузиаст", "инициативность",
        "пунктуальность", "ответственность", "лидерство", "дисциплинированность", "общительность", "воспитанность", "гордость", "самокритичность", "настойчивость",
        "легковозбудимость", "неустойчивость", "забота")

    var extra_info = arrayListOf<String>("ведёт личный дневник.", "верит в сверхъестественных существ.", "выиграл(а) в лотерее целое состояние", "знает наизусть все стихи Пушкина",
        "играл(а) в театре.", "имеет экстрасенсорные способности.", "может оказать первую помощь.", "ненавидит современную музыку.", "обладает феноменальной памятью.",
        "пережил(а) три покушения.", "побывал(а) на вершине Эвереста.", "поставил(а) мировой рекорд по поеданию бургеров.", "проектировал(а) этот бункер.",
        "проходил(а) курсы кулинарии.", "проходил(а) курсы парикмахера.", "сидел(а) в тюрьме.", "страдает морской болезнью.",
        "уверен(а), что эта катастрофа - заговор рептилий.", "увлекается охотой.", "умеет жонглировать.", "хорошо знает высшую математику.", "хорошо ладит с животными.",
        "читал(а) книгу про выживание на необитаемом острове.", "является копрофилом.", "является резидентом Comedy Club", "играет на гитаре", "получал(а) удар молнии", "смотрел(а) все серии с Беаром Гриллсом",
        "лоуреат нобелевской премии", "занимался(ась) фехтованием", "умеет открывать консервы", "знает, где находится продовольствие в парке аттракционов", "хорошо ориентируется на местности",
        "еврей")


    var bag = arrayListOf<String>("беспроводная колонка.", "будильник.", "гаечный ключ.", "гитара.", "губная гармошка.", "десять одноразовых медицинских масок.", "дублёнка.", "карманные часы.",
        "кассеты с фильмами.", "компас.", "коробка с боеприпасами.", "косметическое зеркало.", "лейка.", "молоток и гвозди.", "набор для шитья.",
        "набор кухонных инструментов.", "немецкая овчарка.", "несколько чистых листов пергамента.", "открывашка.", "персидский кот.", "презервативы.", "пустая коробка.",
        "рулоны туалетной бумаги.", "семена картофеля.", "семена пшеницы.", "стерильные одноразовые шприцы.", "телевизор.", "три респираторные маски.",
        "фонарик и запасные батарейки.", "четыре рации", "патроны", "пистолет", "игрушечный медведь", "комплект одежды на двух персон", "железная труба", "арматура", "ножницы", "лезвие для бритья",
        "ноутбук", "рюкзак", "канцелярские принадлежности", "красный диплом", "спички", "семена риса", "годовой запас макарон", "кофе", "чай", "сода", "чугунная посуда", "консервы", "скальпель",
        "нож", "бинты", "вазелин", "пинцет", "помада", "солнцезащитные очки", "камера безопасности", "спальные мешки", "батарейки", "свечи", "огнетушитель", "топор", "лопата", "экстремальный набор для выживания",
        "велосипед", "огниво", "леденцы", "шоколад", "настольные игры", "книги", "мыло", "сигареты", "бутылка водки", "жевательная резинка", "фильтр для воды", "книга с арбукой МОРЗЕ",
        "книга с языком жестов", "капканы", "паспорт", "теннисные ракетки", "шарики", "мусорные пакеты", "набор посуды", "кассовый аппарат", "микросхемы", "строительный набор", "палатка",
        "двигатель", "верёвки", "арбалет", "стрелы", "часы", "гамак", "фотографии земли с космоса", "использованный шприц", "игла и нитки", "кассета Макса Коржа", "перья", "кольцо с бриллиантом",
        "школьный альбом", "жидкость для розжига костра", "телефон", "керамическая ваза", "бутылки для воды")


    var actions = arrayListOf<String>("Сгенерировать новую катастрофу.", "Раскрыть любую характеристику любого игрока.", "Враг (который находится после вас (Вы не сможете попасть в бункер если ваш враг пройдет в бункер)).",
        "Друг (который находится после вас (Вы сможете пройти в бункер только если ваш друг пройдет в бункер)).", "Украсть хобби у другого игрока.",
        "Перегенирируйте любую вашу характеристику.", "Перегенирируйте профессии всех игроков.", "Поменяйтесь с игроком багажами.", "Перегенирируйте свое состояние здоровья.",
        "Ваш бункер находится под парком аттракционов.", "+1 слот в бункере.", "Сгенирировать себе новую профессию.", "В вашем багаже появляется еще один предмет.",
        "Ваш бункер находится около бункера который настроен негативно.", "Изменить свой багаж на новый.", "Вылечить любого игрока от любых недугов.",
        "Данная карта дает возможность вылечить тебя от любого недуга.", "Данная карта дает возможность вылечить твою фобию.",
        "Данная карта дает тебе возможность поменяться картой \"фобия\"", "Все игроки меняются картами \"профессия\" по часовой стрелке.",
        "Рядом с вами второй бункер и он настроен недоброжелательно.", "В 20 метрах от вашего бункера сохранился погреб с вином.",
        "Данная карта дает вам возможность поменяться любой характеристикой с любым игроком.", "Данная карта дает вам возможность поменяться любой характеристикой после вас.",
        "Данная карта дает вам возможность поменять ориентацию любого игрока на противоположную.", "Аннулирование всех профессий.")


    var bonus_items = arrayListOf<String>("Инструменты", "Газ-53", "Трактор", "Салон красоты", "Мастерская", "Библиотека",
        "Столовая",
        "Система автоматизации бункера в нерабочем состоянии", "Наличие поломок и неисправностей", "Некачественная проводка",
        "Теплицы и зерновые культуры", "Вентиляционные шахты", "Неглубокая шахта", "Кабинет", "Место для постройки небольшого здания",
        "Пустой склад",
        "Склад с провизией", "Место для готовки еды", "Тир", "Спортивный зал", "Генератор энергии", "Семена агрокультур", "Книги по выживанию",
        "Склад с едой", "Компьютер", "Радио-станция", "Оружейный склад", "Паяльная станция", "Стрельбище", "Метео-станция", "Карта местности",
        "Книги по робототехнике", "Лаборатория по исследованию", "Пособие по ремонту электрооборудования")

    var savedCatastText= hashMapOf<String, String>()

    var savedCharactsText=""

    var savedHeroes:MutableList<CharactItem>?=null
}