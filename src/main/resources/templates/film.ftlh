<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${film.name}</title>
</head>
<body>
<h3>Название фильма - ${film.name}</h3>
<h3>Жанр - ${film.genre}</h3>
<h3>Режисер - ${film.director}</h3>
<h3>Цена - ${film.price}</h3>
<br>
<form method="post" action="/films/${film.id}/update">
    <label>
        Название фильма: <input name="name" value="${film.name}">
    </label>
    <label>
        Жанр: <input name="genre" value="${film.genre}">
    </label>
    <label>
        Режисер: <input name="director" value="${film.director}">
    </label>
    <label>
        Цена: <input name="price" value="${film.price}">
    </label>
    <input type="submit" value="СОХРАНИТЬ">
</form>
<td>
    <a href="/films" action="/films">Перейти к добавлению</a>
</td>
</body>
</html>