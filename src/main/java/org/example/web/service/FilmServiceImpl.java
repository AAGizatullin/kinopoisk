package org.example.web.service;

import lombok.RequiredArgsConstructor;
import org.example.web.form.FilmForm;
import org.example.web.model.Film;
import org.example.web.repository.CustomerRepository;
import org.example.web.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final CustomerRepository customerRepository;

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film getFilm(Integer filmId) {
        return filmRepository.findById(filmId).orElseThrow();
    }

    @Override
    public void addFilm(FilmForm form) {
        Film film = Film.builder()
                .name(form.getName())
                .genre(form.getGenre())
                .director(form.getDirector())
                .price(form.getPrice())
                .build();
        filmRepository.save(film);
    }

    @Override
    public void update(int filmId, FilmForm filmForm) {
        Film film = filmRepository.findById(filmId).orElseThrow();
        film.setName(filmForm.getName());
        film.setGenre(filmForm.getGenre());
        film.setDirector(filmForm.getDirector());
        film.setPrice(filmForm.getPrice());
        filmRepository.save(film);
    }

    @Override
    public void deleteFilm(Integer filmId) {
        filmRepository.deleteById(filmId);
    }

    @Override
    public List<Film> getFilmsByCustomer(Integer customerId) {
        return filmRepository.findAllByCustomer_Id(customerId);
    }

    //    @Override
//    public void addFilmOfCustomer(FilmForm form, Integer customerId) {
//        Film film = Film.builder()
//                .name(form.getName())
//                .genre(form.getGenre())
//                .director(form.getDirector())
//                .price(form.getPrice())
//                .build();
//        Customer customer = customerRepository.getById(customerId);
//        film.setCustomer(customer);
//        filmsRepository.save(film);
//   }
    @Override
    public List<Film> searchFilmByName(String name) {
        return filmRepository.searchByName(name);
    }
}
