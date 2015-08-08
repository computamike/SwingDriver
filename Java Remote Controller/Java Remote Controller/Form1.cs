using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Web.Http;
using System.Web.Http.SelfHost;    

namespace Java_Remote_Controller
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            var config = new HttpSelfHostConfiguration("http://localhost:8080");

            config.Routes.MapHttpRoute("API Default", "api/{controller}/{id}",new { id = RouteParameter.Optional });
            using (HttpSelfHostServer server = new HttpSelfHostServer(config)) 
            {
                server.OpenAsync().Wait();

            }





            rc = new ServiceReference1.RemoteControlServiceClient();
            rc.ClientCredentials.UserName.UserName = "admin";
            rc.ClientCredentials.UserName.Password = "password";
            ws = new WebSocket4Net.WebSocket("ws://localhost:1970/RemoteService/RemoteControl");
            ws.MessageReceived +=ws_MessageReceived;
        }

        void ws_MessageReceived(object sender, WebSocket4Net.MessageReceivedEventArgs e)
        {
            textBox1.Text = textBox1.Text + e.Message + "\n";
        }
        private WebSocket4Net.WebSocket ws;

        private ServiceReference1 .RemoteControlServiceClient rc = new ServiceReference1.RemoteControlServiceClient();
        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
          var s = rc.ScreenShot(@"MainF0tm");
            using (var ms = new System.IO.MemoryStream(s)) {
                pictureBox1.Image = Image.FromStream(ms);
 
            }
            }
            catch (Exception ex)
            {
                
                throw ex;
            }

  
        }

        private void button2_Click(object sender, EventArgs e)
        {
           

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            ws.Send("hello");
          
        }
    }
}
