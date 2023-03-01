package lesson33.homework28.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Product {
    private long id;
    private String name;
    private BigDecimal price;
}
