# Microservice
Тестовое задание
===========================================
БД
![image](https://user-images.githubusercontent.com/55935107/171861738-551950dd-c163-4296-b438-9359385c546d.png)
============================================
Запросы
============================================
Авторизация по ключу (Неверный ключ - 401 без тела)
![image](https://user-images.githubusercontent.com/55935107/171861970-5a7add81-67bd-4c54-b630-310490981db3.png)

Ключ верный, но не указан снилс (400 + Описание ошибки)
![image](https://user-images.githubusercontent.com/55935107/171862314-a9bfc6fd-4e42-476f-a735-c07c71dfbead.png)

Ключ верный и не верный, но несуществующий метод (405)
![image](https://user-images.githubusercontent.com/55935107/171862590-d6c24337-1199-497f-a7e5-c1701bb5879b.png)
Далее запросы с верной авторизацией

Не правильно указан снилс (404)
![image](https://user-images.githubusercontent.com/55935107/171864029-23c06ec3-c864-49f1-a028-d2c82f045550.png)


Все верно (200)

![image](https://user-images.githubusercontent.com/55935107/171864413-34099230-9991-420b-b86a-799157a3c179.png)
![image](https://user-images.githubusercontent.com/55935107/171864467-b8096f46-5386-4b3f-bf9d-027652c98ec4.png)
=====
Описание сервиса на OpenAPI на YAML
=====
![image](https://user-images.githubusercontent.com/55935107/171864673-2662c05b-50a2-4124-b522-38e109abba12.png)


