package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import models.Blogpost;
import play.db.Database;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

public class PostController extends Controller {
	
	private Database db;
	private static Result GO_HOME = redirect(routes.HomeController.index());
	@Inject
	public PostController(Database db) {
		this.db = db;
	}
	
	public Result getPosts() throws SQLException {

        Connection conn = db.getConnection();
        String sqlQuery = "Select * from post_table";
        PreparedStatement getAnElementRow = conn.prepareStatement(sqlQuery);

        //String queryParameter = String.format("%%%s%%", searchPost.toLowerCase());
        //getAnElementRow.setString(1, queryParameter);
        ResultSet theElementSet = getAnElementRow.executeQuery();

        Blogpost blogp = (theElementSet.next()) ? mapToElement(theElementSet) : new Blogpost("", "","");
        return ok(Json.toJson(blogp));
    }

    public Result createPost() {
	    return GO_HOME;
    }

    public Result deletePost() {
	    return GO_HOME;
    }

    private Blogpost mapToElement(ResultSet theElementSet) throws SQLException {
        String title = theElementSet.getString("TITLE");
        String comment = theElementSet.getString("COMMENT");
        String autor = theElementSet.getString("AUTOR");
        return new Blogpost(title, comment, autor);
    }
	
}
