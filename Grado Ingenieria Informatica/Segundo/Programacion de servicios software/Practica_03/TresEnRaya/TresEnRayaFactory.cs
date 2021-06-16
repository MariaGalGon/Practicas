using System;
using System.Collections.Generic;
using System.Text;

namespace PSS.mgg694.Practica_03
{
    public class TresEnRayaFactory
    {
        public static IFicha CrearFicha(string posicion, Jugador jugador, string simbolo)
        {
            return new Ficha(posicion, jugador, simbolo);
        }

        public static IFicha CrearFicha()
        {
            return new Ficha();
        }

        public static IJugador CrearJugador(string nombre, int numero, string[] simbolo)
        {
            return CrearJugador(nombre + numero, simbolo);
        }

        public static IJugador CrearJugador(string nombre, string[] simbolo)
        {
            return new Jugador(nombre, simbolo);
        }

        public static IJugador CrearJugador(string nombre, int numero)
        {
            return CrearJugador(nombre + numero);
        }

        public static IJugador CrearJugador(string nombre)
        {
            return new Jugador(nombre);
        }

        public static ITablero CrearTablero(int tamano)
        {
            return new Tablero(tamano);
        }
    }
}
