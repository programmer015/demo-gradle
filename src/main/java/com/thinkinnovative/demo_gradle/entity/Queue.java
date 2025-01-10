package com.thinkinnovative.demo_gradle.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "queue")
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "queue_id")
    private Integer queue_id;

    private Integer member_id;


    @Column(name = "position")
    private Integer position;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", referencedColumnName = "bookid")
    private  LibraryInformation libraryInformation;
    public LibraryInformation getLibraryInformation() {
        return libraryInformation;

    }

    public void setLibraryInformation(LibraryInformation libraryInformation) {
        this.libraryInformation = libraryInformation;
    }



    public Queue( Integer member_id, Integer position, LibraryInformation libraryInformation) {
        //this.queue_id = queue_id;
        this.member_id = member_id;
        this.position = position;
        this.libraryInformation = libraryInformation;

    }

    public Queue() {
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public Integer getQueue_id() {
        return queue_id;
    }

    public void setQueue_id(Integer queue_id) {
        this.queue_id = queue_id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }


}
