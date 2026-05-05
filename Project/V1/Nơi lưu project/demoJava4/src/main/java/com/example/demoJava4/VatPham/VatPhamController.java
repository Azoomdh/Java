package com.example.demoJava4.VatPham;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demoJava4.Interface.ControllerInterface;
import com.example.demoJava4.Utils.ImageUtil;

@Controller
public class VatPhamController 
    implements ControllerInterface<VatPham, VatPhamDto, Long>
{
    @Autowired
    private VatPhamService vatPhamService;

    @GetMapping("/get/vatpham/{id}")
    @Override
    public String findById
    (
        Model model, 
        @PathVariable(value = "id") Long id
    )
    {
        VatPham t = this.vatPhamService.findById(id);
        model.addAttribute("vatpham", t);
        return "VatPham/detail";
    }

    @Override
    public String getList(Model model, Integer sttPage) {
        // TODO Auto-generated method stub
        return null;
    }

    @GetMapping("/create/vatpham")
    @Override
    public String getCreate(Model model) {
        model.addAttribute("vatphamDto", new VatPhamDto());
        return "VatPham/create";
    }

    @PostMapping("/create/vatpham")
    @Override
    public String postCreate(@ModelAttribute VatPhamDto dto) {
        VatPham t = new VatPham(null, dto.getTen(), dto.getGia(), dto.getDonvi(), dto.getMota(), null);

        String urlAnh = ImageUtil.save(dto.getAnh());
        t.setUrlanh(urlAnh);

        t = this.vatPhamService.create(t);

        String url = "redirect:" + "/get/vatpham/"+ t.getId();
        return url;
    }

    @Override
    public String getUpdate(Model model, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String postUpdate(Long id, VatPhamDto dto) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    
}

