/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoTienda;

import java.util.*;
/**
 *
 * @author najma
 */
public class ProyectoTiendaOficial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
              
        // Caja inicial en 0
        double caja = 0;

        // Contadores
        int ventasRealizadas = 0;
        int comprasRealizadas = 0;
        double totalVentas = 0;
        double totalCompras = 0;
        double mayorGanancia = 0;
        double mayorGasto = 0;

        // Variables de productos
        double ventaAzucar = 30, compraAzucar = 25, vendidoAzucar = 0;
        double ventaAvena = 25, compraAvena = 20, vendidoAvena = 0;
        double ventaTrigo = 32, compraTrigo = 30, vendidoTrigo = 0;
        double ventaMaiz = 20, compraMaiz = 18, vendidoMaiz = 0;

        boolean cajaAbierta = false;
        boolean sistemaActivo = true;
        boolean primerDia = true;

        while (sistemaActivo) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Abrir Caja");
            System.out.println("2. Venta");
            System.out.println("3. Compra");
            System.out.println("4. Reportes");
            System.out.println("5. Cierre de Caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = sc.nextInt();

            if (opcion == 1) {
               if (!cajaAbierta) {
                if (primerDia) {
                caja = 0.0;
                primerDia = false;
                System.out.println("Primera apertura del día. Caja iniciada con Lps. 0.00");
                } else {
                    System.out.println("Caja reabierta con saldo anterior: Lps. " + caja);
                }
                cajaAbierta = true;
                } else {
                    System.out.print("Ingrese monto adicional a caja: ");
                    double adicional = sc.nextDouble();
                    caja += adicional;
                    System.out.println("Efectivo añadido. Caja ahora tiene: Lps. " + caja);
                }
            } 
            else if (opcion == 2) {
                if (!cajaAbierta) {
                    System.out.println("La caja esta cerrada. No puede vender.");
                } else {
                    System.out.println("\n=== Tipo de Cliente ====");
                    System.out.println("Tipo A - Puede comprar cualquier producto");
                    System.out.println("Tipo B - Solo puede comprar los productos con codigos 1 (Azucar), 2 (Avena) y 3 (Trigo)");
                    System.out.println("Tipo C - Solo puede comprar el producto con codigo 4 (Maiz)");
                    System.out.print("\nIngrese tipo de cliente (A, B, C): ");
                    char tipoCliente = sc.next().toUpperCase().charAt(0);
                    boolean seguirVendiendo = true;
                    double subtotalVenta = 0;

                    double ventaKgAzucar = 0, ventaSubtotalAzucar = 0;
                    double ventaKgAvena = 0, ventaSubtotalAvena = 0;
                    double ventaKgTrigo = 0, ventaSubtotalTrigo = 0;
                    double ventaKgMaiz = 0, ventaSubtotalMaiz = 0;

                    while (seguirVendiendo) {
                        System.out.println("\n=== Productos Disponibles ====");
                        System.out.println("Codigo || Producto || Precio Venta");
                        System.out.println("-------||----------||-------------");
                        System.out.println("1      || Azucar   || Lps. 30");
                        System.out.println("2      || Avena    || Lps. 25");
                        System.out.println("3      || Trigo    || Lps. 32");
                        System.out.println("4      || Maiz     || Lps. 20");
                        System.out.print("\nIngrese codigo de producto a vender (1-4): ");
                        int codigoProducto = sc.nextInt();
                        boolean puedeComprar = false;
                        double precioProducto = 0;
                        String nombreProducto = "";
                        boolean productoValido = true;

                        if (codigoProducto == 1) {
                            nombreProducto = "Azucar";
                            precioProducto = ventaAzucar;
                            if (tipoCliente == 'A' || tipoCliente == 'B') puedeComprar = true;
                        } 
                        else if (codigoProducto == 2) {
                            nombreProducto = "Avena";
                            precioProducto = ventaAvena;
                            if (tipoCliente == 'A' || tipoCliente == 'B') puedeComprar = true;
                        } 
                        else if (codigoProducto == 3) {
                            nombreProducto = "Trigo";
                            precioProducto = ventaTrigo;
                            if (tipoCliente == 'A' || tipoCliente == 'B') puedeComprar = true;
                        } 
                        else if (codigoProducto == 4) {
                            nombreProducto = "Maiz";
                            precioProducto = ventaMaiz;
                            if (tipoCliente == 'A' || tipoCliente == 'C') puedeComprar = true;
                        } 
                        else {
                            productoValido = false;
                            System.out.println("Codigo de producto invalido.");
                        }

                        if (productoValido) {
                            if (puedeComprar) {
                                System.out.println("Producto: " + nombreProducto + " - Precio: Lps. " + precioProducto);
                                System.out.print("Ingrese cantidad (kg): ");
                                double kg = sc.nextDouble();
                                double subtotal = precioProducto * kg;
                                subtotalVenta += subtotal;

                                if (codigoProducto == 1) {
                                    vendidoAzucar += kg; ventaKgAzucar += kg; ventaSubtotalAzucar += subtotal;
                                } else if (codigoProducto == 2) {
                                    vendidoAvena += kg; ventaKgAvena += kg; ventaSubtotalAvena += subtotal;
                                } else if (codigoProducto == 3) {
                                    vendidoTrigo += kg; ventaKgTrigo += kg; ventaSubtotalTrigo += subtotal;
                                } else if (codigoProducto == 4) {
                                    vendidoMaiz += kg; ventaKgMaiz += kg; ventaSubtotalMaiz += subtotal;
                                }

                            } else {
                                System.out.println("El cliente tipo " + tipoCliente + " no puede comprar este producto.");
                            }
                        }

                        String respuesta = "";
                        do {
                            System.out.print("Desea comprar otro producto? (si/no): ");
                            respuesta = sc.next();
                            if (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {
                                System.out.println("Opcion no valida. Ingrese 'si' o 'no'.");
                            }
                        } while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));

                        seguirVendiendo = respuesta.equalsIgnoreCase("si");
                    }

                    System.out.println("\n=== Detalle de la Venta ===");
                    if (ventaKgAzucar > 0) System.out.println("Producto: Azucar - " + ventaKgAzucar + " kg - Subtotal: Lps. " + ventaSubtotalAzucar);
                    if (ventaKgAvena > 0) System.out.println("Producto: Avena - " + ventaKgAvena + " kg - Subtotal: Lps. " + ventaSubtotalAvena);
                    if (ventaKgTrigo > 0) System.out.println("Producto: Trigo - " + ventaKgTrigo + " kg - Subtotal: Lps. " + ventaSubtotalTrigo);
                    if (ventaKgMaiz > 0) System.out.println("Producto: Maiz - " + ventaKgMaiz + " kg - Subtotal: Lps. " + ventaSubtotalMaiz);

                    double descuento = 0;
                    if (subtotalVenta >= 5000) descuento = subtotalVenta * 0.10;
                    else if (subtotalVenta >= 1000) descuento = subtotalVenta * 0.05;

                    double impuesto = subtotalVenta * 0.07;
                    double totalPagar = subtotalVenta + impuesto - descuento;

                    System.out.println("\n=== Factura Final ===");
                    System.out.printf("Subtotal: Lps. %.2f\n", subtotalVenta);
                    System.out.printf("Descuento: Lps. %.2f\n", descuento);
                    System.out.printf("Impuesto (7%%): Lps. %.2f\n", impuesto);
                    System.out.printf("TOTAL A PAGAR: Lps. %.2f\n", totalPagar);

                    caja += totalPagar;
                    totalVentas += totalPagar;
                    ventasRealizadas++;
                    if (totalPagar > mayorGanancia) mayorGanancia = totalPagar;

                    System.out.println("Venta registrada correctamente.");
                }
            } 
            else if (opcion == 3) {
                if (!cajaAbierta) {
                    System.out.println("La caja esta cerrada. No puede comprar.");
                } else {
                    System.out.println("\n === Tipo de Proveedor ===");
                    System.out.println("Tipo A - Solo provee los productos con codigos 1 (Azucar) y 4 (Maiz)");
                    System.out.println("Tipo B - Solo provee los productos con codigos 2 (Avena) y 3 (Trigo)");
                    System.out.println("Tipo C - Solo provee el producto con codigo 2 (Avena)");
                    System.out.print("\nIngrese tipo de proveedor (A, B, C): ");
                    char tipoProveedor = sc.next().toUpperCase().charAt(0);

                    boolean seguirComprando = true;
                    double subtotalCompra = 0;
                    double compraSubtotalAzucar = 0, compraSubtotalAvena = 0;
                    double compraSubtotalTrigo = 0, compraSubtotalMaiz = 0;
                    double compraKgAzucar = 0, compraKgAvena = 0;
                    double compraKgTrigo = 0, compraKgMaiz = 0;

                    while (seguirComprando) {
                        int codigoProducto;
                        boolean puedeVender = false;
                        double precioCompraProducto = 0;
                        String nombreProducto = "";
                        boolean productoValido = false;

                        do {
                            System.out.println("\n=== Productos Disponibles ===");
                            System.out.println("Codigo || Producto || Precio Compra");
                            System.out.println("-------||----------||--------------");
                            System.out.println("1      || Azucar   || Lps. 25");
                            System.out.println("2      || Avena    || Lps. (B) 20 (C) 22");
                            System.out.println("3      || Trigo    || Lps. 30");
                            System.out.println("4      || Maiz     || Lps. 18");
                            System.out.print("\nIngrese codigo de producto a comprar (1-4): ");
                            codigoProducto = sc.nextInt();
                            puedeVender = false;
                            productoValido = true;

                            if (codigoProducto == 1) {
                                nombreProducto = "Azucar";
                                precioCompraProducto = compraAzucar;
                                if (tipoProveedor == 'A') puedeVender = true;
                            } else if (codigoProducto == 2) {
                                nombreProducto = "Avena";
                                precioCompraProducto = (tipoProveedor == 'C') ? 22 : 20;
                                if (tipoProveedor == 'B' || tipoProveedor == 'C') puedeVender = true;
                            } else if (codigoProducto == 3) {
                                nombreProducto = "Trigo";
                                precioCompraProducto = compraTrigo;
                                if (tipoProveedor == 'B') puedeVender = true;
                            } else if (codigoProducto == 4) {
                                nombreProducto = "Maiz";
                                precioCompraProducto = compraMaiz;
                                if (tipoProveedor == 'A') puedeVender = true;
                            } else {
                                productoValido = false;
                                System.out.println("Codigo de producto invalido.");
                            }

                            if (productoValido && !puedeVender) {
                                System.out.println("El proveedor tipo " + tipoProveedor + " no vende este producto.");
                                System.out.print("Productos disponibles para este proveedor: \n");
                                if (tipoProveedor == 'A') System.out.println("1. Azucar,\n 4. Maiz");
                                if (tipoProveedor == 'B') System.out.println("2. Avena,\n 3. Trigo");
                                if (tipoProveedor == 'C') System.out.println("2. Avena");
                            }
                        } while (!productoValido || !puedeVender);

                        System.out.println("Producto: " + nombreProducto + " - Precio compra: Lps. " + precioCompraProducto);
                        System.out.print("Ingrese cantidad (kg): ");
                        double kgCompra = sc.nextDouble();
                        double totalCompra = kgCompra * precioCompraProducto;

                        if (totalCompra <= caja) {
                            caja -= totalCompra;
                            totalCompras += totalCompra;
                            comprasRealizadas++;
                            subtotalCompra += totalCompra;

                            if (codigoProducto == 1) {
                                compraKgAzucar += kgCompra;
                                compraSubtotalAzucar += totalCompra;
                            } else if (codigoProducto == 2) {
                                compraKgAvena += kgCompra;
                                compraSubtotalAvena += totalCompra;
                            } else if (codigoProducto == 3) {
                                compraKgTrigo += kgCompra;
                                compraSubtotalTrigo += totalCompra;
                            } else if (codigoProducto == 4) {
                                compraKgMaiz += kgCompra;
                                compraSubtotalMaiz += totalCompra;
                            }

                            if (totalCompra > mayorGasto) mayorGasto = totalCompra;

                            System.out.println("Compra realizada por Lps. " + totalCompra);
                        } else {
                            System.out.println("No se puede pagar la compra. Efectivo insuficiente.");
                        }

                        String respuesta = "";
                        do {
                            System.out.print("Desea comprar otro producto? (si/no): ");
                            respuesta = sc.next();
                            if (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {
                                System.out.println("Opcion no valida. Ingrese 'si' o 'no'.");
                            }
                        } while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));

                        seguirComprando = respuesta.equalsIgnoreCase("si");
                    }

                    System.out.println("\n=== Detalle de la Compra ===");
                    if (compraKgAzucar > 0) System.out.println("Producto: Azucar - " + compraKgAzucar + " kg - Subtotal: Lps. " + compraSubtotalAzucar);
                    if (compraKgAvena > 0) System.out.println("Producto: Avena - " + compraKgAvena + " kg - Subtotal: Lps. " + compraSubtotalAvena);
                    if (compraKgTrigo > 0) System.out.println("Producto: Trigo - " + compraKgTrigo + " kg - Subtotal: Lps. " + compraSubtotalTrigo);
                    if (compraKgMaiz > 0) System.out.println("Producto: Maiz - " + compraKgMaiz + " kg - Subtotal: Lps. " + compraSubtotalMaiz);

                    System.out.printf("\nTOTAL COMPRA REGISTRADA: Lps. %.2f\n", subtotalCompra);
                }
            } 
            else if (opcion == 4) {
                System.out.println("\n=== Reportes de la Tienda ===");
            System.out.println("Efectivo actual en caja: Lps. " + caja);
            System.out.println("Ventas realizadas: " + ventasRealizadas);
            System.out.println("Compras realizadas: " + comprasRealizadas);
            System.out.println("Volumen total de ventas: Lps. " + totalVentas);
            System.out.println("Volumen total de compras: Lps. " + totalCompras);

            // Margen de ganancia (ganancia bruta estimada)
            double margenGanancia = totalVentas - totalCompras;
            System.out.println("Margen de ganancia: Lps. " + margenGanancia);

            // Valor medio (promedio)
            double promedioVentas = (ventasRealizadas > 0) ? totalVentas / ventasRealizadas : 0;
            double promedioCompras = (comprasRealizadas > 0) ? totalCompras / comprasRealizadas : 0;
            System.out.println("Valor medio de venta: Lps. " + promedioVentas);
            System.out.println("Valor medio de compra: Lps. " + promedioCompras);

            // Mayor venta y mayor compra
            System.out.println("Venta con mayor ganancia individual: Lps. " + mayorGanancia);
            System.out.println("Compra con mas gasto: Lps. " + mayorGasto);

            // Producto mas vendido
            String productoEstrella = "";
            double maxKg = vendidoAzucar;

            productoEstrella = "Azucar";
            if (vendidoAvena > maxKg) {
                maxKg = vendidoAvena;
                productoEstrella = "Avena";
            }
            if (vendidoTrigo > maxKg) {
                maxKg = vendidoTrigo;
                productoEstrella = "Trigo";
            }
            if (vendidoMaiz > maxKg) {
                maxKg = vendidoMaiz;
                productoEstrella = "Maiz";
            }

            if (maxKg > 0) {
                System.out.println("Producto mas vendido del dia: " + productoEstrella + " con " + maxKg + " kg vendidos.");
            } else {
                System.out.println("Producto mas vendido del dia: Ninguno (aun no hay ventas).");
            }

            } 
            else if (opcion == 5) {
                if (!cajaAbierta) {
                    System.out.println("Caja ya esta cerrada.");
                } else {
                    System.out.println("Cierre de Caja:");
                    System.out.println("Total en caja: Lps. " + caja);
                    double maxDeposito = caja * 0.60;
                    double deposito = -1;
                    do {
                        System.out.print("Cuanto desea depositar al banco? (max 60%): ");
                        deposito = sc.nextDouble();
                        if (deposito > maxDeposito) {
                        System.out.println("No puede depositar mas del 60% (Max: " + maxDeposito + "). Intente de nuevo.");
                        }
                    } while (deposito > maxDeposito);
                        caja -= deposito;
                        System.out.println("Deposito realizado. Caja ahora tiene: Lps. " + caja);
                        // Reset contadores
                        ventasRealizadas = 0;
                        comprasRealizadas = 0;
                        totalVentas = 0;
                        totalCompras = 0;
                        mayorGanancia = 0;
                        mayorGasto = 0;
                        vendidoAzucar = 0;
                        vendidoAvena = 0;
                        vendidoTrigo = 0;
                        vendidoMaiz = 0;
                        cajaAbierta = false;
                    }
                } 
            else if (opcion == 6) {
                sistemaActivo = false;
                System.out.println("Saliendo del sistema...");
            } else {
                System.out.println("Opcion invalida.");
            }
        }

        sc.close();
    }
    
}