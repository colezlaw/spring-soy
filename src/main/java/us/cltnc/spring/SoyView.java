package us.cltnc.spring;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractUrlBasedView;

import com.google.template.soy.tofu.SoyTofu;

public class SoyView extends AbstractUrlBasedView {

    private SoyTofu.Renderer renderer;
    
    public SoyView(SoyTofu.Renderer renderer) {
        this.renderer = renderer;
    }
    
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String result = renderer.setData(model).render();
        response.getWriter().print(result);
    }

    @Override
    protected boolean isUrlRequired() {
        return false;
    }

}
