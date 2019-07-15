package com.github.brelok.movie;

import com.github.brelok.configuration.BaseEntity;
import com.github.brelok.hall.Hall;
import com.github.brelok.ticket.Ticket;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(length = 50)
    private String type;
    private LocalDate displayStart;
    private LocalDate displayend;
    private Integer lenght;
    private Double rating;

    @ManyToMany
    @JoinTable(name = "movie_hall",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "hall_id"))
    private Set<Hall> halls = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "movie_ticket",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "ticket_id"))
    private Set<Ticket> tickets = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDisplayStart() {
        return displayStart;
    }

    public void setDisplayStart(LocalDate displayStart) {
        this.displayStart = displayStart;
    }

    public LocalDate getDisplayend() {
        return displayend;
    }

    public void setDisplayend(LocalDate displayend) {
        this.displayend = displayend;
    }

    public Integer getLenght() {
        return lenght;
    }

    public void setLenght(Integer lenght) {
        this.lenght = lenght;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", displayStart=" + displayStart +
                ", displayend=" + displayend +
                ", lenght=" + lenght +
                '}';
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Set<Hall> getHalls() {
        return halls;
    }

    public void setHalls(Set<Hall> halls) {
        this.halls = halls;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
