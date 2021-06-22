package com.example.relationaldataaccess.Controller;

import com.example.relationaldataaccess.DAO.TesttableDAO;
import com.example.relationaldataaccess.tableclass.Testtable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RDAController {

    @Autowired
    private TesttableDAO dao ;

    @GetMapping("/getList")
    public List<Testtable> getList(){
        List<Testtable> testtableList = dao.list();
        System.out.println("COUNT" + testtableList.size());
        return testtableList;
    }

    @RequestMapping(value = "/postQues", method = RequestMethod.POST)
    public  String save(@RequestBody Testtable testtable){
        dao.save(testtable);
        return  "successfully inserted";
    }

    @RequestMapping(value = "/updateQues", method = RequestMethod.POST)
    public String update(@RequestBody Testtable testtable){
        dao.update(testtable);
        return "successfully updated";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        dao.delete(id);
        return "successfully Deleted";
    }
}
