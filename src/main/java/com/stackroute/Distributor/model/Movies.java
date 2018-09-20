package com.stackroute.Distributor.model;

import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Movies {
	
	String movieId;
	String movieName;
	String movieDescription;
	String movieGenre;
	String movieReleaseDate;
	String movieLocation;
	

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(String movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	public String getMovieLocation() {
		return movieLocation;
	}

	public void setMovieLocation(String movieLocation) {
		this.movieLocation = movieLocation;
	}



	

	public Movies(String movieId, String movieName, String movieDescription, String movieGenre, String movieReleaseDate,
			String movieLocation, String movieVotes) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.movieGenre = movieGenre;
		this.movieReleaseDate = movieReleaseDate;
		this.movieLocation = movieLocation;
		
	}
	
public Movies() {
	
}

@Override
public String toString() {
	return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", movieDescription=" + movieDescription
			+ ", movieGenre=" + movieGenre + ", movieReleaseDate=" + movieReleaseDate + ", movieLocation="
			+ movieLocation +"]";
}

}
