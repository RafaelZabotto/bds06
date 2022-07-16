package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private AuthService authService;

    @Transactional
    public ReviewDTO insert(ReviewDTO dto) {

        //Verificar se o usuário esta autenticado e retorna id do user.
        User userSession = authService.authenticated();

        Review review = new Review();
        review.setText(dto.getText());
        review.setMovie(new Movie(dto.getMovieId(), null, null, null, null, null));
        review.setUser(new User(userSession.getId(), null,null,null));
        reviewRepository.save(review);
        return new ReviewDTO(review, userSession);
    }

}
