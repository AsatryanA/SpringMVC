package am.basic.springTest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, message = "Name must be more then 3 characters")
    @NotBlank(message = "Name must not be blank")
    private String name;

    @Size(min = 16, message = "Number must be more then 16 characters")
    @NotBlank(message = "Number must not be blank")
    private int number;


    @Size(min = 3, max = 3, message = "Number must be more then 3 characters")
    @NotBlank(message = "CVV must not be blank")
    private int cvv;

    @Column(name = "user_id", nullable = false)
    @NotBlank()
    private int userId;
}
