package com.ulitmoment.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="exercise")
@Data
@NoArgsConstructor
public class Exercise {
    @Id
    private Long id;

    private Short score;

    @ManyToOne
    private User user;
    @ManyToOne
    private Topic topic;
}
