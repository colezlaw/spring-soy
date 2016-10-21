package us.cltnc.spring;

import java.util.Collection;

import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.google.common.io.Resources;
import com.google.template.soy.SoyFileSet;
import com.google.template.soy.tofu.SoyTofu;

public class SoyTemplateResolver extends UrlBasedViewResolver {

    private SoyTofu tofu;
    
    public SoyTemplateResolver() {}
    
    public void setTemplateUris(Collection<String> uris) {
        super.setViewClass(SoyView.class);
        SoyFileSet.Builder builder = SoyFileSet.builder();
        for (String uri : uris) {
            builder.add(Resources.getResource(uri));
        }
        tofu = builder.build().compileToTofu();
    }
    
    @Override
    protected SoyView buildView(String viewName) throws Exception {
        SoyView view = new SoyView(tofu.newRenderer(viewName));
        
        return view;
    }

    @Override
    protected Class<?> requiredViewClass() {
        return SoyView.class;
    }
    
}
