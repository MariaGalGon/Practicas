using System.Collections.Generic;

namespace PSS.mgg694.Practica_03
{
    public class Tablero : ITablero
    {
        private int _tamano;
        private Ficha[,] _fichas;
        public int Tamano { get { return _tamano; } set { _tamano = value; } }
        public Ficha[,] Fichas { get { return _fichas; } }
        
        public Tablero(int dimensiones)
        {
            _tamano = dimensiones;
            _fichas = new Ficha[_tamano, _tamano];
        }

        public void insertarFicha(string posicion, Jugador jugador, string simbolo)
        {
            Ficha ficha = (Ficha)TresEnRayaFactory.CrearFicha(posicion, jugador, simbolo);
                        
            if(ficha.Fila < 0 || ficha.Columna < 0 || ficha.Fila > (_tamano - 1) || ficha.Columna > (_tamano - 1))
            {
                throw new FueraTableroException();
            }
            else
            {
                if(!(ReferenceEquals(_fichas[ficha.Fila, ficha.Columna], null)))
                {
                    throw new CasillaOcupadaException();
                }
                else
                {
                    _fichas[ficha.Fila, ficha.Columna] = ficha;
                }
            }

            bool hayHueco = false;
            for (int i = 0; i < _tamano; i++)
            {
                for (int j = 0; j < _tamano; j++)
                {
                    if (ReferenceEquals(_fichas[i, j], null))
                    {
                        hayHueco = true;
                        break;
                    }
                }
                if (hayHueco) break;
            }

            if (!hayHueco) throw new TableroLlenoException();
        }

        public Jugador comprobarGanador()
        {
            Jugador ganador;

            ganador = comprobarColumnas();
            if (ganador != null) return ganador;

            ganador = comprobarFilas();
            if (ganador != null) return ganador;

            ganador = comprobarDiagonal1();
            if (ganador != null) return ganador;

            ganador = comprobarDiagonal2();
            if (ganador != null) return ganador;

            return null;
        }

        private Jugador comprobarColumnas()
        {
            bool elementosSeguidos;
            bool mismoSimbolo;
            Ficha aux;

            for (int i = 0; i < _tamano; i++)
            {
                elementosSeguidos = true;
                aux = null;
                mismoSimbolo = true;

                for (int j = 0; j < _tamano; j++)
                {
                    if (ReferenceEquals(_fichas[j, i], null))
                    {
                        elementosSeguidos = false;
                        break;
                    }

                    if((!ReferenceEquals(aux, null)) && (!_fichas[j, i].Equals(aux)))
                    {                        
                        mismoSimbolo = false;
                        break;                        
                    }

                    aux = _fichas[j, i];
                }

                if (elementosSeguidos && mismoSimbolo) return _fichas[0, i].Jugador;
            }
            return null;
        }

        private Jugador comprobarFilas()
        {
            bool elementosSeguidos;
            bool mismoSimbolo;
            Ficha aux;

            for (int i = 0; i < _tamano; i++)
            {
                elementosSeguidos = true;
                aux = null;
                mismoSimbolo = true;

                for (int j = 0; j < _tamano; j++)
                {
                    if (ReferenceEquals(_fichas[i, j], null))
                    {
                        elementosSeguidos = false;
                        break;
                    }

                    if ((!ReferenceEquals(aux, null)) && (!_fichas[i, j].Equals(aux)))
                    {
                        mismoSimbolo = false;
                        break;
                    }

                    aux = _fichas[i, j];
                }

                if (elementosSeguidos && mismoSimbolo) return _fichas[i, 0].Jugador;
            }
            return null;
        }

        private Jugador comprobarDiagonal1()
        {            
            bool elementosSeguidos = true;
            bool mismoSimbolo = true;
            Ficha aux = null;
            
            for (int i = 0; i < _tamano; i++)
            {
                if (ReferenceEquals(_fichas[i, i], null))
                {
                    elementosSeguidos = false;
                    break;
                }

                if ((!ReferenceEquals(aux, null)) && (!_fichas[i, i].Equals(aux)))
                {
                    mismoSimbolo = false;
                    break;
                }

                aux = _fichas[i, i];
            }
            if (elementosSeguidos && mismoSimbolo) return _fichas[0, 0].Jugador;
            else return null;
        }

        private Jugador comprobarDiagonal2()
        {
            bool elementosSeguidos = true;
            bool mismoSimbolo = true;
            Ficha aux = null;

            for (int i = 0, j = (_tamano - 1); i < _tamano; i++, j--)
            {
                if (ReferenceEquals(_fichas[i, j], null))
                {
                    elementosSeguidos = false;
                    break;
                }

                if ((!ReferenceEquals(aux, null)) && (!_fichas[i, j].Equals(aux)))
                {
                    mismoSimbolo = false;
                    break;
                }

                aux = _fichas[i, j];
            }
            if (elementosSeguidos && mismoSimbolo) return _fichas[0, 2].Jugador;
            else return null;
        }

        public string mostrarTablero(Jugador[] jugadores)
        {            
            string mensaje = "┌───";
            for (int k = 1; k < (_tamano - 1); k++)
            {
                mensaje += "┬───";
            }
            mensaje += "┬───┐\n";

            for (int i = 0; i < _tamano; i++)
            {
                for(int j = 0; j < _tamano; j++)
                {
                    if (!(ReferenceEquals(_fichas[i, j], null)))
                    {
                        mensaje += "│ " + _fichas[i, j].Simbolo + " ";
                    }
                    else
                    {
                        mensaje += "│   ";
                    }
                                       
                }
                mensaje += "│\n";
                if (i != (_tamano - 1))
                {
                    mensaje += "├───";
                    for (int k = 1; k < (_tamano - 1); k++)
                    {
                        mensaje += "┼───";

                    }
                    mensaje += "┼───┤\n";
                }
            }
            mensaje += "└───";
            for (int k = 1; k < (_tamano - 1); k++)
            {
                mensaje += "┴───";
            }
            mensaje += "┴───┘";

            return mensaje;
        }

        public string mostrarGuia()
        {
            string mostrar = "┌─────";
            for(int k = 1; k < (_tamano - 1); k++)
            {
                mostrar += "┬─────";
            }
            mostrar += "┬─────┐\n";

            for (int i = 0; i < _tamano; i++)
            {
                for (int j = 0; j < _tamano; j++)
                {
                    mostrar += "│ " + i + "," + j + " ";
                }
                mostrar += "│\n";
                if (i != (_tamano - 1))
                {
                    mostrar += "├─────";
                    for (int k = 1; k < (_tamano - 1); k++)
                    {
                        mostrar += "┼─────";
                    }
                    mostrar += "┼─────┤\n";
                }
            }
            mostrar += "└─────";
            for (int k = 1; k < (_tamano - 1); k++)
            {
                mostrar += "┴─────";
            }
            mostrar += "┴─────┘";

            return mostrar;
        }
    }
}