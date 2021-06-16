using System;
using System.Collections.Generic;
using System.Text;

namespace PSS.mgg694.Practica_03
{
    public interface IFicha : IEquatable<Ficha>, IComparable<Ficha>
    {
        public int Fila { get; set; }
        public int Columna { get; set; }
        public string Posicion { get; set; }
        public Jugador Jugador { get; set; }
        public bool Equals(Ficha other);
        public int CompareTo(Ficha other);
    }
}
