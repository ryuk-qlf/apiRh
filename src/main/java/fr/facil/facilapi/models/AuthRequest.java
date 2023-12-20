package fr.facil.facilapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AuthRequest {

    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private int permission;

}
