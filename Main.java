import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();
        int opcion = -1;

        System.out.println("🌳 Bienvenido a Tree-Stock 🌳");

        while (opcion != 0) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario (Inorden)");
            System.out.println("3. Buscar Producto por ID");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el ID del producto (número): ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingresa el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    inventario.insertar(id, nombre);
                    System.out.println("✅ Producto registrado.");
                    break;
                case 2:
                    inventario.recorridoInorden();
                    break;
                case 3:
                    System.out.print("Ingresa el ID a buscar: ");
                    int idBuscar = scanner.nextInt();
                    inventario.buscar(idBuscar);
                    break;
                case 0:
                    System.out.println("👋 Saliendo de Tree-Stock. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("❌ Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}