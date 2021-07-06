package com.booking.Booking.entities;

import java.util.*;
import javax.persistence.*;

import com.booking.Booking.enums.Movie_Language;
import com.fasterxml.jackson.annotation.*;

@Entity
public class Movie {
	
	// Movie Id
	@Id
	@Column(name = "MovieId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long MovieId;
	
	// Movie Title
	@Column(name = "Title", length=256 , nullable = false)
	private String Title;
	
	// Movie Description
	@Column(name = "Description", length=512 , nullable = false)
	private String Description;
	
	// Movie Duration
	@Column(name = "Duration")
	@Temporal(TemporalType.TIME)
	private Date Duration;
	
	// Movie Language (Hindi/English)
	@Column(name = "MovieLanguage")
	@Enumerated(EnumType.STRING)
	private Movie_Language MovieLanguage;
	
	// Movie Release Date
	@Column(name = "ReleaseDate")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date ReleaseDate;
	
	// Movie Country (Movie Release Country)
	@Column(name = "Country", length=64 , nullable = false)
	private String Country;
	
	// One to Many Relation between Movie and Shows (One movie have multiple shows)
	@OneToMany(mappedBy = "Show", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Show> Shows;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(long movieId, String title, String description, Date duration, Movie_Language movieLanguage,
			Date releaseDate, String country, List<Show> shows) {
		super();
		MovieId = movieId;
		Title = title;
		Description = description;
		Duration = duration;
		MovieLanguage = movieLanguage;
		ReleaseDate = releaseDate;
		Country = country;
		Shows = shows;
	}

	public long getMovieId() {
		return MovieId;
	}

	public void setMovieId(long movieId) {
		MovieId = movieId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDuration() {
		return Duration;
	}

	public void setDuration(Date duration) {
		Duration = duration;
	}

	public Movie_Language getMovieLanguage() {
		return MovieLanguage;
	}

	public void setMovieLanguage(Movie_Language movieLanguage) {
		MovieLanguage = movieLanguage;
	}

	public Date getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public List<Show> getShows() {
		return Shows;
	}

	public void setShows(List<Show> shows) {
		Shows = shows;
	}

	@Override
	public String toString() {
		return "Movie [MovieId=" + MovieId + ", Title=" + Title + ", Description=" + Description + ", Duration="
				+ Duration + ", MovieLanguage=" + MovieLanguage + ", ReleaseDate=" + ReleaseDate + ", Country="
				+ Country + ", Shows=" + Shows + "]";
	}

	
	//

	
	
	
}
