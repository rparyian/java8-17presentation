package com.example.java817presentation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class AutoBiography {
    Optional<School> school;
}
