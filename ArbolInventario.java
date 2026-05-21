public class ArbolInventario {
    Producto raiz; // El punto de inicio del árbol

    public ArbolInventario() {
        this.raiz = null; // El inventario inicia vacío
    }

    // --- 1. MÉTODO INSERTAR (Recursivo) ---
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        // Si encontramos un espacio vacío, creamos el producto ahí
        if (actual == null) {
            return new Producto(id, nombre);
        }
        // Si el ID es menor, nos vamos por la rama izquierda
        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } 
        // Si el ID es mayor, nos vamos por la rama derecha
        else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        } 
        // Si es igual, no hacemos nada (no se permiten IDs duplicados)
        else {
            System.out.println("❌ Error: El ID " + id + " ya existe en el inventario.");
        }
        return actual;
    }

    // --- 2. MÉTODO RECORRIDO INORDEN (Ordenado de menor a mayor) ---
    public void recorridoInorden() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("\n--- Inventario Ordenado (Inorden) ---");
        inordenRecursivo(raiz);
        System.out.println("-------------------------------------");
    }

    private void inordenRecursivo(Producto nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierdo); // Primero visita los menores (Izquierda)
            System.out.println("ID: " + nodo.id + " | Producto: " + nodo.nombre); // Luego imprime la raíz
            inordenRecursivo(nodo.derecho); // Finalmente visita los mayores (Derecha)
        }
    }

    // --- 3. MÉTODO BUSCAR ---
    public void buscar(int id) {
        Producto encontrado = buscarRecursivo(raiz, id);
        if (encontrado != null) {
            System.out.println("✅ Producto encontrado -> ID: " + encontrado.id + " | Nombre: " + encontrado.nombre);
        } else {
            System.out.println("❌ El producto con ID " + id + " no existe.");
        }
    }

    private Producto buscarRecursivo(Producto actual, int id) {
        // Si llegamos a un espacio vacío o encontramos el ID, devolvemos el nodo
        if (actual == null || actual.id == id) {
            return actual;
        }
        // Si el ID que buscamos es menor, buscamos por la izquierda
        if (id < actual.id) {
            return buscarRecursivo(actual.izquierdo, id);
        }
        // Si es mayor, buscamos por la derecha
        return buscarRecursivo(actual.derecho, id);
    }
}