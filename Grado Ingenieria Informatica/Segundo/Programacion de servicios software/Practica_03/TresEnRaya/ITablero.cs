using System;
using System.Collections.Generic;
using System.Text;

namespace PSS.mgg694.Practica_03
{
    public interface ITablero
    {
        public int Tamano { get; set; }
        public Ficha[,] Fichas { get; }
        public string mostrarGuia();
    }
}
