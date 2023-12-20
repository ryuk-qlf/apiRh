package fr.facil.facilapi.supplement.document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class position {

    private double x;

    private double y;

    private double height;

    private double width;

    public position(double x, double y, double height, double width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
}
