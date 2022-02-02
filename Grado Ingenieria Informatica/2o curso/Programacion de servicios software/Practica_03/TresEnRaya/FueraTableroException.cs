using System;
using System.Runtime.Serialization;

namespace PSS.mgg694.Practica_03
{
    [Serializable]
    public class FueraTableroException : Exception
    {
        public FueraTableroException()
        {
        }

        public FueraTableroException(string message) : base(message)
        {
        }

        public FueraTableroException(string message, Exception innerException) : base(message, innerException)
        {
        }

        protected FueraTableroException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}