using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
namespace Java_Remote_Controller
{
    [TestFixture]
    public class RemoteControlUnitTest
    {
        [Category("Integration")]
        [Test ]
        public void canSetComboBox()
        {
            ServiceReference1.RemoteControlServiceClient rc = new ServiceReference1.RemoteControlServiceClient();
            rc.ClientCredentials.UserName.UserName = "admin";
            rc.ClientCredentials.UserName.Password = "password";

            var s = rc.GetControl("MainForm", "jComboBox1");
            rc.SetControl("MainForm", "jComboBox1", "Oranges");
            var s2 = rc.GetControl("MainForm", "jComboBox1");

            Assert.AreNotEqual(s.text, s2.text);
            Assert.AreEqual(s2.text,"Oranges");
            rc.SetControl("MainForm", "jComboBox1", s.text);


        }
        [Category("Integration")]
        [Test]
        public void canGetAllValuesForAComboBox()
        {
            ServiceReference1.RemoteControlServiceClient rc = new ServiceReference1.RemoteControlServiceClient();
            rc.ClientCredentials.UserName.UserName = "admin";
            rc.ClientCredentials.UserName.Password = "password";

            var s = rc.GetControl("MainForm", "jComboBox1");
            Assert.AreNotEqual(s.values, 0);
            Console.WriteLine(s.values );
          


        }

    }
}
