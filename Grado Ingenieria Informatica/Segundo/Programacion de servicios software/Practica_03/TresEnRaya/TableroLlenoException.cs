using System;
using System.Runtime.Serialization;

namespace PSS.mgg694.Practica_03
{
    [Serializable]
    public class TableroLlenoException : Exception
    {
        public TableroLlenoException()
        {
        }

        public TableroLlenoException(string message) : base(message)
        {
        }

        public TableroLlenoException(string message, Exception innerException) : base(message, innerException)
        {
        }

        protected TableroLlenoException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}