<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Films</title>
</head>
<body>
<h1>Фильмы покупателя</h1>
<table>
<tr>
    <th>ID</th>
    <th>Название</th>
    <th>Жанр</th>
    <th>Режисер</th>
    <th>Цена</th>
</tr>
<#list filmsOfCustomer as film>
    <tr>
        <td>${film.id}</td>
        <td>${film.name}</td>
        <td>${film.genre}</td>
        <td>${film.director}</td>
        <td>${film.price}</td>
    </tr>
</#list>
</table>
<#--<h1>Добавить фильм</h1>-->
<#--<form method="post" action="/customer/${customerId}/films">-->
<#--    <label>Название фильма-->
<#--        <input name="name" placeholder="фильм">-->
<#--    </label>-->
<#--    <label>Жанр-->
<#--        <input name="genre" placeholder="добавить жанр">-->
<#--    </label>-->
<#--    <label>Режиссер-->
<#--        <input name="director" placeholder="добавить режиссера">-->
<#--    </label>-->
<#--    <label>Цена-->
<#--        <input name="price" placeholder="добавить цену">-->
<#--    </label>-->
<#--    <input name="customerId" type="hidden" value="${customerId}">-->
<#--    <input type="submit" value="ДОБАВИТЬ">-->
<#--</form>-->
</body>
</html>