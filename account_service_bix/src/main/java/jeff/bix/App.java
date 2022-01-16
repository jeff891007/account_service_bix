package jeff.bix;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        startH2Server();
        SpringApplication.run(App.class, args);
    }


    private static void startH2Server() {
        try {
            Server h2Server = Server.createWebServer("-trace","-ifNotExists").start();
            if(h2Server.isRunning(true)) {
                System.out.println("h2 server started!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
