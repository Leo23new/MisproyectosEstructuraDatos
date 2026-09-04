public class Main {
    public static void main(String[]args){
        int n=20;
        ListaEstudiantes lista= new ListaEstudiantes(n);
        Estudiante estudiante1= new Estudiante("1","Juan",7.5,7.0,9.0);
        Estudiante estudiante2= new Estudiante("2","Pedro",8.5,9.0,7.0);
        Estudiante estudiante3= new Estudiante("3","Maria",9.5,8.0,9.0);

        lista.insertar(0, estudiante1);
        lista.insertar(1, estudiante2);
        lista.insertar(2, estudiante3);

        Estudiante encontrado=lista.buscarPorCedula("2");
        if(encontrado != null){
            System.out.println("Estudiante encontrado:"+encontrado.getNombre());
        }else{
            System.out.println("Estudiante no encontrado");
        }
        System.out.println("Promedio de Juan:"+estudiante1.promedioIndividual());
        System.out.println("Promedio de Pedro:"+estudiante2.promedioIndividual());
        System.out.println("Promedio de Maria:"+estudiante3.promedioIndividual());
        
        System.out.println("Cantidad de aprobados: " + lista.contarAprobados());

        Estudiante mejor = lista.mayorPromedio();

        if (mejor != null) {
         System.out.println("Mayor promedio: " + mejor.getNombre());
        System.out.println("Promedio: " + mejor.promedioIndividual());
        }       
        }
        
    }

