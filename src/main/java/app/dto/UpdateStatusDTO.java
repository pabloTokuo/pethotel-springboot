package app.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateStatusDTO {
    private String newStatus;

    private LocalDate checkOutDate;

    private LocalDateTime checkOutTime;
}
