using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace Java_Remote_Controller
{
   public  class Class1 : ApiController
    {
       public string ReturnHelloWorld()
       {
           return "Hello World (From .NET)";
       }
    }
}
