package com.emt.utils;

import com.emt.enums.ResultEnum;
import com.emt.model.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ResultUtil {
    public static Result sucess(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setData(object);
        result.setMsg("sucess");
        return result;
    }

    public static Result sucess() {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("sucess");
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    public static Map<String, Object> datatable(List<?> data, Integer num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", data);
        map.put("recordsTotal", num);
        map.put("recordsFiltered", num);
        return map;
    }


}