public class Socio {
    public int ClaveSocio;
    private String nombreCompleto;
    private char sexo;
    private Fecha fechaDeAlta;

    public Socio(int claveSocio, String nombreCompleto, char sex, Fecha saas){
        this.ClaveSocio=  claveSocio;
        this.nombreCompleto= nombreCompleto;
        this.fechaDeAlta= saas;
        this.sexo= sex;
    }

    public int getClave(){
        return this.ClaveSocio;
    }
    public void mostrarSocio(){
        System.out.println("Nombre: " + this.nombreCompleto);
        System.out.println("Número de socio: " + this.ClaveSocio);
        System.out.println("Sexo: " + this.sexo );
        this.fechaDeAlta.mostrarFecha();
        System.out.println("------------------------");
    }
}
