package ru.practicum.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class InFutureValidator implements ConstraintValidator<InFuture, LocalDateTime> {
    private int offset;

    @Override
    public void initialize(InFuture constraintAnnotation) {
        offset = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        return value == null || value.isAfter(LocalDateTime.now().plusHours(offset));
    }
}
