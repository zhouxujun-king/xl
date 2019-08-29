package com.zlzl.estate.util;

import com.zlzl.estate.model.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by sang on 2017/12/30.
 */
public class AdminUtils {
    public static Admin getCurrentHr() {
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
