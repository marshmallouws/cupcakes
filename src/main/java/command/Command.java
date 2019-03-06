package command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caspe
 */
public abstract class Command {
    
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    public static Command from(HttpServletRequest request)
    {
        Command c;
        
        String origin = request.getParameter("command");
        
        Map<String, Command> commands = new HashMap();
        commands.put("userlogin", new CommandUserLogin());

        c = commands.getOrDefault(origin, new CommandUnknown());
        
        return c;
    }
}
