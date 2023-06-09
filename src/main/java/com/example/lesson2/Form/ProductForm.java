package com.example.lesson2.Form;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ProductForm {

    @NotEmpty
    @Length(min = 1, max = 50)
    private String ProductName;

    @NotNull
    @Digits(integer = 10, fraction = 0)
    @Max(Integer.MAX_VALUE)
    @Min(0)
    private int ProductPrice;
}
