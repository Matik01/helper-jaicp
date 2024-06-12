require: slotfilling/slotFilling.sc
    module = sys.zb-common
theme: /

    state: Start
        q!: $regex<start>
        a: Начнём!
    
    state: hello 
        q!: *hello 
        q!: *(привет/здравствуй*/~добрый (~утро/~день/~вечер/~ночь))*
        random:
            a: Добро пожаловать! Вы можете спросить о погоде или курсе валют.
            a: Привет, я ваш бот-помощник. Спросите меня о погоде или курсе валют!
    
    state: weather
        q!: *weather
        q!: *(погода/какая погода*/прогноз погоды/погода сегодня*/какая погода*)*
        a: Прогноз погоды на сегодня: Ясно, 25°C.

    state: currency
        q!: *currency
        q!: *(курс валют/валюта/курс доллара и евро/курс евро и доллара/какой курс*)*
        a: Курс валют на сегодня: 1 USD = 75 RUB, 1 EUR = 85 RUB.

    state: NoMatch
        event!: noMatch
        a: Я не понял ваш запрос:"{{$request.query}}".