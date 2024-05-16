public class Hash {
    private double n=0.618033988;
    public int direccionar(int clave, int m){
        int direccion;
        double a=(double)(clave);
        a=a*this.n-Math.floor(a*this.n);
        direccion=(int)(m*a);
        System.out.println("La clave ingresada es: " + clave + ", El hasheo ingresado es: " + direccion);
        return direccion;
    }
}
