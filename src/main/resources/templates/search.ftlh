<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Поиск</title>
</head>
<body>
<h1>КИНОПОИСК</h1>
<h2>Поиск фильмов</h2>
<form method="get" action="/searchFilmByName">
    <label>Введите название
        <input name="name" placeholder="фильм">
    </label>
    <input type="submit" value="ПОИСК">
</form>
<table>
    <#list films as film>
        <tr>
            <td>${film.id}</td>
            <td>${film.name}</td>
            <td>${film.genre}</td>
            <td>${film.director}</td>
            <td>${film.price}</td>
        </tr>
    </#list>
</table>
</body>
</html>