package dev.j3c.model.helpers;

public enum PetType {

    DOG("Dog"),
    CAT("Cat"),
    RABBIT("Rabbit"),
    FISH("Fish"),
    BIRD("Bird");

    private final String type;

    PetType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
