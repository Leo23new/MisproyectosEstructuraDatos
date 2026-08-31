public class Auto extends Vehiculo {
    private String marca;
    private String modelo;

    public Auto(int anio, double precio, String marca, String modelo) {
        super(anio, precio);
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
    }

}
