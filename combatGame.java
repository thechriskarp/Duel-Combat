import java.util.Scanner;
import java.util.Random;

public class combatGame {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Random azar = new Random();

        int vidaJugador = 100;
        int vidaRival = 100;

        System.out.println("⚔️ ¡Bienvenido a Duel Combat! ⚔️");

        while (vidaJugador > 0 && vidaRival > 0) {
            System.out.println("\n-------------------------------");
            System.out.println("Tu Vida: " + vidaJugador + " | Vida Rival: " + vidaRival);
            
            int accion = 0;
            boolean opcionValida = false;
            int contadorErrores = 0; // Para rastrear cuántas veces falla

            while (!opcionValida) {
                System.out.println("1. Ataque Rápido (Seguro)");
                System.out.println("2. Ataque Cargado (Riesgoso)");
                System.out.print("Elige tu movimiento (1 o 2): ");
                
                if (lector.hasNextInt()) {
                    accion = lector.nextInt();
                    if (accion == 1 || accion == 2) {
                        opcionValida = true;
                    } else {
                        contadorErrores++;
                        if (contadorErrores >= 2) {
                            System.out.println("❌ Por personas como tu el shampoo trae instrucciones. Vuelve a intentarlo.");
                        } else {
                            System.out.println("❌ Error: '" + accion + "' no es una opción valida (¿acaso no lees las opciones? No te creas xd) Inténtalo de nuevo (1 o 2).");
                        }
                    }
                } else {
                    contadorErrores++;
                    if (contadorErrores >= 2) {
                        System.out.println("❌ Por personas como tu el shampoo trae instrucciones. Vuelve a intentarlo.");
                    } else {
                        System.out.println("❌ Error: ¡Debes ingresar un numero!");
                    }
                    lector.next(); 
                }
            }

            int dañoJugador = 0;
            if (accion == 1) {
                dañoJugador = azar.nextInt(10) + 5;
            } else {
                dañoJugador = azar.nextInt(25);
            }

            if (dañoJugador > 0) {
                vidaRival -= dañoJugador;
                System.out.println("💥 ¡Acertaste! Hiciste " + dañoJugador + " de daño.");
            } else {
                System.out.println("💨 ¡Fallaste el golpe!");
            }

            if (vidaRival > 0) {
                int dañoRival = azar.nextInt(12) + 3;
                vidaJugador -= dañoRival;
                System.out.println("⚠️ El rival contraataca y te quita " + dañoRival + " de vida.");
            }
        }

        if (vidaJugador > 0) {
            System.out.println("\n🏆 ¡VICTORIA! Eres un crack.");
        } else {
            System.out.println("\n💀 DERROTADO... Inténtalo de nuevo.");
        }
    }
              }
