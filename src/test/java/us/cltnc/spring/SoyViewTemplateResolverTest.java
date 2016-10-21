package us.cltnc.spring;

import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import com.google.common.collect.ImmutableMap;

public class SoyViewTemplateResolverTest {
    @Test
    public void testSoyTemplateViewResolver() throws Exception {
        SoyTemplateResolver resolver = new SoyTemplateResolver();
        resolver.setTemplateUris(Arrays.asList("simple.soy"));
        HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
        PrintWriter out = new PrintWriter(System.out);
        Mockito.when(res.getWriter()).thenReturn(out);
        SoyView view = resolver.buildView("examples.simple.helloWorld");
        view.render(ImmutableMap.<String, Object>of(), req, res);
        out.flush();
    }
}
