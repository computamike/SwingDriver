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

        [Test]
        public void canGetCheckboxStatus()
        {
            ServiceReference1.RemoteControlServiceClient rc = new ServiceReference1.RemoteControlServiceClient();
            rc.ClientCredentials.UserName.UserName = "admin";
            rc.ClientCredentials.UserName.Password = "password";

            var s = rc.GetControl("MainForm", "jCheckBox1");
            Console.WriteLine("CHECK BOX = " + s.@checked.ToString());
            
        }

        [Test]
        public void canSetCheckboxStatus()
        {
            ServiceReference1.RemoteControlServiceClient rc = new ServiceReference1.RemoteControlServiceClient();
            rc.ClientCredentials.UserName.UserName = "admin";
            rc.ClientCredentials.UserName.Password = "password";

           Boolean IsChecked =  !rc.GetControl("MainForm", "jCheckBox1").@checked;
           rc.SetControl("MainForm", "jCheckBox1", IsChecked.ToString());
        }

        [Test]
        public void canGetTextField()
        {
            ServiceReference1.RemoteControlServiceClient rc = new ServiceReference1.RemoteControlServiceClient();
            rc.ClientCredentials.UserName.UserName = "admin";
            rc.ClientCredentials.UserName.Password = "password";

           var IsChecked = rc.GetControl("MainForm", "jTextField1").text;
           Console.WriteLine(IsChecked);
        }
        
        [Test]
        public void canSetTextField()
        {
            ServiceReference1.RemoteControlServiceClient rc = new ServiceReference1.RemoteControlServiceClient();
            rc.ClientCredentials.UserName.UserName = "admin";
            rc.ClientCredentials.UserName.Password = "password";
            rc.SetControl("MainForm", "jTextField1","Mike");
        }

        [Test]
        public void canGetButton()
        {
            ServiceReference1.RemoteControlServiceClient rc = new ServiceReference1.RemoteControlServiceClient();
            rc.ClientCredentials.UserName.UserName = "admin";
            rc.ClientCredentials.UserName.Password = "password";

            var IsChecked = rc.GetControl("MainForm", "jButton1");
            Console.WriteLine(IsChecked.text);
        }

        [Test]
        public void canPressButton()
        {
            ServiceReference1.RemoteControlServiceClient rc = new ServiceReference1.RemoteControlServiceClient();
            rc.ClientCredentials.UserName.UserName = "admin";
            rc.ClientCredentials.UserName.Password = "password";
            rc.ClickButton("MainForm", "jButton1");
        }

        [Test]
        public void canGetTextArea()
        {
            ServiceReference1.RemoteControlServiceClient rc = new ServiceReference1.RemoteControlServiceClient();
            rc.ClientCredentials.UserName.UserName = "admin";
            rc.ClientCredentials.UserName.Password = "password";

            var IsChecked = rc.GetControl("MainForm", "jTextArea1").text;
            Console.WriteLine(IsChecked);
        }
        [Test]
        public void canSetTextArea()
        {
            ServiceReference1.RemoteControlServiceClient rc = new ServiceReference1.RemoteControlServiceClient();
            rc.ClientCredentials.UserName.UserName = "admin";
            rc.ClientCredentials.UserName.Password = "password";
            rc.SetControl("MainForm", "jTextArea1","THIS TEXT AREA HAS BEEN UPDATED BY A SCRIPT");
        }

    }
}
