import java.util.Map;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args) {
    ProcessBuilder process = new ProcessBuilder();
    Integer port;
    if (process.environment().get("PORT") != null) {
       port = Integer.parseInt(process.environment().get("PORT"));
    } else {
       port = 4567;
    }

    setPort(port);
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");

      request.session(true);
      if (request.session().attribute("newTamagotchi") instanceof Tamagotchi){
        Tamagotchi tamagotchi;
        tamagotchi = request.session().attribute("newTamagotchi");
        tamagotchi.killTamagotchi();
      }

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/gamepage", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/gamepage.vtl");

      Tamagotchi tamagotchi;
      tamagotchi = request.session().attribute("newTamagotchi");

      if (!(request.session().attribute("newTamagotchi") instanceof Tamagotchi) || !(tamagotchi.getAliveStatement())) {
        Tamagotchi newTamagotchi = new Tamagotchi(request.queryParams("tamagochiName"));
        request.session().attribute("newTamagotchi", newTamagotchi);
      }
      model.put("newTamagotchi", request.session().attribute("newTamagotchi"));

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/foodsuccess", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/foodsuccess.vtl");
      model.put("newTamagotchi", request.session().attribute("newTamagotchi"));

      Tamagotchi tamagotchi;
      tamagotchi = request.session().attribute("newTamagotchi");
      tamagotchi.addFood();

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    // post("/activitysuccess", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/activitysuccess.vtl");
    //   model.put("newTamagotchi", request.session().attribute("newTamagotchi"));
    //
    //   Tamagotchi tamagotchi;
    //   tamagotchi = request.session().attribute("newTamagotchi");
    //   tamagotchi.addPlay();
    //
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    // post("/sleepsuccess", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/sleepsuccess.vtl");
    //   model.put("newTamagotchi", request.session().attribute("newTamagotchi"));
    //
    //   Tamagotchi tamagotchi;
    //   tamagotchi = request.session().attribute("newTamagotchi");
    //   tamagotchi.addSleep();
    //
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    post("/confirmation", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/confirmation.vtl");
      model.put("newTamagotchi", request.session().attribute("newTamagotchi"));

      // if (request.queryParams("action").equals("food")){
      //   model.put("action", true);
      // } else if (request.queryParams("action").equals("sleep")) {
      //   model.put("action", false);
      // }

      model.put("action", request.queryParams("action"));



      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }




}
