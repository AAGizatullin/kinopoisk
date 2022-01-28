package org.example.web.service;

import org.example.web.form.FilmForm;
import org.example.web.model.Film;

import java.util.List;

public interface FilmService {

    List<Film> getAllFilms();

    Film getFilm(Integer filmId);

    void addFilm(FilmForm form);

    void update(int filmId, FilmForm filmForm);

    void deleteFilm(Integer filmId);

    List<Film> getFilmsByCustomer(Integer customerId);

    List<Film> searchFilmByName(String name);

    //void addFilmOfCustomer(FilmForm form, Integer customerId);
}
