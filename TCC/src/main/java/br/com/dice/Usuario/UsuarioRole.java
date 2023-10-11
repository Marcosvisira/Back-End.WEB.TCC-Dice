package br.com.dice.Usuario;

public enum UsuarioRole {
    ADMIN("admin"),
    USER("usuario");

    private String role;

    UsuarioRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
