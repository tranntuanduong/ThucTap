package com.jun;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.jun.service.ICompanyService;
import com.jun.service.IVehicleService;
import com.jun.service.impl.CompanyService;
import com.jun.service.impl.VehicleService;
import com.jun.shareData.ShareData;
import com.jun.utils.ExcelReader;
import com.jun.utils.ThreadCheckNewFile;
import com.jun.utils.ThreadWriteData;

public class App {
    public static void main(String[] args) throws Exception {
    	ShareData shareData = new ShareData();
		IVehicleService vehicleService = new VehicleService();
		ICompanyService companyService = new CompanyService();
		ExcelReader excelReader = new ExcelReader();
    	ThreadCheckNewFile threadCheckNewFile = new ThreadCheckNewFile(shareData);
		ThreadWriteData threadWriteData = new ThreadWriteData(shareData, vehicleService, companyService,
				excelReader);

		threadCheckNewFile.start();
		threadWriteData.start();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);

        
        ServletHolder jerseyServlet = context.addServlet(
             org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
      
        //load class
//        jerseyServlet.setInitParameter(
//                "jersey.config.server.provider.classnames",
//                CompanyAPI.class.getCanonicalName());
        
        
        //load packages
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.packages",
                "com.jun.api");
        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}
