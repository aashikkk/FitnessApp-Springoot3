package com.aashik.runners.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {
    // Compact Constructor
    public Run {
        if (!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed On must be before Started on");
        }
    }

}
