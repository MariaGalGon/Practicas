using System;
using System.Collections.Generic;
using System.Text;

namespace PSS.mgg694.Practica_03
{
    public interface IJugador : IEquatable<Jugador>
    {
        public string Nombre { get; set; }
        public bool Equals(Jugador other);
    }
}
