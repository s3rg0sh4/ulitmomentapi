package com.ulitmoment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="scores")
@Data
@NoArgsConstructor
public class Score {
    @Id
    private Long id;
    private Short score;


}
