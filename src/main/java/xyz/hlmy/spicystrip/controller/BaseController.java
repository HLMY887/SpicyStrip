package xyz.hlmy.spicystrip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制类基类
 */
@RestController
public abstract class BaseController {

    protected final static Logger log = LoggerFactory.getLogger(BaseController.class);

}
