package org.idsit.coursspring.service;


import org.idsit.coursspring.model.Module;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ModuleService {


    private List<Module> modulesList = new ArrayList<Module>(
            Arrays.asList(new Module(1, "La plateforme Java Standard Edition", "Description de la plateforme Java SE"),
                    new Module (2, "La plateforme Java Enterprise Edition", "Description de la plateforme Java EE"))
    );



    public List<Module> getModules(){
        return modulesList;
    }

    public Module getModule(Integer id) {
        if (id == null) {
            return null;
        }
        if (id.compareTo(modulesList.size())>0){
            return null;
        }
        return modulesList.get(id-1);
    }

    public void addModule(Module md){
        modulesList.add(md);
    }

    public void modifyModule(Module module, Integer id) {
        if (id == null || module==null) {
            return;
        }
        if (id.compareTo(modulesList.size())>0) {
            return;
        }
        modulesList.set(id-1,module);
    }

    public void deleteModule(Integer id) {

        if (id == null || id.compareTo(modulesList.size())>0) {
            return;
        }
        modulesList.remove(id-1);
    }
}
