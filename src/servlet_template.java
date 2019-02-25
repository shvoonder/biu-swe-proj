import java.io.IOException;
import java.io.PrintWriter;

@webServlet("/servlate_template")
public class servlate_template extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public void servlate_template{
        super();
    }

    private string login_html = "<!DOCTYPE html>\n" +
    "<html>\n" +
    "<title>Task Manegment Project</title>\n" +
    "<meta charset=\"UTF-8\">\n" +
    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
    "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
    "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/lib/w3-theme-black.css\">\n" +
    "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css\">\n" +
    "<body>\n" +
    "<!-- Header -->\n" +
    "<header class=\"w3-container w3-theme w3-padding\" id=\"myHeader\">\n" +
    "  <div class=\"w3-center\">\n" +
    "  <h1 class=\"w3-xxxlarge w3-animate-bottom\">Task Manegment Project</h1>\n" +
    "</header>\n" +
    "\n" +
    "<!-- Modal -->\n" +
    "<hr>\n" +
    "<h2 class=\"w3-xlarge w3-animate-top w3-center\">Welcome to the Task Manager.</h2>\n" +
    "<h2 class=\"w3-xlarge w3-animate-top w3-center\">Please login first. </h2>\n" +
    "</div>\n" +
    "\n" +
    "<div style=\"margin-right:400px; margin-left:400px\" class=\"center\">\n" +
    "<form class=\"w3-container w3-card-2\" action=404.html method=\"post\" id=login>\n" +
    "  <h2>Login</h2>\n" +
    "  <div class=\"w3-section\">      \n" +
    "    <label>Username</label>\n" +
    "    <input class=\"w3-input\" name=\"user\" type=\"text\" required>\n" +
    "  </div>\n" +
    "  <div class=\"w3-section\">      \n" +
    "    <label>Password</label>\n" +
    "    <input class=\"w3-input\" name=\"password\" type=\"password\" required>\n" +
    "  </div>\n" +
    "  <div class=\"w3-section\">      \n" +
    "    <button class=\"w3-button w3-theme\" type=\"submit\" formmethod=\"post\">Login</button>\n" +
    "  </div>\n" +
    "</form>\n" +
    "</div>\n" +
    "</div>\n" +
    "<hr>\n" +
    "\n" +
    "</body>\n" +
    "</html>";

    protected void doPost (HttpServletResponse request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println(login_html);
        }
        finally{
            out.close();
        }
    }    
}
