# spring-soy

This is a simple `ViewResolver` implementation for Spring MVC which uses
[Closure Templates][1] for rendering.

## Example

    @SpringBootApplication
    @EnableWebMvc
    public class DemoApplication {

        @Bean public ViewResolver viewResolver() {
            SoyTemplateResolver resovler = new SoyTemplateResolver();
            resolver.setTemplateUris(Arrays.asList("simple.soy"));
            return resolver;
        }

        ..
    }

    @Controller
    class HelloController {
        @RequestMapping("/hello/{name}")
        public ModelAndView (@PathVariable("name") String name) {
            Map<String, Object> model = new HashMap<>();
            model.put("name", name);
            return new ModelAndView("examples.simple.helloWorld", model);
        }
    }

[1]: https://developers.google.com/closure/templates/
