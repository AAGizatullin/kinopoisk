package org.example.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.web.form.FilmForm;
import org.example.web.form.FilmNameForm;
import org.example.web.model.Film;
import org.example.web.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FilmController {

    private static final String FILMS_ATTR = "films";

    private final FilmService filmService;

    @GetMapping("/films")
    public String findAllFilms(Model model) {
        List<Film> films = filmService.getAllFilms();
        model.addAttribute(FILMS_ATTR, films);
        return FILMS_ATTR;
    }

    @GetMapping("/films/{film-id}")
    public String findFilmById(Model model, @PathVariable("film-id") Integer filmId) {
        Film film = filmService.getFilm(filmId);
        model.addAttribute("film", film);
        return "film";
    }

    @PostMapping("/films/add")
    public String addFilm(FilmForm form) {
        filmService.addFilm(form);
        return "redirect:/films";
    }

    @PostMapping("/films/{film-id}/update")
    public String update(@PathVariable("film-id") int filmId, FilmForm filmForm) {
        filmService.update(filmId, filmForm);
        return "redirect:/films";
    }

    @PostMapping("/films/{film-id}/delete")
    public String deleteFilm(@PathVariable("film-id") Integer filmId) {
        filmService.deleteFilm(filmId);
        return "redirect:/films";
    }

    @GetMapping("/customer/{customer-id}/films")
    public String getFilmsByCustomer(@PathVariable("customer-id") Integer customerId, Model model) {
        List<Film> films = filmService.getFilmsByCustomer(customerId);
        model.addAttribute("filmsOfCustomer", films);
        model.addAttribute("customerId", customerId);
        return "customer_films";

    }

//    @PostMapping("/customer/{customer-id}/films")
//    public String addFilmFromCustomer(@PathVariable("customer-id") Integer customerId, FilmForm form){
//        filmsService.addFilmOfCustomer(form,customerId);
//        return "redirect:/customer/" + customerId + "/films";
//    }

    @GetMapping("/search")
    public String search(Model model) {
        if (model.getAttribute(FILMS_ATTR) == null) {
            model.addAttribute(FILMS_ATTR, Collections.emptyList());
        }
        return "search";
    }

    @GetMapping("/searchFilmByName")
    public String searchFilmByName(FilmNameForm form, Model model) {
        if (!form.getName().isBlank()) {
            List<Film> films = filmService.searchFilmByName(form.getName());
            model.addAttribute(FILMS_ATTR, films);
        }
        return search(model);
    }
}
