using System;
using System.Diagnostics.CodeAnalysis;

namespace PSS.mgg694.Practica_03
{
    public class Jugador: IJugador
    {
        private string _nombre;
        private string[] _simbolosFicha;
        public string Nombre { get { return _nombre; } set { _nombre = value; } }
        public string[] SimbolosFicha { get { return _simbolosFicha; } }

        public Jugador()
        {
        }

        public Jugador(string nombre)
        {
            _nombre = nombre;
        }

        public Jugador(string nombre, string[] simbolos)
        {
            _nombre = nombre;
            _simbolosFicha = simbolos;
        }

        public bool Equals(Jugador other)
        {
            return Nombre.Equals(other.Nombre);
        }

        public string ToStringSimbolos()
        {
            string mensaje = "(";
            for (int i = 0; i < _simbolosFicha.Length; i++)
            {
                mensaje += _simbolosFicha[i];
                if (i < _simbolosFicha.Length - 1) mensaje += ", ";
            }
            return mensaje + ")";
        }

        public int indiceSimbolo(string x)
        {
            for(int i = 0; i < _simbolosFicha.Length; i++)
            {
                if (x.Equals(_simbolosFicha[i])) return i;
            }
            return -1;
        }
    }
}