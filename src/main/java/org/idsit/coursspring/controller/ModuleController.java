package org.idsit.coursspring.controller;


import org.idsit.coursspring.model.Module;
import org.idsit.coursspring.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;
    @GetMapping
    public List<Module> getModules(){
        return moduleService.getModules();
    }

    @GetMapping("/{id}")
    public Module getModule(@PathVariable Integer id){
        return moduleService.getModule(id);
    }

    @PostMapping
    public void addModule(@RequestBody Module module){
        moduleService.addModule(module);
    }

    @PutMapping("/{id}")
    public void modifyModule(@RequestBody Module module,@PathVariable Integer id){
        moduleService.modifyModule(module,id);
    }

    @DeleteMapping("/{id}")
    public void deleteModule(@PathVariable Integer id){
        moduleService.deleteModule(id);
    }

}
