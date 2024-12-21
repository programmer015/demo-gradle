package com.thinkinnovative.demo_gradle.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="library_information")
public class LibraryInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookid")
    private Long bookID;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "genre")
    private String genre;
    @Column(name = "published_year")
    private Integer publishedYear;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "statusID")
    private StatusTable status;
    //    public Long getStatusID() {
//        return statusID;
//    }
//
//    public void setStatusID(Long statusID) {
//        this.statusID = statusID;
//    }

//    @Transient
//    @JsonProperty("status") // Map "status" from JSON payload
    // private Long statusID;

    public LibraryInformation() {
    }

    public LibraryInformation( String title, String author, String genre, Integer publishedYear, StatusTable status) {
        //this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishedYear = publishedYear;
        this.status = status;
    }
    public StatusTable getStatus() {
        return status;
    }

    public void setStatus(StatusTable status) {
        this.status = status;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

}
