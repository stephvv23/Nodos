/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ucr.ac.cr.nodosenlazados;

/**
 *
 * @author Stephanie
 */
public class NodosEnlazados {

    //private Nodo nodoPrimero, nodoUltimo, nuevoNodo, nodoIndice;
    private Nodo nodoPrimero, nodoUltimo;

    NodosEnlazados() {

    }

    //*************1*********************
    //METODO SEGUN LA GUIA
    public void agregarInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (esVacio()) {
            nodoUltimo = nuevoNodo;
        }
        nuevoNodo.setSiguiente(nodoPrimero);//ENLAZA NUEVO NODO AL FRENTE DE LA LISTA
        nodoPrimero = nuevoNodo; //Mueve primero y apunta al nuevo nodo
    }
    //METODO MIO*************
//    public void agregarItem(int dato) {
//        if (esVacio() == true) {
//            nodoPrimero = new Nodo(dato);
//            nodoUltimo = nodoPrimero;
//        } else {
//            nuevoNodo = new Nodo(dato, nodoPrimero);
//            nodoPrimero = nuevoNodo;
//        }
//    }

    //*************2*********************
    public boolean esVacio() {
        return (nodoPrimero == null) ? true : false;
    }
//    public boolean esVacio() {
//        if (nodoPrimero == null) {
//            return true;
//        }
//        return false;
//    }

    //*************3*********************
    public void agregarFinal(int dato) {
        if (esVacio() == true) {
            agregarInicio(dato);
        } else {
            nodoUltimo.setSiguiente(new Nodo(dato));
            nodoUltimo = nodoUltimo.getSiguiente();
        }

    }
//      public void agregarFinal(int dato) {
//        if (esVacio() == true) {
//            nodoPrimero = new Nodo(dato);
//            nodoUltimo = nodoPrimero;
//        } else {
//            nuevoNodo = new Nodo(dato);
//            nodoUltimo.setSiguiente(nuevoNodo);
//            nodoUltimo = nodoUltimo.getSiguiente();
//        }
//
//    }

    //*************4*********************
    public Nodo buscarLista(int datoBuscar) {
        Nodo indice;
        for (indice = nodoPrimero; indice != null; indice = indice.getSiguiente()) {
            if (datoBuscar == indice.getDato()) {
                return indice;
            }
        }
        return null;
    }
//     public boolean buscar(int dato) {
//        if (esVacio() == false) {
//            if (nodoUltimo.getDato() == dato) {
//                return true;
//            } else {
//                nodoIndice = nodoPrimero;
//                do {
//                    if (nodoIndice.getDato() == dato) {
//                        return true;
//                    } else {
//                        nodoIndice = nodoIndice.getSiguiente();
//                    }
//
//                } while (nodoIndice != null);
//            }
//        }
//        return false;
//    }

    //*************5*********************
    public void insertarDespues(int datoABuscar, int dato) {
        Nodo nuevo = new Nodo(dato);
        Nodo anterior;
        anterior = buscarLista(datoABuscar);
        if (anterior != null) {
            if (anterior == nodoUltimo) {
                nodoUltimo = nuevo;
            }
            nuevo.setSiguiente(anterior.getSiguiente());
            anterior.setSiguiente(nuevo);
        }
    }

    //*************6*********************
    public Nodo getAnterior(int datoABuscar) {
        Nodo indice = nodoPrimero;
        Nodo anterior = nodoPrimero;
        while (indice != null) {
            if (datoABuscar == indice.getDato()) {
                return anterior;
            }
            anterior = indice;
            indice = indice.getSiguiente();
        }
        return null;
    }

    //*************7*********************
    public void insertarAntes(int datoABuscar, int dato) {
        if (datoABuscar == nodoPrimero.getDato()) {
            agregarInicio(dato);
        } else {
            Nodo nuevo = new Nodo(dato);
            Nodo anterior;
            anterior = getAnterior(datoABuscar);
            if (anterior != null) {
                nuevo.setSiguiente(anterior.getSiguiente());
                anterior.setSiguiente(nuevo);
            }
        }
    }
//    public void insertarAntes(int datoABuscar, int dato){
//        Nodo nuevo = new Nodo(dato);
//        Nodo anterior;
//        anterior = buscarLista(datoABuscar);
//        if(anterior != null){
//            if(anterior == nodoUltimo){
//                nodoUltimo=nuevo;
//            }
//            nuevo.setSiguiente(anterior.getSiguiente());
//            anterior.setSiguiente(nuevo);
//        }
//    }

    //*************8*********************
