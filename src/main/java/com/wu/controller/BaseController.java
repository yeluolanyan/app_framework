package com.wu.controller;

import com.wu.common.utils.UserHolder;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by lwh on 2016/5/11.
 */
public class BaseController {

    protected String base = "";
    protected String serverName = "";
    @ModelAttribute
    public void initPath(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        base = request.getContextPath();

        String fullPath = request.getScheme()+"://"+request.getServerName()+base;
        model.addAttribute("userId", UserHolder.getUserId());
        model.addAttribute("base", base);
        model.addAttribute("fullPath", fullPath);
        serverName = request.getServerName()+":"+request.getServerPort();
        model.addAttribute("serverName", serverName);
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        DateFormat df = new MyDateFormat();
        CustomDateEditor editor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    public static class MyDateFormat extends DateFormat {

        private static final List<? extends DateFormat> DATE_FORMATS = Arrays.asList(
                new SimpleDateFormat("yyyy-MM-dd"),
                new SimpleDateFormat("MM/dd/yyyy"));//easyui easyui-datebox 默认时间格式

        @Override
        public StringBuffer format(final Date date, final StringBuffer toAppendTo, final FieldPosition fieldPosition) {
            throw new UnsupportedOperationException("This custom date formatter can only be used to *parse* Dates.");
        }

        @Override
        public Date parse(final String source, final ParsePosition pos) {
            Date res;
            for (final DateFormat dateFormat : DATE_FORMATS) {
                if ((res = dateFormat.parse(source, pos)) != null) {
                    return res;
                }
            }

            return null;
        }
    }


}
