using System;
using System.Threading;
using TresEnRayaConsola;

namespace PSS.mgg694.Practica_03
{
    public class TresEnRaya
    {
        public int EmpiezaPartida(int jugadores)
        {
            Random random = new Random(DateTime.Now.Millisecond);
            int[] valores = new int[jugadores];
            int indiceMax = 0;

            for(int i = 0; i < valores.Length; i++)
            {
                valores[i] = random.Next(0, 5);
                if(valores[i] > valores[indiceMax]) indiceMax = i;
            }

            return indiceMax;
        }

        static void Main(string[] args)
        {            
            //Seleccion idioma
            Console.WriteLine("Escoge un idioma(1)/Choose an idiom(2)/Choisissez une langue(3):");
            switch (Console.ReadLine())
            {
                case "2":
                    Thread.CurrentThread.CurrentUICulture = new System.Globalization.CultureInfo("en-GB");
                    break;
                case "3":
                    Thread.CurrentThread.CurrentUICulture = new System.Globalization.CultureInfo("fr");
                    break;
                default:
                    break;
            }
            Console.WriteLine();

            //Seleccion numero jugadores
            bool errorEntrada = false;
            int numJugadores = 0;
            do
            {
                Console.WriteLine(Idioma.NumeroJugadores + " (min = 2):");
                numJugadores = Convert.ToInt32(Console.ReadLine());
                if (numJugadores < 2) errorEntrada = true;
                else errorEntrada = false;
            } while (errorEntrada);
            Console.WriteLine();

            //Introduccion nombre de los jugadores y sus fichas
            Jugador[] jugadores = new Jugador[numJugadores];
            Jugador jugador = null;
            for (int i = 1; i <= numJugadores; i++)
            {
                Console.WriteLine(Idioma.PedirJugador + i + Idioma.Nombre);
                string nombre = Console.ReadLine();
                Console.WriteLine(Idioma.PedirSimbolo);
                string fichas = Console.ReadLine();
                string[] simbolos = fichas.Split(",");
                if (String.IsNullOrWhiteSpace(nombre)) jugador = (Jugador)TresEnRayaFactory.CrearJugador(Idioma.Jugador, i, simbolos);
                else jugador = (Jugador)TresEnRayaFactory.CrearJugador(nombre, simbolos);
                jugadores[i - 1] = jugador;
            }
            Console.WriteLine();

            //Muestra los nombres de los jugadores
            string mensaje = Idioma.Bienvenida;
            for(int i = 0; i < jugadores.Length; i++)
            {
                mensaje += jugadores[i].Nombre;
                if (i == (jugadores.Length - 2)) mensaje += Idioma.Y;
                else if (i < (jugadores.Length - 2)) mensaje += ", ";
            }
            Console.WriteLine(mensaje);
            Console.WriteLine();

            //Seleccion dimensiones del tablero
            int tamano = 0;
            do
            {
                Console.WriteLine(Idioma.Dimensiones + " (min = 2):");
                string dimension = Console.ReadLine();
                try
                {
                    int indiceX = dimension.IndexOf('x');
                    if (indiceX != -1) tamano = Convert.ToInt32(dimension.Substring(0, indiceX));
                    else tamano = Convert.ToInt32(dimension);
                }
                catch (FormatException)
                {
                    errorEntrada = true;
                    Console.WriteLine(Idioma.NoLetra);
                    continue;
                }
                if (tamano < 2) errorEntrada = true;
                else errorEntrada = false;
            } while (errorEntrada);
            Tablero tablero = (Tablero)TresEnRayaFactory.CrearTablero(tamano);
            Console.WriteLine();

            //Muestra como se deben poner las posiciones
            Console.WriteLine(Idioma.NombrarPosiciones);            
            Console.WriteLine(tablero.mostrarGuia());
            Console.WriteLine();

            //Decide quien empieza la partida
            TresEnRaya partida = new TresEnRaya();
            int elegido = partida.EmpiezaPartida(jugadores.Length);
            Console.WriteLine(Idioma.Comienza + jugadores[elegido].Nombre);
            Console.WriteLine();

            //Empieza la partida
            bool acabar = false;
            int turno = 0;
            int indiceFicha = 0;
            string eleccion = "";
            Jugador ganador = null;
            string posicion = "";
            string fila = "";
            string columna = "";
            errorEntrada = false;
            while (!acabar)
            {
                if (turno > 0)
                {
                    Console.Clear();
                    Console.WriteLine(tablero.mostrarGuia());
                }
                Console.WriteLine(tablero.mostrarTablero(jugadores));

                do
                {
                    Console.WriteLine(jugadores[elegido].Nombre + Idioma.EscogerFicha + jugadores[elegido].ToStringSimbolos() + ":");
                    eleccion = Console.ReadLine();
                    indiceFicha = jugadores[elegido].indiceSimbolo(eleccion);
                    if (indiceFicha == -1)
                    {
                        Console.WriteLine(Idioma.FichaIncorrecta);
                        errorEntrada = true;                        
                    }
                    else
                    {
                        errorEntrada = false;
                    }                    
                } while (errorEntrada);
                                
                do {
                    Console.WriteLine(jugadores[elegido].Nombre + "(" + jugadores[elegido].SimbolosFicha[indiceFicha] + ")" + Idioma.ElegirFila);
                    fila = Console.ReadLine();
                    Console.WriteLine(jugadores[elegido].Nombre + "(" + jugadores[elegido].SimbolosFicha[indiceFicha] + ")" + Idioma.ElegirColumna);
                    columna = Console.ReadLine();
                    if (!(Char.IsNumber(Convert.ToChar(fila)) && Char.IsNumber(Convert.ToChar(columna))))
                    {
                        Console.WriteLine(Idioma.NoLetra);
                        errorEntrada = true;
                    }
                    else
                    {
                        errorEntrada = false;
                        posicion = "(" + fila + "," + columna + ")";
                    }
                } while (errorEntrada);

                try
                {
                    tablero.insertarFicha(posicion, jugadores[elegido], jugadores[elegido].SimbolosFicha[indiceFicha]);
                }
                catch (TableroLlenoException)
                {
                    Console.WriteLine(Idioma.TableroLleno);
                    acabar = true;
                }
                catch (CasillaOcupadaException)
                {
                    Console.WriteLine(Idioma.Casilla + posicion + Idioma.PosicionOcupada);
                    acabar = false;
                    turno = 0;
                    continue;
                }
                catch (FueraTableroException)
                {
                    Console.WriteLine(Idioma.Casilla + posicion + Idioma.FueraTablero);
                    acabar = false;
                    turno = 0;
                    continue;
                }
                
                ganador = tablero.comprobarGanador();
                if (!(ReferenceEquals(ganador, null)))
                {
                    Console.WriteLine(tablero.mostrarTablero(jugadores));
                    Console.WriteLine(ganador.Nombre + Idioma.Ganador);
                    acabar = true;
                }
                else if (acabar)
                {
                    Console.WriteLine(Idioma.NoGanador);
                }

                elegido++;
                if (elegido >= jugadores.Length) elegido = 0;
                turno++;
            }
        }
    }
}