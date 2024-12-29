package com.thinkinnovative.demo_gradle.entity;

import jakarta.persistence.*;

@Entity
@Table(name="library_information")
public class LibraryInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookid")
    private Integer bookID;
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
    @Column(name = "stock", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer stock = 0;
   @ManyToOne
   @JoinColumn(name = "in_queue", nullable = false, referencedColumnName = "queue_id")
   private Queue inqueue;

    public Queue getInqueue() {
        return inqueue;
    }

    public void setInqueue(Queue inqueue) {
        this.inqueue = inqueue;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }


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

    public LibraryInformation( String title, String author, String genre, Integer publishedYear, StatusTable status, Queue inqueue) {
        //this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishedYear = publishedYear;
        this.status = status;
        this.inqueue = inqueue;

    }
    public StatusTable getStatus() {
        return status;
    }

    public void setStatus(StatusTable status) {
        this.status = status;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
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
