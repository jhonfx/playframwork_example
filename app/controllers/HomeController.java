package controllers;

import models.Blogpost;
import play.db.Database;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

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

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    private Database db;



    public HomeController(Database db) {
        this.db = db;
    }

    public Result index() {

        return ok(index.render("Your new application is ready."));
    }

    public Result getBlogpost() throws SQLException {
        String searchPost = request().getQueryString("blog");

        Connection conn = db.getConnection();

        String sqlQuery = "Select * from post_table";
        PreparedStatement getAnElementRow = conn.prepareStatement(sqlQuery);

        //String queryParameter = String.format("%%%s%%", searchPost.toLowerCase());
        //getAnElementRow.setString(1, queryParameter);
        ResultSet theElementSet = getAnElementRow.executeQuery();

        Blogpost blogp = (theElementSet.next()) ? mapToElement(theElementSet) : new Blogpost("", "","");
        return ok(Json.toJson(blogp));
    }

    private Blogpost mapToElement(ResultSet theElementSet) throws SQLException {
        String title = theElementSet.getString("TITLE");
        String comment = theElementSet.getString("COMMENT");
        String autor = theElementSet.getString("AUTOR");
        return new Blogpost(title, comment, autor);
    }

    public Result getFamily() {
        String parameter = request().getQueryString("name");
        Map<String, String> family = new HashMap<>();
        family.put("Ximena Purata", "Son");
        family.put("Maleni Peña", "Wife");
        family.put("Pelusa", "Pet");
        return ok(Json.toJson(family));
    }


}
