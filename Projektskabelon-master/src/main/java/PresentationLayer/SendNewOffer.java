package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.Economy;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendNewOffer extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //todo read order from aplication scoop, call a method from FunctionLayer that will send it further to
        // OrderMapper and sæt Order on aplicationScoop as null


        double saleprice = Double.parseDouble(request.getParameter("saleprice"));
        System.out.println("SalePrice read from prepareOffer.jsp: "+saleprice);
        double coverage = Double.parseDouble(request.getParameter("coverage"));
        System.out.println("Coverage read from prepareOffer.jsp: "+coverage);


        Order order = (Order) request.getServletContext().getAttribute("orderForValidation");
        Construction construction = order.getConstruction();

        if (request.getParameter("byPrice")!=null){
            order.setSalePrice(saleprice);
            order.setCoverage(Economy.setCoverage(order));
        }

        if (request.getParameter("byCoverage")!=null){
            order.setCoverage(coverage);
            order.setSalePrice(Economy.ordersSalePrice(order));
        }

        LogicFacade.sendOffer(order);

        request.setAttribute("orderMSG","Tilbud er blevet sendt til "+ order.getEmail()+"" +
                "Salgspris: "+ order.getSalePrice()+", dækningsgrad: "+order.getCoverage());
        try {
            LogicFacade.setMaterialsForOrder(order);
        } catch (LoginSampleException e) {
            e.printStackTrace();
            throw new LoginSampleException(e.getMessage());

        }


        request.getServletContext().setAttribute("orderForValidation",null);

        return "employeePage";
    }
}
