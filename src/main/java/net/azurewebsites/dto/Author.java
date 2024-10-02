package net.azurewebsites.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private int id;
    private int idBook;
    private String firstName;
    private String lastName;
}