//    lo deje como yo lo tenia
    public String imprimir() {
        Nodo nodoIndice = nodoPrimero;
        String message = "";

        if (esVacio() == true) {
            message = "La lista esta vacia";
        } else {
            do {
                message += "[" + nodoIndice.getDato() + "]";
                nodoIndice = nodoIndice.getSiguiente();
            } while (nodoIndice != null);
        }

        return message;
    }

    //*************9*********************
    public void eliminar(int datoAEliminar) {
        Nodo actual = nodoPrimero;
        Nodo anterior = null;
        boolean encontrado = false;
        while ((actual != null) && (!encontrado)) {
            encontrado = (actual.getDato() == datoAEliminar);
            if (!encontrado) {
                anterior = actual;
                actual = actual.getSiguiente();
            }

        }
        if (actual != null) {
            if (actual == nodoPrimero) {
                nodoPrimero = actual.getSiguiente();

            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }
            actual = null;
        }
    }

    public void eliminarExplicado(int datoAEliminar) {
        Nodo actual = nodoPrimero;  // Inicializa el nodo actual como el primer nodo de la lista
        Nodo anterior = null;  // Inicializa el nodo anterior como nulo
        boolean encontrado = false;  // Inicializa la variable encontrado como falso

        // Mientras que el nodo actual no sea nulo y el nodo no haya sido encontrado
        while ((actual != null) && (!encontrado)) {
            encontrado = (actual.getDato() == datoAEliminar);  // Comprueba si el dato del nodo actual es igual al dato a eliminar
            if (!encontrado) {  // Si no se ha encontrado el dato a eliminar
                anterior = actual;  // El nodo anterior se actualiza al nodo actual
                actual = actual.getSiguiente();  // El nodo actual se mueve al siguiente nodo en la lista
            }
        }

        // Si se encontró el nodo con el dato a eliminar
        if (actual != null) {
            if (actual == nodoPrimero) {  // Si el nodo a eliminar es el primer nodo de la lista
                nodoPrimero = actual.getSiguiente();  // Actualiza el primer nodo de la lista al siguiente nodo
            } else {  // Si el nodo a eliminar no es el primer nodo de la lista
                anterior.setSiguiente(actual.getSiguiente());  // Enlaza el nodo anterior al siguiente nodo del nodo a eliminar
            }
            actual = null;  // Libera la referencia al nodo a eliminar
        }
    }

//    public boolean eliminar(int dato) {
//
//        if (esVacio() == false) {
//            if (this.buscar(dato) != false) {
//                nodoIndice = nodoPrimero;
//
//                if (nodoPrimero.getDato() == dato) {
//                    if (nodoPrimero.getSiguiente() != null) {
//                        nodoPrimero = nodoPrimero.getSiguiente();
//                        return true;
//                    } else {
//                        nodoPrimero = null;
//                        nodoUltimo = null;
//                    }
//                }
//
//                do {
//                    if (nodoIndice.getSiguiente().getDato() != dato) {
//                        nodoIndice = nodoIndice.getSiguiente();
//                    }
//
//                } while (nodoIndice.getSiguiente().getDato() != dato);
//
//                if (nodoIndice.getSiguiente() == nodoUltimo) {
//                    nodoIndice.setSiguiente(null);
//                    return true;
//                } else {
//                    nodoIndice.setSiguiente(nodoIndice.getSiguiente().getSiguiente());
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    public void vaciar() {
        nodoPrimero = null;
        nodoUltimo = null;
    }

    public String imprimirUltimo() {
        String message = "";
        if (nodoUltimo == null) {
            message = "Ultimo esta vacio";
        } else {
            message += "[" + nodoUltimo.getDato() + "]";
        }
        return message;
    }

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        NodosEnlazados nodosEnlazados = new NodosEnlazados();
        nodosEnlazados.agregarFinal(100);
        nodosEnlazados.agregarInicio(1);
        nodosEnlazados.agregarInicio(2);
        System.out.println(nodosEnlazados.imprimir());
        nodosEnlazados.eliminar(2);
        System.out.println(nodosEnlazados.imprimir());
    }

}
