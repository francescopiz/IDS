package com.unicam.ingdelsoftware.models.approvabili;

import java.util.Objects;

public record Posizione(double x, double y) {

    /**
     * crea una posizione date le due dimensioni x e y
     *
     * @param x coordinata x
     * @param y coordinata y
     */
    public Posizione {
    }

    /**
     * @return coordinata x
     */
    public double x() {
        return this.x;
    }

    /**
     * @return coordinata y
     */
    public double y() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posizione that = (Posizione) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}