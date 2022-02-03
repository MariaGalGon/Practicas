using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace PSS.mgg694.Practica_03
{
    [TestClass]
    public class TresEnRayaTest
    {
        [TestMethod]
        public void Constructor_JugadorPorDefecto()
        {
            Jugador jugador1 = (Jugador)TresEnRayaFactory.CrearJugador("Jugador", 1);
            Assert.AreEqual("Jugador1", jugador1.Nombre);

            Jugador jugador2 = (Jugador)TresEnRayaFactory.CrearJugador("Jugador", 2);
            Assert.AreEqual("Jugador2", jugador2.Nombre);
        }

        [TestMethod]
        public void Constructor_JugadorConNombreFactoria()
        {
            Jugador jugador = (Jugador)TresEnRayaFactory.CrearJugador("Juan");

            Assert.AreEqual("Juan", jugador.Nombre);
        }

        [TestMethod]
        public void Constructor_JugadorConNombreYSimbolosFactoria()
        {
            string[] simbolo = { "X", "O"};
            Jugador jugador = (Jugador)TresEnRayaFactory.CrearJugador("Juan", simbolo);

            Assert.IsNotNull(jugador);
        }

        [TestMethod]
        public void Constructor_JugadorConNombrePropiedad()
        {
            Jugador jugador = new Jugador { Nombre = "Juan" };

            Assert.AreEqual("Juan", jugador.Nombre);
        }

        [TestMethod]
        public void Constructor_JugadorPorDefectoYNombre()
        {
            Jugador jugador1 = (Jugador)TresEnRayaFactory.CrearJugador("Ana");
            Assert.AreEqual("Ana", jugador1.Nombre);

            Jugador jugador2 = (Jugador)TresEnRayaFactory.CrearJugador("Jugador", 2);
            Assert.AreEqual("Jugador2", jugador2.Nombre);
        }

        [TestMethod]
        public void Constructor_JugadorEquals_False()
        {
            Jugador j1 = (Jugador)TresEnRayaFactory.CrearJugador("A");
            Jugador j2 = (Jugador)TresEnRayaFactory.CrearJugador("P");

            bool noIguales = j1.Equals(j2);
            Assert.IsFalse(noIguales);
        }

        [TestMethod]
        public void Constructor_JugadorEquals_True()
        {
            Jugador j1 = (Jugador)TresEnRayaFactory.CrearJugador("A");
            Jugador j2 = (Jugador)TresEnRayaFactory.CrearJugador("A");

            bool iguales = j1.Equals(j2);
            Assert.IsTrue(iguales);
        }

        [TestMethod]
        public void Constructor_TableroDimensiones()
        {
            Tablero t = (Tablero)TresEnRayaFactory.CrearTablero(3);

            Assert.AreEqual(3, t.Tamano);
        }

        [TestMethod]
        public void Constructor_Ficha()
        {
            Ficha f = (Ficha)TresEnRayaFactory.CrearFicha();

            Assert.IsNotNull(f);
        }

        [TestMethod]
        public void Ficha_Posicion()
        {
            Ficha f = new Ficha { Posicion = "(1,1)" };

            Assert.AreEqual("(1,1)", f.Posicion);
            Assert.AreEqual(1, f.Fila);
            Assert.AreEqual(1, f.Columna);
        }

        [TestMethod]
        public void Ficha_Equals_True()
        {
            Jugador jugador1 = (Jugador)TresEnRayaFactory.CrearJugador("Pepe");
            Ficha f1 = (Ficha)TresEnRayaFactory.CrearFicha("(2,2)", jugador1, "X");
            Ficha f2 = (Ficha)TresEnRayaFactory.CrearFicha("(2,2)", jugador1, "X");

            bool iguales = f1.Equals(f2);
            Assert.IsTrue(iguales);
        }

        [TestMethod]
        public void Ficha_Equals_False()
        {
            Jugador jugador1 = (Jugador)TresEnRayaFactory.CrearJugador("Lola");
            Ficha f1 = (Ficha)TresEnRayaFactory.CrearFicha("(2,2)", jugador1, "X");
            Ficha f2 = (Ficha)TresEnRayaFactory.CrearFicha("(2,2)", jugador1, "O");

            bool noIguales = f1.Equals(f2);
            Assert.IsFalse(noIguales);
        }

        [TestMethod]
        public void Ficha_CompareTo_Mayor()
        {
            Jugador jugador1 = (Jugador)TresEnRayaFactory.CrearJugador("Lola");
            Ficha f1 = (Ficha)TresEnRayaFactory.CrearFicha("(2,2)", jugador1, "X");
            Ficha f2 = (Ficha)TresEnRayaFactory.CrearFicha("(0,2)", jugador1, "O");

            int comparacion = f1.CompareTo(f2);
            Assert.IsTrue(comparacion > 0);
        }

        [TestMethod]
        public void Ficha_CompareTo_Menor()
        {
            Jugador jugador1 = (Jugador)TresEnRayaFactory.CrearJugador("Lola");
            Ficha f1 = (Ficha)TresEnRayaFactory.CrearFicha("(1,2)", jugador1, "X");
            Ficha f2 = (Ficha)TresEnRayaFactory.CrearFicha("(2,2)", jugador1, "O");

            int comparacion = f1.CompareTo(f2);
            Assert.IsTrue(comparacion < 0);
        }

        [TestMethod]
        public void TresEnRaya_JugadorComienza()
        {
            TresEnRaya partida = new TresEnRaya();
            Jugador[] jugadores = { (Jugador)TresEnRayaFactory.CrearJugador("Jugador", 1), (Jugador)TresEnRayaFactory.CrearJugador("Jugador", 2) };

            Assert.IsNotNull(partida.EmpiezaPartida(jugadores.Length));
        }

        [TestMethod]
        public void Tablero_InsertarFicha_True()
        {
            Tablero t = (Tablero)TresEnRayaFactory.CrearTablero(3);
            Jugador j = (Jugador)TresEnRayaFactory.CrearJugador("Jugador", 1);
            t.insertarFicha("(1,1)", j, "X");

            Assert.AreEqual("(1,1)", t.Fichas[1,1].Posicion);
        }

        [TestMethod]
        public void Tablero_CasillasVacias_Null()
        {
            Tablero t = (Tablero)TresEnRayaFactory.CrearTablero(3);  

            Assert.IsNull(t.Fichas[1,1]);
        }

        [TestMethod]
        [ExpectedException(typeof(FueraTableroException))]
        public void Tablero_InsertarFicha_FueraTableroException()
        {
            Tablero t = (Tablero)TresEnRayaFactory.CrearTablero(3);
            Jugador j = (Jugador)TresEnRayaFactory.CrearJugador("Jugador", 1);
            t.insertarFicha("(-2,1)", j, "X");

            Assert.Fail("Deberia lanzar la excepcion FueraTableroException");
        }

        [TestMethod]
        [ExpectedException(typeof(CasillaOcupadaException))]
        public void Tablero_InsertarFicha_CasillaOcupadaException()
        {
            Tablero t = (Tablero)TresEnRayaFactory.CrearTablero(3);
            Jugador j1 = (Jugador)TresEnRayaFactory.CrearJugador("Jugador", 1);
            Jugador j2 = (Jugador)TresEnRayaFactory.CrearJugador("Jugador", 2);
            t.insertarFicha("(1,1)", j1, "X");
            t.insertarFicha("(1,1)", j2, "O");

            Assert.Fail("Deberia lanzar la excepcion CasillaOcupadaException");
        }

        [TestMethod]
        [ExpectedException(typeof(TableroLlenoException))]
        public void Tablero_InsertarFicha_TableroLlenoException()
        {
            Tablero t = (Tablero)TresEnRayaFactory.CrearTablero(3);
            Jugador j1 = (Jugador)TresEnRayaFactory.CrearJugador("Jugador", 1);
            t.insertarFicha("(0,0)", j1, "X");
            t.insertarFicha("(0,1)", j1, "X");
            t.insertarFicha("(0,2)", j1, "X");
            t.insertarFicha("(1,1)", j1, "X");
            t.insertarFicha("(1,0)", j1, "X");
            t.insertarFicha("(1,2)", j1, "X");
            t.insertarFicha("(2,0)", j1, "X");
            t.insertarFicha("(2,1)", j1, "X");
            t.insertarFicha("(2,2)", j1, "X");
            t.insertarFicha("(0,3)", j1, "X");

            Assert.Fail("Deberia lanzar la excepcion TableroLlenoException");
        }

        [TestMethod]
        public void Tablero_ComprobarGanadorFila_True()
        {
            Tablero t = (Tablero)TresEnRayaFactory.CrearTablero(3);
            Jugador j1 = new Jugador { Nombre = "Ana"};
            Jugador j2 = new Jugador { Nombre = "Maria"};

            t.insertarFicha("(0,0)", j1, "X");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(1,1)", j2, "O");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(0,2)", j1, "X");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(2,0)", j2, "O");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(0,1)", j1, "X");
            Assert.AreEqual(j1, t.comprobarGanador());            
        }

        [TestMethod]
        public void Tablero_ComprobarGanadorColumna_True()
        {
            Tablero t = (Tablero)TresEnRayaFactory.CrearTablero(3);
            Jugador j1 = new Jugador { Nombre = "Pepe" };
            Jugador j2 = new Jugador { Nombre = "Luis" };

            t.insertarFicha("(0,1)", j1, "X");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(1,0)", j2, "O");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(1,1)", j1, "X");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(1,2)", j2, "O");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(2,1)", j1, "X");
            Assert.AreEqual(j1, t.comprobarGanador());
        }

        [TestMethod]
        public void Tablero_ComprobarGanadorDiagonal_True()
        {
            Tablero t = (Tablero)TresEnRayaFactory.CrearTablero(3);
            Jugador j1 = new Jugador { Nombre = "Enrique" };
            Jugador j2 = new Jugador { Nombre = "Luisa" };

            t.insertarFicha("(0,2)", j1, "O");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(0,0)", j2, "X");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(1,1)", j1, "O");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(2,1)", j2, "X");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(2,0)", j1, "O");
            Assert.AreEqual(j1, t.comprobarGanador());
        }

        [TestMethod]
        public void Tablero_ComprobarGanadorDistintaFicha_Null()
        {
            Tablero t = (Tablero)TresEnRayaFactory.CrearTablero(3);
            Jugador j1 = new Jugador { Nombre = "Ana" };
            Jugador j2 = new Jugador { Nombre = "Maria" };

            t.insertarFicha("(0,0)", j1, "X");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(1,1)", j2, "O");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(0,2)", j1, "-");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(2,0)", j2, "O");
            Assert.IsNull(t.comprobarGanador());

            t.insertarFicha("(0,1)", j1, "R");
            Assert.IsNull(t.comprobarGanador());
        }
    }
}
