package com.djsk.challenges.persistence.enums;

public enum UserRole {
    ADMIN ("ADMIN"),
    VIEWER ("NORMAL");

    private final String roleName;

    UserRole(String role) {
        roleName = role;
    }

    public boolean equalsName(String name) {
        return roleName.equals(name);
    }

    public String toString() {
        return this.roleName;
    }
}
