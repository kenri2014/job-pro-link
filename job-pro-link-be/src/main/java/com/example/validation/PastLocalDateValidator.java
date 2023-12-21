package com.example.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

/**
     * {@link PastLocalDate} 対応するバリデーター
     */
    public class PastLocalDateValidator implements ConstraintValidator<PastLocalDate, LocalDate> {

        @Override
        public void initialize(PastLocalDate futureLocalDate) {

        }

        @Override
        public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
            return localDate.isBefore(LocalDate.now());
        }
    }


