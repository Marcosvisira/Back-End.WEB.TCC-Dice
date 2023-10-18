package br.com.dice.Usuario;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum UsuarioRole {
    ADMIN("admin"),
    USER("usuario");

    @Enumerated(EnumType.ORDINAL)
    private String role;

    UsuarioRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}