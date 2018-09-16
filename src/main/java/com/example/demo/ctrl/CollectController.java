package com.example.demo.ctrl;





import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/kafka")
public class CollectController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @ApiOperation(value="添加用户信息", notes = "添加用户信息")
    @GetMapping("/msg")
    public void  send(@RequestParam(value = "message")String message) throws Exception {
        try {

            System.out.println("kafka的消息={}"+ message);
            kafkaTemplate.send("test", "key", message);
            System.out.println("发送kafka成功"+message);
        } catch (Exception e) {
            System.out.println("发送kafka失败="+ e);

        }
    }

}