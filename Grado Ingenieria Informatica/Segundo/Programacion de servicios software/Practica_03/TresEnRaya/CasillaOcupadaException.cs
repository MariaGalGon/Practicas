using System;
using System.Runtime.Serialization;

namespace PSS.mgg694.Practica_03
{
    [Serializable]
    public class CasillaOcupadaException : Exception
    {
        public CasillaOcupadaException()
        {
        }

        public CasillaOcupadaException(string message) : base(message)
        {
        }

        public CasillaOcupadaException(string message, Exception innerException) : base(message, innerException)
        {
        }

        protected CasillaOcupadaException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}