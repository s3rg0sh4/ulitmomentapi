package com.ulitmoment.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name="files")
@Data
@NoArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
}