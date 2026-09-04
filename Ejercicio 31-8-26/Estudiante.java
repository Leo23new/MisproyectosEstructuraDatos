
public class Estudiante {
    private String cedula;
    private String nombre;
    private double[]notas;

    public Estudiante(String cedula, String nombre, double nota1,double nota2,double nota3) {   
        this.cedula = cedula;
        this.nombre = nombre;
        this.notas = new double[3];
        this.notas[0] = nota1;
        this.notas[1] = nota2;
        this.notas[2] = nota3;
    }
    public String getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public double[] getNotas() {
        return notas;
    }
    public double promedioIndividual(){
        double suma=0;
        for(int i=0; i<notas.length; i++){
            suma+=notas[i];
        }
        return suma/notas.length;
    }

    

}
