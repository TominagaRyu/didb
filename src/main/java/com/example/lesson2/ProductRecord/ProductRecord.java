package com.example.lesson2.ProductRecord;

import jakarta.validation.constraints.Digits;

public record ProductRecord(int id, String name , int price) {

}
