package com.eureka.client.eurekaclient.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eureka.client.eurekaclient.utils.JdbcUtils;
import com.eureka.client.eurekaclient.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@RestController
public class demoController {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @RequestMapping("/getDataByID")
    public JSONObject getDataByID(@RequestParam String id){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String name = "";
        String age = "";
        String tableid = "";
        JSONObject json = new JSONObject();
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("state","0");
        try{
            conn = JdbcUtils.getConnection();
            id = StringUtils.isEmpty(id) ? "1":SecurityUtils.getPara(id);
            String sql = "select id,name,age from t_users where id= '"+id+"' and state='1'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                jsonResult.put("state","1");
                name = rs.getString("name");
                age = rs.getString("age");
                tableid = rs.getString("id");
                json = appendJson(name,age,tableid);
            }
            jsonResult.put("data",json);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return jsonResult;
    }

    @RequestMapping("/getData")
    public JSONObject getData(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String name = "";
        String age = "";
        String id = "";
        String result = "未查询到数据";
        JSONObject json = new JSONObject();
        JSONObject jsonReslut = new JSONObject();
        JSONArray jarry = new JSONArray();
        jsonReslut.put("state","0");
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select id,name,age from t_users where state='1' order by id desc";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                jsonReslut.put("state","1");
                for(int i=0; i<rs.getRow(); i++){
                    name = rs.getString("name");
                    age = rs.getString("age");
                    id = rs.getString("id");
                    json = appendJson(name,age,id);
                    jarry.add(i,json);
                    rs.next();
                }
            }
            jsonReslut.put("data",jarry);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return jsonReslut;
    }

    /**
     * 根据id逻辑删除用户信息
     * @param id
     * @return
     */
    @RequestMapping("/removeDataByID")
    public JSONObject removeDataByID(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        JSONObject json = new JSONObject();
        json.put("state","0");
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils.getConnection();
            String id = SecurityUtils.getPara(request, "id");
            String sql = "update t_users set state='0' where id= '"+id+"' and state='1'";
            st = conn.createStatement();
            int num = st.executeUpdate(sql);
            if(num>0){
                json.put("state","1");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return json;
    }

    /**
     * 新增一条用户信息
     * @param request
     * @return
     */
    @RequestMapping("/insertData")
    public JSONObject insertData(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        JSONObject json = new JSONObject();
        json.put("state","0");
        String name = SecurityUtils.getPara(request,"name");
        String age = SecurityUtils.getPara(request,"age");
        if(!checkMessage(name, age)){
            json.put("error","[姓名]或[年龄]信息不完整。");
        }
        String sql = "insert into t_users (name,age) value ('"+name+"','"+age+"')";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            int num = st.executeUpdate(sql);
            if(num>0){
                json.put("state","1");
                json.put("error","新增成功。");
            }else{
                json.put("error","新增失败。");
            }
        }catch (Exception e) {
            e.printStackTrace();
            json.put("error","新增失败。");
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return json;
    }

    /**
     * 根据id修改用户信息
     * @param id
     * @return
     */
    @RequestMapping("/updateDataByID")
    public JSONObject updateDataByID(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        JSONObject json = new JSONObject();
        json.put("state","0");
        try{
            conn = JdbcUtils.getConnection();
            String id = SecurityUtils.getPara(request, "id");
            String age = SecurityUtils.getPara(request, "age");
            String name = SecurityUtils.getPara(request, "name");
            if(StringUtils.isEmpty(age) || StringUtils.isEmpty(name)){
                json.put("error", "[年龄]或[姓名]为空");
            }
            String sql = "update t_users set age='"+age+"',name='"+name+"' where id= '"+id+"' and state='1'";
            st = conn.createStatement();
            int num = st.executeUpdate(sql);
            if(num>0){
                json.put("state","1");
                json.put("error", "修改成功");
            }else{
                json.put("error", "修改失败");
            }
        }catch (Exception e) {
            json.put("error", "修改失败");
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return json;
    }

    public boolean checkMessage(String name, String age){
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(age)){
            return false;
        }else{
            return true;
        }
    }

    public JSONObject appendJson(String name, String age, String id){
        JSONObject json = new JSONObject();
        json.put("name",name);
        json.put("age",age);
        json.put("id",id);
        return json;
    }

}
