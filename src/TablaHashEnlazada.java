public class TablaHashEnlazada {
    private int M;
    private Nodo[] tabla;
    private Hash dispersion = new Hash();

    public TablaHashEnlazada(){
        this.M=97;
        this.tabla= new Nodo[this.M];
        for(int i=0; i<this.M; i++){
            this.tabla[i]=null;
        }
    }
    public boolean insertar(Socio socioCargado){
        int indice = dispersion.direccionar(socioCargado.getClave(), M);
        if(tabla[indice]==null){
            Nodo nodin = new Nodo(socioCargado);
            this.tabla[indice]= nodin;
            return true;
        }
        else{
            if(!this.buscarClave(indice, socioCargado.getClave())){
                Nodo nodaso = new Nodo(socioCargado);
                this.insertarAlFinal(indice, nodaso);
                return true;
            }
            else{
                return false;
            }
        }

    }
    public boolean buscarClave(int indice, int clavesuki){
        Nodo nodoActual= this.tabla[indice];
        while(nodoActual!=null){
            if(nodoActual.sos.getClave()== clavesuki){
                return true;
            }
            else{
                nodoActual=nodoActual.nodoSiguiente;
            }
        }
        return false;
    }

    public void insertarAlFinal (int indice, Nodo nuevo){
        Nodo actual= this.tabla[indice];
        Nodo anterior= null;
        while (actual!=null){
            anterior= actual;
            actual=actual.nodoSiguiente;
        }
        anterior.nodoSiguiente= nuevo;
    } 
    public boolean encontrarYDarDeBaja(int claveSocio){
        int indiceABuscar= this.dispersion.direccionar(claveSocio, this.M);
        if(this.tabla[indiceABuscar]==null){
            return false;
        }
        else{
            if(this.tabla[indiceABuscar].sos.getClave()==claveSocio){
                tabla[indiceABuscar]=tabla[indiceABuscar].nodoSiguiente;
                return true;
            }
            else{
                Nodo anterior = null;
                Nodo actual= tabla[indiceABuscar];
                while(actual!=null){
                    anterior=actual;
                    actual=actual.nodoSiguiente;
                    if(actual.sos.getClave()==claveSocio){
                        anterior.nodoSiguiente=actual.nodoSiguiente;
                        return true;
                    }
                }
                return false;
            }

        }

    }
    public boolean MostrarTodo(){
        Nodo actual;
        boolean a=false;
        for(int i=0;i<this.M;i++){
            if(this.tabla[i] != null){
                a=true;
                actual=this.tabla[i];
                System.out.println("Posicion N° "+i);
                while(actual!=null){
                    actual.sos.mostrarSocio();
                    actual=actual.nodoSiguiente;
                }
            }
        }
        return a;
    }
    public boolean buscarYMostrar(int clave){
        int indiceABuscar = this.dispersion.direccionar(clave, this.M);
        if(this.tabla[indiceABuscar]!=null){
            if(this.tabla[indiceABuscar].sos.getClave()==clave){
                this.tabla[indiceABuscar].sos.mostrarSocio();
                return true;
            }
            else{
                Nodo actual=this.tabla[indiceABuscar];
                while(actual!=null){
                    actual=actual.nodoSiguiente;
                    if(actual.sos.getClave()==clave){
                        actual.sos.mostrarSocio();
                        return true;
                    }
                }
                return false;
            }
        }
        else{
            return false;
        }

    }
}
