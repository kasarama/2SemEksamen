package PresentationLayer;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login());
        commands.put( "register", new Register() );
        commands.put( "redirect", new Redirect() );
        commands.put( "designflatroof", new FlatRoof() );
        commands.put( "designpitchedroof", new PitchedRoof() );
        commands.put( "newrequest", new NewRequest() );
        commands.put( "findmaterial", new FindMaterial() );
        commands.put("materiale", new Materials());
        commands.put( "carportbase", new CarportBase() );
        commands.put( "addmaterial", new AddMaterial() );
        commands.put( "overlay", new Overlay() );
        commands.put("drawing", new Drawing());
        commands.put("sendnewrequest", new SendNewRequest());

    }

    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws Exception;

}