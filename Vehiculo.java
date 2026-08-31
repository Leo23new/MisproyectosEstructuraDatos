public class Vehiculo {
    private int anio;
    private double precio;

    public Vehiculo(int anio, double precio) {
        this.anio = anio;
        this.precio = precio;
    }
    public void mostrarInformacion() {
        System.out.println("Año: " + anio);
        System.out.println("Precio: " + precio);
    }

}
