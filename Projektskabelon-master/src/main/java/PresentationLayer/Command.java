package PresentationLayer;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "redirect", new Redirect() );
        commands.put( "shed", new ShedSizingMia() );
        commands.put( "showRequests", new ShowRequests() );
        commands.put( "makerequest", new MakeRequest() );
        commands.put( "designshed", new DesignShed() );
        commands.put( "designflatroof", new FlatRoof() );
        commands.put( "designpitchedroof", new PitchedRoof() );
        commands.put( "sendrequest", new SendRequest() );
        commands.put( "showdrawing", new ShowDrawing() );
        commands.put( "newrequest", new NewRequest() );
        commands.put( "findmaterial", new FindMaterial() );
        commands.put("FlatRoof", new FlatRoof());
        commands.put("materiale", new Materials());

        commands.put( "shedposition", new ShedPosition() );

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
