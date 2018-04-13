package top.minecode.web.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.domain.tag.TagResult;
import top.minecode.domain.user.User;
import top.minecode.json.JsonConfig;
import top.minecode.json.task.SwitchPicResponse;
import top.minecode.service.taskexecute.TagService;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Controller
@RequestMapping("/tag")
public class TagController extends BaseController {

    private TagService tagService;

    public TagService getTagService() {
        return tagService;
    }

    @Autowired
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping("/save")
    @ResponseBody
    public void save(HttpServletRequest request, int taskId, String url, String data) {
        TagResult tagResult = JsonConfig.getGson().fromJson(data, TagResult.class);
        User user = getSessionUser(request);
        tagService.saveTag(taskId, user, url, tagResult);
    }

    @RequestMapping("/next")
    @ResponseBody
    public String next(HttpServletRequest request, int taskId, String url) {
        String nextUrl = tagService.getNextPic(taskId, url);
        SwitchPicResponse switchPicResponse = new SwitchPicResponse();
        switchPicResponse.setUrl(nextUrl);
        if (nextUrl == null)
            switchPicResponse.setDescription(SwitchPicResponse.NO_MORE);
        return JsonConfig.getGson().toJson(switchPicResponse);
    }

    @RequestMapping("/getLabelInfo")
    @ResponseBody
    public String getLabelInformation(HttpServletRequest request, int taskId, String picURL) {
        User user = getSessionUser(request);
        TagResult tagResult = tagService.getTagResult(taskId, user, picURL);
        return JsonConfig.getGson().toJson(tagResult);
    }

    @RequestMapping("/previous")
    @ResponseBody
    public String previous(HttpServletRequest request, int taskId, String url) {
        String prevUrl = tagService.getPreviousPic(taskId, url);
        SwitchPicResponse switchPicResponse = new SwitchPicResponse();
        switchPicResponse.setUrl(prevUrl);
        if (prevUrl == null)
            switchPicResponse.setDescription(SwitchPicResponse.NO_MORE);
        return JsonConfig.getGson().toJson(switchPicResponse);
    }

    @RequestMapping("/taskInfo")
    @ResponseBody
    public String getTaskInformation(HttpServletRequest request, int taskId) {
        return tagService.getTaskInfo(taskId);
    }
}
