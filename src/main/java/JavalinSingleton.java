

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;


/**
 * Background: A json string representing a song will be sent in this POST request with the following fields: 
 *      songName, artistName
 */
public class JavalinSingleton {

    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        ObjectMapper om = new ObjectMapper();
        
        /**
         * problem1: retrieve the song object from the request body...
         *      1. return the song object as JSON in the response body.
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/echo", ctx -> {
          String songString=ctx.body();
            //implement logic here
            Song song = om.readValue(songString, Song.class);

        ctx.json(song);
        });
        return app.post("/changeartisttobeatles", ctx -> {
            String songString=ctx.body();
            Song song = om.readValue(songString, Song.class);
            song.artistName("Beatles");
            ctx.json(song);
        
           
            //implement logic here
               
        });
    }}


  
      

