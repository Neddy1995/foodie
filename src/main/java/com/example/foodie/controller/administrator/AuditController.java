package com.example.foodie.controller.administrator;

import com.example.foodie.bean.Article;
import com.example.foodie.bean.AuditArticle;
import com.example.foodie.service.AuditService;
import com.example.foodie.util.ControllerResult;
import com.example.foodie.util.SessionKeyValue;
import com.example.foodie.vo.TitleAndPictureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.CompositeName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AuditController {

    @Autowired
    private AuditService auditService;

    /**
     * 查询需要审核的内容
     * @return
     */
    @GetMapping("/selectAuditArticle.do")
    public ControllerResult selectAuditArticle(){
        List<Article> list = auditService.selectAuditArticle();
        return ControllerResult.createSuccess("查询需要审核的内容成功",list);
    }

    /**
     * 查询该管理员已审核的内容
     * @param request
     * @return
     */
    @GetMapping("/selectPassArticle.do")
    public ControllerResult selectPassArticle(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Article> list = auditService.selectPassArticle((String)session.getAttribute(SessionKeyValue.USER_ID));
        return ControllerResult.createSuccess("查询该管理员已审核内容成功",list);
    }

    /**
     * 提交审核
     * @param request
     * @param articleId
     * @param state
     * @return
     */
    @PostMapping("/insertAuditArticle.do")
    public ControllerResult insertAuditArticle(HttpServletRequest request,
                                               @RequestParam String articleId,
                                               @RequestParam String state){
        HttpSession session = request.getSession();
        AuditArticle auditArticle = new AuditArticle();
        auditArticle.setUserId((String) session.getAttribute(SessionKeyValue.USER_ID));
        auditArticle.setArticleId(articleId);
        auditService.insertAuditArticle(auditArticle,state);
        return ControllerResult.createSuccess("审核成功");
    }


}
