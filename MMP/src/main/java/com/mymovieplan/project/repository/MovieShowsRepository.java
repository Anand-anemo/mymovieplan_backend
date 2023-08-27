package com.mymovieplan.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mymovieplan.project.model.movie.MovieShows;

@Repository
public interface MovieShowsRepository extends JpaRepository<MovieShows,Integer> {
	
	  @Query(value = "SELECT DISTINCT ms.movieid , ms.movieshowsid , ms.end, ms.price_id ,ms.showid, ms.start  FROM movie_shows ms WHERE ms.start > CURRENT_DATE()", nativeQuery = true)
	    List<MovieShows> findAllUpComing();

	    @Query(value = "SELECT DISTINCT ms.movieid , ms.movieshowsid , ms.end, ms.price_id ,ms.showid,ms.start FROM movie_shows ms WHERE ms.start <= CURRENT_DATE() AND ms.end >= CURRENT_DATE()", nativeQuery = true)
	    List<MovieShows> findAllNowPlaying();

//	    @Query(value = "SELECT DISTINCT ON(ms.movieid) * FROM movie_shows ms WHERE ms.end >= CURRENT_DATE", nativeQuery = true)
//	    List<MovieShows> findAllNowPlayingAndUpComing();
	@Query(value = "SELECT DISTINCT ms.movieid , ms.movieshowsid , ms.end, ms.price_id ,ms.showid,ms.start  FROM mymovieplandb.Movie_Shows ms  WHERE ms.end >= CURRENT_DATE()", nativeQuery = true)
    List<MovieShows> findAllNowPlayingAndUpComing();

	    @Query(value = "SELECT DISTINCT ms.movieid , ms.movieshowsid , ms.end, ms.price_id ,ms.showid,ms.start FROM movie_shows ms WHERE ms.end < CURRENT_DATE()", nativeQuery = true)
	    List<MovieShows> findAllNotPlaying();
	    
	    @Query(value = "SELECT DISTINCT ms.movieid , ms.movieshowsid , ms.end, ms.price_id ,ms.showid,ms.start FROM movie_shows ms WHERE ms.start > CURRENT_DATE() ", nativeQuery = true)
	    List<MovieShows> findFewUpComing();

	    @Query(value = "SELECT DISTINCT ms.movieid , ms.movieshowsid , ms.end, ms.price_id ,ms.showid,ms.start FROM movie_shows ms WHERE ms.start <= CURRENT_DATE() AND ms.end >= CURRENT_DATE()", nativeQuery = true)
	    List<MovieShows> findFewNowPlaying();


}
