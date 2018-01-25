package controllers;

import models.User;

import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import views.html.createUser;
import views.html.index;
import javax.inject.Inject;
import java.util.Date;

import static play.data.Form.form;

public class UserController extends Controller {

    private static Result GO_HOME = redirect(routes.HomeController.index());
    private Date today = new Date();

    public UserController() {}

    public Result index() {
        return ok(index.render("Los usuarios"));
    }

    public Result getUsers() {
        User user = new User("juan", "purata", 32, "mex", "admin");
        return GO_HOME;
    }

    public static Result createUser() {
        Form<User> newUser = form(User.class);
        return ok(createUser.render(newUser));
    }

    public Result deleteUser() {
        return GO_HOME;
    }
}
