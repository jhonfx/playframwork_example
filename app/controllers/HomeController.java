package controllers;

import models.Blogpost;
import play.db.Database;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

  
    public Result index() {
        return ok(views.html.posts.render());
    }

    public Result getFamily() {
        Map<String, String> family = new HashMap<>();
        family.put("Ximena Purata", "Son");
        family.put("Maleni Peña", "Wife");
        family.put("Pelusa", "Pet");
        return ok(Json.toJson(family));
    }


}
