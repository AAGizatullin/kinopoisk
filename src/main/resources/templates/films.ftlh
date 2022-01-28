<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>List of Films</title>
</head>
<body>
<h1>КИНОПОИСК</h1>
<h2>Добавление фильма</h2>
<form method="post" action="/films/add">
    <label>Название фильма
        <input name="name" placeholder="фильм">
    </label>
    <label>Жанр
        <input name="genre" placeholder="добавить жанр">
    </label>
    <label>Режиссер
        <input name="director" placeholder="добавить режиссера">
    </label>
    <label>Цена
        <input name="price" placeholder="установить цену">
    </label>
    <input type="submit" value="ДОБАВИТЬ">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>жанр</th>
        <th>режисер</th>
        <th>цена</th>
    </tr>
    <#list films as film>
        <tr>
            <td>${film.id}</td>
            <td>${film.name}</td>
            <td>${film.genre}</td>
            <td>${film.director}</td>
            <td>${film.price}</td>
            <td>
                <form method="post" action="/films/${film.id}/delete">
                    <input type="submit" value="УДАЛИТЬ">
                </form>
            </td>
            <td>
                <a href="films/${film.id}">Перейти к фильму</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>