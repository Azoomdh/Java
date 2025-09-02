package com.example.demoJava4.VatPham;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demoJava4.Interface.ControllerInterface;

@Controller
public class VatPhamController 
    implements ControllerInterface<VatPham, Long>
{
    @Autowired
    private VatPhamService vatPhamService;

    @Override
    @GetMapping("/get/vatpham/{tKey}")
    public String findById
    (
        @PathVariable(value = "tKey", defaultValue="0") Long tKey
    )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getList(Integer sttPage, Integer sizePage) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String create(VatPham t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String update(Long tKey, VatPham t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String delete(Long tKey) {
        // TODO Auto-generated method stub
        return null;
    }

    

    
}
