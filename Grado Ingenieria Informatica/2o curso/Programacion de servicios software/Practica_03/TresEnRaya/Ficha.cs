using System;
using System.Diagnostics.CodeAnalysis;

namespace PSS.mgg694.Practica_03
{
    public class Ficha: IFicha
    {
        private int _fila;
        private int _columna;
        private Jugador _jugador;
        private string _simbolo;

        public int Fila { get { return _fila; } set { _fila = value; } }
        public int Columna { get { return _columna; } set { _columna = value; } }
        public string Simbolo { get { return _simbolo; } set { _simbolo = value; } }

        public string Posicion {
            get
            {
                return "(" + _fila + "," + _columna + ")";
            }
            set
            {                
                int coma = value.IndexOf(',');

                int quitarFil = coma - 1;
                string fila = value.Substring(1, quitarFil);
                _fila = int.Parse(fila);

                int quitarCol = (value.Length - 2) - coma;
                string columna = value.Substring(coma + 1, quitarCol);
                _columna = int.Parse(columna);
            }
        }

        public Jugador Jugador { get { return _jugador; } set{ _jugador = value; } }

        public Ficha()
        {
        }

        public Ficha(string posicion, Jugador jug, string simbolo)
        {
            Posicion = posicion;
            Jugador = jug;
            _simbolo = simbolo;
        }

        public bool Equals(Ficha other)
        {
            if (ReferenceEquals(other, null)) return false;
             else return _simbolo.Equals(other._simbolo);
        }

        public int CompareTo(Ficha other)
        {
            if (ReferenceEquals(other, null)) return 1;
            if (Fila == other.Fila) return Columna.CompareTo(other.Columna);
            else return Fila.CompareTo(other.Fila);
        }
    }
}