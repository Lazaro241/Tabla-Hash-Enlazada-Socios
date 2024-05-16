/* Los elementos de la tabla son, a título de ejemplo, socios del club de montaña La Parra. Cada
socio se identifica con estos datos: número de socio, nombre completo, edad, sexo, fecha de alta.
Se elige como clave el número de socio, que es un entero en el rango de 101 a 1999. Actualmente,
el club tiene 94 socios, entonces la tabla dispersa se diseña con el tamaño de 97 posiciones (no
hay perspectivas de mucho crecimiento). El factor de carga, con este supuesto, estará en valores
próximos a uno.
La función hash utiliza el método de la multiplicación, genera valores dispersos entre 0 y 96.*/

import java.util.Scanner;

public class Main {
    public static void darDeAlta(Scanner t, TablaHashEnlazada tablecita){
        int claveSocio;
        String nombreIngresado;
        char sexo;
        int sexoAuxiliar;
        int diaIngresado, mesIngresado, anioIngresado;
        System.out.println("Ingrese el nombre completo del socio nuevo");
        nombreIngresado=t.nextLine();
        nombreIngresado=t.nextLine();
        System.out.println("Ingrese el sexo");
        System.out.println("1) Masculino");
        System.out.println("2) Femenino");
        sexoAuxiliar=t.nextInt();
        while (sexoAuxiliar!=1 && sexoAuxiliar!=2){
            System.out.println("Ingrese un valor válido");
            sexoAuxiliar=t.nextInt();
        }
        if (sexoAuxiliar==1){
            sexo='M';
        }
        else{
            sexo='F';
        }
        System.out.println("Ingrese el dia de alta del socio nuevo");
        diaIngresado=t.nextInt();
        while(diaIngresado<1 || diaIngresado>31){
            System.out.println("El valor del dia es inválido");
            diaIngresado=t.nextInt();
        }
        System.out.println("Ingrese el mes de alta del socio nuevo ");
        mesIngresado=t.nextInt();
        while(mesIngresado<1 || mesIngresado>12){
            System.out.println("El valor del mes es invalido");
            mesIngresado=t.nextInt();
        }
        System.out.println("Ingrese el año de alta del socio nuevo");
        anioIngresado=t.nextInt();
        Fecha fecha = new Fecha(diaIngresado, mesIngresado, anioIngresado);
        System.out.println("Ingrese el número de socio(DATO UNICO)");
        claveSocio=t.nextInt();
        Socio socioIngresado = new Socio(claveSocio, nombreIngresado, sexo, fecha);
        while(!tablecita.insertar(socioIngresado)){
            System.out.println("Ingrese de nuevo el número de socio, está repetido");
            socioIngresado.ClaveSocio=t.nextInt();
        }
        System.out.println("Socio ingresado con éxito");
    }
    public static void darDeBaja(Scanner t, TablaHashEnlazada tablecita){
        int socio;
        System.out.println("Ingrese el número de socio al cúal desea eliminar");
        socio= t.nextInt();
        if(!tablecita.encontrarYDarDeBaja(socio)){
            System.out.println("No existe el socio introducido");
        } else {
            System.out.println("Socio eliminado con exito");
        }
    }
    public static void mostrar(TablaHashEnlazada tabla){
        if(!tabla.MostrarTodo()){
            System.out.println("La tabla esta vacia.");
        }
    }
    public static void buscarSocio(TablaHashEnlazada tabla, Scanner t){
        System.out.println("Ingrese el numero de socio a buscar...");
        if(!tabla.buscarYMostrar(t.nextInt())){
            System.out.println("No existe un socio con esta clave");
        } else {
            System.out.println("Socio encontrado con exito");
        }
    }
    public static void main(String[] args){
        int menu=0;
        TablaHashEnlazada tablaDeSocios = new TablaHashEnlazada();
        Scanner teclado  = new Scanner(System.in);
        do{
            System.out.println("Ingrese Una opción");
            System.out.println("1) Dar de alta un socio de La Parra");
            System.out.println("2) Dar de baja un socio de La Parra");
            System.out.println("3) Buscar un socio de La Parra");
            System.out.println("4) Mostrar todos los socios de La Parra");
            System.out.println("5) Salir del programa");
            menu= teclado.nextInt();
            switch(menu){
                case 1:
                    darDeAlta(teclado, tablaDeSocios);
                break;
                case 2:
                    darDeBaja(teclado, tablaDeSocios);
                break;
                case 3:
                    buscarSocio(tablaDeSocios, teclado);
                break;
                case 4:
                    mostrar(tablaDeSocios);
                break;
                case 5:
                    System.out.println("Fin del programa");
                break;
                default:
                    System.out.println("Opción inválida");
                break;
            }
        }while(menu!=5);

    
    }
}
