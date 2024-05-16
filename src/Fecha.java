public class Fecha {
    int dia, mes, anio;
    public Fecha(int dia, int mes, int anio){
        this.anio=anio;
        this.dia=dia;
        this.mes=mes;
    }
    public void mostrarFecha(){
        System.out.println("Fecha: "+this.dia+"/"+this.mes+"/"+this.anio);
    }
}
